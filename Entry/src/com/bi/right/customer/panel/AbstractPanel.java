/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import com.bi.jsph.model.DemandesTableModel;
import com.bi.right.customer.HelpMouseListener;
import com.bi.right.customer.LoaderStorer;
import com.bi.right.customer.OpenerJDialog;
import com.bi.right.customer.bo.Defenseur;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.bo.Personne;
import com.bi.right.customer.panel.sub.DefenseurJPanel;
import com.bi.right.customer.panel.sub.RepresentantLegalJPanel;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public abstract class AbstractPanel extends JPanel implements Undoable {

    private static Logger logger = Logger.getLogger("AbstractPanel");
    private boolean wizardMode = true;
    private DemandesTableModel demandes;
    private AbstractPanel previous;
    private AbstractPanel next;
    protected GUIManager parentRoot;
    private JDialog parentDialog;
    private OpenerJDialog helpEditor;
    private ItemListener internalChk;
    private JTextArea offLineHelpEditor;
    private WeakReference nextButton = null;

    public AbstractPanel() {
    }

    public AbstractPanel(GUIManager root) {
	this.parentRoot = root;
    }

    public AbstractPanel(DemandesTableModel demandes) {
	this.demandes = demandes;
    }

    public void setOffLineHelpEditor(JTextArea jTextArea1) {
	this.offLineHelpEditor = jTextArea1;
    }

    public JTextArea getOffLineHelpEditor() {
	return offLineHelpEditor;
    }

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

    public AbstractPanel getPrevious() {
	return previous;
    }

    public void setPrevious(AbstractPanel previous) {
	this.previous = previous;
    }

    public AbstractPanel getNext() {
	return next;
    }

    public void setNext(AbstractPanel nextPanel) {
	this.next = nextPanel;
	if (this.next != null) {
	    this.next.setPrevious(this);
	}
    }

    public JDialog getParentDialog() {
	return parentDialog;
    }

    public void setParentDialog(JDialog parentDialog) {
	this.parentDialog = parentDialog;
    }

    public abstract void initJComponents();

    public void removeMouseLstnr(HelpMouseListener helpMouseListener) {
	/*  List<Binding> bindings = getBindingGroup().getBindings();
	 for (Iterator<Binding> it = bindings.iterator(); it.hasNext();) {
	 Binding binding = it.next();
	 if (binding != null) {
	 Object component = binding.getSourceObject();
	 if (component instanceof JComponent) {
	 ((JComponent) component).removeMouseListener(helpMouseListener);
	 }
	 }


	 }*/
    }

    public void addMouseLstnr(HelpMouseListener helpMouseListener) {
	/*  List<Binding> bindings = getBindingGroup().getBindings();
	 for (Iterator<Binding> it = bindings.iterator(); it.hasNext();) {
	 Binding binding = it.next();
	 if (binding != null) {
	 Object component = binding.getSourceObject();
	 if (component instanceof JComponent) {
	 ((JComponent) component).addMouseListener(helpMouseListener);
	 }
	 }


	 }*/
    }

    public OpenerJDialog getHelpEditor() {
	return helpEditor;
    }

    public void setHelpEditor(OpenerJDialog helpEditor) {
	this.helpEditor = helpEditor;
    }

    public void fillEditorText(final String atext) {
	if (isWizardMode()) {
	    if (helpEditor != null) {
		helpEditor.fillEditorText(atext);
	    }
	} else {
	    if (offLineHelpEditor != null) {
		SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
			offLineHelpEditor.setText(atext);
		    }
		});
	    }
	}
    }
    private final AbstractPanel.InternalKey propertyChangeLstr = new AbstractPanel.InternalKey();
    private int completeness = 0;

    public int getCompleteness() {
	return completeness;
    }

    public void setCompleteness(int completeness) {
	this.completeness = completeness;
    }
    private final static Color FIELDMANDATORY = new Color(204, 51, 204);

    public boolean isEmpty(JComponent... txt) {
	if (txt == null) {
	    return true;
	}

	completeness = 100;
	boolean result = false;
	int nbCmpny = txt.length;
	for (JComponent jTextComponent1 : txt) {
	    if (jTextComponent1 == null) {
		continue;
	    }
	    if (jTextComponent1 instanceof JTextComponent) {
		JTextComponent jTextComponent = (JTextComponent) jTextComponent1;
		//Les champs obligatoirs vides fond grid
		if ((jTextComponent.getText() == null) || "".equals(jTextComponent.getText().trim())) {
		    if (jTextComponent.getKeyListeners().length > 1) {
		    } else {
			jTextComponent.setBackground(FIELDMANDATORY);
			jTextComponent.addKeyListener(propertyChangeLstr);
			completeness--;
		    }
		    if (!result) {
			completeness = 100;
			result = true;
		    }
		} else {
		    jTextComponent.setBackground(Color.white);
		    jTextComponent.removeKeyListener(propertyChangeLstr);
		    nbCmpny--;

		}
	    }
	}
	if (!result && nbCmpny == 0) {
	    setEnableNext(true);
	}
	return result;
    }

    public boolean isEmpty2(JComponent... txt) {
	if (txt == null) {
	    return true;
	}
	completeness = 100;
	boolean result = false;
	for (JComponent jTextComponent1 : txt) {
	    if (jTextComponent1 instanceof JTextComponent) {
		JTextComponent jTextComponent = (JTextComponent) jTextComponent1;
		//Les champs obligatoirs vides fond grid
		if ((jTextComponent.getText() == null) || "".equals(jTextComponent.getText().trim())) {
		    jTextComponent.setBackground(FIELDMANDATORY);
		    jTextComponent.addPropertyChangeListener(propertyChangeLstr);
		    if (!result) {
			result = true;
		    }
		} else {
		    jTextComponent.removePropertyChangeListener(propertyChangeLstr);

		}
	    }
	}

	return result;
    }

    public void setNextButton(JButton jButtonNext) {
	nextButton = new WeakReference(jButtonNext);
    }

    protected void setEnableNext(boolean enableNext) {
	if (nextButton != null) {
	    JButton nextOne = (JButton) nextButton.get();
	    if (nextOne != null) {
		nextOne.setEnabled(enableNext);
	    }
	} else {
	    if (next!=null){
	      next.setEnabled(enableNext);
	    }
	}

    }

    public void proceedSave() {
	try {
	    LoaderStorer loader = new LoaderStorer();
	    loader.store(parentRoot, parentRoot.getPath());
	} catch (Exception ex) {
	    Exceptions.printStackTrace(ex);
	}
    }

    class IntraItemListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
	    if (e.getStateChange() == ItemEvent.SELECTED) {
		getHelpEditor().enableNext();
	    }
	}
    }

    class InternalKey implements PropertyChangeListener, KeyListener {

	public InternalKey() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	    logger.info("propertyChange " + evt);
	    Object source = evt.getSource();

	    if (source instanceof JTextComponent) {
		JTextComponent jTextComponent = (JTextComponent) source;
		if ("".equals(jTextComponent.getText().trim())) {
		    jTextComponent.setBackground(FIELDMANDATORY);
		} else {
		    jTextComponent.setBackground(Color.WHITE);
		    setEnableNext(true);

		}
	    } else {
		throw new RuntimeException("Texte introuvable");
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent evt) {
	    logger.info("keyReleased" + evt);
	    Object source = evt.getSource();

	    if (source instanceof JTextComponent) {
		JTextComponent jTextComponent = (JTextComponent) source;
		if ("".equals(jTextComponent.getText().trim())) {
		    jTextComponent.setBackground(FIELDMANDATORY);
		} else {
		    jTextComponent.setBackground(Color.WHITE);
		    //getHelpEditor().enableNext();
		    setEnableNext(true);

		}
	    } else {
		throw new RuntimeException("Texte introuvable");
	    }
	}
    }

    public void beforeClose() {
    }

    public void afterOpen() {
    }

    public boolean isWizardMode() {
	return (wizardMode && helpEditor != null);
    }

    public void setWizardMode(boolean wizardMode) {
	this.wizardMode = wizardMode;
    }

    protected Dialog showDefenseurPopup(Defenseur representant, final String label) {
	//DefRepresenteJPanel represantant = new DefRepresenteJPanel(getParentRoot());
	DefenseurJPanel popupanel = new DefenseurJPanel(representant);
	DefenseurACT actionlistener = new DefenseurACT(representant, label);
	DialogDescriptor dd = new DialogDescriptor(popupanel, label, true, actionlistener);
	Dialog resDls = DialogDisplayer.getDefault().createDialog(dd);
	actionlistener.setDialog(resDls);
	resDls.setVisible(true);
	return resDls;
    }

    protected Dialog showRepresentantLegalPopup(Personne representant, String label) {
	//DefRepresenteJPanel represantant = new DefRepresenteJPanel(getParentRoot());
	RepresentantLegalJPanel popupanel = new RepresentantLegalJPanel(representant);
	LegalACT actionlistener = new LegalACT(representant, label);
	DialogDescriptor dd = new DialogDescriptor(popupanel, label, true, actionlistener);
	Dialog resDls = DialogDisplayer.getDefault().createDialog(dd);
	actionlistener.setDialog(resDls);
	resDls.setVisible(true);
	return resDls;
    }

    class DefenseurACT implements ActionListener {

	private Defenseur internal;
	private String label;
	private Dialog dialog;

	public DefenseurACT(Defenseur internal, String lbl) {
	    this.internal = internal;
	    this.label = lbl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if ("OK".equalsIgnoreCase(e.getActionCommand())) {
		if (dialog != null) {
		    dialog.setVisible(false);
		}

	    } else {
		if (dialog != null) {
		    dialog.setVisible(false);
		}
	    }
	    //  NotifyDescriptor nd = new NotifyDescriptor.Message("Vous avez selectionné "+e.getActionCommand()+" pour "+label+" 0x"+Integer.toHexString(internal.hashCode()));
	    //	DialogDisplayer.getDefault().notify(nd);

	}

	private void setDialog(Dialog resDls) {
	    this.dialog = resDls;
	}

	public Dialog getDialog() {
	    return dialog;
	}
    }

    protected void notifyError(String msg, Throwable ex) {
	ErrorNotifier.display(msg, ex);
    }

    protected void saveRoot(File prjFile) {
	LoaderStorer l = new LoaderStorer();
	try {
	    getParentRoot().setPath(prjFile.getPath());
	    l.store(getParentRoot(), prjFile);
	} catch (Exception ex) {
	    Exceptions.printStackTrace(ex);
	    notifyError("Enregistrement du projet", ex);
	}
    }
      public void saveRoot() {
	LoaderStorer l = new LoaderStorer();
	try {
	    l.store(getParentRoot(), getParentRoot().getPath());
	} catch (Exception ex) {
	    Exceptions.printStackTrace(ex);
	    notifyError("Enregistrement du projet", ex);
	}
    }
      
      
      protected void openUrl(String url_) {
	String url = url_;
	if (url == null) {
	    url = "www.jsph.fr";
	}
	if (java.awt.Desktop.isDesktopSupported()) {
	    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
	    if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
		try {
		    java.net.URI uri = new java.net.URI(url);
		    desktop.browse(uri);
		} catch (IOException ex) {
		    Exceptions.printStackTrace(ex);
		} catch (URISyntaxException ex) {
		    Exceptions.printStackTrace(ex);
		}
	    } else {
	    notifyError("Veuillez configurer un navigateur par défaut pour ouvrir la page:"+url, null);
	    
	    }
	}
    }
}
