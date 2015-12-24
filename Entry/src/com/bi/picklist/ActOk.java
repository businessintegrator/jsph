/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.picklist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author rafaralahitsimba tiaray
 */
class ActOk implements ActionListener {

    private final JTextField target;
    private final JTable jtable;
    private final CityChooser dlg;

    public ActOk(JTextField target, JTable jtable, CityChooser aThis) {
	this.target = target;
	this.jtable = jtable;
	this.dlg = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	int row = jtable.getSelectedRow();
	StringListPopupModel model = (StringListPopupModel) jtable.getModel();
	String selected = (String) model.getValueAt(row, 0);
	if (selected!=null){
	   target.setText(selected);
	}
	dlg.dispose();


    }
}
