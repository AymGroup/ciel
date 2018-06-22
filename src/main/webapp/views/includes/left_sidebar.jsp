<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="left-sidebar">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <li class="nav-devider"></li>
                        <li class="nav-label">Home</li>
                         <c:url value="/dashboard/show" var="url_dashboard"></c:url>
                        <li> <a href="${url_dashboard }" aria-expanded="false"><i class="fa fa-tachometer"></i><span class="hide-menu">Dashboard </span></a>
                           <!-- <ul aria-expanded="false" class="collapse">
                                <li><a href="index.html">Ecommerce </a></li>
                                <li><a href="index1.html">Analytics </a></li>
                            </ul> --> 
                        </li>
                        <!-- RESERVATION MENU -->
                        <c:url value="/reservation/nouveau" var="url_reservation"></c:url>
                        <li class="nav-label">Main Menu</li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-paperclip"></i><span class="hide-menu">Réservations</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="${url_reservation }">Nouvelle réservation</a></li>
                                <li><a href="#">Mon planning</a></li>
                                <li><a href="#">Liste des réservations</a></li>
                                <li><a href="#">Liste des factures</a></li>
                                <li><a href="#">Liste des impayés</a></li>
                            </ul>
                        </li>
                        <!-- CATEGORIE MENU -->
                        <c:url value="/categorie/nouveau" var="url_categorie"></c:url>
                        <c:url value="/categorie/getCategories" var="url_categorie_list"></c:url>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-folder-open"></i><span class="hide-menu">Catégories</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="${url_categorie }">Nouvelle catégorie</a></li>
                                <li><a href="${url_categorie_list }">Liste des catégories</a></li>
                            
                            </ul>
                        </li>
                        <!-- VEHICULE MENU -->
                        <c:url value="/vehicule/nouveau" var="url_vehicule"></c:url>
                        <c:url value="/vehicule/getVehicules" var="url_vehicule_list"></c:url>
                        <c:url value="/reservation/showVehiculesOnService" var="url_vehicule_service"></c:url>
                        <c:url value="/reservation/showVehiculesHorsService" var="url_vehicule_hors_service"></c:url>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-road"></i><span class="hide-menu">Véhicules</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="${url_vehicule }">Nouvelle véhicule</a></li>
                                <li><a href="${url_vehicule_service }">Véhicule en service</a></li>
                                <li><a href="${url_vehicule_hors_service }">Véhicule hors service</a></li>
                                <li><a href="${url_vehicule_list }">Liste des véhicules</a></li>
                            </ul>
                        </li>
                        
                        <!-- CLIENT MENU -->
                        <c:url value="/client/nouveau" var="url_client"></c:url>
                        <c:url value="/client/getClients" var="url_client_list"></c:url>
                        <li class="nav-label">Main Menu</li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-user"></i><span class="hide-menu">Client</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="${url_client }">Nouveau client</a></li>
                                <li><a href="${url_client_list }">Liste des clients</a></li>
                            </ul>
                        </li>

                        <!-- PROPRIETAIRE MENU -->
                        <c:url value="/proprietaire/nouveau" var="url_prop"></c:url>    
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-user"></i><span class="hide-menu">Propriétaires</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="${url_prop }">Nouveau propriétaire</a></li>
                                <li><a href="form-layout.html">Liste des propriétaire</a></li>
                            
                            </ul>
                        </li>
                        
                        <!-- CONTRAT MENU -->
                        <c:url value="/contrat/nouveau" var="url_contrat"></c:url> 
                        <c:url value="/contrat/getContrats" var="url_contrat_list"></c:url>   
						<li> <a class="has-arrow" href="#" aria-expanded="false"><i class="fa fa-suitcase"></i><span class="hide-menu">Contrat propriétaire</span></a>
							<ul aria-expanded="false" class="collapse">
                                <li><a href="${url_contrat }">Nouveau contrat</a></li>
                                <li><a href="${url_contrat_list }">Liste des contrats</a></li>
                            </ul>
						</li>
                        
                        
                        <li class="nav-label">EXTRA</li>
						<c:url value="/email/show" var="url_mail"></c:url> 
						<c:url value="/email/showAll" var="url_mails_list"></c:url> 
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-envelope"></i><span class="hide-menu">Email</span></a>
                            <ul aria-expanded="false" class="collapse">
                               <li><a href="${url_mail }">Nouveau email</a></li>
                                <li><a href="${url_mails_list }">Liste des emails</a></li>
                            </ul>
                        </li>
                        
                        <c:url value="/pack/nouveau" var="url_pack"></c:url> 
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-cog"></i><span class="hide-menu">Pack</span></a>
                            <ul aria-expanded="false" class="collapse">
                               <li><a href="${url_pack }">Nouveau pack</a></li>
                                <li><a href="layout-boxed.html">Liste des packs</a></li>
                            </ul>
                        </li>
                        
                        <c:url value="/logout" var="url_logout"></c:url> 
                        <li style="margin-top: 335px;"> <a  href="${url_logout }" aria-expanded="false"><i class="fa fa-arrow-right"></i><span class="hide-menu">Logout</span></a>
                            
                        </li>
                        <!--<li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-book"></i><span class="hide-menu">Pages <span class="label label-rouded label-success pull-right">8</span></span></a>
                            <ul aria-expanded="false" class="collapse">

                                <li><a href="#" class="has-arrow">Authentication <span class="label label-rounded label-success">6</span></a>
                                    <ul aria-expanded="false" class="collapse">
                                        <li><a href="page-login.html">Login</a></li>
                                        <li><a href="page-register.html">Register</a></li>
                                        <li><a href="page-invoice.html">Invoice</a></li>
                                    </ul>
                                </li>
                                <li><a href="#" class="has-arrow">Error Pages</a>
                                    <ul aria-expanded="false" class="collapse">
                                        <li><a href="page-error-400.html">400</a></li>
                                        <li><a href="page-error-403.html">403</a></li>
                                        <li><a href="page-error-404.html">404</a></li>
                                        <li><a href="page-error-500.html">500</a></li>
                                        <li><a href="page-error-503.html">503</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-map-marker"></i><span class="hide-menu">Maps</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="map-google.html">Google</a></li>
                                <li><a href="map-vector.html">Vector</a></li>
                            </ul>
                        </li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-level-down"></i><span class="hide-menu">Multi level dd</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="#">item 1.1</a></li>
                                <li><a href="#">item 1.2</a></li>
                                <li> <a class="has-arrow" href="#" aria-expanded="false">Menu 1.3</a>
                                    <ul aria-expanded="false" class="collapse">
                                        <li><a href="#">item 1.3.1</a></li>
                                        <li><a href="#">item 1.3.2</a></li>
                                        <li><a href="#">item 1.3.3</a></li>
                                        <li><a href="#">item 1.3.4</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">item 1.4</a></li>
                            </ul>
                        </li>-->
                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </div>