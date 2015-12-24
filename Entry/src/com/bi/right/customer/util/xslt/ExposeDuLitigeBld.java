/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util.xslt;

import com.bi.right.customer.bo.Contrat;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.bo.Personne;
import com.bi.right.customer.bo.SalarieBO;
import com.bi.right.customer.bo.Societe;
import com.bi.right.customer.bo.Typerupture;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class ExposeDuLitigeBld {

    private GUIManager parentRoot;
    private boolean salarieDemandeur , dossierDatak;

    public GUIManager getParentRoot() {
	return parentRoot;
    }

    public void setParentRoot(GUIManager parentRoot) {
	this.parentRoot = parentRoot;
    }

    public ExposeDuLitigeBld(GUIManager parentRoot) {
	this.parentRoot = parentRoot;
	salarieDemandeur = parentRoot.isPourSalarie(); 
	dossierDatak = parentRoot.isAttak();
	
    }

    public void buildSalarie(StringBuilder str) {
	Societe societe = getParentRoot().getDemandeur().getSocId();
	str.append(" La société" + (societe.getNm() == null ? "" : societe.getNm()));


	Personne personne = getParentRoot().getDefendeur().getPersonne();

	String civilite = personne.getCivilite();


	str.append(" a  embauché " + civilite + " " + personne.getPnm() + " " + personne.getNm() + " "
		+ "le ");

	final Contrat contrat = getParentRoot().getContrat();

	Date start = contrat.getStartdt();
	if (start != null) {
	    str.append(new SimpleDateFormat("dd MMMMM yyyy", Locale.FRANCE).format(start));
	    str.append(" en tant que " + contrat.getProfession());
	}
	if (contrat.isEcrit()) {
	    str.append("Le contrat est écrit");
	} else {
	    str.append("Le contrat n'est pas écrit");
	}
	Date end = contrat.getEnddt();
	if (end != null) {
	    str.append(" Le contrat a été rompu le ");
	    str.append(new SimpleDateFormat("dd MMMMM yyyy", Locale.FRANCE).format(end));
	    str.append(". Le type de la rupture est  " + getParentRoot().getRupture().getDescription());
	    String motif = getParentRoot().getRupture().getMotif();
	    if (!"".equals(motif)) {
		str.append(" avec comme motif  " + motif + ".");
	    }
	}
    }

    public void pourSociete(StringBuilder str) {
	SalarieBO salarie = getParentRoot().getDemandeur().getPersonId();
	Personne personne = salarie.getIndividu();
	String civilite = personne.getCivilite();
	str.append(civilite + " " + personne.getPnm() + " " + personne.getNm() + " ");
	boolean hom = civilite.trim().startsWith("Monsieur");
	str.append(civilite);

	str.append(" à été embauché" + (hom ? "" : "e") + " le ");

	final Contrat contrat = getParentRoot().getContrat();

	Date start = contrat.getStartdt();
	if (start != null) {
	    str.append(new SimpleDateFormat("dd MMMMM yyyy", Locale.FRANCE).format(start));
	    str.append(" en tant que " + contrat.getProfession());
	}
	Societe societe = getParentRoot().getDefendeur().getSociete();
	str.append(" par " + (societe.getNm() == null ? "" : societe.getNm()));

	str.append((hom ? ". Il " : ". Elle ") + " n'est pas d'accord sur ...");

	Date end = contrat.getEnddt();
	if (end != null) {
	    str.append(" Le contrat a été rompu le ");
	    str.append(new SimpleDateFormat("dd MMMMM yyyy", Locale.FRANCE).format(end));
	    final Typerupture rupture = getParentRoot().getRupture();
	    str.append("Le type de la rupture est : " + rupture.getDescription());
	    String motif = rupture.getMotif();
	    String desc = rupture.getDescription();
	    if (!"".equals(motif)) {
		str.append(" avec comme motif " + motif + ".");
	    }
	}
    }

    public void build(StringBuilder str) {
	if (salarieDemandeur && dossierDatak){
	          buildDemandeurSalarie(str);
	    }else if (!salarieDemandeur && dossierDatak){
	         buildDemandeurSociete(str);
	    }else if (salarieDemandeur && !dossierDatak){
		 buildDefendeurSociete(str);
	    }else if (!salarieDemandeur && !dossierDatak){
		buildDefendeurSalarie(str);
	    } 
    }

    private void buildDemandeurSalarie(StringBuilder str) {
	buildSalarie(str);
    }

    private void buildDemandeurSociete(StringBuilder str) {
	buildSalarie(str);
    }

    private void buildDefendeurSalarie(StringBuilder str) {
	buildSalarie(str);
    }

    private void buildDefendeurSociete(StringBuilder str) {
	buildSalarie(str);
    }
}
