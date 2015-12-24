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
 * //
 *
 * @author rafaralahitsimba tiaray
 */
@XmlType(propOrder={"salarie",
"societe" ,
    "personne",
    "siege",
    "tp",    
    "represente",
    "assiste",
    "representant",
    "assistant"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Defendeur implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean salarie = false;
    private Societe societe;
    private Personne personne;
    private Postaladress6 siege;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String tp;    
    private boolean represente = false;
    private boolean assiste = false;
    private Defenseur representant = null;
    private Defenseur assistant = null;
    

 

    public boolean isRepresente() {
        return represente;
    }

    public void setRepresente(boolean represente) {
        this.represente = represente;
    }

    public boolean getAssiste() {
        return assiste;
    }

    public void setAssiste(boolean assiste) {
        this.assiste = assiste;
    }


    public Defendeur() {
        this.siege = new Postaladress6();
        this.societe = new Societe();
        this.personne = new Personne();
	this.assistant = new Defenseur();
	this.representant = new Defenseur();
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

  
  
    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

  
    

    public Postaladress6 getSiege() {
        return siege;
    }

    public void setSiege(Postaladress6 siege) {
        this.siege = siege;
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

    @Override
    public String toString() {
        return "Defendeur{tp=" + tp + ", siege=" + siege + ", societe=" + societe + ", personne=" + personne + '}';
    }

    public boolean isSalarie() {
        return salarie ;
    }

    public void setSalarie(boolean salarie) {
        this.salarie = salarie;
    }

}
