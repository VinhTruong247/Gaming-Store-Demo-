<%-- 
    Document   : aboutus
    Created on : Mar 9, 2023, 10:08:57 AM
    Author     : Admin
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US" scope="session" />

<div class="about-us">

    <!-- ***** Banner ***** -->    
    <div class="page-heading" id="top">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="inner-content">
                        <h2><span>Our Team</span></h2>
                        <span>The Steam V2.0</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ***** Banner ***** -->

    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="left-image">
                    <img src="<c:url value="/images/team.jpg"/>" alt="">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="right-content">
                    <h4>About Us &amp; Our Skills</h4>
                    <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod kon tempor incididunt ut labore.</span>
                    <div class="quote">
                        <i class="fa fa-quote-left"></i><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiuski smod kon tempor incididunt ut labore.</p>
                    </div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod kon tempor incididunt ut labore et dolore magna aliqua ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip.</p>
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
</div>



<!-- ***** Our Team Area Starts ***** -->
<section class="our-team">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-heading">
                    <h2>Our Amazing Team</h2>
                    <span></span>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="team-item">
                    <div class="thumb">
                        <div class="hover-effect">
                            <div class="inner-content">
                                <ul>
                                    <li><a href="<c:url value="#"/>"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="<c:url value="#"/>"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="<c:url value="#"/>"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="<c:url value="#"/>"><i class="fa fa-github"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <img src="<c:url value="/images/face.jpg"/>" alt="">
                    </div>
                    <div class="down-content">
                        <h4>Zackie</h4>
                        <span>Database Collector</span>
                    </div>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="team-item">
                    <div class="thumb">
                        <div class="hover-effect">
                            <div class="inner-content">
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-github"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <img src="<c:url value="/images/face.jpg"/>" alt="">
                    </div>
                    <div class="down-content">
                        <h4>Tuna The Fish</h4>
                        <span>Database Collector</span>
                    </div>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="team-item">
                    <div class="thumb">
                        <div class="hover-effect">
                            <div class="inner-content">
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-github"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <img src="<c:url value="/images/face.jpg"/>" alt="">
                    </div>
                    <div class="down-content">
                        <h4>Bucket</h4>
                        <span>UX-UI</span>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">            
            <div class="col-lg-4">
                <div class="team-item">
                    <div class="thumb">
                        <div class="hover-effect">
                            <div class="inner-content">
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-github"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <img src="<c:url value="/images/face.jpg"/>" alt="">
                    </div>
                    <div class="down-content">
                        <h4>The Rock</h4>
                        <span>Back-end</span>
                    </div>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="team-item">
                    <div class="thumb">
                        <div class="hover-effect">
                            <div class="inner-content">
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-github"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <img src="<c:url value="/images/face.jpg"/>" alt="">
                    </div>
                    <div class="down-content">
                        <h4>StonkOverFlown</h4>
                        <span>Back-end</span>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>
<!-- ***** Our Team Area Ends ***** -->