package com.gregoriofer.Ej7_EleccionDeDelegado.model;

public class Votacion {
	private String alumno;
	private Integer numVotos;
	
	public Votacion (String alumno) {
		this.alumno = alumno;
	}
	
	public Votacion(String alumno, Integer numVotos) {
		super();
		this.alumno = alumno;
		this.numVotos = numVotos;
	}
	public String getAlumno() {
		return alumno;
	}
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	public Integer getNumVotos() {
		return numVotos;
	}
	public void setNumVotos() {
		numVotos++;
	}
	
	
	
	
	
	
}
