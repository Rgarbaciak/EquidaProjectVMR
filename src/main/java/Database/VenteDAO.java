/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CategVente;
import model.Vente;
import model.Courriel;
import model.PieceJointe;
import model.Cheval;
import model.TypeCheval;
import model.Lot;


/**
 *
 * @author Zakina
 */
public class VenteDAO {
    
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    /* @author Zakina - 25/08/2021
    /* Méthode permettant de lister toutes les ventes enregistrées en base, triées par date décroissante.
    /* Pour chaque vente, on récupère aussi sa catégorie.
    /* La liste des vente est stockée dans une ArrayList
    */
    public static ArrayList<Vente>  getLesVentes(Connection connection){    
        
        ArrayList<Vente> lesVentes = new  ArrayList<Vente>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from vente, categvente where categvente.cat_code=vente.ven_codeCategVente order by ven_dateDebut desc");          
            //executer la requete
            rs=requete.executeQuery();
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Vente uneVente = new Vente();
                uneVente.setId(rs.getInt("ven_id"));
                uneVente.setNom(rs.getString("ven_nom"));
                uneVente.setDateDebutVente(rs.getString("ven_dateDebut"));
                
                CategVente laCategVente = new CategVente();
                laCategVente.setCode(rs.getString("cat_code"));  // on aurait aussi pu prendre CodeCateg
                laCategVente.setLibelle(rs.getString("cat_libelle"));
                
                uneVente.setCategVente(laCategVente);
                lesVentes.add(uneVente);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesVentes ;    
    }
    public static ArrayList<Courriel>  getLesCourriels(Connection connection, int idVente){    
        
        ArrayList<Courriel> lesCourriels = new  ArrayList<Courriel>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from courriel,vente where  courriel.cou_venteCourriel=vente.ven_id AND courriel.cou_venteCourriel=? ");
            requete.setInt(1, idVente);
            //executer la requete
            rs=requete.executeQuery();
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Courriel unCourriel = new Courriel();
                unCourriel.setId(rs.getInt("cou_id"));
                unCourriel.setCorps(rs.getString("cou_corps"));
                unCourriel.setObjet(rs.getString("cou_objet"));
                lesCourriels.add(unCourriel);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesCourriels ;    
    }
    
    public static ArrayList<Lot>  getLesLots(Connection connection, int idVente){    
        
       
        ArrayList<Lot> lesLots = new  ArrayList<Lot>();
        try
        {
            //preparation de la requete     
           System.out.println("venteDAO " + idVente );
            requete=connection.prepareStatement("SELECT c.che_id  ,c.che_nom,c.che_sexe,c.che_sire,c.che_dateNaissance,c.che_poids,typecheval.typC_libelle,lot.lot_prixDepart,p.che_nom, m.che_nom , vente.ven_id, lot_id FROM lot,vente,typecheval,cheval c LEFT OUTER JOIN cheval p on  c.che_pere=p.che_id  LEFT OUTER JOIN cheval m on c.che_mere=m.che_id WHERE  lot.che_lot=c.che_id AND c.che_typC=typecheval.typC_id AND lot.ven_lot=vente.ven_id AND  vente.ven_id=?");
            System.out.println(requete);
            requete.setInt(1, idVente);
            //executer la requete
            rs=requete.executeQuery();
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Cheval unCheval = new Cheval();
                unCheval.setId(rs.getInt("c.che_id"));
                unCheval.setNom(rs.getString("c.che_nom"));
                unCheval.setSexe(rs.getString("c.che_sexe"));
                unCheval.setSire(rs.getString("c.che_sire"));
                unCheval.setDateNaissance(rs.getString("c.che_dateNaissance"));
                unCheval.setPoids(rs.getString("c.che_poids"));
                
                Cheval mere = new Cheval();
                mere.setNom(rs.getString("m.che_nom"));
                unCheval.setMere(mere);
                
                Cheval pere = new Cheval();
                pere.setNom(rs.getString("p.che_nom"));
                unCheval.setPere(pere);
                
                
                
                
                TypeCheval tc = new TypeCheval();
                tc.setLibelle(rs.getString("TypC_libelle"));
                unCheval.setUnTypeCheval(tc);
                
                Lot unLot= new Lot();
                unLot.setId(rs.getInt("lot_id"));
                unLot.setPrixDepart(rs.getString("lot_prixDepart"));
                
               
                unLot.setLeCheval(unCheval);
                
                lesLots.add(unLot);
                 
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
        return lesLots ;   
        
    }
   
}
