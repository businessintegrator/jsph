/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import com.bi.jsph.model.DemandesTableModel;
import com.bi.right.customer.bo.GUIManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
    category = "File",
id = "com.bi.right.customer.JsphAction")
@ActionRegistration(
    displayName = "#CTL_JsphAction")
@ActionReference(path = "Menu/File", position = 1000)
@Messages("CTL_JsphAction=Ouvrir *.jsph")
public final class JsphAction implements ActionListener {

     @Override
    public void actionPerformed(ActionEvent e) {
        com.bi.right.customer.LoaderStorer loaderStorer1 = new LoaderStorer();
  
	 JFileChooser c = new JFileChooser();
        c.setFileFilter(JSPHProjectFilter.getInstance());
        c.setMultiSelectionEnabled(false);
        int res = c.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            try {
		GUIManager gUIManager1 = loaderStorer1.load(c.getSelectedFile());
		DemandesTableModel model = new DemandesTableModel(gUIManager1.getDemandes());
		openTopComponents(model,gUIManager1);
                
                fillText("Vous venez de charger l'affaire : " + gUIManager1.getAffaire() + gUIManager1.getUniqueId());
                
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
                notifyError(ex.getMessage());

            }
        }
    }
    
    private void fillText(final String str) {
        
    }

    private void notifyError(String message) {
         OpenerJDialog.notifyError(message);
    }

    private void openTopComponents(DemandesTableModel model, GUIManager gUIManager1) {
	Set<? extends Mode> modes = WindowManager.getDefault().getModes();
	for (Iterator<? extends Mode> it = modes.iterator(); it.hasNext();) {
	    Mode mode = it.next();
	    TopComponent[] top = WindowManager.getDefault().getOpenedTopComponents(mode);
	    for (int i = 0; i < top.length; i++) {
		TopComponent topComponent = top[i];
		Logger.getLogger("open").info(""+topComponent.getShortName());
		if (topComponent instanceof ProjectTopComponent){
		    ProjectTopComponent prj = (ProjectTopComponent)topComponent;
		    prj.setModel(model);
		    prj.setProject(gUIManager1);
		    prj.init();
		    prj.open();
		}
		if (topComponent instanceof GUIManagerTopComponent){
		    GUIManagerTopComponent gui = (GUIManagerTopComponent)topComponent;
		    GUIManagerTopComponent.getResultList().add(gUIManager1);
		    GUIManagerTopComponent.refreshNode();
		    gui.open();
		}
	    }
	}
    }

}
