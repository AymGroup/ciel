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
    <title>List vehicule en service - Espace Commercial</title>
    <!-- Bootstrap Core CSS -->
    <link href="/car_rental/resources/css/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/resources/css/helper.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet">
    
    <!-- JQuery & validation -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
   <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
   
   <script src="<%=request.getContextPath() %>/resources/js/scriptsJquery.js"></script>
	
    <script>

    	 $(document).ready(function(){
    	      
    	      $('.getCategorie').click(function(e){
				  //alert($(this).attr('href'));
				  e.preventDefault();
				  
    	    	  $.ajax({
    	              url : $(this).attr('href'),
    	              success : function(data) {
        	              
        	            var result="";
        	            datas = JSON.parse(data);
        	            $("#id").val(datas.id);
        	            $("#libelle").val(datas.libelle);
        	            $("#description").val(datas.description);
        	            
        	            $('#categorieImage').attr('src', "/car_rental/resources/uploaded/categorie/"+datas.id+".png");
        	            
        	           	$("#infoShow").show();
    	              },
    	    	  	  error: function(response) {
    	              	alert("An error occurred !");
    	            	// terminate the script
    	          	  }
    	          });
    	    	  return false;
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
                    <h3 class="text-primary">Espace Véhicules</h3> </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Liste des véhicules en service</li>
                    </ol>
                </div>
            </div>
            
            <!-- End Bread crumb -->
            <!-- Container fluid  -->
            <div class="container-fluid">
                <!-- Start Page Content -->
                			<div class="row">
                               	<div class="col-lg-12">	
                               		<div class="card">	
                               			<div class="card-body">
                               				<h4 class="card-title">Liste des véhicules en service</h4>
                               				<hr>  
                                			<div class="table-responsive m-t-5">
                                    			<table id="myTable" class="table table-bordered table-striped">
                                        			<thead>
			                                            <tr>
			                                            	<!--<th>Image</th>-->
			                                                <th>#</th>
			                                                <th>Marque</th>
			                                                <th>Modele</th>
			                                                <th>Date debut réservation</th>
			                                                <th>Date fin réservation</th>
			                                                <th>Status</th>
			                                            </tr>
			                                        </thead>
			                                        <tbody>
			                                        
			                                        <c:forEach var="lv" items="${vehiculesReserved}">
			                                            <tr>
			                                                <td>${lv.vehicule.id }</td>
			                                                <td>${lv.vehicule.marque }</td>
			                                                <td>${lv.vehicule.modele }</td>
			                                                <td>${lv.reservation.dateResevation }</td>
			                                                <td>${lv.reservation.dateFinResevation }</td>
			                                                <td>
			                                                	<c:choose>
																  <c:when test="${lv.vehicule.onService=='En Service'}">
																    <span class="badge badge-success">${lv.vehicule.onService }</span>
																  </c:when>
																  <c:otherwise>
																  	<span class="badge badge-danger">Off Service</span>
																  </c:otherwise>
										   						</c:choose>
			                                                </td>
			                                            </tr>
													</c:forEach>
													
			                                        </tbody>
                                    			</table>
                                			</div><!-- # table responsive -->
                                		</div><!-- # card-body -->
                                	</div><!-- # card -->
                                </div><!-- # col-lg-12 -->
                            </div><!-- # Row -->
                 </div><!-- # container-fluid -->
 
                <!-- End PAge Content -->
            
            <!-- End Container fluid  -->
            <!-- footer -->
            	<jsp:include page="../includes/footer.jsp"/>
            <!-- End footer -->
            </div>
        </div><!-- # main-wrapper -->
        <!-- End Page wrapper  -->

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
    
    <!-- DataTables Scripts -->
     <script src="<%=request.getContextPath() %>/resources/js/lib/datatables/datatables.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/datatables/cdn.datatables.net/buttons/1.2.2/js/dataTables.buttons.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/datatables/cdn.datatables.net/buttons/1.2.2/js/buttons.flash.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/datatables/cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/datatables/cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/datatables/cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/datatables/cdn.datatables.net/buttons/1.2.2/js/buttons.html5.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/datatables/cdn.datatables.net/buttons/1.2.2/js/buttons.print.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/lib/datatables/datatables-init.js"></script>
	
</body>

</html>