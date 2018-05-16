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
    <link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath() %>/resources/images/favicon.png">
    <title>Login - Espace Commercial</title>
    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/css/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
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

        <div class="unix-login">
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-lg-4">
                        <div class="login-content card">
                            <div class="login-form">
                                <!--<h4>Login</h4>-->
                                <img style="max-width: 50%;margin-left: 23%;margin-bottom:32px" src="<%=request.getContextPath() %>/resources/images/logo_car_rental.png" alt="">
                                <form>
                                    <div class="form-group">
                                        <label>Email address</label>
                                        <input type="email" class="form-control" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" class="form-control" placeholder="Password">
                                    </div>
                                    <div class="checkbox">
                                        <label>
        										<input type="checkbox"> Remember Me
        									</label>
                                        <label class="pull-right">
        										<a href="#">Forgotten Password?</a>
        									</label>

                                    </div>
                                    <button type="submit" class="btn btn-danger btn-flat m-b-30 m-t-30">Sign in</button>
                                    
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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
    <script src="<%=request.getContextPath() %>/resources/js/custom.min.js"></script>

</body>

</html>