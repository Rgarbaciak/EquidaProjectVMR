<%-- 
    Document   : listerLesVentes
    Created on : 18 août 2021, 16:52:29
    Author     : Zakina
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Pays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Equida | Liste des pays</title>
      
       <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
        
        
    </head>
    <body>
        
        <%@include file="../Components/Menu.jsp" %>
        <h2>Liste des Pays</h2>
        
         <h3><a href ='/equida/ServletParam/ajouterPays'>Ajouter un pays</a></h3>
         <%
        ArrayList<Pays> lesPays = (ArrayList)request.getAttribute("pListePays");
         if(role==1 && role==2){
                    response.sendRedirect( request.getContextPath() + "/");
                }
        %>
       <table  class="table table-bordered table-striped table-condensed">  
            <thead> 
                <tr>             
                    <th>code</th>
                    <th>nom</th> 
                </tr>
            </thead>
            <tbody>
             
                <tr>
                    <%
                    for(int i = 0; i < lesPays.size();i++)
                    {
                        
                        Pays unPays = lesPays.get(i);
                        out.println("<tr><td>");
                        out.println(unPays.getCode());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(unPays.getNom());
                        out.println("</td>");

                        out.println("<td><a href ='../ServletVente/listerLesChevauxParVente?codeVente'>");  //Manque le code à ajouter
                        out.println("Modifier");
                        out.println("</td>");
                        
                        out.println("<td><a href ='../ServletVente/listerLesChevauxParVente?codeVente'>"); //Manque le code à ajouter
                        out.println("Supprimer");
                        out.println("</td>");
                       
                        
                        
                  
                               
                    }
                    %>
                </tr>
               
            </tbody>
        </table>
                 
    </body>
</html>
