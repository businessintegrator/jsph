/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JEditorPane;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class HelpMouseListener implements MouseListener{

    private OpenerJDialog editorPane;
    public HelpMouseListener(OpenerJDialog editorPane) {
        this.editorPane = editorPane;
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source  = e.getSource();
        if (source instanceof JComponent){
           this.editorPane.fillEditorText(((JComponent)source).getToolTipText());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
