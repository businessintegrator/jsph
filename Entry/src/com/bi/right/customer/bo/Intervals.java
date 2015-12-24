/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * //@author rafaralahitsimba tiaray
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Intervals implements Serializable {
    private static final long serialVersionUID = 1L;
   @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String descript;
    private List<ExecutionContrat> executionContratList;
    private Situation idsituation;
    private Interval idinterval;

    public Intervals() {
    }

    
    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    //@XmlTransient
    public List<ExecutionContrat> getExecutionContratList() {
        return executionContratList;
    }

    public void setExecutionContratList(List<ExecutionContrat> executionContratList) {
        this.executionContratList = executionContratList;
    }

    public Situation getIdsituation() {
        return idsituation;
    }

    public void setIdsituation(Situation idsituation) {
        this.idsituation = idsituation;
    }

    public Interval getIdinterval() {
        return idinterval;
    }

    public void setIdinterval(Interval idinterval) {
        this.idinterval = idinterval;
    }

    
    
}
