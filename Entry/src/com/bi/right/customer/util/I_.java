/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util;

/**
 *
 * @author rafaralahitsimba tiaray
 */
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;

public class I_ {

	private static I_ instance;
	
	public static I_ getInstance() {
		if (instance == null){
			instance = new I_();
		}
		return instance;
	}
	
	private StandardPBEByteEncryptor encryptor ;
	private String label;
	public I_() {
		super();
		encryptor = new StandardPBEByteEncryptor();
		encryptor.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);
		encryptor.setPassword("notaffected1");
		encryptor.initialize();
	}
     /**
      * 
      * @param myBytes
      * @return
      */
	public byte [] form(byte[] myBytes){
		return  encryptor.encrypt(myBytes);	
	}
	
	/**
	 * 
	 * @param encryptedBytes
	 * @return
	 */
	public byte [] mrof(byte[] encryptedBytes){
		return encryptor.decrypt(encryptedBytes);  // myBytes.equals(plainBytes)	
	}
	/**
	 * 
	 * @return
	 */
	public StandardPBEByteEncryptor _() {
		return encryptor;
	}
	/**
	 * 
	 * @param encryptor
	 */
	public void setEncryptor(StandardPBEByteEncryptor encryptor) {
		this.encryptor = encryptor;
	}
	/**
	 * 
	 * @return
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * 
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
}
