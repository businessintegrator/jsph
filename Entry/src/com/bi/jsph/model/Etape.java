/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jsph.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class Etape implements ListModel<String> {

    private List<ListDataListener> listener = Collections.synchronizedList(new LinkedList<ListDataListener>());
    
    ArrayList<String> convetions = new ArrayList<String>(260);
    

    public Etape() {
        Properties p = new Properties();
        try {
            InputStream in = ConventionListModel.class.getClassLoader().getResourceAsStream("resources/etap.properties");
            p.load(in);
            if (in != null){
            in.close();
            }
            for (Iterator<?> it = p.entrySet().iterator(); it.hasNext();) {
                Map.Entry<String,String> item = (Map.Entry<String,String>) it.next();
                convetions.add(item.getValue()+" - "+item.getKey());

            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    @Override
    public int getSize() {
        return convetions.size();
    }

    @Override
    public String getElementAt(int index) {
        return convetions.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.listener.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.listener.remove(l);
    }
}
