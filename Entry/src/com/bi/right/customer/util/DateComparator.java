/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util;

import com.bi.right.customer.bo.Piece;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class DateComparator implements Comparator<Piece> {

    public DateComparator() {
    }

    @Override
    public int compare(Piece o1, Piece o2) {
        if (o1 == o2 ) return 0;
        if (o1 == null) return -1;
        if (o2 == null) return 1;
        if (o1.getStartDate() != null && o2.getStartDate() != null){
           return o1.getStartDate().compareTo(o2.getStartDate());
        }
        return -1;
    }

   
    
}
