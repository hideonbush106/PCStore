<%-- 
    Document   : index
    Created on : Mar 2, 2023, 1:41:38 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Product goes here</h1>
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
</div>