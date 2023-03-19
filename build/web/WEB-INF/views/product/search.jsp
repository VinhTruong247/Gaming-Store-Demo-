<%-- Document : page_1 Created on : Mar 13, 2023, 10:54:27 AM Author : Admin --%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<fmt:setLocale value="en-US" scope="session" />

<section class="section" id="products">

<!-- ***** Banner ***** -->    
    <div class="page-heading" id="top">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="inner-content">
                        <h2><span>Our Latest Products</span></h2>
                        <span>Check out all of our products.</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
<!-- ***** Banner ***** -->

    <div class="container">
        <div class="row">

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
                <c:forEach var="product" items="${searchList}" varStatus="loop">
                    <form action="/product/search.page">
                        <tr>
                            <td>${loop.count}</td>
                            <td style="width: 220px;"><img src="<c:url value="${product.productImages}"/>" style="width:100%; height:100%" alt=""></td>
                            <td>${product.productName}</td>
                            <td><fmt:formatNumber value="${product.price}" type="number"/>&#8363;</td>
                            <td><a href="<c:url value="/product/single_product.page?quantity=1&op=none&productId=${product.productId}"/>" class="btn btn-outline-primary">Find out</a></td>
                        </tr>
                    </form>
                </c:forEach>
            </table>

        </div>
    </div>
</section>