package Servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		
		if (sesion.getAttribute("ticket") == null) {
		    sesion.setAttribute("ticket", 0);
		}

		
        int suma = (int) sesion.getAttribute("ticket");
		
		String boton = request.getParameter("boton");
		
		if (boton != null) {
			switch (boton) {
			case "A": suma += 3; break;
			case "B": suma += 4; break;
			case "C": suma += 5; break;
			case "D": suma += 1; break;
			case "ticket": break;
			}

		}	
		
		sesion.setAttribute("ticket", suma);
		
		response.setContentType("text/html");
		response.getWriter().append("<html><head>TIENDA LETRAS</head><p>")
							.append("<body>")
					        .append("<form action='Servlet1' method='get'>")
							.append("<button name=\"boton\" value=\"A\">A</button>")
							.append("<button name=\"boton\" value=\"B\">B</button>")
							.append("<button name=\"boton\" value=\"C\">C</button>")
							.append("<button name=\"boton\" value=\"D\">D</button>")
							.append("<p>")
							.append("<button name=\"boton\" value=\"ticket\">Ticket</button>")
					        .append("</form>");
		
		if (boton != null && boton.equals("ticket")) {
			response.getWriter().append("<p>Total: " + suma + "</p>");
		}
					        
		response.getWriter().append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
