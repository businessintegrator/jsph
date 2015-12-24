/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jsph.model;

import com.bi.right.customer.bo.SousPiece;
import java.util.*;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class FileListModel implements ListModel<SousPiece> {
private ArrayList<SousPiece> files = null;
    private List<ListDataListener> dataListener = Collections.synchronizedList(new LinkedList<ListDataListener>());
    

    public FileListModel(ArrayList<SousPiece> pfiles) {
        if (pfiles != null && !pfiles.isEmpty()){
          this.files = pfiles;
          fireAdd(this.files.get(0), 0);
        } else {
            files = new ArrayList<SousPiece>();
        }
    }

    public FileListModel() {
        files = new ArrayList<SousPiece>();
    }

    public void add(int index, SousPiece element) {
        files.add(index, element);
        element.setIndex(index);
        
        fireAdd(element, index);
        
    }

   

    public boolean remove(SousPiece o) {
        boolean result =  files.remove(o);
        fireRemoved(o,0);
        return result;
    }

    public boolean contains(String o) {
        return files.contains(o);
    }

    public boolean add(SousPiece e) {
        boolean result =  files.add(e);
        fireAdd(e, 0);
        return result;
    }

    public void clear() {
        files.clear();
	fireCleared();
    }

    @Override
    public int getSize() {
        return files.size();
    }

    @Override
    public SousPiece getElementAt(int index) {
        return files.get(index);

    }

    @Override
    public void addListDataListener(ListDataListener l) {
        dataListener.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        dataListener.remove(l);
    }

    private void fireAdd(Object e, int index) {
        int start = index;
        int end = getSize();
        if (e == null && index <0){
            start = 0;
        }
        final ListDataEvent evt = new ListDataEvent(e, ListDataEvent.INTERVAL_ADDED, start, end);
        for (Iterator<ListDataListener> it = dataListener.iterator(); it.hasNext();) {
            ListDataListener listDataListener = it.next();
            listDataListener.intervalAdded(evt);
        }
    }

    private void fireRemoved(Object e, int index) {
        final ListDataEvent evt = new ListDataEvent(e, ListDataEvent.INTERVAL_REMOVED, index, index);
        for (Iterator<ListDataListener> it = dataListener.iterator(); it.hasNext();) {
            ListDataListener listDataListener = it.next();
            listDataListener.intervalRemoved(evt);
        }
    }
       private void fireCleared() {
        final ListDataEvent evt = new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, 0, files.size());
        for (Iterator<ListDataListener> it = dataListener.iterator(); it.hasNext();) {
            ListDataListener listDataListener = it.next();
            listDataListener.intervalRemoved(evt);
        }
    }
    
     private void fireUpdated(Object e, int index,int indexEnd) {
        final ListDataEvent evt = new ListDataEvent(e, ListDataEvent.CONTENTS_CHANGED, index, indexEnd);
        for (Iterator<ListDataListener> it = dataListener.iterator(); it.hasNext();) {
            ListDataListener listDataListener = it.next();
            listDataListener.contentsChanged(evt);
        }
    }

    public ArrayList<SousPiece> getFiles() {
        return files;
    }

    public void up(SousPiece obj,int index) {
        
        files.remove(obj);
        fireRemoved(obj, index);
        files.add(index-1,obj);
        fireAdd(obj, index-1);
        resort(obj,index-1);
    }

    public void down(SousPiece obj, int index) {
        files.remove(obj);
        fireRemoved(obj, index);
        files.add(index+1,obj);
        fireAdd(obj, index+1);
        resort(obj,index);
    }

    private void resort(SousPiece obj,int startIndex) {
        for (int i = 0; i < files.size(); i++) {
            SousPiece sousPiece = files.get(i);
            sousPiece.setIndex(i);
        }
        fireUpdated(obj, startIndex, files.size()-1);
    }
}
