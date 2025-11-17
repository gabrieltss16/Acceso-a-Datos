package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Ejercicio34
 */
@WebServlet("/Ejercicio34")
public class Ejercicio34 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio34() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><form action='Ejercicio34' method='post' >");
		out.print("<input type='submit' value='Acceso' name='boton' />");
		out.print("<input type='submit' value='Nueva Sesión' name='boton' />");
		out.println("</form></body></html>");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		HttpSession sesion = request.getSession(true);
		Integer cont=1;
		if (request.getParameter("boton").equalsIgnoreCase("Nueva Sesión")) {
			sesion.invalidate();
			sesion = request.getSession(true);
			response.getWriter().append("Es la primera vez que se accede a la web.");
		} else {
			cont =sesion.getAttribute("contador")!=null?(Integer)sesion.getAttribute("contador"):1;
			response.getWriter().append(cont!=1?"Desde la ultima sesiòn ha accedido " + cont + " veces.":"Es la primera vez que se accede a la web.");
		  
		}
		sesion.setAttribute("contador", cont+1);

	}

}
