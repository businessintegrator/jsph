package com.bi.right.state;

import com.bi.right.customer.bo.Redressement;

public class RedressementChecker extends Milkshake {

	private Redressement redressement;
	private Stateview stateView;

	public RedressementChecker(Redressement redressement, Stateview s) {
		// TODO Auto-generated constructor stub
		this.redressement = redressement;
		this.stateView = s;
	}

	public void process() {
            boolean redressementReady = false;
		if (isEmpty(redressement.getCreditorrepr())) {
			this.stateView.set(Item.REDRESSEMENT_CREDITOR, 0);
			if (isEmpty(redressement.getAdmin())) {
				this.stateView.set(Item.REDRESSEMENT_ADMINISTRATEUR, 0);
			} else {
				this.stateView.set(Item.REDRESSEMENT_ADMINISTRATEUR, 50);
			}
		} else {
			if (isEmpty(redressement.getAdmin())) {
				this.stateView.set(Item.REDRESSEMENT_ADMINISTRATEUR, 50);
			} else {
				this.stateView.set(Item.REDRESSEMENT_ADMINISTRATEUR, 100);
                                redressementReady =true;
			}
		}
                
                this.stateView.setRedressementReady(redressementReady);
	}

}
