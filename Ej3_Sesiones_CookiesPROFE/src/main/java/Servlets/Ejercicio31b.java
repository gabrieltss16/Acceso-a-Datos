package Servlets;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Ejercicio31b
 */
@WebServlet("/Ejercicio31b")
public class Ejercicio31b extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio31b() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesion = request.getSession(true);
		int sum = sesion.getAttribute("suma") != null
				? Integer.parseInt(sesion.getAttribute("suma").toString())
				: 0;
		Map<String,String[]> param = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : param.entrySet()) {
			String key = entry.getKey();
			//String[] val = entry.getValue();
			response.getWriter().append(key.equalsIgnoreCase("ticket") ? "TOTAL ACUMULADO:" + sum + "<HR>" : key);
			sum += key.equalsIgnoreCase("ticket") ? 0 : Integer.parseInt(key);	
		}
		sesion.setAttribute("suma", sum);
		response.setContentType("text/html");
		response.getWriter().append("<html><body>");
		response.getWriter().append("<form action='" + response.encodeURL("Ejercicio31b") + "' method='get'>")
				.append("<input type='submit' name='3' value='A'>")
				.append("<input type='submit' name='4' value='B'>")
				.append("<input type='submit' name='5' value='C'>")
				.append("<input type='submit' name='1' value='D'></br>")
				.append("<input type='submit' name='ticket' value='Ticket'>")
		        .append("</form></body></html>");
		response.getWriter().close();

	}

}
