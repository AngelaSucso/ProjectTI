package com.registlab.model;

public class Asignaturagenerica {
	private int id;
	private String curso;
	private String horario;
	private String grado;
	private String grupo;
	private String profesor;
	private int capacidad;
	
	public Asignaturagenerica(int id, String curso, String horario, String grado, String grupo, String profesor, int capacidad) {
		this.id = id;
		this.curso = curso;
		this.horario = horario;
		this.grado = grado;
		this.grupo = grupo;
		this.profesor = profesor;
		this.capacidad = capacidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
}
