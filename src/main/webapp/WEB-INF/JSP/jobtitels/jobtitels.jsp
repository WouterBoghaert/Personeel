<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="nl">
	<head>
		<v:head title="Jobtitels"/>
	</head>
	<body>
		<h1>Jobtitels</h1>
		<p>
		<c:forEach items="${jobtitels}" var="jobtitel">
			<spring:url value="/jobtitels/jobtitels/{id}" var="url">
				<spring:param name="id" value="${jobtitel.id}"/> 
			</spring:url>
			<a href="${url}">${jobtitel.naam}</a> 
		</c:forEach>
		</p>
		<c:if test="${not empty werknemers}">
			<h1>${jobtitel.naam}</h1>
			<ul>
				<c:forEach items="${werknemers}" var="werknemer">
					<spring:url value="/werknemers/werknemer/{id}" var="url">
						<spring:param name="id" value="${werknemer.id}"/>
					</spring:url>
					<li><a href="${url}">${werknemer.naam}</a></li>
				</c:forEach>
			</ul>
		</c:if>
		<c:if test="${empty werknemers and not empty jobtitel}">
			<p>Er zijn geen werknemers gevonden met deze jobtitel.</p>
		</c:if>
		<c:if test="${fout != null}">
			<div class="fout">${fout}</div>
		</c:if>
	</body>
</html>