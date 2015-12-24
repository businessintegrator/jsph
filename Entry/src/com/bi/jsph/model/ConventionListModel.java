/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jsph.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class ConventionListModel implements ListModel<String> {

    private List<ListDataListener> listener = Collections.synchronizedList(new LinkedList<ListDataListener>());
    private ArrayList<String> convetions = new ArrayList<String>();
    private ArrayList<String> convetionsFiltered = new ArrayList<String>();
    private boolean filtered = false;

    public ConventionListModel() {
        convetions.add("");
        Properties p = new Properties();
        try {
            p.load(ConventionListModel.class.getClassLoader().getResourceAsStream("resources/conv.properties"));
            for (Iterator<?> it = p.entrySet().iterator(); it.hasNext();) {
                Map.Entry<String,String> item = (Map.Entry<String,String>) it.next();
                convetions.add(item.getValue()/*+" - "+item.getKey()*/);

            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
           Collections.sort(convetions);
    }

    @Override
    public int getSize() {
        return filtered?convetionsFiltered.size():convetions.size();
    }

    @Override
    public String getElementAt(int index) {
        return filtered?convetionsFiltered.get(index):convetions.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.listener.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.listener.remove(l);
    }
    public void filter(String filter) {
	
	int lastSize  = getSize();
	if (filter != null && !"".equals(filter.trim())){
	    
	    for (String c : convetions) {
		if (c.toUpperCase().contains(filter.toUpperCase())){
		  if (!convetionsFiltered.contains(c)){
		    convetionsFiltered.add(c);
		  }
		} else {
		  convetionsFiltered.remove(c);
		}
	    }
	    int newSize = convetionsFiltered.size();
	    fireChangedEnhanced( lastSize, newSize);
	    filtered = true;
	} else {
	    filtered = false;
	     int newSize = convetions.size();
	     fireChangedEnhanced(lastSize, newSize);
	     convetionsFiltered.clear();
	   
	    
	    
	}
	
	
    }

    private void fireAdded(int index0,int index1) {
	ListDataEvent e = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, index0, index1);
	for (ListDataListener listDataListener : listener) {
	    listDataListener.intervalAdded(e);
	    
	}
    }
      private void fire(int index0,int index1) {
	ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, index0, index1);
	for (ListDataListener listDataListener : listener) {
	    listDataListener.contentsChanged(e);
	  
	    
	}
    }
        private void fireRemoved(int index0,int index1) {
	ListDataEvent e = new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, index0, index1);
	for (ListDataListener listDataListener : listener) {
	    listDataListener.intervalRemoved(e);
	    
	}
    }

    private void fireChangedEnhanced(int lastSize, int newSize) {
	 
	if (lastSize<newSize){
	    fire(0,newSize);
	     fireAdded(lastSize, newSize);
	 
	 } else if (lastSize>newSize){
	     fireRemoved(newSize, lastSize);
	     fire(0,newSize);
	 }
	
    }
    
}
