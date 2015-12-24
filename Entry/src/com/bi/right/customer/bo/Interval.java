/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * //@author rafaralahitsimba tiaray
 */
@XmlType(propOrder={"startdt","enddt","intervalsList"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Interval implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Date startdt;
    private Date enddt;
    private List<Intervals> intervalsList;

    public Interval() {
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

    public List<Intervals> getIntervalsList() {
        return intervalsList;
    }

    public void setIntervalsList(List<Intervals> intervalsList) {
        this.intervalsList = intervalsList;
    }

  
    
}
