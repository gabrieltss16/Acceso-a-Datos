package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import clasesJava.Persona;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio2_2
 */
@WebServlet("/Ejercicio2_2")
public class Ejercicio2_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio2_2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
		String apellidos = request.getParameter("apellidos") != null ? request.getParameter("apellidos") : "";
		Integer edad = request.getParameter("edad") != null ? (Integer.parseInt(request.getParameter("edad"))) : 0;
		String contacto = request.getParameter("contacto") != null ? request.getParameter("contacto") : "";
		Persona persona = new Persona(nombre, edad, contacto);
		// Compruebo siempre que existe el objeto personas en el contexto
		ArrayList<Persona> listPers = getServletContext().getAttribute("list_pers") != null
				? (ArrayList<Persona>) getServletContext().getAttribute("list_pers")
				: new ArrayList<Persona>();
		// Añado objetos persona al listado personas
		listPers.add(persona);
		// Actualizo el valor del listado de personas en el contexto
		getServletContext().setAttribute("list_pers", listPers);
		response.getWriter().append("<html><body>").append("<form action ='Ejercicio2_2b' method='post'>")
				.append("<input type='submit' value='Listado Personas'>").append("</form></body></html>");
		response.getWriter().close();
	}

}
