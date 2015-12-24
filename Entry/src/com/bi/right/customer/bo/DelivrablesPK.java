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

public class DelivrablesPK implements Serializable {
    private int iddoc;
    private int idetapejuridique;

    public DelivrablesPK() {
    }

    public DelivrablesPK(int iddoc, int idetapejuridique) {
        this.iddoc = iddoc;
        this.idetapejuridique = idetapejuridique;
    }

    public int getIddoc() {
        return iddoc;
    }

    public void setIddoc(int iddoc) {
        this.iddoc = iddoc;
    }

    public int getIdetapejuridique() {
        return idetapejuridique;
    }

    public void setIdetapejuridique(int idetapejuridique) {
        this.idetapejuridique = idetapejuridique;
    }

  
    
}
