<%-- 
    Document   : update
    Created on : Mar 4, 2023, 10:17:15 PM
    Author     : VU HONG ANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US" scope="session" />
<h2>Update Page</h2>

<div class="update">
    <div class="container">
        <div class="row">

            <h2>Product Information Editor</h2>

            <div class="col">
                <form action="<c:url value="/product/update_handler.page"/>">
                    <div class="mb-3 mt-3">
                        <label for="productId" class="form-label">Product ID:</label>
                        <input disabled="" type="text" class="form-control" id="productId" placeholder="Product ID" name="productId" value="${product.productId}">
                        <input type="hidden" name="productId" value="${product.productId}">

                        <label for="productName" class="form-label">Product Name:</label>
                        <input type="text" class="form-control" id="productName" placeholder="Product Name" name="productName" value="${product.productName}">

                        <label for="productPublisher" class="form-label">Publisher:</label>
                        <input type="text" class="form-control" id="productPublisher" placeholder="Publisher" name="productPublisher" value="${product.productPublisher}">

                        <label for="category" class="form-label">Category:</label>
                        <input type="text" class="form-control" id="category" placeholder="Category" name="category" value="${product.category}">

                        <label for="description" class="form-label">Description:</label>
                        <input type="text" class="form-control" id="description" placeholder="Description" name="description" value="${product.description}">
                        
                        <label for="quantity" class="form-label">Quantity:</label>
                        <input type="number" step="1" class="form-control" id="quantity" placeholder="Quantity" name="quantity" value="${product.quantity}">         

                        <label for="price" class="form-label">Price:</label>
                        <input type="number" step="100" class="form-control" id="price" placeholder="Price" name="price" value="${product.price}">                       
                        
                        <label for="productImages" class="form-label">Images:</label>
                        <input type="text" class="form-control" id="productImages" placeholder="Input images directory" value="${product.productImages}">
                    </div>
                    
                    <button type="submit" name="op" class="btn btn-outline-success" value="update"><i class="fa fa-check"></i> Update</button>
                    <button type="submit" name="op" class="btn btn-outline-danger" value="cancel"><i class="fa fa-xmark"></i> Cancel</button>
                    
                </form>
                <i style="color:red">${message}</i>
            </div>

            <div class="col">
                <img src="<c:url value="${product.productImages}"/>" alt="">
            </div>

        </div>
    </div>
</div>