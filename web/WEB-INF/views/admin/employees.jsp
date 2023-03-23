

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">

    <div class="table-title">
        <div class="row">
            <div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
                <h2 class="ml-lg-2">Manage Employee By Admin</h2>
            </div>
            <div class="col-sm-6 p-0 d-flex justify-content-lg-end justify-content-center">
                <a href="<c:url value="/admin/createEmployee.do"/>" class="btn btn-success d-flex align-items-center" data-toggle="modal" style="margin-right: 10px">
                    <i class="fa-sharp fa-solid fa-plus" style="margin-right: 10px"></i><span>Add New Employee</span></a>

            </div>
        </div>
    </div>
    <div class="table-container">
        <table class="table table-striped table-hover">
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
                            <!--<a href="<c:url value="/admin/deleteEmployee.do?id=${employee.employeeId}"/>">Delete</a>-->
                        </td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
    </div> 

</c:if>