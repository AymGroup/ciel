<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="left-sidebar">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <li class="nav-devider"></li>
                        <li class="nav-label">Home</li>
                        <li> <a href="#" aria-expanded="false"><i class="fa fa-tachometer"></i><span class="hide-menu">Dashboard </span></a>
                           <!-- <ul aria-expanded="false" class="collapse">
                                <li><a href="index.html">Ecommerce </a></li>
                                <li><a href="index1.html">Analytics </a></li>
                            </ul> --> 
                        </li>
                        <li class="nav-label">Main Menu</li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-paperclip"></i><span class="hide-menu">Réservations</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="#">Nouvelle réservation</a></li>
                                <li><a href="#">Mon planning</a></li>
                                <li><a href="#">Liste des réservations</a></li>
                                <li><a href="#">Liste des factures</a></li>
                                <li><a href="#">Liste des impayés</a></li>
                            </ul>
                        </li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-folder-open"></i><span class="hide-menu">Catégories</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="chart-flot.html">Nouvelle catégorie</a></li>
                                <li><a href="chart-morris.html">Liste des catégories</a></li>
                            
                            </ul>
                        </li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-road"></i><span class="hide-menu">Véhicules</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="#">Nouvelle véhicule</a></li>
                                <li><a href="#">Véhicule en service</a></li>
                                <li><a href="#">Véhicule hors service</a></li>
                                <li><a href="#">Liste des véhicules</a></li>
                            </ul>
                        </li>
                        
                        <!-- CLIENT MENU -->
                        <c:url value="/client/nouveau" var="url_client"></c:url>
                        <li class="nav-label">Main Menu</li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-user"></i><span class="hide-menu">Client</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="${url_client }">Nouveau client</a></li>
                                <li><a href="#">Liste des clients</a></li>
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
						<li> <a href="#" aria-expanded="false"><i class="fa fa-suitcase"></i><span class="hide-menu">Contrat propriétaire</span></a>
							<ul aria-expanded="false" class="collapse">
                                <li><a href="${url_contrat }">Nouveau contrat</a></li>
                                <li><a href="form-layout.html">Liste des contrats</a></li>
                            </ul>
						</li>
                        
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-table"></i><span class="hide-menu">Tables</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="table-bootstrap.html">Basic Tables</a></li>
                                <li><a href="table-datatable.html">Data Tables</a></li>
                            </ul>
                        </li>
                        <li class="nav-label"></li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-columns"></i><span class="hide-menu">Options</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="layout-blank.html">Blank</a></li>
                                <li><a href="layout-boxed.html">Boxed</a></li>
                     
                            </ul>
                        </li>
                        <li class="nav-label">EXTRA</li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-book"></i><span class="hide-menu">Pages <span class="label label-rouded label-success pull-right">8</span></span></a>
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
                        </li>
                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </div>