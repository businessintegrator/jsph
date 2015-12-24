/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;
import com.bi.jsph.gn.WrapperOne;
import com.bi.jsph.model.DemandesTableModel;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.panel.AbstractPanel;
import com.bi.right.customer.panel.DemandesJPanel;
import com.bi.right.customer.panel.PermissionJPanel;
import com.bi.right.customer.panel.SaisineJPanel;
import com.bi.right.customer.panel.SalarieDefendeurJPanel;
import com.bi.right.customer.panel.SalarieDemandeurJPanel;
import com.bi.right.customer.panel.SocieteDefendeurJPanel;
import com.bi.right.customer.panel.SocieteDemandeurJPanel;
import java.awt.HeadlessException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.Exceptions;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class OpenerJDialog extends javax.swing.JDialog {

    private WrapperOne w = null;
    final static int CONCLUSION = 4;
    final static int SAISINE = 2;
    final static int DEMANDEUR = 0;
    final static int DEFENDEUR = 1;
    private List<AbstractPanelRef> wizardList = new ArrayList<AbstractPanelRef>();
    private AbstractPanel panel = null;
    HelpMouseListener helpMouseListener = null;

    public OpenerJDialog() {
	 w = new WrapperOne();
    }

    /**
     * Creates new form FieChooserJDialog
     */
    public OpenerJDialog(java.awt.Frame parent, boolean modal) {
	super(parent, modal);
	panel = new PermissionJPanel(this);
	panel.setHelpEditor(this);
	helpMouseListener = new HelpMouseListener(this);
	initComponents();
	parentRoot = new GUIManager();
	demandes = new DemandesTableModel();
	refreshViewportView();
    }

    /**
     * Creates new form FieChooserJDialog
     */
    public OpenerJDialog(java.awt.Frame parent, boolean modal, GUIManager theMgr, DemandesTableModel pdemandes) {
	super(parent, modal);
	panel = new PermissionJPanel(this);
	panel.setHelpEditor(this);
	helpMouseListener = new HelpMouseListener(this);
	initComponents();
	parentRoot = theMgr;
	demandes = pdemandes;
	refreshViewportView();
    }

    static void notifyError(String errormessage) {
	NotifyDescriptor.Confirmation message = new NotifyDescriptor.Confirmation(errormessage, NotifyDescriptor.ERROR_MESSAGE);
	DialogDisplayer.getDefault().notify(message);


    }
    private GUIManager parentRoot = null;
    private DemandesTableModel demandes = null;

    public GUIManager getParentRoot() {
	return parentRoot;
    }

    public void setParentRoot(GUIManager parentRoot) {
	this.parentRoot = parentRoot;
    }

    public DemandesTableModel getDemandes() {
	return demandes;
    }

    public void setDemandes(DemandesTableModel demandes) {
	this.demandes = demandes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneCenter = new javax.swing.JScrollPane();
        jPanelSouth = new javax.swing.JPanel();
        jButtonPrevious = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonOkFin = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jLicense = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setPreferredSize(new java.awt.Dimension(1500, 600));
        getContentPane().add(jScrollPaneCenter, java.awt.BorderLayout.CENTER);

        org.openide.awt.Mnemonics.setLocalizedText(jButtonPrevious, org.openide.util.NbBundle.getMessage(OpenerJDialog.class, "OpenerJDialog.jButtonPrevious.text_1")); // NOI18N
        jButtonPrevious.setEnabled(false);
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });
        jPanelSouth.add(jButtonPrevious);

        org.openide.awt.Mnemonics.setLocalizedText(jButtonNext, org.openide.util.NbBundle.getMessage(OpenerJDialog.class, "OpenerJDialog.jButtonNext.text")); // NOI18N
        jButtonNext.setEnabled(false);
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });
        jPanelSouth.add(jButtonNext);

        org.openide.awt.Mnemonics.setLocalizedText(jButtonCancel, org.openide.util.NbBundle.getMessage(OpenerJDialog.class, "OpenerJDialog.jButtonCancel.text")); // NOI18N
        jButtonCancel.setEnabled(false);
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanelSouth.add(jButtonCancel);

        org.openide.awt.Mnemonics.setLocalizedText(jButtonOkFin, org.openide.util.NbBundle.getMessage(OpenerJDialog.class, "OpenerJDialog.jButtonOkFin.text")); // NOI18N
        jButtonOkFin.setEnabled(false);
        jButtonOkFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkFinActionPerformed(evt);
            }
        });
        jPanelSouth.add(jButtonOkFin);

        jEditorPane1.setBorder(null);
        jEditorPane1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jEditorPane1.setToolTipText(org.openide.util.NbBundle.getMessage(OpenerJDialog.class, "OpenerJDialog.jEditorPane1.toolTipText")); // NOI18N
        jEditorPane1.setDoubleBuffered(true);
        jEditorPane1.setSelectionColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(jEditorPane1);

        jPanelSouth.add(jScrollPane2);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(OpenerJDialog.class, "OpenerJDialog.jLabel1.text")); // NOI18N
        jPanelSouth.add(jLabel1);

        jLicense.setBackground(new java.awt.Color(255, 255, 51));
        org.openide.awt.Mnemonics.setLocalizedText(jLicense, org.openide.util.NbBundle.getMessage(OpenerJDialog.class, "OpenerJDialog.jLicense.text")); // NOI18N
        jLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLicenseActionPerformed(evt);
            }
        });
        jPanelSouth.add(jLicense);

        getContentPane().add(jPanelSouth, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
	if (doNext()) {
	    return;
	}
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed

	if (panel != null && panel.getPrevious() != null) {
	    panel.removeMouseLstnr(this.helpMouseListener);
	    panel = panel.getPrevious();
	    panel.addMouseLstnr(this.helpMouseListener);
	    refreshViewportView();
	} else if (panel != null && panel.getPrevious() == null) {
	    jButtonPrevious.setEnabled(false);
	} else if (panel == null) {
	}


    }//GEN-LAST:event_jButtonPreviousActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
	setVisible(false);
	parentRoot = null;
	demandes = null;

	dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonOkFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkFinActionPerformed
	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		saveProject();
		fillProject();
	    }});

    }//GEN-LAST:event_jButtonOkFinActionPerformed

    private void jLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLicenseActionPerformed
	//load l
	JFileChooser license = new JFileChooser();
	int opened = license.showOpenDialog(this);
	if(opened == JFileChooser.APPROVE_OPTION){
	    try {
		File licfile = license.getSelectedFile();
		w.load(new URL[]{licfile.toURI().toURL()});
		w.proceed();
	    } catch (MalformedURLException ex) {
		Exceptions.printStackTrace(ex);
	    }
	}
	
    }//GEN-LAST:event_jLicenseActionPerformed

		
    
