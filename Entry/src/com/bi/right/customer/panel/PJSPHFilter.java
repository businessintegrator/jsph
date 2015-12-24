/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class PJSPHFilter implements FileFilter{
    
    private static PJSPHFilter instance;

    public static PJSPHFilter getInstance() {
        if (instance == null){
            instance = new PJSPHFilter();
        }
        return instance;
    }
    
    public PJSPHFilter() {
        super();
    }

    
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".pjsph");
    }
    
}
