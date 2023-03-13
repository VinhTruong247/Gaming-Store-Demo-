<%-- 
    Document   : login
    Created on : Mar 9, 2023, 11:11:23 AM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US" scope="session" />

<h2>Login Page</h2>

<div class="login">
    <div class="container">
        <div class="row">
            
            <div class="col">
            </div>
            
            <div class="col">
                <form action="<c:url value="/user/login_handler.page" />" method="get">
                    <div class="mb-3 mt-3">
                        <label for="loginInput" class="form-label">Email or Username:</label>
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
                <hr/>
                <div style="margin: 30px 0px;">
                    Doesn't have an account? 
                    <a href="<c:url value="/user/signup.page"/>" class="btn btn-outline-primary">Sign Up</a>
                </div>
            </div>
                
            <div class="col">
            </div>
                
        </div>
    </div>
</div>