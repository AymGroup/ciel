<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
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
    <title>Nouveau email - Espace commercial</title>
    <!-- Bootstrap Core CSS -->
    <link href="/car_rental/resources/css/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/resources/css/helper.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet">
    
    <!-- JQuery & validation -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
   <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
   
   <script src="<%=request.getContextPath() %>/resources/js/scriptsJquery.js"></script>
   
   <!-- JQuery validation -->
    <script>

    	 $(document).ready(function(){
    	      
    	      $('#myform').validate({ // initialize the plugin
    	          rules: {
    	              "recipient": {
    	                  required: true,
    	                  email: true
    	              },
    	              "subject":{
        	              required: true
        	          },
    	              "body": {
    	                  required: true 
    	              }
    	          },
    	      });
    	 });
    </script>
    
    <style type="text/css">
    	.error {
      		color: #e67e22;
   		}
    </style>
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
                    <h3 class="text-primary">Espace Emails</h3> </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Nouveau email</li>
                    </ol>
                </div>
            </div>
            <!-- End Bread crumb -->
            <!-- Container fluid  -->
            <div class="container-fluid">
                <!-- Start Page Content -->
                  <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="card-content">
                                    <!-- Left sidebar -->
                                    <div class="inbox-leftbar">

                                        <a href="email-inbox.html" class="btn btn-danger btn-block waves-effect waves-light">Inbox</a>

                                        <div class="mail-list mt-4">
                                            <a href="#" class="list-group-item border-0 text-danger"><i class="mdi mdi-inbox font-18 align-middle mr-2"></i><b>Inbox</b><span class="label label-danger float-right ml-2">8</span></a>
                                            <a href="#" class="list-group-item border-0"><i class="mdi mdi-star font-18 align-middle mr-2"></i>Starred</a>
                                            <a href="#" class="list-group-item border-0"><i class="mdi mdi-file-document-box font-18 align-middle mr-2"></i>Draft<span class="label label-info float-right ml-2">32</span></a>
                                            <a href="#" class="list-group-item border-0"><i class="mdi mdi-send font-18 align-middle mr-2"></i>Sent Mail</a>
                                            <a href="#" class="list-group-item border-0"><i class="mdi mdi-delete font-18 align-middle mr-2"></i>Trash</a>
                                        </div>

                                    </div>
                                    <!-- End Left sidebar -->
                                    <div class="inbox-rightbar">
                                    
                                        <div class="mt-4">
                                            <c:url value="/email/sendEmail" var ="urlEnvoyer" />
                                			<f:form id="myform2" modelAttribute="message" action="${urlEnvoyer }" enctype="multipart/form-data">
                                                <div class="form-group">
                                                    <f:input path="recipient" type="email" class="form-control" placeholder="To" />
                                                </div>

                                                <div class="form-group">
                                                    <f:input path="subject" class="form-control" placeholder="Subject" />
                                                </div>
                                                <div class="form-group">
                                                    <!--<textarea name="name" rows="8" cols="80" class="form-control" style="height:300px"></textarea>-->
                                                    <f:textarea path="body" rows="8" cols="80" class="form-control" style="height:300px"/>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <label class="control-label">Attachment</label><br>
                                                    <label class="btn btn-default btn-sm center-block btn-file">
													  <i class="fa fa-upload fa-2x" aria-hidden="true"></i>
													  <input id="mailAttachment" type="file" name="attachFileObj" size="60" style="display: none;" class="form:input-large" />
													</label>
                                                </div>
                                                
                                                
                                                <div class="form-group m-b-0">
                                                    <div class="text-right">
                                                        <button type="button" class="btn btn-success waves-effect waves-light m-r-5"><i class="fa fa-floppy-o"></i></button>
                                                        <button type="button" class="btn btn-success waves-effect waves-light m-r-5"><i class="fa fa-trash-o"></i></button>
                                                        <button type="submit" class="btn btn-purple waves-effect waves-light"> <span>Send</span> <i class="fa fa-send m-l-10"></i> </button>
                                                    </div>
                                                </div>
                                           </f:form>
                                        </div>
                                        <!-- end card-->

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- /Row -->
                <!-- End PAge Content -->
  
            <!-- End PAge Content -->
            </div><!-- /End Container fluid  -->
            
            <!-- footer -->
            	<jsp:include page="../includes/footer.jsp"/>
            <!-- End footer -->
        </div>
        <!-- End Page wrapper  -->
    </div>
    <!-- End Wrapper -->
    <!-- All Jquery -->
    <!--  <script src="<%=request.getContextPath() %>/resources/js/lib/jquery/jquery.min.js"></script>-->
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