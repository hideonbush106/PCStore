<%-- 
    Document   : index
    Created on : Mar 2, 2023, 1:41:38 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="utils.Utils" %>
<h1>Product goes here</h1>
Sort by:
<%--    <form action="<c:url value=""/>">
    <label for="sortChoice"></label>
    <select name="sortChoice" id="sortChoice">
        <option value="price">Price</option>
        <option value="brand">Brand</option>
    </select>
</form>--%>

<form action="<c:url value="/home/sort.do"/>">
    <label for="sortOrderChoice"></label>
    <select name="sortOrderChoice" id="sortOrderChoice">
        <option value="asc">Ascending</option>
        <option value="desc">Descending</option>
    </select>
    <button type="submit" name="op" value="sortOrderChoice">Sort</button>
</form>

<div style="display: flex; flex-wrap: wrap; align-content: center; justify-content: center">
    <c:forEach items="${list}" var="product" varStatus="loop">
        <div style="width: 30%; text-align: center; margin: 1rem">
            <h3 style="margin: 0;">${product.productName}</h3>
            <img style="margin:0 ; width:30%; height:fit-content" src="<c:url value="${product.imgSrc}"/>" alt="">
            <p>${product.price}</p><br/>
            <h4 style="margin: 0;">${product.categoryName}</h4><br/>
            <h4 style="margin: 0;">${product.brandName}</h4><br/>
            <p style="text-align: justify">${product.description}</p><br/>
            <c:if test="${sessionScope.account.role == 'ROLE_CUSTOMER'}">
                <a href="<c:url value="/cart?op=add&productId=${product.productId}"/>">Add to cart</a>
            </c:if>
            <c:if test="${sessionScope.account == null}">
                <p>Login to buy nha!</p>
            </c:if>
        </div>
    </c:forEach>
    <c:forEach items="${list}" var="product" varStatus="loop" end="10">
        <!-- Single -->
        <div class="product-single">
            <div class="sale-badge">
                <span>sale1</span>
            </div>
            <div class="product-thumbnail">
                <a href="product-details.html"
                   ><img
                        src="https://bizweb.dktcdn.net/100/416/452/products/dell-9570-1.jpg?v=1612512400560"
                        alt="product"
                        /></a>
                <div
                    class="product-thumbnail-overly"
                    >
                    <ul>
                        <li>
                            <a href="cart.html"
                               ><i
                                    class="fas fa-shopping-cart"
                                    ></i
                                ></a>
                        </li>
                        <li>
                            <a href="wishlist.html"
                               ><i
                                    class="far fa-heart"
                                    ></i
                                ></a>
                        </li>
                        <li>
                            <a href="#"
                               ><i
                                    class="far fa-eye"
                                    ></i
                                ></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="product-content">
                <h4>
                    <a href="product-details.html"
                       >${product.productName}</a
                    >
                </h4>
                <div class="pricing">
                    <span
                        >$ ${product.price} <del>$<%= Utils.getRandomNumber()%></del></span
                    >
                </div>
            </div>
        </div>
    </c:forEach>
</div>