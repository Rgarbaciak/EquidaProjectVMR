<%-- 
    Document   : consulterClient
    Created on : 19 août 2021, 15:17:27
    Author     : Zakina
--%>

<%@page import="model.Pays"%>
<%@page import="model.CategVente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="forms.FormClient"%>
<%@page import="model.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Equida</title>
        <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
         <%@include file="../Components/Menu.jsp" %>

        <!-- Hero Area Start-->
    
         <%
                //Client client=(Client)request.getAttribute("client");
                FormClient form = (FormClient)request.getAttribute("form");

            %>
        <div class="slider-area ">
            <div class="single-slider slider-height2 d-flex align-items-center">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>↓ Inscription ↓</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       <section class="confirmation_part">
         <form class="form-contact contact_form" action="ajouterClient" method="POST">
              
                  <div class="row">
              <div class="col-lg-6 col-lx-4">
             
             <h4> Informations pour vous connecter</h4>
              <label for="login" style="display:block; float:left;width:150px">Identifiant : </label>
                <input id="login" type="text" name="login"  size="30" maxlength="30" >
                </br>
                </br>
                 <label for="mdp" style="display:block; float:left;width:150px">Mot de passe : </label>
                <input id="mdp" type="password" name="mdp"  size="30" maxlength="30">
                </br>
                </br>
                 <label for="mdpvérif" style="display:block; float:left;width:150px">Vérification mot de passe : </label>
                <input id="mdpvérif" type="password" name="mdpvérif"  size="30" maxlength="30">
                </br>
                </br>
                
            
              </div>
             
            
               <div class="col-lg-6 col-lx-4">
            
             <h4> Informations sur vous</h4>
             <div class="col">
                <label for="nom">Nom : </label>
                <input id="nom" type="text" name="nom"  size="30" maxlength="30">
                </br>
                </br>
                
                <label for="prenom">Prenom : </label>
                <input id="prenom"  type="text"  name="prenom" size="30" maxlength="30">      
                 </br>
                 </br>
                
                <label for="rue">Rue : </label>
                <input id="rue"  type="text"  name="rue" size="30" maxlength="50">
                 </br>
                 </br>
                               
                
                <label for="copos">Code Postal : </label>
                <input id="copos"  type="text"  name="copos" size="5" maxlength="5">
                </br>
                </br>
                
                <label for="ville">Ville : </label>
                <input id="ville"  type="text"  name="ville" size="40" maxlength="40">
                </br>
                </br>
                
                <label for="mail">Mail : </label>
                <input id="mail"  type="text"  name="mail" size="40" maxlength="40">
                </br>
                </br>
                
                <%-- Champ Liste des pays --%>
                <label for="pays">Pays : </label>
                <select name="codePays">
                    <%
                        ArrayList<Pays> lesPays = (ArrayList)request.getAttribute("pLesPays");
                        for (int i=0; i<lesPays.size();i++){
                            Pays p = lesPays.get(i);
                            out.println("<option value='" + p.getCode()+"'>" + p.getNom()+"</option>" );
                        }
                    %>
                </select>
                </br>   
                </br>
                
                <label for="categVente">Categorie Vente : </label>
                <select name="categVente" size="5" multiple>
                <%
                        ArrayList<CategVente> lesCategVente = (ArrayList)request.getAttribute("pLesCategVente");
                        for (int i=0; i<lesCategVente.size();i++){
                            CategVente cv = lesCategVente.get(i);
                            out.println("<option value ='" + cv.getCode() + "'>" + cv.getLibelle() + "</option>"); 
                           
                        }
                    %>
                </select></br>
                </br>
                
                               
                

                                
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </div>
             
             </div>
            </form>
                    
             
        
    </body>
</html>
