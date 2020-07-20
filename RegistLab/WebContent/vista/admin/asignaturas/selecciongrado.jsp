<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artículos Java Web JSP y Servlet</title>
</head>
<body>
	<h1>Escoge las asignaturas que desea ver</h1>
	<table border="1" width="50%" align="center">
		<tr>
			<td align="center"><a href="adminSystem?action=showas&id=1">Primer grado</a></td>			
		</tr>
		<tr>
			<td align="center"><a href="adminSystem?action=showas&id=2">Segundo grado</a></td>
		</tr>
		<tr>
			<td align="center"><a href="adminSystem?action=showas&id=3">Tercer grado</a></td>
		</tr>
		<tr>
			<td align="center"><a href="adminSystem?action=showas&id=4">Cuarto grado</a></td>
		</tr>
		<tr>
			<td align="center"><a href="adminSystem?action=showas&id=5">quinto año</a></td>
		</tr>
		<tr>
			<td align="center"><a href="adminSystem?action=createasign" >nueva asignatura</a> </td>
		</tr>
	</table>
</body>
</html>