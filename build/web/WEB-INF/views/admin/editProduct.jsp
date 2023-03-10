<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <form action="<c:url value="/admin/edit_handlerProduct.do"/>">
        <label>Product ID:</label>
        <input type="text" readonly name="productId" value="${product.productId}"><br/>
        <label>Product name: </label>
        <input value="${product.productName}" type="text" name="productName"/><br/>
        <label>Product price: </label>
        <input value="${product.price}" type="number" step="0.1" name="price" min="0"/><br/>

        <label>Product category: </label>
        <select name="categoryId">
            <c:forEach items="${categoryList}" var="category">
                <option value="${category.categoryId}" ${category.categoryId == product.categoryId?"selected":""}>${category.name}</option>
            </c:forEach>
        </select><br/>
        <label>Product brand:</label>
        <select name="brandId">
            <c:forEach items="${brandList}" var="brand">
                <option value="${brand.brandId}" ${brand.brandId == product.brandId?"selected":""}>${brand.name}</option>
            </c:forEach>
        </select><br/>
        <label>Product description:</label>
        <input value="${product.description}" type="text" name="description"/><br/>
        <button type="submit" name="op" value="update">Update</button>
        <button type="submit" name="op" value="cancel">Cancel</button>
    </form>
</c:if>