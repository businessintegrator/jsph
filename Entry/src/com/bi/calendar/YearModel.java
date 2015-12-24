package com.bi.calendar;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;


public class YearModel implements ComboBoxModel<String> {
    public static final int MINYEAR = 1913;

	
	public YearModel() {
		super();
		this.selected = ""+Calendar.getInstance().get(Calendar.YEAR);
	}

	private List<ListDataListener> dataListener = Collections
			.synchronizedList(new LinkedList<ListDataListener>());
	private Object selected;

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		dataListener.remove(arg0);

	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return selected;
	}

	@Override
	public void setSelectedItem(Object arg0) {
		// TODO Auto-generated method stub
		selected = arg0;
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		dataListener.add(arg0);
	}

	@Override
	public String getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return ""+(arg0+MINYEAR);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 200;
	}


	

}
