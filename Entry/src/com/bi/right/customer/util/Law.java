/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class Law {

    private String article;
    private String content;
    private String fullContent;

    public Law() {
    }

    public String getArticle() {
	return article;
    }

    public void setArticle(String article) {
	this.article = article;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    @Override
    public String toString() {
	int k = Math.min(255, content.length());
	return article + " - " + content.substring(0, k) + "...";
    }

    public void setFullContent(String ctx) {
	this.fullContent = ctx;
    }

    public String getFullContent() {
	return fullContent;
    }

    public void loadFullContent() {
	try {
	    //CET DE L XML.........
	    StringBuilder f = new StringBuilder();
	    BufferedReader in =
		    new BufferedReader(
		    new InputStreamReader((new FileInputStream(
		    content))));
	    String line = in.readLine();
	    while (line != null) {
		if (line.length() > 40) {
		    f.append(line.substring(0, 40)).append("\n").append(line.substring(40));

		} else {

		    f.append(line).append("\n");
		}

		line = in.readLine();
	    }
	    fullContent = f.toString();
	} catch (Exception e) {
	    Exceptions.printStackTrace(e);
	}
    }
}
