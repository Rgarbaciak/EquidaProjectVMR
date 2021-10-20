/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Database.CategVenteDAO;
import Database.ClientDAO;
import Database.ParamDAO;
import forms.FormClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategVente;
import model.Client;
import model.Pays;

/**
 *
 * @author Zakina
 */
public class ServletClient extends HttpServlet {
    
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
            out.println("<title>Servlet ServletClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletClient at " + request.getContextPath() + "</h1>");
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
        if(url.equals("/equida/ServletClient/listerLesClientsParCategVente"))
        {  
            String codeCat = (String)request.getParameter("codeCat");
                  
            ArrayList<Client> lesClients = ClientDAO.getLesClientsByCateg(connection, codeCat);
            request.setAttribute("pLesClientsByCateg", lesClients);
            getServletContext().getRequestDispatcher("/vues/client/listerLesClientsParCategVente.jsp").forward(request, response);
        }
        
         if(url.equals("/equida/ServletClient/ajouterClient"))
        {                   
            ArrayList<Pays> lesPays = ParamDAO.getLesPays(connection);
            request.setAttribute("pLesPays", lesPays);
            
            ArrayList<CategVente> lesCategVentes = CategVenteDAO.getLesCategVentes(connection);
            request.setAttribute("pLesCategVente", lesCategVentes);
            this.getServletContext().getRequestDispatcher("/vues/client/ajouterClient.jsp" ).forward( request, response );
        }
         
        if(url.equals("/equida/ServletClient/updateClient"))
        {                   
            ArrayList<Pays> lesPays = ParamDAO.getLesPays(connection);
            request.setAttribute("pLesPays", lesPays);
            
            ArrayList<CategVente> lesCategVentes = CategVenteDAO.getLesCategVentes(connection);
            Integer idClient = Integer.parseInt((String)request.getParameter("idClient")); 
            Client unClient = ClientDAO.getUnClient(connection,idClient );
            
            
            request.setAttribute("pLesCategVente", lesCategVentes);
            request.setAttribute("pClient", unClient);
            
            this.getServletContext().getRequestDispatcher("/vues/client/updateClient.jsp" ).forward( request, response );
        }
         
         if(url.equals("/equida/ServletClient/listerLesClients"))
        {  
          
                  
            ArrayList<Client> lesClients = ClientDAO.getLesClients(connection);
            request.setAttribute("pLesClients", lesClients);
            getServletContext().getRequestDispatcher("/vues/client/listerLesClients.jsp").forward(request, response);
        }
         
         if(url.equals("/equida/ServletClient/deleteClient"))
        {  
          
            Integer idClient = Integer.parseInt((String)request.getParameter("idClient"));      
            ClientDAO.deleteClient(connection,idClient);
            
            getServletContext().getRequestDispatcher("/vues/Accueil/Accueil.jsp").forward(request, response);
        }
          if(url.equals("/equida/ServletClient/ajouterCompte"))
        {  
 
                ArrayList<Pays> lesPays = ParamDAO.getLesPays(connection);
            request.setAttribute("pLesPays", lesPays);
            
            ArrayList<CategVente> lesCategVentes = CategVenteDAO.getLesCategVentes(connection);
            request.setAttribute("pLesCategVente", lesCategVentes);
            
            this.getServletContext().getRequestDispatcher("/vues/client/ajouterCompte.jsp").forward(request, response);
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
        FormClient form = new FormClient();
         String url = request.getRequestURI();  
         
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Client unClient= null;
       
     
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "pUnClient", unClient );

        if (form.getErreurs().isEmpty()){
             if(url.equals("/equida/ServletClient/updateClient"))
        {
            
          Client unClientUpdate =  form.updateClient(request);
          unClient =  ClientDAO.updateClient(connection, unClientUpdate);
 
        }
         
          if(url.equals("/equida/ServletClient/ajouterClient"))
        {                   
          Client unClientAjout =  form.ajouterClient(request);
          unClient =  ClientDAO.ajouterClient(connection, unClientAjout);

        }
          System.out.println(unClient);
            if (unClient != null ){
                Client selectClient =ClientDAO.getUnClient(connection, unClient.getId());
                System.out.println("REQUEST"+request);
                request.setAttribute("pClient", selectClient);
                this.getServletContext().getRequestDispatcher("/vues/Cheval/consulter.jsp" ).forward( request, response );
            }
            else 
            {
                // Cas oùl'insertion en bdd a échoué
                //renvoyer vers une page d'erreur 
            }
           
           
       
        }
        else 
        
         if(url.equals("/equida/ServletClient/updateClient"))
        { 
		// il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs
            ArrayList<Pays> lesPays = ParamDAO.getLesPays(connection);
            request.setAttribute("pLesPays", lesPays);
            
            ArrayList<CategVente> lesCategVentes = CategVenteDAO.getLesCategVentes(connection);
            request.setAttribute("pLesCategVente", lesCategVentes);
           this.getServletContext().getRequestDispatcher("/vues/updateClient.jsp" ).forward( request, response );
        }
        
         else if(url.equals("/equida/ServletClient/ajouterClient"))
        { 
		// il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs
            ArrayList<Pays> lesPays = ParamDAO.getLesPays(connection);
            request.setAttribute("pLesPays", lesPays);
            
            ArrayList<CategVente> lesCategVentes = CategVenteDAO.getLesCategVentes(connection);
            request.setAttribute("pLesCategVente", lesCategVentes);
           this.getServletContext().getRequestDispatcher("/vues/clientAjouter.jsp" ).forward( request, response );
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
