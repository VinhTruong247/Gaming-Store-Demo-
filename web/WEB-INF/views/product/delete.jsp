<%-- 
    Document   : delete
    Created on : Mar 4, 2023, 8:39:56 PM
    Author     : VU HONG ANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>Alert</h2>
<form action="<c:url value="/product/delete_handler.page"/>">
    <input type="hidden" name="productId" value="${productId}"/>
    Are you sure about deleting product with ID ${productId}?
    <br/>
    Note: This action can't be undone.
    <button type="submit" name="op" class="btn btn-outline-success" value="yes">Yes</button>
    <button type="submit" name="op" class="btn btn-outline-danger" value="no">No</button>
</form>
    