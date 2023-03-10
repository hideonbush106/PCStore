<%-- 
    Document   : createEmployee
    Created on : Mar 8, 2023, 1:16:34 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <form action="<c:url value="/admin/create_handlerEmployee.do"/>">
        <label>Employee account email:</label>
        <input type="email" name="email"/><br/>
        <label>Employee account password:</label>
        <input type="password" name="password"><br/>
        <label>Employee's name:</label>
        <input type="text" name="empName"/><br/>
        <label>Employee's salary: </label>
        <input type="number" min="0" step="0.1" name="salary"><br/>
        <label> Employee's address: </label>
        <input type="text" name="address"/><br/>
        <label> Employee's phone number </label>
        <input type="tel" name="phoneNo"/><br/>
        <button type="submit" name="op" value="create">Create</button>
        <button type="submit" name="op" value="cancel">Cancel</button>
    </form>
    <i>${message}</i>
</c:if>