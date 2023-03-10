<%-- 
    Document   : create
    Created on : Mar 7, 2023, 10:27:20 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <form action="<c:url value="/admin/create_handlerProduct.do"/>">
        <label>Product name: </label>
        <input type="text" name="productName"/><br/>
        <label>Product price: </label>
        <input type="number" step="0.1" name="price" min="0"/><br/>
        <label>Product brand:</label>
        <select name="brandId">
            <c:forEach items="${brandList}" var="brand">
                <option value="${brand.brandId}">${brand.name}</option>
            </c:forEach>
        </select><br/>
        <label>Product category: </label>
        <select name="categoryId">
            <c:forEach items="${categoryList}" var="category">
                <option value="${category.categoryId}">${category.name}</option>
            </c:forEach>
        </select><br/>
        <label>Product description:</label>
        <input type="text" name="description"/><br/>
        <button type="submit" name="op" value="create">Create</button>
        <button type="submit" name="op" value="cancel">Cancel</button>
    </form>
</c:if>
