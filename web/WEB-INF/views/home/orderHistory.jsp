<%-- 
    Document   : orderHistory
    Created on : Mar 22, 2023, 9:45:46 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Order Status</th>
            <th>Detail</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach var="order" items="${list}">
            <tr>
                <td>${order.orderHeaderId}</td>
                <td>${order.date}</td>
                <td>${order.status == true ? "On Deliveried" :"Processing"}</td>
                <td><a href="<c:url value="/home/orderDetail.do?id=${order.orderHeaderId}"/>">View Detail</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
