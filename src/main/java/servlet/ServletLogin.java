/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Database.LoginDAO;
import forms.FormLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Compte;
import model.Role;

/**
 *
 * @author adminsio
 */
public class ServletLogin extends HttpServlet {   

    public ServletLogin() {
        super();
    }
    
    Connection cnt;
     @Override
    public void init()
    {     
        ServletContext servletContext=getServletContext();
        cnt=(Connection)servletContext.getAttribute("connection");
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
            out.println("<title>Servlet ServletLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLogin at " + request.getContextPath() + "</h1>");
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
        if(url.equals("/equida/ServletLogin/Login"))
        {  
             int msg = 0;
                    request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher("/vues/Login/Login.jsp").forward(request, response);
      
        }
        if(url.equals("/equida/ServletLogin/Profil"))
        {  
            
            getServletContext().getRequestDispatcher("/vues/Login/Profil.jsp").forward(request, response);
      
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
        
        FormLogin form = new FormLogin();
 
        
        
        Compte unCompte = form.checkConnexion(request);
            
        String user = unCompte.getLogin();
        String pass = unCompte.getMdp();
        
        
        request.setAttribute("form", form); 
        
        Compte compte = LoginDAO.getCompte(cnt, user, pass);
            
            if (compte != null)
            {
                HttpSession session = request.getSession();
                session.setAttribute("user", compte.getLogin());
                session.setAttribute("pass", compte.getMdp());
                
                session.setAttribute("client", compte.getLeClient());
                session.setAttribute("role",compte.getUnRole().getId());
               
               
                
                
                // Envoi 1 si l'utilisateur est connecté
                session.setAttribute("connected", 1);
                
                
                this.getServletContext().getRequestDispatcher("/vues/Login/Profil.jsp").forward(request, response);
                System.out.println("Connection à " + user + ' ' + pass);
                
            }
            else {
                    
                    //this.getServletContext().getRequestDispatcher("/vues/Login/Login.jsp").forward(request, response);
                    System.out.println("Les Informations renseignèes correspondent à aucun utilisateur enregistrés.");
                    
                    int msg = 1;
                    request.setAttribute("msg", msg);
                    request.getRequestDispatcher("/vues/Login/Login.jsp").forward(request, response); 
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
