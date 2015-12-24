/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import com.bi.right.customer.bo.Piece;
import com.bi.right.customer.panel.PiecesJPanel;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
    category = "File",
id = "com.bi.right.customer.PiecesAction")
@ActionRegistration(
    iconBase = "com/bi/right/customer/loupe16x16.png",
displayName = "#CTL_PiecesAction")
@ActionReference(path = "Menu/File", position = 1200)
@Messages("CTL_PiecesAction=Ajouter preuves")
public final class PiecesAction extends AbstractAction implements ActionListener {
    private final JTextPane editor;
    private PiecesJPanel pieces;
   

    public PiecesAction(JTextPane jEditorPaneArg) {
        super("Ajouter preuves");
        this.editor = jEditorPaneArg;
    }

  

    public PiecesJPanel getPieces() {
	return pieces;
    }

    public void setPieces(PiecesJPanel pieces) {
	this.pieces = pieces;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ActPieces act = new ActPieces(pieces);
        DialogDescriptor dd = new DialogDescriptor(pieces,
                "Preuves",
                true, act);
        Dialog dialog = DialogDisplayer.getDefault().createDialog(dd);
        act.setDlg(dialog);
        dialog.setVisible(true);

    }

    private class ActPieces implements ActionListener {

        private Dialog dlg;
        private final PiecesJPanel p;

        private ActPieces(PiecesJPanel pieces) {
            this.p = pieces;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (dlg != null) {
                Piece selected = this.p.getSelectedPiece();
                if (selected != null) {
                    javax.swing.text.DefaultStyledDocument d = (javax.swing.text.DefaultStyledDocument) getEditor()
                            .getDocument();

                    try {
                        SimpleAttributeSet picecesattributeSet = new SimpleAttributeSet();
                        picecesattributeSet.addAttribute("piece", selected);
                        String txt = "(Pièce(s) n° " + selected.getNumero() + ")";
                        d.insertString(getEditor().getCaretPosition(), txt, picecesattributeSet);
                    } catch (Exception xe) {
                        NotifyDescriptor nd = new NotifyDescriptor.Message("Insertion non possible",NotifyDescriptor.Message.ERROR_MESSAGE );
                        // TODO Auto-generated catch block
                        DialogDisplayer.getDefault().notify(nd);
                    }
                }
                dlg.dispose();
            }
        }

        private void setDlg(Dialog dialog) {
            this.dlg = dialog;
        }

        public Dialog getDlg() {
            return dlg;
        }
    }

    public JTextPane getEditor() {
        return editor;
    }

    
    
}
