/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import com.bi.right.customer.panel.AbstractPanel;
import java.lang.ref.WeakReference;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class AbstractPanelRef {
    
    WeakReference<AbstractPanel> ref = null;

    public AbstractPanelRef(AbstractPanel panel) {
	ref = new WeakReference<AbstractPanel>(panel);
    }

    public WeakReference<AbstractPanel> getRef() {
	return ref;
    }
    
    AbstractPanel getInternal (){
	return getRef().get();
    }
    
    
    
}
