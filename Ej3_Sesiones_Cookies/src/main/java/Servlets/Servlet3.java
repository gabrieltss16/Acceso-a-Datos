package Servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet3() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String libro = request.getParameter("libro");
        String unidadesStr = request.getParameter("unidades");
        String accion = request.getParameter("accion");

        response.setContentType("text/html");

        if (accion.equals("añadir")) {
            int unidades = Integer.parseInt(unidadesStr);
            int cantidadActual = 0;

            Cookie[] cs = request.getCookies();
            if (cs != null) {
                for (int i = 0; i < cs.length; i++) {
                    if (cs[i].getName().equals(libro)) {
                        cantidadActual = Integer.parseInt(cs[i].getValue());
                    }
                }
            }

            cantidadActual += unidades;

            Cookie c = new Cookie(libro, String.valueOf(cantidadActual));
            c.setMaxAge(60 * 60); 
            response.addCookie(c);

            response.getWriter().append("<h2>Libro añadido: " + libro + " (" + unidades + " unidades)</h2>");
            response.getWriter().append("<a href='Ejercicio3.html'>Seguir comprando</a>");
            response.getWriter().append("<br><br><a href='Servlet3?accion=ver'>Ver compra</a>");

        } else if (accion.equals("ver")) {

            response.getWriter().append("<h1 style='text-align:center;'>Compra total</h1>");
            response.getWriter().append("<table border='1' style='width:50%; margin:auto; text-align:center;'>");
            response.getWriter().append("<tr><th>Título del Libro</th><th>Unidades</th><th>Precio</th></tr>");

            double total = 0;

            Cookie[] cs = request.getCookies();
            if (cs != null) {
                for (int i = 0; i < cs.length; i++) {
                    String nombreLibro = cs[i].getName();
                    int cantidad;

                    try {
                        cantidad = Integer.parseInt(cs[i].getValue());
                    } catch (NumberFormatException e) {
                        continue;
                    }

                    double precioUnitario = 0;
                    switch (nombreLibro) {
                        case "Java": precioUnitario = 15.0; break;
                        case "C": precioUnitario = 12.0; break;
                        case "C++": precioUnitario = 18.0; break;
                        case "VB": precioUnitario = 10.0; break;
                        case "Python": precioUnitario = 20.0; break;
                    }

                    if (precioUnitario > 0) {
                        double subtotal = cantidad * precioUnitario;
                        total += subtotal;

                        response.getWriter().append("<tr>");
                        response.getWriter().append("<td>" + nombreLibro + "</td>");
                        response.getWriter().append("<td>" + cantidad + "</td>");
                        response.getWriter().append("<td>" + subtotal + "€</td>");
                        response.getWriter().append("</tr>");
                    }
                }
            }

            response.getWriter().append("</table>");
            response.getWriter().append("<h2 style='text-align:center;'>Total: " + total + "€</h2>");
            response.getWriter().append("<div style='text-align:center;'><a href='Ejercicio3.html'>Volver a la tienda</a></div>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
