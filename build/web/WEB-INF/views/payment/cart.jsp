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

<div class="checkout">
    <div class="container">
        <div class="row">

            <table class="table table-striped">
                <thead>

                    <tr>
                        <th>No.</th>
                        <th>Images</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Total Price</th>
                        <th>Quantity</th>
                        <th></th>
                    </tr>

                </thead>
                <c:forEach var="item" items="${sessionScope.cart.item}" varStatus="loop">
                    <form action="/lonmePRJ/cart">
                        <tr>
                            <td>${loop.count}</td>
                            <td style="width: 220px;"><img src="<c:url value="${item.product.productImages}"/>" style="width:100%; height:100%" alt=""></td>
                            <td>${item.product.productName}</td>
                            <td>${item.product.price}</td>
                            <td>${item.cost}</td>
                            <td><input type="number" name="addQuantity" value="${item.addQuantity}" style="width: 30%;" /></td>
                            <td>
                                <a href="<c:url value="/cart?productId=${item.product.productId}&op=delete"/>"><i class="bi bi-x-lg"></i></a>
                            </td>
                        </tr>
                    </form>
                    </c:forEach>
                </tbody>
            </table>

        </div>

        <a href="<c:url value="/payment/checkout.page"/>" class="btn btn-outline-primary">Go to checkout</a>

    </div>
</div>