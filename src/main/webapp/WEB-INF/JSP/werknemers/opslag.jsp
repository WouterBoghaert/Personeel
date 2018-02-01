<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="nl">
	<head>
		<v:head title="Opslag voor ${werknemer.naam}"/>	
	</head>
	<body>
	<c:choose>
	<c:when test="${werknemer != null}">
		<h1>Opslag voor ${werknemer.naam}</h1>
		<dl>
			<dt>Huidig salaris</dt>
			<dd><spring:eval expression="werknemer.salaris"/></dd>
		</dl>
		<spring:url value="/werknemers/opslag/{werknemer}" var="url">
			<spring:param name="werknemer" value="${werknemer.id}"/>
		</spring:url>
		<form:form action="${url}" commandName="opslagForm" id="opslagForm">
			<form:label path="opslag">Bedrag<form:errors path="opslag" delimiter=", "/>
			</form:label>
			<form:input path="opslag" autofocus="autofocus" required="required"
			min="1" type="number" step="0.01"/>
			<form:hidden path="versie" value="${werknemer.versie}"/>
			<input type="submit" value="Opslag" id="opslagKnop">
			<form:errors cssClass="fout"/>
		</form:form>		
	</c:when>
	<c:otherwise>
		<div class="fout">Er is geen correcte werknemer geselecteerd!</div>
	</c:otherwise>
	</c:choose>
	<c:if test="${fout != null }">
		<div class="fout">${fout}</div>
	</c:if>
		<script>
			document.getElementById("opslagForm").addEventListener("submit", function() {
				document.getElementById("opslagKnop").disabled = true;
			});
		</script>
	</body>
</html>