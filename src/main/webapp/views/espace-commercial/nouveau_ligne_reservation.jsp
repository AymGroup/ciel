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
    <title>Nouvelle ligne réservation - Espace commercial</title>
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
                    <h3 class="text-primary">Espace Ligne Réservation</h3> </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Nouvelle ligne réservation</li>
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
                            
                            	 <c:url value="/reservation/enregistrerLigneReservation" var ="urlEnregistrer" />
                       			 <f:form id="myform" modelAttribute="ligne_reservation" action="${urlEnregistrer }" method="POST">
                                    <div class="form-body">

									<!-- Alert messages -->
									<c:choose>
										<c:when test="${response =='success'}">
										    <div class="alert alert-success alert-dismissible fade show" role="alert">
						  						<strong>Success !</strong> You should check in on some of those fields below.
						  						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    						<span aria-hidden="true">&times;</span>
						  						</button>
											</div>
										  </c:when>
										  <c:when test="${response =='error'}">
										    <div class="alert alert-danger alert-dismissible fade show" role="alert">
						  						<strong>Error !</strong> You should check in on some of those fields below.
						  						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    						<span aria-hidden="true">&times;</span>
						  						</button>
											</div>
										  </c:when>
								   </c:choose>
								   <!-- # End Alert -->

                                        <h3 class="card-title m-t-15">Nouvelle ligne réservation</h3>
                                        <hr>
                                        <div class="row p-t-20">
                                            <div class="col-md-12">
	                                            	<div class="form-group">
	                                            		<label class="control-label">Véhicule</label>
	                                            		<f:input path="reservation.id" type="hidden" value="${param.id_reservation }"/>
			                                            <f:select path="vehicule.id" class="form-control custom-select" required="true">
		                                                        <f:option selected="selected" value="" readonly="true" disabled="true">-- Choisissez une véhicule --</f:option>
		                                                        <c:forEach var="vehicule"  items="${vehicules}">
		                                                        	<f:option value="${vehicule.id }">${vehicule.marque} - ${vehicule.modele}</f:option>
		                                                        </c:forEach>                                                 
		                                                </f:select>
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
                
                <!-- Second Row -->
                <div class="row">
                	<div class="col-lg-12">
                		<div class="card card-outline-primary">
                		 	<div class="card-body">
                		 	<h4 class="card-title">Détail réservation</h4>
                		 	<hr>
                		 		<div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Date Réservation</th>
                                                <th>Date Fin Réservation</th>
                                                <th>Client</th>
                                                <th>Pack</th>
                                                <th>Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        
                                        <c:forEach var="rd" items="${reservationDetail }">
                                            <tr>
                                                <th scope="row">${rd.id }</th>
                                                <td>${rd.dateResevation }</td>
                                                <td>${rd.dateFinResevation }</td>
                                                <td>${rd.client.nom } ${rd.client.prenom }</td>
                                                <td>${rd.pack.libelle }</td>
                                                <td class="color-primary">${rd.tarifTotal }</td>
                                            </tr>
                                        </c:forEach>
                                        
                                        </tbody>
                                    </table>
                                </div>
                		 	</div>
                		</div>
                	</div>
                </div>
                <!-- /End -->
                
                <c:if test="${ligneRes == 'ok' }">
                <div class="row">
                	<div class="col-lg-12">
                		<div class="card card-outline-primary">
                		 	<div class="card-body">
                		 	<h4 class="card-title">Liste des ligne réservations</h4>
                		 		<div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Réservation</th>
                                                <th>Véhicule</th>
                                                <th>Tarif</th>
                                                <th>Last Touched</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="l" items="${ligneReservations }">
                                            <tr>
                                                <th scope="row">${l.id}</th>
                                                <td>${l.reservation.id }</td>
                                                <td>${l.vehicule.marque } ${l.vehicule.modele }</td>
                                                <td>${l.tarif }</td>
                                                <td class="color-primary">${l.lastTouched }</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                		 	</div>
                		</div>
                	</div>
                </div>
                </c:if>
                
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