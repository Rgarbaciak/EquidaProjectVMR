<%-- 
    Document   : AjouterCheval
    Created on : 11 oct. 2021, 10:47:07
    Author     : adminsio
--%>

<%@page import="model.TypeCheval"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cheval"%>
<%@page import="forms.FormCheval"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <title>Equida | Ajouter Cheval</title>
        <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
        <%@include file="../Components/Menu.jsp" %>
         <h2>NOUVEAU CHEVAL</h2>
        
         <%
                //Client client=(Client)request.getAttribute("client");
                FormCheval form = (FormCheval)request.getAttribute("form");
                 if(role==1){
                    response.sendRedirect( request.getContextPath() + "/");
                }
            %>
        
        <form class="form-contact contact_form" action="AjouterCheval" method="post" id="contactForm" novalidate="novalidate">
                <label for="Nom">Nom : </label>
                <input id="Nom" type="text" name="Nom"  size="30" maxlength="30" >
                </br>
                
                <label for="Sexe">Sexe : </label>
                <input id="Sexe"  type="text"  name="Sexe" size="30" maxlength="30">      
                 </br>
                
                <label for="Sire">SIRE : </label>
                <input id="Sire"  type="text"  name="Sire" size="30" maxlength="50">
                 </br>
                               
                
                <label for="DatedeNaissance">Date de Naissance : </label>
                <input id="DateDeNaissance"  type="text"  name="DateDeNaissance" size="10" maxlength="10">
                </br>
                
                <label for="Poids">Poids : </label>
                <input id="Poids"  type="text"  name="Poids" size="40" maxlength="40">
                </br>
                
                  <label for="TypeCheval">Type de Cheval : </label>
                <select name="TypeCheval">
                    <%
                        ArrayList<TypeCheval> lesRaces = (ArrayList)request.getAttribute("pLesRaces");
                        for (int i=0; i<lesRaces.size();i++){
                            TypeCheval Typ = lesRaces.get(i);
                            out.println("<option value='" + Typ.getId()+"'>" + Typ.getLibelle()+"</option>" );
                        }
                    %>
                </select>
                </br>
                
                <label for="pere">père du cheval : </label>
                <select name="pere">
                    <%
                        ArrayList<Cheval> lesNoms = (ArrayList)request.getAttribute("pLesNoms");
                        for (int i=0; i<lesNoms.size();i++){
                            Cheval nom = lesNoms.get(i);
                            out.println("<option value='" + nom.getId()+"'>" + nom.getId()+ "  "+ nom.getNom()+"</option>" );
                        }
                    %>
                </select>
                </br>
                
                <label for="mere">mère du cheval : </label>
                <select name="mere">
                    <%
                        ArrayList<Cheval> lesNoms2 = (ArrayList)request.getAttribute("pLesNoms2");
                        for (int i=0; i<lesNoms2.size();i++){
                            Cheval nom2 = lesNoms2.get(i);
                            out.println("<option value='" + nom2.getId()+"'>" + nom2.getId()+ "  "+ nom2.getNom()+"</option>" );
                        }
                    %>
                </select>
                </br>     
             
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
    </body>
</html>
