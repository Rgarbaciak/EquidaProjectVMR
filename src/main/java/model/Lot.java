/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author zokum
 */
public class Lot {
    private int id;
    private String prixDepart;
    private Cheval leCheval;
    private Vente laVente ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(String prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Cheval getLeCheval() {;
        return leCheval;
    }

    public void setLeCheval(Cheval leCheval) {
        this.leCheval = leCheval;
    }

    public Vente getLaVente() {
        return laVente;
    }

    public void setLaVente(Vente laVente) {
        this.laVente = laVente;
    }
    
    
}
