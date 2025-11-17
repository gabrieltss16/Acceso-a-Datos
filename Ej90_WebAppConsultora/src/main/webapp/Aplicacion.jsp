<%@page import="java.util.ArrayList,java.util.List"%>
<%@page import="com.gf.entities.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%
	String userName = request.getParameter("nombre");
	Integer numAccesos = (Integer) application.getAttribute("numAccesos");
	List<Usuario> usuariosRegistrados = (ArrayList<Usuario>) application.getAttribute("usersReg");
%>
<head>
<meta charset="ISO-8859-1">
<title>Aplicación</title>
</head>
<body>
	<h1>Datos Registro Desarrollo de Software</h1>
	<p style="font-weight:bolder"><%= userName %> has accedido correctamente</p>
	<p style="font-weight:bolder">Nº de veces que se accede a la página registrso desde la aplicación: <%=numAccesos %></p>
	<table border="black solid 1px">
		<tr>
			<td style="font-weight:bolder">Usuarios registrados</td>
		</tr>
		<%for(Usuario usuario : usuariosRegistrados) {
		%>
			<tr>
				<td><%= usuario.getNombre()%></td>
			</tr>
		<%	
		}%>
	</table><br>
	<form action="Acceso.jsp">
		<input type="submit" name="boton" value="Acceso">
	</form>
</body>
</html>