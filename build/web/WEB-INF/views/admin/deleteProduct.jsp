<%-- 
    Document   : deleteProduct
    Created on : Mar 7, 2023, 7:34:08 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <h2>Deletion Confirmation</h2>
    <form action="<c:url value="/admin/delete_handlerProduct.do" />">
        <input type="hidden" name="id" value="${id}" />
        Are you sure to delete the product with id = ${id}?<br/>
        <button type="subtmit" name="op" value="yes" class="btn-light"> Yes</button>
        <button type="subtmit" name="op" value="no" class="btn-danger"> No</button>
    </form>
</c:if>
