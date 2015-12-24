/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import com.bi.jsph.model.DemandesTableModel;
import com.bi.right.customer.bo.GUIManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
    category = "File",
id = "com.bi.right.customer.OpenAffaireAction")
@ActionRegistration(
    iconBase = "com/bi/right/customer/open16x16.png",
displayName = "#CTL_OpenAffaireAction")
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 1300),
    @ActionReference(path = "Toolbars/File", position = 100),
    @ActionReference(path = "Shortcuts", name = "D-O")
})
@Messages("CTL_OpenAffaireAction=Ouvrir une affaire")
public final class OpenAffaireAction implements ActionListener/*implements Action*/ {
   //private DemandesTableModel model;
   private File template;
   private com.bi.right.customer.LoaderStorer loaderStorer1 = new LoaderStorer();
   
   private Map<String,Object> map = new HashMap<String,Object>();
   private boolean enabled = true;
   private List<PropertyChangeListener> listeners = (List<PropertyChangeListener>) Collections.synchronizedList(new LinkedList<PropertyChangeListener>());

//    public OpenAffaireAction(GUIManager project) {
//	
//	gUIManager1 = project;
//    }
//
//    OpenAffaireAction(List<GUIManager> resultList, GUIManager project) {
//	this(project);
//	if (resultList.contains(project)){
//	}
//    }
   
   

    @Override
    public void actionPerformed(ActionEvent e) {
	GUIManager gUIManager1;
        JFileChooser c = new JFileChooser();
        c.setFileFilter(JSPHProjectFilter.getInstance());
        c.setMultiSelectionEnabled(false);
        int res = c.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            try {

                gUIManager1 = loaderStorer1.load(c.getSelectedFile());
		DemandesTableModel model = new DemandesTableModel(gUIManager1.getDemandes());
		openTopComponents(gUIManager1,model);
                
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

    private void openTopComponents(GUIManager gUIManager1, DemandesTableModel model) {
	ProjectTopComponent top1 = new ProjectTopComponent(gUIManager1, model);
	top1.open();
	Set<? extends Mode> modes = WindowManager.getDefault().getModes();
	for (Iterator<? extends Mode> it = modes.iterator(); it.hasNext();) {
	    Mode mode = it.next();
	    TopComponent[] top = WindowManager.getDefault().getOpenedTopComponents(mode);
	    for (int i = 0; i < top.length; i++) {
		TopComponent topComponent = top[i];
		Logger.getLogger("open").info(""+topComponent.getShortName());
		/*if (topComponent instanceof ProjectTopComponent){
		    ProjectTopComponent prj = (ProjectTopComponent)topComponent;
		    prj.setModel(model);
		    prj.setProject(gUIManager1);
		    prj.init();
		    if (!prj.isOpened()){
		     prj.open();
		    }
		}*/
		if (topComponent instanceof GUIManagerTopComponent){
		    GUIManagerTopComponent gui = (GUIManagerTopComponent)topComponent;
		    GUIManagerTopComponent.getResultList().add(gUIManager1);
		    GUIManagerTopComponent.refreshNode();
		    gui.open();
		}
	    }
	}
    }

    //@Override
    public Object getValue(String key) {
	return map.get(key);
    }

    //@Override
    public void putValue(String key, Object value) {
	map.put(key,value);
    }

    //@Override
    public void setEnabled(boolean b) {
	enabled = b;
    }

    //@Override
    public boolean isEnabled() {
	return true;//enabled;
    }

    //@Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
	listeners.add(listener);
    }

    //@Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
	listeners.remove(listener);
    }

    
    
}
