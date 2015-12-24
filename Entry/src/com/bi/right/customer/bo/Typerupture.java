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
//@Entity
//@Table(catalog = "", schema = "AAAAAAAA")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"id"  ,
 "description",
"motif"        ,
"idcontrat"     ,
"fne"            ,
 "dispensePreavis",
"nbMoispreavis"})
public class Typerupture implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String description="";
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String motif="";
    private int idcontrat;
    private boolean fne =false;
    private boolean dispensePreavis = false;
    private int nbMoispreavis = 0;

    public boolean isFne() {
        return fne;
    }

    public void setFne(boolean fne) {
        this.fne = fne;
    }

    public Typerupture() {
    }

    public Typerupture(Integer id) {
        this.id = id;
    }

    public Typerupture(Integer id, int idcontrat) {
        this.id = id;
        this.idcontrat = idcontrat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public int getIdcontrat() {
        return idcontrat;
    }

    public void setIdcontrat(int idcontrat) {
        this.idcontrat = idcontrat;
    }

    //@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    //@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typerupture)) {
            return false;
        }
        Typerupture other = (Typerupture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Typerupture{" + "description=" + description + ", motif=" + motif + ", idcontrat=" + idcontrat + ", fne=" + fne + '}';
    }

    public boolean isDispensePreavis() {
	return dispensePreavis;
    }

    public void setDispensePreavis(boolean dispensePreavis) {
	this.dispensePreavis = dispensePreavis;
    }

    public int getNbMoispreavis() {
	return nbMoispreavis;
    }

    public void setNbMoispreavis(int nbMoispreavis) {
	this.nbMoispreavis = nbMoispreavis;
    }

   
    
}
