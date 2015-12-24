package com.bi.calendar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.util.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * 
 * @author rafaralahitsimba tiaray
 */
public class CalendarPopupModel implements TableModel {
	private int seletedMonth = 4;
	private int selectedDay;
	private int selectedYear = 2013;
	private List<D> selected = new LinkedList<D>();
	private List<TableModelListener> modelListener = Collections
			.synchronizedList(new LinkedList<TableModelListener>());

	public CalendarPopupModel() {
		super();
		// TODO Auto-generated constructor stub

		fillCalend2(-1,-1);
	}

	private void fillCalend2(int month,int year) {
		Calendar c1 = Calendar.getInstance();
		Calendar c = null;
		for(int row =0;row<6;row++){
		for (int col=0;col<7;col++){
			
				if(c == null){ 
					c =(Calendar) c1.clone();
					if (year > 0){
					 c.set(Calendar.YEAR, year);
					 c.set(Calendar.MONTH, month);
					}
					c.set(Calendar.WEEK_OF_MONTH,row+1);
					c.set(Calendar.DAY_OF_WEEK, col+1);
					//c.set(Calendar.DAY_OF_MONTH, row*7+col);
					int dofmonth = c.get(Calendar.DAY_OF_MONTH);
					//recuer d'une week
					c.add(Calendar.WEEK_OF_YEAR, -(Math.round(dofmonth/7)+1));
					
				} else{
					c =(Calendar)c.clone();
					c.add(Calendar.DAY_OF_YEAR, 1);
				}
							
				D ddd =new D(c);
				selected.add(row*7+col,ddd);
			}
		}
	Collections.sort(selected);	
	}

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		CalendarPopupModel model = new CalendarPopupModel();
		JFrame f = new JFrame();
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		JComboBox<String> jcombomonth = new JComboBox<String>();
		ComboBoxModel<String> monthModel = new MonthModel();
		ItemListener monthItemstnr = new MonthLstnr(model);
		jcombomonth.addItemListener(monthItemstnr);
		jcombomonth.setModel(monthModel);
		JComboBox<String> jcomboyearth = new JComboBox<String>();
		ComboBoxModel<String> yearModel = new YearModel();
		ItemListener yearitemlstnr = new YearLstnr(model);
		jcomboyearth.addItemListener(yearitemlstnr);
		jcomboyearth.setModel(yearModel);
		north.add(jcombomonth);
		north.add(jcomboyearth);
		f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.add(north, BorderLayout.NORTH);
	
		JScrollPane p = new JScrollPane();
		Dimension ddd = new Dimension(70 * 4, 70 * 7);
	
		p.setAutoscrolls(true);
		JTable jtable = new JTable();
		jtable.setSize(ddd);
	
		jtable.setRowHeight(70);

		jtable.setDefaultRenderer(D.class, new Dr());

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
		return D.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public String getColumnName(int arg0) {
		switch (arg0 + 1) {
		case Calendar.SUNDAY:
			return "Di";
		case Calendar.MONDAY:
			return "Lu";
		case Calendar.TUESDAY:
			return "Ma";
		case Calendar.WEDNESDAY:
			return "Me";
		case Calendar.THURSDAY:
			return "Je";
		case Calendar.FRIDAY:
			return "Ve";
		case Calendar.SATURDAY:
			return "Sa";
		

		default:
			return null;
		}
	}

	@Override
	public int getRowCount() {
//return 5;
		return 6;
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		return selected.get((row) * 7 + (col));
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
				fillCalend2(seletedMonth,selectedYear<0?2013:selectedYear);
				
				for (Iterator iterator = modelListener.iterator(); iterator.hasNext();) {
					TableModelListener type = (TableModelListener) iterator.next();
					type.tableChanged(evt);
				}
				
			}
		});
		
	}

	public void fireYear(int parseInt) {
		selectedYear = parseInt;
		fire();

	}
}
