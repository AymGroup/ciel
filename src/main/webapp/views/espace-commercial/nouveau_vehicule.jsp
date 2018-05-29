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
    <title>Nouveau véhicule - Espace commercial</title>
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
    	              "libelle": {
    	            	  maxlength: 25,
    	                  required: true
    	              },
    	              "categorieImage":{
        	              required: true
        	          },
    	              "description": {
    	            	  maxlength: 30,
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
                    <h3 class="text-primary">Espace Véhicules</h3> </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Nouveau véhicule</li>
                    </ol>
                </div>
            </div>
            <!-- End Bread crumb -->
            <!-- Container fluid  -->
            <div class="container-fluid">
                <!-- Start Page Content -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card card-outline-primary">
                            <!--<div class="card-header" style="background-color:#ef5350;border-color:#ef5350">
                                <h4 class="m-b-0 text-white">Nouveau Client</h4>
                            </div>-->
                            <div class="card-body">
                            
                            	<c:url value="/vehicule/enregistrer" var ="urlEnregistrer" />
                                <f:form id="myform" modelAttribute="vehicule" action="${urlEnregistrer }" enctype="multipart/form-data">
                                    <div class="form-body">

									<!-- Alert messages -->
									<c:choose>
										  <c:when test="${response =='error'}">
										    ...
										  </c:when>
										  <c:when test="${response =='success'}">
										    <div class="alert alert-success alert-dismissible fade show" role="alert">
						  						<strong>Success !</strong> You should check in on some of those fields below.
						  						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    						<span aria-hidden="true">&times;</span>
						  						</button>
											</div>
										  </c:when>
										  <c:otherwise>
										    
										  </c:otherwise>
								   </c:choose>
								   <!-- # End Alert -->

                                        <h3 class="card-title m-t-15">Nouveau véhicule</h3>
                                        <hr>
                                        <div class="row p-t-20">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="control-label">Marque</label>
                                                    <f:input path="marque" class="form-control"  />
                                                </div>
                                                    
                                            </div>
                                            <!--/span-->
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="control-label">Puissance fiscale</label>
                                                    <f:input path="puissanceFiscale" class="form-control"  />
                                                </div>
                                                    
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="control-label">Immatriculationt</label>
                                                    <f:input path="immatriculation" class="form-control"  />
                                                </div>
                                                    
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="control-label">Kilométrage</label>
                                                    <f:input path="kilometrage" class="form-control"  />
                                                </div>   
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="control-label">Air conditioner</label>
                                                    <f:input path="airConditioner" class="form-control"  />
                                                </div>   
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="control-label">Type transmission</label>
                                                    <f:select path="typeTransmission" class="form-control custom-select">
                                                    	<f:option value="manuelle">Manuelle</f:option>
                                                    	<f:option value="automatique">Automatique</f:option>
                                                    </f:select>
                                                </div>   
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="control-label">Carburant</label>
                                                    <f:select path="carburant" class="form-control custom-select">
                                                    	<f:option value="essence">Essence</f:option>
                                                    	<f:option value="diesel">Diesel</f:option>
                                                    </f:select>
                                                </div>   
                                            </div>
                                            
                                            
                                            <div class="col-md-6">
                                             	<div class="form-group">
                                                    <label class="control-label">Upload image for your category</label><br>
                                                    <label class="btn btn-default btn-sm center-block btn-file">
													  <i class="fa fa-upload fa-2x" aria-hidden="true"></i>
													  <f:input type="file" style="display: none;" path="categorieImage" id="categorieImage" name="categorieImage" class="form:input-large" required="true"/>
													</label>
                                                </div>
                                             </div>
                                            <!--/span-->
                                        </div>
                                        <!--/row-->
                                        
                                    </div>
                                    <div class="form-actions">
                                        <button type="submit" class="btn btn-success"> <i class="fa fa-check"></i> Save</button>
                                        <button type="reset" class="btn btn-inverse">Cancel</button>
                                    </div>
                                </f:form>
                            </div>
                        </div>
                    </div>

                </div>
                
                <!-- Row -->
                <!-- End PAge Content -->
            </div>
            <!-- End Container fluid  -->
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