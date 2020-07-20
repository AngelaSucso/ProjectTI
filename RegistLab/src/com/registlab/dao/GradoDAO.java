package com.registlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.registlab.model.Grado;
import com.registlab.model.Conexion;


public class GradoDAO {
	private Conexion con;
	private Connection connection;
	
	public GradoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Grado grado) throws SQLException {
		String sql = "INSERT INTO `GRADO` (`Grado_asign`) VALUES (?);";
		System.out.println(grado.getGrado_asign());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, grado.getGrado_asign());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Grado> listarGrados() throws SQLException {

		List<Grado> listaGrados = new ArrayList<Grado>();
		String sql = "SELECT * FROM grado";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("idGrado");
			String nombre = resulSet.getString("Grado_asign");
			Grado grado = new Grado(id, nombre);
			listaGrados.add(grado);
		}
		con.desconectar();
		return listaGrados;
	}

	// obtener por id
	public Grado obtenerPorId(int id) throws SQLException {
		Grado grado = null;

		String sql = "SELECT * FROM grado WHERE idGrado= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			 grado = new Grado(res.getInt("idGrado"), res.getString("Grado_asign"));
		}
		res.close();
		con.desconectar();

		return grado;
	}

	// actualizar
	public boolean actualizar(Grado grado) throws SQLException {
		boolean rowActualizar = false;
		String sql = "update curso set `Grado_asign` = ?  where idGrado = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, grado.getGrado_asign());
		System.out.println(grado.getGrado_asign());
		statement.setInt(2, grado.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Grado grado) throws SQLException {
		boolean rowEliminar = false;
		String sql = "delete from grado where idGrado = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, grado.getId());

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
		PreparedStatement statement = connection.prepareStatement("alter table grado auto_increment = ?");
		statement.setInt(1, num);
		
		rowSetear = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowSetear;
	}
	
	public boolean actualizar_traseliminar(int num) throws SQLException  {
		boolean rowSetear = false;
		String sql = "update grado set idGrado = ? where idGrado = ?";
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
	public int search_idwithname(Grado grado)throws SQLException{
		int num = 0;
		String sql = "select idGrado from Grado where Grado_asign = ";
		String sql2 = "'"+ grado.getGrado_asign()+"' ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql+sql2);
		
		ResultSet res = statement.executeQuery();
		if(res.next())
			num = res.getInt("idGrado");
		
		res.close();
		con.desconectar();
		return num;
	}
}