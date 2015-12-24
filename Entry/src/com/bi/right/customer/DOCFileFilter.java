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
public class DOCFileFilter extends FileFilter {

    private final static DOCFileFilter instance = new DOCFileFilter();

    static DOCFileFilter getInstance() {
        return instance;
    }

    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().endsWith(".doc"));
    }

    @Override
    public String getDescription() {
        return "Files *.doc";
    }
}
