/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util.renderer;

import com.bi.right.customer.panel.sub.DateTextField;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellEditor;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class DateCelleEditor extends AbstractCellEditor implements TableCellEditor {

    private DateTextField thefield = null;

    public DateCelleEditor(String format) {
	thefield = new DateTextField();

    }

    @Override
    public Object getCellEditorValue() {
	Object val = null;
	if (val == null) {
	    if (thefield == null) {
		return null;
	    }
	    String val1 = thefield.getText();
	    if (val1 == null || "".equals(val1.trim())){
		return null;
	    }
	    SimpleDateFormat s = new SimpleDateFormat(DateCelleRenderer.DATE);
	    try {
		return s.parse(val1);
	    } catch (ParseException ex) {
		Exceptions.printStackTrace(ex);
		return null;
	    }
	} else {
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
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	if (value instanceof Date) {
	    SimpleDateFormat s = new SimpleDateFormat(DateCelleRenderer.DATE);
	    thefield = new DateTextField(s.format((Date) value));
	}
	return thefield;
    }
}
