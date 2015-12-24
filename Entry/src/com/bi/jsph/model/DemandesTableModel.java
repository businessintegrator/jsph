/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jsph.model;

import com.bi.right.customer.bo.Demande;
import com.bi.right.customer.bo.Interval;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class DemandesTableModel implements TableModel {

    private final static boolean LIGHT = true;
    
    private static ArrayList<Demande> templates = new ArrayList<Demande>();
    private List<TableModelListener> listeners = Collections.synchronizedList(new LinkedList<TableModelListener>());
    private ArrayList<Demande> list = null;
    private final static javax.swing.ImageIcon IC = new javax.swing.ImageIcon(DemandesTableModel.class.getResource("/resources/empty/editer32.png"));
    private final static javax.swing.ImageIcon DEL = new javax.swing.ImageIcon(DemandesTableModel.class.getResource("/resources/empty/del32.png"));

    static {
	Properties p = new Properties();
	try {
	    p.load(ConventionListModel.class.getClassLoader().getResourceAsStream("resources/demandes.properties"));
	    for (Iterator<?> it = p.entrySet().iterator(); it.hasNext();) {
		Map.Entry<String, String> item = (Map.Entry<String, String>) it.next();
		Demande d = new Demande();
		d.setLbl(item.getKey());
		d.setArtlaw(item.getValue());
		templates.add(d);
	    }
	} catch (IOException ex) {
	    Exceptions.printStackTrace(ex);
	}
    }

    public ArrayList<Demande> getList() {
	return list;
    }

    public ArrayList<Demande> filterSelected() {
	ArrayList<Demande> filterSelectedList = null;
	for (Iterator<Demande> it = list.iterator(); it.hasNext();) {
	    Demande demande = it.next();
	    if (demande != null) {
		if (demande.isSelected()) {
		    if (filterSelectedList == null) {
			filterSelectedList = new ArrayList<Demande>();
		    }
		    filterSelectedList.add(demande);
		}
	    }
	}
	return filterSelectedList;
    }
    

    public DemandesTableModel() {
	list = new ArrayList<Demande>();
	list.addAll((ArrayList<Demande>) templates.clone());
    }

    public DemandesTableModel(ArrayList<Demande> external) {
	this.list = external;
	//list.addAll((ArrayList<Demande>) templates.clone());
    }

    @Override
    public int getRowCount() {
	return list.size();
    }

    @Override
    public int getColumnCount() {
	return LIGHT ? 9 : 9;
    }

    @Override
    public String getColumnName(int columnIndex) {
	if (LIGHT) {
	    switch (columnIndex) {
		case 0:
		    return "Editer";
		case 1:
		    return "Argumenté";
		case 2:
		    return "Sélectionné";
		case 3:
		    return "Libellé";
		case 4:
		    return "Montant";
		case 5:
		    return "Début dd/mm/yyyy";
		case 6:
		    return "Fin dd/mm/yyyy";
		case 7:
		    return "Reconventionnel";
		case 8:
		    return "Supprimer";    
		default:
		    return "Argumenté";
	    }
	}
	switch (columnIndex) {
	    case 0:
		return "Argumenté";
	    case 1:
		return "Art";
	    case 2:
		return "Conv";
	    case 3:
		return "Libellé";
	    case 4:
		return "Début dd/mm/yyyy";
	    case 5:
		return "Fin dd/mm/yyyy";
	    case 6:
		return "Precision";
	    case 7:
		return "Montant";
	    case 8:
		return "-";
	    default:
		return "*";
	}
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
	if (LIGHT) {
	    switch (columnIndex) {
		case 0:
		    return ImageIcon.class;
		case 1:
		    return Boolean.class;
		case 2:
		    return Boolean.class;
		case 3:
		    return String.class;
		case 4:
		    return String.class;
		case 5:
		    return Date.class;
		case 6:
		    return Date.class;
		case 7:
		    return List.class;
		case 8:    
		    return ImageIcon.class;    
		default:
		    return Boolean.class;
	    }
	} else {
	    switch (columnIndex) {
		case 0:
		    return Boolean.class;
		case 1:

		case 2:

		case 3:
		    return String.class;
		case 4:
		    return String.class;
		case 5:
		    return String.class;
		case 6:
		    return String.class;
		case 7:
		    return String.class;
		case 8:
		    return String.class;

		default:
		    return Boolean.class;
	    }
	}
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	if (columnIndex == 0 ||columnIndex == 8) {
	    return false;
	}
	return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	Demande d = list.get(rowIndex);

	Interval intv = d.getIdinterval();
	if (LIGHT) {
	    SimpleDateFormat sdfg = new SimpleDateFormat("dd/MM/yyyy");
	    switch (columnIndex) {

		case 0:
		    return IC;
		case 1:
		    return Boolean.valueOf(d.isArgumented());
		case 2:
		    return Boolean.valueOf(d.isSelected());
		case 3:

		    return d.getLbl();
		case 4:
		    return d.getAmount().toString();
		case 5:
		    if (d.getIdinterval().getStartdt() == null) {
			return null;
		    }
		    return sdfg.format(d.getIdinterval().getStartdt());
		case 6:
		    if (d.getIdinterval().getEnddt() == null) {
			return null;
		    }
		    return sdfg.format(d.getIdinterval().getEnddt());
		case 7:
		    return d.getDemanderefList();
		case 8:
		    return DEL;    
		default:
		    return d.isSelected();
	    }
	} else {
	    switch (columnIndex) {
		case 0:
		    return Boolean.valueOf(d.isSelected());
		case 1:
		    return d.getArtlaw();
		case 2:
		    return d.getArtconv();
		case 3:
		    return d.getLbl();
		case 4:

		    return (intv.getStartdt() != null) ? intv.getStartdt() : null;
		case 5:

		    return (intv.getEnddt() != null) ? intv.getEnddt() : null;
		case 6:
		    return d.getPrecision();
		case 7:
		    return d.getAmount().toString();
		case 8:
		    return " ";
		default:
		    return d.isSelected();
	    }
	}
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	Demande d = list.get(rowIndex);
	if (d == null) {
	    return;
	    // d = new Demande();
	    // list.add(d);
	}
	Interval intv = d.getIdinterval();
	if (LIGHT) {
	    switch (columnIndex) {
		case 0:
		    //d.setArgumented(Boolean.parseBoolean(aValue.toString()));
		    break;
		case 1:
		    d.setArgumented(Boolean.parseBoolean(aValue.toString()));
		    break;
		case 2:
		    d.setSelected(Boolean.parseBoolean(aValue.toString()));
		    break;
		case 3:
		    d.setLbl(aValue.toString());
		    break;
		case 4:
		    d.setAmount(Double.valueOf(aValue.toString()));
		    break;
		case 5:
		    if (aValue != null && !"".equals(aValue.toString().trim())) {
			Pattern p = Pattern.compile("\\d+/\\d+/\\d+");
			Matcher m = p.matcher((String) aValue);
			if (m.matches()) {
			    SimpleDateFormat sdfg = new SimpleDateFormat("dd/MM/yyyy");
			    try {
				d.getIdinterval().setStartdt(sdfg.parse((String) aValue));

			    } catch (ParseException ex) {
				//Exceptions.printStackTrace(ex);
			    }
			}
		    }
		    break;
		case 6:
		    if (aValue != null && !"".equals(aValue.toString().trim())) {
			Pattern p = Pattern.compile("\\d+/\\d+/\\d+");
			Matcher m = p.matcher((String) aValue);
			if (m.matches()) {
			    try {
				SimpleDateFormat sdfg = new SimpleDateFormat("dd/MM/yyyy");
				d.getIdinterval().setEnddt(sdfg.parse((String) aValue));
			    } catch (ParseException ex) {
				//Exceptions.printStackTrace(ex);
			    }
			}
		    }
		    break;
		default:
		    d.setSelected(Boolean.parseBoolean(aValue.toString()));
	    }
	} else {
	    switch (columnIndex) {
		case 0:
		    d.setSelected(Boolean.parseBoolean(aValue.toString()));
		    break;
		case 1:
		    d.setArtlaw(aValue.toString());
		    break;
		case 2:
		    d.setArtconv(aValue.toString());
		    break;
		case 3:
		    d.setLbl(aValue.toString());
		    break;
		case 4:
		    if (intv == null) {
			intv = new Interval();
		    }
		    intv.setStartdt((Date) aValue);
		    break;
		case 5:
		    if (intv == null) {
			intv = new Interval();
		    }
		    intv.setEnddt((Date) aValue);
		    break;
		case 6:
		    d.setPrecision(aValue.toString());
		    break;
		case 7:
		    d.setAmount(Double.valueOf(aValue.toString()));
		    break;
		case 8:
		    break;
		default:
		    d.setSelected(Boolean.parseBoolean(aValue.toString()));
	    }
	}
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
	this.listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
	this.listeners.remove(l);
    }

    public Double total() {
	double result = 0;
	for (Iterator<Demande> it = list.iterator(); it.hasNext();) {
	    Demande demande = it.next();
	    result += demande.getAmount();
	}
	return result;
    }

    public void addDemande(Demande d) {
	list.add(d);
	fireEvent();
    }

    public Demande getDemande(int row) {
	if (list == null) {
	    return null;
	}
	return list.get(row);
    }

    public void removeDemande(int row) {
	if (list.size()<row ||row <0){return;}
	list.remove(row);
	fireDelete(row);
    }

    private void fireEvent() {
	final TableModelEvent e = new TableModelEvent(this);
	notifyListeners(e);
    }

    private void fireDelete(int row) {
	
	final TableModelEvent e = new TableModelEvent(this);
	notifyListeners(e);
    }

    private void notifyListeners(final TableModelEvent e) {
	for (Iterator<TableModelListener> it = listeners.iterator(); it.hasNext();) {
	    TableModelListener listener = it.next();
	    listener.tableChanged(e);
	}
    }
}
