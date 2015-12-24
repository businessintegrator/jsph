/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.cities.dlg;

import com.bi.right.customer.LoaderStorer;
import com.bi.right.customer.bo.Conseil;
import com.bi.right.customer.panel.sub.CitiesJPanel;
import com.bi.right.customer.util.GlobalParameters;
import com.bi.right.customer.util.ProcheConseil;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class ActCities implements ActionListener {
    public static final String Annuler = "Annuler";
    public static final String Choisir = "Choisir";
    
    private  Dialog dlg;
    private final CitiesJPanel citiesJPaneljtable;
    private Conseil conseilSelected;

   

    public ActCities(CitiesJPanel citiespanel) {
	this.citiesJPaneljtable = citiespanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	try {
	    if (Choisir.equals(e.getActionCommand())){
	    ProcheConseil selectedOne = (ProcheConseil)this.citiesJPaneljtable.getSelectedValue();
	    LoaderStorer l = new LoaderStorer();
	    InputStream in = GlobalParameters.class.getClassLoader().getResourceAsStream(selectedOne.getConseil());
	    Conseil conseilFound = l.loadConseil(in);
            setConseilSelected(conseilFound);
	    }
	    this.dlg.dispose();
	} catch (Exception ex) {
	    Exceptions.printStackTrace(ex);
	}
    }

    public void setDlg(Dialog dlg) {
	this.dlg = dlg;
    }

    public Dialog getDlg() {
	return dlg;
    }

    private void setConseilSelected(Conseil conseilFound) {
	this.conseilSelected = conseilFound;
    }

    public Conseil getConseilSelected() {
	return conseilSelected;
    }
    
    
}
