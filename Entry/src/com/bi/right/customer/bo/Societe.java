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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"redressement",
    "liquidation",
    "ags",
    "id",
    "nm",
    "nmcom",
    "siret",
    "nafape",
    "convcoll",
    "addr",
    "idredressement",
    "ursaff",
    "idliquidation",
    "agscgea",
    "effectif",
    "lblActivite",
    "owner",
    "rprsnt"})
public class Societe implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean redressement = false;
    private boolean liquidation = false;
    private boolean ags = false;
    private Integer id;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String nm = "";
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String nmcom = "";
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String siret = "";
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String nafape = "";
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String convcoll = "";
    private Redressement idredressement;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String ursaff = "";
    private Liquidation idliquidation;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String agscgea = "";
    private long effectif;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String lblActivite = "";
    private Societe owner;
    private Postaladress6 addr;
    private Personne rprsnt;

    public boolean isRedressement() {
	return redressement;
    }

    public void setRedressement(boolean redressement) {
	this.redressement = redressement;
    }

    public boolean getLiquidation() {
	return liquidation;
    }

    public void setLiquidation(boolean liquidation) {
	this.liquidation = liquidation;
    }

    public Societe() {
	this.addr = new Postaladress6();
	this.idliquidation = new Liquidation();
	this.idredressement = new Redressement();
	this.rprsnt = new Personne();
    }

    public Societe(Integer id) {
	this.id = id;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNm() {
	return nm;
    }

    public void setNm(String nm) {
	this.nm = nm;
    }

    public String getNmcom() {
	return nmcom;
    }

    public void setNmcom(String nmcom) {
	this.nmcom = nmcom;
    }

    public String getSiret() {
	return siret;
    }

    public void setSiret(String siret) {
	this.siret = siret;
    }

    public String getNafape() {
	return nafape;
    }

    public void setNafape(String nafape) {
	this.nafape = nafape;
    }

    public String getConvcoll() {
	return convcoll;
    }

    public void setConvcoll(String convcoll) {
	this.convcoll = convcoll;
    }

    public boolean getAgs() {
	return ags;
    }

    public void setAgs(boolean ags) {
	this.ags = ags;
    }

    public String getUrsaff() {
	return ursaff;
    }

    public void setUrsaff(String ursaff) {
	this.ursaff = ursaff;
    }

    public String getAgscgea() {
	return agscgea;
    }

    public void setAgscgea(String agscgea) {
	this.agscgea = agscgea;
    }

    public long getEffectif() {
	return effectif;
    }

    public void setEffectif(long effectif) {
	this.effectif = effectif;
    }

    public String getLblActivite() {
	return lblActivite;
    }

    public void setLblActivite(String lblActivite) {
	this.lblActivite = lblActivite;
    }

    public Societe getOwner() {
	return owner;
    }

    public void setOwner(Societe socProp) {
	this.owner = socProp;
    }

    public Postaladress6 getAddr() {
	return addr;
    }

    public void setAddr(Postaladress6 addr) {
	this.addr = addr;
    }

    public Personne getRprsnt() {
	return rprsnt;
    }

    public void setRprsnt(Personne rprsnt) {
	this.rprsnt = rprsnt;
    }

    public Redressement getIdredressement() {
	return idredressement;
    }

    public void setIdredressement(Redressement idredressement) {
	this.idredressement = idredressement;
    }

    public Liquidation getIdliquidation() {
	return idliquidation;
    }

    public void setIdliquidation(Liquidation idliquidation) {
	this.idliquidation = idliquidation;
    }

    @Override
    public String toString() {
	return "Societe{" + "id=" + id + ", nm=" + nm + ", nmcom=" + nmcom + ", siret=" + siret + ", nafape=" + nafape + ", convcoll=" + convcoll + ", ags=" + ags + ", ursaff=" + ursaff + ", idliquidation=" + idliquidation + ", agscgea=" + agscgea + ", effectif=" + effectif + ", lblActivite=" + lblActivite + ", socProp=" + owner + ", addr=" + addr + ", rprsnt=" + rprsnt + "}";
    }
}
