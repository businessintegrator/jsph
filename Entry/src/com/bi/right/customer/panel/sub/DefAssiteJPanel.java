/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel.sub;

import com.bi.right.customer.bo.Defenseur;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.panel.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import org.jdesktop.beansbinding.BindingGroup;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class DefAssiteJPanel extends AbstractPanel {

    public DefAssiteJPanel(GUIManager root) {
        super(root);
        getParentRoot().getDefendeur().setAssistant(new Defenseur());
        initComponents();
    }

    
    /**
     * Creates new form DefAssiteJPanel
     */
    public DefAssiteJPanel() {
        getParentRoot().getDefendeur().setAssistant(new Defenseur());
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

        gUIManager1 = getParentRoot();
        defenseurJPanel1 = new DefenseurJPanel(getParentRoot().getDefendeur().getAssistant());

        setLayout(new java.awt.BorderLayout());
        add(defenseurJPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bi.right.customer.panel.sub.DefenseurJPanel defenseurJPanel1;
    private com.bi.right.customer.bo.GUIManager gUIManager1;
    // End of variables declaration//GEN-END:variables

    public List<Document> getUndoableDocuments() {
        return defenseurJPanel1.getUndoableDocuments();
    }

    public BindingGroup getBindingGroup() {
        return defenseurJPanel1.getBindingGroup();
    }

 @Override
    public void initJComponents() {
        initComponents();
    }    

    @Override
    public boolean isNextPossible() {
        return getParentRoot().getDefendeur().getAssiste();
    }
}
