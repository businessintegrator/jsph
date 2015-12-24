/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util.renderer;

import com.bi.right.customer.panel.sub.DateTextField;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class DateDemandeEditor extends DefaultCellEditor implements TableCellEditor {
private final static Logger logger = Logger.getLogger(DateDemandeEditor.class.getName());
    //private DateTextField thefield = null;

    public DateDemandeEditor() {
	super(new DateTextField(false));
	logger.info("DateDemandeEditor created "+Integer.toHexString(hashCode()));
    }

    /*@Override
    public Object getCellEditorValue() {
	Object val = null;
	if (val == null) {
	    if (thefield == null) {
		return null;
	    }
	    String val1 = thefield.getText().trim();
	    if (val1 == null || "".equals(val1)){
		return null;
	    }
	    SimpleDateFormat s = new SimpleDateFormat(DateCelleRenderer.DATE);
	    try {
	        logger.info("value in text "+val1);
		return s.parse(val1);
	    } catch (ParseException ex) {
		Exceptions.printStackTrace(ex);
		return null;
	    }
	} else {
	    logger.info("ELSE "+val);
	    if (val instanceof Date) {
		return val;

	    } else if (val instanceof String) {
		SimpleDateFormat s = new SimpleDateFormat(DateCelleRenderer.DATE);
		try {
		    String val1 = (String) val;
		    return s.parse(val1);
		} catch (ParseException ex) {
		    Exceptions.printStackTrace(ex);
		    return null;
		}
	    }
	}
	return val;
    }*/

   /* @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

	logger.info("value is  "+ value+" selected "+isSelected+" ("+row+","+column+")");
	if (value instanceof Date) {
	    logger.info("value is date "+value+" "+Integer.toHexString(thefield.hashCode()));
	    SimpleDateFormat s = new SimpleDateFormat(DateCelleRenderer.DATE);
	    thefield = new DateTextField(s.format((Date) value));
	} else if (value instanceof String){
	    logger.info("value is string "+value+" "+Integer.toHexString(thefield.hashCode()));
	    thefield.setText((String)value);
	}
	
	return thefield;
    }*/
    
    
}
