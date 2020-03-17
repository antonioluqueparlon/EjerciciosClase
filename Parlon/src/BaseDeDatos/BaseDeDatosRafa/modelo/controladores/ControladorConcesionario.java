package BaseDeDatos.BaseDeDatosRafa.modelo.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BaseDeDatos.BaseDeDatosRafa.modelo.Concesionario;

public class ControladorConcesionario extends ControladorBBDD {

	
	
	public static List<Concesionario> getAll () throws ErrorBBDDException {
		List<Concesionario> concesionarios = new ArrayList<Concesionario> ();
				
		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from concesionario");

			while (rs.next()) {
				Concesionario con = new Concesionario();
				con.setId(rs.getInt("id"));
				con.setCif(rs.getString("cif"));
				con.setNombre(rs.getString("nombre"));
				con.setLocalidad(rs.getString("localidad"));
				concesionarios.add(con);
			}
			
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return concesionarios;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void almacenar (Concesionario concesionario) throws ErrorBBDDException {
		if (get(concesionario.getId()) != null) { // Solo modificar
			almacenarModificado(concesionario);
		}
		else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(concesionario);
		}
	}
	

	
	/**
	 * 
	 * @param fabricante
	 * @return
	 * @throws ErrorBBDDException
	 */
	public static Concesionario get (int id) throws ErrorBBDDException {
		Connection conn = null;
		Concesionario con = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from concesionario where id = " + id);

			if (rs.next()) {
				con = new Concesionario();
				con.setId(id);
				con.setCif(rs.getString("cif"));
				con.setNombre(rs.getString("nombre"));
				con.setLocalidad(rs.getString("localidad"));
			}
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return con;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo (Concesionario conc) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"INSERT INTO concesionario (id, cif, nombre, localidad) VALUES  (?, ?, ?, ?)");
			int registrosInsertados;
			
			ps.setInt(1, nextIdEnTabla(conn, "concesionario")); 
			ps.setString(2, conc.getCif());
			ps.setString(3, conc.getNombre());
			ps.setString(4, conc.getLocalidad());

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException ("No ha sido posible la inserción del nuevo registro");
			}
			ps.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		}

	}
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarModificado (Concesionario conc) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"update concesionario set cif = ?, nombre = ?, localidad = ?, where id = ?");
			int registrosInsertados;
			
			ps.setString(1, conc.getCif());
			ps.setString(2, conc.getNombre());
			ps.setInt(3, conc.getId()); 
			ps.setString(4, conc.getLocalidad());

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException ("No ha sido posible la modificación del registro");
			}
			ps.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		}

	}
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void eliminar (Concesionario conc) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"delete from concesionario where id = ?");
			int registrosInsertados;
			
			ps.setInt(1, conc.getId()); 

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException ("No ha sido posible la eliminación del registro");
			}
			ps.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		}

	}
	
	
}
