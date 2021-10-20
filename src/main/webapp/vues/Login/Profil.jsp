<%-- 
    Document   : Connecté
    Created on : 11 oct. 2021, 11:12:51
    Author     : adminsio
--%>
<%@page import="model.Compte"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            
            %>
        <title>Equida | Profil</title>
         <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
        <%@include file="../Components/Menu.jsp" %>

        <table  class="table table-bordered table-striped table-condensed">  
            <h1> ️ Profile 
                <tr>
                <b> Nom d'Utilisateur : ${user} <br><br>
                    Mot de Passe : ${pass} <br><br>
                    Client n° ${client}<br><br>
                </b>
                </tr>
            </tbody>
        </table>
    </body>
</html>
