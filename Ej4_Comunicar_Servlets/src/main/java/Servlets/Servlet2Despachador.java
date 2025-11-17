package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet2Despachador
 */
@WebServlet("/Servlet2Despachador")
public class Servlet2Despachador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2Despachador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String numeroStr = request.getParameter("numero");
        String color = request.getParameter("color");
        
        RequestDispatcher rd;

        if (numeroStr == null || numeroStr.equals("") || numeroStr.equals("Elige una tabla")) {
            request.setAttribute("mensaje", 
                "No has elegido ninguna tabla. Elige una tabla por favor.");
            rd = request.getRequestDispatcher("Servlet2Error");
        } else {
            int numero = Integer.parseInt(numeroStr);
            request.setAttribute("numero", numero);
            if (color != null) {
                request.setAttribute("color", color);
            }
            rd = request.getRequestDispatcher("Servlet2Tablas");
        }
        
        rd.forward(request, response);
        
	}

}
