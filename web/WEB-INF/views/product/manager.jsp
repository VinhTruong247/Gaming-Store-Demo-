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
            <div class="row">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Product ID</th>
                            <th>Name</th>
                            <th>Publisher</th>
                            <th>Category</th>
                            <th>Price</th>

                            <th>Options</th> 

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${list}" varStatus="loop">
                            <tr>
                                <td>${product.productId}</td>
                                <td>${product.productName}</td>
                                <td>${product.productPublisher}</td>
                                <td>${product.category}</td>
                                <td>
                                    <fmt:formatNumber value="${product.price}" type="currency" />
                                </td>
                                <td>

                                    <a href="<c:url value="/product/update.page?productId=${product.productId}" />">Update</a> |
                                    <a href="<c:url value="/product/delete.page?productId=${product.productId}" />">Delete</a>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
