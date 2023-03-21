<%-- 
    Document   : product
    Created on : Mar 3, 2023, 11:04:07 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">

    <div class="table-title">
      <div class="row">
        <div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
          <h2 class="ml-lg-2">Manage Product By Admin</h2>
        </div>
        <div class="col-sm-6 p-0 d-flex justify-content-lg-end justify-content-center">
          <a href="<c:url value="/admin/createProduct.do"/>" class="btn btn-success d-flex align-items-center" data-toggle="modal" style="margin-right: 10px">
		 <i class="fa-sharp fa-solid fa-plus" style="margin-right: 10px"></i><span>Add New Product</span></a>
          <a href="#deleteEmployeeModal" class="btn btn-danger d-flex align-items-center" data-toggle="modal">
		<i class="fa-sharp fa-solid fa-trash " style="margin-right: 10px"></i><span>Delete</span></a>
        </div>
      </div>
    </div>
                 <div class="table-container">
    <table class="table table-striped table-hover">
							<thead>
								<tr>
								<th >Thumbnail
								</th>
								<th>No.</th>
                                                                <th>Name</th>
                                                                <th>Price</th>
                                                                <th>Category</th>
                                                                <th>Brand</th>
                                                                <th>Description</th>
                                                                <th>Quantity</th>
                                                                <th>Operations</th>
                                                                
								</tr>
							</thead>
							
							<tbody>
                                                            <c:forEach items="${list}" var="product" varStatus="loop">
                                                                <tr>
                                                                    <td class="img-table"><img src="<c:url value="${product.imgSrc}" />" class="img-table"</td>
                                                                    <td>${product.productId}</td>
                                                                    <td>${product.productName}</td>
                                                                    <td>${product.price}</td>
                                                                    <td>${product.categoryName}</td>
                                                                    <td>${product.brandName}</td>
                                                                    <td>${product.description}</td>
                                                                    <td>${product.quantity}</td>
                                                                    <td><div class="operations">
                                                                            <a href="<c:url value="/admin/editProduct.do?id=${product.productId}"/>"><i class="fa-sharp fa-solid fa-pen text-warning"></i></a>
                                                                        <a href="<c:url value="/admin/upload_img.do?id=${product.productId}"/>"><i class="fa-sharp fa-solid fa-image"></i></a>
                                                                        <a href="<c:url value="/admin/deleteProduct.do?id=${product.productId}"/>"><i class="fa-sharp fa-solid fa-trash text-danger"></i></a>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
							</tbody>
                                                        
						</table>
                    </div> 
    <%--handle logic for the pagination --%>
     <c:if test="${numOfPages >= 1}">
            <c:set var="startPage" value="${currentPage - 5}"/>
            <c:if test="${startPage lt 1}">
                <c:set var="startPage" value="1"/>
            </c:if>
            <c:set var="endPage" value="${currentPage + 5}"/>
            <c:if test="${endPage gt numOfPages}">
                <c:set var="endPage" value="${numOfPages}"/>
            </c:if>
            <div class="pagination justify-content-center">
                <c:choose>
                    <c:when test="${currentPage gt 1}">
                        <button class="page-item"><a href="<c:url value='/admin/products.do?currentPage=${currentPage - 1}'/>" ><i class="fa-sharp fa-solid fa-arrow-left"></i></a></button>
                    </c:when>
                    <c:otherwise>
                        <button class="disabled page-item"><i class="fa-sharp fa-solid fa-arrow-left"></i></button>
                    </c:otherwise>
                </c:choose>
                <c:forEach begin="${startPage}" end="${endPage}" var="i">
                    <c:choose>
                        <c:when test="${i eq currentPage}">
                            <button class="actived"><a href="#"><c:out value="${i}"/></a></button>
                        </c:when>
                        <c:otherwise>
                            <button class="page-item"><a href="<c:url value='/admin/products.do?currentPage=${i}'/>"><c:out value="${i}"/></a></button>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${currentPage lt numOfPages}">
                        <button clas="page-item"><a href="<c:url value='/admin/products.do?currentPage=${currentPage + 1}'/>"><i class="fa-sharp fa-solid fa-arrow-right"></i></a></button>
                    </c:when>
                    <c:otherwise>
                    <button class="disabled page-item"><i class="fa-sharp fa-solid fa-arrow-right"></i></button>
                        </c:otherwise>
                            </c:choose>
          
            </div>
      </c:if>
</c:if>

							
