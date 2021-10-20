/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Zakina
 */
public class Vente {
    
    private int id;
    private String nom ;
    private String dateDebutVente ;
    private CategVente CategVente ;
    private ArrayList<Courriel> lesCourriels ;
    private Lieu leLieu ;
    private ArrayList<Lot> lesLots ;
    private ArrayList<TypeCheval> lesTypesChevaux;

    public Vente() {
    }

    public Vente(int id, String nom, String dateDebutVente) {
        this.id = id;
        this.nom = nom;
        this.dateDebutVente = dateDebutVente;
    }



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

    public String getDateDebutVente() {
        return dateDebutVente;
    }

    public void setDateDebutVente(String dateDebutVente) {
        this.dateDebutVente = dateDebutVente;
    }

    public CategVente getCategVente() {
        return CategVente;
    }

    public void setCategVente(CategVente CategVente) {
        this.CategVente = CategVente;
    }

    public ArrayList<Courriel> getLesCourriels() {
        return lesCourriels;
    }

    public void setLesCourriels(ArrayList<Courriel> lesCourriels) {
        this.lesCourriels = lesCourriels;
    }
    
    public void addUnCourriel(Courriel pUnCourriel){
        if (lesCourriels == null){
            lesCourriels = new ArrayList<Courriel>();
        }
        lesCourriels.add(pUnCourriel);
    }

    public Lieu getLeLieu() {
        return leLieu;
    }

    public void setLeLieu(Lieu leLieu) {
        this.leLieu = leLieu;
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
    
   public ArrayList<TypeCheval> getLesTypesChevaux() {
        return lesTypesChevaux;
    }

    public void setLesTypesChevaux(ArrayList<TypeCheval> lesTypesChevaux) {
        this.lesTypesChevaux = lesTypesChevaux;
    }
    
    public void addUnTypeCheval(TypeCheval pUnTypeCheval){
        if (lesTypesChevaux == null){
            lesTypesChevaux = new ArrayList<TypeCheval>();
        }
        lesTypesChevaux.add(pUnTypeCheval);
    }
    
    
}
