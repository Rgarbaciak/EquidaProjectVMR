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
import model.Course;
import model.Participer;
import model.TypeCheval;

/**
 *
 * @author Zakina
 */
public class CourseDAO {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static ArrayList<Course>  getLesCourses(Connection connection){      
        ArrayList<Course> lesCourses = new  ArrayList<Course>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("SELECT course.cou_id,course.cou_nom,course.cou_lieu,course.cou_date FROM `course`");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Course uneCourse = new Course();
               
                uneCourse.setId(rs.getInt("cou_id"));
                uneCourse.setNom(rs.getString("cou_nom"));
                uneCourse.setLieu(rs.getString("cou_lieu"));
                uneCourse.setDate(rs.getString("cou_date"));
                
                lesCourses.add(uneCourse);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesCourses ;    
    } 
     
     
     public static ArrayList<Participer>  getLesCoursesByIdChe(Connection connection,int idCheval){      
        ArrayList<Participer> lesParticipation = new  ArrayList<Participer>();
        ArrayList<Course> lesCourses = new  ArrayList<Course>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("SELECT participer.par_place,course.cou_nom,course.cou_lieu,course.cou_date,course.cou_id FROM `course` \n" +
                                                "INNER JOIN participer on course.cou_id=participer.cou_id\n" +
                                                "INNER JOIN cheval on cheval.che_id=participer.che_id\n" +
                                                "AND cheval.che_id=?");
            requete.setInt(1, idCheval);
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Course uneCourse = new Course();
               
                uneCourse.setId(rs.getInt("course.cou_id"));
                uneCourse.setNom(rs.getString("cou_nom"));
                uneCourse.setLieu(rs.getString("cou_lieu"));
                uneCourse.setDate(rs.getString("cou_date"));
                
                Participer Participation= new Participer();
                Participation.setPlace(rs.getInt("par_place"));
                lesCourses.add(uneCourse);
                
                Participation.setLesCourses(lesCourses);
                
                lesParticipation.add(Participation);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesParticipation ;    
    } 
     
     
    
}
