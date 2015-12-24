/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import com.bi.jsph.model.DemandesTableModel;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.panel.AbstractPanel;
import com.bi.right.customer.util.TopSavable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.UndoRedo;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public abstract class AbstractJsphTopComponent<R> extends TopComponent implements LookupListener {
    /* static {
     try {
     //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFee          l");
     //com.sun.java.swing.plaf.windows.WindowsLookAndFeel
     UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
             
     } catch (ClassNotFoundException ex) {
     Exceptions.printStackTrace(ex);
     } catch (InstantiationException ex) {
     Exceptions.printStackTrace(ex);
     } catch (IllegalAccessException ex) {
     Exceptions.printStackTrace(ex);
     } catch (UnsupportedLookAndFeelException ex) {
     Exceptions.printStackTrace(ex);
     }
     }*/

    private Lookup.Result result = null;
    private DemandesTableModel demandesTableModel;

    public DemandesTableModel getDemandesTableModel() {
        return demandesTableModel;
    }

    public void setDemandesTableModel(DemandesTableModel demandesTableModel) {
        this.demandesTableModel = demandesTableModel;
    }
    private TopComponent next;
    private TopComponent previous;
    protected UndoRedo.Manager manager = UndoRedoManbager.getInstance();
    protected TopSavable<R> impl;
    private AbstractPanel abstractPanel;

    @Override
    public UndoRedo getUndoRedo() {
        return manager;
    }

    public TopComponent getNext() {
        return next;
    }

    public void setNext(TopComponent next) {
        this.next = next;
    }

    public TopComponent getPrevious() {
        return previous;
    }

    public void setPrevious(TopComponent previous) {
        this.previous = previous;
    }

    void setAbstractPanel(AbstractPanel abstractPanel) {
        this.abstractPanel = abstractPanel;

    }

    public AbstractPanel getAbstractPanel() {
        return abstractPanel;
    }

    private void fillListeners(AbstractPanel abstractPanel) {
        setAbstractPanel(abstractPanel);
        List<Document> listOfDoc = this.abstractPanel.getUndoableDocuments();
        if (listOfDoc != null) {
            for (Iterator<Document> it = listOfDoc.iterator(); it.hasNext();) {
                Document document = it.next();
                document.addUndoableEditListener(manager);
                document.addDocumentListener(impl);
            }
        }

        //this.abstractPanel.getBindingGroup().addBindingListener(impl);
    }

    private void removeFillListeners() {
        List<Document> listOfDoc = this.abstractPanel.getUndoableDocuments();
        if (listOfDoc != null) {
            for (Iterator<Document> it = listOfDoc.iterator(); it.hasNext();) {
                Document document = it.next();
                document.removeUndoableEditListener(manager);
                document.removeDocumentListener(impl);
            }
        }
        //this.abstractPanel.getBindingGroup().removeBindingListener(impl);
        //abstractPanel = null;
    }

    protected void closedTreatment() {
        if (result != null) {
            result.removeLookupListener(AbstractJsphTopComponent.this);
            removeFillListeners();
        }

        if (abstractPanel != null){
            abstractPanel.beforeClose();
        }
        
    }

    protected void openedTreatment(AbstractPanel abstractPanel) {
        // Map<String, AbstractPanel> mapWz = GUIManagerTopComponent.getWizards();
        if (abstractPanel != null){
            abstractPanel.afterOpen();
        }
        fillListeners(abstractPanel);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TopComponent tc = WindowManager.getDefault().findTopComponent("GUIManagerTopComponent");
                if (tc == null) {
                    NotifyDescriptor.Confirmation message = new NotifyDescriptor.Confirmation("Affaires not trouvés", NotifyDescriptor.PLAIN_MESSAGE);
                    DialogDisplayer.getDefault().notify(message);
                    return;


                }
                result = tc.getLookup().lookupResult(GUIManager.class);
                result.addLookupListener(AbstractJsphTopComponent.this);
                resultChanged(
                        new LookupEvent(result));

            }
        });


    }

    @Override
    public void resultChanged(LookupEvent lookupEvent) {
        if (WindowManager.getDefault() == null) {
            return;
        }
        Set<? extends Mode> modes = WindowManager.getDefault().getModes();
        for (Iterator<? extends Mode> it = modes.iterator(); it.hasNext();) {
            Mode mode = it.next();
            TopComponent[] tops = WindowManager.getDefault().getOpenedTopComponents(mode);
            if (tops == null) {
                return;
            }
            for (int i = 0; i < tops.length; i++) {
                TopComponent topComponent = tops[i];
                Logger.getLogger(getClass().getName()).log(Level.INFO, "topComponent openned " + topComponent.getName());

            }
        }
        if (lookupEvent == null) {
            return;
        }
        Logger.getLogger(getClass().getName()).log(Level.INFO, "result changed " + lookupEvent.toString());
        Lookup.Result r = (Lookup.Result) lookupEvent.getSource();
        if (r == null) {
            return;
        }
        Logger.getLogger(getClass().getName()).log(Level.INFO, "result changed " + r.toString());
        Collection<GUIManager> coll = r.allInstances();
        if (coll == null) {
            return;
        }
        Logger.getLogger(getClass().getName()).log(Level.INFO, " SIZE  " + coll.size());
        if (!coll.isEmpty()) {
            for (GUIManager cust : coll) {
                Logger.getLogger(getClass().getName()).log(Level.INFO, " GUIManager " + cust);
                if (abstractPanel == null) {
                    continue;
                }

                abstractPanel.setParentRoot(cust);
                abstractPanel.initJComponents();
                // List<Binding> bindings = abstractPanel.getBindingGroup().getBindings();
               /* for (Iterator<Binding> it = bindings.iterator(); it.hasNext();) {
                 Binding binding = it.next();
                 Object sourceObject = binding.getSourceObject();
                 if (sourceObject == null) {
                 //binding.unbind();
                 //sourceObject = cust;
                 //binding.setSourceObject(sourceObject);
                 // binding.bind();
                 } else {
                 if (sourceObject instanceof GUIManager) {
                 sourceObject = cust;
                 binding.unbind();
                 binding.setSourceObject(sourceObject);
                 binding.bind();
                 } else {
                 Logger.getLogger(getClass().getName()).log(Level.INFO, " ALREADY binding.... " + sourceObject + " " + sourceObject.getClass());
                 }

                 }
                 }*/

            }
        } else {
            Logger.getLogger(getClass().getName()).log(Level.INFO, " GUIManager empty ");
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (abstractPanel != null) {
                    abstractPanel.repaint();
                } else {
                    throw new RuntimeException(getName());
                }
            }
        });

    }
}
