/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * //@author rafaralahitsimba tiaray
 */
@XmlType(propOrder={"id","description","startdt","idinstance"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Etatjuridique implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String description;
    private Date startdt;
    private Instancencours idinstance;

    public Etatjuridique() {
    }

    public Etatjuridique(Integer id) {
        this.id = id;
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

    public Date getStartdt() {
        return startdt;
    }

    public void setStartdt(Date startdt) {
        this.startdt = startdt;
    }

    public Instancencours getIdinstance() {
        return idinstance;
    }

    public void setIdinstance(Instancencours idinstance) {
        this.idinstance = idinstance;
    }

    @Override
    public String toString() {
        return "Etatjuridique{" + "id=" + id + ", description=" + description + ", startdt=" + startdt + ", idinstance=" + idinstance + '}';
    }

  
}
