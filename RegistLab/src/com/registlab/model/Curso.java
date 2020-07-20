package com.registlab.model;

public class Curso {
	private int id;
	private String curso_asign;
	public Curso(int id, String Curso_nombre){
		this.id = id;
		this.curso_asign = Curso_nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurso_asign() {
		return curso_asign;
	}
	public void setCurso_asign(String curso_nombre) {
		this.curso_asign = curso_nombre;
	}
}
