package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import clasesJava.Persona;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // importante!
    }
    // inicializo un arrayList de personas
	ArrayList<Persona> personas = new ArrayList<>();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			// recojo los parametros y los guardo
		    String nombre = request.getParameter("nombre" );
		    String edadStr = request.getParameter("edad" );
		    String telefono = request.getParameter("telefono" );
		    
		    // parseo la edad para guaradrlo como int, y añado una persona al array con esos parametros
		    // siempre que haya parametros claro
		    if (nombre != null && edadStr != null && telefono != null) {
		    int edad = Integer.parseInt(edadStr);
		    personas.add(new Persona(nombre, edad, telefono));
		    
			//guardo ese array de personas como atributo del contexto llamado "listaPersonas"
			getServletContext().setAttribute("listaPersonas", personas);
		    }

				response.setContentType("text/html");
				response.getWriter().append("<html>")
									.append("<head>")
									.append("</head>")
									.append("<body>")
									.append("<h1>Servlet2</h1>");
		    if (personas.isEmpty()) {
		        // si no hay personas mensaje de informacion
		        response.getWriter().append("<p>No hay personas registradas aún.</p>");
		    }
		    else {
		    	response.getWriter().append("<table border='1'>")
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
		    }
					response.getWriter().append("</table>")
										.append("<form action= \"Servlet2Bis\" method=\"get\"> ")
										.append("<p><input type=\"submit\" value=\"Ver listado en Servlet2Bis\"></p>")
										.append("</form>")
										.append("</body>")
										.append("</html>");
				


	}
	
	/*EJEMPLO DE URL CON 3 PERSONAS
	 * http://localhost:8080/Ej2_Contexto/Servlet2?nombre=gabriel&edad=1956&telefono=446544658
	 * http://localhost:8080/Ej2_Contexto/Servlet2?nombre=paula&edad=543&telefono=5345345
	 * http://localhost:8080/Ej2_Contexto/Servlet2?nombre=nico&edad=657&telefono=2152325
	 * */


}
