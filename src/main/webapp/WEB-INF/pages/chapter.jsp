<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="row">
	<div ng-repeat="chapter in chapters" class="col-md-4 chapter-row" >
		<div class="row">
			<div class="col-md-3">
				<span class="chapterNumber">{{chapter.id}}</span>
			</div>
			<div class="col-md-9">
				<span ng-click="categoryGo(chapter)" class="chapterTitle"><spring:message code="word.chapter" /> {{chapter.id}}</span>
				<br />
				<span>{{chapter.descripion}}</span>
			</div>
		</div>
	</div>
</div>