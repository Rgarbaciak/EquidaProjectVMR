/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import Database.ChevalDAO;
import Database.CourseDAO;
import forms.FormCheval;
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
import model.Cheval;
import model.Course;
import model.Participer;
import model.TypeCheval;

/**
 *
 * @author zokum
 */
@WebServlet(name = "ServletCheval", urlPatterns = {"/ServletCheval"})
public class ServletCheval extends HttpServlet {
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
            out.println("<title>Servlet ServletCheval</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCheval at " + request.getContextPath() + "</h1>");
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
        // Récup et affichage par date décroissante de toutes les ventes    
       
        
        
        if(url.equals("/equida/ServletCheval/listerLesChevaux"))
        {  
           ArrayList<Cheval> lesChevaux = ChevalDAO.getLesChevaux(connection);
           request.setAttribute("pLesChevaux", lesChevaux);
           getServletContext().getRequestDispatcher("/vues/Cheval/listerLesChevaux.jsp").forward(request, response);
        }
        
        if(url.equals("/equida/ServletCheval/listerLesRaces"))
        {  
         
        
            ArrayList<TypeCheval> lesRaces = ChevalDAO.getLesRaces(connection);
           request.setAttribute("pLesRaces", lesRaces);
           getServletContext().getRequestDispatcher("/vues/Cheval/listerLesRaces.jsp").forward(request, response);
        }
       
        
                if(url.equals("/equida/ServletCheval/consulter"))
        {  
          Integer idCheval = Integer.parseInt((String)request.getParameter("codeCheval"));
            Cheval unCheval = ChevalDAO.getLeCheval(connection,idCheval);
            
             ArrayList<Participer> lesParticipations = CourseDAO.getLesCoursesByIdChe(connection,idCheval);
            
           request.setAttribute("pInfoCheval", unCheval);
           request.setAttribute("pInfoCourse", lesParticipations);
           getServletContext().getRequestDispatcher("/vues/Cheval/consulter.jsp").forward(request, response);
        }
         if(url.equals("/equida/ServletCheval/AjouterCheval"))
        {  
           ArrayList<TypeCheval> lesRaces = ChevalDAO.getLesRaces(connection);
           request.setAttribute("pLesRaces", lesRaces);
           
           ArrayList<Cheval> lesNoms = ChevalDAO.getLesNomsP(connection);
           request.setAttribute("pLesNoms", lesNoms);
           
           
           ArrayList<Cheval> lesNoms2 = ChevalDAO.getLesNomsM(connection);
           request.setAttribute("pLesNoms2", lesNoms2);
           
           
           getServletContext().getRequestDispatcher("/vues/Cheval/AjouterCheval.jsp").forward(request, response);
        }
          if(url.equals("/equida/ServletCheval/updateCheval"))
        {  
            ArrayList<TypeCheval> lesRaces = ChevalDAO.getLesRaces(connection);
            request.setAttribute("pLesRaces", lesRaces);
            
            ArrayList<Cheval> lesPeres = ChevalDAO.getLesNomsP(connection);
            request.setAttribute("pLesPeres", lesPeres);
           
           
            ArrayList<Cheval> lesMeres = ChevalDAO.getLesNomsM(connection);
            request.setAttribute("pLesMeres", lesMeres);
            
            Integer idCheval = Integer.parseInt((String)request.getParameter("che_id"));

            Cheval leCheval = ChevalDAO.getLeCheval(connection, idCheval);
            request.setAttribute("pLecheval", leCheval);
            getServletContext().getRequestDispatcher("/vues/Cheval/updateCheval.jsp").forward(request, response);
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
        FormCheval form = new FormCheval();
         String url = request.getRequestURI();  
         
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */ 
        Cheval unCheval= null;
       
     
        
        /* Stockage du formulaire et de l'objet dans l'objet request */ 
        request.setAttribute( "form", form );
        request.setAttribute( "pUnCheval", unCheval );

        if (form.getErreurs().isEmpty()){
            
         
          if(url.equals("/equida/ServletCheval/AjouterCheval"))
        {                   
          Cheval unChevalAjout =  form.ajouterCheval(request);
          unCheval =  ChevalDAO.ajouterCheval(connection, unChevalAjout);

        }
                    if(url.equals("/equida/ServletCheval/updateCheval"))
        {                   
          Cheval unChevalUpdate =  form.updateCheval(request);
          unCheval =  ChevalDAO.modifierCheval(connection, unChevalUpdate);
          System.out.println("coucou"+unCheval.getId());

        }
          System.out.println(unCheval);
            if (unCheval != null ){
                Cheval selectCheval =ChevalDAO.getLeCheval(connection, unCheval.getId());
                System.out.println("ID CHEVAL " + unCheval.getId());
                System.out.println("REQUEST"+request);
                request.setAttribute("pInfoCheval", selectCheval);
                this.getServletContext().getRequestDispatcher("/vues/Cheval/consulter.jsp" ).forward( request, response );
            }
            else 
            {
                // Cas oùl'insertion en bdd a échoué
                //renvoyer vers une page d'erreur 
            }

        }
        else 
            if(url.equals("/equida/ServletClient/updateCheval"))
        { 
		// il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs
            ArrayList<TypeCheval> lesTypes = ChevalDAO.getLesRaces(connection);
            request.setAttribute("pLesRaces", lesTypes);
            
             ArrayList<Cheval> lesPeres = ChevalDAO.getLesNomsP(connection);
            request.setAttribute("pLesPeres", lesPeres);
           
           
            ArrayList<Cheval> lesMeres = ChevalDAO.getLesNomsM(connection);
            request.setAttribute("pLesMeres", lesMeres);
          
           this.getServletContext().getRequestDispatcher("/vues/updateCheval.jsp" ).forward( request, response );
        }

        if(url.equals("/equida/ServletClient/ajouterClient"))
        { 
		// il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs
            ArrayList<TypeCheval> lesTypes = ChevalDAO.getLesRaces(connection);
            request.setAttribute("pLesRaces", lesTypes);
            
           this.getServletContext().getRequestDispatcher("/vues/Cheval/ajouterCheval.jsp" ).forward( request, response );
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
