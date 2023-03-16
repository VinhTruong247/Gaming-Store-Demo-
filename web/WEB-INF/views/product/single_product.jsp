<%-- 
    Document   : single_product
    Created on : Mar 16, 2023, 12:29:04 AM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<fmt:setLocale value="en-US" scope="session" />

<section class="section" id="single">

    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="left-images">
                    <img src="<c:url value="${product.productImages}"/>" alt="">
                </div>
            </div>

            <div class="col-lg-4">
                <div class="right-content">

                    <h4>${product.productName}</h4>

                    <span class="price"><fmt:formatNumber value="${product.price}" type="number"/>&#8363;</span>

                    <span>
                        <ul class="stars">
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                        </ul>
                    </span>

                    <span>${product.productPublisher} | ${product.category}</span>

                    <div class="quote">
                        <p>${product.description}</p>
                    </div>

                    <div class="quantity-content">
                        <div class="left-content">
                            <h6>No. of Orders</h6>
                        </div>
                        <div class="right-content">
                            <div class="quantity buttons_added">
                                <input type="button" value="-" class="minus"><input type="number" step="1" min="1" max="" name="quantity" value="1" title="Qty" class="input-text qty text" size="4" pattern="" inputmode=""><input type="button" value="+" class="plus">
                            </div>
                        </div>
                        <div class="right-content">
                            <p>Product left in stock: <fmt:formatNumber value="${product.quantity}" type="number"/></p>
                        </div>
                    </div>
                    <div class="total">
                        <h4>Total: </h4>
                        <div class="main-border-button"><a href="<c:url value="#"/>">Add To Cart</a></div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>
