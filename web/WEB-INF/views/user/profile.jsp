<%-- 
    Document   : profile
    Created on : Mar 14, 2023, 5:40:55 PM
    Author     : binla
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="login">
    <div class="container">
        <div class="row">
            <div class="col">
                <h2>Profile</h2>
            </div>
            <div class="col">
                <form>
                    <div class="mb-3 mt-3">
                        <label for="role" class="form-label">Role: </label>
                        <input disabled="" type="text" class="form-control" id="role" name="role" value="${user.role}">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="username" class="form-label">Username:</label>
                        <input disabled="" type="text" class="form-control" id="username" name="username" value="${user.username}">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="fullName" class="form-label">Full name:</label>
                        <input disabled="" type="text" class="form-control" id="fullName" name="fullName" value="${user.fullName}">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="email" class="form-label">Email:</label>
                        <input disabled="" type="text" class="form-control" id="email" name="email" value="${user.email}">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="password" class="form-label">Password:</label>
                        <input disabled="" type="password" class="form-control" id="password" name="password" value="${user.password}">
                    </div> 
                </form>
                <div>
                    <a href="<c:url value="/user/edit.page"/>" class="btn btn-outline-primary">Edit</a>
                </div>
            </div>
            <div class="col">
            </div>
        </div>
    </div>
</div>