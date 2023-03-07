<%-- 
    Document   : userlist
    Created on : Mar 3, 2023, 4:24:30 PM
    Author     : binla
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi-VN" scope="session" />
<h2>User List</h2>
<table class="table table-striped">
    <thead>
        <tr>
            <th>Role</th>
            <th>ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Email</th>
            <th>Full Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${list}" varStatus="loop">
            <tr>
                <td>${user.role}</td>
                <td>${user.userId}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.fullName}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>