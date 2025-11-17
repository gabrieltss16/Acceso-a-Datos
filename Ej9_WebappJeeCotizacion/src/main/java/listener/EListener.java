package listener;

import java.util.HashMap;

import entities.Cotizacion;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class EListener
 *
 */
@WebListener("/EListener")
public class EListener implements ServletContextListener {
	private Object lock = new Object();

	/**
	 * Default constructor.
	 */
	public EListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		HashMap<String, Cotizacion> cotizaciones = new HashMap<String, Cotizacion>();
		cotizaciones.put("DAM", new Cotizacion("DAM", 48.5));
		cotizaciones.put("SMR", new Cotizacion("SMR", 47.5));
		cotizaciones.put("ADFI", new Cotizacion("ADFI", 30.0));
		cotizaciones.put("ADMIN", new Cotizacion("ADMIN", 45.0));
		cotizaciones.put("VENTAS", new Cotizacion("VENTAS", 20.5));
		cotizaciones.put("TURISMO", new Cotizacion("TURISMO", 19.5));
		cotizaciones.put("ISOCIAL", new Cotizacion("ISOCIAL", 37.5));
		cotizaciones.put("EDINF", new Cotizacion("EDINF", 23.0));
		cotizaciones.put("LABCLIN", new Cotizacion("LABCLIN", 52.0));
		cotizaciones.put("FARMACIA", new Cotizacion("FARMACIA", 35.6));
		cotizaciones.put("ATENCION", new Cotizacion("ATENCION", 30.5));
		cotizaciones.put("IA", new Cotizacion("IA", 58.0));
		synchronized (lock) {
			sce.getServletContext().setAttribute("listCotiza", cotizaciones);
		}

	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

}
