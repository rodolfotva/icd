<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th><spring:message code="world.icd" /></th>
				<th><spring:message code="world.description" /></th>
			</tr>
		</thead>
		<tbody ng-repeat="group in groups">
			<tr>
				<td>{{group.name}}</td>
				<td>{{group.description}}</td>
			</tr>
			<tr ng-repeat="subgroup in group.subGroups">
				<td>{{subgroup.name}}</td>
				<td>{{subgroup.description}}</td>
			</tr>
		</tbody>		
	</table>
</div>