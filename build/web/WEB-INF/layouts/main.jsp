<%-- 
    Document   : main
    Created on : Feb 20, 2023, 9:37:53 PM
    Author     : VU HONG ANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TestPage</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="<c:url value="/css/site.css" />" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row header">
                <div class="col">
                    <h1 class="title">insertBrandNameHere</h1>
                    <a href="<c:url value="/" />">Home</a> |
                    <a href="<c:url value="/product/index.page" />">Product</a> |
                    <a href="<c:url value="/" />">Discount</a> |
                    <a href="<c:url value="/home/aboutus.page" />">About Us</a> 
                    <span style="float:right;">
                        <c:if test="${sessionScope.user==null}">
                            <a href="<c:url value="/user/login.page" />">Login</a>
                        </c:if>
                        <c:if test="${sessionScope.user!=null}">
                            Welcome ${sessionScope.user.username} | 
                            <a href="<c:url value="/user/logout.page" />">Logout</a>
                        </c:if> |
                            <a href="<c:url value="/user/userlist.page" />">User List</a>|
                            <a href="<c:url value="/product/purchase.page"/>">Test-Purchase</a>
                    </span>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
                </div>
            </div>
            <div class="row footer">
                <div class="col">
                    Copyright &copy; by TeamForge. All rights reserved.
                </div>
            </div>
        </div>
    </body>
</html>
