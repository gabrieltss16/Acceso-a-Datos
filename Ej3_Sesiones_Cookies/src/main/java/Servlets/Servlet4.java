package Servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet4
 */
@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet4() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession();
		
		if (sesion.getAttribute("cont") == null) {
			sesion.setAttribute("cont", 1);
		}
		
		int cont = (int) sesion.getAttribute("cont");

		String boton = request.getParameter("boton");
		
		if (boton == null) {
		
		response.setContentType("text/html");
		response.getWriter().append("<html><body><h1>Servlet4</h1>")
							.append("<form method='get'>")
							.append("<button name='boton' value='acceso'>Acceso</button><br><br>")
							.append("<button name='boton' value='nuevaSesion'>Nueva Sesion</button>")
							.append("</form>")
							.append("</body></html>");
		} else if (boton.equals("acceso")) {
			
			response.setContentType("text/html");
			response.getWriter().append("<html><body><h1>Servlet4</h1>")
								.append("<p>Desde la última vez ha accedido " + cont + " veces</p><br><br>")
								.append("<form method='get'>")
								.append("<button name='boton' value='acceso'>Acceso</button><br><br>")
								.append("<button name='boton' value='nuevaSesion'>Nueva Sesion</button>")
								.append("</form>")
								.append("</body></html>");
			sesion.setAttribute("cont", cont +1 );
		} else if (boton.equals("nuevaSesion")) {
			sesion.invalidate();
			HttpSession nuevaSesion = request.getSession();
			nuevaSesion.setAttribute("cont", 1);
			
			response.setContentType("text/html");
			response.getWriter().append("<html><body><h1>Servlet4</h1>")
								.append("<p>Es la primera vez que accede a la web</p><br><br>")
								.append("<form method='get'>")
								.append("<button name='boton' value='acceso'>Acceso</button><br><br>")
								.append("<button name='boton' value='nuevaSesion'>Nueva Sesion</button>")
								.append("</form>")
								.append("</body></html>");

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
