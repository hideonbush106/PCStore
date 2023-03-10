<%-- 
    Document   : product
    Created on : Mar 3, 2023, 11:04:07 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <h1>Manage product here</h1>
    <table border="1px" cellspacing="0" cellpadding="4">
        <thead>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Price</th>
                <th>Category</th>
                <th>Brand</th>
                <th>Description</th>
                <th>Operations</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="product" varStatus="loop">
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.categoryName}</td>
                    <td>${product.brandName}</td>
                    <td>${product.description}</td>
                    <td><a href="<c:url value="/admin/editProduct.do?id=${product.productId}"/>">Update</a>
                        <a href="<c:url value="/admin/deleteProduct.do?id=${product.productId}"/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value="/admin/createProduct.do"/>">Create</a>
</c:if>
