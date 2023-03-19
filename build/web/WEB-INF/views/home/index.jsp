<%-- 
    Document   : index
    Created on : Mar 1, 2023, 9:40:02 PM
    Author     : Admin
--%>


<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="utils.Utils" %>
 <!-- Start Hero Area -->
        <section class="hero-area">
            <div class="hero-area-full owl-carousel">
                <!-- Single -->
                <div
                    class="hero-slider-single"
                    style="background-image: url(https://www.nvidia.com/content/dam/en-zz/Solutions/geforce/ada/rtx-4090/geforce-rtx-4090-100vp-l@2x.jpg)"
                >
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="hero-slider-single-content">
                                    <h2>
                                        Leading Hand Tools 
                                        <span>Manufacturer</span>
                                    </h2>
                                    <p>
                                        Ostromi Is A Specialist Of Hand Tools
                                        Which Are
                                    </p>
                                    <a class="button-1" href="<c:url value="product/index.do"/>"
                                        >Shop Now</a
                                    >
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Single -->
                <div
                    class="hero-slider-single"
                    style="background-image: url(https://www.nvidia.com/content/dam/en/geforce/products/g-sync-monitors/geforce-gsync-hero-2560x770-d.jpeg)"
                >
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="hero-slider-single-content">
                                    <h2>
                                        Leading Hand Tools
                                        <span>Manufacturer</span>
                                    </h2>
                                    <p>
                                        Ostromi Is A Specialist Of Hand Tools
                                        Which Are
                                    </p>
                                    <a class="button-1" href="<c:url value="product/index.do"/>"
                                        >Shop Now</a
                                    >
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Hero Area -->
        <!-- Start banner Area -->
        <div class="banner-area container">
            <div class="row">
                <!-- Single -->
                <div class="col-lg-4 col-md-6 mb-30">
                    <div class="banner-item">
                        <a href="#">
                            <img src="https://i.dell.com/das/dih.ashx/1200w/sites/csimages/Product_Imagery/all/fp-aw-laptops-hero-a-1920x1440-v2.png" alt="img" />
                        </a>
                    </div>
                </div>
                <!-- Single -->
                <div class="col-lg-4 col-md-6 mb-30">
                    <div class="banner-item">
                        <a href="#">
                            <img src="https://i.ytimg.com/vi/UusyZKfMr6I/maxresdefault.jpg" alt="img" />
                        </a>
                    </div>
                </div>
                <!-- Single -->
                <div class="col-lg-4 col-md-6 mb-30">
                    <div class="banner-item">
                        <a href="#">
                            <img src="https://m.media-amazon.com/images/G/01/Audio/EchoFamilyDevices._CB1198675309_._TTW_.jpg" alt="img" />
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- End banner Area -->
        <!-- Start Product Style -->
        <section class="pb-50 pt-50">
            <div class="container">
                <div class="row">
                    <div class="product-tab-style product-tab-style-1">
                        <div class="row">
                            <div class="col-lg-6">
                                <h3 class="deal-title">Featured Products</h3>
                            </div>
                            <div class="col-lg-6">
                                <ul
                                    class="nav nav-tabs"
                                    id="myTab"
                                    role="tablist"
                                >
                                    <li class="nav-item" role="presentation">
                                        <span
                                            class="nav-link active"
                                            id="popular1-tab"
                                            data-bs-toggle="tab"
                                            data-bs-target="#popular1"
                                            role="tab"
                                            aria-controls="popular1"
                                            aria-selected="true"
                                            >Popular</span
                                        >
                                    </li>
                                    <li class="nav-item" role="presentation">
                                        <span
                                            class="nav-link"
                                            id="bastsaller1-tab"
                                            data-bs-toggle="tab"
                                            data-bs-target="#bastsaller1"
                                            role="tab"
                                            aria-controls="bastsaller1"
                                            aria-selected="false"
                                            >Best Saller</span
                                        >
                                    </li>
                                    <li class="nav-item" role="presentation">
                                        <span
                                            class="nav-link"
                                            id="featured1-tab"
                                            data-bs-toggle="tab"
                                            data-bs-target="#featured1"
                                            role="tab"
                                            aria-controls="featured1"
                                            aria-selected="false"
                                            >Featured</span
                                        >
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div
                            class="tab-content product-tab-full"
                            id="myTabContent"
                        >
                            <div
                                class="tab-pane product-tab-item fade show active"
                                id="popular1"
                                role="tabpanel"
                                aria-labelledby="popular1-tab"
                            >
                                <div
                                    class="product-tab-slider-full owl-carousel"
                                >

                                    <c:forEach items="${list}" var="product" varStatus="loop" end="10">
                                        <!-- Single -->
                                                                        <div class="product-single product-page">
                                            <div class="sale-badge">
                                                <span>sale</span>
                                            </div>
                                            <div class="product-thumbnail">
                                                <a href="<c:url value="/product/index.do?id=${product.productId}"/>"
                                                   ><img
                                                        src="<c:url value="${product.imgSrc}"/>"
                                                        alt="product"
                                                        /></a>
                                                <div
                                                    class="product-thumbnail-overly"
                                                    >
                                                    <ul>
                                                        <li>
                                                             <c:if test="${sessionScope.account.role == 'ROLE_CUSTOMER'}">
                                                                <a href="<c:url value="/cart?op=add&productId=${product.productId}"/>"><i
                                                                    class="fas fa-shopping-cart"
                                                                    ></i></a>
                                                             </c:if>
                                                            <c:if test="${sessionScope.account == null}">
                                                                <a href="<c:url value="/account/login.do" />"><i class="fa-regular fa-user"></i></a>
                                                             </c:if>

                                                        </li>
                                                        <li>
                                                            <a  href="<c:url value="/product/index.do?id=${product.productId}"/>"
                                                               ><i
                                                                    class="far fa-heart"
                                                                    ></i
                                                                ></a>
                                                        </li>
                                                        <li>
                                                            <a href="<c:url value="/product/index.do?id=${product.productId}"/>"
                                                               ><i
                                                                    class="far fa-eye"
                                                                    ></i
                                                                ></a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="product-content">
                                                <h4>
                                                    <a  href="<c:url value="/product/index.do?id=${product.productId}"/>"
                                                       >${product.productName}</a
                                                    >
                                                </h4>
                                                <div class="pricing">
                                                    <span
                                                        >$ ${product.price} <del>${product.price+Utils.getRandomNumber()}</del></span
                                                    >
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Product Style -->

        <!-- Start Sales Banner Area -->
        <div
            class="sales-banner pt-50 pb-50"
            style="background-image: url('https://softdevltd.com/demo/template/bulkshop/assets/img/sale-bnr-large.jpg')"
        >
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-8">
                        <div class="sales-banner-content">
                            <h3>
                                Saving up to <span>75% OFF</span> all items
                                first purchase!
                            </h3>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <a class="button-1 text-right" href="#"
                            >Use Code: Z381aC3</a
                        >
                    </div>
                </div>
            </div>
        </div>
        <!-- End Sales Banner Area -->

        <!-- Start Our Latest Product -->
        <section class="latest-product pt-70 pb-70">
            <div class="container">
                <!-- Section Title -->
                <div class="row">
                    <div class="col-12">
                        <div class="section-headding-1 mb-50">
                            <h2><span>Latest Products</span></h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="latest-product-full owl-carousel">
                             <c:forEach items="${list}" var="product" varStatus="loop"  begin="11" end="14">
                                        <!-- Single -->
                                <div class="product-single product-page">
                                         <div class="sale-badge">
                                             <span>sale</span>
                                         </div>
                                         <div class="product-thumbnail">
                                             <a href="<c:url value="/product/index.do?id=${product.productId}"/>"
                                                ><img
                                                     src="<c:url value="${product.imgSrc}"/>"
                                                     alt="product"
                                                     /></a>
                                             <div
                                                 class="product-thumbnail-overly"
                                                 >
                                                 <ul>
                                                     <li>
                                                          <c:if test="${sessionScope.account.role == 'ROLE_CUSTOMER'}">
                                                             <a href="<c:url value="/cart?op=add&productId=${product.productId}"/>"><i
                                                                 class="fas fa-shopping-cart"
                                                                 ></i></a>
                                                          </c:if>
                                                         <c:if test="${sessionScope.account == null}">
                                                             <a href="<c:url value="/account/login.do" />"><i class="fa-regular fa-user"></i></a>
                                                          </c:if>

                                                     </li>
                                                     <li>
                                                         <a  href="<c:url value="/product/index.do?id=${product.productId}"/>"
                                                            ><i
                                                                 class="far fa-heart"
                                                                 ></i
                                                             ></a>
                                                     </li>
                                                     <li>
                                                         <a href="<c:url value="/product/index.do?id=${product.productId}"/>"
                                                            ><i
                                                                 class="far fa-eye"
                                                                 ></i
                                                             ></a>
                                                     </li>
                                                 </ul>
                                             </div>
                                         </div>
                                         <div class="product-content">
                                             <h4>
                                                 <a  href="<c:url value="/product/index.do?id=${product.productId}"/>"
                                                    >${product.productName}</a
                                                 >
                                             </h4>
                                             <div class="pricing">
                                                 <span
                                                     >$ ${product.price} <del>${product.price+Utils.getRandomNumber()}</del></span
                                                 >
                                             </div>
                                         </div>
                                     </div>     
                             </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Our Latest Product -->

        <!-- Start Deal Product -->
        <section class="deal-product pt-70 pb-70 section-bg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="deal-popular-product">
                            <h3 class="deal-title">Popular items</h3>
                            <div class="deal-popular-product-all">
                                <!-- Singel -->
                               <c:forEach items="${list}" var="product" varStatus="loop" begin="15" end="19" >
                                    <div class="deal-popular-product-single">
                                    <img
                                        src="<c:url value="${product.imgSrc}"/>"
                                        alt="product"
                                    />
                                    <div class="content">
                                        <h5>
                                            <a href="<c:url value="/cart?op=add&productId=${product.productId}"/>"
                                                >${product.productName}</a
                                            >
                                        </h5>
                                        <div class="pricing">
                                          <span
                                                        >$ ${product.price} <del>$<%= Utils.getRandomNumber() %></del></span
                                                    >
                                        </div>
                                    </div>
                                </div>
                                </c:forEach>
                        
                                <div
                                    class="deal-popular-product-single read-btn"
                                >
                                    <a href="<c:url value="/home/product.do" />">View More +</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="deal-product-slider">
                            <h3 class="deal-title">Hot Deal Of the Week</h3>
                            <div class="deal-product-slider-full">
                                <!-- Single -->
                                <div class="deal-product-slider-single">
                                    <div class="row">
                                        <div class="col-lg-5 col-md-6">
                                            <c:forEach items="${list}" var="product" varStatus="loop" end="0">
                                            <div
                                                class="deal-product-slider-single-img"
                                            >
                                                <img
                                                    src="<c:url value="${product.imgSrc}"/>"
                                                    alt="product"
                                                />
                                            </div>
                                        </div>
                                        <div class="col-lg-7 col-md-6">
                                            <div
                                                class="deal-product-slider-single-content"
                                            >
                                                <div class="left">
                                                    <div
                                                        class="count-time"
                                                        id="eShopCountdown"
                                                        data-countdown-codepopular="2023/03/21"
                                                    >
                                                        <ul>
                                                            <li>
                                                                %d<span
                                                                    >Days</span
                                                                >
                                                            </li>
                                                            <li>
                                                                %h
                                                                <span
                                                                    >Hours</span
                                                                >
                                                            </li>
                                                            <li>
                                                                %m
                                                                <span
                                                                    >Minits</span
                                                                >
                                                            </li>
                                                            <li>
                                                                %s
                                                                <span
                                                                    >Days</span
                                                                >
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="right">
                                                    <h3>
                                                        <a href="#"
                                                            >${product.productName}</a
                                                        >
                                                    </h3>
                                                    <div class="ratting">
                                                        <span
                                                            ><i
                                                                class="fas fa-star"
                                                            ></i
                                                        ></span>
                                                        <span
                                                            ><i
                                                                class="fas fa-star"
                                                            ></i
                                                        ></span>
                                                        <span
                                                            ><i
                                                                class="fas fa-star"
                                                            ></i
                                                        ></span>
                                                        <span
                                                            ><i
                                                                class="fas fa-star"
                                                            ></i
                                                        ></span>
                                                        <span
                                                            ><i
                                                                class="fas fa-star"
                                                            ></i
                                                        ></span>
                                                    </div>
                                                    <div class="pricing">
                                                         <span>$ ${product.price} <del>${product.price+Utils.getRandomNumber()}</del></span>
                                                    </div>
                                                    <p>
                                                        ${product.description}
                                                    </p>
                                                    <a
                                                        class="button-1"
                                                     <a  href="<c:url value="/product/index.do?id=${product.productId}"/>"
                                                        >Shop Now</a
                                                    >
                                                </div>
                                            </div>
                                        </div>
                                            </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
 

      
  

        
