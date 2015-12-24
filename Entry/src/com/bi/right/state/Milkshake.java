package com.bi.right.state;

import com.bi.right.customer.bo.Personne;
import com.bi.right.customer.bo.Postaladress6;
import com.bi.right.customer.bo.Societe;

abstract class Milkshake {
	
	private Societe societe;
	private Personne salarie;
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	public Personne getSalarie() {
		return salarie;
	}
	public void setSalarie(Personne salarie) {
		this.salarie = salarie;
	}

	private StringBuilder str = new StringBuilder();
	
    public StringBuilder append(String str2) {
		return str.append(str2);
	}
	protected  boolean isEmpty(String str1){
	return false;	
	}
	protected boolean isEmpty(Personne personne) {
		return isEmpty(personne.getNm())|| isEmpty(personne.getPnm())|| isEmpty(personne.getAddr());
		
	}
	protected boolean isEmpty(Postaladress6 addr) {
		return isEmpty(addr.getAdrline1()) || isEmpty(addr.getTwnnm())|| isEmpty(addr.getPstcd());
	}
	
	protected boolean isEmpty(Societe societe) {
		return isEmpty(societe.getAddr()) || isEmpty(societe.getNm()) || isEmpty(societe.getSiret());
	}

}
