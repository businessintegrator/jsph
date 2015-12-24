package com.bi.right.state;

import com.bi.right.customer.bo.GUIManager;
import com.bi.right.customer.bo.Liquidation;
import com.bi.right.customer.bo.Personne;
import com.bi.right.customer.bo.Redressement;
import com.bi.right.customer.bo.Societe;

public class DossierChecker extends Milkshake {

	private GUIManager p;
	private Stateview s;

	public DossierChecker(GUIManager project) {
		
		this.p = project;
		s = new Stateview();
	}

	public void process() {
		if (isEmpty(p.getAffaire())) {
			
			s.set(Item.AFFAIRE, 0);

		} else {
			s.set(Item.AFFAIRE, 100);
                        
		}
		if (isEmpty(p.getExposeLitige())) {
			
			s.set(Item.EXPOSE_LITIGE, 0);

		}else {
			s.set(Item.EXPOSE_LITIGE, 100);
                        s.setExposeLitigeReady(true);
                        
		}

		ConseilChecker chk = new ConseilChecker(p.getConseil(), s);
		chk.process();
		ContratChecker chkcontrat = new ContratChecker(p.getContrat(), s);
		chkcontrat.process();

		DefChecker chkcdef = new DefChecker(p.getDefendeur(), s);
		chkcdef.process();

		DemChecker chkcdem = new DemChecker(p, s);
		chkcdem.process();

		DemandesChecker dmChk = new DemandesChecker(this.p, s);
		dmChk.process();
		Societe societe = null;
		Personne salarie = null;
		if (chkcdef.isSalarie() && chkcdem.isSalarie()) {
			this.s.set(Item.DEFENDEUR_DEMANDEUR, 0);

		} else if (!chkcdef.isSalarie() && chkcdem.isSalarie()) {
			this.s.set(Item.DEFENDEUR_DEMANDEUR, 100);
			salarie = chkcdem.getSalarie();
			societe = chkcdef.getSociete();

		} else if (chkcdef.isSalarie() && !chkcdem.isSalarie()) {
			this.s.set(Item.DEFENDEUR_DEMANDEUR, 100);
			societe = chkcdem.getSociete();
			salarie = chkcdef.getSalarie();
		} else if (!chkcdef.isSalarie() && !chkcdem.isSalarie()) {
			this.s.set(Item.DEFENDEUR_DEMANDEUR, 0);
		}
                if (societe == null){
                    s.set(Item.DEFENDEUR_SOCIETE,0);
                    s.set(Item.DEMANDEUR_SOCIETE,0);
                    if (chkcdem.isSalarie()){
                      s.setDefendeurReady(false);
                    
                    }else {
                        s.setDemandeurReady(false);
                    }
                    return;
                }
		Liquidation liquidation = societe.getIdliquidation();
		if (liquidation != null) {
			LiquidationChecker liquidateur = new LiquidationChecker(
					liquidation, s);
			liquidateur.process();
			s.set(Item.LIQUIDATION_ENDROIT,100);
		} 
		Redressement redresement = societe.getIdredressement();
		if (redresement != null) {
			RedressementChecker redressement = new RedressementChecker(
					redresement, s);
			redressement.process();
			s.set(Item.REDRESSEMENT_ENDROIT,100);
		}
                
               

	}

	public Stateview getStateView() {
		// TODO Auto-generated method stub
		return s;
	}

}
