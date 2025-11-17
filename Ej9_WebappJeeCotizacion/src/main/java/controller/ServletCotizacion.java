package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;

import entities.Cotizacion;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletCotizacion
 */
@WebServlet("/ServletCotizacion")
public class ServletCotizacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object lock= new Object();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCotizacion() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "";
		String msj="";
		ServletContext sc = getServletConfig().getServletContext();
		HashMap<String, Cotizacion> cotizaciones = sc.getAttribute("listCotiza") != null
					? (HashMap<String, Cotizacion>) sc.getAttribute("listCotiza")
					: new HashMap<String, Cotizacion>();
		HttpSession sesion=request.getSession(true);
		
		switch (request.getParameter("boton")) {
		case "Acceso":
			if (request.getParameter("nombre").isBlank() || request.getParameter("password").isBlank()) {
				msj= "(*)El nombre y el código pin son obligatorios.";
				page = "/Acceso.jsp";
			} else if (!request.getParameter("password").equalsIgnoreCase("123456")) {
				msj= "(*) Las credenciales no son correctas.";
				page = "/Acceso.jsp";
			} else {
				synchronized (lock) {
					sesion.setAttribute("user",request.getParameter("nombre"));
				}
				page = "/Cotizacion.jsp";
			}
			break;
		case "Cerrar":
			sesion.invalidate();
			msj="(*)La sesión ha expirado.";
			page = "/Acceso.jsp";
			break;
		case "Enviar":
			Enumeration<String> params = request.getParameterNames();
			while(params.hasMoreElements()) {
				String type = (String) params.nextElement();
				String valor = (request.getParameter(type)!=null && !request.getParameter(type).isBlank())?request.getParameter(type)
						.replace(",", "."):"0.0";
				Cotizacion c;
				if (!type.equals("boton")) {
					c = new Cotizacion(type,cotizaciones.get(type).getAnterior(),Double.valueOf(valor));
					c.setEvalua();
					cotizaciones.put(type, c);
				}
			}
			synchronized (lock) {
			sc.setAttribute("listCotiza", cotizaciones);
			}
			page = "ConsultaCotizacion.jsp";
			break;
		case "Volver":
			page="Acceso.jsp";
		default:
			break;
		}
		request.setAttribute("mensaje", msj);
		request.getRequestDispatcher(page).forward(request, response);

	}

}
