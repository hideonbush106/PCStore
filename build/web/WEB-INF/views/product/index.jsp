<%-- 
    Document   : index
    Created on : Mar 2, 2023, 1:41:38 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="utils.Utils" %>
<!-- Start Shop Area -->
<section class="shop-area pt-70 pb-70">
    <div class="container">

        <!-- Product Details -->
        <div class="row">
            <div class="col-md-5 col-lg-6">
                <div class="modal_tab">  
                    <div class="tab-content product-details-large">
                        <div class="tab-pane fade show active" id="detailstab1" role="tabpanel" >
                            <div class="modal_tab_img">
                                <a href="#"><img src="<c:url value="${product.imgSrc}"/>"alt="img"></a>    
                            </div>
                        </div>
                        <%-- <div class="tab-pane fade" id="detailstab2" role="tabpanel">
                              <div class="modal_tab_img">
                                  <a href="#"><img src="<c:url value="${product.imgSrc}"/>"alt="img"></a>    
                              </div>
                          </div>
                          <div class="tab-pane fade" id="detailstab3" role="tabpanel">
                              <div class="modal_tab_img">
                                  <a href="#"><img src="assets/img/product/3.jpg" alt="img"></a>    
                              </div>
                          </div>
                          <div class="tab-pane fade" id="detailstab4" role="tabpanel">
                              <div class="modal_tab_img">
                                  <a href="#"><img src="assets/img/product/4.jpg" alt="img"></a>    
                              </div>
                          </div>
                          <div class="tab-pane fade" id="detailstab5" role="tabpanel">
                              <div class="modal_tab_img">
                                  <a href="#"><img src="assets/img/product/5.jpg" alt="img"></a>    
                              </div>
                          </div>
                        --%>
                    </div>
                    <div class="modal_tab_button">    
                        <ul class="nav product_navactive owl-carousel" role="tablist">
                            <li >
                                <a class="nav-link active" data-toggle="tab" href="#detailstab1" role="tab" aria-controls="detailstab1" aria-selected="false"><img src="assets/img/product/1.jpg" alt="img"></a>
                            </li>
                            <li>
                                <a class="nav-link" data-toggle="tab" href="#detailstab2" role="tab" aria-controls="detailstab2" aria-selected="false"><img src="assets/img/product/2.jpg" alt="img"></a>
                            </li>
                            <li>
                                <a class="nav-link button_three" data-toggle="tab" href="#detailstab3" role="tab" aria-controls="detailstab3" aria-selected="false"><img src="assets/img/product/3.jpg" alt="img"></a>
                            </li>
                            <li>
                                <a class="nav-link" data-toggle="tab" href="#detailstab4" role="tab" aria-controls="detailstab4" aria-selected="false"><img src="assets/img/product/4.jpg" alt="img"></a>
                            </li>
                            <li>
                                <a class="nav-link" data-toggle="tab" href="#detailstab5" role="tab" aria-controls="detailstab5" aria-selected="false"><img src="assets/img/product/5.jpg" alt="img"></a>
                            </li>

                        </ul>
                    </div>    
                </div>
            </div>
            <div class="col-md-7 col-lg-6">
                <div class="product-details-img-full">
                    <h2>${product.productName} </h2>
                    <div class="pricing">
                        <span>$200 <del>$210</del></span>
                    </div>
                    <div class="ratting">
                        <span><i class="fas fa-star"></i></span>
                        <span><i class="fas fa-star"></i></span>
                        <span><i class="fas fa-star"></i></span>
                        <span><i class="fas fa-star"></i></span>
                        <span><i class="fas fa-star"></i></span>
                    </div>
                    <p>Category:${product.categoryId}</p>
                    <p>Brand:${product.brandId}</p>

                    <div class="modal_add_to_cart">
                        <form action="#">
                            <span class="quantity">
                                <input type="number" min="1" max="1000" step="1" value="1">
                            </span>
                            <button class="button-1" type="submit">add to cart</button>
                        </form>
                    </div>
                    <h3>Share This Product</h3>
                    <ul class="share-product">
                        <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                        <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                        <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fab fa-linkedin"></i></a></li>
                        <li><a href="#"><i class="fab fa-pinterest"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row mt-50 section-bg">
            <div class="shop-details-full-content">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="Description-tab" data-bs-toggle="tab" data-bs-target="#Description" type="button" role="tab" aria-controls="Description" aria-selected="true">Description</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="Review-tab" data-bs-toggle="tab" data-bs-target="#Review" type="button" role="tab" aria-controls="Review" aria-selected="false">Review</button>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="Description" role="tabpanel" aria-labelledby="Description-tab">
                        <p>${product.description}</p>
                    </div>
                    <div class="tab-pane fade" id="Review" role="tabpanel" aria-labelledby="Review-tab">
                        <div class="product-review">
                            <div class="product-review-list">
                                <h3>2 Review For Blue Dress For Woman</h3>
                                <ul>
                                    <!-- Single -->
                                    <li class="review-single">
                                        <img src="assets/img/avata-admin.jpg" alt="avatar">
                                        <div class="review-info">
                                            <h5>Alea Brooks</h5>
                                            <small> Jun 01, 2021 </small>
                                        </div>
                                        <div class="ratting">
                                            <span><i class="fas fa-star"></i></span>
                                            <span><i class="fas fa-star"></i></span>
                                            <span><i class="fas fa-star"></i></span>
                                            <span><i class="fas fa-star"></i></span>
                                            <span><i class="fas fa-star"></i></span>
                                        </div>
                                        <div class="revie-con">
                                            <p>Lorem Ipsumin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate</p>
                                        </div>
                                    </li>
                                    <!-- Single -->
                                    <li class="review-single">
                                        <img src="assets/img/avata-admin.jpg" alt="avatar">
                                        <div class="review-info">
                                            <h5>Alea Brooks</h5>
                                            <small> Jun 01, 2021 </small>
                                        </div>
                                        <div class="ratting">
                                            <span><i class="fas fa-star"></i></span>
                                            <span><i class="fas fa-star"></i></span>
                                            <span><i class="fas fa-star"></i></span>
                                            <span><i class="fas fa-star"></i></span>
                                            <span><i class="fas fa-star"></i></span>
                                        </div>
                                        <div class="revie-con">
                                            <p>Lorem Ipsumin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <!-- Form -->
                            <div class="product-review-form">
                                <h3>Add a review</h3>
                                <div class="ratting">
                                    <span><i class="fas fa-star"></i></span>
                                    <span><i class="fas fa-star"></i></span>
                                    <span><i class="fas fa-star"></i></span>
                                    <span><i class="fas fa-star"></i></span>
                                    <span><i class="fas fa-star"></i></span>
                                </div>
                                <form action="#">
                                    <textarea name="review-message" class="form-control" placeholder="Your Review"></textarea>
                                    <input type="text" name="name" class="form-control" placeholder="Your Name">
                                    <input type="email" name="email" class="form-control" placeholder="Your Email">
                                    <button type="submit">Submit Review</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>
