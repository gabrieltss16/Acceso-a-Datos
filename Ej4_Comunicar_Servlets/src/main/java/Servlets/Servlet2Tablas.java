package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet2Tablas
 */
@WebServlet("/Servlet2Tablas")
public class Servlet2Tablas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2Tablas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		Integer numero = (Integer) request.getAttribute("numero");
        String color = (String) request.getAttribute("color");

        if (color == null) color = "verde";

        // Mapear color
        String bgColor = switch (color.toLowerCase()) {
            case "rojo"     -> "Red";
            case "verde"    -> "Green";
            case "azul"     -> "Blue";
            case "naranja"  -> "Orange";
            default         -> "#cccccc";
        };

        response.getWriter().append("<!DOCTYPE html>\n")
				              .append("<html lang='es'>\n")
				              .append("<head>\n")
				              .append("    <meta charset='UTF-8'>\n")
				              .append("    <title>Tabla del ").append(String.valueOf(numero)).append("</title>\n")
				              .append("    <style>\n")
				              .append("        body {font-family:Arial,sans-serif;text-align:center;margin-top:50px;}\n")
				              .append("        table {margin:20px auto;border-collapse:collapse;}\n")
				              .append("        td {border:1px solid black;padding:8px 15px;background-color:").append(bgColor).append(";}\n")
				              .append("        .volver {margin-top:30px;}\n")
				              .append("        .volver a {color:blue;text-decoration:underline;font-size:16px;}\n")
				              .append("    </style>\n")
				              .append("</head>\n")
				              .append("<body>\n")
				              .append("    <h2>Tabla de multiplicar del ").append(String.valueOf(numero)).append("</h2>\n")
				              .append("    <hr>\n")
				              .append("    <table>\n");

        for (int i = 1; i <= 10; i++) {
            response.getWriter().append("        <tr>\n")
				                  .append("            <td>").append(String.valueOf(numero)).append(" x ").append(String.valueOf(i)).append("</td>\n")
				                  .append("            <td>").append(String.valueOf(numero * i)).append("</td>\n")
				                  .append("        </tr>\n");
        }

        response.getWriter().append("    </table>\n")
				              .append("    <hr>\n")
				              .append("    <div class='volver'>\n")
				              .append("        <a href='index2.html'>Volver</a>\n")
				              .append("    </div>\n")
				              .append("</body>\n")
				              .append("</html>");
	}

}
