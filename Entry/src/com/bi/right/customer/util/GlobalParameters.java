/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util;

import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.util.naf.R1441_9;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class GlobalParameters implements CompletionService<String> {

    private final  Properties PROPS = new Properties();
    public final  List<Law> LAWS = new ArrayList<Law>();
    public StringBuilder NAFCODES;

    public void loadNafCodes(){
	InputStream in = R1441_9.class.getResourceAsStream("nafcode.txt");
	InputStreamReader r = new InputStreamReader(in, Charset.forName("UTF-8"));
	BufferedReader reader = new BufferedReader(r);
	NAFCODES = new StringBuilder();
	String line;
	try {
	    line = reader.readLine();
	    while (line != null) {
		String line__ = line.trim();
		int indx = line__.indexOf("\t");
		if (indx > 0) {
		    Law law = new Law();
		    law.setArticle(line__.substring(0, indx).trim());
		    law.setContent(line__.substring(indx).trim());
		    LAWS.add(law);
		}

		line = reader.readLine();
	    }
	} catch (IOException ex) {
	    Exceptions.printStackTrace(ex);
	}
    }

    public void loadWorkProperties(){
	try {
	    PROPS.load(GlobalParameters.class.getClassLoader().getResourceAsStream("work.properties"));
	} catch (IOException ex) {
	    System.err.println("work.properties missing");
	    Exceptions.printStackTrace(ex);
	}
	
    }
    public  Map<String, String> COMMUNES = new TreeMap<String, String>();

    public  void loadCommunes() {
	if (COMMUNES.isEmpty()) {
	    Properties p = new Properties();
	    try {
		p.load(GlobalParameters.class.getClassLoader().getResourceAsStream("communes.properties"));
		for (Map.Entry<Object, Object> entry : p.entrySet()) {
		    String object = (String) entry.getKey();
		    String object1 = (String) entry.getValue();
		    COMMUNES.put(object, object1);

		}
	    } catch (IOException ex) {
		Exceptions.printStackTrace(ex);
	    }
	}

    }

    public  String getWorkDir(GUIManager mngr) {
	if (mngr == null || mngr.getPath() == null) {
	    try {
		File f = File.createTempFile("jsph", Integer.toHexString(PROPS.hashCode()));
		return f.getPath();
	    } catch (IOException ex) {
		Exceptions.printStackTrace(ex);
		return System.getProperty("java.io.tmpdir");
	    }
	} else {
	    File f = new File(mngr.getPath());
	    if (f.isDirectory()) {
		return f.getPath();
	    } else {
		return f.getParent();
	    }
	}
    }
   
    private static GlobalParameters instance = null;

    public static GlobalParameters getInstance() {
	if (instance == null){instance = new GlobalParameters();}
	return instance;
    }
    
    private GlobalParameters() {
    }

    @Override
    public String autoComplete(String startsWith) {
	// Naive implementation, but good enough for the sample
	String hit = null;
	Set<String> datas = COMMUNES.keySet();
	for (String o : datas) {
	    if (o.startsWith(startsWith)) {
		// CompletionService contract states that we only
		// should return completion for unique hits.
		if (hit == null) {
		    hit = o;
		    return hit;
		} else {
		    hit = null;
		    break;
		}
	    }
	}
	return hit;
    }
}
