<%-- 
    Document   : sale
    Created on : Mar 20, 2023, 8:31:39 AM
    Author     : Admin
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
                            <th>No.</th>
                            <th>Product ID</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Price</th> 

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${list}" varStatus="loop">
                            <c:if test="${loop.count == 1}">
                                <c:set var = "profit" scope = "session" value = "${total}"/>
                            </c:if>
                            <tr>
                                <td>${loop.count}</td>
                                <td>${product.productId}</td>
                                <td>${product.productName}</td>
                                <td>
                                    <c:set var = "sold" scope = "session" value = "${100-product.quantity}"/>
                                    <fmt:formatNumber value="${sold}" type="number"/>
                                </td>
                                <td>
                                    <c:set var = "total" scope = "session" value = "${sold*product.price}"/>
                                    <fmt:formatNumber value="${total}" type="number"/>
                                </td>
                                <td>

                                    <a href="<c:url value="/product/update.page?productId=${product.productId}" />">Update</a> |
                                    <a href="<c:url value="/product/delete.page?productId=${product.productId}" />">Delete</a>

                                </td>
                                <c:set var = "profit" scope = "session" value = "${profit+total}"/>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                Total profit: <fmt:formatNumber value="${profit}" type="number"/>
            </div>
        </c:if>
    </div>
</div>