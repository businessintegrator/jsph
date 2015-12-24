/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jsph.http;

import com.bi.jsph.uploa.txns.rw.BusinessClass;
import com.bi.jsph.uploa.txns.rw.Certifier;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class Client {

    static final Logger logger = Logger.getLogger("Client");
    private final static boolean DEBUG = true;
    private final static String SITE = System.setProperty("tiaray.rafaralahitsimba", "fr");
    private final static String CANCELLED = System.setProperty(".cancelled", "");
    private final static String PAYED = System.setProperty(".paied", "");
    private final static String PAYPAL = System.setProperty(".paied", "");

    static {
	System.setProperty("user.language", "fr");

    }
    private Map<Date, BusinessClass> listAllowance;
    private Certifier cert;
    private final static String PERSONNAL = "2020697845f456";

    public String getBuyUrl() {
	return getUpdateUrl();
    }

    public Client() {
    }

    public boolean doservice(HttpClient client, String domain,
	    String mail, String password, PostMethod method, String emailkey,
	    String passwordkey, String queryString, String realm) throws HttpException, IOException, Exception {
	load();
	return true;
    }

    public Map<Date, BusinessClass> getListAllowance() {
	return listAllowance;
    }

    public String getUpdateUrl() {
	if (cert == null) {
	    return null;
	}
	return cert.getUpdateUrl();
    }

    public String getBackupUrl() {
	if (cert == null) {
	    return null;
	}
	return cert.getBackupUrl();
    }

    public String getAmountFisko() {
	if (cert == null) {
	    return null;
	}
	return cert.getAmountFisko();
    }

    public String getAmount1Affair() {
	if (cert == null) {
	    return null;
	}
	return cert.getAmount1Affair();
    }

    public String getAmountnAffair() {
	if (cert == null) {
	    return null;
	}
	return cert.getAmountnAffair();
    }

    public String getNow() {
	if (cert == null) {
	    return null;
	}
	return cert.getNow();
    }

    public void store() {
	Preferences prefs = Preferences.userRoot().node(PERSONNAL);
	prefs.putInt("nb", listAllowance.size());
	int k = 0;
	for (Map.Entry<Date, BusinessClass> entry : listAllowance.entrySet()) {
	    Date date = entry.getKey();
	    BusinessClass businessClass = entry.getValue();
	    Double amt = businessClass.getAmount();
	    String cls = businessClass.getBoclass();
	    prefs.put("a." + k, cls);
	    prefs.putDouble("b." + k, amt);
	    prefs.putLong("d." + k, date.getTime());
	    k++;
	}

    }

    public void load() {
	Preferences prefs = Preferences.userRoot().node(PERSONNAL);
	int size = prefs.getInt("nb", 0);;
	if (listAllowance == null) {
	    listAllowance = new HashMap<Date, BusinessClass>();
	}
	for (int k = 0; k < size; k++) {
	    String classl = prefs.get("a." + k, "");
	    double amt = prefs.getDouble("b." + k, 0);
	    long time = prefs.getLong("d." + k, 0);
	    BusinessClass businessClass = new BusinessClass(new Double(amt), classl);
	    Date d = new Date(time);
	    listAllowance.put(d, businessClass);
	}
    }
}
