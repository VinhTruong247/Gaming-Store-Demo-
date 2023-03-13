<%-- 
    Document   : update
    Created on : Mar 4, 2023, 10:17:15 PM
    Author     : VU HONG ANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US" scope="session" />
<div class="row">
    <h2>Product Information Editor</h2>
    <div class="col">
        <form action="<c:url value="/product/update_handler.page"/>">
            <div class="mb-3 mt-3">
                <label for="productId" class="form-label">Product ID:</label>
                <input disabled="" type="text" class="form-control" id="productId" placeholder="Product ID" name="productId" value="${product.productId}">
                <input type="hidden" name="productId" value="${product.productId}">
            </div>
            <div>
                <label for="productName" class="form-label">Product Name:</label>
                <input type="text" class="form-control" id="productName" placeholder="Product Name" name="productName" value="${product.productName}">
            </div>
            <div>
                <label for="productPublisher" class="form-label">Publisher:</label>
                <input type="text" class="form-control" id="productPublisher" placeholder="Publisher" name="productPublisher" value="${product.productPublisher}">
            </div>
            <div>
                <label for="category" class="form-label">Category:</label>
                <input type="text" class="form-control" id="category" placeholder="Category" name="category" value="${product.category}">
            </div>
            <div>
                <label for="description" class="form-label">Description:</label>
                <input type="text" class="form-control" id="description" placeholder="Description" name="description" value="${product.description}">
            </div>
            <div>
                <label for="price" class="form-label">Price:</label>
                <input type="number" step="0.1" class="form-control" id="price" placeholder="Price" name="price" value="${product.price}">
            </div>
            <button type="submit" name="op" class="btn btn-outline-success" value="update"><i class="bi bi-check-circle"></i> Update</button>
            <button type="submit" name="op" class="btn btn-outline-danger" value="cancel"><i class="bi bi-x-circle"></i> Cancel</button>
        </form>
        <i style="color:red">${message}</i>
    </div>
    <div class="col">
        
    </div>
</div>