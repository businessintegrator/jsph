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
 * //@author rafaralahitsimba tiaray
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Delivery implements Serializable {
    private static final long serialVersionUID = 1L;
    //@EmbeddedId
    protected DeliveryPK deliveryPK;
    private Chemindoc chemindoc;

    public Delivery() {
        chemindoc = new Chemindoc();
    }

    public Delivery(DeliveryPK deliveryPK) {
        this.deliveryPK = deliveryPK;
    }

    public Delivery(int iddoc, int idetape) {
        this.deliveryPK = new DeliveryPK(iddoc, idetape);
    }

    public DeliveryPK getDeliveryPK() {
        return deliveryPK;
    }

    public void setDeliveryPK(DeliveryPK deliveryPK) {
        this.deliveryPK = deliveryPK;
    }

    public Chemindoc getChemindoc() {
        return chemindoc;
    }

    public void setChemindoc(Chemindoc chemindoc) {
        this.chemindoc = chemindoc;
    }

  
}
