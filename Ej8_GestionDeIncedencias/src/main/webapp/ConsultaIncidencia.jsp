<%@page import="java.util.ArrayList,com.gf.E8_GestionDeIncedencias.model.Incidencia"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList<Incidencia> list = (ArrayList<Incidencia>) application.getAttribute("listInc");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Código</td>
			<td>Tema</td>
			<td>Descripcion</td>
		</tr>
		<% for(Incidencia inc:list) {%>
		<tr>
			<td><%=inc.getCodigo() %></td>
			<td><%=inc.getTema() %></td>
			<td><%=inc.getDescripcion() %></td>
		</tr>
		<%} %>
	</table>
	<form action="ServletIncidencia" method="post">
	<input type="submit" name="boton" value="Volver"/>
	</form>
</body>
</html>