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
 * //
 *
 * @author rafaralahitsimba tiaray
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"id","startdt","creditorrepr","admin"})
public class Redressement implements Serializable {

    private static final long serialVersionUID = 1L;
  
    private Integer id;
    
    private Date startdt;
   
    private Personne creditorrepr;
     private Personne admin;

    public Personne getCreditorrepr() {
        return creditorrepr;
    }

    public void setCreditorrepr(Personne creditorrepr) {
        this.creditorrepr = creditorrepr;
    }

    public Personne getAdmin() {
        return admin;
    }

    public void setAdmin(Personne admin) {
        this.admin = admin;
    }

    public Redressement() {
        this.creditorrepr = new Personne();
        this.admin = new Personne();

    }

    public Redressement(Integer id) {
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

    @Override
    public String toString() {
        return "Redressement{" + "startdt=" + startdt + ", creditorrepr=" + creditorrepr + ", admin=" + admin + '}';
    }

}
