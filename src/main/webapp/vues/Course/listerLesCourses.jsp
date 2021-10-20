<%-- 
    Document   : listerLesVentes
    Created on : 18 août 2021, 16:52:29
    Author     : Zakina
--%>

<%@page import="model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cheval"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Equida | Liste des courses</title>
        <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
        <%@include file="../Components/Menu.jsp" %>
        <h2>Liste des courses</h2>
        <% if(role==2 || role==3){%>
        <h3><a href ='/equida/ServletCourse/ajouterCourse'>Ajouter une course </a></h3> <!-- Code à modifier -->
        <%}%>
         <%
        ArrayList<Course> lesCourses= (ArrayList)request.getAttribute("pLesCourses");
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>Nom</th>
                    <th>Lieu</th> 
                    <th>Date</th> 
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesCourses.size();i++)
                    {
                        
                        Course uneCourse = lesCourses.get(i);
                        out.println("<tr><td>");
                        out.println(uneCourse.getId());
                        out.println("</a></td>");
                        
                        

                        out.println("<td>");
                        out.println(uneCourse.getNom());
                        out.println("</a></td>");
                        
                        out.println("<td>");
                        out.println(uneCourse.getLieu());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(uneCourse.getDate());
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
