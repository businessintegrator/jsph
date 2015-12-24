/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util;

import com.bi.right.customer.LoaderStorer;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.bo.GenericRoot;
import java.io.File;
import java.io.IOException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingListener;
import org.jdesktop.beansbinding.PropertyStateEvent;
import org.netbeans.spi.actions.AbstractSavable;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.lookup.InstanceContent;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class TopSavable<J> extends AbstractSavable implements Node.Cookie, BindingListener, DocumentListener {

    private  J t2save;
    private InstanceContent content;
    private  String baseDirectory = null;
    private  String componentName;

    public void setContent(InstanceContent content) {
        this.content = content;
    }

    public TopSavable(J obj, InstanceContent instanceContent, String baseDirectory, String componentName)  {
        super();
        this.t2save = obj;
        this.content = instanceContent;
        this.baseDirectory = baseDirectory;
        this.componentName = componentName;
	try {
	    baseDirectory = File.createTempFile("jsph", "work").getParent();
	} catch (IOException ex) {
	    Exceptions.printStackTrace(ex);
	}
        register();
    }

    
    private void fire(boolean modified) {

        if (modified) {
            //If the text is modified,
            //we add SaveCookie impl to Lookup:

            content.add(this);
        } else {
            //Otherwise, we remove the SaveCookie impl from the lookup:
            content.remove(this);
        }

    }

    @Override
    protected String findDisplayName() {
        return componentName; // get display name somehow
    }

    @Override
    protected void handleSave() throws IOException {
	if (t2save instanceof GUIManager){
	    LoaderStorer l = new LoaderStorer();
	    GUIManager projct = (GUIManager)t2save;
	    l.store(projct, projct.getPath());
	} else {
	 genericSave();
	}
        fire(false);
        //register();



    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
	if (t2save == null) {return (((TopSavable) other).t2save == null);}
        if (other instanceof TopSavable) {
            return t2save.equals(((TopSavable) other).t2save);
        }
        return false;
    }

  

    @Override
    public void bindingBecameBound(Binding bndng) {
        System.out.println("bindingBecameBound:" + bndng.getSourceValueForTarget() + " " + bndng.getTargetValueForSource() + " " + bndng.getSourceObject() + bndng.getTargetObject() + " @" + Integer.toHexString(bndng.hashCode()));
    }

    @Override
    public void bindingBecameUnbound(Binding bndng) {
        if (bndng != null){
           System.out.println("bindingBecameUnbound:" + bndng.getSourceValueForTarget() + " " + bndng.getTargetValueForSource() + " " + bndng.getSourceObject() + bndng.getTargetObject() + " @" + Integer.toHexString(bndng.hashCode()));
        }
    }

    @Override
    public void syncFailed(Binding bndng, Binding.SyncFailure sf) {
        System.out.println("syncFailed:" + bndng.getSourceValueForTarget() + " " + bndng.getTargetValueForSource() + " " + bndng.getSourceObject() + bndng.getTargetObject() + " @" + Integer.toHexString(bndng.hashCode()));
    }

    @Override
    public void synced(Binding bndng) {
        System.out.println("synced:" + bndng.getSourceValueForTarget() + " " + bndng.getTargetValueForSource() + " " + bndng.getSourceObject() + bndng.getTargetObject() + " @" + Integer.toHexString(bndng.hashCode()));
    }

    @Override
    public void sourceChanged(Binding bndng, PropertyStateEvent pse) {
        System.out.println("sourceChanged" + bndng.getSourceValueForTarget() + " " + bndng.getTargetValueForSource() + " " + bndng.getSourceObject() + bndng.getTargetObject() + " @" + Integer.toHexString(bndng.hashCode()));
    }

    @Override
    public void targetChanged(Binding bndng, PropertyStateEvent pse) {
        System.out.println("sourceChanged" + bndng.getSourceValueForTarget() + " " + bndng.getTargetValueForSource() + " " + bndng.getSourceObject() + bndng.getTargetObject() + " @" + Integer.toHexString(bndng.hashCode()));
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        fire(true);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        fire(true);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        fire(true);
    }

    public J getT2save() {
        return t2save;
    }

    public String getBaseDirectory() {
	
        return baseDirectory;
    }

    public InstanceContent getContent() {
        return content;
    }

    @Override
    public int hashCode() {
	return content.hashCode();
    }

    private void genericSave() throws IOException {
	try {
	    JAXBContext jaxbContext = JAXBContext.newInstance(GenericRoot.class
		    .getPackage().getName());
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    // output pretty printed

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
		    true);
	    GenericRoot<J> root = new GenericRoot<J>();

	    root.setInternal(t2save);

	    //jaxbMarshaller.marshal(root, System.out);

	    jaxbMarshaller.marshal(root,
		    new File(getBaseDirectory() + "/" + componentName + ".xml"));
	} catch (Exception e) {
	    throw new IOException(e);

	}
    }

    public void setT2save(J t2save) {
	this.t2save = t2save;
    }

    public void setBaseDirectory(String baseDirectory) {
	this.baseDirectory = baseDirectory;
    }
    
}
