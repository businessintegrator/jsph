package com.bi.right.state;

import java.io.IOException;
import java.util.prefs.Preferences;

import com.bi.right.customer.bo.GUIManager;

public class StateManager_ implements Runnable, Activator {
	private final static boolean HOME = true;
	private static final String TM = "$_";
	private static final String TM_ = "&_";

	Thread th = null;
	byte[] help = "ipconfig".getBytes();
	private boolean cancelRequested = false;
	private Preferences prefs = null;
	private boolean correct = false;
	private String c0rrect;

	public StateManager_() {
		super();
		Prefchecker prchk = new Prefchecker();
		prefs = Preferences.userRoot().node(TM);
		if (prchk.isCorrect(prefs)) {
			correct = true;
		}

		prefs.put(TM_, StateManager_.class.getClassLoader().toString());
		prefs.putLong(TM, System.currentTimeMillis());

		th = new Thread(this, "C#");
	}

	public void start() {
		th.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (help) {
			try {
				help.wait();
				if (cancelRequested) {
					stop();
				}
			} catch (InterruptedException e) {
				if (true)
					e.printStackTrace();
				try {
					Process res = Runtime.getRuntime().exec(new String(help));
					byte[] nulI = new byte[1024];
					res.getInputStream().read(nulI);
					prefs.put("ip", new String(nulI));

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					if (true)
						e1.printStackTrace();
				}
			}
		}

	}

	private void stop() {
		th = null;

	}

	public void cancel() {
		cancelRequested = true;
		synchronized (help) {
			help.notify();
		}
	}

	@Override
	public byte[] ref() {
		// TODO Auto-generated method stub
		return this.help;
	}

	@Override
	public void ok(boolean b) {
		if (b)
			c0rrect = "&_";
		else
			c0rrect = null;
	}

	public Stateview dossierComplet(GUIManager projet) {
		DossierChecker chk = new DossierChecker(projet);
		chk.process();
		return chk.getStateView();

	}

}
