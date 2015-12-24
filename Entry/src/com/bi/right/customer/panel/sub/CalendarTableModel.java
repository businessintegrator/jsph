/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel.sub;

import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class CalendarTableModel implements TableModel {
    private Calendar now;
    

    public Calendar getNow() {
        return now = Calendar.getInstance();
    }

    public void setNow(Calendar now) {
        this.now = now;
    }

    public int getYear() {
        return getNow().get(Calendar.YEAR);
    }

    public void setYear(int year) {
        getNow().set(Calendar.YEAR,year);
        fireChanges();
    }

    public int getMonth() {
        return getNow().get(Calendar.MONTH);
    }

    public void setMonth(int month) {
        getNow().set(Calendar.MONTH,month);
        fireChanges();
    }

    public Calendar getSelected() {
        return selected;
    }

    public void setSelected(Calendar selected) {
        this.selected = selected;
    }
    
    
    private Calendar selected;
    
    private List<TableModelListener> listeners = Collections.synchronizedList(new LinkedList<TableModelListener>());

    public CalendarTableModel() {
    }

    @Override
    public int getRowCount() {
        return 6;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "L";
            case 1:
                return "M";
            case 2:
                return "M";
            case 3:
                return "J";
            case 4:
                return "V";
            case 5:
                return "S";
            case 6:
                return "D";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Calendar.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Calendar now1 = Calendar.getInstance();	
     now1.set(Calendar.DAY_OF_WEEK, columnIndex);
     now1.set(Calendar.WEEK_OF_MONTH, rowIndex);
     return now1;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }
    @Override
    public void addTableModelListener(TableModelListener l) {
        this.listeners.add(l);
    }
    @Override
    public void removeTableModelListener(TableModelListener l) {
        this.listeners.remove(l);
    }
    
    public Calendar getCalendarValueAt(int rowIndex, int columnIndex){
        return (Calendar)getValueAt(rowIndex,  columnIndex) ;
    }

    private void fireChanges() {
        TableModelEvent e = new TableModelEvent(this, 0, getRowCount()-1);
        for (Iterator<TableModelListener> it = listeners.iterator(); it.hasNext();) {
            TableModelListener tableModelListener = it.next();
            tableModelListener.tableChanged(e);
        }
    }
}
