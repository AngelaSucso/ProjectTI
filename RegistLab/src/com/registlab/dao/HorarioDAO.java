package com.registlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.registlab.model.Horario;
import com.registlab.model.Conexion;


public class HorarioDAO {
	private Conexion con;
	private Connection connection;
	
	public HorarioDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Horario horario) throws SQLException {
		String sql = "INSERT INTO `HORARIO` (`Hora_inicio`, `Hora_fin`,`Fecha`) VALUES (?,?,?);";
		System.out.println(horario.getId());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, horario.getHora_inicio());
		statement.setString(2, horario.getHora_fin());
		statement.setString(3, horario.getFecha());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Horario> listarHorarios() throws SQLException {

		List<Horario> listaHorarios = new ArrayList<Horario>();
		String sql = "SELECT * FROM horario";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("idHorario");
			String hora_inicio = resulSet.getString("Hora_inicio");
			String hora_fin = resulSet.getString("Hora_fin");
			String fecha = resulSet.getString("Fecha");
			Horario horario = new Horario(id, hora_inicio, hora_fin, fecha);
			listaHorarios.add(horario);
		}
		con.desconectar();
		return listaHorarios;
	}

	// obtener por id
	public Horario obtenerPorId(int id) throws SQLException {
		Horario horario = null;

		String sql = "SELECT * FROM horario WHERE idHorario = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			 horario = new Horario(res.getInt("idHorario"), res.getString("Hora_inicio"),res.getString("Hora_fin")  ,res.getString("Fecha") );
		}
		res.close();
		con.desconectar();

		return horario;
	}

	// actualizar
	public boolean actualizar(Horario horario) throws SQLException {
		boolean rowActualizar = false;
		String sql = "update horario set `Hora_inicio` = ? , `Hora_fin`=? , `Fecha`=?  where idHorario = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, horario.getHora_inicio());
		statement.setString(2, horario.getHora_fin());
		statement.setString(3, horario.getFecha());
		System.out.println(horario.getHora_inicio());
		statement.setInt(4, horario.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Horario horario) throws SQLException {
		boolean rowEliminar = false;
		String sql = "delete from horario where idHorario = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, horario.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
	public int search_idwithname(Horario horario)throws SQLException{
		int num = 0;
		String sql = "select idHorario from Horario where Hora_inicio = ";
		String sql2 = "'"+ horario.getHora_inicio()+"' "+"and Hora_fin= '"+horario.getHora_fin()+"' and Fecha = '"+horario.getFecha()+"' ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql+sql2);
		
		ResultSet res = statement.executeQuery();
		if(res.next())
			num = res.getInt("idHorario");
		
		res.close();
		con.desconectar();
		return num;
	}
	public boolean setear_tabla() throws SQLException{
		int num = get_idmax();
		boolean rowSetear = false;
		
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement("alter table horario auto_increment = ?");
		statement.setInt(1, num);
		
		rowSetear = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowSetear;
	}
	
	public boolean actualizar_traseliminar(int num) throws SQLException  {
		boolean rowSetear = false;
		String sql = "update horario set idHorario = ? where idHorario = ?";
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
		String sql = "select max(idHorario) from horario";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet res = statement.executeQuery();
		if(res.next())
			num = res.getInt("max(idHorario)");
		
		res.close();
		con.desconectar();
		return num;
	}
}