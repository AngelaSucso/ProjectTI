package com.registlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.registlab.model.Profesor;
import com.registlab.model.Conexion;


public class ProfesorDAO {
	private Conexion con;
	private Connection connection;
	
	public ProfesorDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Profesor profesor) throws SQLException {
		String sql = "INSERT INTO `PROFESOR` (`Nombres`, `Apellidos`) VALUES (?,?);";
		System.out.println(profesor.getNombres());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, profesor.getNombres());
		statement.setString(2, profesor.getApellidos());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Profesor> listarHorarios() throws SQLException {

		List<Profesor> listaHorarios = new ArrayList<Profesor>();
		String sql = "SELECT * FROM profesor";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("idProfesor");
			String nombre = resulSet.getString("Nombres");
			String apellido = resulSet.getString("Apellidos");
			Profesor profesor = new Profesor(id, nombre, apellido);
			listaHorarios.add(profesor);
		}
		con.desconectar();
		return listaHorarios;
	}

	// obtener por id
	public Profesor obtenerPorId(int id) throws SQLException {
		Profesor profesor = null;

		String sql = "SELECT * FROM profesor WHERE idProfesor = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			 profesor = new Profesor(res.getInt("idProfesor"), res.getString("Nombres"),res.getString("Apellidos") );
		}
		res.close();
		con.desconectar();

		return profesor;
	}

	// actualizar
	public boolean actualizar(Profesor profesor) throws SQLException {
		boolean rowActualizar = false;
		String sql = "update horario set `Nombres` = ? , `Apellidos`=?  where idProfesor = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, profesor.getNombres());
		statement.setString(2, profesor.getApellidos());
		System.out.println(profesor.getApellidos());
		statement.setInt(4, profesor.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Profesor profesor) throws SQLException {
		boolean rowEliminar = false;
		String sql = "delete from profesor where idProfesor = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, profesor.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
	public int search_idwithname(Profesor profesor)throws SQLException{
		int num = 0;
		String sql = "select idProfesor from Profesor where Nombres = ";
		String sql2 = "'"+ profesor.getNombres()+"' "+"and Apellidos= '"+profesor.getApellidos()+"' ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql+sql2);
		
		ResultSet res = statement.executeQuery();
		if(res.next())
			num = res.getInt("idProfesor");
		
		res.close();
		con.desconectar();
		return num;
	}
	public boolean setear_tabla() throws SQLException{
		int num = get_idmax();
		boolean rowSetear = false;
		
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement("alter table profesor auto_increment = ?");
		statement.setInt(1, num);
		
		rowSetear = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowSetear;
	}
	
	public boolean actualizar_traseliminar(int num) throws SQLException  {
		boolean rowSetear = false;
		String sql = "update profesor set idProfesor = ? where idProfesor = ?";
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
		String sql = "select max(idProfesor) from profesor";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet res = statement.executeQuery();
		if(res.next())
			num = res.getInt("max(idProfesor)");
		
		res.close();
		con.desconectar();
		return num;
	}
}