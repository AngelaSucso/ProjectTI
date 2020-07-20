package com.registlab.model;

public class Horario {
	private int id;
	private String hora_inicio;
	private String hora_fin;
	private String fecha;
	public Horario(int id, String Hora_inicio, String Hora_fin, String Fecha) {
		this.id = id;
		this.hora_inicio = Hora_inicio;
		this.hora_fin = Hora_fin;
		this.fecha = Fecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public String getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
