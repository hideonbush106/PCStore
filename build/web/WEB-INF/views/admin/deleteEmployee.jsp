<%-- 
    Document   : deleteEmployee
    Created on : Mar 9, 2023, 8:55:28 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <h2>Deletion Confirmation</h2>
    <form action="<c:url value="/admin/delete_handlerEmployee.do" />">
        <input type="hidden" name="id" value="${id}" />
        Are you sure to delete this employee with id = ${id}?<br/>
        <button type="subtmit" name="op" value="yes"> Yes</button>
        <button type="subtmit" name="op" value="no"> No</button>
    </form>
</c:if>
