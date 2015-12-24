/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util.naf;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class R1441_9 {

    private static final String[] SECTIONS = new String[]{"Industrie",
	"Activités diverses", "Commerce", "Agriculture"};
    private static final String[] PROPS = new String[]{
	"industrie.properties", "activites_diverses.properties",
	"commerce.properties", "agriculture.properties"};
    private static final int INDUSTRY = 0;
    private static final int ACT_DIV = 1;
    private static final int COMMERCE = 2;
    private static final int AGRICULTURE = 3;
    private static final List<List<String>> SINGLES = new ArrayList<List<String>>();
    private static final List<List<String>> GROUPS = new ArrayList<List<String>>();

    public R1441_9() {
	if (SINGLES.isEmpty()) {
	    for (int i = 0; i < SECTIONS.length; i++) {
		SINGLES.add(new ArrayList<String>());
		GROUPS.add(new ArrayList<String>());
		try {
		    load(PROPS[i], i);
		} catch (Exception ex) {
		    Exceptions.printStackTrace(ex);
		}
	    }
	}

    }

    private void load(String resource, int section) throws Exception {
	List<String> SINGLE = SINGLES.get(section);
	List<String> GROUP = GROUPS.get(section);
	InputStream in = R1441_9.class.getResourceAsStream(resource);
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		in, Charset.forName("UTF-8")));
	String read = reader.readLine();
	while (read != null) {
	    String that = read.trim().toUpperCase();
	    //System.err.println(that);

	    if (that.length() == 4) {
		SINGLE.add(that);
	    } else if (that.length() > 0) {
		GROUP.add(that);
	    }
	    read = reader.readLine();
	}
	in.close();
	in = null;

    }

    public String calcSection(String NAF_APE, boolean cadre) {
	if (cadre) {
	    return "Encadrement";
	}
	final String candidate = NAF_APE.trim().toUpperCase();
	for (int i = 0; i < SINGLES.size(); i++) {
	    List<String> SINGLE = SINGLES.get(i);

	    if (SINGLE.contains(candidate)) {
		return SECTIONS[i];
	    }
	}

	for (int i = 0; i < GROUPS.size(); i++) {
	    List<String> GROUP = GROUPS.get(i);
	    for (Iterator iterator = GROUP.iterator(); iterator.hasNext();) {
		String type = (String) iterator.next();
		if (candidate.startsWith(type)) {
		    return SECTIONS[i];
		}

	    }
	}
	return null;
    }

    public void test() throws Exception {
	File f = new File("C:/jesaisilesprudhoms/Choix section/nafcode.txt");
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		new FileInputStream(f), Charset.forName("UTF-8")));
	String read = reader.readLine();
	while (read != null) {
	    String candidate = read.substring(0, 5);
	    String section = calcSection(candidate, false);
	    if (section != null) {
		System.out.println(read+";"+section);
	    } else {
		throw new Exception(read);
	    }
	    read = reader.readLine();
	}
	reader.close();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

	R1441_9 r = new R1441_9();
	try {
	    r.test();
	} catch (Exception ex) {
	    Exceptions.printStackTrace(ex);
	}

    }
    private static R1441_9 instance = null;

    public static R1441_9 getInstance() {
	if (instance == null) {
	    instance = new R1441_9();
	}
	return instance;
    }
}
