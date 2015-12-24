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
 * //
 *
 * @author rafaralahitsimba tiaray
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={
  "id"            ,
    "idreconv"     ,
    "iddem"         ,
    "prononceList"})

public class Demanderef implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Demandereconv idreconv;
    private Demande iddem;
    private List<Prononce> prononceList;

    public Demanderef() {
        this.idreconv = new Demandereconv();
        this.prononceList = new ArrayList<Prononce>();
    }

    public Demanderef(Demande iddem) {
	this();
	this.iddem = iddem;
    }

    public Demanderef(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Demandereconv getIdreconv() {
        return idreconv;
    }

    public void setIdreconv(Demandereconv idreconv) {
        this.idreconv = idreconv;
    }

    public Demande getIddem() {
        return iddem;
    }

    public void setIddem(Demande iddem) {
        this.iddem = iddem;
    }

    //@XmlTransient
    public List<Prononce> getPrononceList() {
        return prononceList;
    }

    public void setPrononceList(List<Prononce> prononceList) {
        this.prononceList = prononceList;
    }

    @Override
    public String toString() {
        return "Demanderef{" + "id=" + id + ", idreconv=" + idreconv + ", prononceList=" + prononceList + '}';
    }

   
}
