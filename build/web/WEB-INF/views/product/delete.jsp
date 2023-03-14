<%-- 
    Document   : delete
    Created on : Mar 4, 2023, 8:39:56 PM
    Author     : VU HONG ANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US" scope="session" />

<h2>Delete Page</h2>

<div class="delete">
    <div class="container">

        <h1>Alert</h1>
        <form action="<c:url value="/product/delete_handler.page"/>">
            <input type="hidden" name="productId" value="${productId}"/>
            Are you sure about deleting product with <span style="color: red; font-weight: bold">ID ${productId}</span>?
            <br/>
            Note: This action can't be undone.
            <div class="col">
                <button type="submit" name="op" class="btn btn-outline-success" value="yes"><i class="fa fa-check"></i> Yes</button>
                <button type="submit" name="op" class="btn btn-outline-danger" value="no"><i class="fa fa-xmark"></i> No</button>
            </div>
        </form>

    </div>
</div>