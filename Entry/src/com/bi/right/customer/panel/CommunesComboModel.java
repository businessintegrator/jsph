/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import com.bi.right.customer.util.GlobalParameters;
import com.bi.right.customer.util.ProcheConseil;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class CommunesComboModel implements ComboBoxModel<ProcheConseil>, ListModel<ProcheConseil>, Runnable {

    private List<ListDataListener> listeners = Collections.synchronizedList(new LinkedList<ListDataListener>());
    private final List<ProcheConseil> list = new LinkedList<ProcheConseil>();
    private final List<ProcheConseil> filteredList = new LinkedList<ProcheConseil>();
    private boolean filtered = false;
    private final static CommunesComboModel instance = new CommunesComboModel();

    public static CommunesComboModel getInstance() {
	return instance;
    }

    public CommunesComboModel filter(String filter) {
	int formerSize = getSize();
	if (filter != null && !"".equals(filter.trim())) {


	    for (ProcheConseil object : list) {
		if (object.getCommune().toUpperCase().contains(filter.toUpperCase())) {
		    if (!filteredList.contains(object)) {
			filteredList.add(object);
		    }
		} else {
		    filteredList.remove(object);

		}
	    }
	    int newSize = filteredList.size();
	    notifyModelChanged(newSize, formerSize);

	    filtered = true;

	} else {
	    filtered = false;
	    filteredList.clear();
	    int newSize = list.size();
	    notifyModelChanged(newSize, formerSize);

	}
	return instance;
    }

    public CommunesComboModel unfilter() {
	filtered = false;

	return instance;

    }
    private Object selected;

    public CommunesComboModel() {
	new Thread(this).run();
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
	return filtered ? filteredList.size() : list.size();
    }

    @Override
    public ProcheConseil getElementAt(int index) {
	return filtered ? filteredList.get(index) : list.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
	listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
	listeners.add(l);
    }

    public void fire(int index0, int index1) {
	ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, index0, index1);
	for (ListDataListener listDataListener : listeners) {

	    listDataListener.contentsChanged(e);

	}
    }

    @Override
    public void run() {
	GlobalParameters communes = GlobalParameters.getInstance();
	communes.loadCommunes();
	for (Map.Entry<String, String> en : communes.COMMUNES.entrySet()) {
	    String commune = en.getKey();
	    String conseil = en.getValue();
	    list.add(new ProcheConseil(commune, conseil));
	}
    }

    private void fireRemoved(int index0, int index1) {
	ListDataEvent e = new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, index0, index1);
	for (ListDataListener listDataListener : listeners) {

	    listDataListener.contentsChanged(e);

	}
    }

    private void fireAdded(int index0, int index1) {
	ListDataEvent e = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, index0, index1);
	for (ListDataListener listDataListener : listeners) {

	    listDataListener.contentsChanged(e);

	}
    }

    private void notifyModelChanged(int newSize, int formerSize) {
	fire(0, newSize);
	if (formerSize < newSize) {
	    fireAdded(formerSize, newSize);
	} else if (formerSize > newSize) {
	    fireRemoved(newSize, formerSize);
	}
    }
}
