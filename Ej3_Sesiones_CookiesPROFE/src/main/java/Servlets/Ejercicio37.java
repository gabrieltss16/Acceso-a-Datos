



package Servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio37
 */
@WebServlet("/Ejercicio37")
public class Ejercicio37 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio37() {
        super();
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HashMap<String, Integer> result = (HashMap<String, Integer>) getServletConfig().getServletContext().getAttribute("resultado");
		response.setContentType("text/html");
		response.getWriter().append("<html><body>").append("<table border='1'>")
				.append("<tr><td>Sintomas</td><td>Número Personas</td></tr>");
		if (result!=null) {
			for (Entry<String, Integer> entry : result.entrySet()) {
				response.getWriter().append("<tr>").append("<td>" + entry.getKey() + "</td>")
						.append("<td>" + entry.getValue().toString() + "</td>").append("</tr>");

			}
		}
		response.getWriter().append("<table><br>")
				.append("<h3>"+(request.getAttribute("msj")!=null&&!request.getAttribute("msj").toString().isEmpty() ? "Usted no puede realizar la encuesta de nuevo" : ""+"</h3>"))
				.append("</body></html>");
		response.getWriter().close();

	}

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, Integer> result = getServletConfig().getServletContext().getAttribute("resultado") != null
				? (HashMap<String, Integer>) getServletContext().getAttribute("resultado")
				: new HashMap<String, Integer>();
		Cookie[] cs = request.getCookies();
		boolean flag = false;
		if (cs != null) {
			for (int i = 0; i < cs.length && !flag; i++) {
				if (cs[i].getName().equals("encuesta")) {
					flag = true;
				}
			}
		}
		if (!flag) {
			Enumeration<String> parameters = request.getParameterNames();
			while (parameters.hasMoreElements()) {
				String param = parameters.nextElement();
				if (param != null && !param.equalsIgnoreCase("enviar")) {
					if (result.get(param) != null)
						result.put(param, result.get(param) + 1);
					else
						result.put(param, 1);
				}
			}

			getServletContext().setAttribute("resultado", result);
			Cookie c = new Cookie("encuesta", "si");
			response.addCookie(c);
			request.setAttribute("msj", "");
		
		
		} else {
			request.setAttribute("msj", "Usted no puede repetir la encuesta.");
		}
		doGet(request, response);


	}

}
