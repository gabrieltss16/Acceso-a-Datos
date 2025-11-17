<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="entities.Cotizacion,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>COTIZAGF S.L.</h1>
	<table border="1">
	<tr><td>Ciclo</td>
	<td>Valor Anterior</td>
	<td>Valor Actual</td>
	<td>Condición</td></tr>
		<%
		HashMap<String, Cotizacion> cotizaciones = (HashMap<String, Cotizacion>) application.getAttribute("listCotiza");
			for (HashMap.Entry<String, Cotizacion> c : cotizaciones.entrySet()) {
		%>
		<tr>
			<td><%=c.getKey()%></td>
			<td><%=c.getValue().getAnterior()%></td>
			<td><%=c.getValue().getActual()%></td>
			<td><%=c.getValue().getEvalua()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<form action="ServletCotizacion" method="post">
	<input type="submit" name="boton" value="Volver">
	</form>
</body>
</html>