/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
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
@XmlType(propOrder={ "id",
 "iddem",
"selected",
"argumented",
"artlaw",
"artconv",
"lbl",
"idinterval",
"amount",
"curr",
"precision",
"argDroit",
"argFait",
"argumentationPath",
"astreinte",
"demanderefList"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Demande implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;
    private Integer id  ;
@XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String artlaw;
@XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String artconv;
    private Integer iddem;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String lbl;
    private Interval idinterval;
    private Double amount;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String curr;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String precision;
    private List<Demanderef> demanderefList;
    private boolean selected;
    private boolean argumented;
    
    private String argDroit;
    private String argFait;
    private String argumentationPath;
    private Double astreinte =0.0; 

    public String getArgDroit() {
        return argDroit;
    }

    public void setArgDroit(String argDroit) {
        this.argDroit = argDroit;
    }

    public String getArgFait() {
        return argFait;
    }

    public void setArgFait(String argFait) {
        this.argFait = argFait;
    }

    public boolean isArgumented() {
        return argumented;
    }

    public void setArgumented(boolean argumented) {
        this.argumented = argumented;
    }

    public Demande() {
        this.artlaw = "";
        this.artconv = "";

        this.lbl = "";
        this.amount = new Double(0);
        this.curr = "EUR";
        this.precision = "";
        this.idinterval = new Interval();
	this.demanderefList = new LinkedList<Demanderef>();

    }

    public Demande(Integer id) {
        this.id = id;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtlaw() {
        return artlaw;
    }

    public void setArtlaw(String artlaw) {
        this.artlaw = artlaw;
    }

    public String getArtconv() {
        return artconv;
    }

    public void setArtconv(String artconv) {
        this.artconv = artconv;
    }

    public Integer getIddem() {
        return iddem;
    }

    public void setIddem(Integer iddem) {
        this.iddem = iddem;
    }

    public String getLbl() {
        return lbl;
    }

    public void setLbl(String lbl) {
        this.lbl = lbl;
    }

    public Interval getIdinterval() {
        return idinterval;
    }

    public void setIdinterval(Interval idinterval) {
        this.idinterval = idinterval;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    //@XmlTransient
    public List<Demanderef> getDemanderefList() {
        return demanderefList;
    }

    public void setDemanderefList(List<Demanderef> demanderefList) {
        this.demanderefList = demanderefList;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Demande{" + "id=" + id + ", artlaw=" + artlaw + ", artconv=" + artconv + ", lbl=" + lbl + ", idinterval=" + idinterval + ", amount=" + amount + ", curr=" + curr + ", precision=" + precision + ", demanderefList=" + demanderefList + ", selected=" + selected + '}';
    }

    public void setArgumentationPath(String path) {
        this.argumentationPath = path;
    }

    public String getArgumentationPath() {
        return argumentationPath;
    }

    public Double getAstreinte() {
	return astreinte;
    }

    public void setAstreinte(Double astreinte) {
	this.astreinte = astreinte;
    }

   
    
}
