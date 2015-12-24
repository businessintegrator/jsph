/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import com.bi.jsph.model.DemandesTableModel;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.panel.AbstractPanel;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.ActionMap;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle.Messages;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.RequestProcessor;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
    dtd = "-//com.bi.right.customer//GUIManager//EN",
autostore = false)
@TopComponent.Description(
    preferredID = "GUIManagerTopComponent",
iconBase = "com/bi/right/customer/jsph16x16.png",
persistenceType = TopComponent.PERSISTENCE_NEVER)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "com.bi.right.customer.GUIManagerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_GUIManagerAction",
preferredID = "GUIManagerTopComponent")
@Messages({
    "CTL_GUIManagerAction=Liste d'Affaires",
    "CTL_GUIManagerTopComponent=Liste d'Affaires",
    "HINT_GUIManagerTopComponent=Liste d'Affaires"
})
public final class GUIManagerTopComponent extends TopComponent implements ExplorerManager.Provider {

    private static final List<GUIManager> resultList = new LinkedList<GUIManager>();
    private static Map<String, AbstractPanel> wizards;
    public static final String NB_AFFAIRE = "nbAffaireJsph";
    public static final String AFFAIRE = "AffaireJsph";
    public static final String AFFAIRES = "affairesJsph";

    public static Map<String, AbstractPanel> getWizards() {
	return wizards;
    }

    public static List<GUIManager> getResultList() {
	return resultList;
    }
    private static ExplorerManager em = new ExplorerManager();

    static void refreshNode() {
	//if (em.getRootContext() == null){
	  em.setRootContext(new AffaireNode(Children.create(new AffaireChildFactory(resultList), true)));
	//} else {
	//    Node rootCtx = em.getRootContext();
	//    Children children = rootCtx.getChildren();

	    
	//}
}

    public GUIManagerTopComponent() {
	initComponents();
	setName(Bundle.CTL_GUIManagerTopComponent());
	setToolTipText(Bundle.HINT_GUIManagerTopComponent());
	ActionMap map = this.getActionMap();
	map.put("delete", ExplorerUtils.actionDelete(em, true)); //NOI18N

	PropertyChangeListener property = new PropertyChangeListener() {
	    @Override
	    public void propertyChange(PropertyChangeEvent evt) {
		
		Object newValue = evt.getNewValue();
		if (newValue == null) {
		    return;
		}
		//save old value
		//laod new value
		if (newValue instanceof com.bi.right.customer.AffaireNode) {
		    com.bi.right.customer.AffaireNode nodeAf = (com.bi.right.customer.AffaireNode) newValue;
		    Lookup thelookup = nodeAf.getLookup();
		    if (thelookup == null) {
			thelookup = getLookup();
		    }
		    Object objFoundNode = thelookup.lookup(GUIManager.class);
		    if (objFoundNode == null) {
			NotifyDescriptor nd = new NotifyDescriptor.Message("Pas d'affaire trouvé dans le noeud "+evt.getPropertyName());
			DialogDisplayer.getDefault().notify(nd);
			return;

		    }

		    Object objFound = getLookup().lookup(GUIManager.class);
		    if (objFound == null) {
			NotifyDescriptor nd = new NotifyDescriptor.Message("Pas d'affaire trouvé");
			DialogDisplayer.getDefault().notify(nd);
			return;
		    }
		    GUIManager guimanger = (GUIManager) objFound;
		    // private void openTopComponents() {
		    Set<? extends Mode> modes = WindowManager.getDefault().getModes();
		    for (Iterator<? extends Mode> it = modes.iterator(); it.hasNext();) {
			Mode mode = it.next();
			TopComponent[] top = WindowManager.getDefault().getOpenedTopComponents(mode);
			for (int i = 0; i < top.length; i++) {
			    TopComponent topComponent = top[i];
			    Logger.getLogger("open").info("" + topComponent.getShortName());
			    if (topComponent instanceof ProjectTopComponent) {
				ProjectTopComponent prj = (ProjectTopComponent) topComponent;

				prj.setModel(new DemandesTableModel(guimanger.getDemandes()));
				prj.setProject(guimanger);
				prj.init();
				if (!prj.isOpened()) {
				    prj.open();
				}
			    }
			    /*if (topComponent instanceof GUIManagerTopComponent){
			     GUIManagerTopComponent gui = (GUIManagerTopComponent)topComponent;
			     GUIManagerTopComponent.getResultList().add(gUIManager1);
			     GUIManagerTopComponent.refreshNode();
			     gui.open();
			     }**/
			    // }
			}
		    }
		}
		Logger.getLogger("GUIManagerTopComponent").info(" new value " + newValue);
	    }
	};
	//map.put("copy", ExplorerUtils.actionCopy(em)); //NOI18N
	//map.put("paste", ExplorerUtils.actionPaste(em)); //NOI18N
	em.addPropertyChangeListener(property);
	associateLookup(ExplorerUtils.createLookup(em, map));
	RequestProcessor.getDefault().post(new Runnable() {
	    @Override
	    public void run() {
		readGuiManager();
	    }
	});
	beanTreeView1.setBackground(Color.yellow);
    }

