package servlets;


import com.ejemplo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Creamos un array de hasta 3 personas (puedes ampliar)
        Persona[] personas = new Persona[3];

        for (int i = 0; i < personas.length; i++) {
            String nombre = request.getParameter("nombre" + (i + 1));
            String apellidos = request.getParameter("apellidos" + (i + 1));
            String edadStr = request.getParameter("edad" + (i + 1));
            String contacto = request.getParameter("contacto" + (i + 1));

            if (nombre != null && apellidos != null && edadStr != null && contacto != null) {
                int edad = Integer.parseInt(edadStr);
                personas[i] = new Persona(nombre, apellidos, edad, contacto);
            }
        }

        // HTML de salida
        out.println("<html>");
        out.println("<head><title>Listado de Personas</title></head>");
        out.println("<body style='font-family: Arial;'>");
        out.println("<h1>Listado de Personas</h1>");
        out.println("<table border='1' cellpadding='8' cellspacing='0'>");
        out.println("<tr style='background-color: #f2f2f2;'>");
        out.println("<th>Nombre</th><th>Apellidos</th><th>Edad</th><th>Contacto</th>");
        out.println("</tr>");

        // Mostrar cada persona
        for (Persona p : personas) {
            if (p != null) {
                out.println("<tr>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getApellidos() + "</td>");
                out.println("<td>" + p.getEdad() + "</td>");
                out.println("<td>" + p.getContacto() + "</td>");
                out.println("</tr>");
            }
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
