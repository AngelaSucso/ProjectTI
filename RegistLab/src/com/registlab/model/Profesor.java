package com.registlab.model;

public class Profesor {
	private int id;
	private String nombres;
	private String apellidos;
	public Profesor(int id, String Nombres, String Apellidos) {
		this.id = id;
		this.nombres = Nombres;
		this.apellidos = Apellidos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
