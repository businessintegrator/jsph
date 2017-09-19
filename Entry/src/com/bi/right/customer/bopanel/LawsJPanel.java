/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bopanel;

import com.bi.jsph.model.LawListModel;
import com.bi.right.customer.util.Law;
import com.bi.right.customer.util.thpool.GUIExecutorImpl;
import java.awt.Cursor;
import java.awt.Dialog;
import java.io.File;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import javax.swing.JProgressBar;
import javax.swing.ListModel;
import javax.swing.ProgressMonitor;
import javax.swing.SwingUtilities;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class LawsJPanel extends javax.swing.JPanel {

    private File directory = null;
    private FileSeeker seeker = null;
    private Law selected;

    /**
     * Creates new form LawsJPanel
     */
    public LawsJPanel() {
	initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaOne = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(200);

        jList1.setModel(new LawListModel());
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jList1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList1MouseMoved(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jTextAreaOne.setEditable(false);
        jTextAreaOne.setColumns(20);
        jTextAreaOne.setLineWrap(true);
        jTextAreaOne.setRows(5);
        jScrollPane2.setViewportView(jTextAreaOne);

        jSplitPane1.setRightComponent(jScrollPane2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jTextField1.setText(org.openide.util.NbBundle.getMessage(LawsJPanel.class, "LawsJPanel.jTextField1.text")); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(LawsJPanel.class, "LawsJPanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButtonSearch, org.openide.util.NbBundle.getMessage(LawsJPanel.class, "LawsJPanel.jButtonSearch.text")); // NOI18N
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonSearch))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(344, 344, 344)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSearch))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
	if (evt.getValueIsAdjusting() && evt.getLastIndex() < this.jList1.getModel().getSize()) {
	    selected = (Law) this.jList1.getSelectedValue();
	    if (selected != null) {
		String content = selected.getFullContent();
		if (content == null) {
		    selected.loadFullContent();
		}
		jTextAreaOne.setText(selected.getFullContent());

	    }
	}
    }//GEN-LAST:event_jList1ValueChanged

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
	// TODO add your handling code here:
	searchEvent();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jList1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseMoved
//	Component o = evt.getComponent();
//	Logger.getLogger("evt sourece").info(o.toString());
//	Component cmpot = jList1.getComponentAt(evt.getX(), evt.getY());
//	Logger.getLogger("componentat").info(cmpot.toString());
//	
	/*Law l = (Law)jList1.getSelectedValue();
	 if (l != null){
	 jList1.setToolTipText(l.getFullContent());
	 }*/
    }//GEN-LAST:event_jList1MouseMoved
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextAreaOne;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public File getDirectory() {
	return directory;
    }

    public void setDirectory(File pdirectory) {
	this.directory = pdirectory;
	if (seeker == null && pdirectory != null) {
	    seeker = new FileSeeker();
	}
	seeker.setFile(directory);
    }
    private final Object LOCK_OUT = new Object();
    final private GUIExecutorImpl guiimpl = new GUIExecutorImpl(10);

    private void search(String ptxt) throws Exception {
	final Cursor lastCursor = getCursor();
	setCursor(new Cursor(Cursor.WAIT_CURSOR));
	final String txt = ptxt;
	guiimpl.execute(new Runnable() {
	    @Override
	    public void run() {
		try {
		    List<Law> results = seeker.seek(guiimpl, txt,LOCK_OUT);
		    synchronized (LOCK_OUT) {
			//LOCK_OUT.wait();
			setEnabled(true);
			ListModel modl = jList1.getModel();
			if (modl != null && modl instanceof LawListModel){
			    ((LawListModel)modl).addAll(results);
			} else {
			    jList1.setModel(new LawListModel(results));
			     setCursor(lastCursor);
			}
			
		    }
		} catch (Exception ex) {
		    Exceptions.printStackTrace(ex);
		}
	    }
	});




    }

    public Law getSelected() {
	return selected;
    }

    public void setSelected(Law selected) {
	this.selected = selected;
    }

    private void searchEvent() {
	try {
	    ((LawListModel)jList1.getModel()).clear();
	    final String txt = jTextField1.getText();
	    search(txt);
	} catch (Exception ex) {
	    Exceptions.printStackTrace(ex);
	}
    }
}