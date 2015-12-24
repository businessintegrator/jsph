/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util.xslt;

import com.bi.right.customer.LoaderStorer;
import com.bi.right.customer.bo.Defendeur;
import com.bi.right.customer.bo.Defenseur;
import com.bi.right.customer.bo.Demande;
import com.bi.right.customer.bo.Demandeur;
import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.bo.Personne;
import com.bi.right.customer.bo.Postaladress6;
import com.bi.right.customer.bo.Societe;
import com.bi.right.customer.util.Irreell;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import org.openide.util.Exceptions;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class ParallelTransformers extends Transformers {

    private final static Logger logger = Logger.getLogger("Concusion generator");
    private static final int MAX_LINE_LENGTH = 80;
    private OutputStream out;
    private final static String NL = "\n";
    private final static String ADROITE = "\t\t\t\t";

    public ParallelTransformers() {
    }

    public void transformXML(String path, String result) {
	try {
	    boolean salarieEnDemande = true;
	    boolean dossierDatak = true;
	    out = new FileOutputStream(result, true);
	    LoaderStorer loader = new LoaderStorer();
	    GUIManager project = loader.load(new File(path));
	    c("Conclusions");
	    if (project.isAttak()) {
		c("En demande");
		dossierDatak = true;
	    } else {
		c("En defense");
	    }
	    c(project.getConseil().getAddrid().getAdrline1());
	    c("Dossier " + project.getInstance().getRefid());
	    c("Section " + project.getConseil().getSection());
	    c("Convocation devant le bureau de conciliation/jugement/mise en l'état");
	    c("Audience du .................................");
	    c("------------Demandeur---------------");
	    salarieEnDemande = displayDemandeur(project.getDemandeur());
	    c(ADROITE + "contre");
	    c("------------Défendeur---------------");
	    displayDefendeur(project.getDefendeur());
	    c("--------------Résumé des demandes-----------");
	    Map<String, String> files = write(project, project.getDemandes());

	    String rExpose = project.getExposeLitige();
	    if (rExpose == null) {
		throw new Exception("Exposé de litige ");
	    } else {
		decompressExposeLitige(rExpose, salarieEnDemande, dossierDatak);
	    }
	    c("--------------Discussions-----------");
	    int k = 0;
	    for (Map.Entry<String, String> entry : files.entrySet()) {
		String demande = entry.getKey();
		String f = entry.getValue();

		c((k + 1) + ")-------Discussion sur la demande :" + demande);
		try {
		    decompress(demande, f);
		} catch (Exception e) {
		    Exceptions.printStackTrace(e);

		}

		k++;

	    }

	    writeBordereau(project.getPiecesPath());
	    out.close();

	} catch (Exception ex) {
	    logger.log(Level.WARNING, "Conclusion");
	    Exceptions.printStackTrace(ex);
	}
    }

    private void c(String line) throws IOException {
	//project.
	int length = line.length();
	if (length > MAX_LINE_LENGTH) {
	    int q = length / 80;
	    int r = length % MAX_LINE_LENGTH;
	    for (int k = 0; k < q; k++) {
		out.write(line.substring(k * 80, (k + 1) * 80).getBytes());
		out.write(NL.getBytes());
	    }
	    if (r > 0) {
		out.write(line.substring(length - r, length).getBytes());
		out.write(NL.getBytes());
	    }
	}else{
	  out.write((line + NL).getBytes());
	}
    }

    private void cl(String... lines) throws IOException {
	//project.
	for (String line : lines) {
	    c(line + NL);
	}

    }

    private boolean displayDemandeur(Demandeur demandeur) {
	boolean demandeurSalarie = false;
	if (demandeur.isSalarie()) {
	    demandeurSalarie = true;
	    if (demandeur.isRepresente()) {
		try {
		    Defenseur defenseur = demandeur.getAssistant();
		    c("Représenté par :");
		    displayDefenseur(defenseur);
		} catch (IOException ex) {
		    logger.log(Level.WARNING, " Demandeur représenté :" + ex.getMessage());
		    Exceptions.printStackTrace(ex);
		}
	    } else {
		displayOne(demandeur.getPersonId().getIndividu());
	    }

	    if (demandeur.isAssiste()) {
		try {
		    Defenseur defenseur = demandeur.getAssistant();
		    c("Assité par :");
		    displayDefenseur(defenseur);
		} catch (IOException ex) {
		    logger.log(Level.WARNING, " Demandeur assisté :" + ex.getMessage());
		    Exceptions.printStackTrace(ex);
		}
	    }

	} else {
	    if (demandeur.isAssiste()) {
		try {
		    Defenseur defenseur = demandeur.getAssistant();
		    c("Assité par :");
		    displayDefenseur(defenseur);
		} catch (IOException ex) {
		    Exceptions.printStackTrace(ex);
		}
	    }
	    if (demandeur.isRepresente()) {
		Defenseur defenseur = demandeur.getAssistant();
		try {
		    c("Représenté par :");
		} catch (IOException ex) {
		    Exceptions.printStackTrace(ex);
		}
		displayDefenseur(defenseur);
	    } else {
		displaySoc(demandeur.getSocId(), demandeur.isAssiste(), demandeur.isRepresente());
	    }
	}
	return demandeurSalarie;
    }

    private void displayDefendeur(Defendeur defendeur) {
	if (defendeur.isSalarie()) {

	    if (defendeur.isRepresente()) {
		try {
		    c(ADROITE + "Représenté par :");
		    Defenseur defenseur = defendeur.getAssistant();
		    displayDefenseur(defenseur);
		} catch (IOException ex) {
		    logger.log(Level.WARNING, " Defendeur représenté :" + ex.getMessage());
		    Exceptions.printStackTrace(ex);
		}
	    } else {
		displayOne(defendeur.getPersonne());
	    }
	    if (defendeur.getAssiste()) {
		try {
		    c(ADROITE + "Assité par :");
		    Defenseur defenseur = defendeur.getAssistant();
		    displayDefenseur(defenseur);
		} catch (IOException ex) {
		    logger.log(Level.WARNING, " Defendeur assisté :" + ex.getMessage());

		    Exceptions.printStackTrace(ex);
		}
	    }
	} else {
	    if (defendeur.getAssiste()) {
		try {
		    c("Assité par :");
		    Defenseur defenseur = defendeur.getAssistant();
		    displayDefenseur(defenseur);
		} catch (IOException ex) {
		    logger.log(Level.WARNING, " Defendeur assistance :" + ex.getMessage());
		    Exceptions.printStackTrace(ex);

		}
	    }
	    if (defendeur.isRepresente()) {
		try {
		    c("Représenté par :");
		    Defenseur defenseur = defendeur.getAssistant();
		    displayDefenseur(defenseur);
		} catch (IOException ex) {
		    logger.log(Level.WARNING, " Defenseur :" + ex.getMessage());

		    Exceptions.printStackTrace(ex);
		}
	    } else {
		displaySoc(defendeur.getSociete(), defendeur.getAssiste(), defendeur.isRepresente());
	    }
	}

    }

    private void displayOne(Personne p) {
	try {
	    cl(p.getCivilite(), p.getNm(), p.getPnm());
	    displayOne(p.getAddr());
	} catch (IOException ex) {
	    Exceptions.printStackTrace(ex);
	}
    }

    private void displayOne(Postaladress6 addr) {
	try {
	    cl(addr.getAdrline1(), addr.getAdrline2(), addr.getAdrline3(), addr.getPstcd(), addr.getTwnnm());
	} catch (IOException ex) {
	    Exceptions.printStackTrace(ex);
	}

    }

    private void displaySoc(Societe s, boolean assist, boolean represente) {
	try {
	    cl(s.getNm() + " " + s.getNmcom());
	    displayOne(s.getAddr());
	} catch (IOException ex) {
	    logger.log(Level.WARNING, " Société :" + ex.getMessage());

	    Exceptions.printStackTrace(ex);
	}
    }

    private void displayDefenseur(Defenseur defenseur) {
	try {
	    cl(defenseur.getRepresentant().getCivilite(), defenseur.getRepresentant().getNm(), defenseur.getRepresentant().getPnm());
	} catch (IOException ex) {
	    logger.log(Level.WARNING, " Defenseur :" + ex.getMessage());

	    Exceptions.printStackTrace(ex);
	}
    }

    private Map<String, String> write(GUIManager project, ArrayList<Demande> demandes) {
	Map<String, String> files = new HashMap<String, String>();

	for (Demande demande : demandes) {
	    if (!demande.isSelected()) {
		continue;
	    }
	    try {
		if (isAmount(demande.getAmount())) {
		    c(demande.getLbl() + "\t\t" + demande.getAmount() + " " + demande.getCurr());
		} else {
		    c(demande.getLbl());
		}
		if (isAmount(demande.getAstreinte())) {
		    c("Astreinte de " + demande.getAstreinte() + " " + demande.getCurr() + " par jourde retard");
		}
		files.put(demande.getLbl(), demande.getArgumentationPath());

	    } catch (IOException ex) {
		logger.log(Level.WARNING, " Demande :" + ex.getMessage());

		Exceptions.printStackTrace(ex);
	    }


	}
	return files;

    }

    private boolean isAmount(Double amount) {
	return (amount != null && 0 != amount.doubleValue());
    }

    private void writeBordereau(String piecesPath) throws IOException {
	String xml = piecesPath;
	InputStream xsl = ParallelTransformers.class.getResourceAsStream("bord.xsl");
	xsl.close();
	new Transformers().transform(xml, xsl, out);


    }

    private void decompress(String demande, String f) throws FileNotFoundException, IOException {

	if (f == null) {
	    throw new FileNotFoundException(" ");
	}
	try {

	    Irreell ireel = new Irreell(new File(f));
	    Document document = ireel.readObject();
	    int length = document.getLength();
	    c("----------------------------------");
	    int q = length / 80;
	    int r = length % MAX_LINE_LENGTH;
	    for (int k = 0; k < q; k++) {
		out.write(document.getText(k * 80, 80).getBytes());
		out.write(NL.getBytes());
	    }
	    if (r > 0) {
		out.write(document.getText(length - r, r).getBytes());
		out.write(NL.getBytes());
	    }
	    c("----------------------------------");
	} catch (Exception e) {
	    Exceptions.printStackTrace(e);
	    throw new IOException("Decompression error");
	}

    }

    private void decompressExposeLitige(String file, boolean salarieDemandeur, boolean dossierDatak) {
	try {
	    c("-------------Exposé du litige----------------");
	    if (salarieDemandeur && dossierDatak) {
	    } else if (!salarieDemandeur && dossierDatak) {
	    } else if (salarieDemandeur && !dossierDatak) {
	    } else if (!salarieDemandeur && !dossierDatak) {
	    }
	    decompress(null, file);
	    c("-----------------------------------------------");
	} catch (IOException ex) {
	    Exceptions.printStackTrace(ex);
	}


    }
}
