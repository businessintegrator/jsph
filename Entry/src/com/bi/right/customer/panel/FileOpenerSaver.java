/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class FileOpenerSaver {

    
    private Component parent;
    private static JFileChooser chooser;

    public FileOpenerSaver(Component parent) {
	this.parent = parent;
	chooser = new JFileChooser();
	chooser.setAcceptAllFileFilterUsed(true);
	
	chooser.setFileFilter(new FileFilter() {
	    @Override
	    public boolean accept(File f) {
		if (f == null){return false;}
		boolean result = f.isDirectory() || f.getName().endsWith(".demandes");
		
		
		return result;
	    }

	    @Override
	    public String getDescription() {
		return "Fichiers de demandes *.demandes";
	    }
	});
    }

    public File openPropertiesFile(Properties p) {
	File result = null;
	
	int res = chooser.showOpenDialog(parent);
	if (res == JFileChooser.APPROVE_OPTION) {
	    result = chooser.getSelectedFile();
	    if (result != null) {
		//projectRoot = result.getParentFile();
		InputStream in;
		try {
		    in = new FileInputStream(result);
		    p.load(in);
		    in.close();

		} catch (Exception ex) {
		    Exceptions.printStackTrace(ex);
		    NotifyDescriptor msg = new NotifyDescriptor.Message("Ouverture de modeles", NotifyDescriptor.Message.WARNING_MESSAGE);
		    DialogDisplayer.getDefault().notify(msg);
		}
	    } else {
		NotifyDescriptor msg = new NotifyDescriptor.Message("Fichier invalide:" + result, NotifyDescriptor.Message.WARNING_MESSAGE);
		DialogDisplayer.getDefault().notify(msg);
	    }

	}
	return result;
    }

    public void savePropertiesFile(Properties p) {
	
	int res = chooser.showSaveDialog(parent);
	if (res == JFileChooser.APPROVE_OPTION) {
	    OutputStream out;
	    try {
		File f2save = chooser.getSelectedFile();
		if (!f2save.getName().endsWith(".demandes")) {
		    f2save= new File(f2save.getPath() + ".demandes");
		}
		out = new FileOutputStream(f2save);
		p.store(out, "" + new Date());
		out.close();
	    } catch (Exception ex) {
		Exceptions.printStackTrace(ex);
		NotifyDescriptor msg = new NotifyDescriptor.Message("Sauvegarde de modeles", NotifyDescriptor.Message.WARNING_MESSAGE);
		DialogDisplayer.getDefault().notify(msg);
	    }
	}

    }
}
