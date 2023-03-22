<%-- 
    Document   : cart
    Created on : Mar 14, 2023, 12:32:16 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <div class="mx-auto col-xl-6" >
        <h3 class="text-center" >Release Invoice</h3>
    <form action="<c:url value="/employees/invoice.do"/>">
        <div class=" d-flex justify-content-center align-items-center">
        <select name="customerId" class="form-control">
            <c:forEach items="${customerList}" var="customer">
            <option value="${customer.customerId}" class="form-control">${customer.customerId} - ${customer.fullName}</option>
            </c:forEach>
        </select>
            <button type="submit" value="invoice" name="op" class="btn btn-primary">Continue</button>
        </div>
        
    </form>
    </div>
<table class="table table-striped table-hover">
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
</div>
