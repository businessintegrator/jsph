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
public class Convcoll implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String nm;
    
    private Rules cIdRules;

    public Convcoll() {
        nm ="";
    }

    public Convcoll(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public Rules getCIdRules() {
        return cIdRules;
    }

    public void setCIdRules(Rules cIdRules) {
        this.cIdRules = cIdRules;
    }

    //@Override

    @Override
    public String toString() {
        return "Convcoll{" + "id=" + id + ", nm=" + nm + ", cIdRules=" + cIdRules + '}';
    }
  
    
}
