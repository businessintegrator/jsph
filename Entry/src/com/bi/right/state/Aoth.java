package com.bi.right.state;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Aoth {

	public Aoth() {
		
	}

	public void wet(Activator act, String iza, String ino)  {
		
		synchronized (act.ref()) {
			try {
				URL url = new URL("http://www.jsph.fr/refs");
				try {
					URLConnection cnx = url.openConnection();
					cnx.connect();
					System.out.println(cnx.getContent());
					act.ok(true);
					act.ref().notify();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					act.ok(false);
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				act.ok(false);
			}
			
		}
		
	}

	public String result() {
		
		return null;
	}

}
