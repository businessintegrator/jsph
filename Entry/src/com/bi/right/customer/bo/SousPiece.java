/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bo;

import com.bi.right.customer.util.xml.CDATAAdapter;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author rafaralahitsimba tiaray
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SousPiece")
public class SousPiece implements Serializable{
    private int index;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String path;
    private long fileLength;

    public long getFileLength() {
        return fileLength;
    }

    public void setFileLength(long fileLength) {
        this.fileLength = fileLength;
    }

    public SousPiece() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    String toFileName(){
     /*int idx = path.lastIndexOf(".");
     int ifxs = path.lastIndexOf("\\");
     if (idx > ifxs && ifxs >0){
     return path.substring( ifxs,idx);
     } */
     return path;
    }
    @Override
    public String toString() {
        return toFileName();
    }
    
}
