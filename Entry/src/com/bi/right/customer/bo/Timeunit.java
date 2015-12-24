/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * //@author rafaralahitsimba tiaray
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Timeunit implements Serializable {
    private static final long serialVersionUID = 1L;
    public final static String MOIS ="MOIS"; 
    public final static String AN ="AN"; 
    public final static String JOUR ="JOUR"; 

    private Short id;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String lbl ="";
    

    public Timeunit() {
    }

    public Timeunit(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getLbl() {
        return lbl;
    }

    public void setLbl(String lbl) {
        this.lbl = lbl;
    }

    

   
    
}
