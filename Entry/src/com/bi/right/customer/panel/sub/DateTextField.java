/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel.sub;

import com.bi.calendar.dlg.DateChooser;

import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;
import javax.swing.event.MouseInputListener;
import org.openide.windows.WindowManager;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class DateTextField extends JFormattedTextField implements MouseInputListener {
    private boolean hour = true;

    public DateTextField() {
        super();
        addMouseListener(this);
    }
    public DateTextField(String value) {
        super(value);
        addMouseListener(this);
    }

    public DateTextField(boolean useHour) {
	this();
	this.hour = useHour;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
       if (e.getClickCount() ==2){
            DateChooser dc = new DateChooser(WindowManager.getDefault().getMainWindow(), this,true);
	    dc.setLocationRelativeTo(this);
	    dc.setLocation(e.getPoint());
	    dc.setVisible(true);  
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    protected void finalize() throws Throwable {
	try {
	    removeMouseListener(this);
	} catch (Throwable e) {
	    e.printStackTrace();;
	}
	
	super.finalize();
    }

    
}
