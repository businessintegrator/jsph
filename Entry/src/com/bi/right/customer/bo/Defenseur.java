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
 * @author rafaralahitsimba tiaray
 */
@XmlType(propOrder={"entity",
    "personnephysique",
    "representant",
    "societe"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Defenseur implements Serializable {
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String entity;
    private boolean personnephysique = true;
    private Personne representant;
    private Societe  societe;

    public Defenseur() {
	this.representant = new Personne();
	this.societe = new Societe();
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Personne getRepresentant() {
        return representant;
    }

    public void setRepresentant(Personne representant) {
        this.representant = representant;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public boolean isPersonnephysique() {
	return personnephysique;
    }

    public void setPersonnephysique(boolean personnephysique) {
	this.personnephysique = personnephysique;
    }
    
    
}
