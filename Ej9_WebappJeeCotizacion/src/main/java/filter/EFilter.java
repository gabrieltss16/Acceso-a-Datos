package filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EFilter
 */
@WebFilter("/ServletCotizacion")
public class EFilter extends HttpFilter implements Filter {
	private Object lock= new Object();

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public EFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		synchronized (lock) {
			String fechaActual = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			request.getServletContext().setAttribute("fechaActual", fechaActual);
			// Si se han grabado los nuevos valores de cotización incrementa el contador.
			if (request.getParameter("boton") != null && request.getParameter("boton").equalsIgnoreCase("Enviar")) {
				Integer contador = request.getServletContext().getAttribute("acceso_" + fechaActual) != null
						? (Integer) request.getServletContext().getAttribute("acceso_" + fechaActual)
						: 0;
				request.getServletContext().setAttribute("acceso_" + fechaActual, contador + 1);
			}
			
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
