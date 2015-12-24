package com.bi.jsph.uploa.txns.rw;

import com.bi.jsph.uploa.txns.entities.JsphObj;
import com.bi.jsph.uploa.txns.entities.Txn;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openide.util.Exceptions;

public class Certifier {

    private Map<String, Boolean> usedIp = new HashMap<String, Boolean>();
    private JsphObj o;
    private final static String DARTH = "$_";

    public Certifier() {
    }

    private void displayIP() throws SocketException {

	Enumeration<NetworkInterface> interfaces = NetworkInterface
		.getNetworkInterfaces();
	while (interfaces.hasMoreElements()) {
	    NetworkInterface current = interfaces.nextElement();
	    // System.out.println(current);
	    if (!current.isUp() || current.isLoopback() || current.isVirtual()) {
		continue;
	    }
	    Enumeration<InetAddress> addresses = current.getInetAddresses();
	    int k = 0;
	    while (addresses.hasMoreElements()) {
		InetAddress current_addr = addresses.nextElement();
		if (current_addr.isLoopbackAddress()) {
		    continue;
		}
		System.out.println(k + ")" + current_addr.getHostAddress());
		usedIp.put(current_addr.getHostAddress(), true);
	    }
	}


    }

    public final Map<Date, BusinessClass> proceed(InputStream in) throws Exception {
	Map<Date, Double> allowance = new HashMap<Date, Double>();
	RXW rxw = new RXW();
	o = rxw.load(in);
	ArrayList<Txn> listTxn = o.getTxns();
	String ip = null;
	for (Iterator iterator = listTxn.iterator(); iterator.hasNext();) {
	    Txn txn = (Txn) iterator.next();
	    ip = txn.getUserIp();
	    Date paymentDate = extractDate(txn.getUserTxn());
	    // 12,55�
	    String amounbStr = txn.getTxnAmount();
	    Double dAmt = extractAmount(amounbStr);
	    if (paymentDate != null) {
		allowance.put(paymentDate, dAmt);
	    }

	    if (usedIp.get(ip) != null) {
		break;
	    }
	}
	return allow(o, allowance, ip);

    }

    private Date extractDate(String lastConnected) throws ParseException {
	Date cnxDate = null;
	Pattern p = Pattern.compile("\\d+/\\d+/\\d+");

	Matcher mLastCnx = p.matcher(lastConnected);
	if (mLastCnx.matches()) {

	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    cnxDate = sdf.parse(lastConnected);

	}
	return cnxDate;
    }

    private Double extractAmount(String amounbStr) {
	Pattern pAmountPattern = Pattern.compile("((\\d+)[,\\.](\\d+)[�])");
	Double dAmt = null;
	Matcher matcherAmount = pAmountPattern.matcher(amounbStr);
	if (matcherAmount.find()) {
	    int count = matcherAmount.groupCount();
	    if (count >= 2) {
		dAmt = Double.valueOf(matcherAmount.group(2) + "."
			+ matcherAmount.group(3));
	    } else {
		dAmt = new Double(0);
	    }
	}
	return dAmt;
    }

    private Map<Date, BusinessClass> allow(JsphObj ojsph,
	    Map<Date, Double> allowance, String ip) throws ParseException, IOException {
	Map<Date, BusinessClass> endDates = new HashMap<Date, BusinessClass>();
	Double montantPourUneAffaire = Double.valueOf(ojsph.getAmount1Affair());
	Logger.getLogger("JSPH  montantPourUneAffaire " + montantPourUneAffaire);
	Double montantPourNAffaire = Double.valueOf(ojsph.getAmountnAffair());
	Logger.getLogger("JSPH  montantPourNAffaire " + montantPourNAffaire);
	Date now = extractDate(ojsph.getNow());
	Date computerNow = new Date();
	boolean safeComputer = compare(now, computerNow);
	if (safeComputer) {
	    // 1 mois = 30 jour*24 heures*60 minutes*60 seconds*1000 mili
	    long nbMounthAllowed1Affaire = 0;
	    long nbMounthAllowedNAffaire = 0;
	    for (Iterator iterator = allowance.entrySet().iterator(); iterator
		    .hasNext();) {
		Map.Entry<Date, Double> entry = (Map.Entry<Date, Double>) iterator
			.next();
		Date start = entry.getKey();
		Double amount = entry.getValue();
		Preferences prefs = Preferences.userRoot().node(ip);
		long millis = prefs.getLong(DARTH, 0);
		if (millis == 0) {
		    millis = System.currentTimeMillis();
		    prefs.putLong(DARTH, millis);
		}

		if (amount == null || amount == 0) {

		    Calendar c = Calendar.getInstance();
		    c.setTimeInMillis(millis);
		    c.add(Calendar.DAY_OF_YEAR, 10);
		    if (computerNow.after(c.getTime())) {
			//endDates.clear();
			endDates.put(c.getTime(), BusinessClass.OUTOFDATE);
		    } else {

			endDates.put(c.getTime(), BusinessClass.ESSAY);
		    }

		} else {
		    if (montantPourUneAffaire > 0 && montantPourNAffaire > 0) {
			nbMounthAllowed1Affaire = Math.round(amount
				/ montantPourUneAffaire);
			nbMounthAllowedNAffaire = Math.round(amount
				/ montantPourNAffaire);

			Calendar c = Calendar.getInstance();
			c.setTime(start);
			c.add(Calendar.MONTH, (int) nbMounthAllowed1Affaire);
			// ----------------
			Calendar c1 = Calendar.getInstance();
			c1.setTime(start);
			c1.add(Calendar.MONTH, (int) nbMounthAllowedNAffaire);
			// ----------------
			Date endDate1 = c.getTime();

			if (endDate1.after(now)) {
			    endDates.put(endDate1, new BusinessClass(amount,
				    "A"));
			}
			Date endDateN = c1.getTime();
			if (endDateN.after(now)) {
			    endDates.put(endDateN, new BusinessClass(amount,
				    "B"));
			}
		    } else {
			Calendar c = Calendar.getInstance();
			c.setTime(start);
			c.add(Calendar.DAY_OF_YEAR, 10);
			endDates.put(start, BusinessClass.ESSAY);
		    }
		}
	    }

	} else {
	    // send the ip adress to ban it
	    try {
		URL url = new URL(ojsph.getUpdateUrl() + "?success=" + ip);
		URLConnection cnx = url.openConnection();
		cnx.getContent();
	    } catch (Throwable e) {
		Exceptions.printStackTrace(e);
	    }



	}
	// intersection des payments
	return endDates;
    }

    private boolean compare(Date now, Date computerNow) {
	SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
	String s1 = sd.format(now);
	String s2 = sd.format(computerNow);
	return s2.compareToIgnoreCase(s1) == 0;

    }

    public String getUpdateUrl() {
	if (o == null) {
	    return null;
	}
	return o.getUpdateUrl();
    }

    public String getBackupUrl() {
	if (o == null) {
	    return null;
	}
	return o.getBackupUrl();
    }

    public ArrayList<Txn> getTxns() {
	if (o == null) {
	    return null;
	}
	return o.getTxns();
    }

    public String getAmountFisko() {
	if (o == null) {
	    return null;
	}
	return o.getAmountFisko();
    }

    public String getAmount1Affair() {
	if (o == null) {
	    return null;
	}
	return o.getAmount1Affair();
    }

    public String getAmountnAffair() {
	if (o == null) {
	    return null;
	}
	return o.getAmountnAffair();
    }

    public String getNow() {
	if (o == null) {
	    return null;
	}
	return o.getNow();
    }
}
