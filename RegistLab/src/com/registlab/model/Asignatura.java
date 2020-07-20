package com.registlab.model;

public class Asignatura {
	private int id;
	private int idCurso;
	private int idHorario;
	private int idGrado;
	private int idGrupo;
	private int idProfesor;
	private int capacidad;
	
	public Asignatura(int id, int idCurso, int idHorario, int idGrado, int idGrupo, int idProfesor, int Capacidad) {
		this.id = id;
		this.idCurso = idCurso;
		this.idHorario = idHorario;
		this.idGrado = idGrado;
		this.idGrupo = idGrupo;
		this.idProfesor = idProfesor;
		this.capacidad = Capacidad;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public int getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(int idGrado) {
		this.idGrado = idGrado;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
}
