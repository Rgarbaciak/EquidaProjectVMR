<%-- 
    Document   : Menu
    Created on : 3 oct. 2021, 15:18:55
    Author     : zokum
--%>

<%@page import="com.sun.org.apache.xpath.internal.operations.Bool"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <header>
        <!-- Header Start -->
        <div class="header-area">
            <div class="main-header header-sticky">
                <div class="container-fluid">
                    <div class="menu-wrapper">
                        <!-- Logo -->
                        <div class="logo">
                            <a href="/equida/"><img src="../assets/img/logo/logo.png" alt=""></a>
                        </div>
                        <!-- Main-menu -->
                        
                        
                         <%
                            Integer connected = (Integer) session.getAttribute("connected");
                            System.out.println("CONNECTED "+connected);
                            Integer role = (Integer) session.getAttribute("role");
                            System.out.println("ROLE"+ role);
                            if (connected != null && connected == 1) {%>
                           
                            
                        <div class="main-menu d-none d-lg-block">
                            <nav>                                                
                                <ul id="navigation">  
                                    <li><a href="/equida/">Accueil</a></li>
                                    
                                    <li><a href="/equida/ServletCheval/listerLesChevaux">Cheval</a>
                                        <ul class="submenu">
                                            <li><a href="/equida/ServletCheval/listerLesChevaux">Informations cheval</a></li>
                                            <% if(role==2 || role==3) {%>
                                            <li><a href="elements.html">Liste des propositions d'ajouts</a></li>
                                            <%}%>
                                             <% if(role==1 ) {%>
                                            <li><a href="elements.html">Proposer un cheval</a></li>
                                            <%}%>
                                        </ul>
                                    </li>
                                    <li><a href="/equida/ServletVente/listerLesVentes">Vente</a>
                                    <li><a href="/equida/ServletCourse/listerLesCourses">Course</a>
                                       <% if(role==3){ %>
                                    <li><a >Gestion</a>
                                        <ul class="submenu">
                                            <li><a href="/equida/ServletParam/listerLesComptes">Gestion des comptes</a></li>
                                            <li><a href="/equida/ServletCheval/listerLesRaces">Gestion d'une race</a></li>
                                            <li><a href="/equida/ServletParam/listerLesPays">Gestion d'un pays</a></li>
                                            <li><a href="/equida/ServletParam/listerLesLieux">Gestion d'un lieu</a></li> 
                                            <li><a href="/equida/ServletClient/listerLesClients">Gestion d'un Client</a></li>
                                        </ul>
                                    </li>
                                    <%}%> 
                                </ul>
                            </nav>
                        </div>
                        <!-- Header Right -->
                        <div class="header-right">
                            <ul>
                                <li> <a href="/equida/ServletLogin/Profil"><span class="flaticon-user"></span></a></li>
                                <li> <b>${user}</b></li>
                                &nbsp;&nbsp;
                                <li> 
                                    <a href="/equida/ServletLogout/Deconnecter">
                                      <svg xmlns="http://www.w3.org/2000/svg" width="23" height="23" fill="black"  class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
                                            <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                                      </svg>
                                    </a>
                                </li>
                             
                            </ul>
                        </div>
                           <%}else {%>
                                
                             <div class="main-menu d-none d-lg-block">
                                <nav>                                                
                                    <ul id="navigation">  
                                        <li><a href="/equida/">Accueil</a></li>
                                    </ul>
                                    
                                </nav>
                                 
                            </div>
                            <div class="header-right">
                            <ul>
                                <li>
                                        
                                </li>                          
                                <li> <a href="/equida/ServletLogin/Login"><span>Connexion</span></a></li>

                            </ul>
                        </div>
                            <%}%>
                    </div>
                    <!-- Mobile Menu -->
                    <div class="col-12">
                        <div class="mobile_menu d-block d-lg-none"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End -->
    </header>