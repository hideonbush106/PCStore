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
        <c:if test="${sessionScope.cart == null}">
            <h1 class="m-auto">Omg!, Your cart is empty  keep shopping !!</h1>
        </c:if>
        <c:if test="${sessionScope.cart != null}">
            <c:if test="${!sessionScope.cart.map.isEmpty()}">
                <section class="cart-page pt-70 pb-70">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="cart-table table-responsive">
						<table class="table table-bordered align-middle text-center">
							<thead>
                                <tr>
                                    <th class="pro-thumbnail">Thumbnail</th>
                                    <th class="pro-title">Product</th>
                                     <th class="pro-price">Category</th>
                                     <th>Brand</th>
                                     <th class="pro-price">Price</th>
                                    <th class="pro-quantity">Quantity</th>
                                    <th class="pro-subtotal">Total</th>
                                    <th class="pro-remove">Operations</th>
                                </tr>
                            </thead>
                            <tbody>
                            	 <c:forEach var="item" items="${sessionScope.cart.item}" varStatus="loop">
                            <tr>
                        <form action="<c:url value="/cart"/>">
                              <td class="pro-thumbnail"><a href="#"><img class="img-fluid" src="<c:url value="${item.product.imgSrc}"/>" alt="Product"></a></td>
                            <td>${item.product.productName}</td>
                            <td>${item.product.categoryName}</td>
                            <td>${item.product.brandName}</td>
                            <td>${item.product.price}</td>
                            <td class="pro-quantity">
                                <span class="quantity">
				<input type="number" min="1" max="1000" step="1" value="${item.quantity}" name="quantity">
				</span>
                                    </td>
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
						</table>
					</div>
					<div class="cart-update-option d-block d-md-flex justify-content-between">

                    </div>
				</div>
			</div>
			<div class="row">
                <div class="col-lg-5 ml-auto">
                    <!-- Cart Calculation Area -->
                    <div class="cart-calculator-wrapper section-bg mt-30">
                        <div class="cart-calculate-items">
                            <h3>Cart Totals</h3>
                            <div class="table-responsive">
                                <table class="table">
                                    <tbody><tr>
                                        <td>Sub Total</td>
                                        <td>$${cart.total}</td>
                                    </tr>
                                    <tr>
                                        <td>Shipping</td>
                                        <td>$0</td>
                                    </tr>
                                    <tr class="total">
                                        <td>Total</td>
                                        <td class="total-amount">$${cart.total}</td>
                                    </tr>
                                </tbody></table>
                            </div>
                        </div>
                                        <a href="<c:url value="/home/checkout.do"/>" class="button-1">Proceed To Checkout</a>
                    </div>
                </div>
            </div>
		</div>
	</section>
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