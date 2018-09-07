<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:message code="search.fieldicd.explain" var="descSearchHolder"/>
<spring:message code="search.fielddesc.explain" var="icdSearchHolder"/>
<div class="starter-template">
	<h1><spring:message code="donation.title" /></h1>
	<p class="lead"><spring:message code="search.explanation" /></p>
</div>
<div class="row" style="padding-bottom: 50px">
	<form name="searchIcd">
		<div class="col-md-2"></div>
		<div class="col-md-3">
			<input type="text" class="form-control" placeholder="${descSearchHolder}"  ng-focus="descSearch = '' " ng-model="icdSearch">
		</div>
		<div class="col-md-4">
			<input type="text" class="form-control" placeholder="${icdSearchHolder}" ng-focus="icdSearch = '' " ng-model="descSearch">
		</div>
		<div class="col-md-3">
			<button type="button" class="btn btn-default"  ng-click="search()" ng-disabled="searching" ><i ng-if="searching" class="fa fa-spinner fa-spin" style="font-size:18px" ></i> <spring:message code="world.search" /></button>
		</div>
	</form>
</div>			
<div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th><spring:message code="world.icd" /></th>
				<th><spring:message code="world.description" /></th>
			</tr>
		</thead>
		<tbody ng-repeat="result in searchResult">
			<tr>
				<td><div ng-bind-html="result.name | searchIcdFilter:icdSearch" /></td>
				<td><div ng-bind-html="result.description | searchDescFilter:descSearch" /></td>
			</tr>
			<tr ng-repeat="sub in result.subGroups">
				<td><div ng-bind-html="sub.name | searchIcdFilter:icdSearch" /></td>
				<td><div ng-bind-html="sub.description | searchDescFilter:descSearch" /></td>
			</tr>
		</tbody>
	</table>
</div>