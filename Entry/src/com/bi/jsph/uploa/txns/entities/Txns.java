package com.bi.jsph.uploa.txns.entities;

import java.io.Serializable;
import java.util.LinkedList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Txns")
public class Txns implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LinkedList<Txn> txns = new LinkedList<Txn>();
	public Txns() {
		// TODO Auto-generated constructor stub
	}
	protected LinkedList<Txn> getTxns() {
		return txns;
	}
	protected void setTxns(LinkedList<Txn> txns) {
		this.txns = txns;
	}
	@Override
	public String toString() {
		return "Txns [txns=" + txns + "]";
	}

}
