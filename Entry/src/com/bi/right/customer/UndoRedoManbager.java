/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import org.openide.awt.UndoRedo;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class UndoRedoManbager extends UndoRedo.Manager{

    static UndoRedoManbager instance = new UndoRedoManbager();
    static UndoRedoManbager getInstance(){
      if (instance == null){
          instance = new UndoRedoManbager();
      }
      return instance;
    }
    
    private UndoRedoManbager() {
        super();
    }
    
    
}
