/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import com.bi.right.customer.bo.GUIManager;
import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.Document;
import org.jdesktop.beansbinding.BindingGroup;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class NouvelleAffaireJPanel extends AbstractPanel {

    private File fileUser = new File(System.getProperty("user.home"));
    private JFileChooser c = null;

    NouvelleAffaireJPanel(GUIManager parentRoot) {
	super(parentRoot);
	if (parentRoot.getPath() == null) {
	    c = new JFileChooser(fileUser);
	} else {
	    File fs = new File(parentRoot.getPath());
	    if (fs.exists()) {
		c = new JFileChooser(fs.isDirectory() ? fs : fs.getParentFile());
	    } else {
		c = new JFileChooser(fileUser);
	    }
	}
	initnow();
	if (parentRoot.isAttak() && parentRoot.isPourSalarie()) {
	    jRadioButtonattak.setSelected(true);
	    jRadioButtonsalarie.setSelected(true);
	} else if (!parentRoot.isAttak() && parentRoot.isPourSalarie()) {
	    jRadioButtonDefense.setSelected(true);
	    jRadioButtonsalarie.setSelected(true);
	} else if (parentRoot.isAttak() && !parentRoot.isPourSalarie()) {
	    jRadioButtonattak.setSelected(true);
	    jRadioButtonenterprise.setSelected(true);
	} else if (!parentRoot.isAttak() && !parentRoot.isPourSalarie()) {
	    jRadioButtonDefense.setSelected(true);
	    jRadioButtonenterprise.setSelected(true);


	}
    }

    @Override
    public AbstractPanel getNext() {
	final GUIManager ctxCross = getParentRoot();
	if (ctxCross.getPath() == null){
	    openFileDialog();
	}
	ContractJPanel contratPanel = new ContractJPanel(ctxCross);
	ConseilJPanel conseil = new ConseilJPanel(ctxCross);
	contratPanel.setNext(conseil);
	DemandesJPanel demandesPanel = new DemandesJPanel(ctxCross, getDemandes());
	conseil.setNext(demandesPanel);
	SalarieDemandeurJPanel salariedemandeurPanel = null;
	SocieteDefendeurJPanel societedefendeurPanel = null;
	SalarieDefendeurJPanel salarieDefendeurPanel = null;
	SocieteDemandeurJPanel societeDemandeurDemPanel = null;

	if (super.getNext() == null) {
	    if (jRadioButtonattak.isSelected() && jRadioButtonsalarie.isSelected()) {
		//Salarié demandeur
		salariedemandeurPanel = new SalarieDemandeurJPanel(ctxCross);
		societedefendeurPanel = new SocieteDefendeurJPanel(ctxCross);
		setNext(salariedemandeurPanel);
		salariedemandeurPanel.setNext(societedefendeurPanel);
		societedefendeurPanel.setNext(contratPanel);

	    } else if (jRadioButtonDefense.isSelected() && jRadioButtonsalarie.isSelected()) {
		salarieDefendeurPanel = new SalarieDefendeurJPanel(ctxCross.getDefendeur());
		societeDemandeurDemPanel = new SocieteDemandeurJPanel(ctxCross);
		setNext(salarieDefendeurPanel);
		salarieDefendeurPanel.setNext(societeDemandeurDemPanel);
		societeDemandeurDemPanel.setNext(contratPanel);


	    } else if (jRadioButtonattak.isSelected() && jRadioButtonenterprise.isSelected()) {
		societeDemandeurDemPanel = new SocieteDemandeurJPanel(ctxCross);
		salarieDefendeurPanel = new SalarieDefendeurJPanel(ctxCross.getDefendeur());
		setNext(societeDemandeurDemPanel);
		societeDemandeurDemPanel.setNext(salarieDefendeurPanel);
		salarieDefendeurPanel.setNext(contratPanel);

	    } else if (jRadioButtonDefense.isSelected() && jRadioButtonenterprise.isSelected()) {
		//Société demandeur
		societedefendeurPanel = new SocieteDefendeurJPanel(ctxCross);
		salariedemandeurPanel = new SalarieDemandeurJPanel(ctxCross);

		setNext(societedefendeurPanel);

		societedefendeurPanel.setNext(salariedemandeurPanel);
		salariedemandeurPanel.setNext(contratPanel);
	    }
	} else {
	    AbstractPanel old = super.getNext();
	    AbstractPanel oldNext = old.getNext();
	    if (old instanceof SalarieDemandeurJPanel) {
		salariedemandeurPanel = (SalarieDemandeurJPanel) old;
	    } else if (old instanceof SocieteDefendeurJPanel) {
		societedefendeurPanel = (SocieteDefendeurJPanel) old;
	    } else if (old instanceof SalarieDefendeurJPanel) {
		salarieDefendeurPanel = (SalarieDefendeurJPanel) old;
	    } else if (old instanceof SocieteDemandeurJPanel) {
		societeDemandeurDemPanel = (SocieteDemandeurJPanel) old;
	    }
	    if (oldNext != null) {
		if (oldNext instanceof SalarieDemandeurJPanel) {
		    salariedemandeurPanel = (SalarieDemandeurJPanel) oldNext;
		} else if (oldNext instanceof SocieteDefendeurJPanel) {
		    societedefendeurPanel = (SocieteDefendeurJPanel) oldNext;
		} else if (oldNext instanceof SalarieDefendeurJPanel) {
		    salarieDefendeurPanel = (SalarieDefendeurJPanel) oldNext;
		} else if (oldNext instanceof SocieteDemandeurJPanel) {
		    societeDemandeurDemPanel = (SocieteDemandeurJPanel) oldNext;
		}
	    }
	    if (jRadioButtonattak.isSelected() && jRadioButtonsalarie.isSelected()) {
		//Salarié demandeur
		if (salariedemandeurPanel == null) {
		    salariedemandeurPanel = new SalarieDemandeurJPanel(ctxCross);
		} else {
		    salariedemandeurPanel.setPrevious(null);
		}
		if (societedefendeurPanel == null) {
		    societedefendeurPanel = new SocieteDefendeurJPanel(ctxCross);
		} else {
		    societedefendeurPanel.setPrevious(null);
		}
		setNext(salariedemandeurPanel);
		salariedemandeurPanel.setNext(societedefendeurPanel);
		societedefendeurPanel.setNext(contratPanel);

	    } else if (jRadioButtonDefense.isSelected() && jRadioButtonsalarie.isSelected()) {
		if (salarieDefendeurPanel == null) {
		    salarieDefendeurPanel = new SalarieDefendeurJPanel(ctxCross.getDefendeur());
		} else {
		    salarieDefendeurPanel.setPrevious(null);
		}
		if (societeDemandeurDemPanel == null) {
		    societeDemandeurDemPanel = new SocieteDemandeurJPanel(ctxCross);
		} else {
		    societeDemandeurDemPanel.setPrevious(null);
		}
		setNext(salarieDefendeurPanel);
		salarieDefendeurPanel.setNext(societeDemandeurDemPanel);
		societeDemandeurDemPanel.setNext(contratPanel);


	    } else if (jRadioButtonattak.isSelected() && jRadioButtonenterprise.isSelected()) {
		if (societeDemandeurDemPanel == null) {
		    societeDemandeurDemPanel = new SocieteDemandeurJPanel(ctxCross);
		} else {
		    societeDemandeurDemPanel.setPrevious(null);
		}
		if (salarieDefendeurPanel == null) {
		    salarieDefendeurPanel = new SalarieDefendeurJPanel(ctxCross.getDefendeur());
		} else {
		    salarieDefendeurPanel.setPrevious(null);
		}
		setNext(societeDemandeurDemPanel);
		societeDemandeurDemPanel.setNext(salarieDefendeurPanel);
		salarieDefendeurPanel.setNext(contratPanel);

	    } else if (jRadioButtonDefense.isSelected() && jRadioButtonenterprise.isSelected()) {
		//Société demandeur
		if (societedefendeurPanel == null) {
		    societedefendeurPanel = new SocieteDefendeurJPanel(ctxCross);
		} else {
		    societedefendeurPanel.setPrevious(null);
		}
		if (salariedemandeurPanel == null) {
		    salariedemandeurPanel = new SalarieDemandeurJPanel(ctxCross);
		} else {
		    salariedemandeurPanel.setPrevious(null);
		}

		setNext(societedefendeurPanel);

		societedefendeurPanel.setNext(salariedemandeurPanel);
		salariedemandeurPanel.setNext(contratPanel);
	    }

	}
	return super.getNext();
    }

    /**
     * Creates new form NouvelleAffaireJPanel
     */
    public NouvelleAffaireJPanel() {
	initnow();
    }

    private void initnow() {
	initComponents();
	if (c != null && c.getCurrentDirectory() != null) {
	    this.jLabelPath.setText(c.getCurrentDirectory().getPath());
	    c.setFileFilter(new FileFilter() {
		@Override
		public boolean accept(File f) {
		    return f.isDirectory() || f.getName().endsWith(".xjsph");
		}

		@Override
		public String getDescription() {
		    return "Affaire Jsph *.xjsph";
		}
	    });
	}
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

        gUIManager1 = getParentRoot();
        buttonGroupSalarie = new javax.swing.ButtonGroup();
        buttonGroupAttaque = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelPath = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButtonenterprise = new javax.swing.JRadioButton();
        jRadioButtonDefense = new javax.swing.JRadioButton();
        jRadioButtonsalarie = new javax.swing.JRadioButton();
        jRadioButtonattak = new javax.swing.JRadioButton();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(NouvelleAffaireJPanel.class, "NouvelleAffaireJPanel.jLabel1.text")); // NOI18N

        jTextField1.setToolTipText(org.openide.util.NbBundle.getMessage(NouvelleAffaireJPanel.class, "NouvelleAffaireJPanel.jTextField1.toolTipText")); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, gUIManager1, org.jdesktop.beansbinding.ELProperty.create("${affaire}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(NouvelleAffaireJPanel.class, "NouvelleAffaireJPanel.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(NouvelleAffaireJPanel.class, "NouvelleAffaireJPanel.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(NouvelleAffaireJPanel.class, "NouvelleAffaireJPanel.jLabel2.text")); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bi/right/customer/jsph16x16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(NouvelleAffaireJPanel.class, "NouvelleAffaireJPanel.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(NouvelleAffaireJPanel.class, "NouvelleAffaireJPanel.jLabel4.text")); // NOI18N

        buttonGroupSalarie.add(jRadioButtonenterprise);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButtonenterprise, org.openide.util.NbBundle.getMessage(NouvelleAffaireJPanel.class, "NouvelleAffaireJPanel.jRadioButtonenterprise.text")); // NOI18N

        buttonGroupAttaque.add(jRadioButtonDefense);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButtonDefense, org.openide.util.NbBundle.getMessage(NouvelleAffaireJPanel.class, "NouvelleAffaireJPanel.jRadioButtonDefense.text")); // NOI18N

        buttonGroupSalarie.add(jRadioButtonsalarie);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButtonsalarie, org.openide.util.NbBundle.getMessage(NouvelleAffaireJPanel.class, "NouvelleAffaireJPanel.jRadioButtonsalarie.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, gUIManager1, org.jdesktop.beansbinding.ELProperty.create("${pourSalarie}"), jRadioButtonsalarie, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        buttonGroupAttaque.add(jRadioButtonattak);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButtonattak, org.openide.util.NbBundle.getMessage(NouvelleAffaireJPanel.class, "NouvelleAffaireJPanel.jRadioButtonattak.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, gUIManager1, org.jdesktop.beansbinding.ELProperty.create("${attak}"), jRadioButtonattak, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPath, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonattak)
                            .addComponent(jRadioButtonsalarie))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonenterprise)
                            .addComponent(jRadioButtonDefense))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelPath)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonsalarie)
                    .addComponent(jRadioButtonenterprise))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonattak)
                    .addComponent(jRadioButtonDefense))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	openFileDialog();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupAttaque;
    private javax.swing.ButtonGroup buttonGroupSalarie;
    private com.bi.right.customer.bo.GUIManager gUIManager1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelPath;
    private javax.swing.JRadioButton jRadioButtonDefense;
    private javax.swing.JRadioButton jRadioButtonattak;
    private javax.swing.JRadioButton jRadioButtonenterprise;
    private javax.swing.JRadioButton jRadioButtonsalarie;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<Document> getUndoableDocuments() {
	List<Document> prj = new ArrayList<Document>();
	prj.add(jTextField1.getDocument());
	return prj;
    }

    @Override
    public boolean isNextPossible() {
	if (isEmpty(jTextField1)) {
	    return false;
	}
	return true;
    }

    @Override
    public BindingGroup getBindingGroup() {
	return bindingGroup;
    }

    @Override
    public void initJComponents() {
	initComponents();
    }

    private void openFileDialog() throws HeadlessException {
	c.setMultiSelectionEnabled(false);
	c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	getParentRoot().setAffaire(this.jTextField1.getText());
	int res = c.showOpenDialog(this);
	if (res == JFileChooser.APPROVE_OPTION) {
	    File prj = c.getSelectedFile();
            if (!prj.exists()) {
		prj.mkdirs();
	    }
	    String path = prj.getPath() + "/Affaire_"+this.jTextField1.getText()+".xjsph";
	    File prjFile = new File(path);
	    int k = 0;
	    while (prjFile.exists()) {
		path = c.getSelectedFile().getPath() + "/Affaire_" + this.jTextField1.getText()+"_"+k + ".xjsph";
		prjFile = new File(path);
		k++;
	    }
	    saveRoot(prjFile);
	    jLabelPath.setText(prj.getPath());
	}
    }

}
