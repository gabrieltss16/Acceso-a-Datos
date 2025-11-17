package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet3Despachador
 */
@WebServlet("/Servlet3Despachador")
public class Servlet3Despachador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3Despachador() {
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
		response.getWriter().append("<html><body>");
		
		RequestDispatcher rd;
		
		if (request.getParameter("texto") == null || request.getParameter("texto") == "") {
			rd = request.getRequestDispatcher("Servlet3Error");
			request.setAttribute("mensajeError", "No has introducido ningun texto");
			rd.forward(request, response);
		}
		else {
			String texto = request.getParameter("texto");
			rd = request.getRequestDispatcher("cabecera.html");
			rd.include(request, response);
			
			response.getWriter().append("<h2 align='center'>Has escrito: " + texto + "</h2><br>")
								.append("<h4 align='center'>Has delegado el procesamiento de la peticion al servlet" + request.getServletPath() + "</h4>");
			
			rd = request.getRequestDispatcher("pie.html");
			rd.include(request, response);
		}
		response.getWriter().append("</html></body>");

	}

}
