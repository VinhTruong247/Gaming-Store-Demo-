<%-- 
    Document   : index
    Created on : Feb 6, 2023, 10:09:20 AM
    Author     : PHT
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US" scope="session" />

<h2>Home Page</h2>

<!-- ***** Feature Area Start ***** -->
<div class="main-banner" id="top">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
                <div class="left-content">
                    <div class="thumb">
                        <div class="inner-content">
                            <h4>Steam V2.0</h4>
                            <span>We are more steamer than the original!</span>
                            <div class="main-border-button">
                                <a href="<c:url value="/home/aboutus.page"/>">Find out more</a>
                            </div>
                        </div>
                        <img src="<c:url value="/images/out.jpg"/>" alt="">
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="right-content">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="right-first-image">
                                <div class="thumb">
                                    <div class="inner-content">
                                        <h4>Best Seller #1</h4>
                                        <span></span>
                                    </div>
                                    <div class="hover-content">
                                        <div class="inner">
                                            <h4>Best Seller #1</h4>
                                            <p>Lorem ipsum dolor sit amet, conservisii ctetur adipiscing elit incid.</p>
                                            <div class="main-border-button">
                                                <a href="<c:url value="#"/>">Buy Now</a>
                                            </div>
                                        </div>
                                    </div>
                                    <img src="<c:url value="/images/out1.jpg"/>" alt="">
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="right-first-image">
                                <div class="thumb">
                                    <div class="inner-content">
                                        <h4>Best Seller #2</h4>
                                        <span></span>
                                    </div>
                                    <div class="hover-content">
                                        <div class="inner">
                                            <h4>Best Seller #2</h4>
                                            <p>Lorem ipsum dolor sit amet, conservisii ctetur adipiscing elit incid.</p>
                                            <div class="main-border-button">
                                                <a href="<c:url value="#"/>">Buy Now</a>
                                            </div>
                                        </div>
                                    </div>
                                    <img src="<c:url value="/images/out1.jpg"/>" alt="">
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="right-first-image">
                                <div class="thumb">
                                    <div class="inner-content">
                                        <h4>Best Seller #3</h4>
                                        <span></span>
                                    </div>
                                    <div class="hover-content">
                                        <div class="inner">
                                            <h4>Best Seller #3</h4>
                                            <p>Lorem ipsum dolor sit amet, conservisii ctetur adipiscing elit incid.</p>
                                            <div class="main-border-button">
                                                <a href="<c:url value="#"/>">Buy Now</a>
                                            </div>
                                        </div>
                                    </div>
                                    <img src="<c:url value="/images/out1.jpg"/>" alt="">
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="right-first-image">
                                <div class="thumb">
                                    <div class="inner-content">
                                        <h4>Best Seller #4</h4>
                                        <span></span>
                                    </div>
                                    <div class="hover-content">
                                        <div class="inner">
                                            <h4>Best Seller #4</h4>
                                            <p>Lorem ipsum dolor sit amet, conservisii ctetur adipiscing elit incid.</p>
                                            <div class="main-border-button">
                                                <a href="<c:url value="#"/>">aBuy Now</a>
                                            </div>
                                        </div>
                                    </div>
                                    <img src="<c:url value="/images/out1.jpg"/>" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ***** Feature Area End ***** -->
