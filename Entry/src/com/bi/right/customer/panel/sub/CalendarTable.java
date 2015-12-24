/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel.sub;

import javax.swing.JTable;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class CalendarTable extends JTable {

    private int year;
    private int mounth;

    public CalendarTable() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        ((CalendarTableModel) getModel()).setYear(this.year);
    }

    public int getMounth() {
        return mounth;
    }

    public void setMounth(int mounth) {
        this.mounth = mounth;
        ((CalendarTableModel) getModel()).setMonth(this.mounth+1);
    }
}
