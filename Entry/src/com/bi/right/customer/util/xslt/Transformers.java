/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util.xslt;

import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class Transformers {

    public Transformers() {
    }

    public void transform(String xml, String xsl, String result) throws TransformerConfigurationException, TransformerException {
	TransformerFactory tFactory = TransformerFactory.newInstance();
	Transformer transformer = tFactory.newTransformer(new StreamSource(xsl));
	transformer.transform(new StreamSource(xml), new StreamResult(result));
    }

    void transform(String xml, InputStream xsl, OutputStream out) {
	try {
	    TransformerFactory tFactory = TransformerFactory.newInstance();
	    
	    Transformer transformer = tFactory.newTransformer(new StreamSource(xsl));
	    //transformer.getOutputProperties().list(System.out);
	    transformer.transform(new StreamSource(xml), new StreamResult(out));
	} catch (TransformerException ex) {
	    Exceptions.printStackTrace(ex);
	}
    }
}
