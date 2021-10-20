<%-- 
    Document   : AjouterCheval
    Created on : 11 oct. 2021, 10:47:07
    Author     : adminsio
--%>

<%@page import="forms.FormPara"%>
<%@page import="model.TypeCheval"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cheval"%>
<%@page import="forms.FormCheval"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <title>Equida | Ajouter Race</title>
        <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
        <%@include file="../Components/Menu.jsp" %>
         <h2>Nouvelle Race</h2>
        
         <%
                //Client client=(Client)request.getAttribute("client");
                FormPara form = (FormPara)request.getAttribute("form");
                 if(role==1){
                    response.sendRedirect( request.getContextPath() + "/");
                }
            %>
        
        <form class="form-contact contact_form " action="ajouterRace" method="post" id="contactForm" novalidate="novalidate">
          
            <div class="column">
                <label for="c">Libelle : </label>
                <input id="libelle" type="text" name="libelle"  size="30" maxlength="30" >
                </br>
                 <div class="row">
                <label for="description">Description : </label>

                 <textarea class="textarea" id="description"  name="description" rows="4" cols="25" ></textarea> 
                 </div>
                 
             
            <input type="submit" name="valider" id="valider" value="Valider"/>

            </br>

            </form>
    </body>
</html>
