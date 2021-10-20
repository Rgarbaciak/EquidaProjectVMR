/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author adminsio
 */
public class Role {
    
    private int id;
    private String nom;
    private ArrayList<Compte> lesComptes;

    public Role() {
    }

    public Role(int id, String nom) {
        this.id = id;
        this.nom = nom;
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

    public ArrayList<Compte> getLesComptes() {
        return lesComptes;
    }

    public void setLesComptes(ArrayList<Compte> lesComptes) {
        this.lesComptes = lesComptes;
    }
    
    public void addUnCompte(Compte pUnCompte){
        if (lesComptes == null){
            lesComptes = new ArrayList<Compte>();
    }
    lesComptes.add(pUnCompte);
    }   
    
}
