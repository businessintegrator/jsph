/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel.sub;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public final class PComboModel implements ComboBoxModel<String> {

    static private List<String> TEMPLATE = new LinkedList<String>();
    private List<ListDataListener> listeners = Collections.synchronizedList(new LinkedList<ListDataListener>());
    private List<String> list = new LinkedList<String>();
    private String selected;

    static {
	Properties p = new Properties();
	try {
	    p.load(PComboModel.class.getResourceAsStream("civilite.properties"));
	    for (Map.Entry<Object, Object> entry : p.entrySet()) {
		Object object = entry.getKey();
		Object object1 = entry.getValue();
		TEMPLATE.add(object1.toString());

	    }
	} catch (IOException ex) {
	    Exceptions.printStackTrace(ex);
	}
    }

    public static List<String> getTEMPLATE() {
	return TEMPLATE;
    }

    public PComboModel() {
	if (list.isEmpty()) {
	    list.addAll(getTEMPLATE());
	}
    }

    @Override
    public void setSelectedItem(Object anItem) {
	this.selected = anItem.toString();
    }

    @Override
    public Object getSelectedItem() {
	return this.selected;
    }

    @Override
    public int getSize() {
	return list.size();
    }

    @Override
    public void addListDataListener(ListDataListener l) {
	this.listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
	this.listeners.remove(l);
    }

    @Override
    public String getElementAt(int index) {
	return list.get(index);
    }
}
