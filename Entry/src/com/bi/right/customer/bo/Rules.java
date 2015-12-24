/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * //
 *
 * @author rafaralahitsimba tiaray
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id",
    "connaissanceFaute",
    "periodeEssay",
    "prolongationPeriodeEssay",
    "congePeriodeEssay",
    "rttPeriodeEssay",
    "preavisDeLicenciement",
    "preavisPeriodeEssay",
    "dispenseDePreavisLicenciement",
    "indemniteLicenciement",
    "entretienPralable",
    "notificationLicenciement",
    "applicabiliteNBSalarie",
    "applicabiliteAnciennete",
    "applicabiliteConvention",
    "applicabiliteCodeNaf"})
public class Rules implements Serializable {

    private static final long serialVersionUID = 1L;
    private Rule id;
    private Rule connaissanceFaute;
    private Rule periodeEssay;
    private Rule prolongationPeriodeEssay;
    private Rule congePeriodeEssay;
    private Rule rttPeriodeEssay;
    private Rule preavisDeLicenciement;
    private Rule preavisPeriodeEssay;
    private Rule dispenseDePreavisLicenciement;
    private Rule indemniteLicenciement;
    private Rule entretienPralable;
    private Rule notificationLicenciement;
    private Rule applicabiliteNBSalarie;
    private Rule applicabiliteAnciennete;
    private Rule applicabiliteConvention;
    private Rule applicabiliteCodeNaf;

    public Rules() {
    }

    public Rules(Rule id) {
	this.id = id;
    }

    public Rule getId() {
	return id;
    }

    public void setId(Rule id) {
	this.id = id;
    }

    public Rule getConnaissanceFaute() {
	return connaissanceFaute;
    }

    public void setConnaissanceFaute(Rule connaissanceFaute) {
	this.connaissanceFaute = connaissanceFaute;
    }

    public Rule getPeriodeEssay() {
	return periodeEssay;
    }

    public void setPeriodeEssay(Rule periodeEssay) {
	this.periodeEssay = periodeEssay;
    }

    public Rule getProlongationPeriodeEssay() {
	return prolongationPeriodeEssay;
    }

    public void setProlongationPeriodeEssay(Rule prolongationPeriodeEssay) {
	this.prolongationPeriodeEssay = prolongationPeriodeEssay;
    }

    public Rule getCongePeriodeEssay() {
	return congePeriodeEssay;
    }

    public void setCongePeriodeEssay(Rule congePeriodeEssay) {
	this.congePeriodeEssay = congePeriodeEssay;
    }

    public Rule getRttPeriodeEssay() {
	return rttPeriodeEssay;
    }

    public void setRttPeriodeEssay(Rule rttPeriodeEssay) {
	this.rttPeriodeEssay = rttPeriodeEssay;
    }

    public Rule getPreavisDeLicenciement() {
	return preavisDeLicenciement;
    }

    public void setPreavisDeLicenciement(Rule preavisDeLicenciement) {
	this.preavisDeLicenciement = preavisDeLicenciement;
    }

    public Rule getPreavisPeriodeEssay() {
	return preavisPeriodeEssay;
    }

    public void setPreavisPeriodeEssay(Rule preavisPeriodeEssay) {
	this.preavisPeriodeEssay = preavisPeriodeEssay;
    }

    public Rule getDispenseDePreavisLicenciement() {
	return dispenseDePreavisLicenciement;
    }

    public void setDispenseDePreavisLicenciement(Rule dispenseDePreavisLicenciement) {
	this.dispenseDePreavisLicenciement = dispenseDePreavisLicenciement;
    }

    public Rule getIndemniteLicenciement() {
	return indemniteLicenciement;
    }

    public void setIndemniteLicenciement(Rule indemniteLicenciement) {
	this.indemniteLicenciement = indemniteLicenciement;
    }

    public Rule getEntretienPralable() {
	return entretienPralable;
    }

    public void setEntretienPralable(Rule entretienPralable) {
	this.entretienPralable = entretienPralable;
    }

    public Rule getNotificationLicenciement() {
	return notificationLicenciement;
    }

    public void setNotificationLicenciement(Rule notificationLicenciement) {
	this.notificationLicenciement = notificationLicenciement;
    }

    public Rule getApplicabiliteNBSalarie() {
	return applicabiliteNBSalarie;
    }

    public void setApplicabiliteNBSalarie(Rule applicabiliteNBSalarie) {
	this.applicabiliteNBSalarie = applicabiliteNBSalarie;
    }

    public Rule getApplicabiliteAnciennete() {
	return applicabiliteAnciennete;
    }

    public void setApplicabiliteAnciennete(Rule applicabiliteAnciennete) {
	this.applicabiliteAnciennete = applicabiliteAnciennete;
    }

    public Rule getApplicabiliteConvention() {
	return applicabiliteConvention;
    }

    public void setApplicabiliteConvention(Rule applicabiliteConvention) {
	this.applicabiliteConvention = applicabiliteConvention;
    }

    public Rule getApplicabiliteCodeNaf() {
	return applicabiliteCodeNaf;
    }

    public void setApplicabiliteCodeNaf(Rule applicabiliteCodeNaf) {
	this.applicabiliteCodeNaf = applicabiliteCodeNaf;
    }
}
