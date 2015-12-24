/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import com.bi.right.customer.bopanel.LawsJPanel;
import com.bi.right.customer.util.Law;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
    category = "File",
id = "com.bi.right.customer.LawsAction")
@ActionRegistration(
    iconBase = "com/bi/right/customer/laws16x16.png",
displayName = "#CTL_LawsAction")
@ActionReference(path = "Menu/File", position = 1100)
@Messages("CTL_LawsAction=Loi")
public final class LawsAction extends AbstractAction implements ActionListener {

    private static LawsJPanel lawspanel = new LawsJPanel();
    private final JTextPane editor;
    private final static String INSERER = "Insérer";
    private final static String ANNULER = "Annuler";

    public LawsAction(JTextPane peditor) {
	super("Article");
	this.editor = peditor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

	File dir = lawspanel.getDirectory();
	if (dir == null) {
	    JFileChooser ch = new JFileChooser();
	    ch.setMultiSelectionEnabled(false);
	    ch.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    int res = ch.showOpenDialog(editor);
	    if (res == JFileChooser.APPROVE_OPTION) {
		lawspanel.setDirectory(ch.getSelectedFile());
	    
	    
	    }else {
		NotifyDescriptor nd = new NotifyDescriptor.Message("Sélectionner le répertoire contenant les lois que vous avez téléchargé", NotifyDescriptor.Message.WARNING_MESSAGE);
		DialogDisplayer.getDefault().notify(nd);
		//url
		TopComponent top = WindowManager.getDefault().findTopComponent("DecoupeurDeLoisTopComponent");
		if (top instanceof DecoupeurDeLoisTopComponent){
		 DecoupeurDeLoisTopComponent dec = ((DecoupeurDeLoisTopComponent)top);
		 dec.open();
		 
		}
	    }

	}
	Iseract actionlistener = new Iseract(lawspanel);
	DialogDescriptor dd = new DialogDescriptor(lawspanel,
		"Insertion d'article de lois et conventions", true,
		new Object[]{INSERER, ANNULER}, ANNULER, 0, null, actionlistener);
	Dialog dlg = DialogDisplayer.getDefault().createDialog(dd);
	actionlistener.setDlg(dlg);
        dlg.setVisible(true);


    }

    class Iseract implements ActionListener {

	private final LawsJPanel lawspanel;
	private Dialog dlg;

	private Iseract(LawsJPanel plawspanel) {
	    this.lawspanel = plawspanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (dlg != null) {
		if (INSERER.equals(e.getActionCommand())) {
		    if (editor != null) {
			javax.swing.text.DefaultStyledDocument d = (javax.swing.text.DefaultStyledDocument) editor.getDocument();
			Law law = lawspanel.getSelected();
			if (law != null) {
			    try {
				SimpleAttributeSet picecesattributeSet = new SimpleAttributeSet();
				picecesattributeSet.addAttribute("piece", law.hashCode());
				String txt = law.getArticle() + "\n" + law.getFullContent() + "\n";
				d.insertString(editor.getCaretPosition(), txt, picecesattributeSet);
			    } catch (Exception xe) {
				NotifyDescriptor nd = new NotifyDescriptor.Message("Insertion non possible", NotifyDescriptor.Message.ERROR_MESSAGE);
				// TODO Auto-generated catch block
				DialogDisplayer.getDefault().notify(nd);
			    }

			}
		    }

		} else if (ANNULER.equals(e.getActionCommand())) {
		}
		dlg.dispose();
	    }

	}

	private void setDlg(Dialog dlg) {
	    this.dlg = dlg;
	}
    }
    
    public static void changeReferentialDir (File dir ){
	lawspanel.setDirectory(dir);
    }
}
