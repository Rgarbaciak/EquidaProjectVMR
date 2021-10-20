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
import model.Client;
import model.Pays;
import model.CategVente;

/**
 *
 * @author Zakina
 */
public class ClientDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    /* @author Zakina - 25/08/2021
    /* Méthode permettant de lister les clients interessés par la catégorie de la vente selectionnée (passée en paramètre de la méthode)
    /* Pour chaque client, on récupère aussi le nom de son pays
    /* La liste des clients est stockée dans une ArrayList
    */
    public static ArrayList<Client>  getLesClientsByCateg(Connection connection, String codeCateg){      
        ArrayList<Client> lesClients = new  ArrayList<Client>();
        try
        {
            //preparation de la requete     
            //codeCateg="ETE";
            requete=connection.prepareStatement("SELECT * FROM client,clientcategvente,categvente,pays WHERE client.cli_codePays=pays.pays_code AND client.cli_id=clientcategvente.clicat_codeClient AND categvente.cat_code=clientcategvente.clicat_codeCategVente AND categvente.cat_code=?");
            requete.setString(1, codeCateg);
            //executer la requete
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
                Client unClient = new Client();
                unClient.setId(rs.getInt("cli_id"));
                unClient.setNom(rs.getString("cli_nom"));
                unClient.setPrenom(rs.getString("cli_prenom"));
                unClient.setVille(rs.getString("cli_ville"));
                unClient.setCodePostal(rs.getString("cli_copos"));
                unClient.setAdresseMessagerie(rs.getString("cli_mail"));
                
                
                Pays p = new Pays();
                p.setCode(rs.getString("pays_code"));
                p.setNom(rs.getString("pays_nom"));
                
                unClient.setLePays(p);
                CategVente uneCateg = new CategVente();
                uneCateg.setCode(rs.getString("cat_code"));  // on aurait aussi pu prendre CodeCateg
                uneCateg.setLibelle(rs.getString("cat_libelle"));
                
                lesClients.add(unClient);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesClients ;    
    }
    //SELECT c.*, cv.cat_libelle, p.pays_nom as nomPays, p.pays_code as codePays FROM categvente cv, client c, ach_cat ac, acheteur a, pays p where cv.cat_code = ? and cv.CAT_CODE = ac.CAT_CODE and ac.CLI_ID = a.CLI_ID and a.CLI_ID = c.CLI_ID and c.cli_codePays = p.pays_code
    
     // Méthode permettant d'insérer un client en base à partir de l'objet client passé en paramètre
    // Cette méthode renvoie l'objet client
        public static Client ajouterClient(Connection connection, Client unClient){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("INSERT INTO client ( cli_nom, cli_prenom, cli_rue, cli_copos, cli_ville, cli_mail, cli_codePays)\n" +
                    "VALUES (?,?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unClient.getNom());
            requete.setString(2, unClient.getPrenom());
            requete.setString(3, unClient.getAdrRue());
            requete.setString(4, unClient.getCodePostal());
            requete.setString(5, unClient.getVille());
            requete.setString(6, unClient.getMail());
            requete.setString(7, unClient.getLePays().getCode());
            

           /* Exécution de la requête */
            requete.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unClient.setId(idGenere);
            }
            
            // ajout des enregistrement dans la table clientcategvente
            for (int i=0;i<unClient.getLesCategVente().size();i++){
                PreparedStatement requete2=connection.prepareStatement("INSERT INTO clientcategvente (clicat_codeClient, clicat_codeCategVente )\n" +
                    "VALUES (?,?)");
                 requete2.setInt(1, unClient.getId());
                 requete2.setString(2, unClient.getLesCategVente().get(i).getCode());
                 requete2.executeUpdate();
            }
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unClient ;    
    }
        
        
         public static Client updateClient(Connection connection, Client unClient){      
       
        try
        {
            System.out.println("IDCLIENT"+unClient.getId());
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("UPDATE client SET  cli_nom=?, cli_prenom=?, cli_rue=?, cli_copos=?, cli_ville=?, cli_mail=?, cli_codePays=? WHERE cli_id=?", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unClient.getNom());
            requete.setString(2, unClient.getPrenom());
            requete.setString(3, unClient.getAdrRue());
            requete.setString(4, unClient.getCodePostal());
            requete.setString(5, unClient.getVille());
            requete.setString(6, unClient.getMail());
            requete.setString(7, unClient.getLePays().getCode());
            requete.setInt(8, unClient.getId());
            

           /* Exécution de la requête */
            requete.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            PreparedStatement requete2=connection.prepareStatement("DELETE FROM `clientcategvente` WHERE clicat_codeClient=?");
            requete2.setInt(1, unClient.getId());
            requete2.executeUpdate();
            
            // ajout des enregistrement dans la table clientcategvente
            for (int i=0;i<unClient.getLesCategVente().size();i++){
                PreparedStatement requete3=connection.prepareStatement("INSERT INTO clientcategvente (clicat_codeClient, clicat_codeCategVente )\n" +
                    "VALUES (?,?)");
                 requete3.setInt(1, unClient.getId());
                 requete3.setString(2, unClient.getLesCategVente().get(i).getCode());
                 requete3.executeUpdate();
                 
            }
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unClient ;    
    }
      public static ArrayList<Client>  getLesClients(Connection connection){      
        ArrayList<Client> lesClients = new  ArrayList<Client>();
        try
        {
            //preparation de la requete     
            //codeCateg="ETE";
            requete=connection.prepareStatement("SELECT client.cli_id,client.cli_prenom,client.cli_nom,pays.pays_nom,client.cli_rue,client.cli_copos,client.cli_ville,client.cli_mail,pays.pays_code FROM client INNER JOIN pays On client.cli_codePays= pays.pays_code ORDER By cli_id");
            //executer la requete
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
                Client unClient = new Client();
                unClient.setId(rs.getInt("client.cli_id"));
                unClient.setNom(rs.getString("client.cli_nom"));
                unClient.setPrenom(rs.getString("client.cli_prenom"));
                unClient.setVille(rs.getString("client.cli_ville"));
                unClient.setCodePostal(rs.getString("client.cli_copos"));
                unClient.setAdresseMessagerie(rs.getString("client.cli_mail"));
                unClient.setAdrRue(rs.getString("client.cli_rue"));
                
                
                Pays p = new Pays();
                p.setCode(rs.getString("pays.pays_code"));
                p.setNom(rs.getString("pays.pays_nom"));
                
                unClient.setLePays(p);
              
                
                lesClients.add(unClient);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesClients ;    
    }
      
      public static Client  getUnClient(Connection connection,int idClient){      
        Client unClient = new  Client();
       ArrayList<CategVente> lesCategs = new  ArrayList<CategVente>();
        try
        {
            //preparation de la requete     
           
            requete=connection.prepareStatement("SELECT client.cli_id,client.cli_prenom,client.cli_nom,pays.pays_code,client.cli_rue,client.cli_copos,client.cli_ville,client.cli_mail,pays.pays_nom,client.cli_mail\n" +
"FROM client \n" +
"INNER JOIN pays On client.cli_codePays= pays.pays_code \n" +
"WHERE client.cli_id=?");
             requete.setInt(1, idClient);
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            if ( rs.next() ) {  

                unClient.setId(rs.getInt("client.cli_id"));
                unClient.setNom(rs.getString("client.cli_nom"));
                unClient.setPrenom(rs.getString("client.cli_prenom"));
                unClient.setVille(rs.getString("client.cli_ville"));
                unClient.setCodePostal(rs.getString("client.cli_copos"));
                unClient.setAdresseMessagerie(rs.getString("client.cli_mail"));
                unClient.setAdrRue(rs.getString("client.cli_rue"));
                unClient.setMail(rs.getString("client.cli_mail"));
                
                
                Pays p = new Pays();
                p.setCode(rs.getString("pays.pays_code"));
                p.setNom(rs.getString("pays.pays_nom"));
                
                
                 PreparedStatement requete3=connection.prepareStatement("SELECT  categvente.cat_code,categvente.cat_libelle FROM `client` \n" +
                "INNER JOIN clientcategvente on client.cli_id= clientcategvente.clicat_codeClient\n" +
                "INNER JOIN categvente on clientcategvente.clicat_codeCategVente= categvente.cat_code\n" +
                "WHERE client.cli_id=?");
                  requete3.setInt(1, unClient.getId());
                 ResultSet rs3=requete3.executeQuery();
                
                while (rs3.next()) {
                    CategVente uneCateg = new CategVente();
                    uneCateg.setCode(rs3.getString("categvente.cat_code"));
                    uneCateg.setLibelle(rs3.getString("categvente.cat_libelle"));
                    unClient.addUneCategVente(uneCateg);
                    System.out.println(uneCateg.getLibelle());
                 
            }
                unClient.setLePays(p);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unClient ;    
    }
      
    
    public static ClientDAO deleteClient(Connection connection,int idClient){
    
    try{
           
            requete = connection.prepareStatement("DELETE FROM client WHERE cli_id=?");
             requete.setInt(1, idClient);
            rs=requete.executeQuery();
             
                 
           
       }
        catch(Exception e){
             System.out.println("Error " + e.getMessage());
        }
     return null;
    }    
    
    
}
