<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="starter-template">
	<h1><spring:message code="donation.title" /></h1>
	<p class="lead"><spring:message code="donation.explain" /></p>
	<p class="lead"><spring:message code="donation.text" /></p>
	
	<div class="donateBtn">
		<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
			<input type="hidden" name="cmd" value="_s-xclick">
			<input type="hidden" name="hosted_button_id" value="MRH7F4GNMUKE6">
			<input type="image" src="<c:url value="/resources/icd/images/donate.png" />" width="250px" height="130px" border="0" name="submit" title="PayPal - Donate CAD$1.00!">
			<img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
		</form>
	</div>
</div>