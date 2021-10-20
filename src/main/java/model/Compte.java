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
public class Compte {
    
    private int id;
    private String login;
    private String mdp;
    private Client leClient;
    private Role unRole;
    
    public Compte() {
    }

    public Compte(int id, String login, String mdp) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Client getLeClient() {
        return leClient;
    }

    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }

    public Role getUnRole() {
        return unRole;
    }

    public void setUnRole(Role unRole) {
        this.unRole = unRole;
    }

   
}
