<%-- 
    Document   : listerLesClients
    Created on : 3 oct. 2021, 16:35:29
    Author     : zokum
--%>

<%@page import="model.Client"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Equida | Lister les clients</title>
         <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
        <%@include file="../Components/Menu.jsp" %>
       <h2>Liste des clients</h2>
       
       <h3><a href ='/equida/ServletClient/ajouterClient'>Ajouter un client </a></h3>
       
        
           <%
        ArrayList<Client> lesClients = (ArrayList)request.getAttribute("pLesClients");
         if(role==1){
                    response.sendRedirect( request.getContextPath() + "/");
                }
        %>
    <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Pays</th>
                    <th>Rue</th>
                    <th>Code Postal</th>
                    <th>Ville</th>
                    <th>Adresse Messagerie</th>
                   

                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesClients.size();i++)
                    {
                        Client unClient = lesClients.get(i);
                        out.println("<tr><td>");
                        out.println(unClient.getId());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(unClient.getNom());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unClient.getPrenom());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unClient.getLePays().getNom());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unClient.getAdrRue());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unClient.getCodePostal());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unClient.getVille());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unClient.getAdresseMessagerie());
                        out.println("</td>");

                        out.println("<td><a href ='../ServletClient/updateClient?idClient="+ unClient.getId()+ "'>"); //Manque le code à ajouter
                        out.println("Modifier");
                        out.println("</td>");
                        
                        out.println("<td><a href ='../ServletClient/deleteClient?idClient="+ unClient.getId()+ "'>"); //Manque le code à ajouter
                        out.println("Supprimer");
                        out.println("</td>");
                               
                    }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>