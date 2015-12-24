/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel.sub;

import java.text.DecimalFormat;
import javax.swing.JFormattedTextField;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class SalairesJPanel extends javax.swing.JPanel {
    private double salaireRetenu;
    private  JFormattedTextField salaireTxt = null;

    public SalairesJPanel(JFormattedTextField jFormattedTextFieldSalaireRef) {
        this.salaireTxt = jFormattedTextFieldSalaireRef;
        initComponents();
    }

    public double getSalaireRetenu() {
        return salaireRetenu;
    }

    public void setSalaireRetenu(double salaireRetenu) {
        this.salaireRetenu = salaireRetenu;
    }

    /**
     * Creates new form SalairesJPanel
     */
    public SalairesJPanel() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        rule = new com.bi.right.customer.bo.LicenciementRuleContainer();
        jPanelRefSalaire = new javax.swing.JPanel();
        jLabelMois = new javax.swing.JLabel();
        jFormattedTextFieldMois_12 = new javax.swing.JFormattedTextField();
        jLabelMois1 = new javax.swing.JLabel();
        jFormattedTextFieldMois_10 = new javax.swing.JFormattedTextField();
        jLabelMois2 = new javax.swing.JLabel();
        jFormattedTextFieldMois_11 = new javax.swing.JFormattedTextField();
        jLabelMois3 = new javax.swing.JLabel();
        jFormattedTextFieldMois_9 = new javax.swing.JFormattedTextField();
        jLabelMois4 = new javax.swing.JLabel();
        jFormattedTextFieldMois_8 = new javax.swing.JFormattedTextField();
        jLabelMois5 = new javax.swing.JLabel();
        jFormattedTextFieldMois_7 = new javax.swing.JFormattedTextField();
        jLabelMois6 = new javax.swing.JLabel();
        jFormattedTextFieldMois_6 = new javax.swing.JFormattedTextField();
        jLabelMois7 = new javax.swing.JLabel();
        jFormattedTextFieldMois_5 = new javax.swing.JFormattedTextField();
        jLabelMois8 = new javax.swing.JLabel();
        jFormattedTextFieldMois_4 = new javax.swing.JFormattedTextField();
        jLabelMois9 = new javax.swing.JLabel();
        jFormattedTextFieldMois_3 = new javax.swing.JFormattedTextField();
        jLabelMois10 = new javax.swing.JLabel();
        jFormattedTextFieldMois_2 = new javax.swing.JFormattedTextField();
        jLabelMois11 = new javax.swing.JLabel();
        jFormattedTextFieldMois_1 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextFieldX12 = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jButtonCalcReference = new javax.swing.JButton();
        jFormattedTextFieldX3Mois = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois.text")); // NOI18N

        jFormattedTextFieldMois_12.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_12.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_12.text_1")); // NOI18N
        jFormattedTextFieldMois_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldMois_12ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois1, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois1.text")); // NOI18N

        jFormattedTextFieldMois_10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_10.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_10.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois2, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois2.text")); // NOI18N

        jFormattedTextFieldMois_11.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_11.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_11.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois3, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois3.text")); // NOI18N

        jFormattedTextFieldMois_9.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_9.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_9.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois4, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois4.text")); // NOI18N

        jFormattedTextFieldMois_8.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_8.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_8.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois5, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois5.text")); // NOI18N

        jFormattedTextFieldMois_7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_7.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_7.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois6, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois6.text")); // NOI18N

        jFormattedTextFieldMois_6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_6.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_6.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois7, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois7.text")); // NOI18N

        jFormattedTextFieldMois_5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_5.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_5.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois8, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois8.text")); // NOI18N

        jFormattedTextFieldMois_4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_4.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_4.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois9, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois9.text")); // NOI18N

        jFormattedTextFieldMois_3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_3.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_3.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois10, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois10.text")); // NOI18N

        jFormattedTextFieldMois_2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_2.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_2.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMois11, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabelMois11.text")); // NOI18N

        jFormattedTextFieldMois_1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldMois_1.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldMois_1.text_1")); // NOI18N
        jFormattedTextFieldMois_1.setPreferredSize(new java.awt.Dimension(100, 20));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabel8.text")); // NOI18N

        jFormattedTextFieldX12.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldX12.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldX12.text_1")); // NOI18N
        jFormattedTextFieldX12.setToolTipText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldX12.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabel9.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButtonCalcReference, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jButtonCalcReference.text")); // NOI18N
        jButtonCalcReference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcReferenceActionPerformed(evt);
            }
        });

        jFormattedTextFieldX3Mois.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########.##"))));
        jFormattedTextFieldX3Mois.setText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldX3Mois.text")); // NOI18N
        jFormattedTextFieldX3Mois.setToolTipText(org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jFormattedTextFieldX3Mois.toolTipText")); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel13, org.openide.util.NbBundle.getMessage(SalairesJPanel.class, "SalairesJPanel.jLabel13.text")); // NOI18N

        javax.swing.GroupLayout jPanelRefSalaireLayout = new javax.swing.GroupLayout(jPanelRefSalaire);
        jPanelRefSalaire.setLayout(jPanelRefSalaireLayout);
        jPanelRefSalaireLayout.setHorizontalGroup(
            jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonCalcReference, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextFieldX12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldX3Mois, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMois11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMois10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMois9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMois8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMois7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMois6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMois5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMois4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMois3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMois2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMois1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMois, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldMois_1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldMois_2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldMois_3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldMois_4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldMois_5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldMois_6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldMois_7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldMois_8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldMois_9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldMois_10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldMois_11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldMois_12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel13)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanelRefSalaireLayout.setVerticalGroup(
            jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMois11)
                    .addComponent(jFormattedTextFieldMois_1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMois10)
                    .addComponent(jFormattedTextFieldMois_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelMois9))
                    .addComponent(jFormattedTextFieldMois_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelMois8))
                    .addComponent(jFormattedTextFieldMois_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldMois_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMois7))
                .addGap(2, 2, 2)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelMois6))
                    .addComponent(jFormattedTextFieldMois_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelMois5))
                    .addComponent(jFormattedTextFieldMois_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelMois4))
                    .addComponent(jFormattedTextFieldMois_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelMois3))
                    .addComponent(jFormattedTextFieldMois_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelMois2))
                    .addComponent(jFormattedTextFieldMois_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelMois1))
                    .addComponent(jFormattedTextFieldMois_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRefSalaireLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelMois))
                    .addComponent(jFormattedTextFieldMois_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCalcReference)
                .addGap(7, 7, 7)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldX12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRefSalaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldX3Mois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanelRefSalaire, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalcReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcReferenceActionPerformed
        calculate();
    }//GEN-LAST:event_jButtonCalcReferenceActionPerformed

    private void jFormattedTextFieldMois_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldMois_12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldMois_12ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCalcReference;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_1;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_10;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_11;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_12;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_2;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_3;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_4;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_5;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_6;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_7;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_8;
    private javax.swing.JFormattedTextField jFormattedTextFieldMois_9;
    private javax.swing.JFormattedTextField jFormattedTextFieldX12;
    private javax.swing.JFormattedTextField jFormattedTextFieldX3Mois;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMois;
    private javax.swing.JLabel jLabelMois1;
    private javax.swing.JLabel jLabelMois10;
    private javax.swing.JLabel jLabelMois11;
    private javax.swing.JLabel jLabelMois2;
    private javax.swing.JLabel jLabelMois3;
    private javax.swing.JLabel jLabelMois4;
    private javax.swing.JLabel jLabelMois5;
    private javax.swing.JLabel jLabelMois6;
    private javax.swing.JLabel jLabelMois7;
    private javax.swing.JLabel jLabelMois8;
    private javax.swing.JLabel jLabelMois9;
    private javax.swing.JPanel jPanelRefSalaire;
    private com.bi.right.customer.bo.LicenciementRuleContainer rule;
    // End of variables declaration//GEN-END:variables

 private javax.swing.JFormattedTextField [] getSalaires(){return  new javax.swing.JFormattedTextField [] {    
    jFormattedTextFieldMois_1,
    jFormattedTextFieldMois_2,
    jFormattedTextFieldMois_3,
    jFormattedTextFieldMois_4,
    jFormattedTextFieldMois_5,
    jFormattedTextFieldMois_6,
    jFormattedTextFieldMois_7,
    jFormattedTextFieldMois_8,
    jFormattedTextFieldMois_9,
    jFormattedTextFieldMois_10,
    jFormattedTextFieldMois_11,
    jFormattedTextFieldMois_12
                               };
 }

    private void calculate() {
        int filled = 0;
        double sum = 0;
        double sum3 = 0;
        JFormattedTextField[] salaires = getSalaires();
        for (int i = 0; i < salaires.length; i++) {
            JFormattedTextField jFormattedTextFielTemp = salaires[i];
            if (jFormattedTextFielTemp.getDocument() == null) continue;
            String textTemp =jFormattedTextFielTemp.getText();
            if ("".equals(textTemp.trim())) continue;
             Double n = Double.valueOf(textTemp);
             if (n != null && n.doubleValue() > 0){
               filled++;
               sum +=n.doubleValue();
               if (filled == 3) {
                  sum3 = sum; 
               }
             }
        }
        Double _3 = new Double(sum3/Math.min(3, filled));
        Double _12 = new Double(sum/Math.min(12, filled));
        jFormattedTextFieldX3Mois.setValue(_3);
        jFormattedTextFieldX12.setValue(_12);
        this.salaireRetenu =  (Math.max(_3, _12));
        this.salaireTxt.setValue(this.salaireRetenu);
    }
}
