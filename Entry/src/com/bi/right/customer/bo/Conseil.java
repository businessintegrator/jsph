/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 * //@author rafaralahitsimba tiaray
 */
@XmlType(name="Conseil",propOrder={"id",
 "ville",
  "section",
   "chambre",
    "addrid",
    "tel",
    "fax",
    "instanceOuverte"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Postaladress6.class,Phonenumber.class})
public class Conseil implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String ville ="";
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String section ="";
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String chambre="";
    private Postaladress6 addrid;
    private Phonenumber tel;
    private Phonenumber fax;
    private boolean instanceOuverte = false;

    public Conseil() {
         this.addrid = new Postaladress6();
         this.tel = new Phonenumber();
         this.fax = new Phonenumber();
         this.ville = "";
         this.section ="";
         this.chambre="";
         
    }

    public Conseil(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getChambre() {
        return chambre;
    }

    public void setChambre(String chambre) {
        this.chambre = chambre;
    }

    public Postaladress6 getAddrid() {
        return addrid;
    }

    public void setAddrid(Postaladress6 addrid) {
        this.addrid = addrid;
    }

    public Phonenumber getTel() {
        return tel;
    }

    public void setTel(Phonenumber tel) {
        this.tel = tel;
    }

    public Phonenumber getFax() {
        return fax;
    }

    public void setFax(Phonenumber fax) {
        this.fax = fax;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conseil other = (Conseil) obj;
        if ((this.ville == null) ? (other.ville != null) : !this.ville.equals(other.ville)) {
            return false;
        }
        if ((this.section == null) ? (other.section != null) : !this.section.equals(other.section)) {
            return false;
        }
        if ((this.chambre == null) ? (other.chambre != null) : !this.chambre.equals(other.chambre)) {
            return false;
        }
        if (this.addrid != other.addrid && (this.addrid == null || !this.addrid.equals(other.addrid))) {
            return false;
        }
        if (this.tel != other.tel && (this.tel == null || !this.tel.equals(other.tel))) {
            return false;
        }
        if (this.fax != other.fax && (this.fax == null || !this.fax.equals(other.fax))) {
            return false;
        }
        return true;
    }

    public boolean isInstanceOuverte() {
	return instanceOuverte;
    }

    public void setInstanceOuverte(boolean instanceOuverte) {
	this.instanceOuverte = instanceOuverte;
    }

    
    @Override
    public String toString() {
        return "Conseil{" + "ville=" + ville + ", section=" + section + ", chambre=" + chambre + ", addrid=" + addrid + ", tel=" + tel + ", fax=" + fax + '}';
    }

  
    
}
