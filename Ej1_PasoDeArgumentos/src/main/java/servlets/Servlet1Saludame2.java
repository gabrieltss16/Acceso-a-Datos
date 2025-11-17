package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletSaludame2
 */
@WebServlet("/ServletSaludame2")
public class Servlet1Saludame2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1Saludame2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String idioma = request.getParameter("idioma");
        String saludo;

        if (idioma == null) {
            saludo = "No seleccionaste idioma";
        } else {
            switch (idioma) {
                case "es":
                    saludo = "Hola Mundo";
                    break;
                case "en":
                    saludo = "Hello World";
                    break;
                case "it":
                    saludo = "Ciao a tutti";
                    break;
                case "fr":
                    saludo = "Bonjour Tout";
                    break;
                default:
                    saludo = "El idioma no está en nuestra base de datos";
            }
        }

        out.println("<h1>" + saludo + "</h1>");
	}

}
