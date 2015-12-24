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
 * @author rafaralahitsimba tiaray
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class LawEu implements Serializable {
    private static final long serialVersionUID = 1L;
@XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String versionid;
@XmlJavaTypeAdapter(value=CDATAAdapter.class)    
private String descriptipon;
    private Rules lRules;

    public LawEu() {
    }

    public LawEu(String versionid) {
        this.versionid = versionid;
    }

    public String getVersionid() {
        return versionid;
    }

    public void setVersionid(String versionid) {
        this.versionid = versionid;
    }

    public String getDescriptipon() {
        return descriptipon;
    }

    public void setDescriptipon(String descriptipon) {
        this.descriptipon = descriptipon;
    }

    public Rules getLRules() {
        return lRules;
    }

    public void setLRules(Rules lRules) {
        this.lRules = lRules;
    }

    //@Override
    public int hashCode() {
        int hash = 0;
        hash += (versionid != null ? versionid.hashCode() : 0);
        return hash;
    }

    //@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LawEu)) {
            return false;
        }
        LawEu other = (LawEu) object;
        if ((this.versionid == null && other.versionid != null) || (this.versionid != null && !this.versionid.equals(other.versionid))) {
            return false;
        }
        return true;
    }

    //@Override
    public String toString() {
        return "com.bi.jsph.entities.LawEu[ versionid=" + versionid + " ]";
    }
    
}
