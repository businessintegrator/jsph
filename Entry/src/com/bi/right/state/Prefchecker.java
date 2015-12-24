package com.bi.right.state;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Prefchecker implements Activator{
	private String end = "2013O4O1";
	private String iza,ino;
	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getIno() {
		return ino;
	}

	public void setIno(String ino) {
		this.ino = ino;
	}
	private byte [] help = "ipconfig".getBytes();
	private String serieux;
	public boolean isCorrect(Preferences prefs) {
		try {
			if (prefs.nodeExists("Prefchecker")){
				int combien = prefs.getInt("uses", 0);
				prefs.putInt("uses", combien+1);
				String cs = prefs.get(TM_, "");
				Calendar c = Calendar.getInstance();
				c.set(Calendar.YEAR,2015);
				
				long time = prefs.getLong(TM,c.getTimeInMillis());
				//retrieve licence time from server
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				long endLicence;
				try {
					endLicence = sdf.parse(end).getTime();
					return endLicence > time;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				
				
			} else {
				//FirsTime for user
				prefs.putInt("uses", 0);
				return false;
			}
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			if (HOME)e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public byte[] ref() {
		// TODO Auto-generated method stub
		return help;
	}
	public void auth(){
		//HttpClient c = new 
		end = check(iza,ino);
		
		
	}

	private String check(String iza2, String ino2) {
		Aoth th = new Aoth();
		th.wet(this,iza,ino);
		String res = null;
		synchronized (help) {
			try {
				help.wait();
				res = th.result();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				res = null;
			}
			
		}
		return res;
		
	}

	@Override
	public void ok(boolean b) {
		if (b)
		this.serieux = "__";
		else
			this.serieux = null;
			
		
	}

}
