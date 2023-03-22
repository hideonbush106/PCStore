<%-- 
    Document   : invoice
    Created on : Mar 22, 2023, 9:19:27 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="<c:url value="/employees/invoice.do"/>">
    <select name="orderHeaderId">
        <option value="-1">None</option>
        <c:forEach items="${orderDate}" var="order">
            <option value="${order.orderHeaderId}" ${order.orderHeaderId == orderHeaderId ? "selected" : ""}>Order #${order.orderHeaderId} on ${order.date}</option>
        </c:forEach>
    </select>
    <input type="hidden" name="customerId" value="${customerId}"/>
    <button type="submit" name="op" value="export">Submit</button>
</form>
<div id="invoice">
    <h1>Invoice</h1>
    <p>Employees's name: ${sessionScope.account.fullName}</p>
    <p>Customer's name: ${customer.fullName}</p>
    <p>Customer's phone number: ${customer.phoneNo}</p>
    <p>Customer's address: ${customer.address}</p>
    <p>Order date: ${date}</p>
    <table border="1" cellpadding="3" cellspacing="3">
        <thead>
            <tr>
                <th>Product's name</th>
                <th>Quantity</th>
                <th>Cost</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${orderList}">
                <tr>
                    <td>${order.productName}</td>
                    <td>${order.quantity}</td>
                    <td>${order.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<form action="<c:url value="/employees/invoice.do"/>">
    <input type="hidden" value="${orderHeaderId}" name="orderHeaderId"/>
    <button type="submit" name="op" value="print" onclick="printInvoice()">Print</button>
</form>
<script>
    function printInvoice() {
        const printableContent = document.getElementById('invoice');
        const printWindow = window.open('', '', 'height=1000,width=1000');
        printWindow.document.write('<html><head><title>Printable Content</title></head><body>');
        printWindow.document.write(printableContent.innerHTML);
        printWindow.document.write('</body></html>');
        printWindow.document.close();
        printWindow.focus();
        printWindow.print();
        printWindow.close();
    }
</script>


