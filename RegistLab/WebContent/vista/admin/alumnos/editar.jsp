<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Alumno</title>
</head>
<body>
<h1>Actualizar Alumno</h1>
	<form action="adminSystem?action=editar" method="post" >
		<table>
			<tr>
				<td><label>Id</label></td>
				<td><input type="text" name="id" value="<c:out value="${alumno.id}"></c:out>" ></td>
			</tr>
			<tr>
				<td><label>Código</label></td>
				<td><input type="text" name="cui" value='<c:out value="${alumno.CUI}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="nombre" value='<c:out value="${alumno.nombres}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Descripción</label></td>
				<td><input type="text" name="apellidos" value='<c:out value="${alumno.apellidos}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Existencia</label></td>
				<td><input type="text" name="correo" value='<c:out value="${alumno.correo}"></c:out>' ></td>
			</tr>
			
			<tr>
				<td><label>Precio</label></td>
				<td><input type="text" name="Idasignatura" value='<c:out value="${alumno.asignatura}"></c:out>' ></td>
			</tr>
		</table>
	
		<input type="submit" name="registrar" value="Guardar"> 
	</form>

</body>
</html>