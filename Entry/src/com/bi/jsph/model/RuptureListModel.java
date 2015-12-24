/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jsph.model;

import com.bi.jsph.model.ConventionListModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class RuptureListModel implements ListModel<String> {

    private List<ListDataListener> listener =  Collections.synchronizedList(new LinkedList<ListDataListener>());
    ArrayList<String> rupture = new ArrayList<String>(60);

    public RuptureListModel() {
        Properties p = new Properties();
        try {
            p.load(ConventionListModel.class.getClassLoader().getResourceAsStream("resources/rupture.properties"));
            for (Iterator<?> it = p.entrySet().iterator(); it.hasNext();) {
                Map.Entry<String,String> item = (Map.Entry<String,String>) it.next();
                rupture.add(item.getValue());
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        Collections.sort(rupture);
    }

    @Override
    public int getSize() {
        return rupture.size();
    }

    @Override
    public String getElementAt(int index) {
        return rupture.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        listener.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        listener.remove(l);
    }
    
}