private void fillProject() {
		Set<? extends Mode> modes = WindowManager.getDefault().getModes();
		for (Iterator<? extends Mode> it = modes.iterator(); it.hasNext();) {
		    Mode mode = it.next();
		    TopComponent[] top = WindowManager.getDefault().getOpenedTopComponents(mode);
		    for (int i = 0; i < top.length; i++) {
			TopComponent topComponent = top[i];
//                        Logger.getLogger("open").info(""+topComponent.getShortName());
			if (topComponent instanceof ProjectTopComponent) {
			    ProjectTopComponent prj = (ProjectTopComponent) topComponent;
			    prj.setModel(demandes);
			    prj.setProject(parentRoot);
			    prj.init();
			    prj.open();
			    prj.fillWizardList(getWizardList());
			    return;
			}
		    }
		}
	    }

	    private void saveProject() throws HeadlessException {
		GUIManagerTopComponent.getResultList().add(parentRoot);
		parentRoot.setDemandes(demandes.filterSelected());
		setVisible(false);
		GUIManagerTopComponent.refreshNode();

		LoaderStorer loader = new LoaderStorer();
		File project = new File(parentRoot.getPath());
		NotifyDescriptor fdd = new NotifyDescriptor.Message("Sauvegarde de" + Integer.toHexString(parentRoot.hashCode()) + " " + parentRoot.getPath());
		DialogDisplayer.getDefault().notify(fdd);
		try {
		    loader.store(parentRoot, project);
		} catch (Exception ex) {
		    Exceptions.printStackTrace(ex);
		    notifyError("Problème de sauvegarde de l'affaire " + project.getPath());

		}
	    }
	
	    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {

		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(OpenerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(OpenerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(OpenerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(OpenerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the dialog */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		OpenerJDialog dialog = new OpenerJDialog(new javax.swing.JFrame(), true);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		    }
		});
		dialog.setVisible(true);
	    }
	});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonOkFin;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jLicense;
    private javax.swing.JPanel jPanelSouth;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneCenter;
    // End of variables declaration//GEN-END:variables

    private void refreshViewportView() {
	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		if (panel != null) {
		    if ((panel instanceof SaisineJPanel)) {
			jButtonNext.setEnabled(false);
		    } else {
			jButtonNext.setEnabled(panel.isNextPossible());
		    }
		    jScrollPaneCenter.setViewportView(panel);
		}
	    }
	});

    }

    public void fillEditorText(final String atext) {
	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		jEditorPane1.setText(atext);
	    }
	});

    }

    public void enableNext() {
	if (panel.isNextPossible()) {
	    SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
		    jButtonNext.setEnabled(true);
		}
	    });

	}
    }

    public void setNextEnable(boolean b) {
	if (b) {
	    enableNext();
	}
    }

    private boolean doNext() {
	AbstractPanel previous = null;
	try {
	    if (panel == null) {
		jButtonNext.setEnabled(false);
		jButtonOkFin.setEnabled(true);
		return true;
	    }
	    panel.setHelpEditor(this);
	    if (parentRoot == null) {
		setParentRoot(parentRoot);
		parentRoot = new GUIManager();
	    }
	    panel.setParentRoot(parentRoot);
	    panel.setDemandes(demandes);
	    previous = panel;
	    previous.removeMouseLstnr(this.helpMouseListener);
	    panel = panel.getNext();
	    jButtonPrevious.setEnabled(!(previous == null));
	    panel.setHelpEditor(this);
	    panel.setParentRoot(parentRoot);
	    panel.setDemandes(demandes);
	    panel.setPrevious(previous);
	    panel.addMouseLstnr(this.helpMouseListener);
	    jButtonNext.setEnabled(panel.isNextPossible());
	    panel.setNextButton(jButtonNext);
	    jButtonOkFin.setEnabled((panel instanceof SaisineJPanel));
	    refreshViewportView();
	} catch (Exception e) {
	    Exceptions.printStackTrace(e);
	}
	return false;
    }

    public List<AbstractPanelRef> getWizardList() {
	return wizardList;
    }

    public void setWizardList(List<AbstractPanelRef> wizardList) {
	this.wizardList = wizardList;
    }

    void gotoTheStep(int step) {
	switch (step) {
	    case CONCLUSION:
		while (!(panel instanceof DemandesJPanel)) {
		    doNext();
		}
		break;
	    case SAISINE:
		while (!(panel instanceof SaisineJPanel)) {
		    doNext();
		}
		break;
	    case DEMANDEUR:
		while (!((panel instanceof SalarieDemandeurJPanel) || (panel instanceof SocieteDemandeurJPanel))) {
		    doNext();
		}
		break;
	    case DEFENDEUR:
		while (!((panel instanceof SalarieDefendeurJPanel) || (panel instanceof SocieteDefendeurJPanel))) {
		    doNext();
		}
		break;
	    default:
	}
    }
}
