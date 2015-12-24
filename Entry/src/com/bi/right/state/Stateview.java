package com.bi.right.state;

import java.util.*;

public class Stateview {

    private String Z_ACK_DEFENDEUR="Z_ACK_DEFENDEUR",Z_RECOURS="Z_RECOURS",Z_TRANSACTION="Z_TRANSACTION",Z_JUGEE="Z_JUGEE",Z_ROLE="Z_ROLE",Z_CONCLUSIONSRECO="Z_CONCLUSIONSRECO",Z_CONCLUSIONS="Z_CONCLUSIONS",Z_SAISINE="SAISINE",Z_CPH = "CPH", Z_DEMADEUR = "DEMADEUR",
            Z_DEFENDEUR = "DEFENDEUR",
            Z_DEMANDES = "DEMANDES",
            Z_DISCUSSIONS = "DISCUSSIONS",
            Z_PIECES = "PIECES",
            Z_ADDR = "ADDR",
            Z_EXPOSE_LITIGE = "EXPOSE_LITIGE",
            Z_SECTION = "SECTION",
            Z_REDRESSEMENT_CREDITOR = "REDRESSEMENT_CREDITOR",
            Z_REDRESSEMENT_ADMINISTRATEUR = "REDRESSEMENT_ADMINISTRATEUR",
            Z_CONTRAT_START_BEFORE_ENDDATE = "CONTRAT_START_BEFORE_ENDDATE",
            Z_CONTRAT_START = "CONTRAT_START",
            Z_CONTRAT_END = "CONTRAT_END",
            Z_CONTRAT = "CONTRAT",
            Z_JUGEMENT_EVENT = "JUGEMENT",
            Z_DEFENDEUR_SALARIE = "DEFENDEUR_SALARIE",
            Z_DEFENDEUR_SOCIETE = "DEFENDEUR_SOCIETE",
            Z_DEMANDEUR_SALARIE = "DEMANDEUR_SALARIE",
            Z_DEMANDEUR_SOCIETE = "DEMANDEUR_SOCIETE",
            Z_DEMANDE_AMOUNT = "DEMANDE_AMOUNT",
            Z_DEFENDEUR_DEMANDEUR = "DEFENDEUR_DEMANDEUR",
            Z_LIQUIDATION_ENDROIT = "LIQUIDATION_ENDROIT",
            Z_REDRESSEMENT_ENDROIT = "REDRESSEMENT_ENDROIT",
            Z_LIQUIDATION = "LIQUIDATION",
            Z_LIQUIDATION_DATE = "LIQUIDATION_DATE",
            Z_AFFAIRE = "AFFAIRE";
    private Map<Item, Integer> states = new EnumMap<Item, Integer>(Item.class);
    private boolean conseilReady = false;
    private boolean contratReady = false;
    private boolean defendeurReady = false;
    private boolean demandeurReady = false;
    private boolean demandesReady = false;
    private boolean liquidationReady = false;
    private boolean redressementReady = false;
    private boolean discussionsReady = false;
    private boolean exposeLitigeReady = false;

    public boolean isExposeLitigeReady() {
        return exposeLitigeReady;
    }

    public void setExposeLitigeReady(boolean exposeLitigeReady) {
        this.exposeLitigeReady = exposeLitigeReady;
    }

    public boolean isDiscussionsReady() {
        return discussionsReady;
    }

    public boolean isSaisineReady() {
        return conseilReady && contratReady
                && defendeurReady && demandeurReady
                && demandesReady;
    }

    public boolean isConclusionsReady() {
        return isSaisineReady() && discussionsReady && exposeLitigeReady;
    }

    public boolean isConseilReady() {
        return conseilReady;
    }

    public boolean isContratReady() {
        return contratReady;
    }

    public boolean isDefendeurReady() {
        return defendeurReady;
    }

    public boolean isDemandeurReady() {
        return demandeurReady;
    }

    public boolean isDemandesReady() {
        return demandesReady;
    }

    public boolean isLiquidationReady() {
        return liquidationReady;
    }

    public boolean isRedressementReady() {
        return redressementReady;
    }

    public Map<Item, Integer> getStates() {
        return states;
    }

    public void set(Item cph, int i) {

        states.put(cph, i);
    }

    int get(Item item) {
        return states.get(item);
    }

    void setConseilReady(boolean b) {
        this.conseilReady = b;
    }

    void setContratReady(boolean b) {
        this.contratReady = b;
    }

    void setDefendeurReady(boolean b) {
        this.defendeurReady = b;
    }

    void setDemandeurReady(boolean b) {
        this.demandeurReady = b;
    }

    void setDemandesReady(boolean b) {
        this.demandesReady = b;
    }

    void setLiquidationReady(boolean b) {
        this.liquidationReady = b;
    }

    void setRedressementReady(boolean b) {
        this.redressementReady = b;
    }

    void setDiscussionsReady(boolean b) {
        this.discussionsReady = b;

    }

