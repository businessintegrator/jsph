package com.bi.right.customer.bo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="R")
public class LicenciementRuleContainer {

	private Boolean legale = true;
        private Boolean cadre = true;
        private Boolean fauteGrave = false;
        private Boolean fauteLourde = false;
        private Boolean fauteHorsPReavis = false;
        
        private int nbSalarieMin = 0;
        private int nbSalarieMax = 10;
        private int nbMoisPreavis = 0;
        
	private String convention = null;
	private LicenciementRule legal;
	private LicenciementRule conventionnel;
	
	public LicenciementRuleContainer() {
		// TODO Auto-generated constructor stub
	}

	public Boolean getLegale() {
		return legale;
	}

	public void setLegale(Boolean legale) {
		this.legale = legale;
	}

	public String getConvention() {
		return convention;
	}

	public void setConvention(String convention) {
		this.convention = convention;
	}

	public LicenciementRule getLegal() {
		return legal;
	}

	public void setLegal(LicenciementRule legal) {
		this.legal = legal;
	}

	public LicenciementRule getConventionnel() {
		return conventionnel;
	}

	public void setConventionnel(LicenciementRule conventionnel) {
		this.conventionnel = conventionnel;
	}

    public Boolean getCadre() {
        return cadre;
    }

    public void setCadre(Boolean cadre) {
        this.cadre = cadre;
    }

    public int getNbSalarieMin() {
        return nbSalarieMin;
    }

    public void setNbSalarieMin(int nbSalarieMin) {
        this.nbSalarieMin = nbSalarieMin;
    }

    public int getNbSalarieMax() {
        return nbSalarieMax;
    }

    public void setNbSalarieMax(int nbSalarieMax) {
        this.nbSalarieMax = nbSalarieMax;
    }

    public Boolean getFauteGrave() {
        return fauteGrave;
    }

    public void setFauteGrave(Boolean fauteGrave) {
        this.fauteGrave = fauteGrave;
    }

    public Boolean getFauteLourde() {
        return fauteLourde;
    }

    public void setFauteLourde(Boolean fauteLourde) {
        this.fauteLourde = fauteLourde;
    }

    public Boolean getFauteHorsPReavis() {
        return fauteHorsPReavis;
    }

    public void setFauteHorsPReavis(Boolean fauteHorsPReavis) {
        this.fauteHorsPReavis = fauteHorsPReavis;
    }

    public int getNbMoisPreavis() {
        return nbMoisPreavis;
    }

    public void setNbMoisPreavis(int nbMoisPreavis) {
        this.nbMoisPreavis = nbMoisPreavis;
    }


        
	
}
