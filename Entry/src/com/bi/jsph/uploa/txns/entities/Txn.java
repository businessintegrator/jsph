package com.bi.jsph.uploa.txns.entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Txn")
@XmlAccessorType(XmlAccessType.FIELD)
// ,propOrder={"userId", "userIp",
// "userLastConnectedDate","userTxn","txnDescription","txnAmount"}
public class Txn implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2274186052297208441L;
	// <k><![CDATA[2]]></k>
	@XmlElement(name = "k")
	private String userId;
	// <l><![CDATA[109.30.201.140]]</l>
	@XmlElement(name = "l")
	private String userIp;
	// <m><![CDATA[08/03/2013]]</m>
	@XmlElement(name = "m")
	private String userLastConnectedDate;
	// <d><![CDATA[01/01/1970]]</d>
	@XmlElement(name = "d")
	private String userTxn;
	// <j><![CDATA[]]</j>
	@XmlElement(name = "j")
	private String txnDescription;
	// <x><![CDATA[0,00�]]</x>
	@XmlElement(name = "x")
	private String txnAmount;

	

	private Txn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUserLastConnectedDate() {
		return userLastConnectedDate;
	}

	public void setUserLastConnectedDate(String userLastConnectedDate) {
		this.userLastConnectedDate = userLastConnectedDate;
	}

	public String getUserTxn() {
		return userTxn;
	}

	public void setUserTxn(String userTxn) {
		this.userTxn = userTxn;
	}

	public String getTxnDescription() {
		return txnDescription;
	}

	public void setTxnDescription(String txnDescription) {
		this.txnDescription = txnDescription;
	}

	public String getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(String txnAmount) {
		this.txnAmount = txnAmount;
	}

	


	@Override
	public String toString() {
		return "Tnx [userId=" + userId + ", userIp=" + userIp
				+ ", userLastConnectedDate=" + userLastConnectedDate
				+ ", userTxn=" + userTxn + ", txnDescription=" + txnDescription
				+ ", txnAmount=" + txnAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((txnAmount == null) ? 0 : txnAmount.hashCode());
		result = prime * result
				+ ((txnDescription == null) ? 0 : txnDescription.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userIp == null) ? 0 : userIp.hashCode());
		result = prime
				* result
				+ ((userLastConnectedDate == null) ? 0 : userLastConnectedDate
						.hashCode());
		result = prime * result + ((userTxn == null) ? 0 : userTxn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Txn other = (Txn) obj;
		if (txnAmount == null) {
			if (other.txnAmount != null)
				return false;
		} else if (!txnAmount.equals(other.txnAmount))
			return false;
		if (txnDescription == null) {
			if (other.txnDescription != null)
				return false;
		} else if (!txnDescription.equals(other.txnDescription))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userIp == null) {
			if (other.userIp != null)
				return false;
		} else if (!userIp.equals(other.userIp))
			return false;
		if (userLastConnectedDate == null) {
			if (other.userLastConnectedDate != null)
				return false;
		} else if (!userLastConnectedDate.equals(other.userLastConnectedDate))
			return false;
		if (userTxn == null) {
			if (other.userTxn != null)
				return false;
		} else if (!userTxn.equals(other.userTxn))
			return false;
		return true;
	}

}
