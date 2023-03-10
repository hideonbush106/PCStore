<%-- 
    Document   : cart
    Created on : Mar 14, 2023, 12:32:16 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table border="1" cellpadding="3" cellspacing="3">
    <thead>
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Status</th>
            <th>Customer's name</th>
            <th>Product's name</th>
            <th>Quantity</th>
            <th>Cost</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="order" items="${list}">
            <tr>
                <td>${order.orderHeaderId}</td>
                <td>${order.date}</td>
                <td>${order.status}</td>
                <td>${order.fullname}</td>
                <td>${order.productName}</td>
                <td>${order.quantity}</td>
                <td>${order.price}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
