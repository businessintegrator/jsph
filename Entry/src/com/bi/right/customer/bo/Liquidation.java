/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * //@author rafaralahitsimba tiaray
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"id","startdt","liquidateur"})
public class Liquidation implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Date startdt;
    private Personne liquidateur;

    public Liquidation() {
        liquidateur = new Personne();
    }

    public Liquidation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartdt() {
        return startdt;
    }

    public void setStartdt(Date startdt) {
        this.startdt = startdt;
    }

    public Personne getLiquidateur() {
        return liquidateur;
    }

    public void setLiquidateur(Personne liquidateur) {
        this.liquidateur = liquidateur;
    }

    @Override
    public String toString() {
        return "Liquidation{" + "id=" + id + ", startdt=" + startdt + ", liquidateur=" + liquidateur + '}';
    }

    
}
