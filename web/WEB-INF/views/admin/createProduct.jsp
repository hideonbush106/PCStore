<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <form action="<c:url value="/admin/create_handlerProduct.do"/>">
        <div class="container-fluid">
            <div class="container">
                <!-- Title -->
                <div
                    class="d-flex justify-content-between align-items-lg-center py-3 flex-column flex-lg-row"
                    >
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
                                <h2 class="ml-lg-2">Create Product</h2>
                            </div>
                            <div class="col-sm-6 p-0 d-flex justify-content-lg-end justify-content-center">
                                <button  type="submit" name="op" value="create" class="btn btn-success d-flex align-items-center"style="margin-right: 10px">
                                    <i class="fa-sharp fa-solid fa-plus" style="margin-right: 10px"></i><span>Create</span></button>
                                <button  type="submit" name="op" value="cancel" class="btn btn-danger d-flex align-items-center">
                                    <i class="fa-sharp fa-solid fa-trash " style="margin-right: 10px"></i><span>Cancel</span></button>
                            </div>
                        </div>
                    </div>
                </div>

                <i>${message}</i>
                <!-- Main content -->
                <div class="row">
                    <!-- Left side -->
                    <div class="col-lg-8">
                        <!-- Basic information -->
                        <div class="card mb-4">
                            <div class="card-body">
                                <h3 class="h6 mb-4">Basic information</h3>

                                <div class="col-lg-12">
                                    <div class="mb-3">
                                        <label class="form-label">Product Name</label>
                                        <input value="${product.productName}" type="text" name="productName" class="form-control"/>
                                    </div>
                                </div>

                                <div class="col-lg-12">
                                    <div class="mb-3">
                                        <label class="form-label">Product Price</label>
                                        <input value="${product.price}" type="number" step="0.1" name="price" min="0" class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="mb-3">
                                        <label class="form-label"
                                               >Product Description</label
                                        >
                                        <textarea  type="text" name="description" class="form-control">${product.description}</textarea>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="mb-3">
                                        <label class="form-label"
                                               >Product Quantity</label
                                        >
                                        <textarea  type="text" name="quantity" class="form-control">${product.quantity}</textarea>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <!-- Address -->
                        <div class="card mb-4">
                            <div class="card-body">
                                <h3 class="h6 mb-4">Category and Brand</h3>
                                <div class="mb-3">
                                    <label class="form-label">Brand</label>
                                    <select
                                        name="brandId"
                                        class="select2 form-control select2-hidden-accessible"
                                        data-select2-placeholder="Select country"
                                        data-select2-id="select2-data-1-gy14"
                                        tabindex="-1"
                                        aria-hidden="true"
                                        >
                                        <c:forEach items="${brandList}" var="brand">
                                            <option value="${brand.brandId}" ${brand.brandId == product.brandId?"selected":""}>${brand.name}</option>
                                        </c:forEach></select><span
                                        class="select2 select2-container select2-container--bootstrap-5"
                                        dir="ltr"
                                        data-select2-id="select2-data-2-46y9"
                                        style="width: 391px"
                                        ><span class="selection"
                                           ><span
                                                class="select2-selection select2-selection--single"
                                                role="combobox"
                                                aria-haspopup="true"
                                                aria-expanded="false"
                                                tabindex="0"
                                                aria-disabled="false"
                                                aria-labelledby="select2-vp8l-container"
                                                aria-controls="select2-vp8l-container"
                                                ><span
                                                    class="select2-selection__rendered"
                                                    id="select2-vp8l-container"
                                                    role="textbox"
                                                    aria-readonly="true"
                                                    title="Select country"
                                                    ><span
                                                        class="select2-selection__placeholder"
                                                        >Select Product's Brand</span
                                                    ></span
                                                ><span
                                                    class="select2-selection__arrow"
                                                    role="presentation"
                                                    ><b
                                                        role="presentation"
                                                        ></b></span></span></span
                                        ><span
                                            class="dropdown-wrapper"
                                            aria-hidden="true"
                                            ></span
                                        ></span>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Category</label>
                                    <select
                                        name="categoryId"
                                        class="select2 form-control select2-hidden-accessible"
                                        data-select2-placeholder="Select country"
                                        data-select2-id="select2-data-1-gy14"
                                        tabindex="-1"
                                        aria-hidden="true"
                                        >
                                        <c:forEach items="${categoryList}" var="category">
                                            <option value="${category.categoryId}" ${category.categoryId == product.categoryId?"selected":""}>${category.name}</option>
                                        </c:forEach></select><span
                                        class="select2 select2-container select2-container--bootstrap-5"
                                        dir="ltr"
                                        data-select2-id="select2-data-2-46y9"
                                        style="width: 391px"
                                        ><span class="selection"
                                           ><span
                                                class="select2-selection select2-selection--single"
                                                role="combobox"
                                                aria-haspopup="true"
                                                aria-expanded="false"
                                                tabindex="0"
                                                aria-disabled="false"
                                                aria-labelledby="select2-vp8l-container"
                                                aria-controls="select2-vp8l-container"
                                                ><span
                                                    class="select2-selection__rendered"
                                                    id="select2-vp8l-container"
                                                    role="textbox"
                                                    aria-readonly="true"
                                                    title="Select country"
                                                    ><span
                                                        class="select2-selection__placeholder"
                                                        >Select Product's Brand</span
                                                    ></span
                                                ><span
                                                    class="select2-selection__arrow"
                                                    role="presentation"
                                                    ><b
                                                        role="presentation"
                                                        ></b></span></span></span
                                        ><span
                                            class="dropdown-wrapper"
                                            aria-hidden="true"
                                            ></span 
                                        ></span>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>


                <script>
                    const imageUpload = document.querySelector('#image-upload');
                    const imagePreview = document.querySelector('#image-preview');

                    imageUpload.addEventListener('change', () => {
                        imagePreview.innerHTML = ''; // clear previous preview
                        for (let i = 0; i < imageUpload.files.length; i++) {
                            const file = imageUpload.files[i];
                            const img = document.createElement('img');
                            img.src = URL.createObjectURL(file);
                            img.classList.add('preview-image');
                            imagePreview.appendChild(img);
                        }
                    });
                </script>
            </div>
    </form




</c:if>