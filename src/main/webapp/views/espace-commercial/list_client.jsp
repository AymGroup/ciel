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
    <title>List clients - Espace Commercial</title>
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
    	      
    	      $('.getClient').click(function(e){
				  //alert($(this).attr('href'));
				  e.preventDefault();
				  
    	    	  $.ajax({
    	              url : $(this).attr('href'),
    	              success : function(data) {
        	              
        	            var result="";
        	            datas = JSON.parse(data);
        	            $("#id").val(datas.id);
        	            $("#nom").val(datas.nom);
        	            $("#prenom").val(datas.prenom);
        	            $("#telephone").val(datas.telephone);
        	            $("#civilite").val(datas.civilite);
        	            $("#email").val(datas.email);
        	            $("#numPermis").val(datas.numPermis);
        	            $("#idAddress").val(datas.address.id);
        	            $("#street").val(datas.address.street);
        	            $("#city").val(datas.address.city);
        	            $("#state").val(datas.address.state);
        	            $("#postCode").val(datas.address.postCode);

        	            $('#cltImage').attr('src', "/car_rental/resources/uploaded/user/"+datas.id+".png");
        	            
        	           	$("#infoShow").show();
        	            //$(".accordion").remove();
    	                $('#result').html(datas);
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
	    	
		      $('.deleteContrat').click(function(e){
		    	  
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
                    <h3 class="text-primary">Espace Client</h3> </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Liste des clients</li>
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
												  <c:when test="${param.response=='success'}">
												    <div class="alert alert-info alert-dismissible fade show" role="alert">
								  						<strong>Success !</strong> La suppression a été effectuée avec succès.
								  						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								    						<span aria-hidden="true">&times;</span>
								  						</button>
													</div>
												  </c:when>
												  <c:when test="${param.response_delete=='success'}">
												    <div class="alert alert-danger alert-dismissible fade show" role="alert">
								  						<strong>Delete !</strong> La suppression a été effectuée avec succès.
								  						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								    						<span aria-hidden="true">&times;</span>
								  						</button>
													</div>
												  </c:when>
												  <c:otherwise>
												    
												  </c:otherwise>
										   </c:choose>
										   <!-- # End Alert -->			
                                		<h4 class="card-title">Recherche client par ville</h4>
                               			<hr>      			
                               				<div class="col-lg-6">
                               				<!-- Search form -->
                               					<c:url value="/client/chercher/${address.ville }" var ="urlChercher" />
                               					<f:form action="${urlChercher}" modelAttribute="client">
                               					<div class="form-group">
                               						<label>Ville</label>       
                                                    <f:select path="address.city" class="form-control custom-select" required="true">
                                                        <f:option selected="selected" value="" readonly="true" disabled="true">--Choisissez votre ville--</f:option>
                                                        <f:option value="casablanca">Casablanca</f:option>
                                                        <f:option value="rabat">Rabat</f:option>
                                                        <f:option value="fes">Fes</f:option>
                                                    </f:select>
                                                 </div>
                                                 
                                                 <div class="form-actions">
                               						<button type="submit" class="btn btn-info btn-rounded m-b-10 m-l-5"><i class="fa fa-search"></i>Chercher</button>
                               					</div>
                                                  
                                                </f:form>
                                            <!-- # END Search form -->  
                               				</div><!-- # col-lg-6 -->
                               			</div><!-- # card-body -->
                               		</div><!-- # card -->
                          </div><!-- # col-lg-12 -->
                      </div><!-- # Row -->
                	
                	<!-- Test -->
                	<p id="result" ></p>
					<h3></h3>
					<!-- # Test -->
					
                			<div class="row">
                               	<div class="col-lg-12">	
                               		<div class="card">	
                               			<div class="card-body">
                               				
                               					<h4 class="card-title">Liste des clients</h4>
                               				
                               				<!--<c:if test = "${not empty prop}">
                               					<h4 class="card-title">Liste des contrats pour le propriétaire : ${prop}</h4>
                               				</c:if>-->
                               				<hr>  
                                			<div class="table-responsive m-t-5">
                                    			<table id="myTable" class="table table-bordered table-striped">
                                        			<thead>
			                                            <tr>
			                                            	<!--<th>Image</th>-->
			                                                <th>#</th>
			                                                <th>Nom</th>
			                                                <th>Prénomt</th>
			                                                <th>Téléphone</th>
			                                                <th>Civilité</th>
			                                                <th>Adresse e-mail</th>
			                                                <th>Actions</th>
			                                            </tr>
			                                        </thead>
			                                        <tbody>
			                                        
			                                        <c:forEach var="client" items="${clients}">
			                                            <tr>
			                                            	<!--<td><img src="<c:url value="/resources/uploaded/${client.id}.png"/>" alt="image" class="img-circle" width="304" height="236"/></td>-->
			                                                <td>${client.id }</td>
			                                                <td>${client.nom }</td>
			                                                <td>${client.prenom }</td>
			                                                <td>${client.telephone }</td>
			                                                <td>${client.civilite }</td>
			                                                <td>${client.email }</td>
			                                                
			                                                <!-- View Détails -->
			                                                <c:url var="url_get_client" value="/client/get?id=${client.id }" />
			                                                <c:url var="url_delete_client" value="/client/delete?id=${client.id }" />
			                                                <td>
			                                               		<div class="dropdown">
								                                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Actions
																			<span class="caret"></span></button>
								                                    <ul class="dropdown-menu">
								                                        <li><i class="fa fa-eye"></i><a class="getClient" href="${url_get_client}"> View</a></li>
								                                        <li><i class="fa fa-pencil"></i><a href="#"> Edit</a></li>
								                                        <li><i class="fa fa-trash"></i><a class="deleteContrat" href="${url_delete_client}"> Delete</a></li>
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
                            
                            
                       <!-- Details Ajax -->
                       <div id="infoShow">
                          <div class="row">
                    			<div class="col-lg-12">
                        			<div class="card card-outline-primary">
                            			<div class="card-body">
                            			
                            				<c:url value="/client/edit" var ="urlEdit" />
                                			<f:form id="myforme" modelAttribute="client" action="${urlEdit }">
                                   		 		<div class="form-body">
                                   		 			<!-- # Contrat Détails -->
                                   		 			<h3 class="card-title m-t-4">Détails client</h3>
                                        			<hr>
                                        			<div class="row">
                                        				<div class="col-lg-12">
						        							<div class="form-group">
						        								<img id="cltImage" src="<c:url value="/resources/uploaded/user/${client.id}.png"/>" alt="image" class="img-circle" width="304" height="236" style="margin:0 410px;"/>
						        							</div>
						        						</div>
                                        				<div class="col-lg-6">
						        							<div class="form-group">
						        								<label>Nom :</label>
						        								<f:input path="nom" class="form-control"  />
						        								
						        								<f:input path="id" type="hidden" />
						        							</div>
						        						</div>
                                        				<div class="col-lg-6">
						        							<div class="form-group">
						        								<label>Prénom :</label>
						        								<f:input path="prenom" class="form-control"  />
						        							</div>
						        						</div>
						        						<div class="col-lg-6">
						        							<div class="form-group">
						        								<label>Téléphone :</label>
						        								<f:input path="telephone" class="form-control"  />
						        							</div>
						        						</div>
						        						<div class="col-lg-6">
						        							<div class="form-group">
						        								<label>Civilité :</label>
						        								<f:input path="civilite" class="form-control"  />
						        							</div>
						        						</div>
						        						<div class="col-lg-6">
						        							<div class="form-group">
						        								<label>Email :</label>
						        								<f:input path="email" class="form-control"  />
						        							</div>
						        						</div>
						        						<div class="col-lg-6">
						        							<div class="form-group">
						        								<label>Numéro permis :</label>
						        								<f:input path="numPermis" class="form-control"  />
						        							</div>
						        						</div>
                                   		 			</div>
                                   		 		</div><!-- # form-body -->	
                                   		 	<br>
                                   		 			
                                   		 			<!-- # Client Détails Address -->
                                   		 			<h3 class="card-title m-t-4">Address </h3>
                                        			<hr>
                                        			<div class="form-body">
                                        			<div class="row">
                                        				<div class="col-lg-6">
						        							<div class="form-group">
						        								<label>Rue :</label>
						        								<f:input id="street" path="address.street" class="form-control"  />
						        								<f:input id="idAddress" path="address.id" type="hidden" />
						        							</div>
						        						</div>
						        						<div class="col-lg-6">
						        							<div class="form-group">
						        								<label>Ville :</label>
						        								<!--<f:input id="city" path="address.city" class="form-control"  />-->
						        								<f:select id="city" path="address.city" class="form-control custom-select" required="true">
			                                                        <f:option selected="selected" value="" readonly="true" disabled="true">--Choisissez votre ville--</f:option>
			                                                        <f:option value="casablanca">Casablanca</f:option>
			                                                        <f:option value="rabat">Rabat</f:option>
			                                                        <f:option value="fes">Fes</f:option>
			                                                    </f:select>
						        							</div>
						        						</div>
						        						<div class="col-lg-6">
						        							<div class="form-group">
						        								<label>Etat :</label>
						        								<f:input id="state" path="address.state" class="form-control"  />
						        							</div>
						        						</div>
						        						<div class="col-lg-6">
						        							<div class="form-group">
						        								<label>Code postale :</label>
						        								<f:input id="postCode" path="address.postCode" class="form-control"  />
						        							</div>
						        						</div>
						        					</div>	
                                   		 		</div>
                                   		 		
                                   		 		<div class="form-actions">
                                        			<button type="submit" class="btn btn-warning"> <i class="fa fa-check"></i> Edit</button>
                                        			<button type="reset" class="btn btn-inverse">Cancel</button>
                                    			</div>
                                   		 		
                                   		 	</f:form><!-- # myForm --><br>
                            			</div><!-- # card-body -->
                            		</div><!-- # card card-outline-primary -->
                            	</div><!-- # col-lg-12 -->
                           </div><!-- # Row -->
                       </div><!-- # Detail Ajax -->
 
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