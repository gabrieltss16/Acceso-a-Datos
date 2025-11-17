package com.gf.E8_GestionDeIncedencias.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Incidencia {

	private String tema;
	private String descripcion;
	private int codigo;
	private static Set<Integer> listadoCodigos = new HashSet<Integer>();
	
	public Incidencia() {
		
	}
	public Incidencia(String tema, String descripcion) {
		super();
		this.tema = tema;
		this.descripcion = descripcion;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo() {
		
		boolean flag = false;
		Random r = new Random();
		Integer code = r.nextInt(20)+1; 
		
		boolean validaCode = listadoCodigos.add(code); 
		while(!validaCode && !flag) {
			code = r.nextInt(20)+1;
			validaCode = listadoCodigos.add(code); 
			if(listadoCodigos.size()==20) {
				flag=true; 
			}
		}
		
		this.codigo = code;
	}


	
	
}
