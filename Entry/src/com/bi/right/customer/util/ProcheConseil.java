/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class ProcheConseil {
    private String commune;
    private String conseil;
    private String codePostal;

    public ProcheConseil(String commune, String conseil) {
        this.commune = commune;
        this.conseil = conseil;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getConseil() {
        return conseil;
    }

    public void setConseil(String conseil) {
        this.conseil = conseil;
    }

    @Override
    public String toString() {
        return  commune ;
    }

    public String getCodePostal() {
	return this.codePostal;
    }

    public void setCodePostal(String codePostal) {
	this.codePostal = codePostal;
    }
    
    
    
}
