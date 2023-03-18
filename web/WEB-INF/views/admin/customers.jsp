

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">



    <div class="table-container">
        <table class="table table-striped table-hover">
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
    </div> 

</c:if>