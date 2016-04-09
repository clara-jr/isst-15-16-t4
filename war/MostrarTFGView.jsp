<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="css/main.css" /> -->
<title>TFG</title>
</head>
<body>
<p>Sistema de gestión de TFGs</p>
<c:if test="${not empty user}">
	<c:out value="${user}" />
	<p>Puedes pulsar el siguiente enlace para salir
	<a href="<c:url value="${url}"/>"><c:out value="${urlLinktext}"/></a></p>
	<c:if test="${empty tfg}">
		<p>Puedes pulsar el siguiente enlace para solicitar un TFG
		<a href="<c:url value="SolicitarTFGView.jsp"/>"><c:out value="Solicitar TFG"/>/<a></p>
	</c:if>
	<c:if test="${not empty tfg}">
		<p>Este es su TFG solicitado:
		<tr>
			<td><c:out value="${tfg.autor}" /></td>
			<td><c:out value="${tfg.titulo}" /></td>
			<td><c:out value="${tfg.resumen}" /></td>
			<td><c:out value="${tfg.tutor}" /></td>
			<td><c:out value="${tfg.secretario}" /></td>
			<td><c:out value="${tfg.estado}" /></td>
		</tr>
		<c:if test="${tfg.estado lt 2}">
			Sin memoria.
		</c:if>
	</c:if>
	<c:if test="${not empty tfgs}">
		<p>TFGs registrados:
		<c:forEach items="${tfgs}" var="tfg">
			<tr>
				<td><c:out value="${tfg.autor}" /></td>
				<td><c:out value="${tfg.titulo}" /></td>
				<td><c:out value="${tfg.resumen}" /></td>
				<td><c:out value="${tfg.tutor}" /></td>
				<td><c:out value="${tfg.estado}" /></td>
			</tr>
		</c:forEach>
	</c:if>
</c:if>
<c:if test="${empty user}">
	<c:out value="${user}" />
	<p>Puedes pulsar el siguiente enlace para entrar
	<a href="<c:url value="${url}"/>"><c:out value="${urlLinktext}"/></a></p>
</c:if>
</body>
</html>