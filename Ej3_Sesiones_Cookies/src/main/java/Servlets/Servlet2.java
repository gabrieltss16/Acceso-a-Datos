package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();

		
		if (sesion.getAttribute("nombres") == null) {
		    sesion.setAttribute("nombres", new ArrayList<String>());
		}
		
		ArrayList<String> nombres = (ArrayList<String>) sesion.getAttribute("nombres");
		
        String nombre = (String) request.getParameter("usuario");
		
        if (nombre != null) {
        nombres.add(nombre);
		
		sesion.setAttribute("nombres", nombres);
		
		response.setContentType("text/html");
		response.getWriter().append("<html><head>Visitadores</head><p>")
							.append("<body>")
							.append("<p>Hola " + nombre + "</p>")
							.append("<p>Bienvenido a mi primera pagina web</p>")
							.append("<p>Contigo, hoy me han visitado: </p>");
		for (String n : nombres) {
			response.getWriter().append("<p>" + n + "</p>");
		}
					        
		response.getWriter().append("</body></html>");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
