<%-- 
    Document   : success
    Created on : Mar 16, 2023, 7:17:59 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            </div>
        </div>
    </div>
</div>