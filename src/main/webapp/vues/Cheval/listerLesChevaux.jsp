<%-- 
    Document   : listerLesVentes
    Created on : 18 août 2021, 16:52:29
    Author     : Zakina
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Cheval"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Equida | Lister les chevaux</title>
        <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
        <%@include file="../Components/Menu.jsp" %>
        <h2>Liste des chevaux</h2>
        <% if(role==2 || role==3){%>
        <h3><a href ='/equida/ServletCheval/AjouterCheval'>Ajouter un cheval </a></h3> <!-- Code à modifier -->
        <%}%>
         <%
             
        ArrayList<Cheval> lesChevaux= (ArrayList)request.getAttribute("pLesChevaux");
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>Nom</th>
                    <th>Sexe</th> 
                    <th>Sire</th> 
                    <th>&ensp;Date de Naissance&ensp;</th>
                    <th>Poids</th>
                    <th>Race</th>
                    <th> Cheval pere </th>
                    <th> Cheval mere </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesChevaux.size();i++)
                    {
                        
                        Cheval unCheval = lesChevaux.get(i);
                        out.println("<tr><td>");
                        out.println(unCheval.getId());
                        out.println("</a></td>");
                        
                        

                        out.println("<td><a href ='../ServletCheval/consulter?codeCheval="+ unCheval.getId()+ "'>");
                        out.println(unCheval.getNom());
                        out.println("</a></td>");
                        
                        out.println("<td>");
                        out.println(unCheval.getSexe());
                        out.println("</td>");
                        
                        out.println("<td>&ensp;&ensp;");
                        out.println(unCheval.getSire());
                        out.println("</td>&ensp;&ensp;");
                        
                        out.println("<td>&ensp;");
                        out.println(unCheval.getDateNaissance());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unCheval.getPoids());
                        out.println("Kg</td>");
                        
                        out.println("<td>");
                        out.println(unCheval.getUnTypeCheval().getLibelle());
                        out.println("</td>");
                        
                        
                          out.println("<td>");
                        out.println(unCheval.getPere().getNom());
                        out.println("</td>");
                        
                          out.println("<td>");
                        out.println(unCheval.getMere().getNom());
                        out.println("</td>");
                        if(role==2 || role==3){
                        out.println("<td><a href ='../ServletCheval/updateCheval?che_id="+ unCheval.getId()+"'>");  //Manque le code à ajouter
                        out.println("Modifier");
                        out.println("</td>");
                        
                        out.println("<td><a href ='../ServletVente/listerLesChevauxParVente?codeVente'>"); //Manque le code à ajouter
                        out.println("Supprimer");
                        out.println("</td>");
                        }

                     
         
                    }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
