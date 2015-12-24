/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jsph.gn;

import java.io.*;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class Generator {

    /**
     *
     * @param out
     * @param p
     * @param in
     * @throws Exception
     */
    public void generate(OutputStream out, Map p, InputStream in) throws Exception {

        HWPFDocument doc = new HWPFDocument(in);
        Range range = doc.getRange();
        for (Iterator iterator = p.entrySet().iterator(); iterator
                .hasNext();) {
            Map.Entry entry = (Map.Entry) iterator
                    .next();
            range.replaceText("${" + (String) entry.getKey() + "}", (String) entry.getValue());
        }

        doc.write(out);

        out.flush();
        out.close();
        in.close();
    }
}
