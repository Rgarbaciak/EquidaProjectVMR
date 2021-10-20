<%-- 
    Document   : listerLesVentes
    Created on : 18 août 2021, 16:52:29
    Author     : Zakina
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Lot"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Equida | Liste des chevaux</title>
         <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
        <%@include file="../Components/Menu.jsp" %>
        <h2>Liste des chevaux</h2>
         <%
        ArrayList<Lot> lesLots= (ArrayList)request.getAttribute("plesLots");
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>Numéro du cheval</th>
                    <th>Nom</th>
                    <th>Sexe</th> 
                    <th>Sire</th> 
                    <th>&ensp;Date de Naissance&ensp;</th>
                    <th>Poids</th>
                    <th>Race</th>
                    <th>Prix de départ</th>
                    <th> Cheval pere </th>
                    <th> Cheval mere </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesLots.size();i++)
                    {
                        
                        Lot unLot = lesLots.get(i);
                        out.println("<tr><td>");
                        out.println(unLot.getId());
                        out.println("</a></td>");

                        out.println("<td><a href ='../ServletCheval/informationCheval?codeCheval="+ unLot.getLeCheval().getId()+ "'>");
                        out.println(unLot.getLeCheval().getNom());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(unLot.getLeCheval().getSexe());
                        out.println("</td>");
                        
                        out.println("<td>&ensp;&ensp;");
                        out.println(unLot.getLeCheval().getSire());
                        out.println("</td>&ensp;&ensp;");
                        
                        out.println("<td>&ensp;");
                        out.println(unLot.getLeCheval().getDateNaissance());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getPoids());
                        out.println("Kg</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getUnTypeCheval().getLibelle());
                        out.println("</td>");
                        
                         out.println("<td>");
                        out.println(unLot.getPrixDepart());
                        out.println("</td>");
                        
                          out.println("<td>");
                        out.println(unLot.getLeCheval().getPere().getNom());
                        out.println("</td>");
                        
                          out.println("<td>");
                        out.println(unLot.getLeCheval().getMere().getNom());
                        out.println("</td>");
                    
                     
         
                    }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
