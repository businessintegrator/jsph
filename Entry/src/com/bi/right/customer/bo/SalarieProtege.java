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
public class SalarieProtege implements Serializable {
    private static final long serialVersionUID = 1L;
   
   
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String description ="";
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String ref="";
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String versionid="";

    public SalarieProtege() {
    }

  

    public SalarieProtege( String versionid) {
      
        this.versionid = versionid;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getVersionid() {
        return versionid;
    }

    public void setVersionid(String versionid) {
        this.versionid = versionid;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 59 * hash + ((this.description == null)?0:1);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final SalarieProtege other = (SalarieProtege) obj;
	return true;
    }

    

   
}