    public String getZ_CPH() {
        return Z_CPH;
    }

    public void setZ_CPH(String Z_CPH) {
        this.Z_CPH = Z_CPH;
    }

    public String getZ_DEMADEUR() {
        return Z_DEMADEUR;
    }

    public void setZ_DEMADEUR(String Z_DEMADEUR) {
        this.Z_DEMADEUR = Z_DEMADEUR;
    }

    public String getZ_DEFENDEUR() {
        return Z_DEFENDEUR;
    }

    public void setZ_DEFENDEUR(String Z_DEFENDEUR) {
        this.Z_DEFENDEUR = Z_DEFENDEUR;
    }

    public String getZ_DEMANDES() {
        return Z_DEMANDES;
    }

    public void setZ_DEMANDES(String Z_DEMANDES) {
        this.Z_DEMANDES = Z_DEMANDES;
    }

    public String getZ_DISCUSSIONS() {
        return Z_DISCUSSIONS;
    }

    public void setZ_DISCUSSIONS(String Z_DISCUSSIONS) {
        this.Z_DISCUSSIONS = Z_DISCUSSIONS;
    }

    public String getZ_PIECES() {
        return Z_PIECES;
    }

    public void setZ_PIECES(String Z_PIECES) {
        this.Z_PIECES = Z_PIECES;
    }

    public String getZ_ADDR() {
        return Z_ADDR;
    }

    public void setZ_ADDR(String Z_ADDR) {
        this.Z_ADDR = Z_ADDR;
    }

    public String getZ_EXPOSE_LITIGE() {
        return Z_EXPOSE_LITIGE;
    }

    public void setZ_EXPOSE_LITIGE(String Z_EXPOSE_LITIGE) {
        this.Z_EXPOSE_LITIGE = Z_EXPOSE_LITIGE;
    }

    public String getZ_SECTION() {
        return Z_SECTION;
    }

    public void setZ_SECTION(String Z_SECTION) {
        this.Z_SECTION = Z_SECTION;
    }

    public String getZ_REDRESSEMENT_CREDITOR() {
        return Z_REDRESSEMENT_CREDITOR;
    }

    public void setZ_REDRESSEMENT_CREDITOR(String Z_REDRESSEMENT_CREDITOR) {
        this.Z_REDRESSEMENT_CREDITOR = Z_REDRESSEMENT_CREDITOR;
    }

    public String getZ_REDRESSEMENT_ADMINISTRATEUR() {
        return Z_REDRESSEMENT_ADMINISTRATEUR;
    }

    public void setZ_REDRESSEMENT_ADMINISTRATEUR(String Z_REDRESSEMENT_ADMINISTRATEUR) {
        this.Z_REDRESSEMENT_ADMINISTRATEUR = Z_REDRESSEMENT_ADMINISTRATEUR;
    }

    public String getZ_CONTRAT_START_BEFORE_ENDDATE() {
        return Z_CONTRAT_START_BEFORE_ENDDATE;
    }

    public void setZ_CONTRAT_START_BEFORE_ENDDATE(String Z_CONTRAT_START_BEFORE_ENDDATE) {
        this.Z_CONTRAT_START_BEFORE_ENDDATE = Z_CONTRAT_START_BEFORE_ENDDATE;
    }

    public String getZ_CONTRAT_START() {
        return Z_CONTRAT_START;
    }

    public void setZ_CONTRAT_START(String Z_CONTRAT_START) {
        this.Z_CONTRAT_START = Z_CONTRAT_START;
    }

    public String getZ_CONTRAT_END() {
        return Z_CONTRAT_END;
    }

    public void setZ_CONTRAT_END(String Z_CONTRAT_END) {
        this.Z_CONTRAT_END = Z_CONTRAT_END;
    }

    public String getZ_DEFENDEUR_SALARIE() {
        return Z_DEFENDEUR_SALARIE;
    }

    public void setZ_DEFENDEUR_SALARIE(String Z_DEFENDEUR_SALARIE) {
        this.Z_DEFENDEUR_SALARIE = Z_DEFENDEUR_SALARIE;
    }

    public String getZ_DEFENDEUR_SOCIETE() {
        return Z_DEFENDEUR_SOCIETE;
    }

    public void setZ_DEFENDEUR_SOCIETE(String Z_DEFENDEUR_SOCIETE) {
        this.Z_DEFENDEUR_SOCIETE = Z_DEFENDEUR_SOCIETE;
    }

    public String getZ_DEMANDEUR_SALARIE() {
        return Z_DEMANDEUR_SALARIE;
    }

    public void setZ_DEMANDEUR_SALARIE(String Z_DEMANDEUR_SALARIE) {
        this.Z_DEMANDEUR_SALARIE = Z_DEMANDEUR_SALARIE;
    }

    public String getZ_DEMANDEUR_SOCIETE() {
        return Z_DEMANDEUR_SOCIETE;
    }

