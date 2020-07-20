<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Alumnos</title>
</head>
<body>
	<h1>Lista  Alumnos</h1>
	
	
	<c:forEach var ="asignatura" items="${asignaturas}" varStatus = "loop">
		<table border="1" width ="100%">
			<tr>
				<td><c:out value="${asignatura.id}"/></td>
				<td><c:out value="${asignatura.curso}"/></td>
				<td><c:out value="${asignatura.horario}"/></td>
				<td><c:out value="${asignatura.grado}"/></td>
				<td><c:out value="${asignatura.grupo}"/></td>
				<td><c:out value="${asignatura.profesor}"/></td>
				<td><c:out value="${asignatura.capacidad}"/></td>
				<td>editar</td>
				<td><a href="adminSystem?action=nuevo&id=<c:out value="${asignatura.id}"/>">Agregar Alumno</a> </td>				
			</tr>
			<c:forEach var = "alumno" items = "${alumnos}">
			<tr>
				<td><c:out value="${alumno[loop.index].id}"/></td>
				<td><c:out value="${alumno[loop.index].apellidos}"/></td>
				<td><c:out value="${alumno[loop.index].CUI}"/></td>
				<td><c:out value="${alumno[loop.index].nombres}"/></td>
				<td><c:out value="${alumno[loop.index].correo}"/></td>
				<td><c:out value="${alumno[loop.index].asignatura}"/></td>
				<td><a href="adminSystem?action=showedit&id=<c:out value="${alumno[loop.index].id}" />">Editar</a></td>
				<td><a href="adminSystem?action=eliminar&id=<c:out value="${alumno[loop.index].id}"/>">Eliminar</a> </td>				
			</tr>
			</c:forEach>			
		</table>
	</c:forEach>
</body>
</html>