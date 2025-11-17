package Servlets;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio35
 */
@WebServlet("/Ejercicio35")
public class Ejercicio35 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio35() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		response.setContentType("text/plain");
		int numContext = ((getServletContext().getAttribute("num_context") != null)
				? (int) getServletContext().getAttribute("num_context")
				: new Random().nextInt(1, 11));
		int num = new Random().nextInt(1, 11);
		response.getWriter().append("Aleatorio: " + num + ".Contexto: " + numContext + ".\n")
				.append(((num == numContext) ? "Números iguales." : "Números distintos."));
		getServletContext().setAttribute("num_context", new Random().nextInt(1, 11));

	}
	



}
