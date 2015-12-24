/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util.renderer;

import com.bi.right.customer.panel.sub.DateTextField;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class DateDemandeRenderer extends DefaultTableCellRenderer {

    private final static boolean DEBUG = false;
    private final static Logger logger = Logger.getLogger(DateDemandeRenderer.class.getName());
    public final static String DATE = "dd/MM/yyyy";

    public DateDemandeRenderer() {
	if (DEBUG) logger.info("create Renderer "+Integer.toHexString(hashCode()));
	
    }
    
    

    
    @Override
    protected void setValue(Object value) {
	if (DEBUG) logger.info("setValue "+value);
	if (value instanceof Date){
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE);
	    String val = sdf.format((Date)value);
	    if (DEBUG) logger.info("setValue modified "+val);
	    super.setValue(val);
	    return;
	}
	super.setValue(value);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	Component c =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	
	if (c instanceof DateTextField){
	    if (DEBUG) logger.info("getTableCellRendererComponent DateTextField"+ Integer.toHexString(c.hashCode()) );
	    return c;}
	if (value instanceof Date){
	    SimpleDateFormat s = new SimpleDateFormat(DATE);
	    DateTextField d = new DateTextField(s.format((Date)value));
	    if (DEBUG) logger.info("getTableCellRendererComponent"+ Integer.toHexString(d.hashCode()) );
	    if (DEBUG) logger.info("getTableCellRendererComponent"+d);
	    return d;
	}
	return c;
	
    }

}
    

