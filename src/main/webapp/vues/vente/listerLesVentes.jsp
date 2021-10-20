<%-- 
    Document   : listerLesVentes
    Created on : 18 août 2021, 16:52:29
    Author     : Zakina
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Vente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Equida | Liste des ventes</title>
        <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
       
        
        
        
    </head>
    <body>
        
        <%@include file="../Components/Menu.jsp" %>
        <h2>Liste des ventes</h2>
        <% if(role==2 || role==3){%>
         <h3><a href ='/equida/ServletClient/ajouterClient'>Ajouter une vente</a></h3>
         <%}%>
         <%
        ArrayList<Vente> lesVentes = (ArrayList)request.getAttribute("pLesVentes");
        %>
       <table  class="table table-bordered table-striped table-condensed">  
            <thead> 
                <tr>             
                    <th>Numéro de la vente</th>
                    <th>Nom</th>
                    <th>Date début</th>
                    <th>Catégorie</th>  
                </tr>
            </thead>
            <tbody>
             
                <tr>
                    <%
                    for(int i = 0; i < lesVentes.size();i++)
                    {
                        
                        Vente uneVente = lesVentes.get(i);
                        out.println("<tr><td>");
                        out.println(uneVente.getId());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(uneVente.getNom());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(uneVente.getDateDebutVente());
                        out.println("</td>");

                        out.println("<td>&ensp;");
                        out.println(uneVente.getCategVente().getLibelle());
                        out.println("</td>");
                        
                        out.println("<td><a href ='../ServletClient/listerLesClientsParCategVente?codeCat="+ uneVente.getCategVente().getCode()+ "'>");
                        out.println("Lister les clients interessés");
                        out.println("</td>");
                      
                        out.println("<td><a href ='../ServletVente/listerLesCourrielsParVentes?codeVente="+ uneVente.getId()+ "'>");
                        out.println("Lister les courriels");
                        out.println("</td>");
                        
                         out.println("<td><a href ='../ServletVente/listerLesChevauxParVente?codeVente="+ uneVente.getId()+ "'>");
                        out.println("Lister les chevaux");
                        out.println("</td>");
                     
                        
                        
                        
                  
                               
                    }
                    %>
                </tr>
               
            </tbody>
        </table>
                 
    </body>
</html>
