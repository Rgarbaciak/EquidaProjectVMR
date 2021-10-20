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
public class Course {
    private int id;
    private String nom;
    private String lieu;
    private String date;
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

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    public ArrayList<Participer> getLesParticipations() {
    return lesParticipations;
    }

    public void setLesParticipations(ArrayList<Participer> lesParticipations) {
        this.lesParticipations = lesParticipations;
    }
    
    public void addUneParticipation(Participer pUneParticipation){
        if (lesParticipations == null){
            lesParticipations = new ArrayList<Participer>();
        }
        lesParticipations.add(pUneParticipation);
    }
    
}
