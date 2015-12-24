/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaralahitsimba tiaray
 */
@XmlRootElement(name="rule")
public class LawDisplay {
 
    private String code;
 
    private String nm;
  
    private String art;

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getNm() {
	return nm;
    }

    public void setNm(String nm) {
	this.nm = nm;
    }

    public String getArt() {
	return art;
    }

    public void setArt(String art) {
	this.art = art;
    }
    
    
}
