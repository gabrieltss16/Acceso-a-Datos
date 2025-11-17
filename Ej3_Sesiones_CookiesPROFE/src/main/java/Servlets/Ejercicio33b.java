package Servlets;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio3b
 */
@WebServlet("/Ejercicio33b")
public class Ejercicio33b extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HashMap<String, String> lib = getServletConfig().getServletContext().getAttribute("libros") != null
				? (HashMap<String, String>) getServletConfig().getServletContext().getAttribute("libros")
				: new HashMap<String, String>();
		Cookie cookies[] = request.getCookies();
		Double sum = 0.00;
		response.setContentType("text/html");
		response.getWriter().append("<html><body>");
		if (cookies != null && cookies.length != 0) {
			response.getWriter().append("<h1 >Compra Total</h1>").append("<table  border='1'>").append("<tr>")
					.append("<td  ><strong><b>Titulo del Libro</b></strong></td>")
					.append("<td  ><strong><b>Unidades</b></strong></td>")
					.append("<td  ><strong><b>Precio</b></strong></td>").append("</tr>");
			for (Cookie cookie : cookies) {
				//if (!cookie.getName().equalsIgnoreCase("jsessionid")) {
					response.getWriter().append("<tr>").append("<td>" + cookie.getName() + "</td><td>"
							+ cookie.getValue() + "</td><td>" + lib.get(cookie.getName()) + "</td>").append("</tr>");
					sum = sum + (Double.parseDouble(cookie.getValue()) * Double.parseDouble(lib.get(cookie.getName())));
					// Elimina los cookies del navegador
					//cookie.setMaxAge(0);
					response.addCookie(cookie);
				//}
			}
			response.getWriter().append("</table>").append("<br>").append("<h2><b>Total:  " + sum + "</b></h2>");

		} else {
			response.getWriter().append("<H1>No hay recomendaciones. </H1>")
					.append("<p>Usted no seleccionó ningún Libro.</p>");
		}
		response.getWriter().append("</body></html>");
		response.getWriter().close();

	}
}
