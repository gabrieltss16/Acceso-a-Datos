package com.gregoriofer.Ej7_EleccionDeDelegado.controller;

import java.io.IOException;
import java.util.HashMap;

import com.gregoriofer.Ej7_EleccionDeDelegado.model.Votacion;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletVotacion
 */
@WebServlet("/ServletVotacion")
public class ServletVotacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVotacion() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = getServletConfig().getServletContext();
		HashMap<String, Votacion> mapVot = sc.getAttribute("mapVotos") != null ? (HashMap<String, Votacion>) sc.getAttribute("mapVotos") : new HashMap<String, Votacion>();
		
		String[] candidatos = request.getParameterValues("alumno") != null ? request.getParameterValues("alumno") : new String[] {"Blancos"};
		for (String c : candidatos) {
			Votacion v = mapVot.get(c) != null ? mapVot.get(c) : new Votacion(c);
			v.setNumVotos();
			mapVot.put(c, v);
		}
		
	}

}
