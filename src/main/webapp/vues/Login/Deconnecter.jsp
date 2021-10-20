<%-- 
    Document   : Deconnecté
    Created on : 11 oct. 2021, 11:12:51
    Author     : adminsio
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Equida | Deconnecter</title>
        <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>
    </head>
    <body>
        <%@include file="../Components/Menu.jsp" %>

        <table  class="table table-bordered table-striped table-condensed">  
            <h1> ️ <h1>
                <tr>
                <p><b> Vous avez été déconnecté avec succés !!</b><p>
                    <a href="/equida/"> Revenir à l'Accueil</a>
                </tr>
                
                <style>
                    p{
                        text-align: center;
                    }
                </style>
            </tbody>
        </table>
    </body>
</html>
