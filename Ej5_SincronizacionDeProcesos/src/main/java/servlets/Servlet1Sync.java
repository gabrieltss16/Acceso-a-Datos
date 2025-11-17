package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Servlet1Sync")
public class Servlet1Sync extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static int val = 0;
    private final Object lock = new Object();

    public Servlet1Sync() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            synchronized (lock) {
                val = Integer.parseInt(request.getParameter("param"));
                System.out.println("Sync - Thread: " + Thread.currentThread().getName() + " valor inicial " + val);
                Thread.sleep(10000);
                System.out.println("Sync - Thread: " + Thread.currentThread().getName() + " valor dentro synchronized " + val);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sync - Thread: " + Thread.currentThread().getName() + " valor final " + val);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}