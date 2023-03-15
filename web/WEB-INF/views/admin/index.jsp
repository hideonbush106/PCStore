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
    <h1>Hello Admin</h1>
</c:if>
