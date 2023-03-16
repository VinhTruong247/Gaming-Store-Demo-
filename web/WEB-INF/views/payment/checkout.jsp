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

                <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                <input type="text" id="fname" name="firstname" placeholder="Your Name">
                <label for="email"><i class="fa fa-envelope"></i> Email</label>
                <input type="text" id="email" name="email" placeholder="abc@example.com">
                <label for="adr"><i class="fa fa-home"></i> Address</label>
                <input type="text" id="adr" name="address" placeholder="Your Address">
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
                <input type="text" id="expmonth" name="expmonth" placeholder="September">

                <div class="row">
                    <div class="col">
                        <label for="expyear">Expire Year</label>
                        <input type="text" id="expyear" name="expyear" placeholder="2023">
                    </div>
                    <div class="col">
                        <label for="cvv">CVV</label>
                        <input type="text" id="cvv" name="cvv" placeholder="123">
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel" style="background-color: red"><i class="bi bi-x-lg"></i> Cancel</button>
            <button type="submit" class="btn btn-outline-success" name="op" value="purchase" style="background-color: green"><i class="bi bi-check-lg"></i> Purchase</button>
        </div>
        
    </div>
</div>