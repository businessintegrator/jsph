/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import com.bi.right.customer.bo.GUIManager;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import org.jdesktop.beansbinding.BindingGroup;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class SocieteDefendeurJPanel extends AbstractPanel {
    private Dialog popupRepresentant;
    private Dialog popupAssistant;
    private Dialog popupRepresentantLegal;

    public SocieteDefendeurJPanel(GUIManager root) {
        super(root);
        initComponents();
    }

    /**
     * Creates new form DefendeurJPanel
     */
    public SocieteDefendeurJPanel() {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        gUIManager = getParentRoot();
        jCheckBoxRepresente = new javax.swing.JCheckBox();
        jCheckBoxAssiste = new javax.swing.JCheckBox();
        jButtonReprente = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButtonAssist = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        societeBoPanel1 = new com.bi.right.customer.bopanel.SocieteBoPanel(getParentRoot().getDefendeur().getSociete());
        adresseJPanel1 = new com.bi.right.customer.bopanel.AdresseJPanel(getParentRoot().getDefendeur().getSociete().getAddr(),getParentRoot().getDefendeur().getSociete().getRprsnt().getTel(),getParentRoot().getDefendeur().getSociete().getRprsnt().getFax());

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBoxRepresente, org.openide.util.NbBundle.getMessage(SocieteDefendeurJPanel.class, "SocieteDefendeurJPanel.jCheckBoxRepresente.text")); // NOI18N
        jCheckBoxRepresente.setToolTipText(org.openide.util.NbBundle.getMessage(SocieteDefendeurJPanel.class, "SocieteDefendeurJPanel.jCheckBoxRepresente.toolTipText")); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, gUIManager, org.jdesktop.beansbinding.ELProperty.create("${defendeur.represente}"), jCheckBoxRepresente, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jCheckBoxRepresente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxRepresenteItemStateChanged(evt);
            }
        });
        jCheckBoxRepresente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRepresenteActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBoxAssiste, org.openide.util.NbBundle.getMessage(SocieteDefendeurJPanel.class, "SocieteDefendeurJPanel.jCheckBoxAssiste.text")); // NOI18N
        jCheckBoxAssiste.setToolTipText(org.openide.util.NbBundle.getMessage(SocieteDefendeurJPanel.class, "SocieteDefendeurJPanel.jCheckBoxAssiste.toolTipText")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, gUIManager, org.jdesktop.beansbinding.ELProperty.create("${defendeur.assiste}"), jCheckBoxAssiste, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jCheckBoxAssiste.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxAssisteItemStateChanged(evt);
            }
        });
        jCheckBoxAssiste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAssisteActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButtonReprente, org.openide.util.NbBundle.getMessage(SocieteDefendeurJPanel.class, "SocieteDefendeurJPanel.jButtonReprente.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jCheckBoxRepresente, org.jdesktop.beansbinding.ELProperty.create("${selected}"), jButtonReprente, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButtonReprente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReprenteActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox1, org.openide.util.NbBundle.getMessage(SocieteDefendeurJPanel.class, "SocieteDefendeurJPanel.jCheckBox1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButtonAssist, org.openide.util.NbBundle.getMessage(SocieteDefendeurJPanel.class, "SocieteDefendeurJPanel.jButtonAssist.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jCheckBoxAssiste, org.jdesktop.beansbinding.ELProperty.create("${selected}"), jButtonAssist, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButtonAssist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssistActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(SocieteDefendeurJPanel.class, "SocieteDefendeurJPanel.jButton1.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jCheckBox1, org.jdesktop.beansbinding.ELProperty.create("${selected}"), jButton1, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        societeBoPanel1.setAbstractPanel(this);

        adresseJPanel1.setAbstractPanel(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBoxRepresente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonReprente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAssiste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAssist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(102, 102, 102))
                    .addComponent(societeBoPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adresseJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonReprente)
                        .addComponent(jCheckBoxRepresente)
                        .addComponent(jCheckBoxAssiste)
                        .addComponent(jButtonAssist))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(societeBoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adresseJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxRepresenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRepresenteActionPerformed
    }//GEN-LAST:event_jCheckBoxRepresenteActionPerformed

    private void jCheckBoxAssisteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAssisteActionPerformed
    }//GEN-LAST:event_jCheckBoxAssisteActionPerformed

    private void jCheckBoxRepresenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxRepresenteItemStateChanged
    }//GEN-LAST:event_jCheckBoxRepresenteItemStateChanged

    private void jCheckBoxAssisteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxAssisteItemStateChanged
    }//GEN-LAST:event_jCheckBoxAssisteItemStateChanged

    private void jButtonReprenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReprenteActionPerformed
       if (popupRepresentant == null){
	popupRepresentant = showDefenseurPopup(getParentRoot().getDefendeur().getRepresentant(),"Représenté par");
       } else {
	   popupRepresentant.setVisible(true);
        }
    }//GEN-LAST:event_jButtonReprenteActionPerformed

    private void jButtonAssistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssistActionPerformed
	if (popupAssistant == null){
	popupAssistant = showDefenseurPopup(getParentRoot().getDefendeur().getAssistant(), "Assisté par");
	} else {
	    popupAssistant.setVisible(true);
	    
	}
    }//GEN-LAST:event_jButtonAssistActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (popupRepresentantLegal == null){
	 popupRepresentantLegal = showRepresentantLegalPopup(getParentRoot().getDemandeur().getSocId().getRprsnt(),"Représentant légal de la société");
       } else {
	   popupRepresentantLegal.setVisible(true);
	   
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    @Override
    public void proceedSave() {
	super.proceedSave();
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bi.right.customer.bopanel.AdresseJPanel adresseJPanel1;
    private com.bi.right.customer.bo.GUIManager gUIManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAssist;
    private javax.swing.JButton jButtonReprente;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxAssiste;
    private javax.swing.JCheckBox jCheckBoxRepresente;
    private com.bi.right.customer.bopanel.SocieteBoPanel societeBoPanel1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<Document> getUndoableDocuments() {
        ArrayList<Document> prj = new ArrayList<Document>();
	societeBoPanel1.fillTextFields(prj);
        return prj;
    }

    @Override
    public boolean isNextPossible() {
	return societeBoPanel1.isEmpty(this);
    }

    @Override
    public BindingGroup getBindingGroup() {
        return bindingGroup;
    }

    @Override
    public void initJComponents() {
        initComponents();
    }
    
    private void agsComment(){
    fillEditorText("L'association pour la Gestion du régime\n de garantie des créances des Salariés(A.G.S)\n"
                + "est à saisir en même temps que le mandataire\n liquidateur et le représentant des créanciers\n"
                + "en cas de liquidation. Si vous gagnez,\n l'AGS vous paye des avances si la société\n"
                + "est liquidé ");
    }

   
}