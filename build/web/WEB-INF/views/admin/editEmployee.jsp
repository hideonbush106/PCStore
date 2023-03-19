<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
        <form action="<c:url value="/admin/edit_handlerProduct.do"/>">
   <div class="container-fluid">
        <div class="container">
        <!-- Title -->
                <div
                    class="d-flex justify-content-between align-items-lg-center py-3 flex-column flex-lg-row"
                >
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
                                <h2 class="ml-lg-2">Edit Employee Info</h2>
                              </div>
                              <div class="col-sm-6 p-0 d-flex justify-content-lg-end justify-content-center">
                                <button  type="submit" name="op" value="update" class="btn btn-success d-flex align-items-center"style="margin-right: 10px">
                                    <i class="fa-sharp fa-solid fa-plus" style="margin-right: 10px"></i><span>Edit</span></button>
                                <button  type="submit" name="op" value="cancel" class="btn btn-danger d-flex align-items-center">
                                      <i class="fa-sharp fa-solid fa-trash " style="margin-right: 10px"></i><span>Cancel</span></button>
                            </div>
                        </div>
                    </div>
        </div>
     

        <!-- Main content -->
        <div class="row">
            <!-- Left side -->
            <div class="col-lg-8">
                <!-- Basic information -->
                <div class="card mb-4">
                    <div class="card-body">
                        <h3 class="h6 mb-4">Basic information</h3>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="mb-3">
                                    <label class="form-label">Employee ID</label>
                                   <input type="text" readonly name="employeeId" value="${employee.employeeId}" class="form-control"/><br/>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="mb-3">
                                    <label class="form-label">Employee Name:</label>
                                   <input type="text" readonly name="empName" value="${employee.empName}" class="form-control"/><br/>
                                </div>
                            </div>
                        </div>
                            <div class="col-lg-12">
                                <div class="mb-3">
                                    <label class="form-label">Salary</label>
                                   <input type="number" min="0" name="salary" value="${employee.salary}" class="form-control"/><br/>
                                </div>
                            </div>
                            

                    </div>
                </div>
              
            </div>
    </div>
</div>
                                  </form
                             

</c:if>