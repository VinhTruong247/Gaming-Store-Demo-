<%-- 
    Document   : cart
    Created on : Mar 13, 2023, 9:04:18 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US" scope="session" />

<h2>Cart Page</h2>

<div class="checkout">
    <div class="container">
        <div class="row">
            <a href="<c:url value="/payment/checkout.page"/>" class="btn btn-outline-primary">Go to checkout</a>
        </div>
    </div>
</div>