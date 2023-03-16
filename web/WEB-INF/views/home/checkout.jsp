<%-- 
    Document   : checkout
    Created on : Mar 16, 2023, 4:21:20 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<section class="checkout-page-wrapper pt-70 pb-70">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="checkout-billing-details-wrap">
						<h2>Billing Details</h2>
						<div class="billing-form-wrap">
							<form action="#">
	
                                        <div class="single-input-item">
                                            <label for="f_name" class="required">Full Name Name</label>
                                            <input type="text" id="f_name" placeholder="Full Name" disabled value="${sessionScope.account.fullName}">
                                        </div>

                                <div class="single-input-item">
                                    <label for="l_eamil" class="required">Email Address</label>
                                    <input type="email" id="l_eamil" placeholder="Email Address" disabled value="${sessionScope.account.email}">
                                </div>
                               
                                <div class="single-input-item">
                                    <label for="Street_address" class="required"> Street address </label>
                                    <input type="text" id="Street_address" placeholder="Street address" disabled value="${sessionScope.account.address}">
                                </div>
                           
                                <div class="single-input-item">
                                    <label for="phone" class="required">Phone</label>
                                    <input type="text" id="phone" placeholder="Phone" disabled value="${sessionScope.account.phoneNo}">
                                </div>
                               
							</form>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="order-summary-details">
						<h2>Your Order Summary</h2>
						<div class="order-summary-content">
			<div class="order-summary-table table-responsive text-center">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Products</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${sessionScope.cart.item}" varStatus="loop">
                                        <tr>
                                            <td><a href="#" >${item.product.productName} <strong> × ${item.quantity}</strong></a></td>
                                            </td>
                                            <td>${item.cost}</td>
                                        </tr>
                                         </c:forEach>
                                      
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <td>Sub Total</td>
                                            <td><strong>${sessionScope.cart.total}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Shipping</td>
                                            <td class="d-flex justify-content-left">
                                                <ul class="shipping-type">
                                    
                                                    <li>
                                                        <div class="custom-control custom-radio">
                                                            <input type="radio" id="freeshipping" name="shipping" class="custom-control-input">
                                                            <label class="custom-control-label" for="freeshipping">Free
                                                                Shipping</label>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Total Amount</td>
                                            <td><strong>${sessionScope.cart.total}</strong></td>
                                        </tr>
                                    </tfoot>
                                </table>
                                <div class="form-group payment">
			                        <h4 class="deal-title">Payment Method</h4>
			                        <ul>
			                            <li><label class="inline"><input class="form-check-input" type="checkbox"><span class="input"></span>Direct Bank
			                                Transfer</label></li>
			                            <li><label class="inline"><input class="form-check-input" type="checkbox"><span class="input"></span>Cash on Delivery</label>
			                            </li>
			                            <li><label class="inline"><input class="form-check-input" type="checkbox"><span class="input"></span>Paypal</label>
			                            </li>
			                        </ul>
			                        <p class="credit">You can pay with your credit<br> card if you don't have a paypal account</p>
			                        <span class="grand-total">Grand Total :  <span>${sessionScope.cart.total}</span></span>
			                        <button type="submit" class="button-1">Place Order Now</button>
			                    </div>
                            </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>