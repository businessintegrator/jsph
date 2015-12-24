/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import java.util.ArrayList;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * 
 *
 * @author rafaralahitsimba tiaray
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Situation implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Double pourcentage;
    private Double presence;
    private Double salaire;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String description;
    private ArrayList<Intervals> intervalsList;

    public Situation() {
        this.pourcentage = new Double(100);
        this.presence = new Double(0);
        this.salaire = new Double(0);
        this.description = "";
        this.intervalsList = new ArrayList<Intervals>();
    }

    public Situation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Double getPresence() {
        return presence;
    }

    public void setPresence(Double presence) {
        this.presence = presence;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //@XmlTransient
    public ArrayList<Intervals> getIntervalsList() {
        return intervalsList;
    }

    public void setIntervalsList(ArrayList<Intervals> intervalsList) {
        this.intervalsList = intervalsList;
    }

    @Override
    public String toString() {
        return "Situation{" + "pourcentage=" + pourcentage + ", presence=" + presence + ", salaire=" + salaire + ", description=" + description + ", intervalsList=" + intervalsList + '}';
    }

  
}
