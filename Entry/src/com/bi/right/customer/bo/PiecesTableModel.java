/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.DateComparator;
import java.io.Serializable;
import java.util.*;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafaralahitsimba tiaray
 */
@XmlRootElement(name = "pieces")
@XmlSeeAlso(com.bi.right.customer.bo.Piece.class)
public class PiecesTableModel implements TableModel, Serializable {

    @XmlTransient
    private List<TableModelListener> listeners = Collections.synchronizedList(new LinkedList<TableModelListener>());
    
    private ArrayList<Piece> list = new ArrayList<Piece>();

    public ArrayList<Piece> getList() {
        return list;
    }

    public void setList(ArrayList<Piece> list) {
        this.list = list;
    }

    public PiecesTableModel() {
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return Piece.getColumnCount();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return Piece.getName(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Piece.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Piece row = getPiece(rowIndex);
        return row.getValue(columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Piece row = getPiece(rowIndex);
        row.setValue(aValue, columnIndex);
    }

    @Override
    public void addTableModelListener(TableModelListener li) {
        this.listeners.add(li);
    }

    @Override
    public void removeTableModelListener(TableModelListener li) {
        this.listeners.remove(li);
    }

    public Piece getPiece(int selectedRow) {
        if (selectedRow <0 || selectedRow>= list.size()){return null;}
        Piece row = list.get(selectedRow);

        return row;
    }

    public void add(Piece p) {
        this.list.add(p);
        TableModelEvent e = new TableModelEvent(this);
        for (Iterator it = listeners.iterator(); it.hasNext();) {
            TableModelListener listener = (TableModelListener) it.next();
            listener.tableChanged(e);
        }
        p.setNumero(list.size());

    }

    public void update(int selectedRow) {
        TableModelEvent e = new TableModelEvent(this, selectedRow, selectedRow, 0, TableModelEvent.UPDATE);
        for (Iterator it = listeners.iterator(); it.hasNext();) {
            TableModelListener listener = (TableModelListener) it.next();
            listener.tableChanged(e);
        }
    }

    public void delete(int selectedRow) {
        list.remove(selectedRow);
        final TableModelEvent e = new TableModelEvent(this, selectedRow, selectedRow, 0, TableModelEvent.DELETE);
        for (Iterator it = listeners.iterator(); it.hasNext();) {
            TableModelListener listener = (TableModelListener) it.next();
            listener.tableChanged(e);
        }
    }

    public void sort() {
        Collections.sort(list, new DateComparator());
        for (int i = 0; i < getColumnCount(); i++) {
            final TableModelEvent e = new TableModelEvent(this, 0, list.size(), i, TableModelEvent.UPDATE);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    for (Iterator it = listeners.iterator(); it.hasNext();) {
                        TableModelListener listener = (TableModelListener) it.next();
                        listener.tableChanged(e);
                    }

                }
            });
        }
    }

    public void fill(PiecesTableModel mdl) {
        if (mdl != null) {
            list.clear();
            list.addAll(mdl.list);
        }
        for (int i = 0; i < getColumnCount(); i++) {
            final TableModelEvent e = new TableModelEvent(this, 0, list.size(), i, TableModelEvent.ALL_COLUMNS);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    for (Iterator it = listeners.iterator(); it.hasNext();) {
                        TableModelListener listener = (TableModelListener) it.next();
                        listener.tableChanged(e);
                    }

                }
            });
        }
    }

    public void reindex() {
        
        int idx = 1;
        for (Iterator<Piece> it = list.iterator(); it.hasNext();) {
            Piece p = it.next();
            p.setNumero(idx);
            idx ++;
        }
        for (int i = 0; i < getColumnCount(); i++) {
            final TableModelEvent e = new TableModelEvent(this, 0, list.size(), i, TableModelEvent.INSERT);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    for (Iterator it = listeners.iterator(); it.hasNext();) {
                        TableModelListener listener = (TableModelListener) it.next();
                        listener.tableChanged(e);
                    }

                }
            });
        }
    }
}
