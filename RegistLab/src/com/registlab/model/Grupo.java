package com.registlab.model;

public class Grupo {
	private int id;
	private String grupo_asign;
	public Grupo(int id, String Grupo_asign){
		this.id = id;
		this.grupo_asign = Grupo_asign;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGrupo_asign() {
		return grupo_asign;
	}
	public void setGrupo_asign(String grupo_asign) {
		this.grupo_asign = grupo_asign;
	}
	
}
