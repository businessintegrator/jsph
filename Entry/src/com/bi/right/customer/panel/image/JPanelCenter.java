/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel.image;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class JPanelCenter extends javax.swing.JPanel {

    private double scalingFactor = 0.50;

    public double getScalingFactor() {
	return scalingFactor;
    }

    public void setScalingFactor(double scalingFactor) {
	this.scalingFactor = scalingFactor;
    }

    /**
     * Creates new form JPanelCenter
     */
    public JPanelCenter(final JComponent comp) {
	initComponents();
        add(comp, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

   /* @Override
    public Dimension getPreferredSize() {
	final Dimension size = getLayout().preferredLayoutSize(this);
	return new Dimension((int) (size.width * this.scalingFactor),
		(int) (size.height * this.scalingFactor));
    }

    @Override
    public boolean isOptimizedDrawingEnabled() {
	return false;
    }

    @Override
    public void paint(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	java.awt.geom.AffineTransform backup = g2.getTransform();
	g2.scale(this.scalingFactor, this.scalingFactor);
	super.paint(g2);
	g2.setTransform(backup);
    }
*/
}