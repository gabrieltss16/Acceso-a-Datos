package Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio33
 */
@WebServlet("/Ejercicio33")
public class Ejercicio33 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, String> lib = new HashMap<String, String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio33() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		lib.put("Java", "67.00");
		lib.put("C", "56.00");
		lib.put("C++", "63.00");
		lib.put("VB", "52.00");
		lib.put("Phyton", "46.00");
		config.getServletContext().setAttribute("libros", lib);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.getWriter().append("<html><body>")
				.append("<h1 align ='center'>Bienvenido a Web Librer&iacute;a. Seleccione el libro</h1><br>")
				.append("<form action='Ejercicio33' method='post'>").append(" <h3 align ='center'>Listado de libros: ")
				.append(" <select name='list'>");
		lib.forEach((k, v) -> {
			try {
				response.getWriter().append("<option>" + k
						+ "</option>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		/*
		 * for (Map.Entry entry : lib.entrySet()) {
		 * response.getWriter().append("<option>" + entry.getKey() + "</option>"); }
		 */

		response.getWriter().append("</select>").append("Unidades: <input type='text' name='ud' value='0' />")
				.append("<input type='submit' value='enviar' /></h3>").append("</form>").append("</body>")
				.append("</html>");
		response.getWriter().close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!request.getParameter("ud").equals("0")) {
			
			// Creamos la Cookie, esta recibe dos parametros: Nombre y valor
			Cookie cookie = new Cookie(request.getParameter("list"), request.getParameter("ud"));
			// Añadir el cookie a la respuesta
			response.addCookie(cookie);
			response.getWriter().append("<html><body>").append(
					"<h1 >Bienvenidos a Web Libreria.Usted seleccionó " + request.getParameter("list") + "</h1>");
		} else {
			response.getWriter().append("<h1 >No ha seleccionado unidades a comprar. </h1>");
		}
		response.getWriter().append("<p><a href='Ejercicio33'>Sigue comprando</a></p>")
				.append("<p><a href='Ejercicio33b'>Ver compra</a>").append("</body>").append("</html>");
		response.getWriter().close();
	}

}
