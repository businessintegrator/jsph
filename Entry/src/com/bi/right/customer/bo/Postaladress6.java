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
 * //
 *
 * @author rafaralahitsimba tiaray
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"id","adrtp","dept","strtnm",
"bldgnb","pstcd","twnnm","ctry",
"adrline1","adrline2","adrline3"})
public class Postaladress6 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String adrtp;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String dept;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String strtnm;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String bldgnb;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String pstcd;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String twnnm;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String ctry;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String adrline1;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String adrline2;
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    private String adrline3;
   

    public Postaladress6() {
        this.dept = "";

        this.strtnm = "";

        this.bldgnb = "";

        this.pstcd = "";

        this.twnnm = "";

        this.ctry = "";

        this.adrline1 = "";

        this.adrline2 = "";

        this.adrline3 = "";
    }

    public Postaladress6(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdrtp() {
        return adrtp;
    }

    public void setAdrtp(String adrtp) {
        this.adrtp = adrtp;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getStrtnm() {
        return strtnm;
    }

    public void setStrtnm(String strtnm) {
        this.strtnm = strtnm;
    }

    public String getBldgnb() {
        return bldgnb;
    }

    public void setBldgnb(String bldgnb) {
        this.bldgnb = bldgnb;
    }

    public String getPstcd() {
        return pstcd;
    }

    public void setPstcd(String pstcd) {
        this.pstcd = pstcd;
    }

    public String getTwnnm() {
        return twnnm;
    }

    public void setTwnnm(String twnnm) {
        this.twnnm = twnnm;
    }

    public String getCtry() {
        return ctry;
    }

    public void setCtry(String ctry) {
        this.ctry = ctry;
    }

    public String getAdrline1() {
        return adrline1;
    }

    public void setAdrline1(String adrline1) {
        this.adrline1 = adrline1;
    }

    public String getAdrline2() {
        return adrline2;
    }

    public void setAdrline2(String adrline2) {
        this.adrline2 = adrline2;
    }

    public String getAdrline3() {
        return adrline3;
    }

    public void setAdrline3(String adrline3) {
        this.adrline3 = adrline3;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Postaladress6 other = (Postaladress6) obj;
        if ((this.adrtp == null) ? (other.adrtp != null) : !this.adrtp.equals(other.adrtp)) {
            return false;
        }
        if ((this.dept == null) ? (other.dept != null) : !this.dept.equals(other.dept)) {
            return false;
        }
        if ((this.strtnm == null) ? (other.strtnm != null) : !this.strtnm.equals(other.strtnm)) {
            return false;
        }
        if ((this.bldgnb == null) ? (other.bldgnb != null) : !this.bldgnb.equals(other.bldgnb)) {
            return false;
        }
        if ((this.pstcd == null) ? (other.pstcd != null) : !this.pstcd.equals(other.pstcd)) {
            return false;
        }
        if ((this.twnnm == null) ? (other.twnnm != null) : !this.twnnm.equals(other.twnnm)) {
            return false;
        }
        if ((this.ctry == null) ? (other.ctry != null) : !this.ctry.equals(other.ctry)) {
            return false;
        }
        if ((this.adrline1 == null) ? (other.adrline1 != null) : !this.adrline1.equals(other.adrline1)) {
            return false;
        }
        if ((this.adrline2 == null) ? (other.adrline2 != null) : !this.adrline2.equals(other.adrline2)) {
            return false;
        }
        if ((this.adrline3 == null) ? (other.adrline3 != null) : !this.adrline3.equals(other.adrline3)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Postaladress6{" + "adrtp=" + adrtp + ", dept=" + dept + ", strtnm=" + strtnm + ", bldgnb=" + bldgnb + ", pstcd=" + pstcd + ", twnnm=" + twnnm + ", ctry=" + ctry + ", adrline1=" + adrline1 + ", adrline2=" + adrline2 + ", adrline3=" + adrline3 +"}";
    }

   
}
