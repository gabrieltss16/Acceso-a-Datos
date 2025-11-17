package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio2_1
 */
@WebServlet("/Ejercicio2_1")
public class Ejercicio2_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio2_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);  //SIEMPRE HACER LA LLAMADA DE INIT AL SUPER
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String color= request.getParameter("colorParam")!=null?request.getParameter("colorParam"):(String)getServletContext().getInitParameter("colorContext");
		getServletContext().setAttribute("colorAttrib",color);
		response.getWriter().append("<html><body style='background-color:"+color+"'>")
							.append("<form action='Ejercicio2_1b' method='get'>")
							.append("<input type='submit' name='Enviar' value='Enviar'/>")
							.append("</form></body></html>");
	}
}
