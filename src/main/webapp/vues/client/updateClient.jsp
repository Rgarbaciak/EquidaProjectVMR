<%-- 
    Document   : ajouterClient
    Created on : 18 août 2021, 18:02:51
    Author     : Zakina
--%>

<%@page import="model.Client"%>
<%@page import="model.CategVente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Pays"%>
<%@page import="forms.FormClient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <title>Equida | Modifier Client</title>
        <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
        <%@include file="../Components/Menu.jsp" %>
         <h2>Modification CLIENT</h2>
        
         <%
                Client unClient=(Client)request.getAttribute("pClient");
                FormClient form = (FormClient)request.getAttribute("form");
                 if(role==1){
                    response.sendRedirect( request.getContextPath() + "/");
                }
            %>
        
        <form class="form-contact contact_form" action="updateClient" method="POST">
            

               
                </br>
                <label for="nom">Nom : </label>
                <input id="nom" type="text" name="nom"  size="30" maxlength="30" value='<%  out.println(unClient.getNom()); %>'>
                </br>
                
                <label for="prenom">Prenom : </label>
                <input id="prenom"  type="text"  name="prenom" size="30" maxlength="30"  value='<%  out.println(unClient.getPrenom()); %>'>      
                 </br>
                
                <label for="rue">Rue : </label>
                <input id="rue"  type="text"  name="rue" size="30" maxlength="50"  value='<%  out.println(unClient.getAdrRue()); %>'>
                 </br>
                               
                
                <label for="copos">Code Postal : </label>
                <input id="copos"  type="text"  name="copos" size="5" maxlength="5"  value='<%  out.println(unClient.getCodePostal()); %>'>
                </br>
                
                <label for="ville">Ville : </label>
                <input id="ville"  type="text"  name="ville" size="40" maxlength="40"  value='<%  out.println(unClient.getVille()); %>'>
                </br>
                
                <label for="mail">Mail : </label>
                <input id="mail"  type="text"  name="mail" size="40" maxlength="40"  value='<%  out.println(unClient.getMail()); %>'>
                </br>
                
                <%-- Champ Liste des pays --%>
                <label for="pays">Pays : </label>
                <select name="codePays">
                    <%
                      
                        ArrayList<Pays> lesPays = (ArrayList)request.getAttribute("pLesPays");
                        for (int i=0; i<lesPays.size();i++){
                            Pays p = lesPays.get(i);
                            if(p.getCode().equals(unClient.getLePays().getCode())){
                                 out.println("<option value='" + p.getCode()+"' selected='"+unClient.getLePays().getNom()+"'>" + p.getNom()+" </option>" );
                            }
                            else{
                                out.println("<option value='" + p.getCode()+"'>" + p.getNom()+" </option>" );
                            }
                            
                           
                        }
                       
                        System.out.println(unClient.getLePays().getNom());
                        

                    %>
                </select>
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
                
                
                
                <%-- Cases à cocher permettant de choisir les différentes catégories de vente auxquelles le client souhaite s'inscrire 
                <label for="categVente">Categories de vente : </label></br>
                 <%
                        ArrayList<CategVente> lesCategVente = (ArrayList)request.getAttribute("pLesCategVente");
                        for (int i=0; i<lesCategVente.size();i++){
                            CategVente cv = lesCategVente.get(i);
                            out.println("<input type='checkbox' id='cb" + i + "' name='" + cv.getCode() + "'>"); 
                            out.println(cv.getLibelle()); 
                            out.println("</label></br>");
                        }
                    %>
                    </br>
                    --%>
                              <input id="idClient" type="hidden" name="idClient"  value='<%  out.println(unClient.getId()); %> ' >   
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
    </body>
</html>
