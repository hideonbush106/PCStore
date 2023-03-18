<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : index
    Created on : Mar 3, 2023, 10:59:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <form action="<c:url value="/admin/viewRevenue.do"/>">
        View revenue
        From: <input type="date" name="dateFrom" value="${dateFrom}"/>
        To : <input type="date" name="dateTo" value="${dateTo}"/>
        <button type="submit" name="op" value="view">Submit</button>
    </form>
    <h1>Hello Admin</h1>
    <table border="1" cellspacing="0" cellpadding="4">
        <tr>
            <th>OrderId</th>
            <th>ProductId</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>cost</th>
        </tr>
        <c:forEach var="revenue" items="${list}" varStatus="loop">
            <tr>
                <td>${revenue.orderDetailId}</td>
                <td>${revenue.date}</td>
                <td>${revenue.productId}</td>
                <td>${revenue.productName}</td>
                <td>${revenue.quantity}</td>
                <td>${revenue.cost}</td>
            </tr>
        </c:forEach>
    </table>
    Total:${revenue.totalCost}
</c:if>
