/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author rafaralahitsimba tiaray
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Piece implements Serializable {
    
    private static int INC = 1;
    private Integer numero = 0;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String fileName;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String label;
    private Date startDate;
    private ArrayList<SousPiece> files = new ArrayList<SousPiece>();
    private Boolean printed = false;

    public ArrayList<SousPiece> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<SousPiece> pfiles) {
        this.files = pfiles;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public static int getINC() {
        return INC;
    }

    public static void setINC(int INC) {
        Piece.INC = INC;
    }

    public Piece() {
        
    }
    

    public static String getName(int columnIndex) {
       switch(columnIndex){
           case 0:
               return "Numero";
           case 1:
               return "Sous numero";
           case 2:
               return "Label";
           case 3:
               return "Date";
           case 4:
               return "Imprimé";    
            default:
                return null;
       }
    }

    public static int getColumnCount() {
        return 5;
    }

    public static Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
           case 0:
              return Integer.class;
           case 1:
              
           case 2:
               return String.class;    
           case 3:
               return Date.class;
          case 4:
               return Boolean.class;    
            default:
                return null;
       }
    }


  
    public Object getValue(int columnIndex) {
     switch(columnIndex){
           case 0:
               return this.numero;
           case 1:
               return this.fileName;
           case 2:
               return this.label;
           case 3:
               return this.getStartDate();
           case 4:
               return printed;
            default:
                return null;
       }   
    }

    public void setValue(Object aValue,int columnIndex) {
        switch(columnIndex){
           case 0:
                this.numero = Integer.parseInt(aValue.toString());
               break;
           case 1:
                this.fileName = (String)aValue;
               break;
           case 2:
                this.label = (String)aValue;
               break;
           case 3:
	      
	       this.startDate = (Date)aValue;
               break;
            case 4:
                this.printed = (Boolean)aValue;
               break;
            default:
                
       }   
    }
}
