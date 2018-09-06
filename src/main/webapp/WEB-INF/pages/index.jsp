<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
  <head>  
    <title>:: ICD-10 ::</title>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1" />
    
    <link href="<c:url value="/resources/icd/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/icd/css/icd.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    
    <script src="<c:url value="/resources/icd/js/jquery-min.js" />"></script>
    <script src="<c:url value="/resources/icd/js/bootstrap.js" />"></script>
    <script src="<c:url value="/resources/icd/js/angular173.js" />"></script>
    <script src="<c:url value="/resources/icd/js/icd.js" />"></script>
    <script src="<c:url value="/resources/icd/js/controller/icd_controller.js" />"></script>
    <script src="<c:url value="/resources/icd/js/service/icd_service.js" />"></script>
    <script src="<c:url value="/resources/icd/js/directives/icd_directives.js" />"></script>
    <script src="<c:url value="/resources/icd/js/filters/icd_filters.js" />"></script>
    
    <script src="<c:url value="/resources/icd/js/angular-sanitize173.js" />"></script>
    <script src="<c:url value="/resources/icd/js/angular-animate173.js" />"></script>
    <script src="<c:url value="/resources/icd/js/angular-resource173.js" />"></script>

  </head>
  	<body ng-app="icd" class="ng-cloak">
		<div ng-controller="IcdController">
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"><spring:message code="menu.title" /></a>
					</div>
					<div id="navbar" class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li ng-class="{active : menu == 'search'}"><a href="#" ng-click="menuChange('search')"><spring:message code="menu.search" /></a></li>
							<li ng-class="{active : menu == 'classification'}"><a href="#" ng-click="menuChange('classification')"><spring:message code="menu.classification" /></a></li>
							<li ng-class="{active : menu == 'donation'}"><a href="#" ng-click="menuChange('donation')"><spring:message code="menu.donation" /></a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
			              <li><a href="/Icd/en/" title="English"><img src="<c:url value="/resources/icd/images/usa.png" />" height="16" width="16" /></a></li>
			              <li><a href="/Icd/fr/" title="Français"><img src="<c:url value="/resources/icd/images/france.png" />" height="16" width="16" /></a></li>
			              <li><a href="/Icd/pt/" title="Portugues"><img src="<c:url value="/resources/icd/images/brazil.png" />" height="16" width="16" /></a></li>
            			</ul>
					</div>
				</div>
			</nav>
			
			<div class="container_icd container" >
				<div ng-switch="menu">
					<div ng-switch-when="search" search-page></div>
					<div ng-switch-when="classification" classification-page></div>
					<div ng-switch-when="donation" donation-page></div>
				</div>
			</div>

			<div class="footer">
				<div class="footer-copyright text-center py-3">© 2018 Copyright:
				  <a href="https://www.myicd10.com/"> myicd10.com</a>
				</div>
			</div>
		</div>	
	</body>

</html>