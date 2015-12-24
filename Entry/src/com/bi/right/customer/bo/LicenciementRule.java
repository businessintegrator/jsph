package com.bi.right.customer.bo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Rl")
public class LicenciementRule implements Serializable{

	private int periodeEssai = 0; 
	private int periodeEssaiRenouvele = 0;
	private double ancienenteApplicableMin = 0;
	private double ancienenteApplicableMax = 2;
	private int numerateur = 1;
	private int denominateur = 1;
	private double salaireDerefenrence12;
	private double salaireDerefenrence3;
	private double salaireDerefenrenceUsage;
	
	private int maxMoisIndemniteLicenciement = 12;
	
	public LicenciementRule() {
	}

	public int getPeriodeEssai() {
		return periodeEssai;
	}

	public void setPeriodeEssai(int periodeEssai) {
		this.periodeEssai = periodeEssai;
	}

	public int getPeriodeEssaiRenouvele() {
		return periodeEssaiRenouvele;
	}

	public void setPeriodeEssaiRenouvele(int periodeEssaiRenouvele) {
		this.periodeEssaiRenouvele = periodeEssaiRenouvele;
	}

	public double getAncienenteApplicableMin() {
		return ancienenteApplicableMin;
	}

	public void setAncienenteApplicableMin(double ancienenteApplicableMin) {
		this.ancienenteApplicableMin = ancienenteApplicableMin;
	}

	public double getAncienenteApplicableMax() {
		return ancienenteApplicableMax;
	}

	public void setAncienenteApplicableMax(double ancienenteApplicableMax) {
		this.ancienenteApplicableMax = ancienenteApplicableMax;
	}

	public int getNumerateur() {
		return numerateur;
	}

	public void setNumerateur(int numerateur) {
		this.numerateur = numerateur;
	}

	public int getDenominateur() {
		return denominateur;
	}

	public void setDenominateur(int denominateur) {
		this.denominateur = denominateur;
	}

	public double getSalaireDerefenrence12() {
		return salaireDerefenrence12;
	}

	public void setSalaireDerefenrence12(double salaireDerefenrence12) {
		this.salaireDerefenrence12 = salaireDerefenrence12;
	}

	public double getSalaireDerefenrence3() {
		return salaireDerefenrence3;
	}

	public void setSalaireDerefenrence3(double salaireDerefenrence3) {
		this.salaireDerefenrence3 = salaireDerefenrence3;
	}

	public double getSalaireDerefenrenceUsage() {
		return salaireDerefenrenceUsage;
	}

	public void setSalaireDerefenrenceUsage(double salaireDerefenrenceUsage) {
		this.salaireDerefenrenceUsage = salaireDerefenrenceUsage;
	}

	public int getMaxMoisIndemniteLicenciement() {
		return maxMoisIndemniteLicenciement;
	}

	public void setMaxMoisIndemniteLicenciement(int maxMoisIndemniteLicenciement) {
		this.maxMoisIndemniteLicenciement = maxMoisIndemniteLicenciement;
	}

	
}
