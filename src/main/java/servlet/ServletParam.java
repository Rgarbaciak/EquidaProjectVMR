/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Database.ChevalDAO;
import Database.ParamDAO;
import forms.FormPara;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pays;
import model.Lieu;
import model.TypeCheval;
import forms.FormPara;

/**
 *
 * @author adminsio
 */
@WebServlet(name = "ServletParam", urlPatterns = {"/ServletParam"})
public class ServletParam extends HttpServlet {
    
      Connection connection ;
      
        
    @Override
    public void init()
    {     
        ServletContext servletContext=getServletContext();
        connection=(Connection)servletContext.getAttribute("connection");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletParam</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletParam at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();  
        
        // Récup et affichage des clients interessés par une certaine catégorie de ventes
        if(url.equals("/equida/ServletParam/listerLesPays"))
        {    
            ArrayList<Pays> lesPays = ParamDAO.getLesPays(connection);
            request.setAttribute("pListePays", lesPays);
            getServletContext().getRequestDispatcher("/vues/Admin/listerLesPays.jsp").forward(request, response);
        }
        
        if(url.equals("/equida/ServletParam/listerLesLieux"))
        {    
            ArrayList<Lieu> lesLieux = ParamDAO.getLesLieux(connection);
            request.setAttribute("pListeLieux", lesLieux);
            getServletContext().getRequestDispatcher("/vues/Admin/listerLesLieux.jsp").forward(request, response);
        }
        
        if(url.equals("/equida/ServletParam/ajouterRace"))
        {    
        
            getServletContext().getRequestDispatcher("/vues/Admin/ajouterRace.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            /* Préparation de l'objet formulaire */ 
        FormPara form = new FormPara();
         String url = request.getRequestURI();  
         
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */ 
        TypeCheval uneRace= null;
       
     
        
        /* Stockage du formulaire et de l'objet dans l'objet request */ 
        request.setAttribute( "form", form );
        request.setAttribute( "pUneRace", uneRace );

        if (form.getErreurs().isEmpty()){
            
         
          if(url.equals("/equida/ServletParam/ajouterRace"))
        {                   
          TypeCheval uneRaceAjout =  form.AjouterRace(request);
          uneRace =  ParamDAO.ajouterRace(connection, uneRaceAjout);

        }
          System.out.println(uneRace);
            if (uneRace != null ){
                ArrayList<TypeCheval> lesRaces= ChevalDAO.getLesRaces(connection);
                request.setAttribute("pLesRaces", lesRaces);
                this.getServletContext().getRequestDispatcher("/vues/Cheval/listerLesRaces.jsp" ).forward( request, response );
            }
            else 
            {
                // Cas oùl'insertion en bdd a échoué
                //renvoyer vers une page d'erreur 
            }

        }
        else 

        if(url.equals("/equida/ServletParam/ajouterRace"))
        { 
		// il y a des erreurs. On réaffiche le formulaire avec des messages d'erreur
            
           this.getServletContext().getRequestDispatcher("/vues/Admin/ajouterRace.jsp" ).forward( request, response );
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

