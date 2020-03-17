package BaseDeDatos.BaseDeDatosRafa.modelo.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BaseDeDatos.BaseDeDatosRafa.modelo.Coche;

public class ControladorCoche extends ControladorBBDD {

	
	
	public static List<Coche> getAll () throws ErrorBBDDException {
		List<Coche> coches = new ArrayList<Coche> ();
				
		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from coche");

			while (rs.next()) {
				Coche co = new Coche();
				co.setId(rs.getInt("id"));
				co.setId(rs.getInt("idfabricante"));
				co.setBastidor(rs.getString("bastidor"));
				co.setModelo(rs.getString("modelo"));
				co.setColor(rs.getString("color"));
				coches.add(co);
			}
			
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return coches;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void almacenar (Coche coche) throws ErrorBBDDException {
		if (get(coche.getId()) != null) { // Solo modificar
			almacenarModificado(coche);
		}
		else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(coche);
		}
	}
	

	
	/**
	 * 
	 * @param coche
	 * @return
	 * @throws ErrorBBDDException
	 */
	public static Coche get (int id) throws ErrorBBDDException {
		Connection conn = null;
		Coche co = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from coche where id = " + id);

			if (rs.next()) {
				co = new Coche();
				co.setId(id);
				co.setIdFabricante(rs.getInt("idfabricante"));
				co.setBastidor(rs.getString("bastidor"));
				co.setModelo(rs.getString("modelo"));
				co.setColor(rs.getString("color"));
			}
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return co;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo (Coche co) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"INSERT INTO coche (id, idfabricante, bastidor, modelo, color) VALUES  (?, ?, ?, ?, ?)");
			int registrosInsertados;
			
			ps.setInt(1, nextIdEnTabla(conn, "coche"));
			ps.setInt(2, co.getIdFabricante());
			ps.setString(3, co.getBastidor());
			ps.setString(4, co.getModelo());
			ps.setString(5, co.getColor());

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
	private static void almacenarModificado (Coche co) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"update coche set bastidor = ?, modelo = ?, color = ?, idfabricante = ? where id = ?");
			int registrosInsertados;
			
			ps.setString(1, co.getBastidor());
			ps.setString(2, co.getModelo());
			ps.setString(3, co.getColor());
			ps.setInt(4, co.getId()); 
			ps.setInt(5, co.getIdFabricante());

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
	public static void eliminar (Coche co) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"delete from coche where id = ?");
			int registrosInsertados;
			
			ps.setInt(1, co.getId()); 

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
