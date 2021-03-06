/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 *
 * @author Zakina
 */
public class InitConnexion implements ServletContextListener {
  //parametres de connexion
    Connection connection=null;
    String pilotejdbc=null;
    String urlconnexionjdbc=null;
    String utilisateurjdbc=null;
    String motdepassejdbc=null;

    //action déclenchée lors du chargement du context
    public void contextInitialized(ServletContextEvent event)
    {
        System.out.println("----------- Contexte initialisé -----------");

        //lire le contexte
        ServletContext servletContext=event.getServletContext();
        /*pilotejdbc=(String)servletContext.getInitParameter("pilotejdbc");
        urlconnexionjdbc=(String)servletContext.getInitParameter("urlconnexionjdbc");
        utilisateurjdbc=(String)servletContext.getInitParameter("utilisateurjdbc");
        motdepassejdbc=(String)servletContext.getInitParameter("motdepassejdbc");
        */
        try
        {
            //chargement du driver
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Pilote MySQL JDBC chargé");
        }
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
            System.out.println("Erreur lors du chargemement du pilote");
        }

        try
        {
            //obtention de la connexion
            
           //connection = DriverManager.getConnection ("jdbc:mysql://172.20.0.241:3306/EQUIVMR","USR_VMR","mpUsrVmr");//lycee
            connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/equida","root",""); //maison
            
            //sauvegarder la connexion dans le context
            servletContext.setAttribute("connection",connection);
            System.out.println("Connexion opérationnelle" + "jdbc:mysql://localhost:3306/equida");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Erreur lors de l’établissementde la connexion");
        }
    }

    //action qui permet de détruire le filtre
    public void contextDestroyed(ServletContextEvent event)
    {
        System.out.println("----------- Contexte détruit -----------");
        try
        {
            //fermeture
            System.out.println("Connexion fermée");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            Utilitaire.fermerConnexion(connection);
        }
    }
  
}
