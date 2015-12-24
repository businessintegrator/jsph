/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.calendar.dlg;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class ActDates implements ActionListener{
    public static String Annuler = "Annuler";
    public static String Choisir = "Ok";
    private Dialog dlg;
    private final JPanelDates panel;

    public ActDates(JPanelDates datePanel) {
	this.panel = datePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (Choisir.equals(e.getActionCommand())){
	    this.panel.fillDate();
	}
	if (dlg != null){
	   dlg.dispose();
	   dlg = null;
	}
    }

    public void setDlg(Dialog dc) {
	this.dlg = dc;
    }

    public Dialog getDlg() {
	return dlg;
    }
    
    
    
}
