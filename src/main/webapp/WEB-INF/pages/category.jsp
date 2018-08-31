<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="row">
	<div ng-repeat="category in categorys" class="col-md-6 group-row">
		<div class="row">
			<div class="col-md-12">
				<span ng-click="groupGo(category)" class="chapterTitle"><spring:message code="word.group" /> {{category.first}} <spring:message code="word.to" /> {{category.last}}</span>
				<br />
				<span>{{category.title}}</span>
			</div>
		<div>
	</div>
</div>
