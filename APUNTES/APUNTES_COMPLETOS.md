# Apuntes Completos

## Introducción
Este documento contiene notas detalladas sobre acceso a datos, servlets, sesiones, cookies, sincronización de hilos, acceso a bases de datos y aplicaciones JEE. Incluirá ejemplos prácticos enfocados en los ejercicios Ej7_EleccionDeDelegado y Ej8_GestionDeIncedencias.

## 1. Acceso a Datos
El acceso a datos en Java generalmente se realiza a través de JDBC (Java Database Connectivity). JDBC proporciona un conjunto de interfaces y clases para interactuar con bases de datos relacionales.

### Ejemplo Práctico de Acceso a Datos
```java
import java.sql.*;

public class DatabaseAccess {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println("Student ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

## 2. Servlets
Los servlets son componentes Java que permiten generar contenido dinámico en servidores web. Un servlet puede procesar solicitudes y enviar respuestas de vuelta al cliente.

### Ejemplo de Servlet
```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello, World!</h1>");
    }
}
```

## 3. Sesiones y Cookies
Las sesiones permiten mantener información sobre el estado del usuario durante varias interacciones. Las cookies son pequeñas cantidades de datos almacenados en el navegador del cliente.

### Ejemplo de uso de sesiones
```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    session.setAttribute("user", "gabrieltss16");
}
```

### Ejemplo de uso de cookies
```java
Cookie userCookie = new Cookie("user", "gabrieltss16");
userCookie.setMaxAge(60*60*24); // 1 día
response.addCookie(userCookie);
```

## 4. Sincronización de Hilos
La sincronización de hilos es crucial en aplicaciones concurrentes. Utilizar bloques sincronizados o herramientas de sincronización como `ReentrantLock`.

### Ejemplo de Sincronización
```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
```

## 5. Aplicaciones JEE
Java EE (Enterprise Edition) proporciona un entorno robusto para desarrollar aplicaciones empresariales que requieren conectividad a través de Servlets, JSP, EJB, etc.

### Ejemplo de aplicación JEE
```java
@Stateless
public class UserService {
    @PersistenceContext
    private EntityManager em;

    public void addUser(User user) {
        em.persist(user);
    }
}
```

## 6. Ejercicios Prácticos
### Ejercicio 7: EleccionDeDelegado
Descripción y solución detallada del ejercicio.

### Ejercicio 8: GestionDeIncedencias
Descripción y solución detallada del ejercicio.