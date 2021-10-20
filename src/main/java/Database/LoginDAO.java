/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Client;
import model.Compte;
import model.Role;

/**
 *
 * @author ts1sio
 */
public class LoginDAO {


    Connection cnt=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static Compte getCompte(Connection cnt ,String user , String pass){
         Compte unCompte = new Compte();

        try{
           
           requete =cnt.prepareStatement(" SELECT co.com_id,co.com_login,co.com_mdp,c.cli_id,r.rol_id,r.rol_nom FROM compte co , client c , role r \n"
                 +  " WHERE co.com_role = r.rol_id \n "
                 +  " AND c.cli_compte = co.com_role \n"
                 +  " AND co.com_login = ?"
                 +  " AND co.com_mdp= ?");
           
       
           requete.setString(1,user);
           requete.setString(2,pass);  
            
           rs=requete.executeQuery();
           
           
              if(rs.next()){
                  
                if(user.equals(rs.getString("com_login")) && pass.equals(rs.getString("com_mdp"))){
                  
                unCompte.setLogin(rs.getString("com_login")) ;
                unCompte.setMdp(rs.getString("com_mdp"));
                 System.out.println(" USER " + user + " userBDD ");
                
                
                
                Role unRole = new Role();
                
                unRole.setId(rs.getInt("rol_id"));
                unRole.setNom(rs.getString("rol_nom"));
                
               
               unCompte.setUnRole(unRole);
               
     
                }
                else{
                    unCompte=null;  
                }
              }
              else {
                   unCompte=null; 
                   
                  
                }
          
    
        } catch(SQLException e){
           e.printStackTrace();
           
         }
        
         return unCompte ;
        
    
}
}
    
 