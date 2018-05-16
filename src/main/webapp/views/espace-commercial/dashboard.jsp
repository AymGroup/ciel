<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath() %>/resources/images/logo_car_rental.png">
    <title>DashBoard - Espace-Commercial</title>
    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/css/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->

    <link href="<%=request.getContextPath() %>/resources/css/lib/calendar2/semantic.ui.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/lib/calendar2/pignose.calendar.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/lib/owl.carousel.min.css" rel="stylesheet" />
    <link href="<%=request.getContextPath() %>/resources/css/lib/owl.theme.default.min.css" rel="stylesheet" />
    <link href="<%=request.getContextPath() %>/resources/css/helper.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet">
    
</head>

<body class="fix-header fix-sidebar">
    <!-- Preloader - style you can find in spinners.css -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
			<circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
    </div>
    <!-- Main wrapper  -->
    <div id="main-wrapper">
    
        <!-- header header  -->
        	<jsp:include page="../includes/header.jsp"/>
        <!-- End header header -->
        
        <!-- Left Sidebar  -->
        	<jsp:include page="../includes/left_sidebar.jsp"/>
        <!-- End Left Sidebar  -->
        
        <!-- Page wrapper  -->
        <div class="page-wrapper">
            <!-- Bread crumb -->
            <div class="row page-titles">
                <div class="col-md-5 align-self-center">
                    <h3 class="text-primary">Dashboard</h3> </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                </div>
            </div>
            <!-- End Bread crumb -->
            <!-- Container fluid  -->
           <div class="container-fluid">
                <!-- Start Page Content -->
                <div class="row">
                    <div class="col-md-3">
                        <div class="card p-30">
                            <div class="media">
                                <div class="media-left meida media-middle">
                                    <span><i class="fa fa-usd f-s-40 color-primary"></i></span>
                                </div>
                                <div class="media-body media-text-right">
                                    <h2>568120</h2>
                                    <p class="m-b-0">Total Revenue</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card p-30">
                            <div class="media">
                                <div class="media-left meida media-middle">
                                    <span><i class="fa fa-shopping-cart f-s-40 color-success"></i></span>
                                </div>
                                <div class="media-body media-text-right">
                                    <h2>1178</h2>
                                    <p class="m-b-0">Sales</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card p-30">
                            <div class="media">
                                <div class="media-left meida media-middle">
                                    <span><i class="fa fa-archive f-s-40 color-warning"></i></span>
                                </div>
                                <div class="media-body media-text-right">
                                    <h2>25</h2>
                                    <p class="m-b-0">Stores</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card p-30">
                            <div class="media">
                                <div class="media-left meida media-middle">
                                    <span><i class="fa fa-user f-s-40 color-danger"></i></span>
                                </div>
                                <div class="media-body media-text-right">
                                    <h2>847</h2>
                                    <p class="m-b-0">Customer</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                

                <div class="row">
					
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-title">
                                <h4>Recent Orders </h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>Product</th>
                                                <th>quantity</th>
                                                <th>Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <tr>
                                                <td>
                                                    <div class="round-img">
                                                        <a href=""><img src="images/avatar/4.jpg" alt=""></a>
                                                    </div>
                                                </td>
                                                <td>John Abraham</td>
                                                <td><span>iBook</span></td>
                                                <td><span>456 pcs</span></td>
                                                <td><span class="badge badge-success">Done</span></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="round-img">
                                                        <a href=""><img src="images/avatar/2.jpg" alt=""></a>
                                                    </div>
                                                </td>
                                                <td>John Abraham</td>
                                                <td><span>iPhone</span></td>
                                                <td><span>456 pcs</span></td>
                                                <td><span class="badge badge-success">Done</span></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="round-img">
                                                        <a href=""><img src="images/avatar/3.jpg" alt=""></a>
                                                    </div>
                                                </td>
                                                <td>John Abraham</td>
                                                <td><span>iMac</span></td>
                                                <td><span>456 pcs</span></td>
                                                <td><span class="badge badge-warning">Pending</span></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="round-img">
                                                        <a href=""><img src="images/avatar/4.jpg" alt=""></a>
                                                    </div>
                                                </td>
                                                <td>John Abraham</td>
                                                <td><span>iBook</span></td>
                                                <td><span>456 pcs</span></td>
                                                <td><span class="badge badge-success">Done</span></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
					<div class="col-lg-8">
						<div class="row">
						<!-- /# column -->
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<div class="year-calendar"></div>
								</div>
							</div>
						</div>
						</div>
					</div>
                </div>
                
                <div class="row">
					<div class="col-lg-12">
						<div class="row">
						<!-- /# column -->
						<div class="col-lg-6">
							<div class="card">
                                <div class="card-title">
                                    <h4>Another Section </h4>
                                </div>

								<div class="card-body">
									<h2>Blank Section</h2>
								</div>
							</div>
                        </div>
                        <div class="col-lg-6">
                                <div class="card">
                                    <div class="card-title">
                                        <h4>Another Section </h4>
                                    </div>
    
                                    <div class="card-body">
                                        <h2>Blank Section</h2>
                                    </div>
                                </div>
                            </div>
						</div>
					</div>
                </div>


                <!-- End PAge Content -->
            </div>
            <!-- End Container fluid  -->
            <!-- footer -->
            	<jsp:include page="../includes/footer.jsp"></jsp:include>
            <!-- End footer -->
        </div>
        <!-- End Page wrapper  -->
    </div>
    <!-- End Wrapper -->
    
    <!-- All Jquery -->
    <script src="<%=request.getContextPath() %>/resources/js/lib/jquery/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/js/lib/bootstrap/js/popper.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/bootstrap/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery.slimscroll.js"></script>
    <!--Menu sidebar -->
    <script src="<%=request.getContextPath() %>/resources/js/sidebarmenu.js"></script>
    <!--stickey kit -->
    <script src="<%=request.getContextPath() %>/resources/js/lib/sticky-kit-master/dist/sticky-kit.min.js"></script>
    <!--Custom JavaScript -->


    <!-- Amchart -->
     <script src="<%=request.getContextPath() %>/resources/js/lib/morris-chart/raphael-min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/morris-chart/morris.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/morris-chart/dashboard1-init.js"></script>


	<script src="<%=request.getContextPath() %>/resources/js/lib/calendar-2/moment.latest.min.js"></script>
    <!-- scripit init-->
    <script src="<%=request.getContextPath() %>/resources/js/lib/calendar-2/semantic.ui.min.js"></script>
    <!-- scripit init-->
    <script src="<%=request.getContextPath() %>/resources/js/lib/calendar-2/prism.min.js"></script>
    <!-- scripit init-->
    <script src="<%=request.getContextPath() %>/resources/js/lib/calendar-2/pignose.calendar.min.js"></script>
    <!-- scripit init-->
    <script src="<%=request.getContextPath() %>/resources/js/lib/calendar-2/pignose.init.js"></script>

    <script src="<%=request.getContextPath() %>/resources/js/lib/owl-carousel/owl.carousel.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/owl-carousel/owl.carousel-init.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/scripts.js"></script>
    <!-- scripit init-->

    <script src="<%=request.getContextPath() %>/resources/js/custom.min.js"></script>

</body>

</html>