/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author rafaralahitsimba tiaray
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Demandereconv implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String artlaw;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String artconv;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String lbl;
    private int idinterval;
    private Double amount;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String curr;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String precision;
    private Integer iddef;
    private List<Demanderef> demanderefList;

    public Demandereconv() {
        this.artlaw = "";
        this.artconv = "";
        this.lbl = "";
        this.amount = new Double(0);
        this.curr = "EUR";
        this.precision = "";

    }

    public Demandereconv(Integer id) {
        this.id = id;
    }

    public Demandereconv(Integer id, int idinterval) {
        this.id = id;
        this.idinterval = idinterval;
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

    public String getLbl() {
        return lbl;
    }

    public void setLbl(String lbl) {
        this.lbl = lbl;
    }

    public int getIdinterval() {
        return idinterval;
    }

    public void setIdinterval(int idinterval) {
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

    public Integer getIddef() {
        return iddef;
    }

    public void setIddef(Integer iddef) {
        this.iddef = iddef;
    }

    //@XmlTransient
    public List<Demanderef> getDemanderefList() {
        return demanderefList;
    }

    public void setDemanderefList(List<Demanderef> demanderefList) {
        this.demanderefList = demanderefList;
    }

    @Override
    public String toString() {
        return "Demandereconv{" + "artlaw=" + artlaw + ", artconv=" + artconv + ", lbl=" + lbl + ", idinterval=" + idinterval + ", amount=" + amount + ", curr=" + curr + ", precision=" + precision + ", iddef=" + iddef + ", demanderefList=" + demanderefList + '}';
    }

   
}
