/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author zokum
 */
public class Cheval {
    private int id ;
    private String nom;
    private String sexe;
    private String sire  ;
    private String dateNaissance;
    private String poids;
    private ArrayList<Lot> lesLots ;
    private TypeCheval unTypeCheval;
    private Cheval pere;
    private Cheval mere;
     private ArrayList<Participer> lesParticipations ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getSire() {
        return sire;
    }

    public void setSire(String sire) {
        this.sire = sire;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }
    
      public ArrayList<Lot> getLesLots() {
        return lesLots;
    }

    public void setLesLots(ArrayList<Lot> lesLots) {
        this.lesLots = lesLots;
    }
    
    public void addUnLot(Lot pUnLot){
        if (lesLots == null){
            lesLots = new ArrayList<Lot>();
        }
        lesLots.add(pUnLot);
    }

    public TypeCheval getUnTypeCheval() {
        return unTypeCheval;
    }

    public void setUnTypeCheval(TypeCheval unTypeCheval) {
        this.unTypeCheval = unTypeCheval;
    }
    

    public Cheval getPere() {
        return pere;
    }

    public void setPere(Cheval pere) {
        this.pere = pere;
    }

    public Cheval getMere() {
        return mere;
    }

    public void setMere(Cheval mere) {
        this.mere = mere;
    }
    
        public ArrayList<Participer> getLesParticipations() {
    return lesParticipations;
    }

    public void setLesParticipationss(ArrayList<Participer> lesParticipations) {
        this.lesParticipations = lesParticipations;
    }
    
    public void addUnePieceJointe(Participer pUneParticipation){
        if (lesParticipations == null){
            lesParticipations = new ArrayList<Participer>();
        }
        lesParticipations.add(pUneParticipation);
    }
    
}
