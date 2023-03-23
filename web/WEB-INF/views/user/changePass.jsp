<%-- 
    Document   : profile
    Created on : Mar 14, 2023, 5:40:55 PM
    Author     : binla
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="edit">
    <div class="container">
        <div class="row">
            <h2>Change Password</h2>
            <div class="col">   
            </div>
            <div class="col">
                <form action="<c:url value="/user/changePass_handler.page" />" method="get">
                    <div class="mb-3 mt-3">
                        <label for="oldPass" class="form-label">Old Password:</label>
                        <input type="password" class="form-control" id="oldPass" placeholder="Enter your old password here" name="oldPass" required value="">
                    </div>
                    <div class="mb-3">
                        <label for="newPass" class="form-label">New Password:</label>
                        <input type="password" class="form-control" id="newPass" placeholder="Enter your new password here" name="newPass" required value="">
                    </div>
                    <button type="submit" class="btn btn-outline-success" name="op" value="apply"><i class="bi bi-check-lg"></i> Apply</button>
                    <button type="submit" class="btn btn-outline-danger" formnovalidate name="op" value="cancel"><i class="bi bi-x-lg"></i> Cancel</button>
                </form>
                <i style="color:red;">${message}</i>
            </div>
            <div class="col">
            </div>
        </div>
    </div>
</div>