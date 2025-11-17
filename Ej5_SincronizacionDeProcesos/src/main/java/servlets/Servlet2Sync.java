package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/Servlet2Sync")
public class Servlet2Sync extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public int valor = 0;
    private final Object lock = new Object();

    public Servlet2Sync() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int N = 100;
        int[] nums = new int[N];
        Random rnd = new Random();

        for (int i = 0; i < N; i++) {
            nums[i] = rnd.nextInt(100);
        }

        synchronized (lock) {
            for (int n : nums) {
                valor += n;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int n : nums) {
                valor -= n;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Servlet2Sync - Thread: " + Thread.currentThread().getName() + " valor = " + valor);

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<html><head><meta charset='utf-8'><title>Ejercicio 2 - Sync</title></head><body>");
        response.getWriter().println("<p>valor = " + valor + "</p>");
        response.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}