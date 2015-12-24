/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 *
 * @author rafaralahitsimba tiaray
 */

@XmlType(propOrder={"salarie","personId","nationalite","socId",
    "tp","pro","phoneid",
    "represente","assiste","representant","assistant"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Demandeur implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean salarie = true;
    private Societe socId;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String tp;
    private SalarieBO personId;
    private Phonenumber phoneid;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String nationalite = "";
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String pro = "";
    private boolean represente = false;
    private boolean assiste = false;
    private Defenseur representant = null;
    private Defenseur assistant = null;

    public Demandeur() {
	personId = new SalarieBO();
	phoneid = new Phonenumber();
	socId = new Societe();
	representant = new Defenseur();
	assistant = new Defenseur();
    }

    public boolean isSalarie() {
	return salarie;
    }

    public void setSalarie(boolean salarie) {
	this.salarie = salarie;
    }

    public Societe getSocId() {
	return socId;
    }

    public void setSocId(Societe socId) {
	this.socId = socId;
    }

    public String getTp() {
	return tp;
    }

    public void setTp(String tp) {
	this.tp = tp;
    }

    public SalarieBO getPersonId() {
	return personId;
    }

    public void setPersonId(SalarieBO personId) {
	this.personId = personId;
    }

    public Phonenumber getPhoneid() {
	return phoneid;
    }

    public void setPhoneid(Phonenumber phoneid) {
	this.phoneid = phoneid;
    }

    public String getNationalite() {
	return nationalite;
    }

    public void setNationalite(String nationalite) {
	this.nationalite = nationalite;
    }

    public String getPro() {
	return pro;
    }

    public void setPro(String pro) {
	this.pro = pro;
    }

    public boolean isRepresente() {
	return represente;
    }

    public void setRepresente(boolean represente) {
	this.represente = represente;
    }

    public boolean isAssiste() {
	return assiste;
    }

    public void setAssiste(boolean assiste) {
	this.assiste = assiste;
    }

    public Defenseur getRepresentant() {
	return representant;
    }

    public void setRepresentant(Defenseur representant) {
	this.representant = representant;
    }

    public Defenseur getAssistant() {
	return assistant;
    }

    public void setAssistant(Defenseur assistant) {
	this.assistant = assistant;
    }
}
