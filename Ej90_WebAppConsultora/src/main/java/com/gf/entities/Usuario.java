package com.gf.entities;



public class Usuario {
	private String nombre;
	private String contraseña;
	private String categoriaProfesional;

	public Usuario(String nombre, String contraseña, String categoriaProfesional) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.categoriaProfesional = categoriaProfesional;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCategoriaProfesional() {
		return categoriaProfesional;
	}

	public void setCategoriaProfesional(String categoriaProfesional) {
		this.categoriaProfesional = categoriaProfesional;
	}

}
