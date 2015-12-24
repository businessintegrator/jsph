package com.bi.right.state;

import com.bi.right.customer.bo.Demandeur;
import com.bi.right.customer.bo.GUIManager;

public class DemChecker extends Milkshake {

    private Demandeur demandeur;
    private Stateview stateView;
    private boolean salarie;
    private final boolean demandeurSalarie;

    public boolean isSalarie() {
	return salarie;
    }

    public void setSalarie(boolean salarie) {
	this.salarie = salarie;
    }

    public DemChecker(GUIManager p, Stateview s) {
	// TODO Auto-generated constructor stub
	this.demandeur = p.getDemandeur();
	demandeurSalarie = p.isPourSalarie();
	this.stateView = s;
    }

    public void process() {
	boolean demandeurReady = false;
	if (demandeurSalarie) {
	    salarie = true;
	    if (isEmpty(this.demandeur.getPersonId().getIndividu())) {
		this.stateView.set(Item.DEMANDEUR_SALARIE, 0);
	    } else {
		this.stateView.set(Item.DEMANDEUR_SALARIE, 100);
		demandeurReady = true;
	    }
	} else {
	    salarie = false;
	    if (isEmpty(this.demandeur.getSocId())) {

		this.stateView.set(Item.DEMANDEUR_SOCIETE, 0);
	    } else {
		this.stateView.set(Item.DEMANDEUR_SOCIETE, 100);
		demandeurReady = true;
	    }
	}
	stateView.setDemandeurReady(demandeurReady);

    }
}
