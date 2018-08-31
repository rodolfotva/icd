<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:message code="classification.chapter.bread" var="chapterBreadTitle"/>
<spring:message code="classification.group.bread" var="groupBreadTitle"/>
<div class="starter-template">
	<h1><spring:message code="donation.title" /></h1>
	<p class="lead"><spring:message code="donation.explain" /></p>
</div>
<div class="bread">
<span class="breadStep" ng-if="chapterBread != ''" ng-click="chapterGo()" title="${chapterBreadTitle}"><spring:message code="word.chapter" /> {{chapterBread}} > </span>
<span class="breadStep" ng-if="groupBread != ''" ng-click="categoryGo(chapterObj)" title="${groupBreadTitle}"><spring:message code="word.group" /> {{groupBread}} </span>
</div>
<div ng-switch="steps">
	<div ng-switch-when="chapter" chapter-page></div>
	<div ng-switch-when="group" group-page></div>
	<div ng-switch-when="category" category-page></div>
</div>