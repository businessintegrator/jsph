package com.bi.calendar;
import java.util.Calendar;

public class D implements Comparable{
	private Calendar c;

	public D(Calendar calendar) {
		super();
		
		this.c = calendar;
		
	}

	public String getSelectedHour(){
	    int h= c.get(Calendar.HOUR_OF_DAY);
	    int m = c.get(Calendar.MINUTE);
	    return ((h<10)?("0"+h):h)+":"+((m<10)?("0"+m):m);
	}
	
	public int getSeletedMonth() {
		return c.get(Calendar.MONTH);
	}

	public void setSeletedMonth(int seletedMonth) {
		c.set(Calendar.MONTH,seletedMonth);
	}

	public int getSelectedDay() {
		return  c.get(Calendar.DAY_OF_MONTH);
	}

	public void setSelectedDay(int selectedDay) {
		c.set(Calendar.DAY_OF_MONTH,selectedDay);
	}

	public int getSelectedYear() {
		return c.get(Calendar.YEAR);
	}

	public void setSelectedYear(int selectedYear) {
		c.set(Calendar.YEAR,selectedYear);
	}

	public Calendar getC() {
		return c;
	}

	public void setC(Calendar c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return getSelectedDay()+"/" + getSeletedMonth()
				
				+ "/" + getSelectedYear() + "]";
	}

	@Override
	public int compareTo(Object arg0) {
		if (arg0 == null)return 1;
		if (arg0 instanceof D){
			return c.compareTo(((D)arg0).c);
		}
		return 0;
	}

	
}
