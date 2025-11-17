package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet5() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Datos Recibidos</title></head><body>");
        out.println("<h2>Datos del formulario</h2>");

        // Tabla para mostrar los datos
        out.println("<table border='1' cellpadding='5' cellspacing='0'>");
        out.println("<tr><th>Campo</th><th>Valor</th></tr>");

        // Asignaturas (select multiple)
        String[] asignaturas = request.getParameterValues("asignaturas");
        out.println("<tr><td>Asignaturas</td><td>");
        if (asignaturas != null) {
            for (String a : asignaturas) {
                out.print(a + " ");
            }
        } else {
            out.print("No seleccionadas");
        }
        out.println("</td></tr>");

        // Sexo (radio)
        String sexo = request.getParameter("sexo");
        out.println("<tr><td>Sexo</td><td>" + (sexo != null ? sexo : "No seleccionado") + "</td></tr>");

        // Actividades extraescolares (checkboxes)
        String[] actividades = request.getParameterValues("actividades");
        out.println("<tr><td>Actividades extraescolares</td><td>");
        if (actividades != null) {
            for (String act : actividades) {
                out.print(act + " ");
            }
        } else {
            out.print("No seleccionadas");
        }
        out.println("</td></tr>");

        out.println("</table>");
        out.println("</body></html>");
    }

    // Para pruebas rápidas, también se puede aceptar GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
