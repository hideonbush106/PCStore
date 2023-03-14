<%-- 
    Document   : cart
    Created on : Mar 14, 2023, 12:32:16 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:forEach var="order" items="${orderList}">
    <h1>${order.orderId}</h1>
</c:forEach>