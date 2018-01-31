<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<!doctype html>
<html lang="nl">
	<head>
		<v:head title="Personeel"/> 
	</head>
	<body>
	 <h1>Menu</h1>
	 <ul>
	 	<li><a href="<c:url value="/werknemers/werknemer"/>">Werknemershiërarchie</a></li>
	 	<li><a href="<c:url value="/jobtitels/jobtitels"/>">Jobtitels</a></li>
	 </ul>
	</body>
</html>