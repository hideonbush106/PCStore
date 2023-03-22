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
            <th>Customer's name</th>
            <th>Product's name</th>
            <th>Quantity</th>
            <th>Cost</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.orderHeaderId}</td>
                <td>${order.date}</td>
                <td>${order.fullname}</td>
                <td>${order.productName}</td>
                <td>${order.quantity}</td>
                <td>${order.price}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
Release Invoice
<form action="<c:url value="/employees/invoice.do"/>">
    <select name="customerId">
        <c:forEach items="${customerList}" var="customer">
        <option value="${customer.customerId}">${customer.customerId} - ${customer.fullName}</option>
        </c:forEach>
    </select>
    <button type="submit" value="invoice" name="op">Continue</button>
</form>
