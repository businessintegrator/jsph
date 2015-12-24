/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import java.util.List;
import javax.swing.text.Document;
import org.jdesktop.beansbinding.BindingGroup;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public interface Undoable {
 public abstract List<Document> getUndoableDocuments();  
 public BindingGroup getBindingGroup() ;
 public boolean isNextPossible();
}
