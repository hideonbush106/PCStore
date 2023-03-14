<%-- 
    Document   : main
    Created on : Mar 1, 2023, 9:39:19 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="/assets/css/style.css" />" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <c:if test="${sessionScope.account==null}">
                <%--chua login --%>
                <a href="<c:url value="/" />">Home</a> |
                <a href="<c:url value="/home/product.do" />">Product</a> | 
                <a href="<c:url value="/home/aboutus.do" />">About Us</a>
                <span style="float: right"><a href="<c:url value="/account/login.do" />">Login</a> | 
                    <a href="<c:url value="/account/register.do" />">Register</a>
                </span>
            </c:if>
            <c:if test="${sessionScope.account != null}">
                <%--da login --%>
                <c:if test = "${sessionScope.account.role == 'ROLE_ADMIN'}">
                    <%-- login as admin --%>
                    <a href="<c:url value="/admin/index.do" />">Home</a> |
                    <a href="<c:url value="/admin/products.do" />">Product</a> | 
                    <a href="<c:url value="/admin/employees.do" />">Employee</a> | 
                    <a href="<c:url value="/admin/customers.do" />">Customer</a>
                </c:if>
                <c:if test="${sessionScope.account.role == 'ROLE_EMPLOYEE'}">
                    <%--login as employee --%>
                    <a href="<c:url value="/employees/index.do" />">Home</a> |
                    <a href="<c:url value="/employees/orderList.do" />">Order List</a>
                </c:if>
                <c:if test="${sessionScope.account.role == 'ROLE_CUSTOMER'}">
                    <%--login as customer--%>
                    <a href="<c:url value="/" />">Home</a> |
                    <a href="<c:url value="/home/product.do" />">Product</a> | 
                    <a href="<c:url value="/home/aboutus.do" />">About Us</a>

                </c:if>
                <span style="float: right">
                    <c:if test="${sessionScope.account.role == 'ROLE_CUSTOMER'}">
                        <a href="<c:url value="/home/cart.do" />">My shopping cart</a>
                    </c:if>
                    Welcome ${sessionScope.account.fullName} | 
                    <a href="<c:url value="/account/logout.do" />">Logout</a>
                </span>
            </c:if>
        </header>
        <main><hr><jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" /><hr></main>
        <footer>
            Copyright &copy; by FPT students
        </footer>
    </body>
</html>
