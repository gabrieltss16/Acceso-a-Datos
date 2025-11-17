package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

	
@WebServlet("/ServletSaludameFirma")
public class Servlet1SaludameFirma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1SaludameFirma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String saludo = request.getParameter("saludo");
        String firma = request.getParameter("firma");

        if (saludo == null || firma == null) {
            out.println("<h1>Faltan parámetros en la URL</h1>");
        } else {
            out.println("<h1>" + saludo + " - " + firma + "</h1>");
        }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String saludo = request.getParameter("saludo");
        String firma = request.getParameter("firma");

        out.println("<h1>" + saludo + " - " + firma + "</h1>");	}

}
