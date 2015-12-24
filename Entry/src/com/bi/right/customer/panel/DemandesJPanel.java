/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import com.bi.jsph.model.DemandesTableModel;
import com.bi.right.customer.bo.Demande;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.util.renderer.DateDemandeEditor;
import com.bi.right.customer.util.renderer.DateDemandeRenderer;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;
import javax.swing.text.Document;
import org.jdesktop.beansbinding.BindingGroup;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.HelpCtx;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class DemandesJPanel extends AbstractPanel {

    private static final Logger logger = Logger.getLogger("DemandesJPanel");
    private DemandesTableModel model = null;
    private WeakHashMap<Demande, DiscussionJPanel> maps = new WeakHashMap<Demande, DiscussionJPanel>();
    private PiecesJPanel pieces = null;

    public DemandesJPanel(GUIManager r, DemandesTableModel model) {
	super(r);
	setDemandes(model);
	this.model = model;
	initComponents();
	pieces = new PiecesJPanel();

    }

    @Override
    public AbstractPanel getNext() {
	if (super.getNext() == null) {
	    SaisineJPanel saisine = new SaisineJPanel(getParentRoot());
	    //ExposeLitigeJPanel expose = new ExposeLitigeJPanel(getParentRoot(), getModel());
	    setNext(saisine);
	}
	return super.getNext();
    }

    /**
     * Creates new form DemandesJPanel
     */
    public DemandesJPanel() {
	initComponents();
    }

    final DemandesTableModel getModel() {
	return this.model;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gUIManager1 = getParentRoot();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jScrollPane1.setAutoscrolls(true);

        jTable1.setModel(getModel());
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable1.setToolTipText(org.openide.util.NbBundle.getMessage(DemandesJPanel.class, "DemandesJPanel.jTable1.toolTipText")); // NOI18N
        jTable1.setDoubleBuffered(true);
        jTable1.setGridColor(new java.awt.Color(102, 0, 102));
        jTable1.setRowSelectionAllowed(false);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.setDefaultRenderer(Date.class, new DateDemandeRenderer());

        jTable1.setRowHeight(60);
        jScrollPane1.setViewportView(jTable1);
        TableColumn col0 = jTable1.getColumnModel().getColumn(0);
        col0.setMaxWidth(80);
        TableColumn col1 = jTable1.getColumnModel().getColumn(1);
        col1.setMaxWidth(80);
        TableColumn col2 = jTable1.getColumnModel().getColumn(2);
        col2.setMaxWidth(80);

        TableColumn col5 = jTable1.getColumnModel().getColumn(5);
        col5.setCellEditor(new DateDemandeEditor());
        TableColumn col6 = jTable1.getColumnModel().getColumn(6);
        col6.setCellEditor(new DateDemandeEditor());
        jTable1.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(DemandesJPanel.class, "DemandesJPanel.jTable1.AccessibleContext.accessibleDescription")); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/empty/editer32.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(DemandesJPanel.class, "DemandesJPanel.jLabel1.text")); // NOI18N
        jLabel1.setDoubleBuffered(true);

        org.openide.awt.Mnemonics.setLocalizedText(jButtonAdd, org.openide.util.NbBundle.getMessage(DemandesJPanel.class, "DemandesJPanel.jButtonAdd.text")); // NOI18N
        jButtonAdd.setToolTipText(org.openide.util.NbBundle.getMessage(DemandesJPanel.class, "DemandesJPanel.jButtonAdd.toolTipText")); // NOI18N
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bi/right/customer/open16x16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(DemandesJPanel.class, "DemandesJPanel.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bi/right/customer/save16x16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(DemandesJPanel.class, "DemandesJPanel.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAdd)
                .addGap(77, 77, 77)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jButtonAdd)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		SimpleDemandeJPanel newDem = new SimpleDemandeJPanel();

		ActDem actDem = new ActDem(newDem);
		DialogDescriptor dd =
			new DialogDescriptor(newDem, "Demande",
			true, new Object[]{"OK", "Annuler"},
			"Annuler", 0, null, actDem);
		Dialog resDls = DialogDisplayer.getDefault().createDialog(dd);
		actDem.setDialog(resDls);

		resDls.setVisible(true);
	    }
	});
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
	if (evt.getClickCount() == 2) {
	    Object obj = evt.getSource();
	    if (obj instanceof JTable) {
		JTable jtable = ((JTable) obj);
		final int row = jtable.getSelectedRow();
		int col = jtable.getSelectedColumn();
		logger.info("Selected row col " + row + "," + col);

		if (col == 0) {
		    final Demande dem1 = model.getDemande(row);
		    SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

			    pieces.setCurrentDirectory(getParentRoot());
			    DiscussionJPanel panel = createOrGetDiscussionPanel(dem1, pieces);
			    DiscussionActionListener discussionAct = new DiscussionActionListener(getParentRoot().getPath(), panel.getjEditorPaneArg().getDocument(), dem1);
			    DialogDescriptor dd = new DialogDescriptor(panel, "Discussion sur " + dem1.getLbl(), true, new Object[]{DiscussionActionListener.Ajouter, DiscussionActionListener.Annuler}, DiscussionActionListener.Ajouter, 0, HelpCtx.DEFAULT_HELP, discussionAct);
			    Dialog dialog = DialogDisplayer.getDefault().createDialog(dd);
			    discussionAct.setDialogInternal(dialog);
			    dialog.setVisible(true);
			}
		    });
		} else if (col == 8) {


		    NotifyDescriptor nd = new NotifyDescriptor.Confirmation("Etes vous sûr de supprimer la ligne?", "Suppresion", NotifyDescriptor.Confirmation.QUESTION_MESSAGE);
		    Object res = DialogDisplayer.getDefault().notify(nd);
		    if (NotifyDescriptor.Confirmation.OK_OPTION.equals(res)) {
			SwingUtilities.invokeLater(new Runnable() {
			    @Override
			    public void run() {
				model.removeDemande(row);
			    }
			});
		    }
		}
	    }
	}
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	// load properties
	FileOpenerSaver op = new FileOpenerSaver(this);
	Properties properties = new Properties();
	op.openPropertiesFile(properties);
	for (Map.Entry<Object, Object> entry : properties.entrySet()) {
	    String k = (String) entry.getKey();
	    String v = (String) entry.getValue();
	    Demande d = new Demande();
	    d.setArtlaw(k);
	    d.setLbl(v);
	    getModel().addDemande(d);
	}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	// TODO add your handling code here:
	FileOpenerSaver op = new FileOpenerSaver(this);
	Properties properties = new Properties();
	ArrayList<Demande> demandeList = getModel().getList();
	for (int i = 0; i < demandeList.size(); i++) {
	    Demande demande = demandeList.get(i);
	    properties.setProperty(demande.getArtlaw(), demande.getLbl());
	}
	op.savePropertiesFile(properties);
    }//GEN-LAST:event_jButton2ActionPerformed

    private DiscussionJPanel createOrGetDiscussionPanel(Demande dem1, PiecesJPanel pieces) {
	DiscussionJPanel tDiscussionJPanel = maps.get(dem1);
	if (tDiscussionJPanel == null) {
	    tDiscussionJPanel = new DiscussionJPanel(getParentRoot(), dem1, pieces);
	    maps.put(dem1, tDiscussionJPanel);
	}
	return tDiscussionJPanel;
    }

    private class ActDem implements ActionListener {

	private Dialog dialog = null;
	private SimpleDemandeJPanel represantant = null;

	public Dialog getDialog() {
	    return dialog;
	}

	public void setDialog(Dialog dialog) {
	    this.dialog = dialog;
	}

	public ActDem(SimpleDemandeJPanel prepresantant) {
	    this.represantant = prepresantant;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	    if ("OK".equals(e.getActionCommand())) {
		getModel().addDemande(represantant.getDemande());
	    }
	    if (dialog != null) {
		dialog.dispose();
	    }

	}
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bi.right.customer.bo.GUIManager gUIManager1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public List<Document> getUndoableDocuments() {

	return null;
    }

    @Override
    public boolean isNextPossible() {
	//return getParentRoot().getDemandes().size()>0;
	return true;
    }

    @Override
    public BindingGroup getBindingGroup() {
	return null;
    }

    @Override
    public void initJComponents() {
	initComponents();
    }
}
