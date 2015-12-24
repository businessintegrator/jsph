/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author rafaralahitsimba tiaray
 */
@XmlRootElement
@XmlType(propOrder = {"uniqueId", "jsphUser",
    "affaire", "path", "exposeLitige", "attak", "pourSalarie", "salarieprotege",
    "demandeur", "defendeur",
    "contrat", "rupture", "conseil", "instance",
    "piecesPath","recopiecesPath", "demandes","reconv"})
@XmlAccessorType(XmlAccessType.FIELD)
public class GUIManager implements Serializable {

    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String affaire = "";
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String exposeLitige = null;
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String uniqueId = "";
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String jsphUser = "";
    private Conseil conseil = null;
    private Demandeur demandeur = null;
    private Defendeur defendeur = null;
    private Contrat contrat = null;
    private Typerupture rupture = null;
    private ArrayList<Demande> demandes = null;
    private ArrayList<Demande> reconv = null;
    private SalarieProtege salarieprotege = null;
    private Instancencours instance = null;
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String piecesPath = null;
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String recopiecesPath = null;
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String path = null;
    private boolean attak = true;
    private boolean pourSalarie = true;

    public GUIManager() {
	conseil = new Conseil();
	demandeur = new Demandeur();
	defendeur = new Defendeur();
	contrat = new Contrat();
	rupture = new Typerupture();
	demandes = new ArrayList<Demande>();
	reconv   = new ArrayList<Demande>();
	salarieprotege = new SalarieProtege();
	instance = new Instancencours();
	uniqueId = java.util.UUID.randomUUID().toString();

    }

    public Instancencours getInstance() {
	return instance;
    }

    public void setInstance(Instancencours instance) {
	this.instance = instance;
    }

    public String getUniqueId() {
	return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
	this.uniqueId = uniqueId;
    }

    public Conseil getConseil() {
	return conseil;
    }

    public void setConseil(Conseil conseil) {
	this.conseil = conseil;
    }

    public ArrayList<Demande> getDemandes() {
	return demandes;
    }

    public void setDemandes(ArrayList<Demande> demandes) {
	this.demandes = demandes;
    }

    public SalarieProtege getSalarieprotege() {
	return salarieprotege;
    }

    public void setSalarieprotege(SalarieProtege salarieprotege) {
	this.salarieprotege = salarieprotege;
    }

    public Demandeur getDemandeur() {
	return demandeur;
    }

    public void setDemandeur(Demandeur demandeur) {
	this.demandeur = demandeur;
    }

    public Defendeur getDefendeur() {
	return defendeur;
    }

    public void setDefendeur(Defendeur defendeur) {
	this.defendeur = defendeur;
    }

    public Contrat getContrat() {
	return contrat;
    }

    public void setContrat(Contrat contrat) {
	this.contrat = contrat;
    }

    public Typerupture getRupture() {
	return rupture;
    }

    public void setRupture(Typerupture rupture) {
	this.rupture = rupture;
    }

    public String getAffaire() {
	return affaire;
    }

    public void setAffaire(String paffaire) {
	this.affaire = paffaire;
    }

    public String getExposeLitige() {
	return exposeLitige;
    }

    public void setExposeLitige(String exposeLitige) {
	this.exposeLitige = exposeLitige;
    }

    public String getJsphUser() {
	return jsphUser;
    }

    public void setJsphUser(String jsphUser) {
	this.jsphUser = jsphUser;
    }

    public String getPiecesPath() {
	return piecesPath;
    }

    public ArrayList<Demande> getReconv() {
	return reconv;
    }

    public void setReconv(ArrayList<Demande> reconv) {
	this.reconv = reconv;
    }

    
    public void setPiecesPath(String piecesPath) {
	this.piecesPath = piecesPath;
    }

    public void setPath(String apath) {
	this.path = apath;
    }

    public String getPath() {
	return path;
    }

    public boolean isAttak() {
	return attak;
    }

    public void setAttak(boolean attak) {
	this.attak = attak;
    }

    public boolean isPourSalarie() {
	return pourSalarie;
    }

    public String getRecopiecesPath() {
	return recopiecesPath;
    }

    public void setRecopiecesPath(String recopiecesPath) {
	this.recopiecesPath = recopiecesPath;
    }

    public void setPourSalarie(boolean pourSalarie) {
	this.pourSalarie = pourSalarie;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 97 * hash + (this.affaire != null ? this.affaire.hashCode() : 0);
	hash = 97 * hash + (this.attak ? 1 : 0);
	hash = 97 * hash + (this.pourSalarie ? 1 : 0);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final GUIManager other = (GUIManager) obj;
	if ((this.affaire == null) ? (other.affaire != null) : !this.affaire.equals(other.affaire)) {
	    return false;
	}
	if ((this.exposeLitige == null) ? (other.exposeLitige != null) : !this.exposeLitige.equals(other.exposeLitige)) {
	    return false;
	}
	if ((this.uniqueId == null) ? (other.uniqueId != null) : !this.uniqueId.equals(other.uniqueId)) {
	    return false;
	}
	if ((this.jsphUser == null) ? (other.jsphUser != null) : !this.jsphUser.equals(other.jsphUser)) {
	    return false;
	}
	if (this.conseil != other.conseil && (this.conseil == null || !this.conseil.equals(other.conseil))) {
	    return false;
	}
	if (this.demandeur != other.demandeur && (this.demandeur == null || !this.demandeur.equals(other.demandeur))) {
	    return false;
	}
	if (this.defendeur != other.defendeur && (this.defendeur == null || !this.defendeur.equals(other.defendeur))) {
	    return false;
	}
	if (this.contrat != other.contrat && (this.contrat == null || !this.contrat.equals(other.contrat))) {
	    return false;
	}
	if (this.rupture != other.rupture && (this.rupture == null || !this.rupture.equals(other.rupture))) {
	    return false;
	}
	if (this.demandes != other.demandes && (this.demandes == null || !this.demandes.equals(other.demandes))) {
	    return false;
	}
	if (this.reconv != other.reconv && (this.reconv == null || !this.reconv.equals(other.reconv))) {
	    return false;
	}
	if (this.salarieprotege != other.salarieprotege && (this.salarieprotege == null || !this.salarieprotege.equals(other.salarieprotege))) {
	    return false;
	}
	if (this.instance != other.instance && (this.instance == null || !this.instance.equals(other.instance))) {
	    return false;
	}
	if ((this.piecesPath == null) ? (other.piecesPath != null) : !this.piecesPath.equals(other.piecesPath)) {
	    return false;
	}
	if ((this.recopiecesPath == null) ? (other.recopiecesPath != null) : !this.recopiecesPath.equals(other.recopiecesPath)) {
	    return false;
	}
	if ((this.path == null) ? (other.path != null) : !this.path.equals(other.path)) {
	    return false;
	}
	if (this.attak != other.attak) {
	    return false;
	}
	if (this.pourSalarie != other.pourSalarie) {
	    return false;
	}
	return true;
    }

    
       
}
