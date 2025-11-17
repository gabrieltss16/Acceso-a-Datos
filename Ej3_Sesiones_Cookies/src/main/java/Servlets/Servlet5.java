package Servlets;

import java.io.IOException;
import java.util.Random;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet5
 */
@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet5() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int random = (int) (Math.random()*10)+1;
		
		Object objContexto = getServletContext().getAttribute("num");
		int randomContexto;
		
		if (objContexto == null) {
			randomContexto = random;
			getServletContext().setAttribute("num", randomContexto);
		} else randomContexto = (int) objContexto;

		String resultado= "";
		
		if (random == randomContexto) resultado = "Numeros iguales";
		if (random != randomContexto) resultado = "Numeros distintos";

		getServletContext().setAttribute("num", random);
		
		response.setContentType("text/html");
		response.getWriter().append("<html><body><h1>Servlet5</h1>")
							.append("<p>Aleatorio: "+ random +"</p><br>")
							.append("<p>Contexto: "+ randomContexto +"</p><br>")
							.append("<p>" + resultado + "</p><br>")
							.append("</body></html>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
