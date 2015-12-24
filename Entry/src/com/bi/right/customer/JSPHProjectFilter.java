/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class JSPHProjectFilter extends FileFilter {

    private final static JSPHProjectFilter instance = new JSPHProjectFilter();

    static JSPHProjectFilter getInstance() {
        return instance;
    }

    @Override
    public boolean accept(File f) {
        return f.isDirectory() || (f != null && f.getName().endsWith(".xjsph"));
    }

    @Override
    public String getDescription() {
        return "JSPH projet";
    }
}
