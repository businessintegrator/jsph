/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public interface NavigablePanel {
    
    NavigablePanel next();
    NavigablePanel previous();
    NavigablePanel first();
    NavigablePanel last();
}
