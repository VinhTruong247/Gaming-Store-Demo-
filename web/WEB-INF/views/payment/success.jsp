<%-- 
    Document   : success
    Created on : Mar 16, 2023, 7:17:59 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<fmt:setLocale value="en-US" scope="session" />

<div class="success">
    <div class="container">
        <c:if test="${sessionScope.user==null}">
            <c:redirect url="/payment/cart.page"/>
        </c:if>
        <div class="row">
            <div class="card">
                <div style="border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;">
                    <i class="checkmark">✓</i>
                </div>
                <h1>Success</h1> 
                <p>We received your purchase request!<br/> We'll be in touch shortly!</p>
                <a href="<c:url value="/home/index.page"/>" class="btn btn-outline-primary">Back to Home Page</a>
            </div>
        </div>
    </div>
</div>