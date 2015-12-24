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
public class LawCt implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String versionid;
    
    private Rules lRules;

    public LawCt() {
    }

    public LawCt(String versionid) {
        this.versionid = versionid;
    }

    public String getVersionid() {
        return versionid;
    }

    public void setVersionid(String versionid) {
        this.versionid = versionid;
    }

    public Rules getLRules() {
        return lRules;
    }

    public void setLRules(Rules lRules) {
        this.lRules = lRules;
    }

 
    
}
