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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType

public class Rule implements Serializable {
    private Integer item = 0;
    private Timeunit unite;
@XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String label ="";
    private int numerateur =0;
    private int denominateur = 1;
    private Coefficient coef;
    
    

    public Rule() {
    }

    
    public Integer getItem() {
	return item;
    }

    public void setItem(Integer item) {
	this.item = item;
    }

    public Timeunit getUnite() {
	return unite;
    }

    public void setUnite(Timeunit unite) {
	this.unite = unite;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public int getNumerateur() {
	return numerateur;
    }

    public void setNumerateur(int numerateur) {
	this.numerateur = numerateur;
    }

    public int getDenominateur() {
	return denominateur;
    }

    public void setDenominateur(int denominateur) {
	if (denominateur == 0) {
	 throw new IllegalArgumentException("1/"+denominateur);
	}
	this.denominateur = denominateur;
    }
    
    
    
}
