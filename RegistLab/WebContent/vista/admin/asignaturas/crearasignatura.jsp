<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear asignatura</title>
</head>
<body>
<h1>Crear asignatura</h1>
	<form action="adminSystem?action=addasign" method="post">
		<table border="1" align="center">
		<tr>
			<td><a>Curso:</a></td>		
			<td><input type="text" name="curso"/></td>	
		</tr>
		<tr>
			<td><a>hora inicio:</a></td>		
			<td><input type="text" name="hor1"/></td>	
		</tr>
		<tr>
			<td><a>hora de salida</a></td>		
			<td><input type="text" name="hor2"/></td>	
		</tr>
		<tr>
			<td><a>fecha:</a></td>		
			<td><input type="text" name="hor3"/></td>	
		</tr>
		<tr>
			<td><a>grado:</a></td>		
			<td><input type="text" name="grado"/></td>	
		</tr>	
		<tr>
			<td><a>grupo:</a></td>		
			<td><input type="text" name="grupo"/></td>	
		</tr>
		<tr>
			<td><a>apellido del profesor:</a></td>		
			<td><input type="text" name="apellido"/></td>	
		</tr>	
		<tr>
			<td><a>Nombre del profesor:</a></td>		
			<td><input type="text" name="nombre"/></td>	
		</tr>
		<tr>
			<td><a>Limite de vacantes</a></td>		
			<td><input type="text" name="cantidad"/></td>	
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