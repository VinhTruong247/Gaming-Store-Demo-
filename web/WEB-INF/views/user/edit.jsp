<%-- 
    Document   : profile
    Created on : Mar 14, 2023, 5:40:55 PM
    Author     : binla
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="edit">
    <div class="container">
        <div class="row">
            <div class="col">
                <h2>Edit Your Profile</h2>
            </div>
            <div class="col">
                <form action="<c:url value="/user/edit_handler.page" />" method="get">
                    <div class="mb-3 mt-3">
                        <label for="username" class="form-label">Username:</label>
                        <input type="text" class="form-control" id="username" name="username" required value="${user.username}">
                    </div>
                    <div class="mb-3">
                        <label for="fullName" class="form-label">Full name:</label>
                        <input type="text" class="form-control" id="fullName" name="fullName" required value="${user.fullName}">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email:</label>
                        <input type="email" class="form-control" id="email" name="email" required value="${user.email}">
                    </div>
                    <input type="hidden" name="password" value="${user.password}">
                    <input type="hidden" name="id" value="${user.userId}">
                    <input type="hidden" name="role" value="${user.role}">
                    <button type="submit" class="btn btn-outline-success" name="op" value="apply"><i class="bi bi-check-lg"></i> Apply</button>
                    <button type="submit" class="btn btn-outline-danger" name="op" value="cancel"><i class="bi bi-x-lg"></i> Cancel</button>
                </form>
                <i style="color:red;">${message}</i>
            </div>
            <div class="col">
            </div>
        </div>
    </div>
</div>