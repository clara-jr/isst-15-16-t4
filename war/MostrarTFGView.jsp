<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>Insert title here</title>
</head>
<body>
<p>Sistema de gestión de TFGs</p>
<c:if test="${user != null}">
	<c:out value="${user}" />
</c:if>
<p>Puedes pulsar el siguiente enlace para entrar/salir
<a href="<c:url value="${url}"/>"><c:out value="${urlLinktext}"/></a></p>
<c:forEach items="${tfgs}" var="tfg">
		<tr>
			<td><c:out value="${tfg.autor}" /></td>
			<td><c:out value="${tfg.titulo}" /></td>
			<td><c:out value="${tfg.resumen}" /></td>
			<td><c:out value="${tfg.tutor}" /></td>
			<td><c:out value="${tfg.estado}" /></td>
		</tr>
</c:forEach>
</body>
</html>