<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar asignatura</title>
</head>
<body>
<h1>Actualizar asignatura</h1>
	<form action="adminSystem?action=editarasign" method="post" >
			<table border="1" align="center">
		<tr>
			<td><a>Id:</a></td>		
			<td><input type="text" name="id" value='<c:out value="${asignatura.id}"></c:out>'/></td>	
		</tr>
		<tr>
			<td><a>Curso:</a></td>		
			<td><input type="text" name="curso" value = '<c:out value="${curso.curso_asign}"></c:out>'/></td>	
		</tr>
		<tr>
			<td><a>hora inicio:</a></td>		
			<td><input type="text" name="hor1"value= '<c:out value="${horario.hora_inicio}"></c:out>'/></td>	
		</tr>
		<tr>
			<td><a>hora de salida</a></td>		
			<td><input type="text" name="hor2" value= '<c:out value="${horario.hora_fin}"></c:out>'/></td>	
		</tr>
		<tr>
			<td><a>fecha:</a></td>		
			<td><input type="text" name="hor3" value='<c:out value="${horario.fecha}"></c:out>'/></td>	
		</tr>
		<tr>
			<td><a>grado:</a></td>		
			<td><input type="text" name="grado" value='<c:out value="${grado.grado_asign}"></c:out>'/></td>	
		</tr>	
		<tr>
			<td><a>grupo:</a></td>		
			<td><input type="text" name="grupo" value= '<c:out value="${grupo.grupo_asign}"></c:out>'/></td>	
		</tr>
		<tr>
			<td><a>apellido del profesor:</a></td>		
			<td><input type="text" name="apellido"value='<c:out value="${profesor.apellidos}"></c:out>'/></td>	
		</tr>	
		<tr>
			<td><a>Nombre del profesor:</a></td>		
			<td><input type="text" name="nombre"value='<c:out value="${profesor.nombres}"></c:out>'/></td>	
		</tr>
		<tr>
			<td><a>Limite de vacantes</a></td>		
			<td><input type="text" name="cantidad"value='<c:out value="${asignatura.capacidad}"></c:out>'/></td>	
		</tr>
		
	</table>
	<br>
	<table border="0" align="center">
		<tr>
		<td><input type="submit" value="Agregar" name="agregar"></td>	
		</tr>
	</table>
	</form>

</body>
</html>