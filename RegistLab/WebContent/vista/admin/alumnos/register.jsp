<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Alumno</title>
</head>
<body>
	<h1>Registrar Alumno</h1>
	<form action="adminSystem?action=register" method="post">
		<table border="1" align="center">
		<tr>
			<td><a>CUI:</a></td>		
			<td><input type="text" name="cui"/></td>	
		</tr>
		<tr>
			<td><a>Nombre:</a></td>		
			<td><input type="text" name="nombre"/></td>	
		</tr>
		<tr>
			<td><a>Apellido:</a></td>		
			<td><input type="text" name="apellidos"/></td>	
		</tr>
		<tr>
			<td><a>Correo:</a></td>		
			<td><input type="text" name="correo"/></td>	
		</tr>
		<tr>
			<td><a>asignatura:</a></td>		
			<td><input type="text" name="Idasignatura"value ='<c:out value="${ids}"></c:out>'/></td>	
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