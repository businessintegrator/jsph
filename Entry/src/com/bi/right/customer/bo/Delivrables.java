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
 * //@author rafaralahitsimba tiaray
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Delivrables implements Serializable {
    private static final long serialVersionUID = 1L;
    protected DelivrablesPK delivrablesPK;
    
    private Chemindoc chemindoc;

    public Delivrables() {
        chemindoc = new Chemindoc();
    }

    public Delivrables(DelivrablesPK delivrablesPK) {
        this.delivrablesPK = delivrablesPK;
    }

    public Delivrables(int iddoc, int idetapejuridique) {
        this.delivrablesPK = new DelivrablesPK(iddoc, idetapejuridique);
    }

    public DelivrablesPK getDelivrablesPK() {
        return delivrablesPK;
    }

    public void setDelivrablesPK(DelivrablesPK delivrablesPK) {
        this.delivrablesPK = delivrablesPK;
    }

    public Chemindoc getChemindoc() {
        return chemindoc;
    }

    public void setChemindoc(Chemindoc chemindoc) {
        this.chemindoc = chemindoc;
    }


    
}
