<%-- 
    Document   : ModifierCheval
    Created on : 13 oct. 2021, 09:48:27
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
       
        <title>Equida</title>
        <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
        <%@include file="../Components/Menu.jsp" %>
         <h2>Modification cheval</h2>
        
         <%
                
                FormCheval form = (FormCheval)request.getAttribute("form");
                Cheval leCheval = (Cheval)request.getAttribute("pLecheval");
            %>
        
        <form class="form-contact contact_form" action="updateCheval" method="post" id="contactForm" novalidate="novalidate">
                <label for="Nom">Nom : </label>
                <input id="Nom" type="text" name="Nom"  size="30" maxlength="30" value="<%  out.println(leCheval.getNom()); %>">
                </br>
                
                <label for="Sexe">Sexe : </label>
                <input id="Sexe"  type="text"  name="Sexe" size="30" maxlength="30" value="<%  out.println(leCheval.getSexe()); %>">      
                 </br>
                
                <label for="Sire">SIRE : </label>
                <input id="Sire"  type="text"  name="Sire" size="30" maxlength="50" value="<%  out.println(leCheval.getSire()); %>">
                 </br>
                               
                
                <label for="DatedeNaissance">Date de Naissance : </label>
                <input id="DateDeNaissance"  type="text"  name="DateDeNaissance" size="10" maxlength="10" value="<%  out.println(leCheval.getDateNaissance()); %>">
                </br>
                
                <label for="Poids">Poids : </label>
                <input id="Poids"  type="text"  name="Poids" size="40" maxlength="40" value="<%  out.println(leCheval.getPoids()); %>">
                </br>
                
                  <label for="TypeCheval">Type de Cheval : </label>
                   
                 <select name="TypeCheval">
                    <%
                        ArrayList<TypeCheval> lesRaces = (ArrayList)request.getAttribute("pLesRaces");
                        for (int i=0; i<lesRaces.size();i++){
                            TypeCheval Typ = lesRaces.get(i);
                            if(Typ.getLibelle().equals(leCheval.getUnTypeCheval().getLibelle())){
                                 out.println("<option value='" + Typ.getId()+"' selected='"+leCheval.getUnTypeCheval().getLibelle()+"'>" + Typ.getLibelle()+" </option>" );
                            }
                            else{ 
                            out.println("<option value='" + Typ.getId()+"'>" + Typ.getLibelle()+"</option>" );
                            }
                        }
                    %>
                </select>
                </br>
                
                <label for="pere">père du cheval : </label>
                <select name="pere">
                    <%
                        ArrayList<Cheval> lesPeres = (ArrayList)request.getAttribute("pLesPeres");
                        for (int i=0; i<lesPeres.size();i++){
                            Cheval chevalPere = lesPeres.get(i);
                            if(chevalPere.getId()==(leCheval.getPere().getId())){
                                
                                 out.println("<option value='" + chevalPere.getId()+ "'selected='"+leCheval.getPere().getNom()+"'>" + chevalPere.getId()+ "  "+ chevalPere.getNom()+"</option>" );
                            }
                            else{
                            out.println("<option value='" + chevalPere.getId()+"'>" + chevalPere.getId()+ "  "+ chevalPere.getNom()+"</option>" );
                            }
                        }
                    %>
                </select>
                </br>
                
                <label for="mere">mère du cheval : </label>
               
                <select name="mere">
                    <%
                        ArrayList<Cheval> lesMeres = (ArrayList)request.getAttribute("pLesMeres");
                        for (int i=0; i<lesMeres.size();i++){
                            Cheval chevalMere = lesMeres.get(i);
                            if(chevalMere.getId()==(leCheval.getMere().getId())){
                                
                                 out.println("<option value='" + chevalMere.getId()+ "'selected='"+leCheval.getMere().getNom()+"'>" + chevalMere.getId()+ "  "+ chevalMere.getNom()+"</option>" );
                            }
                            else{
                            out.println("<option value='" + chevalMere.getId()+"'>" + chevalMere.getId()+ "  "+ chevalMere.getNom()+"</option>" );
                            }
                        }
                    %>
                </select>
                </br>     
            <input id="che_id" type="hidden" name="che_id"  value='<%  out.println(leCheval.getId()); %> ' > 
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
    </body>
</html>
