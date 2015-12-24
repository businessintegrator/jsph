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
 * @author rafaralahitsimba tiaray
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
class Coefficient implements Serializable {
    private Double valeurCoef;
    private Double coefficient;

    public Double getValeurCoef() {
	return valeurCoef;
    }

    public void setValeurCoef(Double valeurCoef) {
	this.valeurCoef = valeurCoef;
    }

    public Double getCoefficient() {
	return coefficient;
    }

    public void setCoefficient(Double coefficient) {
	this.coefficient = coefficient;
    }
    
    
}
