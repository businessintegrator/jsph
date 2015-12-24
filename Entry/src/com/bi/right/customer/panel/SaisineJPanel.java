/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import com.bi.right.customer.LoaderStorer;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.util.MapGenerator;
import com.bi.right.customer.util.xslt.Transformers;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.text.Document;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.jdesktop.beansbinding.BindingGroup;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class SaisineJPanel extends AbstractPanel {

    /**
     * Creates new form SaisineJPanel
     */
    public SaisineJPanel() {
	initComponents();
    }

    public SaisineJPanel(GUIManager root) {
	super(root);
	saveRoot();
	initComponents();
	try {
	    FileReader reader = new FileReader(root.getPath());
	    char[] cbuf = new char[1024];
	    StringBuilder b = new StringBuilder();
	    int r = reader.read(cbuf);
	    while (r > 0) {
		b.append(cbuf, 0, r);
		r = reader.read(cbuf);
	    }
	    jEditorPane1.setText(b.toString());
	} catch (Exception ex) {
	    Exceptions.printStackTrace(ex);
	}


	/*AbstractPanel p = getPrevious();
	 int i = 10;
	 while (p != null){
	 p.setPreferredSize(new Dimension(jPanelCenter1.getWidth(),500));
	 jPanelCenter1.add(p,i--);
	 p = p.getPrevious();
	 }*/

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
        jLabel1 = new javax.swing.JLabel();
        jPanelCenter1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jButtonVisualiser = new javax.swing.JButton();
        jButtonVisualiserDOc = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SaisineJPanel.class, "SaisineJPanel.jLabel1.text")); // NOI18N

        jPanelCenter1.setAutoscrolls(true);
        jPanelCenter1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(jEditorPane1);

        jPanelCenter1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        org.openide.awt.Mnemonics.setLocalizedText(jButtonVisualiser, org.openide.util.NbBundle.getMessage(SaisineJPanel.class, "SaisineJPanel.jButtonVisualiser.text")); // NOI18N
        jButtonVisualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualiserActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButtonVisualiserDOc, org.openide.util.NbBundle.getMessage(SaisineJPanel.class, "SaisineJPanel.jButtonVisualiserDOc.text")); // NOI18N
        jButtonVisualiserDOc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualiserDOcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCenter1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVisualiser)
                .addGap(18, 18, 18)
                .addComponent(jButtonVisualiserDOc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVisualiser)
                    .addComponent(jButtonVisualiserDOc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCenter1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVisualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualiserActionPerformed
	try {
	    Transformers optimusPrime = new Transformers();
	    String xml = getParentRoot().getPath();
	    xml = xml.replace("\\", "/");
	    String xsl = "C:/jsph/xslt/saisine.properties.xsl";
	    String url = xml + ".html";
	    optimusPrime.transform(xml, xsl, url);
	    openUrl("file:///" + url);

	} catch (TransformerConfigurationException ex) {
	    Exceptions.printStackTrace(ex);
	} catch (TransformerException ex) {
	    Exceptions.printStackTrace(ex);
	}


    }//GEN-LAST:event_jButtonVisualiserActionPerformed

    private void jButtonVisualiserDOcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualiserDOcActionPerformed
	try {
	    Transformers optimusPrime = new Transformers();
	    String xml = getParentRoot().getPath();
	    xml = xml.replace("\\", "/");
	    String xsl = "C:/jsph/xslt/dollard/wordmltemplate.xml";
	    String url = xml + ".doc";
	    
	    optimusPrime.transform(xml, xsl, url);
	   
	    openUrl("file:///" + url);
	} catch (TransformerConfigurationException ex) {
	    Exceptions.printStackTrace(ex);
	} catch (TransformerException ex) {
	    Exceptions.printStackTrace(ex);
	}
    }//GEN-LAST:event_jButtonVisualiserDOcActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bi.right.customer.bo.GUIManager gUIManager1;
    private javax.swing.JButton jButtonVisualiser;
    private javax.swing.JButton jButtonVisualiserDOc;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelCenter1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<Document> getUndoableDocuments() {
	return null;
    }

    @Override
    public BindingGroup getBindingGroup() {
	return null;
    }

    @Override
    public void initJComponents() {
	initComponents();
    }

    @Override
    public boolean isNextPossible() {
	return true;
    }
}
