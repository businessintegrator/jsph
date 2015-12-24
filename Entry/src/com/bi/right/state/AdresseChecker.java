package com.bi.right.state;

import com.bi.right.customer.bo.Postaladress6;

public class AdresseChecker extends Milkshake{

	private Postaladress6 addr;
	private Stateview stateView;

	public AdresseChecker(Postaladress6 addrid, Stateview stateView) {
		this.addr = addrid;
		this.stateView = stateView;
	}

	public void process() {
		// TODO Auto-generated method stub
		if (this.addr == null) {stateView.set(Item.ADDR, 0);}
		else 
		if (isEmpty(this.addr.getAdrline1())|| isEmpty(this.addr.getAdrline1())|| isEmpty(this.addr.getPstcd())
				|| isEmpty(this.addr.getTwnnm())){stateView.set(Item.ADDR, 10);} else {
					stateView.set(Item.ADDR, 100);
				}
	}

}
