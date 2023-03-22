<%-- 
    Document   : index
    Created on : Feb 6, 2023, 10:09:20 AM
    Author     : PHT
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US" scope="session" />

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
                        <img src="<c:url value="/images/team_home.jpg"/>" alt="">
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
                                        <h4></h4>
                                        <span></span>
                                    </div>
                                    <div class="hover-content">
                                        <div class="inner">
                                            <h4>Minecraft</h4>
                                            <p>Minecraft is a video game in which players create and break apart various kinds of blocks in three-dimensional...</p>
                                            <div class="main-border-button">
                                                <a href="<c:url value="/product/single_product.page?quantity=1&op=none&productId=41"/>">Buy Now</a>
                                            </div>
                                        </div>
                                    </div>
                                    <img src="<c:url value="/images/game/minecraft.jpg"/>" alt="">
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="right-first-image">
                                <div class="thumb">
                                    <div class="inner-content">
                                        <h4></h4>
                                        <span></span>
                                    </div>
                                    <div class="hover-content">
                                        <div class="inner">
                                            <h4>Hogwarts Legacy</h4>
                                            <p>Hogwarts Legacy is an immersive, open-world action RPG. Now you can take control of the action and be...</p>
                                            <div class="main-border-button">
                                                <a href="<c:url value="/product/single_product.page?quantity=1&op=none&productId=2"/>">Buy Now</a>
                                            </div>
                                        </div>
                                    </div>
                                    <img src="<c:url value="/images/game/hogwart_legacy.jpg"/>" alt="">
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="right-first-image">
                                <div class="thumb">
                                    <div class="inner-content">
                                        <h4></h4>
                                        <span></span>
                                    </div>
                                    <div class="hover-content">
                                        <div class="inner">
                                            <h4>EA SPORTS™ FIFA 23</h4>
                                            <p>FIFA 23 brings The World’s Game to the pitch, with HyperMotion2 Technology, men’s and women’s FIFA World Cup™...</p>
                                            <div class="main-border-button">
                                                <a href="<c:url value="/product/single_product.page?quantity=1&op=none&productId=2"/>">Buy Now</a>
                                            </div>
                                        </div>
                                    </div>
                                    <img src="<c:url value="/images/game/fifa23.jpg"/>" alt="">
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="right-first-image">
                                <div class="thumb">
                                    <div class="inner-content">
                                        <h4></h4>
                                        <span></span>
                                    </div>
                                    <div class="hover-content">
                                        <div class="inner">
                                            <h4>Son Of The Forest</h4>
                                            <p>Sent to find a missing billionaire on a remote island, you find yourself in a cannibal-infested...</p>
                                            <div class="main-border-button">
                                                <a href="<c:url value="/product/single_product.page?quantity=1&op=none&productId=1"/>">Buy Now</a>
                                            </div>
                                        </div>
                                    </div>
                                    <img src="<c:url value="/images/game/son_of_the_forest.jpg"/>" alt="">
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