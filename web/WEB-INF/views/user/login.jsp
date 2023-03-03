<%-- 
    Document   : login
    Created on : Mar 3, 2023, 3:28:13 PM
    Author     : binla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Login Form</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/user/login_handler.page" />" method="get">
            <div class="mb-3 mt-3">
                <label for="" class="form-label">Email or Username:</label>
                <input type="text" class="form-control" id="loginInput" name="loginInput" placeholder="Enter your email or username here" value="">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Enter your password here" name="password" value="">
            </div>            
            <button type="submit" class="btn btn-outline-success" name="op" value="login"><i class="bi bi-check-lg"></i> Login</button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel"><i class="bi bi-x-lg"></i> Cancel</button>
        </form>
        <i style="color:red;">${message}</i>
    </div>
    <div class="col">
        
    </div>
</div>
