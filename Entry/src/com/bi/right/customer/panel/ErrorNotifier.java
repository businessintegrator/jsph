/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 *
 * @author rafaralahitsimba tiaray
 */
class ErrorNotifier {

    static void display(String message ,Throwable ex) {
	NotifyDescriptor dd = new NotifyDescriptor.Message(message);
	DialogDisplayer.getDefault().notify(dd);
    }
}
