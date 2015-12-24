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
 * @author rafaralahitsimba tiaray
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class ObjetLitige implements Serializable {
    private static final long serialVersionUID = 1L;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
