package Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet7")
public class Servlet7 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet7() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        boolean testHecho = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("testCovid".equals(c.getName())) {
                	testHecho = true;
                    break;
                }
            }
        }

        if (testHecho) {
            response.getWriter().append("<h2>Usted ya ha realizado el test. No puede repetirlo.</h2>");
            return;
        }

        ServletContext context = getServletContext();
        @SuppressWarnings("unchecked")
        Map<String, Integer> estadisticas = (Map<String, Integer>) context.getAttribute("estadisticas");
        if (estadisticas == null) {
            estadisticas = new HashMap<>();
            estadisticas.put("Fiebre", 0);
            estadisticas.put("Tos Seca", 0);
            estadisticas.put("Diarrea", 0);
            estadisticas.put("Perdida de Olfato", 0);
            estadisticas.put("Dolor Muscular", 0);
        }

        if (request.getParameter("fiebre") != null) {
            estadisticas.put("Fiebre", estadisticas.get("Fiebre") + 1);
        }
        if (request.getParameter("tos") != null) {
            estadisticas.put("Tos Seca", estadisticas.get("Tos Seca") + 1);
        }
        if (request.getParameter("diarrea") != null) {
            estadisticas.put("Diarrea", estadisticas.get("Diarrea") + 1);
        }
        if (request.getParameter("olfato") != null) {
            estadisticas.put("Perdida de Olfato", estadisticas.get("Perdida de Olfato") + 1);
        }
        if (request.getParameter("dolor") != null) {
            estadisticas.put("Dolor Muscular", estadisticas.get("Dolor Muscular") + 1);
        }

        context.setAttribute("estadisticas", estadisticas);

        Cookie cookieTest = new Cookie("testCovid", "true");
        cookieTest.setMaxAge(60 * 60 * 24 * 365); 
        response.addCookie(cookieTest);

        response.getWriter().append("<h1>Resultados del Test COVID-19</h1>");
        response.getWriter().append("<table border='1'>");
        response.getWriter().append("<tr><th>Síntomas</th><th>Número Personas</th></tr>");
        for (Map.Entry<String, Integer> entrada : estadisticas.entrySet()) {
            response.getWriter().append("<tr>")
                    .append("<td>").append(entrada.getKey()).append("</td>")
                    .append("<td>").append(String.valueOf(entrada.getValue())).append("</td>")
                    .append("</tr>");
        }
        response.getWriter().append("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
