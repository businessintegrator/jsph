package com.bi.calendar;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import javax.swing.JComboBox;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Dr extends DefaultTableCellRenderer {

    private final static Color COLOR_today = new Color(153, 255, 153);
    private final static Color COLOR_selected = new Color(153, 255, 153);
    private final static Color COLOR_future = new Color(204, 255, 255);
    private final static Color COLOR_inMonth = new Color(51, 0, 51);
    private final static Color COLOR_nowBefore = new Color(209, 238, 255);
    private final static Color Color_focused = new Color(255, 210, 137);
    /**
     *
     */
    private static final long serialVersionUID = -4766607581692980439L;
    private Calendar startDate = null;
    private WeakReference monthRef = null;
    private WeakReference yearRef = null;
    private Calendar selectedDay;

    public Dr() {
	super();
	// TODO Auto-generated constructor stub*
	startDate = Calendar.getInstance();
    }

    public Dr(Calendar pstartDate) {
	super();
	this.startDate = pstartDate;
    }

    @Override
    public Component getTableCellRendererComponent(JTable arg0, Object arg1,
	    boolean selected, boolean focuesd, int row, int col) {
	if (arg1 == null) {
	    return this;
	}
	Component resut = super.getTableCellRendererComponent(arg0, arg1,
		selected, focuesd, row, col);
	// if (resut instanceof JTextField){
	// JTextField t = (JTextField)resut;
	// t.setCaretColor(Color.YELLOW);
	//
	//
	// }
	if (selected) {
	    resut.setBackground(COLOR_selected);

	} else {
	    resut.setBackground(Color.WHITE);
	}
	if (focuesd) {
	    resut.setBackground(Color_focused);
	} else {
	    resut.setBackground(Color.WHITE);
	}
	Object value = arg1;
	if (value != null &&  value instanceof D) {
	    D d = ((D) value);
	    Calendar now = startDate;

	    if (now.before(d.getC())) {

		if (selected) {
		    resut.setBackground(COLOR_nowBefore);

		} else {
		    resut.setBackground(COLOR_future);
		}
	    }
	    if (exact(now, d)) {
		resut.setBackground(COLOR_today);
	    }
	    if (exact(getSelectedDay(), d)) {
		resut.setBackground(COLOR_selected);
	    }
	    if (isInMonth(d)) {
		resut.setForeground(COLOR_inMonth);

	    } else {
		resut.setForeground(Color.BLACK);
	    }

	}
	return resut;
    }

    private boolean exact(Calendar now, D d) {
	// TODO Auto-generated method stub
	Calendar internal = d.getC();
	return internal.get(Calendar.DAY_OF_YEAR) == now
		.get(Calendar.DAY_OF_YEAR)
		&& internal.get(Calendar.YEAR) == now.get(Calendar.YEAR);

    }

    @Override
    protected void setValue(Object arg0) {
	// TODO Auto-generated method stub
	Object value = arg0;
	if (value instanceof D) {
	    D d = ((D) value);
	    value = "" + d.getSelectedDay();

	    setToolTipText(d.getSelectedDay() + "/" + (d.getSeletedMonth() + 1)
		    + "/" + d.getSelectedYear());

	}
	super.setValue(value);

    }

    public void setMonthComponent(JComboBox<String> jcombomonth) {
	this.monthRef = new WeakReference(jcombomonth);
    }

    public void setYearComponent(JComboBox<String> jcomboyearth) {
	this.yearRef = new WeakReference(jcomboyearth);
    }

    private boolean isInMonth(D date) {
	if (((JComboBox<String>) this.monthRef.get()).getSelectedIndex() == date.getSeletedMonth()) {
	    if (((JComboBox<String>) this.yearRef.get()).getSelectedItem().equals(String.valueOf(date.getSelectedYear()))) {
		return true;
	    }

	}

	return false;

    }

    public Calendar getSelectedDay() {
	return selectedDay;
    }

    public void setSelectedDay(Calendar cal) {
	selectedDay = cal;
    }
}
