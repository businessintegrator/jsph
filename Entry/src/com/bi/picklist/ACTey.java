package com.bi.picklist;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class ACTey implements KeyListener {

	private StringListPopupModel model;
	

	public ACTey(StringListPopupModel model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("ACTey.keyPressed()");
	}

	@Override
	public void keyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		
		final JTextField t =(JTextField)evt.getSource();
		//System.out.println("ACTey.keyReleased()..."+t.getText());
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				model.filter(t.getText());		// TODO Auto-generated method stub
				
			}
		});
		
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		// TODO Auto-generated method stub
		//System.out.println("ACTey.keyTyped()");
		//evt.consume();

	}

}
