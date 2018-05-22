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
    <title>Nouveau client - EC</title>
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
   
   
   <script type="text/javascript">
   		$(document).ready(function(){    
	    	$("#accord").hide();
		});
   </script>
   
    <script>

    	 $(document).ready(function(){
    	      
    	      $('.getContrat').click(function(e){
				  alert($(this).attr('href'));
				  e.preventDefault();
				  
    	    	  $.ajax({
    	              url : $(this).attr('href'),
    	              success : function(data) {
        	              
        	            var result="";
        	            datas = JSON.parse(data);
        	            $("#nom").val(datas.proprietaire.nom);
        	            $("#prenom").val(datas.reglement);
        	            $("#tel").val(datas.proprietaire.telephone);
        	            $("#civilite").val(datas.proprietaire.civilite);

        	           $("#accord").show();
        	            //$(".accordion").remove();
    	                $('#result').html(data);
    	              }
    	          });
    	    	  return false;
        	  });  
    	 });
    </script>
    
    <script type="text/javascript">
    	
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
                    <h3 class="text-primary">Espace Contrat Propriétaire</h3> </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Liste des contrats</li>
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
                                		<h4 class="card-title">Recherche contrats par propriétaires</h4>
                               			<hr>      			
                               				<div class="col-lg-6">
                               				<!-- Search form -->
                               					<c:url value="/contrat/chercher/${proprietaire.id }" var ="urlChercher" />
                               					<f:form action="${urlChercher}" modelAttribute="contrat">
                               					<div class="form-group">
                               						<label>Propriétaire</label>
                                                    <f:select id="proprietaire.id" path="proprietaire.id" class="form-control custom-select" required="true">
                                                        <f:option selected="selected" value="" readonly="true" disabled="true">-- Veuillez sélectionner un propriétaire --</f:option>
                                                        
                                                        <c:forEach var="proprietaire"  items="${proprietaires}">
                                                        	<f:option value="${proprietaire.id }">${proprietaire.nom} ${proprietaire.prenom}</f:option>
                                                        </c:forEach>   
                                                                                                         
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
                	
                	<p id="result" ></p>
					<h3>${exist}</h3>
                			<div class="row">
                               	<div class="col-lg-12">	
                               		<div class="card">	
                               			<div class="card-body">
                               				<c:if test = "${empty prop}">
                               					<h4 class="card-title">Liste des contrats propriétaires</h4>
                               				</c:if>
                               				<c:if test = "${not empty prop}">
                               					<h4 class="card-title">Liste des contrats pour le propriétaire : ${prop}</h4>
                               				</c:if>
                               				<hr>  
                                			<div class="table-responsive m-t-5">
                                    			<table id="myTable" class="table table-bordered table-striped">
                                        			<thead>
			                                            <tr>
			                                                <th>#</th>
			                                                <th>Description</th>
			                                                <th>Date du début du contrat</th>
			                                                <th>Date de fin du contrat</th>
			                                                <th>Tarif</th>
			                                                <th>Actions +</th>
			                                                <th>Opérations</th>
			                                            </tr>
			                                        </thead>
			                                        <tbody>
			                                        
			                                        <c:forEach var="contrat" items="${contrats}">
			                                            <tr>
			                                                <td>${contrat.id }</td>
			                                                <td>${contrat.description }</td>
			                                                <td>${contrat.dateDebut }</td>
			                                                <td>${contrat.dateFin }</td>
			                                                <td>${contrat.tarif }</td>
			                                                <c:url var="url_get_contrat" value="/contrat/get?id=${contrat.id }" />
			                                                <td>
			                                                	<a class="getContrat" href="${url_get_contrat}">Voir</a>
			                                                </td>
			                                                
			                                                <td>
			                                               		<div class="dropdown">
								                                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Actions
																			<span class="caret"></span></button>
								                                    <ul class="dropdown-menu">
								                                        <li><i class="fa fa-eye"></i><a href="#"> View</a></li>
								                                        <li><i class="fa fa-pencil"></i><a href="#"> Edit</a></li>
								                                        <li><i class="fa fa-trash"></i><a href="#"> Delete</a></li>
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
                            
                            <div class="row">
                            	<div class="col-lg-12">
                            		<div id="accord" class="accordion">
					                	<div class="card">
					    					<div class="card-header" id="headingOne">
											      <h5 class="mb-0">
											        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
														Informations sur le propriétaire 
											        </button>
											      </h5>
					    				   </div><br><br>
					
					    				<div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
					      					<div class="card-body">
					        					<form>
						        					<div class="row">
	                                            		<div class="col-md-6">
						        							<div class="form-group">
						        								<label>Nom :</label>
						        								<input id="nom" type="text" class="form-control"/>
						        							</div>
						        						</div>
						        						<div class="col-md-6">
						        							<div class="form-group">
						        								<label>Prénom :</label>
						        								<input id="prenom" type="text" class="form-control"/>
						        							</div>
						        						</div>
						        						<div class="col-md-6">
						        							<div class="form-group">
						        								<label>Téléphone :</label>
						        								<input id="tel" type="text" class="form-control"/>
						        							</div>
						        						</div>
						        						<div class="col-md-6">
						        							<div class="form-group">
						        								<label>Civilité :</label>
						        								<input id="civilite" type="text" class="form-control"/>
						        							</div>
						        						</div>
						        					</div>
					        					</form>
					      					</div><!-- # card-body -->
					    				</div><!-- # collapseOne -->
					  				</div><!-- # card -->
					              </div><!-- # accordion -->
                            	</div><!-- # col-lg-12 -->
                            </div><!-- # Row -->
                            
                          	
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