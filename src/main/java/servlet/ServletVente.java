/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Database.VenteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Courriel;
import model.Vente;
import model.Cheval;
import model.Lot;

/**
 *
 * @author Zakina
 */
public class ServletVente extends HttpServlet {
    
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
            out.println("<title>Servlet ServletVente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletVente at " + request.getContextPath() + "</h1>");
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
        if(url.equals("/equida/ServletVente/listerLesVentes"))
        {  
            ArrayList<Vente> lesVentes = VenteDAO.getLesVentes(connection);
            request.setAttribute("pLesVentes", lesVentes);
            getServletContext().getRequestDispatcher("/vues/vente/listerLesVentes.jsp").forward(request, response);
      
        }
        if(url.equals("/equida/ServletVente/listerLesCourrielsParVentes"))
        {  
            Integer idVente = Integer.parseInt((String)request.getParameter("codeVente"));
            ArrayList<Courriel> lesCourriels = VenteDAO.getLesCourriels(connection,idVente);
            request.setAttribute("pLesCourriels", lesCourriels);
            getServletContext().getRequestDispatcher("/vues/vente/listerLesCourriel.jsp").forward(request, response);
        }
        
         if(url.equals("/equida/ServletVente/listerLesChevauxParVente"))
        {  
            Integer idVente = Integer.parseInt((String)request.getParameter("codeVente"));
            ArrayList<Lot> lesLots= VenteDAO.getLesLots(connection,idVente);
            request.setAttribute("plesLots", lesLots);
            getServletContext().getRequestDispatcher("/vues/vente/listerLesChevauxParVente.jsp").forward(request, response);
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
        processRequest(request, response);
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
