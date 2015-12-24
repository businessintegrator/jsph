package com.bi.calendar;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;


public class MonthLstnr implements ItemListener {

	private CalendarPopupModel internal;


	public MonthLstnr(CalendarPopupModel model) {
		// TODO Auto-generated constructor stub
	   this.internal = model;
	}
	

	@Override
	public void itemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getStateChange() == ItemEvent.SELECTED){
			internal.fireMonth(((JComboBox<?>)evt.getSource()).getSelectedIndex());
			
		}

	}


	public CalendarPopupModel getInternal() {
		return internal;
	}


	public void setInternal(CalendarPopupModel internal) {
		this.internal = internal;
	}

}
