<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_EMPLOYEE'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_EMPLOYEE'}">
    <form action="<c:url value="/employees/invoice.do"/>">
        <div class="container-fluid">
            <div class="container">
                <!-- Title -->
                <div
                    class="d-flex justify-content-between align-items-lg-center py-3 flex-column flex-lg-row"
                    >
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
                                <h2 class="ml-lg-2">Invoice center</h2>
                            </div>
                            <div class="col-sm-6 p-0 d-flex justify-content-lg-end justify-content-center">
                                <select name="orderHeaderId">
                                    <option value="-1">None</option>
                                    <c:forEach items="${orderDate}" var="order">
                                        <option value="${order.orderHeaderId}" ${order.orderHeaderId == orderHeaderId ? "selected" : ""}>Order #${order.orderHeaderId} on ${order.date}</option>
                                    </c:forEach>
                                </select>
                                <input type="hidden" name="customerId" value="${customerId}"/>
                                <button type="submit" name="op" value="export" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </div>
                </div>
    </form>

                <!-- Main content -->
                <div class="row">
                    <!-- Left side -->
                    <div class="col-lg-5">
                        <!-- Basic information -->
                        <div class="card mb-4">
                            <div class="card-body">
                                <h3 class="h6 mb-4">Invoice</h3>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="mb-3">
                                            <label class="form-label">Employee's Name</label>
                                            <input type="text" disabled name="productId" value="${sessionScope.account.fullName}" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="mb-3">
                                            <label class="form-label">Customer's Name</label>
                                            <input  type="text" value="${customer.fullName}"class="form-control" disabled/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="mb-3">
                                        <label class="form-label"> Customer's phone number</label>
                                        <input value="${customer.phoneNo}" type="text" name="productName" class="form-control" disabled/>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="mb-3">
                                        <label class="form-label"
                                               >Customer's address</label
                                        >
                                        <input value="${customer.address}" type="text" name="productName" class="form-control" disabled/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Right side -->
                    <div class="col-lg-7" id="invoice">
                        <label class="form-label">Order date: ${date}</label>
                        <table class="table table-striped table-hover">
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
                        <form action="<c:url value="/employees/invoice.do"/>" class="form-control d-flex justify-content-center" style="height: 50px ">
                            <input type="hidden" value="${orderHeaderId}" name="orderHeaderId"/>
                            <button type="submit" name="op" value="print" onclick="printInvoice()" class="btn btn-primary mx-auto">Print</button>
                        </form>s
                </div>
               
            </div>

<script>
    function printInvoice() {
    const printableContent = document.getElementById('invoice');
    const printWindow = window.open('', '', 'height=1000,width=1000');
    printWindow.document.write('<html><head><title>Printable Content</title>');
    printWindow.document.write('<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">');
    printWindow.document.write('</head><body>');
    printWindow.document.write(printableContent.innerHTML);
    printWindow.document.write('</body></html>');
    printWindow.document.close();
    printWindow.focus();
    printWindow.print();
    printWindow.close();
}

</script>

</c:if>