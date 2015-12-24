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
 * //
 *
 * @author rafaralahitsimba tiaray
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Prononce implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String description;
    private Double amount;
    private Demanderef demanderef;

    public Prononce() {
        this.description = "";
        this.amount = new Double(0);
        this.demanderef = new Demanderef();
    }

    public Prononce(Integer id) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Demanderef getDemanderef() {
        return demanderef;
    }

    public void setDemanderef(Demanderef demanderef) {
        this.demanderef = demanderef;
    }

    @Override
    public String toString() {
        return "Prononce{" + "description=" + description + ", amount=" + amount + ", demanderef=" + demanderef + '}';
    }

   
}
