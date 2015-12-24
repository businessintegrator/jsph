/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * //@author rafaralahitsimba tiaray
 */
@XmlType(propOrder={"intervals","idcontrat1"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecutionContrat implements Serializable {
    private static final long serialVersionUID = 1L;
    private Intervals intervals;
    private Contrat idcontrat1;

    public ExecutionContrat() {
      
    this.intervals = new Intervals();
    this.idcontrat1 = new Contrat();
    }

    


    public void setIdintervals(Intervals idintervals) {
        this.intervals = idintervals;
    }

    public Intervals getIdcontrat() {
        return intervals;
    }

    public void setIdcontrat(Intervals idcontrat) {
        this.intervals = idcontrat;
    }

    public Contrat getIdcontrat1() {
        return idcontrat1;
    }

    public void setIdcontrat1(Contrat idcontrat1) {
        this.idcontrat1 = idcontrat1;
    }

}
