/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jsph.model;

import java.util.*;
import javax.swing.BoundedRangeModel;
import javax.swing.event.ChangeListener;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class SliderModel implements BoundedRangeModel {

    private List<ChangeListener> listeners = new ArrayList<ChangeListener>();
    private boolean valueIsAdjusting;
    private int maximum=10;
    private int minimum =0;
    private int value=0;
    private int extent;

    public SliderModel() {
    }

    @Override
    public int getMinimum() {
        return minimum;
    }

    @Override
    public void setMinimum(int newMinimum) {
        minimum = newMinimum;
    }

    @Override
    public int getMaximum() {
        return maximum;
    }

    @Override
    public void setMaximum(int newMaximum) {
        maximum = newMaximum;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int newValue) {
        value = newValue;
    }

    @Override
    public void setValueIsAdjusting(boolean b) {
        valueIsAdjusting = b;
    }

    @Override
    public boolean getValueIsAdjusting() {
        return valueIsAdjusting;
    }

    @Override
    public int getExtent() {
        return extent;
    }

    @Override
    public void setExtent(int newExtent) {
        extent = newExtent;
    }

    @Override
    public void setRangeProperties(int pvalue, int pextent, int pmin, int pmax, boolean padjusting) {
        value = pvalue;
        extent = pextent;
        minimum = pmin;
        maximum = pmax;
        valueIsAdjusting = padjusting;
    }

    @Override
    public void addChangeListener(ChangeListener x) {
        listeners.add(x);
    }

    @Override
    public void removeChangeListener(ChangeListener x) {
        listeners.remove(x);
    }
}
