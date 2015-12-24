/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.bopanel;

import com.bi.right.customer.util.Law;
import com.bi.right.customer.util.thpool.GUIExecutorImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
class FileSeeker {

    private final static String K_PATTERN = "PT";
    private final static String K_FILE = "F";
    private final static String K_LINE = "L";
    private final static String K_LISTRESULT = "R";
    private File file;

    public FileSeeker() {
    }

    
    void setFile(File directory) {
	this.file = directory;
    }

    public File getFile() {
	return file;
    }

    public List<Law> seek(GUIExecutorImpl guiimpl,String pattern,Object lock) throws Exception {
	Map<String, Object> context = new HashMap<String, Object>();
	String globalPattern = pattern;
	globalPattern = globalPattern.replace("[ÁÀÂÄÉÈÊËÍÌÎÏÓÒÔÖÚÙÛÜáàâäéèêëíìîïóòôöúùûüÇç]", ".");
	context.put(K_PATTERN, Pattern.compile(globalPattern));

	if (this.file == null) {
	    throw new RuntimeException("Pas de referentiel legislatif");
	}
	File[] files = this.file.listFiles();
	for (int i = 0; i < files.length; i++) {
	    File file1 = files[i];
	    if (file1.isDirectory()) {
		recurseSearch(context, file1,guiimpl);
	    } else {
		context.put(K_FILE, file1);
		seekIn(context,guiimpl);
	    }


	}
	/*synchronized(lock){
	  lock.notifyAll();
	}*/
	return (List<Law>) context.get(K_LISTRESULT);
    }

    private void seekIn(final Map<String, Object> context, GUIExecutorImpl guiimpl) throws Exception {
	guiimpl.execute(new Runnable() {
	    @Override
	    public void run() {
		BufferedReader in = null;
		try {
		    in =
			    new BufferedReader(
			    new InputStreamReader((new FileInputStream(
			    (File) context.get(K_FILE)))));
		    StringBuilder d = new StringBuilder();
		    String line = in.readLine();
		    Law y = null;
		    while (line != null) {
			d.append(line);
			if (y == null) {
			    y = treatLine(context, line);
			}
			line = in.readLine();
		    }

		    if (y != null) {
			y.setFullContent(d.toString());
		    }
		} catch (Exception e) {
		    Exceptions.printStackTrace(e);

		} finally {
		    if (in != null) {
			try {
			    in.close();
			} catch (IOException ex) {
			    Exceptions.printStackTrace(ex);
			}
		    }
		}

	    }
	});

    }

    private Law treatLine(Map<String, Object> context, String line) {

	Pattern pP = (Pattern) context.get(K_PATTERN);
	Matcher m = pP.matcher(line);
	if (m.find()) {
	    File fF = (File) context.get(K_FILE);
	    Law l = new Law();
	    l.setArticle(fF.getName());
	    l.setContent(fF.getPath());
	    List<Law> lst = (List<Law>) context.get(K_LISTRESULT);
	    if (lst == null) {
		lst = new LinkedList<Law>();
		context.put(K_LISTRESULT, lst);
	    }
	    lst.add(l);
	    return l;
	}
	return null;
    }

    private void recurseSearch(Map<String, Object> context, File directory, GUIExecutorImpl guiimpl) throws Exception {
	File[] filessub = directory.listFiles();
	for (int j = 0; j < filessub.length; j++) {
	    File file2 = filessub[j];
	    if (file2.isDirectory()) {
		recurseSearch(context, file2, guiimpl);
	    } else {
		context.put(K_FILE, file2);
		seekIn(context, guiimpl);
	    }
	}
    }

    /*List<Law> seek(GUIExecutorImpl guiimpl, String pattern) throws Exception {
	Map<String, Object> context = new HashMap<String, Object>();
	String globalPattern = pattern;
	globalPattern = globalPattern.replace("[ÁÀÂÄÉÈÊËÍÌÎÏÓÒÔÖÚÙÛÜáàâäéèêëíìîïóòôöúùûüÇç]", ".");
	context.put(K_PATTERN, Pattern.compile(globalPattern));
	if (this.file == null) {
	    throw new RuntimeException("Pas de referentiel legislatif");
	}
	File[] files = this.file.listFiles();
	for (int i = 0; i < files.length; i++) {
	    File file1 = files[i];
	    if (file1.isDirectory()) {
		recurseSearch(context, file1, guiimpl);
	    } else {
		context.put(K_FILE, file1);
		seekIn(context, guiimpl);
	    }
	}
	return (List<Law>) context.get(K_LISTRESULT);
    }*/
}
