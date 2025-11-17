<%@page import="com.gf.entities.Usuario"%>
<%@page import="java.util.HashMap,java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<% 
	Map<String, String> mapaCategorias = (HashMap<String, String>) application.getAttribute("mapaCategorias");
	Usuario user = (Usuario) session.getAttribute("usuario");
%>
<head>
<meta charset="ISO-8859-1">
<title>Acceso</title>
</head>
<body>
	<form action="ServletUsuario" method="post">
		<h1>Datos Registro Desarrollo de Software</h1>
		<table>
			<tr>
				<td><label>Nombre:</label></td>
					
				<td><input type="text" name="nombre" value=<%=user.getNombre() %>></td>
			</tr>
			<tr>
				<td><label>Contraseña:</label></td>
				<td><input type="password" name="password" value=<%=user.getContraseña() %>></td>
				
			</tr>
			<tr>
				<td><label>Elige perfil:</label></td>
				
				 <td>
					<select name='cat'>
						<%
						for(String key : mapaCategorias.keySet()) {
							if(key.contains(user.getCategoriaProfesional())) {
						%>		
							<option value=<%=key %>><%= mapaCategorias.get(key) %></option>	
						<%		
							}
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td ><input type="submit" name="boton" value="Acceso"></td>
			</tr>
			<tr>
				<td><%=session.getAttribute("datosSesion") %></td>
			</tr>
		</table>
	</form>
</body>
</html>