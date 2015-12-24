/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jsph.model;

import com.bi.right.customer.util.Law;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class LawListModel implements ListModel<Law> {

    private List<Law> list = Collections.synchronizedList(new ArrayList<Law>());
    private List<Law> listFiltered = new ArrayList<Law>();
    private List<ListDataListener> listeners = Collections.synchronizedList(new ArrayList<ListDataListener>());
    private boolean filtered = false;

    public LawListModel() {
	
    }

    public LawListModel(List<Law> LAWS) {
	    this.list.addAll(LAWS);
    }

    @Override
    public int getSize() {
	return filtered ? listFiltered.size() : list.size();
    }

    @Override
    public Law getElementAt(int index) {
	return filtered ? listFiltered.get(index) : list.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
	this.listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
	this.listeners.remove(l);
    }

    public boolean add(Law e) {
	return filtered ? listFiltered.add(e) : list.add(e);

    }

    public boolean addAll(Collection<? extends Law> c) {
	boolean added = list.addAll(c);
	notifyAdded();
	return added;
    }

    public void clear() {
	list.clear();
	notifyCleared();
    }

    private void notifyAdded() {
	ListDataEvent event = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, 0, getSize());
	for (Iterator<ListDataListener> it = listeners.iterator(); it.hasNext();) {
	    ListDataListener liste = it.next();
	    liste.intervalAdded(event);
	}
    }

    private void notifyCleared() {
	ListDataEvent event = new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, 0, getSize());
	for (Iterator<ListDataListener> it = listeners.iterator(); it.hasNext();) {
	    ListDataListener liste = it.next();
	    liste.intervalRemoved(event);
	}

    }

    public void filter(String text) {
	int oldSize = getSize();
	if (null != text && !"".equals(text.trim())) {
	    for (Law law : list) {
		if (law.toString().toUpperCase().contains(text.toUpperCase())) {
		    if (!listFiltered.contains(law)) {
			listFiltered.add(law);
		    }
		} else {
		    listFiltered.remove(law);
		}
	    }
	    int newSize = listFiltered.size();
	    notify(oldSize, newSize);
	    filtered = true;
	} else {
	    filtered = false;
	    listFiltered.clear();
	    int newSize = list.size();
	    notifyChanged(0, newSize);

	}
    }

    private void notify(int oldSize, int newSize) {
	if (oldSize < newSize) {
	    notifyChanged(0, oldSize);
	    notifyAdded(oldSize, newSize);
	} else if (oldSize > newSize) {
	    notifyCleared();
	    notifyAdded();
	} else {
	}
    }

    private void notifyChanged(int index, int index1) {
	ListDataEvent event = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, index, index1);

	for (Iterator<ListDataListener> it = listeners.iterator(); it.hasNext();) {
	    ListDataListener liste = it.next();
	    liste.contentsChanged(event);
	}
    }

    private void notifyAdded(int oldSize, int newSize) {
	ListDataEvent event = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, oldSize, newSize);
	for (Iterator<ListDataListener> it = listeners.iterator(); it.hasNext();) {
	    ListDataListener liste = it.next();
	    liste.intervalAdded(event);
	}
    }
}
