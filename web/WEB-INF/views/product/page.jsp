<%-- Document : page_1 Created on : Mar 13, 2023, 10:54:27 AM Author : Admin --%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@page contentType="text/html" pageEncoding="UTF-8" %>
                <fmt:setLocale value="en-US" scope="session" />

                <h2>Product Page</h2>

                <section class="section" id="products">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section-heading">
                                    <h2>Our Latest Products</h2>
                                    <span>Check out all of our products.</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">

                            <c:forEach var="product" items="${list}" varStatus="loop">
                                <div class="col-lg-4">
                                    <div class="item">
                                        <div class="thumb">
                                            <div class="hover-content">
                                                <ul>
                                                    <li><a href="<c:url value=" #" />"><i class="fa fa-eye"></i></a>
                                                    </li>
                                                    <li><a href="<c:url value=" #" />"><i class="fa fa-star"></i></a>
                                                    </li>
                                                    <li><a href="<c:url value=" #" />"><i
                                                            class="fa fa-shopping-cart"></i></a></li>
                                                </ul>
                                            </div>
                                            <img src="<c:url value="/images/out1.jpg" />" alt="">
                                        </div>
                                        <div class="down-content">
                                                <h4>${product.productName}</h4>
                                                <span>
                                                    <fmt:formatNumber value="${product.price}" type="number" />&#8363;
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
                                    <li><a href="<c:url value="/product/page.page?offset=0" />">&laquo;</a></li>
                                    <li><a href="<c:url value="/product/page.page?offset=0" />"">1</a></li>
                                    <li><a href="<c:url value="/product/page.page?offset=6" />">2</a></li>
                                    <li><a href="<c:url value="/product/page.page?offset=12" />">3</a></li>
                                    <li><a href="<c:url value="/product/page.page?offset=18" />">4</a></li>
                                    <li><a href="<c:url value="/product/page.page?offset=24" />">5</a></li>
                                    <li><a href="<c:url value="/product/page.page?offset=30" />">6</a></li>
                                    <li><a href="<c:url value="/product/page.page?offset=36" />">7</a></li>
                                    <li><a href="<c:url value="/product/page.page?offset=6" />">&raquo;</a></li>
                                </ul>
                            </div>

                        </div>
                    </div>
                </section>