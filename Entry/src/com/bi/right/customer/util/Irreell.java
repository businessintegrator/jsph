/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util;

/**
 *
 * @author rafaralahitsimba tiaray
 */
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import org.openide.util.Exceptions;

public class Irreell implements Runnable {

    private JTextPane textPane;
    private File file;

    public Irreell(File file) {
	this.file = file;
    }

    public Irreell(JTextPane jEditorPaneArg, File argPath) {
	this.textPane = jEditorPaneArg;
	file = argPath;
    }

    @Override
    public void run() {
	if (file.exists()) {
	    try {
		Document doc = readObject();
		textPane.setDocument(doc);
		
		
	    } catch (IOException io) {
		Exceptions.printStackTrace(io);
		// should put in status panel
		// System.err.println("IOException: " + io.getMessage());
		//textPane.setText("Fichier non trouvé.");
	    } catch (ClassNotFoundException cnf) {
		Exceptions.printStackTrace(cnf);
		// should put in status panel
		// System.err.println("Class not found: " + cnf.getMessage());
		//textPane.setText("Fichier non trouvé!");
	    }
	} else {
	    // should put in status panel
	    // System.err.println("No such file: " + file);
	    //textPane.setText("Fichier non trouvé...");
	}

    }

    public Document readObject() throws FileNotFoundException, IOException, ClassNotFoundException {
	FileInputStream fin = new FileInputStream(file);
	long len = file.length();
	byte[] bs = new byte[(int) len];
	int read = fin.read(bs);
	int currentIndex = 0;
	while (read > 0) {
	    if (read == len) {
		break;
	    }
	    currentIndex += read;
	    read = fin.read(bs, currentIndex, (int) len - currentIndex);
	}
	byte[] res = I_.getInstance().mrof(bs);
	ByteArrayInputStream b = new ByteArrayInputStream(res);
	ObjectInputStream istrm = new ObjectInputStream(b);
	Document doc = (Document) istrm.readObject();
	istrm.close();
	b.close();
	return doc;
    }
}
