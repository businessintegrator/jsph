/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class CDATAAdapter extends XmlAdapter<String, String>{

    @Override
    public String unmarshal(String v) throws Exception {
	return v;
    }

    @Override
    public String marshal(String v) throws Exception {
		//return "<![CDATA[" + v + "]]>";
	return v.trim();
	
    }
    
}
