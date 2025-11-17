package com.gf.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gf.entities.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object lock = new Object();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Usuario> usuariosRegistrados = getServletContext().getAttribute("usersReg") != null
				? (ArrayList<Usuario>) getServletContext().getAttribute("usersReg")
				: new ArrayList<Usuario>();
		String page = "";
		switch (request.getParameter("boton")) {
		case "Registro":
			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("password");
			String cat = request.getParameter("categoria");
			if (!nombre.isBlank() && !pass.isBlank()) {
				Usuario user = new Usuario(nombre, pass, cat);
				// synchronized (lock) {
				//En cada registro nuevo invalidamos la sesión activa si la hubiera
				request.getSession(true).invalidate();
				//Se crea una nueva sesión
				HttpSession sesion = request.getSession(true);
				//Se almacenan los datos del usuario registrado en sesión
				sesion.setAttribute("usuario", user);
				//Se guarda en el contexto la lista de usuarios registrados
				usuariosRegistrados.add(user);
				getServletContext().setAttribute("usersReg", usuariosRegistrados);
				// }
				page = "/Acceso.jsp";
			} else { // Registro
				request.setAttribute("sinDatos", true);
				page = "/Registro.jsp";
			}
			break;
		case "Acceso":
			page = "/Aplicacion.jsp";
			break;
		}
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}
}
