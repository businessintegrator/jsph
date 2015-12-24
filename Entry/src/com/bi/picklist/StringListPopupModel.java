package com.bi.picklist;

import com.bi.right.customer.util.GlobalParameters;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringListPopupModel implements TableModel {

    private int seletedMonth = 4;
    private int selectedDay;
    private int selectedYear = 2013;
    private List<String> selected = new LinkedList<String>();
    List<String> filtered = null;
    private List<TableModelListener> modelListener = Collections
	    .synchronizedList(new LinkedList<TableModelListener>());

    public StringListPopupModel() {
	super();
	// TODO Auto-generated constructor stub

	fillCalend2(4, 2013);
    }

    private void fillCalend2(int month, int year) {
//		Calendar c1 = Calendar.getInstance();
//		Calendar c = null;
//		for (int row = 0; row < 5; row++) {
//			for (int col = 0; col < 7; col++) {
//
//				String ddd = new String("row" + row + "m" + col);
//				System.out.println(ddd);
//
//				selected.add(row * 7 + col, ddd);
//			}
//		}
//		Collections.sort(selected);
	GlobalParameters communes = GlobalParameters.getInstance();
	communes.loadCommunes();
	selected.addAll(communes.COMMUNES.keySet());

    }
    // private void fillCalend() {
    // Calendar c = Calendar.getInstance();
    //
    // int dow = c.get(Calendar.DAY_OF_WEEK);
    // int week = c.get(Calendar.WEEK_OF_MONTH);
    // System.out.println(dow+";;;;;"+week);
    //
    // int index = 7*(week-1)+dow;
    // System.out.println("index :"+index);
    //
    // Calendar c2 = null;
    // int f = 0;
    // for (int k = index;0<k;k--){
    // c2 =(Calendar) c.clone();
    // c2.add(Calendar.DAY_OF_YEAR, -k);
    // System.out.println(c2.getTime());
    // selected.add(new String(c2));
    // f++;
    // if (c2.get(Calendar.DAY_OF_MONTH)==1){
    // System.out.println("*-*-*-"+c2.get(Calendar.DAY_OF_MONTH));
    //
    // break;
    // }
    //
    // }
    // System.out.println("*-*-*-*-*-*-*-*");
    // Calendar c3 = c2;
    // for (int i = f; i < 35; i++) {
    // c3 =(Calendar) c3.clone();
    // c3.add(Calendar.DAY_OF_YEAR, 1);
    // System.out.println(c3.getTime());
    // selected.add(new String(c3));
    // }
    // seletedMonth = c.get(Calendar.MONTH);
    // selectedYear = c.get(Calendar.YEAR);
    // selectedDay = c.get(Calendar.DAY_OF_MONTH);
    // //fire();
    // }
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
	StringListPopupModel model = new StringListPopupModel();
	JFrame f = new JFrame();
	JPanel north = new JPanel();
	north.setLayout(new BorderLayout());
	JTextField tjcombomonth = new JTextField();

	north.add(tjcombomonth, BorderLayout.CENTER);
	tjcombomonth.addKeyListener(new ACTey(model));

	f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	f.setLayout(new BorderLayout());
	f.add(north, BorderLayout.NORTH);

	JScrollPane p = new JScrollPane();
	Dimension ddd = new Dimension(70 * 4, 70 * 7);

	p.setAutoscrolls(true);
	JTable jtable = new JTable();
	jtable.setSize(ddd);

	jtable.setRowHeight(70);

	jtable.setDefaultRenderer(String.class, new Dr());

	jtable.setModel(model);
	p.getViewport().add(jtable);
	// p.getViewport().setSize(new Dimension(6*70, 7*70));
	f.add(p, BorderLayout.CENTER);
	f.pack();
	f.setVisible(true);

    }

    @Override
    public void addTableModelListener(TableModelListener arg0) {
	this.modelListener.add(arg0);

    }

    @Override
    public Class<?> getColumnClass(int arg0) {
	// TODO Auto-generated method stub
	return String.class;
    }

    @Override
    public int getColumnCount() {
	// TODO Auto-generated method stub
	return 1;
    }

    @Override
    public String getColumnName(int arg0) {
	switch (arg0) {
	    case 0:
		return "Nom";
	    case 1:
		return "Code Postal";
	    default:
		return null;
	}
    }

    @Override
    public int getRowCount() {
	if (filtered != null) {
	    return filtered.size();
	}
	return selected.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
	if (filtered != null) {
	    return filtered.get(row);
	}
	return selected.get(row);
    }

    @Override
    public boolean isCellEditable(int arg0, int arg1) {

	return false;
    }

    @Override
    public void removeTableModelListener(TableModelListener arg0) {
	this.modelListener.add(arg0);

    }

    @Override
    public void setValueAt(Object arg0, int arg1, int arg2) {
    }

    public void fireMonth(int parseInt) {
	seletedMonth = parseInt;
	fire();

    }

    private void fire() {
	final TableModelEvent evt = new TableModelEvent(this);
	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		selected.clear();
		fillCalend2(seletedMonth, selectedYear < 2000 ? 2013
			: selectedYear);

		for (Iterator iterator = modelListener.iterator(); iterator
			.hasNext();) {
		    TableModelListener type = (TableModelListener) iterator
			    .next();
		    type.tableChanged(evt);
		}

	    }
	});

    }

    public void fireYear(int parseInt) {
	selectedYear = parseInt;
	fire();

    }

    public void filter(String text) {
	if (text == null || "".equals(text.trim())) {
	    filtered = null;
	} else {
	    String pat = text.replace('(', '.');
	    pat = pat.replace(')', '.');
	    pat = pat.replace(']', '.');
	    pat = pat.replace('[', '.');
	    pat = pat.replace('$', '.');
	    pat = pat.replace('\\', '.');
	    pat = pat.replace('^', '.');
	    Pattern p = Pattern.compile(pat.trim().toLowerCase() + ".*");

	    if (filtered != null) {
		filtered.clear();
	    } else {

		filtered = new LinkedList<String>();
	    }
	    for (Iterator iterator = selected.iterator(); iterator.hasNext();) {
		String string = (String) iterator.next();
		Matcher m = p.matcher(string.toLowerCase());
		if (m.matches()) {
		    filtered.add(string);
		}

	    }

	}
	TableModelEvent evt = new TableModelEvent(this);
	for (Iterator iterator = modelListener.iterator(); iterator.hasNext();) {
	    TableModelListener type = (TableModelListener) iterator.next();

	    type.tableChanged(evt);
	}

    }
}