    public void setZ_DEMANDEUR_SOCIETE(String Z_DEMANDEUR_SOCIETE) {
        this.Z_DEMANDEUR_SOCIETE = Z_DEMANDEUR_SOCIETE;
    }

    public String getZ_DEMANDE_AMOUNT() {
        return Z_DEMANDE_AMOUNT;
    }

    public void setZ_DEMANDE_AMOUNT(String Z_DEMANDE_AMOUNT) {
        this.Z_DEMANDE_AMOUNT = Z_DEMANDE_AMOUNT;
    }

    public String getZ_DEFENDEUR_DEMANDEUR() {
        return Z_DEFENDEUR_DEMANDEUR;
    }

    public void setZ_DEFENDEUR_DEMANDEUR(String Z_DEFENDEUR_DEMANDEUR) {
        this.Z_DEFENDEUR_DEMANDEUR = Z_DEFENDEUR_DEMANDEUR;
    }

    public String getZ_LIQUIDATION_ENDROIT() {
        return Z_LIQUIDATION_ENDROIT;
    }

    public void setZ_LIQUIDATION_ENDROIT(String Z_LIQUIDATION_ENDROIT) {
        this.Z_LIQUIDATION_ENDROIT = Z_LIQUIDATION_ENDROIT;
    }

    public String getZ_REDRESSEMENT_ENDROIT() {
        return Z_REDRESSEMENT_ENDROIT;
    }

    public void setZ_REDRESSEMENT_ENDROIT(String Z_REDRESSEMENT_ENDROIT) {
        this.Z_REDRESSEMENT_ENDROIT = Z_REDRESSEMENT_ENDROIT;
    }

    public String getZ_LIQUIDATION() {
        return Z_LIQUIDATION;
    }

    public void setZ_LIQUIDATION(String Z_LIQUIDATION) {
        this.Z_LIQUIDATION = Z_LIQUIDATION;
    }

    public String getZ_LIQUIDATION_DATE() {
        return Z_LIQUIDATION_DATE;
    }

    public void setZ_LIQUIDATION_DATE(String Z_LIQUIDATION_DATE) {
        this.Z_LIQUIDATION_DATE = Z_LIQUIDATION_DATE;
    }

    public String getZ_AFFAIRE() {
        return Z_AFFAIRE;
    }

    public void setZ_AFFAIRE(String Z_AFFAIRE) {
        this.Z_AFFAIRE = Z_AFFAIRE;
    }

    public String getZ_SAISINE() {
        return Z_SAISINE;
    }

    public void setZ_SAISINE(String Z_SAISINE) {
        this.Z_SAISINE = Z_SAISINE;
    }

    public String getZ_ROLE() {
        return Z_ROLE;
    }

    public void setZ_ROLE(String Z_ROLE) {
        this.Z_ROLE = Z_ROLE;
    }

    public String getZ_CONCLUSIONSRECO() {
        return Z_CONCLUSIONSRECO;
    }

    public void setZ_CONCLUSIONSRECO(String Z_CONCLUSIONSRECO) {
        this.Z_CONCLUSIONSRECO = Z_CONCLUSIONSRECO;
    }

    public String getZ_CONCLUSIONS() {
        return Z_CONCLUSIONS;
    }

    public void setZ_CONCLUSIONS(String Z_CONCLUSIONS) {
        this.Z_CONCLUSIONS = Z_CONCLUSIONS;
    }

    public String getZ_JUGEE() {
        return Z_JUGEE;
    }

    public void setZ_JUGEE(String Z_JUGEE) {
        this.Z_JUGEE = Z_JUGEE;
    }

    public String getZ_RECOURS() {
        return Z_RECOURS;
    }

    public void setZ_RECOURS(String Z_RECOURS) {
        this.Z_RECOURS = Z_RECOURS;
    }

    public String getZ_TRANSACTION() {
        return Z_TRANSACTION;
    }

    public void setZ_TRANSACTION(String Z_TRANSACTION) {
        this.Z_TRANSACTION = Z_TRANSACTION;
    }

    public String getZ_ACK_DEFENDEUR() {
        return Z_ACK_DEFENDEUR;
    }

    public void setZ_ACK_DEFENDEUR(String Z_ACK_DEFENDEUR) {
        this.Z_ACK_DEFENDEUR = Z_ACK_DEFENDEUR;
    }

    public String getZ_CONTRAT() {
        return Z_CONTRAT;
    }

    public void setZ_CONTRAT(String Z_CONTRAT) {
        this.Z_CONTRAT = Z_CONTRAT;
    }

    public String getZ_JUGEMENT_EVENT() {
        return Z_JUGEMENT_EVENT;
    }

    public void setZ_JUGEMENT_EVENT(String Z_JUGEMENT_EVENT) {
        this.Z_JUGEMENT_EVENT = Z_JUGEMENT_EVENT;
    }
    
    
    
}
