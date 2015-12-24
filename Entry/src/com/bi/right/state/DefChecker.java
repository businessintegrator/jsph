package com.bi.right.state;

import com.bi.right.customer.bo.Defendeur;
import com.bi.right.customer.bo.Societe;

public class DefChecker extends Milkshake {

	private Stateview stateView;
	private Defendeur defendeur;
	private boolean salarie;

	public boolean isSalarie() {
		return salarie;
	}

	public void setSalarie(boolean salarie) {
		this.salarie = salarie;
	}

	public DefChecker(Defendeur defendeur, Stateview s) {
		this.defendeur = defendeur;
		this.stateView = s;

	}

	public void process() {
boolean defendeurReady = false;
		if (defendeur.isSalarie()) {
			salarie = true;
			if (isEmpty(this.defendeur.getPersonne())) {
				this.stateView.set(Item.DEFENDEUR_SALARIE, 0);
			} else {
				this.stateView.set(Item.DEFENDEUR_SALARIE, 100);
                                defendeurReady = true;
			}
		} else {
			salarie = false;
			if (isEmpty(this.defendeur.getSociete())) {
				this.stateView.set(Item.DEFENDEUR_SOCIETE, 0);
			} else {
				this.stateView.set(Item.DEFENDEUR_SOCIETE, 100);
                                defendeurReady = true;
			}

		}
stateView.setDefendeurReady(defendeurReady);
	}

}
