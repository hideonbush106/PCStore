<%-- 
    Document   : editEmployee
    Created on : Mar 8, 2023, 1:31:16 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="<c:url value="edit_handlerEmployee.do"/>">
    <c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
        <jsp:forward page="/home/index.do"/>
    </c:if>
    <c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
        <label>Employee ID: </label>
        <input type="text" readonly name="employeeId" value="${employee.employeeId}"/><br/>
        <label>Employee Name: </label>
        <input type="text" readonly name="empName" value="${employee.empName}"/><br/>
        <label>Salary: </label>
        <input type="number" min="0" name="salary" value="${employee.salary}"/><br/>
        <button type="submit" name="op" value="update">Update</button>
        <button type="submit" name="op" value="cancel">Cancel</button>
    </form>
</c:if>