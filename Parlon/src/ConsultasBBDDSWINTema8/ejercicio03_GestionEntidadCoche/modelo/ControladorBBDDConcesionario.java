package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_GestionEntidadCoche.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_GestionEntidadCoche.modelo.ConnectionManagerV2;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_GestionEntidadCoche.modelo.entidades.Concesionario;


public class ControladorBBDDConcesionario  {


	

	/**
	 * 
	 * @return
	 */
	public static Concesionario getPrimerConcesionario () {
		Concesionario concesionario = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.concesionario order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				concesionario = getConcesionarioFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return concesionario;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Concesionario getUltimoConcesionario () {
		Concesionario concesionario = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.concesionario order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				concesionario = getConcesionarioFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return concesionario;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Concesionario getSiguienteConcesionario (Concesionario concesionarioActual) {
		Concesionario concesionarioResultado = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.concesionario where id > ? order by id limit 1");
			ps.setInt(1, concesionarioActual.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				concesionarioResultado = getConcesionarioFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return concesionarioResultado;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Concesionario getAnteriorConcesionario (Concesionario concesionarioActual) {
		Concesionario concesionarioResultado = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.concesionario where id < ? order by id desc limit 1");
			ps.setInt(1, concesionarioActual.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				concesionarioResultado = getConcesionarioFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return concesionarioResultado;
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean guardarNuevoConcesionario (Concesionario concesionario) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO tutorialjavacoches.concesionario values (?, ?, ?, ?, ?)");
			ps.setInt(1, getUltimoConcesionario().getId() + 1);
			ps.setString(3, concesionario.getCif());
			ps.setString(4, concesionario.getNombre());
			ps.setString(5, concesionario.getLocalidad());
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean modificarConcesionario (Concesionario concesionario) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "UPDATE tutorialjavacoches.concesionario SET id = ?, cif = ?, nombre = ?, localidad= ?");
			ps.setInt(1, concesionario.getId());
			ps.setString(2, concesionario.getCif());
			ps.setString(3, concesionario.getNombre());
			ps.setString(4, concesionario.getLocalidad());
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean eliminarConcesionario (Concesionario concesionario) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "DELETE FROM tutorialjavacoches.concesionario where id = ?");
			ps.setInt(1, concesionario.getId());
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
		
	
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static Concesionario getConcesionarioFromResultSet (ResultSet rs) {
		Concesionario concesionario = new Concesionario();
		
		try {
			concesionario.setId(rs.getInt("id"));
			concesionario.setCif(rs.getString("cif"));
			concesionario.setNombre(rs.getString("nombre"));
			concesionario.setLocalidad(rs.getString("localidad"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return concesionario;
	}


/**
 * 
 * @return
 */
	public static List getTodosConcesionario () {
		List resultado = new ArrayList();
		try {
		Connection conn = ConnectionManagerV2.getConexion();

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.concesionario order by nombre");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		resultado.add(getConcesionarioFromResultSet(rs));
		}
		rs.close();
		ps.close();
		conn.close();
		} catch (SQLException | ImposibleConectarException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		return resultado;
		}
}
