<%-- 
    Document   : cart.jsp
    Created on : Mar 9, 2023, 9:11:37 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account == null}">
    <jsp:forward page="home/index.do"/>
</c:if>
<c:if test="${sessionScope.account != null}">
    <c:if test="${sessionScope.account.role == 'ROLE_CUSTOMER'}">
        <h1>Hello Cart</h1>
        <i>${message}</i>
        <c:if test="${sessionScope.cart != null}">
            <c:if test="${!sessionScope.cart.map.isEmpty()}">
                <table border="1px" cellspacing="0" cellpadding="4">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Brand</th>
                            <th>Unit price</th>
                            <th>Quantity</th>
                            <th>Cost</th>
                            <th>Operations</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${sessionScope.cart.item}" varStatus="loop">
                            <tr>
                        <form action="<c:url value="/cart"/>">
                            <td>${item.product.productId}</td>
                            <td>${item.product.productName}</td>
                            <td>${item.product.categoryName}</td>
                            <td>${item.product.brandName}</td>
                            <td>${item.product.price}</td>
                            <td><input type="number" min="1" name="quantity" value="${item.quantity}"/></td>
                            <td>${item.cost}</td>
                            <td>
                                <input type="hidden" name="productId" value="${item.product.productId}" />
                                <button type="submit" name="op" value="update">Update</button>
                                <button type="submit" name="op" value="delete">Delete</button>
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <th colspan="6">Total</th>
                    <th>${sessionScope.cart.total}</th>
                    <th></th>
                </tr>
            </tfoot>
        </table>
        <a href="<c:url value="/cart?op=empty"/>">Empty</a>
        <a href="<c:url value="/cart?op=checkout"/>">Checkout</a>
    </c:if>
</c:if>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <jsp:forward page="admin/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_EMPLOYEE'}">
    <jsp:forward page="employees/index.do"/>
</c:if>
</c:if>