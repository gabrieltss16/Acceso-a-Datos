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
 * Servlet implementation class Ejercicio2_2b
 */
@WebServlet("/Ejercicio2_2b")
public class Ejercicio2_2b extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio2_2b() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Si existe el listado en el contexto recuperarlo
				ArrayList<Persona> listPers =  getServletContext().getAttribute("list_pers") != null?(ArrayList<Persona>)getServletContext().getAttribute("list_pers"):new ArrayList<Persona>();
				response.setContentType("text/html");
				response.getWriter().append("<html><body><table border='1'>")
				                    .append("<tr><td>Nombre</td><td>Apellidos</td><td>Edad</td><td>Contacto</td></tr>");
//					for (Persona p : listPers) {
//						response.getWriter().append("<tr><td>" + p.getNombre() + "</td>")
//											.append("<td>" + p.getApellidos() + "</td>")
//											.append("<td>" + p.getEdad() + "</td>")
//											.append("<td>" + p.getContacto() + "</td></tr>");
//					}
				listPers.forEach(n -> {
					try {
						response.getWriter().append("<tr><td>" + n.getNombre() + "</td>")
											.append("<td>" + n.getEdad() + "</td>")
											.append("<td>" + n.getTelefono() + "</td></tr>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				response.getWriter().append("</table></body></html>");

	}

}
