<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<!doctype html>
<html lang="nl">
	<head>
		<v:head title="Jobtitels"/>
	</head>
	<body>
		<h1>Jobtitels</h1>
		<c:forEach items="${jobtitels}" var="jobtitel">
			
		</c:forEach>
	</body>
</html>