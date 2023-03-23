<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : index
    Created on : Mar 3, 2023, 10:59:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <main class="dash-content">
        <div class="container-fluid">
            <div class="row dash-row">
                <div class="col-xl-4">
                    <div class="stats stats-primary ">
                        <h3 class="stats-title"> All Time Revenue </h3>
                        <div class="stats-content">
                            <div class="stats-icon">
                                <i class="fas fa-cart-arrow-down"></i>
                            </div>
                            <div class="stats-data">

                 
                                <div class="stats-number">$${alltime.cost}</div>
                                <%--<div class="stats-change">
                                    <span class="stats-percentage">17.5%</span>
                                    <span class="stats-timeframe">from last month</span> --%>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-4">
                    <div class="stats stats-success">
                        <h3 class="stats-title"> Revenue from   </h3>
                        <div class="stats-content">
                            <div class="stats-icon">
                                <i class="fas fa-cart-arrow-down"></i>
                            </div>
                            <div class="stats-data">
                                <c:forEach var="revenue" items="${list}" varStatus="loop">

                                    <c:if test="${revenue != null}">
                                        <c:set var="totalcost" value="${totalcost + revenue.cost}" />
                                        <c:set var="totalquantity" value="${totalquantity + revenue.quantity}" />
                                    </c:if>
                                    <c:if test="${revenue == null}">
                                        <c:set var="totalcost" value="${0}" />
                                        <c:set var="totalquantity" value="${0}" />
                                    </c:if>

                                </c:forEach>
                                <div class="stats-number">$${totalcost}</div>
                                <%--<div class="stats-change">
                                    <span class="stats-percentage">17.5%</span>
                                    <span class="stats-timeframe">from last month</span> --%>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-4">
                    <div class="stats stats-danger">
                        <h3 class="stats-title"> Products bought </h3>
                        <div class="stats-content">
                            <div class="stats-icon">
                                <i class="fa-solid fa-box"></i>
                            </div>
                            <div class="stats-data">
                                <div class="stats-number">${totalquantity}</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="col-xl-6">
                <div class="card spur-card">
                    <div class="card-header">
                        <div class="spur-card-icon">
                            <i class="fas fa-chart-bar"></i>
                        </div>
                        <div class="spur-card-title"> Bar Chart </div>
                        <div class="spur-card-menu">
                            <div class="dropdown show">
                                <a class="spur-card-menu-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                </a>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
                                    <a class="dropdown-item" href="#">Action</a>
                                    <a class="dropdown-item" href="#">Another action</a>
                                    <a class="dropdown-item" href="#">Something else here</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body spur-card-body-chart">
                        <canvas id="spurChartjsBar"></canvas>
                        <script>
                            var fivelist = [];
                            <c:forEach var="item" items="${fivelist}">
                            fivelist.push(${item.cost});
                            </c:forEach>
                            var fivelistday = [];

                            var ctx = document.getElementById("spurChartjsBar").getContext('2d');
                            var myChart = new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"],
                                    datasets: [{
                                            label: 'Blue',
                                            data: [fivelist[4], fivelist[3], fivelist[2], fivelist[1], fivelist[0]],
                                            backgroundColor: window.chartColors.primary,
                                            borderColor: 'transparent'
                                        }]
                                },
                                options: {
                                    legend: {
                                        display: false
                                    },
                                    scales: {
                                        yAxes: [{
                                                ticks: {
                                                    beginAtZero: true
                                                }
                                            }]
                                    }
                                }
                            });
                        </script>
                    </div>
                </div>
            </div>
            <div class="col-xl-6">
                <div class="card spur-card">
                    <div class="card-header">
                        <form action="<c:url value="/admin/viewRevenue.do"/>" >
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group d-flex ">
                                        <label for="input_from">From</label>
                                        <input type="date" name="dateFrom" value="${dateFrom}" class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group d-flex">
                                        <label for="input_from">To</label>
                                        <input type="date" name="dateTo" value="${dateTo}" class="form-control"/>

                                    </div>

                                </div>
                            </div>
                            <button type="submit" name="op" value="view" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>

                                <th>OrderDetail ID</th>
                                <th>Date</th>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Cost</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="revenue" items="${list}" varStatus="loop">
                                <tr>
                                    <td>${revenue.orderDetailId}</td>
                                    <td>${revenue.date}</td>
                                    <td>${revenue.productId}</td>
                                    <td>${revenue.productName}</td>
                                    <td>${revenue.quantity}</td>
                                    <td>${revenue.cost}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>
</c:if>

