<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu del administrador</title>
</head>
<body>
	<h1>Bienvenido, admin</h1>
	<table border="1" width="50%" align="center">
		<tr>
			<td align="center"><a href="adminSystem?action=gotoasign">Asignaturas</a></td>			
		</tr>
		<tr>
			<td align="center"><a href="adminSystem?action=gotoalumn">Registros de matriculas</a></td>
		</tr>
		<tr>
			<td align="center"><a href="adminSystem?action=showchangepassword">Cambiar de contraseña</a></td>
		</tr>
		<tr>
			<td align="center"><a href="adminSystem?action=showchangesystem">Establecer apertura de sistema</a></td>
		</tr>
		<tr>
			<td align="center"><a href="adminSystem?action=index">Volver</a></td>
		</tr>
	</table>
</body>
</html>