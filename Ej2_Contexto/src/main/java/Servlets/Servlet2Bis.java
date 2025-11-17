package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import clasesJava.Persona;

/**
 * Servlet implementation class Servlet2Bis
 */
@WebServlet("/Servlet2Bis")
public class Servlet2Bis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2Bis() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				ArrayList<Persona> personas = (ArrayList<Persona>) getServletContext().getAttribute("listaPersonas");
				// llamo al atributo listaPersonas y guardo su valor en un ArrayList de personaa
				
				response.setContentType("text/html");
				response.getWriter().append("<html>")
									.append("<head>")
									.append("</head>")
									.append("<body>")
									.append("<h1>Listado de personas desd el Context</h1>")
									.append("<table border='1'>")
									.append("<tr>")
									.append("<th>Nombre</th>")
									.append("<th>Edad</th>")
									.append("<th>Telefono</th>")
									.append("</tr>");
				
				for (Persona persona : personas) {
					response.getWriter().append("<tr>")
					               		.append("<td>" + persona.getNombre() + "</td>")
					               		.append("<td>" + persona.getEdad() + "</td>")
					               		.append("<td>" + persona.getTelefono() + "</td>")
					               		.append("</tr>");			
				}
					response.getWriter().append("</table>")
										.append("</body>")
										.append("</html>");

	}


}
