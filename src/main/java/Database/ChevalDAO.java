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
import model.Cheval;
import model.TypeCheval;

/**
 *
 * @author Zakina
 */
public class ChevalDAO {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static ArrayList<Cheval>  getLesChevaux(Connection connection){      
        ArrayList<Cheval> lesChevaux = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("SELECT c.che_id ,c.che_nom,c.che_sexe,c.che_sire,c.che_dateNaissance,c.che_poids,typecheval.typC_libelle,p.che_nom as pere, m.che_nom as mere  FROM typecheval,cheval c LEFT OUTER JOIN cheval p on  c.che_pere=p.che_id  LEFT OUTER JOIN cheval m on c.che_mere=m.che_id WHERE c.che_typC=typecheval.typC_id ORDER BY c.che_id ");
            
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
                mere.setNom(rs.getString("mere"));
                unCheval.setMere(mere);
                
                Cheval pere = new Cheval();
                pere.setNom(rs.getString("pere"));
                
                TypeCheval tc = new TypeCheval();
                tc.setLibelle(rs.getString("typecheval.typC_libelle"));
                
                unCheval.setUnTypeCheval(tc);
                
                unCheval.setPere(pere);
                
                System.out.println(unCheval);
                lesChevaux.add(unCheval);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesChevaux ;    
    } 
     
     
       
       
       
          public static Cheval getLeCheval(Connection connection,int idCheval){      
        Cheval unCheval = new  Cheval();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("SELECT c.che_id ,c.che_nom,c.che_sexe,c.che_sire,c.che_dateNaissance,c.che_poids,typecheval.typC_libelle,p.che_nom as pere, m.che_nom as mere,p.che_id,m.che_id  "
                    + "FROM typecheval,cheval c "
                    + "LEFT OUTER JOIN cheval p on  c.che_pere=p.che_id  "
                    + "LEFT OUTER JOIN cheval m on c.che_mere=m.che_id"
                    + " WHERE c.che_typC=typecheval.typC_id "
                    + "AND c.che_id=?");
            requete.setInt(1, idCheval);
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            if ( rs.next() ) {  
                
               
                unCheval.setId(rs.getInt("c.che_id"));
                unCheval.setNom(rs.getString("c.che_nom"));
                unCheval.setSexe(rs.getString("c.che_sexe"));
                unCheval.setSire(rs.getString("c.che_sire"));
                unCheval.setDateNaissance(rs.getString("c.che_dateNaissance"));
                unCheval.setPoids(rs.getString("c.che_poids"));
                
                Cheval mere = new Cheval();
                mere.setNom(rs.getString("mere"));
                mere.setId(rs.getInt("m.che_id"));
                unCheval.setMere(mere);
                
                Cheval pere = new Cheval();
                pere.setNom(rs.getString("pere"));
                pere.setId(rs.getInt("p.che_id"));
                
                TypeCheval tc = new TypeCheval();
                tc.setLibelle(rs.getString("typecheval.typC_libelle"));
                
                unCheval.setUnTypeCheval(tc);
                
                unCheval.setPere(pere);
                
                System.out.println(unCheval.getPere().getId());
              
                
          
                
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval ;    
    }
     public static ArrayList<Cheval>  getLesNomsP(Connection connection){      
        ArrayList<Cheval> lesNoms = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("Select che_id, che_nom from cheval where"
                    + " che_sexe='Mâle'");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Cheval unNom = new Cheval();
               
                unNom.setId(rs.getInt("che_id"));
                unNom.setNom(rs.getString("che_nom"));

          
                lesNoms.add(unNom);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesNoms ;    
    }
     public static ArrayList<Cheval>  getLesNomsM(Connection connection){      
        ArrayList<Cheval> lesNoms = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("Select che_id, che_nom from cheval where"
                    + " che_sexe='Femelle'");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Cheval unNom = new Cheval();
               
                unNom.setId(rs.getInt("che_id"));
                unNom.setNom(rs.getString("che_nom"));

          
                lesNoms.add(unNom);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesNoms ;    
    }
     
       public static ArrayList<TypeCheval>  getLesRaces(Connection connection){      
        ArrayList<TypeCheval> lesTypes = new  ArrayList<TypeCheval>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("Select * from typecheval");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                TypeCheval unType = new TypeCheval();
               
                unType.setId(rs.getInt("typC_id"));
                unType.setLibelle(rs.getString("typC_libelle"));
                unType.setDescription(rs.getString("typC_description"));
          
                lesTypes.add(unType);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesTypes ;    
    }
       
    public static Cheval ajouterCheval(Connection connection, Cheval unCheval){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("INSERT INTO cheval ( che_nom, che_sexe, che_sire,che_dateNaissance,che_poids,che_TypC,che_pere,che_mere)\n" +
                    "VALUES (?,?,?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unCheval.getNom());
            requete.setString(2, unCheval.getSexe());
            requete.setString(3, unCheval.getSire());
            requete.setString(4, unCheval.getDateNaissance());
            requete.setString(5, unCheval.getPoids());
            requete.setString(6, unCheval.getUnTypeCheval().getLibelle());
            requete.setInt(7, unCheval.getPere().getId());
            requete.setInt(8, unCheval.getMere().getId());
            

           /* Exécution de la requête */
            requete.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unCheval.setId(idGenere);
            }     
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval ;    
    }
   public static Cheval modifierCheval(Connection connection, Cheval unCheval){      
        try
        {
    System.out.println("ID du cheval "+unCheval.getId());        
    //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("UPDATE cheval SET che_nom=?, che_sexe=?, che_sire=?, che_dateNaissance=?, che_poids=?, che_typC=?, che_pere=? , che_mere=? WHERE che_id=?", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unCheval.getNom());
            requete.setString(2, unCheval.getSexe());
            requete.setString(3, unCheval.getSire());
            requete.setString(4, unCheval.getDateNaissance());
            requete.setString(5, unCheval.getPoids());
            requete.setString(6, unCheval.getUnTypeCheval().getLibelle());
            requete.setInt(7, unCheval.getPere().getId());
            requete.setInt(8, unCheval.getMere().getId());
            requete.setInt(9, unCheval.getId());
            

           /* Exécution de la requête */
            requete.executeUpdate();
       System.out.println(requete);
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval ;    
    }
}
