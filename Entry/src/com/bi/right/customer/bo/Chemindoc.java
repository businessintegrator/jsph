/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * //@author rafaralahitsimba tiaray
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Chemindoc implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private List<Piece> deliveryList = null;

    public List<Piece> getDeliveryList() {
        return deliveryList;
    }

    public void setDeliveryList(List<Piece> deliveryList) {
        this.deliveryList = deliveryList;
    }
    

    public Chemindoc() {
        deliveryList = new ArrayList<Piece>();
    }

   

   

   
  
   
    
}
