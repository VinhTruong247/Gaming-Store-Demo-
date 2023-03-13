<%-- 
    Document   : create.jsp
    Created on : Mar 13, 2023, 9:55:21 PM
    Author     : VU HONG ANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US" scope="session" />
<div class="row">
    <h2>Product Information Creator</h2>
    <div class="col">
        <form action="<c:url value="/product/create_handler.page"/>">
            <div class="mb-3 mt-3">
                <label for="productId" class="form-label">Product ID:</label>
                <input type="text" class="form-control" id="productId" placeholder="Product ID" name="productId">
            </div>
            <div>
                <label for="productName" class="form-label">Product Name:</label>
                <input type="text" class="form-control" id="productName" placeholder="Product Name" name="productName">
            </div>
            <div>
                <label for="productPublisher" class="form-label">Publisher:</label>
                <input type="text" class="form-control" id="productPublisher" placeholder="Publisher" name="productPublisher">
            </div>
            <div>
                <label for="category" class="form-label">Category:</label>
                <input type="text" class="form-control" id="category" placeholder="Category" name="category">
            </div>
            <div>
                <label for="description" class="form-label">Description:</label>
                <input type="text" class="form-control" id="description" placeholder="Description" name="description">
            </div>
            <div>
                <label for="price" class="form-label">Price:</label>
                <input type="number" step="0.1" class="form-control" id="price" placeholder="Price" name="price">
            </div>
            <button type="submit" name="op" class="btn btn-outline-success" value="create"><i class="bi bi-check-circle"></i> Create</button>
            <button type="submit" name="op" class="btn btn-outline-danger" value="cancel"><i class="bi bi-x-circle"></i> Cancel</button>
        </form>
        <i style="color:red">${message}</i>
    </div>
    <div class="col">
        
    </div>
</div>