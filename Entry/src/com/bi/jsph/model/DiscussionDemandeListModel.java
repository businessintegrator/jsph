/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jsph.model;

import com.bi.right.customer.bo.Demande;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;

import javax.swing.event.ListDataListener;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class DiscussionDemandeListModel implements ComboBoxModel<Demande> {

    

    private DemandesTableModel demandesModel;
    private List<ListDataListener> listeners =  Collections.synchronizedList(new LinkedList<ListDataListener>());
    private Object selected;

    public DiscussionDemandeListModel() {
    }

    
    public DiscussionDemandeListModel(DemandesTableModel demandesModel) {
        this.demandesModel = demandesModel;
        
    }
    @Override
    public void addListDataListener(ListDataListener l) {
        this.listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.listeners.remove(l);
    }

    public DemandesTableModel getDemandesModel() {
        return demandesModel;
    }

    public void setDemandesModel(DemandesTableModel demandesModel) {
        this.demandesModel = demandesModel;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selected = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.selected;
    }

    @Override
    public int getSize() {
     return this.demandesModel.filterSelected().size();   
    }

    @Override
    public Demande getElementAt(int index) {
        if (index <0 || index > getSize()) return null;
        return this.demandesModel.filterSelected().get(index);
    }

    
}
