<%-- 
    Document   : informationCheval
    Created on : 11 oct. 2021, 10:59:54
    Auulor     : adminsio
--%>

<%@page import="model.Client"%>
<%@page import="model.Course"%>
<%@page import="model.Participer"%>
<%@page import="model.Cheval"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
        
        <title>Equida | Consulter</title>
        <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>

    <body>
         <%@include file="../Components/Menu.jsp" %>
                  <%
       Cheval unCheval= (Cheval)request.getAttribute("pInfoCheval");
       Client unClient= (Client)request.getAttribute("pClient");
       ArrayList<Participer> lesParticipations= (ArrayList)request.getAttribute("pInfoCourse");
       System.out.println(" JSP ID CHEVAL "+unCheval.getId());
        
        if(unCheval == null){
            
        %>
        <h2>Information du client   
        
         <%  
           
            out.println(unClient.getNom());
               %></h2>
                    
         <section class="confirmation_part">
 
                              <div class="row">
                                  
                  <div class="col-lg-6 col-lx-4">
              <div class="single_confirmation_details">
                
                <ul>
                  <li>
                    <p>id</p><span>: <%  out.println(unClient.getId()); %></span>
                  </li>
                  <li>
                    <p>Nom</p><span>: <%  out.println(unClient.getNom()); %></span>
                  </li>
                  <li>
                    <p>Prenom</p><span>: <%  out.println(unClient.getPrenom()); %></span>
                  </li>
                  <li>
                    <p>Rue</p><span>: <%  out.println(unClient.getAdrRue()); %></span>
                  </li>
                  <li>
                    <p>Code Postal</p><span>: <%  out.println(unClient.getCodePostal()); %></span>
                  </li>
                  <li>
                    <p>Ville</p><span>: <%  out.println(unClient.getVille()); %></span>
                  </li>
                  <li>
                      <p>Mail</p><span>: <%  out.println(unClient.getMail()); %></span>
                  </li>
                  <li>
                    <p>Pays</p><span>: <%  out.println(unClient.getLePays().getNom()); %></span>
                  </li>
                  <li>
                    <p>CategVente</p><span>: <% for (int i=0; i<unClient.getLesCategVente().size(); i++){
               out.println(unClient.getLesCategVente().get(i).getLibelle() + "</br>");
             
          }
          %></span>
                  </li>
                  
                 
                  
                </ul>
              </div>
            </div>

          </div>
          
       <% }
            else {%>
        
        <h2>Information du cheval 
        <%  
           
            out.println(unCheval.getNom());
               %></h2>
                    
         <section class="confirmation_part">
 
                              <div class="row">
                                  
                  <div class="col-lg-6 col-lx-4">
              <div class="single_confirmation_details">
                
                <ul>
                  <li>
                    <p>id</p><span>: <%  out.println(unCheval.getId()); %></span>
                  </li>
                  <li>
                    <p>Nom</p><span>: <%  out.println(unCheval.getNom()); %></span>
                  </li>
                  <li>
                    <p>Sexe</p><span>: <%  out.println(unCheval.getSexe()); %></span>
                  </li>
                  <li>
                    <p>Sire</p><span>: <%  out.println(unCheval.getSire()); %></span>
                  </li>
                  <li>
                    <p>Date de Naissance</p><span>: <%  out.println(unCheval.getDateNaissance()); %></span>
                  </li>
                  <li>
                    <p>Poids</p><span>: <%  out.println(unCheval.getPoids()); %></span>
                  </li>
                  <li>
                    <p>Race du cheval</p><span>: <%  out.println(unCheval.getUnTypeCheval().getLibelle()); %></span>
                  </li>
                  <li>
                    <p>Cheval mere</p><span>: <%  out.println(unCheval.getPere().getNom()); %></span>
                  </li>
                  
                  <li>
                    <p>Cheval mere</p><span>: <%  out.println(unCheval.getMere().getNom()); %></span>
                  </li>
                  
                </ul>
              </div>
            </div>
                  <div class="column">
                  <img src="../assets/img/cheval/<% 
                      if(unCheval.getId()== 1 ||unCheval.getId()== 2 ||unCheval.getId()== 3 ||unCheval.getId()== 4 || unCheval.getId()== 5){
                           
                           out.println(unCheval.getId());
                      }else{
                          out.println("cheval_Inconnu");
                      }
                      
                      
                      
                       %>.png" width="500" height="355">
           </div>
          </div>
           <% if (lesParticipations!=null){
               
           %>
           <h4>Liste des courses participé </h4>
            <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>Place de la course</th>
                    <th>Nom Course</th>
                    <th>Lieu</th> 
                    <th>Date</th> 
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesParticipations.size();i++)
                    {
                        
                        Participer uneParticipation = lesParticipations.get(i);
                        out.println("<tr><td>");
                        out.println(uneParticipation.getPlace());
                        out.println("</a></td>");
                        
                         for(int y = 0; y < uneParticipation.getLesCourses().size();y++)
                    {
                        Course uneCourse= uneParticipation.getLesCourses().get(y);
                       
                         out.println("<td>");
                        out.println(uneCourse.getNom());
                        out.println("</td>");
                        
                        
                         out.println("<td>");
                        out.println(uneCourse.getLieu());
                        out.println("</td>");
                         out.println("<td>");
                        out.println(uneCourse.getDate());
                        out.println("</td>");

                      
                    }
                         
         
                    }
                    %>
                   
                </tr>
            </tbody>
        </table>
     
           
               
            <% }}%>
    </body>
</html>
