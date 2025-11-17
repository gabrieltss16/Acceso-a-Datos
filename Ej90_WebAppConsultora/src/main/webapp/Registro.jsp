<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta char
set="ISO-8859-1">
<title>Datos Registro Desarrollo de Software</title>
</head>
<body>
	<form action="ServletUsuario" method="post">
		<h1>Datos Registro Desarrollo de Software</h1>
		<table>
			<tr>
				<td><label>Nombre:</label></td>
				<td><input type="text" name="nombre" ></td>

			</tr>
			<tr>
				<td><label>Contraseña:</label></td>
				<td><input type="password" name="password" ></td>
			</tr>
			<tr>
				<td><label>Categoría Profesional:</label></td>
				<td><input type="radio" name="categoria" value="C1" checked="checked">I 
				    <input type="radio" name="categoria" value="C2"> II
				    <input type="radio" name="categoria" value="C3">III
			    </td>
			</tr>
			<tr>
				<td><input type="submit" name="boton" value="Registro"></td>
			</tr>
		</table>
		<% if(request.getAttribute("sinDatos") != null) {%>
			<h4 style="color:red">(*) El nombre de usuario y la contraseña no pueden estar vacios</h4>
		<%} %>
	</form>

</body>
</html>