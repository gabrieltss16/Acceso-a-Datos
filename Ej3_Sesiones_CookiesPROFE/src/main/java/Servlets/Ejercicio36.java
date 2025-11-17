package Servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio36
 */
@WebServlet("/Ejercicio36")
public class Ejercicio36 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio36() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html><body>");
		Cookie[] cs = request.getCookies();
	//	if (cs != null) {
			switch ((request.getParameter("groupCookie") != null) ? request.getParameter("groupCookie") : "") {
			case "muestra":
				if (cs != null) {
					response.getWriter().append("<ul>");
					for (Cookie cookie : cs) {
						// if (!cookie.getName().equalsIgnoreCase("JSESSIONID"))
						response.getWriter().append("<li>" + cookie.getName() + "</li>");
					}
					response.getWriter().append("</ul>");
				} else {
					response.getWriter().append("No hay galletas en la página web");
				}
				break;
			case "cocina":
				if (request.getParameter("galleta") != null && !request.getParameter("galleta").isBlank()) {
					response.addCookie(new Cookie(request.getParameter("galleta"), request.getParameter("galleta")));
					response.getWriter().append("Se cocina  la galleta " + request.getParameter("galleta"));
				} else {
					response.getWriter().append("No has indicado la galleta a cocinar.");
				}
				break;
			case "come":
				if (request.getParameter("galleta") != null && !request.getParameter("galleta").isEmpty()) {
					boolean flag = false;
					if(cs!=null) {
					for (int i = 0; i < cs.length && !flag; i++) {
						if (cs[i].getName().equals(request.getParameter("galleta"))) {
							cs[i].setMaxAge(0);
							response.addCookie(cs[i]);
							flag = true;
							response.getWriter().append("Se ha comido la galleta " + request.getParameter("galleta"));
						}
					}
					}
					if (!flag) {
						response.getWriter()
								.append("La galleta " + request.getParameter("galleta") + " no está  disponible.");
					}

				}
				else {
					response.getWriter().append("No has indicado la galleta a comer.");

				}
				break;
			default:
				response.getWriter().append("No has elegido opción o no has indicado galleta.");
				break;
			}
		//} else {// cs==0
		//	response.getWriter().append("No hay galletas disponibles en este sitio web.");
	//	}

		response.getWriter().append("<br><a href='ejercicio36.html'>Volver</a>");
		response.getWriter().close();
	}

}
