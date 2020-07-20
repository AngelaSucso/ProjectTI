package com.registlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.registlab.model.Curso;
import com.registlab.model.Conexion;

public class CursoDAO {
	private Conexion con;
	private Connection connection;
	
	public CursoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Curso curso) throws SQLException {
		String sql = "INSERT INTO `CURSO` (`Curso_asign`) VALUES (?);";
		System.out.println(curso.getCurso_asign());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, curso.getCurso_asign());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Curso> listarCursos() throws SQLException {

		List<Curso> listaCursos = new ArrayList<Curso>();
		String sql = "SELECT * FROM curso";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("idCurso");
			String nombre = resulSet.getString("Curso_asign");
			Curso curso = new Curso(id, nombre);
			listaCursos.add(curso);
		}
		con.desconectar();
		return listaCursos;
	}

	// obtener por id
	public Curso obtenerPorId(int id) throws SQLException {
		Curso curso = null;

		String sql = "SELECT * FROM curso WHERE idCurso= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			 curso = new Curso(res.getInt("idCurso"), res.getString("Curso_asign"));
		}
		res.close();
		con.desconectar();

		return curso;
	}

	// actualizar
	public boolean actualizar(Curso curso) throws SQLException {
		boolean rowActualizar = false;
		String sql = "update curso set `Curso_asign` = ?  where idCurso = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, curso.getCurso_asign());
		System.out.println(curso.getCurso_asign());
		statement.setInt(2, curso.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Curso curso) throws SQLException {
		boolean rowEliminar = false;
		String sql = "delete from curso where idCurso = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, curso.getId());

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
		PreparedStatement statement = connection.prepareStatement("alter table curso auto_increment = ?");
		statement.setInt(1, num);
		
		rowSetear = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowSetear;
	}
	
	public boolean actualizar_traseliminar(int num) throws SQLException  {
		boolean rowSetear = false;
		String sql = "update curso set idCurso = ? where idCurso = ?";
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
		String sql = "select max(idCurso) from curso";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet res = statement.executeQuery();
		if(res.next())
			num = res.getInt("max(idCurso)");
		
		res.close();
		con.desconectar();
		return num;
	}
	public int search_idwithname(Curso curso)throws SQLException{
		int num = 0;
		String sql = "select idCurso from Curso where Curso_asign = ";
		String sql2 = "'"+ curso.getCurso_asign()+"' ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql+sql2);
		
		ResultSet res = statement.executeQuery();
		if(res.next())
			num = res.getInt("idCurso");
		
		res.close();
		con.desconectar();
		return num;
	}
	
}