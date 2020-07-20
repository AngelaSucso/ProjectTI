package com.registlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.registlab.model.Grupo;
import com.registlab.model.Conexion;


public class GrupoDAO {
	private Conexion con;
	private Connection connection;
	
	public GrupoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Grupo grupo) throws SQLException {
		String sql = "INSERT INTO `GRUPO` (`Grupo_asign`) VALUES (?);";
		System.out.println(grupo.getGrupo_asign());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, grupo.getGrupo_asign());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Grupo> listarGrupos() throws SQLException {

		List<Grupo> listaGrupos = new ArrayList<Grupo>();
		String sql = "SELECT * FROM grupo";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("idGrupo");
			String nombre = resulSet.getString("Grupo_asign");
			Grupo grupo = new Grupo(id, nombre);
			listaGrupos.add(grupo);
		}
		con.desconectar();
		return listaGrupos;
	}

	// obtener por id
	public Grupo obtenerPorId(int id) throws SQLException {
		Grupo grupo = null;

		String sql = "SELECT * FROM grupo WHERE idGrupo= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			 grupo = new Grupo(res.getInt("idGrupo"), res.getString("Grupo_asign"));
		}
		res.close();
		con.desconectar();

		return grupo;
	}

	// actualizar
	public boolean actualizar(Grupo grupo) throws SQLException {
		boolean rowActualizar = false;
		String sql = "update curso set `Grupo_asign` = ?  where idGrupo = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, grupo.getGrupo_asign());
		System.out.println(grupo.getGrupo_asign());
		statement.setInt(2, grupo.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Grupo grupo) throws SQLException {
		boolean rowEliminar = false;
		String sql = "delete from grupo where idGrupo = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, grupo.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
	public int search_idwithname(Grupo grupo)throws SQLException{
		int num = 0;
		String sql = "select idGrupo from Grupo where Grupo_asign = ";
		String sql2 = "'"+ grupo.getGrupo_asign()+"' ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql+sql2);
		
		ResultSet res = statement.executeQuery();
		if(res.next())
			num = res.getInt("idGrupo");
		
		res.close();
		con.desconectar();
		return num;
	}
	
	public boolean setear_tabla() throws SQLException{
		int num = get_idmax();
		boolean rowSetear = false;
		
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement("alter table grupo auto_increment = ?");
		statement.setInt(1, num);
		
		rowSetear = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowSetear;
	}
	
	public boolean actualizar_traseliminar(int num) throws SQLException  {
		boolean rowSetear = false;
		String sql = "update grupo set idGrupo = ? where idGrupo = ?";
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
		String sql = "select max(idGrupo) from grupo";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet res = statement.executeQuery();
		if(res.next())
			num = res.getInt("max(idGrupo)");
		
		res.close();
		con.desconectar();
		return num;
	}
}