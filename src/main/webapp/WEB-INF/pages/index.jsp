<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>  
    <title>:: ICD-10 ::</title>
    <link href="<c:url value="/resources/icd/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/icd/css/icd.css" />" rel="stylesheet">
    
    <script src="<c:url value="/resources/icd/js/jquery-min.js" />"></script>
    <script src="<c:url value="/resources/icd/js/bootstrap.js" />"></script>
    <script src="<c:url value="/resources/icd/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/icd/js/icd.js" />"></script>
    <script src="<c:url value="/resources/icd/js/controller/icd_controller.js" />"></script>
    <script src="<c:url value="/resources/icd/js/service/icd_service.js" />"></script>
    <script src="<c:url value="/resources/icd/js/directives/icd_directives.js" />"></script>

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
						<a class="navbar-brand" href="#">ICD-10</a>
					</div>
					<div id="navbar" class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li ng-class="{active : menu == 'search'}"><a href="#" ng-click="menuChange('search')">Search</a></li>
							<li ng-class="{active : menu == 'classification'}"><a href="#" ng-click="menuChange('classification')">Classification</a></li>
							<li ng-class="{active : menu == 'donation'}"><a href="#" ng-click="menuChange('donation')">Donation</a></li>
						</ul>
					</div>
				</div>
			</nav>
			
			<div class="container">
				<div ng-switch="menu">
					<div ng-switch-when="search" search-page></div>
					<div ng-switch-when="classification" classification-page></div>
					<div ng-switch-when="donation" donation-page></div>
				</div>
			</div>
		</div>	
	</body>

</html>