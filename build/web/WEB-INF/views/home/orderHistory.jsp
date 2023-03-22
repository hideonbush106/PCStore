<%-- 
    Document   : orderHistory
    Created on : Mar 22, 2023, 9:45:46 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table border="1" cellpadding="3" cellspacing="3">
    <thead>
        <tr>
            <th>ID</th>
            <th>Date</th>
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
                <td>${order.productName}</td>
                <td>${order.quantity}</td>
                <td>${order.price}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