<!-- End Shop Area -->
<!-- Start Our Latest Product -->
<section class="latest-product pt-70 pb-70 section-bg">
    <div class="container">
        <!-- Section Title -->
        <div class="row">
            <div class="col-12">
                <div class="section-headding-1 mb-50">
                    <h2><span>Releted Products</span></h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="latest-product-full owl-carousel">
                    <!-- Single -->
                    <c:forEach items="${list}" var="product" varStatus="loop" end="10">
                        <!-- Single -->
                        <div class="product-single product-page">
                            <div class="sale-badge">
                                <span>sale</span>
                            </div>
                            <div class="product-thumbnail">
                                <a href="product-details.html"
                                   ><img
                                        src="<c:url value="${product.imgSrc}"/>"
                                        alt="product"
                                        /></a>
                                <div
                                    class="product-thumbnail-overly"
                                    >
                                    <ul>
                                        <li>
                                            <a href="cart.html"
                                               ><i
                                                    class="fas fa-shopping-cart"
                                                    ></i
                                                ></a>
                                        </li>
                                        <li>
                                            <a href="wishlist.html"
                                               ><i
                                                    class="far fa-heart"
                                                    ></i
                                                ></a>
                                        </li>
                                        <li>
                                            <a href="#"
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
                                    <a href="product-details.html"
                                       >${product.productName}</a
                                    >
                                </h4>
                                <div class="pricing">
                                    <span
                                                        >$ ${product.price} <del>$<%= Utils.getRandomNumber() %></del></span
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