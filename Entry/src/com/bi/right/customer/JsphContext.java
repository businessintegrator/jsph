/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import java.util.ArrayList;
import org.openide.windows.TopComponent;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class JsphContext {
    private static JsphContext instance;
    static ArrayList<TopComponent> LIST = new ArrayList<TopComponent>();

    public static ArrayList<TopComponent> getLIST() {
        return LIST;
    }

    

   static JsphContext getInstance() {
        if (instance == null){
            instance = new JsphContext();
        }
        return instance;
    }
      
   
   static void registerTopComponent(TopComponent top){
       LIST.add(top);
   }

   
}
