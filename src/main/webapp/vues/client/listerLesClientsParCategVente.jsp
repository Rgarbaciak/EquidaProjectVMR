<%-- 
    Document   : listerLesClientsParCategVente
    Created on : 18 août 2021, 17:52:16
    Author     : Zakina
--%>

<%@page import="model.Client"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Equida | Lister les clients par ventes</title>
         <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
         <%@include file="../Components/Menu.jsp" %>
       <h2>Liste des clients</h2>
       
         <%
        ArrayList<Client> lesClients = (ArrayList)request.getAttribute("pLesClientsByCateg");
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
                               
                    }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
