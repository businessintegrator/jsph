/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util.renderer;

import com.bi.right.customer.panel.sub.DateTextField;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class DateCelleRenderer extends DefaultTableCellRenderer {

    public final static String DATE = "dd/MM/yyyy HH:mm";

    public DateCelleRenderer() {
    }
    
    

    
    @Override
    protected void setValue(Object value) {
	if (value instanceof Date){
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE);
	    String val = sdf.format((Date)value);
	    super.setValue(val);
	}
	super.setValue(value);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	Component c =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	if (c instanceof DateTextField){ return c;}
	if (value instanceof Date){
	    SimpleDateFormat s = new SimpleDateFormat(DATE);
	    DateTextField d = new DateTextField(s.format((Date)value));
	    return d;
	}
	return c;
	
    }

    
    
}
