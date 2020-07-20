package com.registlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.registlab.model.Alumno;

import com.registlab.model.Conexion;

public class AlumnoDAO {
	private Conexion con;
	private Connection connection;
	
	public AlumnoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Alumno alumno) throws SQLException {
		String sql = "INSERT INTO `ALUMNO` (`C.U.I.`, `Nombres_Alumno`, `Apellidos_Almuno`, `Correo`, `idAsignatura`) VALUES (?, ?, ?,?,?);";
		System.out.println(alumno.getNombres());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, alumno.getCUI());
		statement.setString(2, alumno.getNombres());
		statement.setString(3, alumno.getApellidos());
		statement.setString(4, alumno.getCorreo());
		statement.setInt(5, alumno.getAsignatura());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Alumno> listarAlumnos() throws SQLException {

		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		String sql = "SELECT * FROM alumno";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("idAlumno");
			int cui = resulSet.getInt("C.U.I.");
			String nombre = resulSet.getString("Nombres_Alumno");
			String apellido = resulSet.getString("Apellidos_Almuno");
			String correo = resulSet.getString("Correo");
			int idasign = resulSet.getInt("idAsignatura");
			Alumno alumno = new Alumno(id, cui, nombre, apellido, correo, idasign);
			listaAlumnos.add(alumno);
		}
		con.desconectar();
		return listaAlumnos;
	}

	// obtener por id
	public Alumno obtenerPorId(int id) throws SQLException {
		Alumno alumno = null;

		String sql = "SELECT * FROM alumno WHERE idAlumno= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			 alumno = new Alumno(res.getInt("idAlumno"), res.getInt("C.U.I."), res.getString("Nombres_Alumno"),
					res.getString("Apellidos_Almuno"), res.getString("Correo"), res.getInt("idAsignatura"));
		}
		res.close();
		con.desconectar();

		return alumno;
	}

	// actualizar
	public boolean actualizar(Alumno alumno) throws SQLException {
		boolean rowActualizar = false;
		String sql = "update alumno set `C.U.I.` =?, Nombres_Alumno=?, Apellidos_Almuno=?, Correo=?, idAsignatura = ? where idAlumno = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, alumno.getCUI());
		statement.setString(2, alumno.getNombres());
		statement.setString(3, alumno.getApellidos());
		statement.setString(4, alumno.getCorreo());
		System.out.println(alumno.getCUI());
		statement.setInt(5, alumno.getAsignatura());
		statement.setInt(6, alumno.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Alumno alumno) throws SQLException {
		boolean rowEliminar = false;
		String sql = "delete from alumno where idAlumno = ?";
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, alumno.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
	
	public boolean setear_tabla() throws SQLException{
		int num = get_idmax();
		boolean rowSetear = false;
		
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement("alter table alumno auto_increment = ?");
		statement.setInt(1, num);
		
		rowSetear = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowSetear;
	}
	
	public boolean actualizar_traseliminar(int num) throws SQLException  {
		boolean rowSetear = false;
		String sql = "update alumno set idAlumno = ? where idAlumno = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, num);
		statement.setInt(2, num+1);
		
		rowSetear = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowSetear;
	}
	
	public int get_idmax()throws SQLException{
		int num=0;
		String sql = "select max(idAlumno) from alumno";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet res = statement.executeQuery();
		if(res.next())
			num = res.getInt("max(idAlumno)");
		
		res.close();
		con.desconectar();
		return num;
	}
	
	public List<Alumno> Listarporidasignatura(int ids) throws SQLException{
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		String sql="select * from alumno where idasignatura = ";
		String sql2 = String.valueOf(ids);
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql+sql2);
		

		while (resulSet.next()) {
			int id = resulSet.getInt("idAlumno");
			int cui = resulSet.getInt("C.U.I.");
			String nombre = resulSet.getString("Nombres_Alumno");
			String apellido = resulSet.getString("Apellidos_Almuno");
			String correo = resulSet.getString("Correo");
			int idasign = resulSet.getInt("idAsignatura");
			Alumno alumno = new Alumno(id, cui, nombre, apellido, correo, idasign);
			listaAlumnos.add(alumno);
		}
		con.desconectar();
		return listaAlumnos;
	}

}
