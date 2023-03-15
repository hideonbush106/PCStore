<%-- 
    Document   : login
    Created on : Mar 1, 2023, 10:15:00 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html  class="no-js" lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>BulkShop - Electronics Shop HTML Template | Login</title>
        <link rel="icon" href="<c:url value="/assets/img/icon.png"/>" type="image/gif" sizes="16x16">
        <link rel="icon" href="<c:url value="/assets/img/icon.png"/>" type="image/gif" sizes="18x18">
        <link rel="icon" href="<c:url value="/assets/img/icon.png"/>" type="image/gif" sizes="20x20">

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js" integrity="sha512-bPs7Ae6pVvhOSiIcyUClR7/q2OAsRiovw4vAkX+zJbw3ShAeeqezq50RIIcIURq7Oa20rW2n2q+fyXBNcU9lrw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css"/>" type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/responsive.css"/>" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div id="preloader" class="preeloader">
		<div class="sk-circle">
		  <div class="sk-circle1 sk-child"></div>
		  <div class="sk-circle2 sk-child"></div>
		  <div class="sk-circle3 sk-child"></div>
		  <div class="sk-circle4 sk-child"></div>
		  <div class="sk-circle5 sk-child"></div>
		  <div class="sk-circle6 sk-child"></div>
		  <div class="sk-circle7 sk-child"></div>
		  <div class="sk-circle8 sk-child"></div>
		  <div class="sk-circle9 sk-child"></div>
		  <div class="sk-circle10 sk-child"></div>
		  <div class="sk-circle11 sk-child"></div>
		  <div class="sk-circle12 sk-child"></div>
		</div>
	</div>
	<div class="off_canvars_overlay"></div>
	<!-- Header -->
	<header class="header">
		<!-- Header Top -->
		<div class="header-top">
			<div class="container">
				<div class="row">
                                            <div class="col-lg-5">
						<div class="top-text">
							<p>Welcome to Electronics Shop</p>
						</div>
					</div>
					<div class="col-lg-7">
						<div class="top-list">
							<a href="#"><i class="fas fa-mobile-alt"></i> +02456 054546</a>
							<a href="wishlist.html"><i class="far fa-heart"></i> Wishlist</a>
							<a href="login.html"><i class="fas fa-user"></i> Login / Register</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Header Middle -->
		<div class="header-middle pt-30 pb-30">
			<div class="container">
				<div class="row">
					<!-- Logo -->
					<div class="col-lg-2">
						<div class="logo">
                                                    <h2><a href="<c:url value="index.jsp"/>"><img src="<c:url value="/assets/img/logo.png"/>"></a></h2>
						</div>
					</div>
					<!-- Search Bar -->
					<div class="col-lg-8">
						<div class="header-search-form">
							<form action="#">
								<input type="search" name="search" placeholder="Search keyword here...">
								<button type="submit"><i class="fas fa-search"></i></button>
							</form>
						</div>	
					</div>
					<!-- MiniCart -->
					<div class="col-lg-2">
						<div class="desktop-mini-cart">
							<div class="mini-cart">
								<div class="mini-cart-icon">
									<i class="fas fa-shopping-cart"></i>
									<span class="counter">02</span>
									<span class="counter-cart"><small>Your Cart</small>$10.00</span>
									 <!-- Mini Cart Content -->
									 <div class="minicart-content-wrapper">
									 	<ul class="cart-list-full">
									 		<!-- Single -->
									 		<li class="cart-list-single">
                                                                                            <img src="<c:url value="/assets/img/product/1.jpg"/>" alt="img">
									 			<h5><a href="#">simple product</a></h5>
									 			<span class="price">$120</span>
									 			<div class="close"><i class="fas fa-times"></i></div>
									 		</li>
									 		
									 	</ul>
									 	<h2 class="subtotal">Subtotal : <span>$220</span></h2>
									 	<div class="minicart-btn">
									 		<a class="button-1" href="cart.html">View Cart</a>
									 		<a class="button-2" href="#">Checkout</a>
									 	</div>
									 </div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Header Bottom -->
		<div class="header-bottm">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="logo-2">
                                                    <h2><a href="<c:url value="index.jsp"/>"><img src="<c:url value="/assets/img/logo.png"/>"></a></h2>
						</div>
						<div class="canvas_open">
					        <a href="javascript:void(0)"><i class="fas fa-bars"></i></a>
					    </div>
					    <div class="mobile-mini-cart">
							<div class="mini-cart">
								<div class="mini-cart-icon">
									<i class="fas fa-shopping-cart"></i>
									<span class="counter">02</span>
									<span class="counter-cart"><small>Your Cart</small>$10.00</span>
									 <!-- Mini Cart Content -->
									 <div class="minicart-content-wrapper">
									 	<ul class="cart-list-full">
									 		
									 		
									 	</ul>
									 	<h2 class="subtotal">Subtotal : <span>$220</span></h2>
									 	<div class="minicart-btn">
									 		<a class="button-1" href="cart.html">View Cart</a>
									 		<a class="button-2" href="#">Checkout</a>
									 	</div>
									 </div>
								</div>
							</div>
						</div>
						<div class="menu">
							<nav>
								<ul>
                                                                    <li><a href="<c:url value="/home/index.do"/>">Home</a></li>
									<li><a href="about.html">About</a></li>
						
									<li><a href="shop.html">Shop <i class="fa fa-angle-down"></i></a>
										<ul class="submenu-item">
											<li><a href="shop.html">Shop</a></li>
											<li><a href="shop2-columns.html">Shop 2 Columns</a></li>
											<li><a href="shop-grid.html">Shop Grid</a></li>
											<li><a href="shop-left-sidebar.html">Shop Left Sidebar</a></li>
											<li><a href="shop-list.html">Shop List</a></li>
										</ul>
									</li>
									<li><a href="contact.html">Contact</a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Header -->

	<!-- Start Mobile Menu Area -->
	<div class="mobile-menu-area">
		
		<!--offcanvas menu area start-->
	    <div class="off_canvars_overlay">
	                
	    </div>
	    <div class="offcanvas_menu">
	        <div class="offcanvas_menu_wrapper">
	            <div class="canvas_close">
	                <a href="javascript:void(0)"><i class="fas fa-times"></i></a>  
	            </div>
	            <div class="mobile-logo">
                        <h2><a href="<c:url value="index.jsp"/>"><img src="<c:url value="/assets/img/logo.png" />"></a></h2>
	            </div>
	            <div id="menu" class="text-left ">
	                <ul class="offcanvas_main_menu">
	                    <li class="menu-item-has-children">
	                        <a href="<c:url value="index.jsp"/>">Home</a>
	                    </li>
	                    <li class="menu-item-has-children">
	                        <a href="about.html">about Us</a>
	                    </li>
	                    
	                    <li class="menu-item-has-children">
	                        <a href="#">Shop</a>
	                        <ul class="sub-menu">
	                        	<li><a href="shop.html">Shop</a></li>
								<li><a href="shop2-columns.html">Shop 2 Columns</a></li>
								<li><a href="shop-grid.html">Shop Grid</a></li>
								<li><a href="shop-left-sidebar.html">Shop Left Sidebar</a></li>
								<li><a href="shop-list.html">Shop List</a></li>
	                        </ul>
	                    </li>
	                  
	                    <li class="menu-item-has-children">
	                        <a href="contact.html"> Contact Us</a> 
	                    </li>
	                </ul>
	            </div>
	        </div>
	    </div>
    </div>
    <!--offcanvas menu area end-->
	<!-- End Mobile Menu Area -->
	<!-- Start BreadCrumb Area -->
	<div class="breadcrumb-area pt-100 pb-100" >
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb-content">
						<h2>Login</h2>
						<ul>
                                                    <li><a href="<c:url value="index.jsp"/>">Home</a></li>
							<li class="active">Login</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End BreadCrumb Area -->

	<!-- Start Login Register Form -->
	<div class="login-register-form pt-70 pb-70">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="login-register-form-full">
						<h3>Login</h3>
						<form action="<c:url value="/account/login_handler.do"/>">
							<input  type="email" name="email" placeholder="Enter email" class="form-control">
							<input type="password" name="password" placeholder="Enter password" class="form-control">
							<div class="row">
								<div class="col-6">
									<div class="form-check">
  										<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
  										<label class="form-check-label" for="flexCheckDefault">Remember me</label>
  									</div>
								</div>
								<div class="col-6 text-right">
									<a href="reset-password.html">Forgot password?</a>
								</div>
							</div>
                                                        <div class="d-flex align-items-center justify-content-between">
							<button class="button-1"  class="form-control" type="submit" value="login" name="op">Log In</button>
                                                        </div>
						</form>
                                                        <i>${message}</i>
                                                        <p>Don't Have an Account? Please  <a href="<c:url value="/account/register.do" />">Sign Up now</a></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Login Register Form -->

	<!-- Start Footer Area -->
	<footer class="footer">
		<!-- Footer Top -->
		<div class="footer-top pt-50">
			<div class="container">
				<div class="row">
					<!-- SIngle -->
					<div class="col-lg-3 col-md-6 mb-30">
						<div class="footer-widgets-single">
							<h2></h2>
							<p> Lorem ipsum dolor sit amet, consectetuipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqut enim ad minim veniamquis </p>
						</div>
					</div>
					<!-- SIngle -->
					<div class="col-lg-3 col-md-6 mb-30">
						<div class="footer-widgets-single">
							<h3>My account</h3>
							<ul>
								<li><a href="#">Sign In</a></li>
								<li><a href="#">View Cart</a></li>
								<li><a href="#">My Wishlist</a></li>
								<li><a href="#">Terms & Conditions</a></li>
								<li><a href="#">Contact us</a></li>
								<li><a href="#">Track My Order</a></li>
							</ul>
						</div>
					</div>
					<!-- SIngle -->
					<div class="col-lg-3 col-md-6 mb-30">
						<div class="footer-widgets-single">
							<h3>Categories</h3>
							<ul>
								<li><a href="#">Home Audio & Theater</a></li>
								<li><a href="#">TV & Video</a></li>
								<li><a href="#">Camera, Photo & Video</a></li>
								<li><a href="#">Cell Phones & Accessories</a></li>
								<li><a href="#">Headphones</a></li>
								<li><a href="#">Video Games</a></li>
							</ul>
						</div>
					</div>
					<!-- SIngle -->
					<div class="col-lg-3 col-md-6 mb-30">
						<div class="footer-widgets-single">
							<h3>Newsletter</h3>
							<p> Get notified of new products, limited releases, and more. </p>
							<form action="#">
								<input type="email" name="email" placeholder="Your Email">
								<button type="submit" class="button-1">Subscribe</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-bottom pt-30 pb-30">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="copyright-text">
							<p> &copy; Copyright 2021 <a href="https://codepopular.com" target="_blank">CodePopular</a> All Rights Reserved. </p>
						</div>
					</div>
					<div class="col-md-6">
						<ul class="footer_payment">
	                       
	                    </ul>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- End Footer Area -->
	


	<div class="scroll-area">
       <i class="fa fa-angle-up"></i>
    </div>


    <!-- Js File -->
    <script src="<c:url value="/assets/js/modernizr.min.js"/>"></script>
    <script src="<c:url value="/assets/js/jquery-3.5.1.min.js"/>"></script>
    <script src="<c:url value="/assets/js/popper.min.js"/>"></script>
    <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/assets/js/owl.carousel.min.js"/>"></script>
    <script src="<c:url value="/assets/js/jquery.nav.min.js"/>"></script>
    <script src="<c:url value="/assets/js/jquery.magnific-popup.min.js"/>"></script>
    <script src="<c:url value="/assets/js/mixitup.min.js"/>"></script>
    <script src="<c:url value="/assets/js/wow.min.js"/>"></script>
    <script src="<c:url value="/assets/js/script.js"/>"></script>
    <script src="<c:url value="/assets/js/mobile-menu.js"/>"></script>
</body>
</html>
