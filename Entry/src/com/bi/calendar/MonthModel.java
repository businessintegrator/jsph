package com.bi.calendar;
import java.util.*;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class MonthModel implements ComboBoxModel<String> {
	private List<ListDataListener> dataListener = Collections
			.synchronizedList(new LinkedList<ListDataListener>());
	private Object selected;

	
	public MonthModel() {
		super();
		this.selected = getElementAt(Calendar.getInstance().get(Calendar.MONTH));
	}

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
		switch (arg0+1) {
		case 1:

			return "Janvier";
		case 2:

			return "Février";
		case 3:

			return "Mars";
		case 4:

			return "Avril";
		case 5:

			return "Mai";
		case 6:

			return "Juin";
		case 7:

			return "Juillet";
		case 8:

			return "Août";
		case 9:

			return "Septembre";
		case 10:

			return "Octobre";
		case 11:

			return "Novembre";
		case 12:

			return "Decembre";
		default:
			return null;
		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 12;
	}

}
