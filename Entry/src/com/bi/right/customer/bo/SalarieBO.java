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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class SalarieBO implements Serializable{
    private static final long serialVersionUID = 1L;
   
    private boolean cadre = false;
    private Personne individu;

    public SalarieBO() {
	individu = new Personne();
    }

    public boolean isCadre() {
	return cadre;
    }

    public void setCadre(boolean cadre) {
	this.cadre = cadre;
    }

    
    

    public void setIndividu(Personne individu) {
	this.individu = individu;
    }

    public Personne getIndividu() {
	return individu;
    }

    @Override
    public int hashCode() {
	int hash = 3;
	hash = 67 * hash + (this.cadre ? 1 : 0);
	hash = 67 * hash + ((this.individu == null)?0:1);
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
	final SalarieBO other = (SalarieBO) obj;
	return true;
    }

      
}
