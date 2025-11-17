package Servlets;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1_0")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    String param;
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		param = config.getServletContext().getInitParameter("color"); 
		// recojo y guardo el valor del parametro que esta en el contexto
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
			String color = request.getParameter("color"); 
			// recojo el parametro metido en la url
			
			getServletContext().setAttribute("colorNuevo", color);
			// lo guardo en un atributo del contexto llamado "colorNuevo"
			
			response.setContentType("text/html");
								response.getWriter().append("<html>")
								.append("<head>")
								.append("<style>")
								.append("body{background-color:" + param + "}") 
								// para el fondo uso el valor del parametro que esta en el contexto
								.append("h1{color:" + color + "}")
								// para el color de la letra uso el color pasado por url
								.append("</style>")
								.append("</head>")
								.append("<body>")
								.append("<h1>Servlet1</h1>")
								.append("<form action= \"Servlet1Bis\" method=\"get\"> ")
								// con el boton voy al Servlet1Bis
								.append("<p> <input type=\"submit\" value=\"Enviar a Bis\"> </p>")
								.append("</body>")
								.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
