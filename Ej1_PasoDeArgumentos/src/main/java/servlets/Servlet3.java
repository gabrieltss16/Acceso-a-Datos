package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//response.getWriter().append("Served at: ").append(request.getContextPath());
}


/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//doGet(request, response);
response.setContentType("text/html");
response.getWriter().append("<html>")
        .append("<body>")
               .append("<h2>Mostrar Datos</h2>")
               .append("<table border='1' cellpadding='5' cellspacing='0'>")
               .append("<tr>")
               .append("<th>Nombre</th>")
               .append("<th>Apellidos</th>")
               .append("<th>Dirección</th>")
               .append("<th>Tipo de tarjeta</th>")
               .append("<th>Número tarjeta</th>")
               .append("</tr>")
               .append("<tr>")
               .append("<td>").append(request.getParameter("nombre")).append("</td>")
               .append("<td>").append(request.getParameter("apellidos")).append("</td>")
               .append("<td>").append(request.getParameter("direccion")).append("</td>")
               .append("<td>").append(request.getParameter("tarjeta")).append("</td>")
               .append("<td>").append(request.getParameter("numtarjeta")).append("</td>")
               .append("</tr>")
               .append("</table>")
               .append("</body></html>");

       

}

}
