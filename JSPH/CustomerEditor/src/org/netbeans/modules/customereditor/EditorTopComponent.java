/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2010 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */
package org.netbeans.modules.customereditor;

import demo.Customer;
import demo.DiscountCode;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.modules.customerdb.JavaDBSupport;
import org.netbeans.modules.customerviewer.CustomerTopComponent;
import org.openide.util.LookupEvent;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.NotifyDescriptor.Confirmation;
import org.openide.awt.UndoRedo;
import org.openide.cookies.SaveCookie;
import org.openide.util.Lookup;
import org.openide.util.LookupListener;
import org.openide.util.RequestProcessor;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 * Top component which displays something.
 */
public final class EditorTopComponent extends TopComponent implements LookupListener {

    private static EditorTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "EditorTopComponent";
    private Lookup.Result result = null;
    private UndoRedo.Manager manager = new UndoRedo.Manager();
    private final SaveCookieImpl impl;
    private final InstanceContent content;
    private Customer customer;

    public EditorTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(EditorTopComponent.class, "CTL_EditorTopComponent"));
        setToolTipText(NbBundle.getMessage(EditorTopComponent.class, "HINT_EditorTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
        jTextField1.getDocument().addUndoableEditListener(manager);
        jTextField2.getDocument().addUndoableEditListener(manager);

        jTextField1.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                fire(true);
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                fire(true);
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                fire(true);
            }
        });

        jTextField2.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                fire(true);
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                fire(true);
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                fire(true);
            }
        });

        //Create a new instance of our SaveCookie implementation:
        impl = new SaveCookieImpl();

        //Create a new instance of our dynamic object:
        content = new InstanceContent();

        //Add the dynamic object to the TopComponent Lookup:
        associateLookup(new AbstractLookup(content));

    }

    @Override
    public void componentOpened() {
        RequestProcessor.getDefault().post(new Runnable() {
            @Override
            public void run() {
                readCustomer();
            }
        });
    }

    private void readCustomer() {
        JavaDBSupport.ensureStartedDB();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TopComponent tc = WindowManager.getDefault().findTopComponent("CustomerTopComponent");
                if (tc == null) {
                    // XXX: message box?
                    return ;
                }
                result = tc.getLookup().lookupResult(Customer.class);
                result.addLookupListener(EditorTopComponent.this);
                resultChanged(new LookupEvent(result));
            }
        });
    }

    @Override
    public void componentClosed() {
        result.removeLookupListener(this);
        result = null;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButtonOpen = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 0, 0, 0);
        add(jLabel1, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.jLabel2.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 312;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 8, 0, 0);
        add(jTextField1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 312;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 8, 0, 0);
        add(jTextField2, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jButtonOpen, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.jButtonOpen.text")); // NOI18N
        jButtonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 263, 0, 0);
        add(jButtonOpen, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.jLabel3.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 10, 97, 0);
        add(jLabel3, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.jLabel4.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 0, 0);
        add(jLabel4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenActionPerformed
        // Open affaire
        JFileChooser chooser = new JFileChooser();
        int res = chooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION){
        }
    }//GEN-LAST:event_jButtonOpenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOpen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized EditorTopComponent getDefault() {
        if (instance == null) {
            instance = new EditorTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the EditorTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized EditorTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(EditorTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof EditorTopComponent) {
            return (EditorTopComponent) win;
        }
        Logger.getLogger(EditorTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    @Override
    public void resultChanged(LookupEvent lookupEvent) {
        Lookup.Result r = (Lookup.Result) lookupEvent.getSource();
        Collection<Customer> coll = r.allInstances();
        if (!coll.isEmpty()) {
            for (Customer cust : coll) {
                customer = cust;
                jTextField1.setText(cust.getName());
                jTextField2.setText(cust.getCity());
            }
        } else {
            jTextField1.setText("[nom]");
            jTextField2.setText("[ville]");
        }
    }

    public void fire(boolean modified) {
        if (modified) {
            //If the text is modified,
            //we add SaveCookie impl to Lookup:
            content.add(impl);
        } else {
            //Otherwise, we remove the SaveCookie impl from the lookup:
            content.remove(impl);
        }
    }

    public void resetFields() {
        customer = new Customer();
        jTextField1.setText("");
        jTextField2.setText("");
    }

    private class SaveCookieImpl implements SaveCookie {

        @Override
        public void save() throws IOException {

            Confirmation message = new NotifyDescriptor.Confirmation("Do you want to save \""
                    + jTextField1.getText() + " (" + jTextField2.getText() + ")\"?",
                    NotifyDescriptor.OK_CANCEL_OPTION,
                    NotifyDescriptor.QUESTION_MESSAGE);

            Object result = DialogDisplayer.getDefault().notify(message);

            //When user clicks "Yes", indicating they really want to save,
            //we need to disable the Save button and Save menu item,
            //so that it will only be usable when the next change is made
            //to the text field:
            if (NotifyDescriptor.YES_OPTION.equals(result)) {
                fire(false);
                EntityManager entityManager = Persistence.createEntityManagerFactory("CustomerDBAccessPU").createEntityManager();
                entityManager.getTransaction().begin();
                if (customer.getCustomerId() != null) {
                    Customer c = entityManager.find(Customer.class, customer.getCustomerId());
                    c.setName(jTextField1.getText());
                    c.setCity(jTextField2.getText());
                    entityManager.getTransaction().commit();
                } else {
                    Query query = entityManager.createQuery("SELECT MAX(c.customerId) FROM Customer c");
                    Integer newId = (Integer) query.getSingleResult() + 1;
                    customer.setCustomerId(newId);
                    customer.setName(jTextField1.getText());
                    customer.setCity(jTextField2.getText());
                    customer.setZip("12345");
                    customer.setDiscountCode(entityManager.find(DiscountCode.class, 'H'));
                    entityManager.persist(customer);
                    entityManager.getTransaction().commit();
                }
                CustomerTopComponent.refreshNode();
            }

        }
    }
}
