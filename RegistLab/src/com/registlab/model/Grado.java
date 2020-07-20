package com.registlab.model;

public class Grado {
	private int id;
	private String grado_asign;
	public Grado(int id, String Grado_asign){
		this.grado_asign = Grado_asign;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGrado_asign() {
		return grado_asign;
	}
	public void setGrado_asign(String grado_asign) {
		this.grado_asign = grado_asign;
	}
	
}
