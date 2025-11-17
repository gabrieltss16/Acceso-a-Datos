package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet("/Ejercicio3Sync")
public class Servlet3Sync extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        synchronized (session) {
            session.setAttribute("user", request.getParameter("user"));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String user = (String) session.getAttribute("user");
        String id = session.getId();
        String created = FORMATTER.format(Instant.ofEpochMilli(session.getCreationTime()));
        String lastAccess = FORMATTER.format(Instant.ofEpochMilli(session.getLastAccessedTime()));

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<html><head><meta charset='utf-8'><title>Ejercicio 3 - Sync</title></head><body>");
        response.getWriter().println("Usuario: " + user + "   Id: " + id + "<br>");
        response.getWriter().println("Fecha creación sesión: " + created + "<br>");
        response.getWriter().println("Fecha último acceso: " + lastAccess + "<br>");
        response.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}