<%-- 
    Document   : cart
    Created on : Mar 13, 2023, 9:04:18 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US" scope="session" />

<h2>Cart Page</h2>

<div class="cart">
    <div class="container">
        <div class="row">

            <table class="table table-striped">
                <thead>

                    <tr>
                        <th>No.</th>
                        <th>Images</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th></th>
                    </tr>

                </thead>
                <c:forEach var="item" items="${sessionScope.cart.item}" varStatus="loop">
                    <form action="/GamingWebsite/cart">
                        <tr>
                            <td>${loop.count}</td>
                            <td style="width: 220px;"><img src="<c:url value="${item.product.productImages}"/>" style="width:100%; height:100%" alt=""></td>
                            <td>${item.product.productName}</td>
                            <td><input type="number" name="addQuantity" min ="1" max="${item.product.quantity}" step="1" required value="${item.quantity}"
                                       <h4>Left in stock: <fmt:parseNumber value="${item.product.quantity}"/></h4>
                            </td>
                            <td><fmt:formatNumber value="${item.product.price}" type="number"/>&#8363;</td>
                            <td>
                                <input type="hidden" name="productId" value="${item.product.productId}">
                                <button type="submit" name="op" value="update">Update</button>
                                <button type="submit" name="op" value="delete">Delete</button>
                            </td>
                        </tr>
                    </form>

                </c:forEach>
                <td colspan = "6"><c:if test="${count==0}"><h1 style="text-align: center;">Go get some games now!</h1></c:if></td>
                </tbody>
            </table>
        </div>

        <div class="row">
            <div class="col-lg-4">
                <c:if test="${count==0}">
                    <a href="<c:url value="/product/page.page?currentPage=1"/>" class="btn btn-outline-primary">Go get more games!</a>
                </c:if>     
                <c:if test="${count>0}">
                    <a href="<c:url value="/payment/checkout.page"/>" class="btn btn-outline-primary">Go to checkout</a>
                </c:if>            
            </div>
            <div class="col-lg-4">
                <form action="/GamingWebsite/cart">
                    <button type="submit" name="op" value="empty">Empty Cart</button>
                </form> 
            </div>
            <div class="col-lg-4">
                <h4>Total: <fmt:formatNumber value="${total}" type="number"/>&#8363;</h4>
            </div>
        </div>

    </div>
</div>