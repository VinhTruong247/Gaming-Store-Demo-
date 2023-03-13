<%-- 
    Document   : main.jsp
    Created on : Mar 1, 2023, 11:58:16 AM
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Steam V2.0</title>

        <!-- Latest compiled and minified CSS -->

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

        <!-- Latest compiled JavaScript -->

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <link href="<c:url value="/css/site.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/product.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/font.css" />" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>

        <header class="header-area header-sticky">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <nav class="main-nav">

                            <!-- ***** Logo Start ***** -->

                            <a href="<c:url value="/"/>" class="logo">
                                <img src="<c:url value="/images/logo.png"/>">
                            </a>

                            <!-- ***** Logo End ***** -->
                            <c:if test="${sessionScope.user!=null}">
                                <li class="scroll-to-section">Welcome ${user.fullName}</li>
                                </c:if>
                            <!-- ***** Menu Start ***** -->
                            <ul class="nav">
                                <li class="scroll-to-section"><a href="<c:url value="/"/>">Home</a></li>
                                <li class="scroll-to-section"><a href="<c:url value="/home/aboutus.page"/>">About Us</a></li>
                                <li class="submenu">
                                    <a href="<c:url value="/product/page_1.page"/>">Games</a>
                                    <ul>
                                        <li><a href="<c:url value="/product/page_1"/>">Features Page</a></li>
                                        <li><a href="<c:url value="#"/>">Game List</a></li>
                                            <c:if test="${sessionScope.user!=null && sessionScope.user.role=='ADMIN'}">
                                                <li><a href="<c:url value="/product/manager.page"/>">Product Manager</a></li>
                                            </c:if>
                                    </ul>
                                </li>
                                <c:if test="${sessionScope.user==null}">
                                    <li class="scroll-to-section"><a href="<c:url value="/user/login.page"/>">Login</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.user!=null}">
                                    <li class="scroll-to-section"><a href="<c:url value="/user/logout.page"/>">Logout</a></li>
                                    </c:if>
                            </ul>        
                            <a class='menu-trigger'>
                                <span>Menu</span>
                            </a>
                            <!-- ***** Menu End ***** -->
                        </nav>
                    </div>
                </div>
            </div>
        </header>            


        <!-- ***** Detail ***** -->                    
        <div class="detail">
            <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />                        
        </div>                    
        <!-- ***** Detail ***** -->


        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="first-item">
                            <div class="logo">
                                <img src="<c:url value="/images/logo.png"/>" alt="">
                            </div>
                            <ul>
                                <li><a href="#">69 Vo Thi Sau, P.Vo Thi Sau, Quan 3, TP.HCM</a></li>
                                <li><a href="#">steamv2@shop.com</a></li>
                                <li><a href="#">012-345-6789</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <h4>Games &amp; Categories</h4>
                        <ul>
                            <li><a href="#">Feature Page 1</a></li>
                            <li><a href="#">Feature Page 2</a></li>
                            <li><a href="#">Feature Page 3</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-3">
                        <h4>Useful Links</h4>
                        <ul>
                            <li><a href="<c:url value="/" />">Home</a></li>
                            <li><a href="<c:url value="/home/aboutus.page" />">About Us</a></li>
                            <li><a href="<c:url value="#" />">Help</a></li>
                            <li><a href="<c:url value="#" />">Contact Us</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-3">
                        <h4>Help &amp; Information</h4>
                        <ul>
                            <li><a href="#">Help</a></li>
                            <li><a href="#">FAQ's</a></li>
                            <li><a href="#">Member</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-12">
                        <div class="under-footer">
                            <p>Copyright © 2023 Steam V2.0, Ltd. All Rights Reserved. 

                                <br>Design: <a href="<c:url value="/home/aboutus.page"/>">SteamV2.0 Team</a>

                                <br>Distributed By: <a href="<c:url value="/home/aboutus.page"/>">SteamV2.0 Team</a></p>
                            <ul>
                                <li><a href="<c:url value="#"/>"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="<c:url value="#"/>"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="<c:url value="#"/>"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="<c:url value="#"/>"><i class="fa fa-github"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
