package com.gf.filters;


import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/Registro.jsp")
public class Filter extends HttpFilter implements jakarta.servlet.Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public Filter() {
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
		
		ServletContext contexto = request.getServletContext();
		Integer numAccesos = contexto.getAttribute("numAccesos") != null?(Integer)contexto.getAttribute("numAccesos"):0;
		contexto.setAttribute("numAccesos", numAccesos + 1);
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
