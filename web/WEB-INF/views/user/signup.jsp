<%-- 
    Document   : signup
    Created on : Mar 7, 2023, 11:31:28 AM
    Author     : binla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Sign Up</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/user/signup_handler.page" />" method="get">
            <input type="hidden" name="role" value="CUSTOMER">
            <div class="mb-3 mt-3">
                <label for="fullName" class="form-label">Full Name:</label>
                <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Enter your full name here" value="">
            </div>
            <div class="mb-3">
                <label for="username" class="form-label">Username:</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username here" value="">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email here" value="">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password here" value="">
            </div>
            <button type="submit" class="btn btn-outline-success" name="op" value="signup"><i class="bi bi-check-lg"></i> Sign Up</button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel"><i class="bi bi-x-lg"></i> Cancel</button>
        </form>
        <hr/>
        Have an account? 
        <a href="<c:url value="/user/login.page"/>" class="btn btn-outline-primary">Login</a>
        <i style="color:red;">${message}</i>
    </div>
</div>