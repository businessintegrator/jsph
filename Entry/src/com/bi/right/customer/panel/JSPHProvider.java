/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

import org.netbeans.spi.quicksearch.SearchProvider;
import org.netbeans.spi.quicksearch.SearchRequest;
import org.netbeans.spi.quicksearch.SearchResponse;

public class JSPHProvider implements SearchProvider {

    public void evaluate(SearchRequest request, SearchResponse response) {
        String text = request.getText();
        response.addResult(new Runnable() {

            @Override
            public void run() {
                
            }
        }, "Here");
        //sample code
        //for (SearchedItem item : getAllItemsToSearchIn()) {
        //    if (isConditionSatisfied(item, request)) {
        //        if (!response.addResult(item.getRunnable(), item.getDisplayName(),
        //	      item.getShortcut(), item.getDisplayHint())) {
        //	      break;
        //	  }
        //    }
        //}
    }
}
