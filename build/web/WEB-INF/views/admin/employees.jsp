<%-- 
    Document   : employees
    Created on : Mar 3, 2023, 11:03:43 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <h1>Manage employees here</h1>
    <table border="1px" cellspacing="0" cellpadding="4">
        <thead>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Salary</th>
                <th>Address</th>
                <th>Phone No.</th>
                <th>Operation</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="employee" varStatus="loop">
                <tr>
                    <td>${employee.employeeId}</td>
                    <td>${employee.empName}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.address}</td>
                    <td>${employee.phoneNo}</td>
                    <td>
                        <a href="<c:url value="/admin/editEmployee.do?id=${employee.employeeId}"/>">Change salary</a>
                        <a href="<c:url value="/admin/deleteEmployee.do?id=${employee.employeeId}"/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value="/admin/createEmployee.do"/>">Create</a>
</c:if>