package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet6")
public class Servlet6 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet6() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");

        String accion = request.getParameter("accion"); 
        String galleta = request.getParameter("galleta"); 

        List<String> galletas = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("galletas".equals(c.getName()) && c.getValue() != null && !c.getValue().isEmpty()) {
                    String valor = c.getValue();
                    String[] partes = valor.split("\\|"); 
                    galletas.addAll(Arrays.asList(partes));
                    break;
                }
            }
        }

        if ("cocinar".equals(accion)) {
            if (galleta != null && !galleta.isEmpty()) {
                if (!galletas.contains(galleta)) {
                    galletas.add(galleta);
                    response.getWriter().append("¡Cocinaste una galleta: ").append(galleta).append("!\n");
                } else {
                    response.getWriter().append("La galleta ya está cocinada: ").append(galleta).append("\n");
                }
            } else {
                response.getWriter().append("Debes indicar qué galleta cocinar.\n");
            }
        } else if ("comer".equals(accion)) {
            if (galleta != null && !galleta.isEmpty()) {
                if (galletas.remove(galleta)) {
                    response.getWriter().append("¡Te comiste la galleta: ").append(galleta).append("!\n");
                } else {
                    response.getWriter().append("No tienes esa galleta: ").append(galleta).append("\n");
                }
            } else {
                response.getWriter().append("Debes indicar qué galleta comer.\n");
            }
        } else {
            if (galletas.isEmpty()) {
                response.getWriter().append("No hay galletas en la cocina.\n");
            } else {
                response.getWriter().append("Galletas en la cocina:\n");
                for (String g : galletas) {
                    response.getWriter().append("- ").append(g).append("\n");
                }
            }
        }

        String valorCookie = String.join("|", galletas); 
        Cookie c = new Cookie("galletas", valorCookie);
        c.setMaxAge(60 * 60 * 24 * 365); 
        response.addCookie(c);

        response.getWriter().close();
    }
}
