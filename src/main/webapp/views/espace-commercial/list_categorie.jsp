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
    <title>List categories - Espace Commercial</title>
    <!-- Bootstrap Core CSS -->
    <link href="/car_rental/resources/css/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/resources/css/helper.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet">
    
    <!-- JQuery & validation -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
   <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
   
   <script src="<%=request.getContextPath() %>/resources/js/scriptsJquery.js"></script>
	
   <script type="text/javascript">
   		$(document).ready(function(){    
	    	$("#infoShow").hide();
		});
   </script>
   
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
    
    <!-- Delete Confirmation -->
    <script type="text/javascript">
	    $(document).ready(function(){
	    	
		      $('.deleteCategorie').click(function(e){
		    	  
		    	  if (!confirm("are you sure?")) {
			    	  console.log("Opération annulé");
	                  return false;
	              }
	              return true;
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
                    <h3 class="text-primary">Espace Catégories</h3> </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Liste des catégories</li>
                    </ol>
                </div>
            </div>
            
            <!-- End Bread crumb -->
            <!-- Container fluid  -->
            <div class="container-fluid">
                <!-- Start Page Content -->

                	<!-- Test -->
                	<p id="result" ></p>
					<h3></h3>
					<!-- # Test -->
                			<div class="row">
                               	<div class="col-lg-12">	
                               		<div class="card">	
                               			<div class="card-body">
                               			<!-- Alert messages -->
											<c:choose>
												  <c:when test="${param.response_update=='success'}">
												    <div class="alert alert-warning alert-dismissible fade show" role="alert">
								  						<strong>Update</strong> La modification a été effectuée avec succès.
								  						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								    						<span aria-hidden="true">&times;</span>
								  						</button>
													</div>
												  </c:when>
												  <c:when test="${param.response_delete=='success'}">
												    <div class="alert alert-info alert-dismissible fade show" role="alert">
								  						<strong>Success !</strong> La suppression a été effectuée avec succès.
								  						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								    						<span aria-hidden="true">&times;</span>
								  						</button>
													</div>
												  </c:when>
										   </c:choose>
                               			
                               			
                               				<h4 class="card-title">Liste des catégories</h4>
                               				<hr>  
                                			<div class="table-responsive m-t-5">
                                    			<table id="myTable" class="table table-bordered table-striped">
                                        			<thead>
			                                            <tr>
			                                            	<!--<th>Image</th>-->
			                                                <th>#</th>
			                                                <th>Image</th>
			                                                <th>Libellé</th>
			                                                <th>Description</th>
			                                                <th>Actions</th>
			                                            </tr>
			                                        </thead>
			                                        <tbody>
			                                        
			                                        <c:forEach var="categorie" items="${categories}">
			                                            <tr>
			                                            	<!--<td><img src="<c:url value="/resources/uploaded/${client.id}.png"/>" alt="image" class="img-circle" width="304" height="236"/></td>-->
			                                                <td>${categorie.id }</td>
			                                                <td><img id="catImage" src="<c:url value="/resources/uploaded/categorie/${categorie.id}.png"/>" alt="image" class="img-thumbnail" width="150" height="150"/></td>
			                                                <td>${categorie.libelle }</td>
			                                                <td>${categorie.description }</td>
			                                                
			                                                <!-- View Détails -->
			                                                <c:url var="url_get_categorie" value="/categorie/get?id=${categorie.id }" />
			                                                <c:url var="url_delete_categorie" value="/categorie/delete?id=${categorie.id }" />
			                                                <td>
			                                               		<div class="dropdown">
								                                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Actions
																			<span class="caret"></span></button>
								                                    <ul class="dropdown-menu">
								                                        <li><i class="fa fa-eye"></i><a class="getCategorie" href="${url_get_categorie}"> View & Edit</a></li>
								                                        <!-- <li><i class="fa fa-pencil"></i><a href="#"> Edit</a></li>-->
								                                        <li><i class="fa fa-trash"></i><a class="deleteCategorie" href="${url_delete_categorie}"> Delete</a></li>
								                                    </ul>
                                								</div>
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
                            
                            <div id="infoShow">
	                            <div class="row">
	                    			<div class="col-lg-12">
	                        			<div class="card card-outline-primary">
	                            			<div class="card-body">
	                            			
	                            				<c:url value="/categorie/edit" var ="urlEdit" />
	                                			<f:form id="myforme" modelAttribute="categorie" action="${urlEdit }" enctype="multipart/form-data">
	                                   		 		<div class="form-body">
	                                   		 			<!-- # Contrat Détails -->
	                                   		 			<h3 class="card-title m-t-4">Détails catégorie</h3>
	                                        			<hr>
	                                        			<div class="row">
	                                        				<div class="col-lg-12">
							        							<div class="form-group">
							        								<img id="categorieImage" src="<c:url value="/resources/uploaded/user/${categorie.id}.png"/>" alt="image" class="img-thumbnail" width="400" height="400" style="margin:0 570px;"/>
							        							</div>
							        						</div>
	                                        				<div class="col-lg-6">
							        							<div class="form-group">
							        								<label>Libellé :</label>
							        								<f:input path="libelle" class="form-control"  />
							        								<f:input path="id" type="hidden" /><!-- Hidden input -->
							        							</div>
							        						</div>
							        						<div class="col-lg-6">
							        							<div class="form-group">
							        								<label>Description :</label>
							        								<f:input path="description" class="form-control"  />
							        								
							        							</div>
							        						</div>
							        						<div class="col-md-6">
				                                             	<div class="form-group">
				                                                    <label class="control-label">Upload image for your category</label><br>
				                                                    <label class="btn btn-default btn-sm center-block btn-file">
																	  <i class="fa fa-upload fa-2x" aria-hidden="true"></i>
																	  <f:input type="file" style="display: none;" path="categorieImage" class="form:input-large" />
																	</label>
				                                                </div>
                                             				</div>
							        						
	                                        				
	                                   		 			</div>
	                                   		 		</div><!-- # form-body -->	
	                                   		 	<br>
	
	                                   		 	<div class="form-actions">
	                                        		<button type="submit" class="btn btn-warning"> <i class="fa fa-check"></i> Edit</button>
	                                        		<button type="reset" class="btn btn-inverse">Cancel</button>
	                                    		</div>
	                                   		 	</f:form><!-- # myForm --><br>
	                            			</div><!-- # card-body -->
	                            		</div><!-- # card card-outline-primary -->
	                            	</div><!-- # col-lg-12 -->
	                           </div><!-- # Row -->
                           </div>

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