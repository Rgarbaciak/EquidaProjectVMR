<%-- 
    Document   : Login
    Created on : 6 oct. 2021, 10:06:21
    Author     : adminsio
--%>

<%@page import="forms.FormLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html >
<head>

    <title>Equida | Connexion</title>
           <%@include file="../Components/Head.jsp" %>
        <%@include file="../Components/CSS.jsp" %>


</head>
<body>
     <%@include file="../Components/Menu.jsp" %>
  
            <%
                //Client client=(Client)request.getAttribute("client");
                FormLogin form = (FormLogin)request.getAttribute("form");
                int msg = (Integer) request.getAttribute("msg");
            %>
    
    <main>
        <!-- Hero Area Start-->
        <div class="slider-area ">
            <div class="single-slider slider-height2 d-flex align-items-center">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>↓ Connexion ↓</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero Area End-->
        <!--================login_part Area =================-->
        <section class="login_part section_padding ">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_text text-center">
                            <div class="login_part_text_iner">
                                <h2>Nouveau sur notre Site ?</h2>
                                <p>Le Business commence maintenant ?!</p>
                                 <a href="/equida/ServletClient/ajouterCompte" class="btn_3">Créer un compte</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_form">
                            <div class="login_part_form_iner">
                                <h3>Rebonjour ! <br>
                                    Connecte toi dès maintenant !</h3>
                                
                                <h5><div id="error">
                                        <% if ( msg == 0) {
                                            
                                           }
                                           else if (msg == 1) {%>
                                           
                                           Les Informations renseignèes correspondent à aucun utilisateur enregistrés.
                                           <%}%>
                                </div></h5><br>
                                <style> 
                                    #error
                                    {
                                     text-align: center;
                                     color: red;
                                    }
                                </style>
                                
                                 <form class="row contact_form" action="Login" method="post" novalidate="novalidate">
                                    <div class="col-md-12 form-group p_star">
                                        <input type="text" required class="form-control" id="name" name="user" value=""
                                               placeholder="Utilisateur" required>
                                    </div>
                                    <div class="col-md-12 form-group p_star">
                                        <input type="password" required class="form-control" id="password" name="pass" value=""
                                            placeholder="Mot de Passe">
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <!--<div class="creat_account d-flex align-items-center">
                                            <input type="checkbox" id="f-option" name="selector">
                                            <label for="f-option">Se Souvenir</label>
                                        </div> -->
                                        <button type="submit" value="submit" class="btn_3">
                                            Connexion
                                        </button>
                                        <a class="lost_pass" href="#">Mot de Passe Oubliés ?</a>
                                    </div>
                                </form>
                               
                                
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================login_part end =================-->
    </main>
    
    <!--? Search model Begin -->
    <div class="search-model-box">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-btn">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Searching key.....">
            </form>
        </div>
    </div>
    <!-- Search model end -->
    
    <!-- JS here -->

    <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
    <!-- Jquery, Popper, Bootstrap -->
    <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- Jquery Mobile Menu -->
    <script src="./assets/js/jquery.slicknav.min.js"></script>

    <!-- Jquery Slick , Owl-Carousel Plugins -->
    <script src="./assets/js/owl.carousel.min.js"></script>
    <script src="./assets/js/slick.min.js"></script>

    <!-- One Page, Animated-HeadLin -->
    <script src="./assets/js/wow.min.js"></script>
    <script src="./assets/js/animated.headline.js"></script>
    
    <!-- Scroll up, nice-select, sticky -->
    <script src="./assets/js/jquery.scrollUp.min.js"></script>
    <script src="./assets/js/jquery.nice-select.min.js"></script>
    <script src="./assets/js/jquery.sticky.js"></script>
    <script src="./assets/js/jquery.magnific-popup.js"></script>

    <!-- contact js -->
    <script src="./assets/js/contact.js"></script>
    <script src="./assets/js/jquery.form.js"></script>
    <script src="./assets/js/jquery.validate.min.js"></script>
    <script src="./assets/js/mail-script.js"></script>
    <script src="./assets/js/jquery.ajaxchimp.min.js"></script>
    
    <!-- Jquery Plugins, main Jquery -->	
    <script src="./assets/js/plugins.js"></script>
    <script src="./assets/js/main.js"></script>

</body>
    
</html>