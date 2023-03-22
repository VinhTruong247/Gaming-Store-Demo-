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
                    <form action="<c:url value="/manager/index.page"/>">
                        <input type="text" class="form-control" id="searchPhrase" name="searchPhrase" placeholder="Find user..." value="${searchPhrase}">  
                    </form>
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
                            <c:forEach var="user" items="${list}" varStatus="loop">
                                <tr>
                                    <td>${user.role}</td>
                                    <td>${user.username}</td>
                                    <td>${user.email}</td>
                                    <td>${user.fullName}</td>
                                    <td>${user.address}</td>
                                    <td>${user.active}</td>
                                    <td>
                                        <a href="<c:url value="/manager/promote.page?username=${user.username}&" />">Promote</a>|
                                        <a href="<c:url value="/manager/deactivate.page?username=${user.username}" />">Deactivate</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
            <c:if test="${isTrue==false}">${message}</c:if>
        </c:if>
    </div>
</div>
