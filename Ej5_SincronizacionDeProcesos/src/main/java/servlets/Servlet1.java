package servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static int val = 0;

    public Servlet1() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        if (param == null) {
            System.out.println("Servlet1: falta el parámetro 'param' en la petición.");
            response.setContentType("text/plain; charset=UTF-8");
            response.getWriter().println("Error: falta el parámetro 'param'. Usa ?param=5 por ejemplo.");
            return;
        }

        try {
            val = Integer.parseInt(param);
        } catch (NumberFormatException e) {
            System.out.println("Servlet1: parámetro 'param' no es un entero: " + param);
            response.setContentType("text/plain; charset=UTF-8");
            response.getWriter().println("Error: el parámetro 'param' debe ser un entero. Valor recibido: " + param);
            return;
        }

        System.out.println("Race - Thread: " + Thread.currentThread().getName() + " valor inicial " + val);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Race - Thread: " + Thread.currentThread().getName() + " valor final " + val);

        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().println("OK. valor final: " + val);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}