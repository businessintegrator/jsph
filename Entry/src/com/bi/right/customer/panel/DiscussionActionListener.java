/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import com.bi.right.customer.bo.Demande;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
class DiscussionActionListener implements ActionListener {

    private File currentDiscussionDir = null;
    static String Annuler = "Annuler";
    static String Ajouter = "OK";
    private Dialog dialogInternal;
    private Demande demande;
    private Document argFait = null;

   
    DiscussionActionListener(String path, Document document, Demande dem1) {
	this.currentDiscussionDir = new File(path).getParentFile();
	this.argFait = document;
	this.demande = dem1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (Annuler.compareTo(e.getActionCommand()) == 0) {
	} else if (Ajouter.compareTo(e.getActionCommand()) == 0) {
	    saveDiscussion();
	}
	if (dialogInternal != null) {
	    dialogInternal.dispose();
	}

    }

    void setDialogInternal(Dialog dialog) {
	this.dialogInternal = dialog;
    }

    public Dialog getDialogInternal() {
	return dialogInternal;
    }

  

    public Demande getDemande() {
	return demande;
    }

    public Document getArgFait() {
	return argFait;
    }

    

    private void saveDiscussion() {
	try {
	    
	
	File file = null;
	if (demande.isArgumented() && (demande.getArgumentationPath() != null)) {
	    file = new File(demande.getArgumentationPath());
	} else {
	    demande.setArgumented(true);
	    file = new File(currentDiscussionDir.getPath() + "/" + Long.toHexString(System.currentTimeMillis()) + ".djsph");
	}
	demande.setArgumentationPath(file.getPath());
	Parallel p = new Parallel(argFait, file);
	p.run();
	
	} catch (Exception e) {
	    Exceptions.printStackTrace(e);
	}
    }

    void save() {
	saveDiscussion();
    }
}
