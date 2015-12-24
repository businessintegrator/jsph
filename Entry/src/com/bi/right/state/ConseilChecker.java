package com.bi.right.state;

import com.bi.right.customer.bo.Conseil;

public class ConseilChecker extends Milkshake{

	
	private Conseil conseil;
	private Stateview stateView;

	public ConseilChecker(Conseil pconseil, Stateview s) {
		this.conseil = pconseil;
		this.stateView = s;
	}

	public void process() {
             boolean conseilReady = false;
		String section = conseil.getSection();
		boolean comp = isEmpty(section);
		if (comp){
			stateView.set(Item.SECTION,0);
		}else {
			stateView.set(Item.SECTION,100);
                        conseilReady = true;
		}
		//comp &= isEmpty(conseil.getVille());
		this.stateView.set(Item.CPH,0);
		AdresseChecker chk = new AdresseChecker(conseil.getAddrid(),stateView);
		chk.process();
                if (stateView.get(Item.ADDR)>= 100){
                    this.stateView.set(Item.CPH,100);
                    if (conseilReady) { conseilReady = true;}
                } else {
                    conseilReady = false;
                }
                this.stateView.setConseilReady(true);
	}

}
