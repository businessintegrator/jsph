/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;


import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.bi.right.customer.util.xml.CDATAAdapter;

/**
 *
 * //
 *
 * @author rafaralahitsimba tiaray
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String nm;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String pnm;
    private Date birthdt;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String prvcofbirth;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String cityofbirth;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String ctryofbirth;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String civilite;
    private Phonenumber tel;
    private Phonenumber fax;
    private Postaladress6 addr;

    public Personne() {
	this.nm = "";
	this.pnm = "";
	this.birthdt = null;
	this.prvcofbirth = "";
	this.cityofbirth = "";
	this.ctryofbirth = "";
	this.civilite = "";
	this.addr = new Postaladress6();
	this.tel = new Phonenumber();
	this.fax = new Phonenumber();
    }

    public String getNm() {
	return nm;
    }

    public void setNm(String nm) {
	this.nm = nm;
    }

    public String getPnm() {
	return pnm;
    }

    public void setPnm(String pnm) {
	this.pnm = pnm;
    }

    public Date getBirthdt() {
	return birthdt;
    }

    public void setBirthdt(Date birthdt) {
	this.birthdt = birthdt;
    }

    public String getPrvcofbirth() {
	return prvcofbirth;
    }

    public void setPrvcofbirth(String prvcofbirth) {
	this.prvcofbirth = prvcofbirth;
    }

    public String getCityofbirth() {
	return cityofbirth;
    }

    public void setCityofbirth(String cityofbirth) {
	this.cityofbirth = cityofbirth;
    }

    public String getCtryofbirth() {
	return ctryofbirth;
    }

    public void setCtryofbirth(String ctryofbirth) {
	this.ctryofbirth = ctryofbirth;
    }

    public String getCivilite() {
	return civilite;
    }

    public void setCivilite(String civilite) {
	this.civilite = civilite;
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

    //@XmlTransient
    public Postaladress6 getAddr() {
	return addr;
    }

    public void setAddr(Postaladress6 addr) {
	this.addr = addr;
    }

    @Override
    public String toString() {
	return "Personne{" + "nm=" + nm + ", pnm=" + pnm + ", birthdt=" + birthdt + ", prvcofbirth=" + prvcofbirth + ", cityofbirth=" + cityofbirth + ", ctryofbirth=" + ctryofbirth + ", civilite=" + civilite + ", tel=" + tel + ", fax=" + fax + ", addr=" + addr + '}';
    }
}
