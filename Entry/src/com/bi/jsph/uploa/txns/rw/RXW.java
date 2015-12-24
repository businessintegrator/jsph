package com.bi.jsph.uploa.txns.rw;

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bi.jsph.uploa.txns.entities.JsphObj;

public class RXW {

    private JAXBContext cctx = null;

    public RXW() {
	try {
	    cctx = JAXBContext.newInstance(JsphObj.class.getPackage().getName());
	} catch (JAXBException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public JsphObj load(InputStream in) throws Exception {

	Unmarshaller m = cctx.createUnmarshaller();
	//m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	JsphObj obj = (JsphObj) m.unmarshal(in);
	return obj;


    }

    public void store(OutputStream out, JsphObj obj) throws Exception {
	Marshaller m = cctx.createMarshaller();
	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	m.marshal(obj, out);

    }
}
