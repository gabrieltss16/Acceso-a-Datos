package com.ejemplo;

public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    private String contacto;

    // Constructor
    public Persona(String nombre, String apellidos, int edad, String contacto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.contacto = contacto;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getContacto() {
        return contacto;
    }
}
