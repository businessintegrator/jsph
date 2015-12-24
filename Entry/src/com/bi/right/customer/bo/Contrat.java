/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
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
@XmlType(name="Contrat",propOrder={"rompu",
 "cdi" ,
 "cdd"  ,
 "ecrit",
"id"     ,
"iddm"    ,
"iddf"     ,
 "startdt"  ,
 "enddt"     ,
"nature"      ,
 "convcoll"    ,"cntrIdRules",
 "profession"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer iddm;
    private Integer iddf;
    private Date startdt;
    private Date enddt;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String nature;
    private boolean rompu = false;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String convcoll;
    private boolean cdi = false;
    private boolean cdd = false;
    private boolean ecrit = true;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String profession;
    private Rules cntrIdRules;

    public boolean isCdi() {
        return cdi;
    }

    public void setCdi(boolean cdi) {
        this.cdi = cdi;
    }

    public boolean isCdd() {
        return cdd;
    }

    public void setCdd(boolean cdd) {
        this.cdd = cdd;
    }
   
    

    public Contrat() {
        this.nature = "";
        this.rompu = false;
        this.convcoll = "";
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIddm() {
        return iddm;
    }

    public void setIddm(Integer iddm) {
        this.iddm = iddm;
    }

    public Integer getIddf() {
        return iddf;
    }

    public void setIddf(Integer iddf) {
        this.iddf = iddf;
    }

    public Date getStartdt() {
        return startdt;
    }

    public void setStartdt(Date startdt) {
        this.startdt = startdt;
    }

    public Date getEnddt() {
        return enddt;
    }

    public void setEnddt(Date enddt) {
        this.enddt = enddt;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public boolean getRompu() {
        return rompu;
    }

    public void setRompu(boolean rompu) {
        this.rompu = rompu;
    }

    public String getConvcoll() {
        return convcoll;
    }

    public void setConvcoll(String convcoll) {
        this.convcoll = convcoll;
    }

    public Rules getCntrIdRules() {
        return cntrIdRules;
    }

    public void setCntrIdRules(Rules cntrIdRules) {
        this.cntrIdRules = cntrIdRules;
    }

    @Override
    public String toString() {
        return "Contrat{" + "id=" + id + ", startdt=" + startdt + ", enddt=" + enddt + ", nature=" + nature + ", rompu=" + rompu + ", convcoll=" + convcoll + ", cdi=" + cdi + ", cdd=" + cdd + ", cntrIdRules=" + cntrIdRules + '}';
    }

    public boolean isEcrit() {
        return ecrit;
    }

    public void setEcrit(boolean ecrit) {
        this.ecrit = ecrit;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


    
   
}
