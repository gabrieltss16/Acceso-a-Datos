package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet4() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println("<html><head><title>Datos Recibidos</title></head><body>");
        response.getWriter().println("<h2>Datos recibidos</h2>");
        response.getWriter().println("<table>");

        response.getWriter().println("<tr><th>Parámetro</th><th>Valor</th></tr>");

        Enumeration<String> nombres = request.getParameterNames();
        while (nombres.hasMoreElements()) {
            String nombre = nombres.nextElement();
            String valor = request.getParameter(nombre); 
            response.getWriter().println("<tr><td>" + nombre + "</td><td>" + valor + "</td></tr>");
        }

        response.getWriter().println("</table>");
        response.getWriter().println("</body></html>");
    }

    // También podemos permitir GET para pruebas con URL
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}
