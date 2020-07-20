package com.registlab.model;

public class Alumno {
	private int id;
	private int CUI;
	private String nombres;
	private String apellidos;
	private String correo;
	private int asignatura;
	
	public Alumno(int id, int CUI, String Nombres, String Apellidos, String Correo, int Asignatura) {
		this.id = id;
		this.CUI = CUI;
		this.nombres = Nombres;
		this.apellidos = Apellidos;
		this.correo = Correo;
		this.asignatura = Asignatura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCUI() {
		return CUI;
	}

	public void setCUI(int cUI) {
		CUI = cUI;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(int asignatura) {
		this.asignatura = asignatura;
	}
	
}

/*`idAlumno` INT PRIMARY KEY AUTO_INCREMENT,
	`C.U.I.` INT(10) NOT NULL,
	`Nombres_Alumno` VARCHAR(45) NOT NULL,
	`Apellidos_Almuno` VARCHAR(45) NOT NULL,
	`Correo` VARCHAR(80) NOT NULL,
	`idAsignatura` INT,*/