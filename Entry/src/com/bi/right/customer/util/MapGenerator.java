/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util;


import com.bi.right.customer.bo.Defendeur;
import com.bi.right.customer.bo.Demande;
import com.bi.right.customer.bo.Demandeur;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.bo.Personne;
import com.bi.right.customer.bo.Postaladress6;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class MapGenerator {
    private GUIManager manager = null;
    
    private static String NL ="\r\n";
    

    public MapGenerator(GUIManager root) {
        this.manager = root;
        
    }

    
    public void generate(File inFile,File outFile) throws Exception {
        OutputStream out = new FileOutputStream(outFile);
        InputStream in = new FileInputStream(inFile);
        generate(out, buildMeta(), in);
    }
    
    Map<String,String> buildMeta(){
        Map <String,String> map = new HashMap<String, String>();
        map.put("Affaire", manager.getAffaire()+manager.getUniqueId());
	final Postaladress6 addrid = manager.getConseil().getAddrid();
	
        fillAdress("Conseil",map, addrid);
        Demandeur d = manager.getDemandeur();
	Personne pPersonne = d.getPersonId().getIndividu();
        map.put("Demandeur","Nom:\t"+ pPersonne.getNm()+NL+
                "Prénom:\t"+ pPersonne.getPnm()+NL+
		
                ((pPersonne.getBirthdt()!= null)?"Né(e):\t"+new SimpleDateFormat("dd MMMMM yyyy", Locale.FRANCE).format(pPersonne.getBirthdt()):"") +NL+                        
                "Nationalité:\t" +d.getNationalite()+NL+       
                "Profession:\t"+d.getPro()+NL+
                (d.getPersonId().isCadre()?"Cadre ":" Non Cadre")+ NL+
                "Rupture du contrat ?\t"+manager.getRupture().getDescription()+NL+
                "Convention collective?\t "+manager.getContrat().getConvcoll()+NL+
                 "Salarié protégé ?\t"+ d.getTp());
	fillAdress("Demandeur.addr",map, pPersonne.getAddr());
        Defendeur vs = manager.getDefendeur();
        map.put("Defendeur","Nom:"+vs.getSociete().getNm()+NL+
                "SIRET: "+vs.getSociete().getSiret()+NL+
                "Code APE NAF : "+vs.getSociete().getNafape()+NL+
                "Effectif: "+vs.getSociete().getEffectif()+NL
                )  ;  
	fillAdress("Defendeur.addr",map, vs.getSociete().getAddr());
        StringBuilder s = new StringBuilder();
        for (Iterator it = manager.getDemandes().iterator(); it.hasNext();) {
            Demande demande = (Demande)it.next();
            if (demande.isSelected()){
              s.append(demande.getArtlaw()+"\t"+demande.getLbl()+"\t"+ demande.getAmount()+NL);
            }
        }
        map.put("Demandes", s.toString());
        return map;
    }
    
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

    private void fillAdress(String key,Map<String, String> map, final Postaladress6 addrid) {
	map.put(key, addrid.getAdrline1()+
		NL+addrid.getAdrline2()+
		NL+addrid.getAdrline3()+
			NL+addrid.getPstcd()+" "+
			addrid.getTwnnm()
			);
    }
}