    private void readGuiManager() {
	em.setRootContext(new AffaireNode(Children.create(new AffaireChildFactory(resultList), true)));
    }

    @Override
    protected void componentActivated() {
	super.componentActivated();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
	super.writeExternal(out);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
	super.readExternal(in);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beanTreeView1 = new org.openide.explorer.view.BeanTreeView();

        setLayout(new java.awt.BorderLayout());

        beanTreeView1.setBackground(new java.awt.Color(153, 153, 153));
        beanTreeView1.setToolTipText(org.openide.util.NbBundle.getMessage(GUIManagerTopComponent.class, "GUIManagerTopComponent.beanTreeView1.toolTipText")); // NOI18N
        beanTreeView1.setAutoWaitCursor(true);
        beanTreeView1.setAutoscrolls(true);
        beanTreeView1.setDoubleBuffered(true);
        beanTreeView1.setFont(beanTreeView1.getFont().deriveFont(beanTreeView1.getFont().getStyle() | java.awt.Font.BOLD, beanTreeView1.getFont().getSize()+1));
        add(beanTreeView1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openide.explorer.view.BeanTreeView beanTreeView1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
	try {
	    Preferences userPreferences = java.util.prefs.Preferences.userRoot().node(AFFAIRES);

	    int size = userPreferences.getInt(NB_AFFAIRE, 0);
	    //resultList.clear();
	    for (int i = 0; i < size; i++) {
		LoaderStorer loader = new LoaderStorer();
		File f = new File(userPreferences.get(AFFAIRE + i, ""));
		if (f.exists()) {
		    resultList.add(loader.load(f));
		}
	    }

	} catch (Exception e) {
	    Exceptions.printStackTrace(e);
	}

    }

    @Override
    public void componentClosed() {
	try {
	    NotifyDescriptor.Confirmation message = new NotifyDescriptor.Confirmation("Voulez-vous enregistrer?",
		    NotifyDescriptor.OK_CANCEL_OPTION,
		    NotifyDescriptor.QUESTION_MESSAGE);

	    Object result = DialogDisplayer.getDefault().notify(message);

	    //When user clicks "Yes", indicating they really want to save,
	    //we need to disable the Save button and Save menu item,
	    //so that it will only be usable when the next change is made
	    //to the text field:
	    if (NotifyDescriptor.YES_OPTION.equals(result)) {

		Preferences userPreferences = java.util.prefs.Preferences.userRoot().node(AFFAIRES);
		int i = 0;
		userPreferences.putInt(NB_AFFAIRE, resultList.size());
		 LoaderStorer loader = new LoaderStorer();
		for (GUIManager gUIManager : resultList) {
		   
		    loader.store(gUIManager, gUIManager.getPath());
		    userPreferences.put(AFFAIRE + i, gUIManager.getPath());
		    i++;
		}
	    }
	} catch (Exception e) {
	    Exceptions.printStackTrace(e);
	}
    }

    void writeProperties(java.util.Properties p) {
	// better to version settings since initial version as advocated at
	// http://wiki.apidesign.org/wiki/PropertyFiles
	p.setProperty("version", "1.0");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
	p.setProperty("date", sdf.format(new Date()));
	// TODO store your settings
    }

    void readProperties(java.util.Properties p) {
	try {
	    String version = p.getProperty("version");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
	    String lastDate = p.getProperty("date");
	    if (lastDate != null) {
		Date lastUse = sdf.parse(lastDate);
	    }
	    // TODO read your settings according to their version
	} catch (ParseException ex) {
	    Exceptions.printStackTrace(ex);
	}
    }

    @Override
    public ExplorerManager getExplorerManager() {
	return em;
    }
}
