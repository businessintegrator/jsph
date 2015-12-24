/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import com.bi.right.customer.bo.Defenseur;
import com.bi.right.customer.bo.Personne;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 *
 * @author rafaralahitsimba tiaray
 */
class LegalACT implements ActionListener {

	 private Personne internal;
	 private String label;
	private Dialog dialog;

	public LegalACT(Personne internal,String lbl) {
	    this.internal = internal;
	    this.label = lbl;
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
	    if ("OK".equalsIgnoreCase(e.getActionCommand())){
		if (dialog != null){
		dialog.setVisible(false);
		}
		
	    } else {
		if (dialog != null){
		dialog.setVisible(false);
		}
	    }
	    //NotifyDescriptor nd = new NotifyDescriptor.Message("Vous avez selectionné "+e.getActionCommand()+" pour "+label+" 0x"+Integer.toHexString(internal.hashCode()));
		//DialogDisplayer.getDefault().notify(nd);
		
	}

	public void setDialog(Dialog resDls) {
	    this.dialog = resDls;
	}

	public Dialog getDialog() {
	    return dialog;
	}
	
	 
     }

