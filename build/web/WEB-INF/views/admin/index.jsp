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
                            <div class="stats stats-primary">
                                <h3 class="stats-title"> Sign ups </h3>
                                <div class="stats-content">
                                    <div class="stats-icon">
                                        <i class="fas fa-user"></i>
                                    </div>
                                    <div class="stats-data">
                                        <div class="stats-number">114</div>
                                        <div class="stats-change">
                                            <span class="stats-percentage">+25%</span>
                                            <span class="stats-timeframe">from last month</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-4">
                            <div class="stats stats-success ">
                                <h3 class="stats-title"> Revenue </h3>
                                <div class="stats-content">
                                    <div class="stats-icon">
                                        <i class="fas fa-cart-arrow-down"></i>
                                    </div>
                                    <div class="stats-data">
                                        <div class="stats-number">$25,541</div>
                                        <div class="stats-change">
                                            <span class="stats-percentage">+17.5%</span>
                                            <span class="stats-timeframe">from last month</span>
                                        </div>
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
                                        <div class="stats-number">5</div>
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
                                        var ctx = document.getElementById("spurChartjsBar").getContext('2d');
                                        var myChart = new Chart(ctx, {
                                            type: 'bar',
                                            data: {
                                                labels: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"],
                                                datasets: [{
                                                    label: 'Blue',
                                                    data: [12, 19, 3, 5, 2],
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
                                    <form action="#" class="row">
                                        <div class="col-md-6">
                                          <div class="form-group">
                                            <label for="input_from">From</label>
                                            <input type="text" class="form-control" id="input_from" placeholder="Start Date">
                                          </div>
                                        </div>
                                        <div class="col-md-6">
                                          <div class="form-group">
                                            <label for="input_from">To</label>
                                            <input type="text" class="form-control" id="input_to" placeholder="Start Date">
                                          </div>
                                        </div>
                                    </form>
                                </div>
                                 <table class="table table-striped table-hover">
							<thead>
								<tr>
                                                           
								<th>Order ID</th>
                                                                <th>Product ID</th>
                                                                <th>Product Name</th>
                                                                <th>Quantity</th>
                                                                <th>Price</th>
                                                                <th>Cost</th>

								</tr>
							</thead>
							
							<tbody>
                                 
                                                                <tr>
                                                                    <td>1</td>
                                                                    <td>2</td>
                                                                    <td>Phong Ngu</td>
                                                                    <td>3</td>
                                                                    <td>200</td>
                                                                    <td>600</td>
                                                                   
                                                                </tr>
                                                                 <tr>
                                                                    <td>1</td>
                                                                    <td>2</td>
                                                                    <td>Phong Ngu</td>
                                                                    <td>3</td>
                                                                    <td>200</td>
                                                                    <td>600</td>
                                                                   
                                                                </tr>
                                
							</tbody>
                                                        
						</table>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
</c:if>

