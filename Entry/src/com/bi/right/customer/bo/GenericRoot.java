/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author rafaralahitsimba tiaray
 */
@XmlRootElement(name="panel")
@XmlSeeAlso({Conseil.class,Postaladress6.class,Phonenumber.class})
public class GenericRoot<T> {
    
    T internal;

    public T getInternal() {
        return internal;
    }

    public void setInternal(T internal) {
        this.internal = internal;
    }
    
    
    
}
