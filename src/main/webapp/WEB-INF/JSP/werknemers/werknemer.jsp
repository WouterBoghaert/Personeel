<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="nl">
	<head>
		<v:head title="Werknemer ${werknemer.naam}"/>
	</head>
	<body>
	<c:choose>
		<c:when test="${not empty werknemer}">
			<h1>Werknemer ${werknemer.naam}</h1>
			<c:if test="${param.optimisticlockingexception}">
				<div class="fout">Werknemer werd door een andere gebruiker als volgt gewijzigd:</div>
			</c:if>
			<dl>
				<dt>Voornaam</dt>
				<dd>${werknemer.voornaam}</dd>
				<dt>Familienaam</dt>
				<dd>${werknemer.familienaam}</dd>
				<dt>Email adres</dt>
				<dd>${werknemer.email}</dd>
				<dt>Salaris</dt>
				<dd><spring:eval expression="werknemer.salaris"/></dd>
				<dt>Jobtitel</dt>
				<dd>${werknemer.jobtitel.naam}</dd>
				<c:if test="${werknemer.chef != null}">
					<spring:url var="url" value="/werknemers/werknemer/{id}">
						<spring:param name="id" value="${werknemer.chef.id}"/>
					</spring:url>
					<dt>Chef</dt>
					<dd><a href="${url}">${werknemer.chef.naam}</a></dd>
				</c:if>
				<c:if test="${not empty ondergeschikten}">
					<dt>Ondergeschikten</dt>
					<dd>
					<c:forEach items="${ondergeschikten}" var="ondergeschikte">					
							<spring:url var="url" value="/werknemers/werknemer/{id}">
								<spring:param name="id" value="${ondergeschikte.id}"/>
							</spring:url>
							<a href="${url}">${ondergeschikte.naam}</a><br>					
					</c:forEach>
					</dd>
				</c:if>
				<dt>Foto</dt>
				<dd><img alt="${werknemer.naam}" src="<c:url value="/images/${werknemer.id}.jpg"/>"></dd>			
			</dl>
			<p>
				<spring:url var="url" value="/werknemers/opslag/{id}">
					<spring:param name="id" value="${werknemer.id}"/>
				</spring:url>
				<a href="${url}">Opslag</a>
			</p>
		</c:when>
		<c:otherwise>
			<div class="fout">Er is geen geldige werknemer geselecteerd!</div>
		</c:otherwise>
	</c:choose>
	</body>
</html>