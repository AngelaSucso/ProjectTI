package com.registlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.registlab.model.Asignatura;
import com.registlab.model.Conexion;
import com.registlab.model.Asignaturagenerica;


public class AsignaturaDAO {
	private Conexion con;
	private Connection connection;
	
	public AsignaturaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Asignatura asignatura) throws SQLException {
		String sql = "INSERT INTO `ASIGNATURA`(`idCurso`, `idHorario`, `idGrado`, `idGrupo`, `idProfesor`, `Capacidad`) VALUES (?,?,?,?,?,?);";
		System.out.println(asignatura.getId());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, asignatura.getIdCurso());
		statement.setInt(2, asignatura.getIdHorario());
		statement.setInt(3, asignatura.getIdGrado());
		statement.setInt(4, asignatura.getIdGrupo());
		statement.setInt(5, asignatura.getIdProfesor());
		statement.setInt(6, asignatura.getCapacidad());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Asignatura> listarAlumnos() throws SQLException {

		List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
		String sql = "SELECT * FROM asignatura";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("idAsignatura");
			int idcurso = resulSet.getInt("idCurso");
			int idhorario = resulSet.getInt("idHorario");
			int idgrado = resulSet.getInt("idGrado");
			int idgrupo = resulSet.getInt("idGrupo");
			int idprofesor = resulSet.getInt("idProfesor");
			int capacidad = resulSet.getInt("Capacidad");
			Asignatura asignatura = new Asignatura(id, idcurso, idhorario, idgrado, idgrupo, idprofesor, capacidad);
			listaAsignaturas.add(asignatura);
		}
		con.desconectar();
		return listaAsignaturas;
	}

	// obtener por id
	public Asignatura obtenerPorId(int id) throws SQLException {
		Asignatura asignatura = null;

		String sql = "SELECT * FROM asignatura WHERE idAsignatura= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			 asignatura = new Asignatura(res.getInt("idAsignatura"), res.getInt("idCurso"), res.getInt("idHorario"),
					res.getInt("idGrado"), res.getInt("idGrupo"), res.getInt("idProfesor"), res.getInt("Capacidad"));
		}
		res.close();
		con.desconectar();

		return asignatura;
	}

	// actualizar
	public boolean actualizar(Asignatura asignatura) throws SQLException {
		boolean rowActualizar = false;
		String sql = "update asignatura set  idCurso=?, idHorario=?, idGrado=?, idGrupo = ?, idProfesor = ?, Capacidad =? where idAsignatura = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1,asignatura.getIdCurso());
		statement.setInt(2, asignatura.getIdHorario());
		statement.setInt(3, asignatura.getIdGrado());
		statement.setInt(4, asignatura.getIdGrupo());
		System.out.println(asignatura.getId());
		statement.setInt(5, asignatura.getIdProfesor());
		statement.setInt(6, asignatura.getCapacidad());
		statement.setInt(7, asignatura.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Asignatura asignatura) throws SQLException {
		boolean rowEliminar = false;
		String sql = "delete from asignatura where idAsignatura = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, asignatura.getId());

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
		PreparedStatement statement = connection.prepareStatement("alter table asignatura auto_increment = ?");
		statement.setInt(1, num);
		
		rowSetear = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowSetear;
	}
	
	public boolean actualizar_traseliminar(int num) throws SQLException  {
		boolean rowSetear = false;
		String sql = "update asignatura set idAsignatura = ? where idAsignatura = ?";
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
		String sql = "select max(idAsignatura) from asignatura";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet res = statement.executeQuery();
		if(res.next())
			num = res.getInt("max(idAsignatura)");
		
		res.close();
		con.desconectar();
		return num;
	}
	public List<Asignaturagenerica> Listarporgrado(int grado) throws SQLException{
		List<Asignaturagenerica> listaAsignaturagenerica = new ArrayList<Asignaturagenerica>();
		
		String sql="select  ASIGNATURA.idAsignatura, Curso.Curso_asign, horario.Hora_inicio, horario.Hora_fin, horario.Fecha, Grado.grado_asign, Grupo.Grupo_asign, Profesor.Apellidos, Profesor.Nombres, Asignatura.Capacidad ";
		String sql2="from curso, horario, grado, grupo, profesor, asignatura ";
		String sql3="where Curso.idCurso=asignatura.idCurso and Horario.idHorario=asignatura.idHorario and Grado.idGrado=asignatura.idGrado and Grupo.idGrupo=asignatura.idGrupo and Grupo.idGrupo=asignatura.idGrupo and Profesor.idProfesor = asignatura.idProfesor and Grado.idGrado =";
		String sql4 = String.valueOf(grado)+";";
		
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql+sql2+sql3+sql4);
		

		while (resulSet.next()) {
			int id = resulSet.getInt("idAsignatura");
			String idcurso = resulSet.getString("Curso_asign");
			String idhorario = resulSet.getString("Hora_inicio");
			String idhorario2 = resulSet.getString("Hora_fin");
			String Fecha = resulSet.getString("Fecha");
			String idgrado = resulSet.getString("grado_asign");
			String idgrupo = resulSet.getString("Grupo_asign");
			String Apellidos = resulSet.getString("Apellidos");
			String Nombres = resulSet.getString("Nombres");
			int capacidad = resulSet.getInt("Capacidad");
			Asignaturagenerica asignatura = new Asignaturagenerica(id, idcurso, idhorario+" "+idhorario2 +" "+ Fecha, idgrado, idgrupo, Apellidos+" "+Nombres, capacidad);
			listaAsignaturagenerica.add(asignatura);
		}
		con.desconectar();
		
		return  listaAsignaturagenerica;
	}
	
	public Asignaturagenerica Listarporid(int ids) throws SQLException{
		Asignaturagenerica asignatura = null;
		
		String sql="select  ASIGNATURA.idAsignatura, Curso.Curso_asign, horario.Hora_inicio, horario.Hora_fin, horario.Fecha, Grado.grado_asign, Grupo.Grupo_asign, Profesor.Apellidos, Profesor.Nombres, Asignatura.Capacidad ";
		String sql2="from curso, horario, grado, grupo, profesor, asignatura ";
		String sql3="where Curso.idCurso=asignatura.idCurso and Horario.idHorario=asignatura.idHorario and Grado.idGrado=asignatura.idGrado and Grupo.idGrupo=asignatura.idGrupo and Grupo.idGrupo=asignatura.idGrupo and Profesor.idProfesor = asignatura.idProfesor and asignatura.idAsignatura = ";
		String sql4 = String.valueOf(ids)+";";
		
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql+sql2+sql3+sql4);
		

		if (resulSet.next()) {
			int id = resulSet.getInt("idAsignatura");
			String idcurso = resulSet.getString("Curso_asign");
			String idhorario = resulSet.getString("Hora_inicio");
			String idhorario2 = resulSet.getString("Hora_fin");
			String Fecha = resulSet.getString("Fecha");
			String idgrado = resulSet.getString("grado_asign");
			String idgrupo = resulSet.getString("Grupo_asign");
			String Apellidos = resulSet.getString("Apellidos");
			String Nombres = resulSet.getString("Nombres");
			int capacidad = resulSet.getInt("Capacidad");
			asignatura = new Asignaturagenerica(id, idcurso, idhorario+" "+idhorario2 +" "+ Fecha, idgrado, idgrupo, Apellidos+" "+Nombres, capacidad);
		}
		con.desconectar();
		
		return  asignatura;
	}
	

}