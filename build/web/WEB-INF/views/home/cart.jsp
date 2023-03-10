<%-- 
    Document   : cart.jsp
    Created on : Mar 9, 2023, 9:11:37 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Hello Cart</h1>
<i>${message}</i>
<c:if test="${sessionScope.cart != null}">
    <table border="1px" cellspacing="0" cellpadding="4">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Brand</th>
            <th>Unit price</th>
            <th>Quantity</th>
            <th>Cost</th>
            <th>Operations</th>
        </tr>
        <c:forEach var="item" items="${sessionScope.cart.item}" varStatus="loop">
            <tr>
                <td>${item.product.productId}</td>
                <td>${item.product.productName}</td>
                <td>${item.product.categoryName}</td>
                <td>${item.product.brandName}</td>
                <td>${item.product.price}</td>
                <td><input type="number" min="1" value="${item.quantity}"/></td>
                <td>${item.product.price * item.quantity}</td>
                <td>
                    <a href="<c:url value="/cart?op=update&quantity=${item.quantity}&productId=${item.product.productId}"/>">Update</a>
                    <a href="<c:url value="/cart?op=delete&productId=${item.product.productId}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="<c:url value="/cart?op=empty"/>">Empty</a>
    <a href="<c:url value="/cart?op=checkout"/>">Checkout</a>
</c:if>