/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel.sub;

import com.bi.right.customer.bo.Defenseur;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.panel.AbstractPanel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import org.jdesktop.beansbinding.BindingGroup;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class DefenseurJPanel extends AbstractPanel {

    
    /**
     * Creates new form DefenseurJPanel
     */
    public DefenseurJPanel() {
        initComponents();
    }

    public DefenseurJPanel(Defenseur pdefenseur) {
	if (pdefenseur == null) throw new RuntimeException("Pas de defenseur");
        this.defenseur = pdefenseur;
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

        defenseur = getDefenseur();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButtonSociete = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        personneBoPanel1 = new com.bi.right.customer.bopanel.PersonneBoPanel(this.defenseur.getRepresentant(),"Représentant du demandeur");
        societeBoPanel1 = new com.bi.right.customer.bopanel.SocieteBoPanel(this.defenseur.getSociete());
        adresseJPanel1 = new com.bi.right.customer.bopanel.AdresseJPanel(this.defenseur.isPersonnephysique()?this.defenseur.getRepresentant().getAddr():this.defenseur.getSociete().getAddr(),this.defenseur.isPersonnephysique()?this.defenseur.getRepresentant().getTel():this.defenseur.getSociete().getRprsnt().getTel(),this.defenseur.isPersonnephysique()?this.defenseur.getRepresentant().getFax():this.defenseur.getSociete().getRprsnt().getFax());

        buttonGroup1.add(jRadioButtonSociete);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButtonSociete, org.openide.util.NbBundle.getMessage(DefenseurJPanel.class, "DefenseurJPanel.jRadioButtonSociete.text")); // NOI18N

        buttonGroup1.add(jRadioButton2);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton2, org.openide.util.NbBundle.getMessage(DefenseurJPanel.class, "DefenseurJPanel.jRadioButton2.text")); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, defenseur, org.jdesktop.beansbinding.ELProperty.create("${personnephysique}"), jRadioButton2, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(DefenseurJPanel.class, "DefenseurJPanel.personneBoPanel1.TabConstraints.tabTitle"), personneBoPanel1); // NOI18N
        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(DefenseurJPanel.class, "DefenseurJPanel.societeBoPanel1.TabConstraints.tabTitle"), societeBoPanel1); // NOI18N
        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(DefenseurJPanel.class, "DefenseurJPanel.adresseJPanel1.TabConstraints.tabTitle"), adresseJPanel1); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jRadioButtonSociete)
                .addGap(44, 44, 44)
                .addComponent(jRadioButton2)
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonSociete)
                    .addComponent(jRadioButton2))
                .addGap(17, 17, 17)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bi.right.customer.bopanel.AdresseJPanel adresseJPanel1;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.bi.right.customer.bo.Defenseur defenseur;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButtonSociete;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.bi.right.customer.bopanel.PersonneBoPanel personneBoPanel1;
    private com.bi.right.customer.bopanel.SocieteBoPanel societeBoPanel1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<Document> getUndoableDocuments() {
        List<Document> p = new ArrayList<Document>();
if (jRadioButtonSociete.isSelected()){
    societeBoPanel1.fillTextFields(p);
} else {
    personneBoPanel1.fillTextFields(p);
    
}

      adresseJPanel1.fillTextFields(p);
        return p;
    }

    @Override
    public BindingGroup getBindingGroup() {
        return bindingGroup;
    }

    public Defenseur getDefenseur() {
        return defenseur;
    }

    public void setDefenseur(Defenseur defenseur) {
        this.defenseur = defenseur;
    }

 @Override
    public void initJComponents() {
        initComponents();
    }    

    @Override
    public boolean isNextPossible() {
        return this.defenseur != null;
    }
}
