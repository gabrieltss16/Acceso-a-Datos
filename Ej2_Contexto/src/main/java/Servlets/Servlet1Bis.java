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
@WebServlet("/Servlet1Bis")
public class Servlet1Bis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1Bis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    

    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String colorNuevo = (String) getServletContext().getAttribute("colorNuevo");
			// recojo el valor del atributo colorNuevo y lo guardo en una String
			
			response.setContentType("text/html");
			response.getWriter().append("<html>")
								.append("<head>")
								.append("<style>")
								.append("body{background-color:" + colorNuevo + "}")
								.append("</style>")
								.append("</head>")
								.append("<body>")
								.append("<h1>Servlet1Bis</h1>")
								.append("</body>")
								.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
