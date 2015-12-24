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
public class DeliveryPK implements Serializable {
    private int iddoc;
    private int idetape;

    public DeliveryPK() {
    }

    public DeliveryPK(int iddoc, int idetape) {
        this.iddoc = iddoc;
        this.idetape = idetape;
    }

    public int getIddoc() {
        return iddoc;
    }

    public void setIddoc(int iddoc) {
        this.iddoc = iddoc;
    }

    public int getIdetape() {
        return idetape;
    }

    public void setIdetape(int idetape) {
        this.idetape = idetape;
    }

   
    
}
