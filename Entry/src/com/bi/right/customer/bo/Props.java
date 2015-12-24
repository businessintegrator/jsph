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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Props implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String tkey;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String tval;
    private Chemindoc idchemin;

    public Props() {
    }

    public Props(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTkey() {
        return tkey;
    }

    public void setTkey(String tkey) {
        this.tkey = tkey;
    }

    public String getTval() {
        return tval;
    }

    public void setTval(String tval) {
        this.tval = tval;
    }

    public Chemindoc getIdchemin() {
        return idchemin;
    }

    public void setIdchemin(Chemindoc idchemin) {
        this.idchemin = idchemin;
    }

   
    
}
