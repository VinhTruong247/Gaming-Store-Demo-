<%-- 
    Document   : checkout
    Created on : Mar 13, 2023, 9:04:32 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US" scope="session" />
<h2>Checkout Page</h2>

<div class="checkout">
    <div class="container">

        <div class="row">

            <div class="col">
                <h3>Billing Address</h3>
                <hr/>
                <c:if test="${sessionScope.user != null}">
                    <label for="fullName"><i class="fa fa-user"></i> Full Name</label>
                    <input type="text" disabled="" id="fname" name="fullName" value="${sessionScope.user.fullName}">
                    <label for="email"><i class="fa fa-envelope"></i> Email</label>
                    <input type="text" disabled="" id="email" name="email" value="${sessionScope.user.email}">
                    <label for="address"><i class="fa fa-home"></i> Address</label>
                    <input type="text" disabled="" id="adr" name="address" value="${sessionScope.user.address}">
                </c:if>
                <c:if test="${sessionScope.user == null}">
                    <label for="fullName"><i class="fa fa-user"></i> Full Name</label>
                    <input type="text" id="fname" name="fullName" placeholder="Your Name">
                    <label for="email"><i class="fa fa-envelope"></i> Email</label>
                    <input type="text" id="email" name="email" placeholder="abc@example.com">
                    <label for="address"><i class="fa fa-home"></i> Address</label>
                    <input type="text" id="adr" name="address" placeholder="Your Address">
                </c:if>
                <label for="city"><i class="fa fa-institution"></i> City</label>
                <input type="text" id="city" name="city" placeholder="City">
                <label for="zip">Zip</label>
                <input type="text" id="zip" name="zip" placeholder="10000">
            </div>

            <div class="col">
                <h3>Payment</h3>
                <hr/>

                <label for="fname">Accepted Cards</label>
                <div class="icon-container">
                    <i class="fa fa-cc-visa" style="color:navy;"></i>
                    <i class="fa fa-cc-amex" style="color:blue;"></i>
                    <i class="fa fa-cc-mastercard" style="color:red;"></i>
                    <i class="fa fa-cc-discover" style="color:orange;"></i>
                </div>

                <label for="cname">Card Holder</label>
                <input type="text" id="cname" name="cardname" placeholder="Card Holder Name">
                <label for="ccnum">Card number</label>
                <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
                <label for="expmonth">Expire Month</label>
                <input type="number" id="expmonth" name="expmonth" placeholder="01">

                <div class="row">
                    <div class="col">
                        <label for="expyear">Expire Year</label>
                        <input type="number" id="expyear" name="expyear" placeholder="2023">
                    </div>
                    <div class="col">
                        <label for="cvv">CVV</label>
                        <input type="text" id="cvv" name="cvv" placeholder="123">
                    </div>
                </div>
            </div>

            <div class="col">
                <h3>Billing Address</h3>
                <hr/>
                <div style="overflow-y: scroll; height:70%">
                    <table class="table table-striped">
                        <thead>

                            <tr>
                                <th>No.</th>
                                <th>Images</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th></th>
                            </tr>

                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${sessionScope.cart.item}" varStatus="loop">
                                <tr>
                                    <td>${loop.count}</td>
                                    <td style="width: 220px;"><img src="<c:url value="${item.product.productImages}"/>" style="width:100%; height:100%" alt=""></td>
                                    <td>${item.product.productName}</td>
                                    <td><fmt:formatNumber value="${item.product.price}" type="number"/>&#8363;</td>
                                    <td>
                                        <a href="<c:url value="/cart?productId=${item.product.productId}&op=delete"/>"><i class="bi bi-x-lg"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        <td colspan = "5"><c:if test="${count==0}"><h1 style="text-align: center;">Go get some games now!</h1></c:if></td>
                        </tbody>
                    </table>
                </div>
                <h4>Total: <fmt:formatNumber value="${cart.total}" type="number"/>&#8363;</h4>
            </div>            

        </div>

        <div class="row" style="text-align: center">
            <form action="<c:url value="/payment/checkout_handler.page" />" method="post">
                <button type="submit" class="btn btn-outline-danger" name="action" value="cancel" style="background-color: red"><i class="bi bi-x-lg"></i> Cancel</button>
                <c:if test="${count==0}">
                    <button type="submit" class="btn btn-secondary" name="action"disabled="" style="background-color: grey"><i class="bi bi-check-lg"></i> Purchase</button>
                </c:if>
                <c:if test="${count>0}">
                    <button type="submit" class="btn btn-outline-success" name="action" value="success" style="background-color: green"><i class="bi bi-check-lg"></i> Purchase</button>
                </c:if>            
            </form>
        </div>

    </div>
</div>