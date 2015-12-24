/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * //
 *
 * @author rafaralahitsimba tiaray
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Instancencours implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Date startdt;
    private Etatjuridique etatcourant;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String refid;
    private Contrat idcontrat;
    private List<Etatjuridique> etatjuridiqueList;

    public Instancencours() {
       
        this.etatcourant = new Etatjuridique();
        this.refid = "";
        this.idcontrat = new Contrat();
        this.etatjuridiqueList = new ArrayList<Etatjuridique>();

    }

    public Date getStartdt() {
        return startdt;
    }

    public void setStartdt(Date startdt) {
        this.startdt = startdt;
    }

    public Etatjuridique getEtatcourant() {
        return etatcourant;
    }

    public void setEtatcourant(Etatjuridique etatcourant) {
        this.etatcourant = etatcourant;
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public Contrat getIdcontrat() {
        return idcontrat;
    }

    public void setIdcontrat(Contrat idcontrat) {
        this.idcontrat = idcontrat;
    }

    //@XmlTransient
    public List<Etatjuridique> getEtatjuridiqueList() {
        return etatjuridiqueList;
    }

    public void setEtatjuridiqueList(List<Etatjuridique> etatjuridiqueList) {
        this.etatjuridiqueList = etatjuridiqueList;
    }

    @Override
    public String toString() {
        return "Instancencours{" + "startdt=" + startdt + ", etatcourant=" + etatcourant + ", refid=" + refid + '}';
    }
    
    
}
