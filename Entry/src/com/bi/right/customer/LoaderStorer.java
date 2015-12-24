/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import com.bi.right.customer.bo.PiecesTableModel;
import com.bi.right.customer.bo.Conseil;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.bo.GenericRoot;
import com.bi.right.customer.bo.LawDisplay;
import com.bi.right.customer.bo.LicenciementRuleContainer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class LoaderStorer {
    private static final Map<String,JAXBContext> MAP = new HashMap<String, JAXBContext>();

    public void delete(GUIManager mgr) {
    }

    public GUIManager load(File file) throws Exception {
	JAXBContext jaxbContext = getGuiManagerCtx(GUIManager.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        GUIManager customer = (GUIManager) jaxbUnmarshaller.unmarshal(file);
        return customer;

    }
    
    

    public void store(GUIManager guimgr, File file) throws Exception {
	try /*throws Exception*/ {
	    JAXBContext jaxbContext = getGuiManagerCtx(GUIManager.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    // output pretty printed
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	    jaxbMarshaller.marshal(guimgr, file);
	} catch (JAXBException ex) {
	    Exceptions.printStackTrace(ex);
	    throw new Exception("Echec d'enregistrement "+file.getPath());
	}

	

    }

    public LicenciementRuleContainer loadLic(InputStream in) throws Exception {
        JAXBContext jaxbContext = getGuiManagerCtx(LicenciementRuleContainer.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        LicenciementRuleContainer res = (LicenciementRuleContainer) jaxbUnmarshaller.unmarshal(in);
        return res;
    }

    public void storeLic(File file, LicenciementRuleContainer rules) throws Exception {
       JAXBContext jaxbContext = getGuiManagerCtx(LicenciementRuleContainer.class);        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

       // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(rules, file);

    }

    public Conseil loadConseil(InputStream in) throws Exception {
        JAXBContext jaxbContext = getGuiManagerCtx(GenericRoot.class);
        
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        GenericRoot<Conseil> customer = (GenericRoot<Conseil>) jaxbUnmarshaller.unmarshal(in);
        return customer.getInternal();

    }

    public void storeModel(PiecesTableModel model, File file) throws Exception {
	JAXBContext jaxbContext = getGuiManagerCtx(PiecesTableModel.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(model, file);


    }

    public PiecesTableModel loadModel(InputStream in) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(PiecesTableModel.class
                .getPackage().getName());
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        PiecesTableModel model = (PiecesTableModel) jaxbUnmarshaller.unmarshal(in);
        return model;

    }

    public void storeConseil(Conseil conseil, File file) throws Exception {
        JAXBContext jaxbContext = getGuiManagerCtx(GenericRoot.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        GenericRoot<Conseil> root = new GenericRoot<Conseil>();
        root.setInternal(conseil);
        jaxbMarshaller.marshal(conseil, file);


    }

    public void store(GUIManager guimanager, String path) throws IOException {
	try {
	    File fPath = null;
	    if (path != null){
	      fPath = new File (path); 
	    } else {
		fPath = new File (guimanager.getPath());
	    }
	    
	    if (fPath.exists()){
	       store(guimanager,fPath);
	    } else {
		throw new IOException(fPath.getPath());
	    }
	    
	} catch (Exception ex) {
	    Exceptions.printStackTrace(ex);
	    
	}
    }
    
    
      public LawDisplay loadLaw(InputStream in) throws Exception {
	  JAXBContext jaxbContext = getGuiManagerCtx(LawDisplay.class);
        
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        LawDisplay res = (LawDisplay) jaxbUnmarshaller.unmarshal(in);
        return res;
    }

    public void storeLaw(File file, LawDisplay rules) throws Exception {
        JAXBContext jaxbContext = getGuiManagerCtx(LawDisplay.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(rules, file);

    }

    private JAXBContext getGuiManagerCtx(Class clazz) throws JAXBException {
	JAXBContext jaxbContext = (JAXBContext)MAP.get(clazz.getPackage().getName());
	if (jaxbContext == null) {
	    jaxbContext = JAXBContext.newInstance(clazz.getPackage().getName());
	    MAP.put(clazz.getPackage().getName(), jaxbContext);
	}
	return jaxbContext;
    }
}
