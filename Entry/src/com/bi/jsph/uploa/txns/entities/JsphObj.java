package com.bi.jsph.uploa.txns.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * 
 * @author rafaralahitsimba tiaray
 *
 */
@XmlRootElement(name="Jsph")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(value={Txn.class,ArrayList.class})
public class JsphObj implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@XmlElement(name="w")
	private String updateUrl = null;

	@XmlElement(name="y")
	private String backupUrl = null;
	
	@XmlElement(name = "c0")
	private String amountFisko;
	@XmlElement(name = "c1")
	private String amount1Affair;
	@XmlElement(name = "c2")
	private String amountnAffair;
	@XmlElement(name = "c3")
	private String now;
	
	@XmlElement(name="Txn",type=Txn.class)
	ArrayList<Txn> txns = new ArrayList<Txn>();
	
	private JsphObj() {
		super();
		
	}

	

	public String getUpdateUrl() {
		return updateUrl;
	}

	protected void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}

	public String getBackupUrl() {
		return backupUrl;
	}

	protected void setBackupUrl(String backupUrl) {
		this.backupUrl = backupUrl;
	}

	
	public ArrayList<Txn> getTxns() {
		return txns;
	}


	

	public String getAmountFisko() {
		return amountFisko;
	}



	public void setAmountFisko(String amountFisko) {
		this.amountFisko = amountFisko;
	}



	public String getAmount1Affair() {
		return amount1Affair;
	}



	public void setAmount1Affair(String amount1Affair) {
		this.amount1Affair = amount1Affair;
	}



	public String getAmountnAffair() {
		return amountnAffair;
	}



	public void setAmountnAffair(String amountnAffair) {
		this.amountnAffair = amountnAffair;
	}



	public String getNow() {
		return now;
	}



	public void setNow(String now) {
		this.now = now;
	}



	protected void setTxns(ArrayList<Txn> txns) {
		this.txns = txns;
	}



	@Override
	public String toString() {
		return "JsphObj [updateUrl=" + updateUrl + ", backupUrl=" + backupUrl
				+ ", txns=" + txns + "]";
	}

	
	
	
}
