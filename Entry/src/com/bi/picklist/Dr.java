package com.bi.picklist;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Dr extends DefaultTableCellRenderer {

	

	public Dr() {
		super();
		
	}

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4766607581692980439L;
	

	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1,
			boolean selected, boolean focuesd, int row, int col) {
		if (arg1 == null){
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
			resut.setBackground(Color.YELLOW);

		} else {
			resut.setBackground(Color.WHITE);
		}
		if (focuesd) {
			resut.setBackground(Color.LIGHT_GRAY);
		} else {
			resut.setBackground(Color.WHITE);
		}
		
		return resut;
	}



	@Override
	protected void setValue(Object arg0) {
		// TODO Auto-generated method stub
		
		super.setValue(arg0);

	}

}
