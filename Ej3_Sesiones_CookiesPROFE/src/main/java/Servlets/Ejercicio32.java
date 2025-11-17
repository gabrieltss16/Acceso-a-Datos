
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
 * Servlet implementation class Ejercicio32
 */
@WebServlet("/Ejercicio32")
public class Ejercicio32 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio32() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		HttpSession sesion = request.getSession(true);
		ArrayList<String> listUser =  sesion.getAttribute("list_user") != null?(ArrayList<String>)sesion.getAttribute("list_user"):new ArrayList<String>();
		String user = (String) request.getParameter("usuario");
		if (user != null && !user.isBlank()) {
			response.getWriter().append("Hola " + user + "\n");
			listUser.add(user);
			sesion.setAttribute("list_user"
					+ ""
					+ "", listUser);
		}
		response.getWriter().append("Bienvenido a mi primera página Web! \n");
		response.getWriter().append("Contigo, hoy me han visitado: \n");
		listUser.forEach(u -> {
			try {
				response.getWriter().append(u +"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

}
