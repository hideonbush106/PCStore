<%-- 
    Document   : customer
    Created on : Mar 7, 2023, 10:42:16 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <h1>Manage customer here</h1>
    <table border="1px" cellspacing="0" cellpadding="4">
        <thead>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone number</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="customer" varStatus="loop">
                <tr>
                    <td>${customer.customerId}</td>
                    <td>${customer.fullName}</td>
                    <td>${customer.address}</td>
                    <td>${customer.phoneNo}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
