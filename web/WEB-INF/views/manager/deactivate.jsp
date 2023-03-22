<%-- 
    Document   : index
    Created on : Feb 21, 2023, 10:22:50 AM
    Author     : VU HONG ANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US" scope="session" />
<h2>Product Management</h2>

<div class="manager">
    <div class="container">
        <c:if test="${sessionScope.user==null}">
            <c:redirect url="/user/login.page"/>
        </c:if>
        <c:if test="${sessionScope.user!=null && sessionScope.user.role=='CUSTOMER'}">
            <c:redirect url="/home/index.page"/>
        </c:if>
        <c:if test="${sessionScope.user!=null && sessionScope.user.role=='ADMIN'}">
            <c:if test="${isTrue==true}">
                <div class="row">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Role</th>
                                <th>Username</th>
                                <th>Email</th>
                                <th>Fullname</th>
                                <th>Address</th>
                                <th>Active</th>
                                <th>Options</th> 

                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${selectedUser.role}</td>
                                <td>${selectedUser.username}</td>
                                <td>${selectedUser.email}</td>
                                <td>${selectedUser.fullName}</td>
                                <td>${selectedUser.address}</td>
                                <td>${selectedUser.active}</td>
                            </tr>
                        </tbody>
                    </table>
                    <form action="<c:url value="/manager/deactivate_handler.page" />">
                        <p>Do you want to deactivate this user now?</p>
                        <input type="hidden" name="userId" value="${selectedUser.userId}">
                        <button type="submit" class="btn btn-outline-success" name="op" value="deactivate"><i class="bi bi-check-lg"></i> Deactivate</button>
                        <button type="submit" class="btn btn-outline-danger" name="op" value="cancel"><i class="bi bi-x-lg"></i> Cancel</button>
                    </form>
                </div>
            </c:if>
            <c:if test="${isTrue==false}">
                ${message}
                <p><a href="<c:url value="/manager/index.page"/>"><i class="bi bi-chevron-compact-left"></i> Go back</a></p>
            </c:if>
        </c:if>
    </div>
</div>
