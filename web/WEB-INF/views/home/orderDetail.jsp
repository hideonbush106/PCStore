<%-- 
    Document   : orderDetail
    Created on : Mar 23, 2023, 2:32:38 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Quantity</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach var="order" items="${list}">
            <tr>
                <td>${order.orderHeaderId}</td>
                <td>${order.productName}</td>
                <td>${order.quantity}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
