/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.picklist;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class CityChooser extends JDialog{
    private JTextField target;

    public CityChooser(Frame mainWindow, JTextField jTextFieldVille) {
	super(mainWindow);
	setModal(true);
	this.target = jTextFieldVille;
	initCmp();
	
	
    }

    private void initCmp() {
	StringListPopupModel model = new StringListPopupModel();
		JDialog f = this;
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		JLabel mf = new JLabel("Filtrer:");
		JTextField tjcombomonth = new JTextField();
		tjcombomonth.setPreferredSize(new Dimension(200, 40));
		
                north.add(mf);
		north.add(tjcombomonth);
		tjcombomonth.addKeyListener(new ACTey(model));

		f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.add(north, BorderLayout.NORTH);

		JScrollPane p = new JScrollPane();
		Dimension ddd = new Dimension(400,300);

		p.setAutoscrolls(true);
		JTable jtable = new JTable();
		jtable.setSize(ddd);

		jtable.setRowHeight(40);

		jtable.setDefaultRenderer(String.class, new Dr());

		jtable.setModel(model);
		p.getViewport().add(jtable);
		// p.getViewport().setSize(new Dimension(6*70, 7*70));
		f.add(p, BorderLayout.CENTER);
		
		
		
		JPanel south = new JPanel();
		
		south.setLayout(new FlowLayout());
		JButton cancelButton = new JButton("Annuler");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				onCancel(arg0);

			}

	    

		});
		south.add(cancelButton);
		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActOk(target,jtable,this));
		south.add(okButton);
		f.add(south,BorderLayout.SOUTH);
		
		f.pack();
    }
    
    private void onCancel(ActionEvent arg0) {
		dispose();
	    }
}
