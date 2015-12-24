/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel;

/**
 *
 * @author rafaralahitsimba tiaray
 */
import com.bi.right.customer.util.I_;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import javax.swing.text.Document;
import org.openide.util.Exceptions;

public class Parallel implements Runnable {
    
    private Document document;
    private File file;
    
    Parallel(Document pdocument, File pfile) {
	this.document = pdocument;
	this.file = pfile;
    }
    
    @Override
    public void run() {
	
	final File f = file;
	try {
	    FileOutputStream fstrm = new FileOutputStream(f);
	    ByteArrayOutputStream bout = new ByteArrayOutputStream();
	    ObjectOutput ostrm = new ObjectOutputStream(bout);
	    ostrm.writeObject(document);
	    ostrm.flush();
	    fstrm.write(I_.getInstance().form(bout.toByteArray()));
	    fstrm.close();
	    ostrm.close();
	} catch (Exception io) {
	    // should put in status panel
	    //System.err.println("IOException: " + io.getMessage());
	    Exceptions.printStackTrace(io);
	    throw new RuntimeException("Erreur de sauvegarde  ", io);
	    
	}
	
    }
}
