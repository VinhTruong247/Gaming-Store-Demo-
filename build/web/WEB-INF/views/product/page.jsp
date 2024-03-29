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

            <c:forEach var="product" items="${list}" varStatus="loop">
                <div class="col-lg-4">
                    <div class="item">
                        <div class="thumb">
                            <div class="hover-content">
                                <ul>
                                    <li><a href="<c:url value="#"/>"><i class="fa fa-eye"></i></a>
                                    </li>
                                    <li><a href="<c:url value="#"/>"><i class="fa fa-star"></i></a>
                                    </li>
                                    <li><a href="<c:url value="/cart?&op=add&productId=${product.productId}"/>"><i class="fa fa-shopping-cart"></i></a></li>
                                </ul>
                            </div>
                            <img src="<c:url value="${product.productImages}"/>" alt="">
                        </div>
                        <div class="down-content">

                            <h4>${product.productName}</h4>

                            <span>
                                <fmt:formatNumber value="${product.price}" type="number"/>&#8363; |
                                <a href="<c:url value="/product/single_product.page?quantity=1&op=none&productId=${product.productId}"/>" class="btn btn-outline-primary">Find out</a>
                            </span>

                            <ul class="stars">
                                <li><i class="fa fa-star"></i></li>
                                <li><i class="fa fa-star"></i></li>
                                <li><i class="fa fa-star"></i></li>
                                <li><i class="fa fa-star"></i></li>
                                <li><i class="fa fa-star"></i></li>
                            </ul>

                        </div>
                    </div>
                </div>
            </c:forEach>

            <div class="pagination">
                <ul>
                    <c:if test="${currentPage > 1}">                         
                        <li><a href="<c:url value="/product/page.page?currentPage=${currentPage - 1}"/>">&laquo;</a></li>
                        </c:if>

                    <c:forEach begin="1" end="${totalPage}" var="i">

                        <c:if test="${i == currentPage}">
                            <li><a href="<c:url value="/product/page.page?currentPage=${i}"/>" class="active">${i}</a></li>
                            </c:if>

                        <c:if test="${i != currentPage}">
                            <li><a href="<c:url value="/product/page.page?currentPage=${i}"/>">${i}</a></li>
                            </c:if>                            
                        </c:forEach>

                    <c:if test="${currentPage < totalPage}">                         
                        <li><a href="<c:url value="/product/page.page?currentPage=${currentPage + 1}"/>">&raquo;</a></li>
                        </c:if>
                </ul>
            </div>

        </div>
    </div>
</section>