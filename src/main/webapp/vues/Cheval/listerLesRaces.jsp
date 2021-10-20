<%-- 
    Document   : listerLesVentes
    Created on : 18 août 2021, 16:52:29
    Author     : Zakina
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.TypeCheval"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Equida | Liste des Races</title>
        <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
        <%@include file="../Components/Menu.jsp" %>
        <h2>Liste des Races</h2>
        <h3><a href ='/equida/ServletParam/ajouterRace'>Ajouter une race </a></h3> <!-- Code à modifier -->
         <%
        ArrayList<TypeCheval> lesRaces= (ArrayList)request.getAttribute("pLesRaces");
         if(role==1){
                    response.sendRedirect( request.getContextPath() + "/");
                }
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>Nom</th>
                    <th>Sexe</th> 
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesRaces.size();i++)
                    {
                        
                        TypeCheval uneRace = lesRaces.get(i);
                        out.println("<tr><td>");
                        out.println(uneRace.getId());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(uneRace.getLibelle());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(uneRace.getDescription());
                        out.println("</td>");
                        
                        out.println("<td><a href ='../ServletVente/listerLesChevauxParVente?codeVente'>");  //Manque le code à ajouter
                        out.println("Modifier");
                        out.println("</td>");
                        

                        
                        
                     
         
                    }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
