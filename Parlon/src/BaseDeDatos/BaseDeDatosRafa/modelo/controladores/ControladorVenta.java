package BaseDeDatos.BaseDeDatosRafa.modelo.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BaseDeDatos.BaseDeDatosRafa.modelo.Venta;

public class ControladorVenta extends ControladorBBDD {

	
	
	public static List<Venta> getAll () throws ErrorBBDDException {
		List<Venta> ventas = new ArrayList<Venta> ();
				
		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from venta");

			while (rs.next()) {
				Venta ve = new Venta();
				ve.setId(rs.getInt("id"));
				ve.setIdCliente(rs.getInt("idCliente"));
				ve.setIdConcesionario(rs.getInt("idConcesionario"));
				ve.setIdCoche(rs.getInt("idCoche"));
				ve.setFecha(rs.getDate("fecha"));
				ve.setPrecioVenta(rs.getInt("precioVenta"));
				ventas.add(ve);
			}
			
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return ventas;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void almacenar (Venta venta) throws ErrorBBDDException {
		if (get(venta.getId()) != null) { // Solo modificar
			almacenarModificado(venta);
		}
		else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(venta);
		}
	}
	

	
	/**
	 * 
	 * @param venta
	 * @return
	 * @throws ErrorBBDDException
	 */
	public static Venta get (int id) throws ErrorBBDDException {
		Connection conn = null;
		Venta ve = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from venta where id = " + id);

			if (rs.next()) {
				ve = new Venta();
				ve.setId(id);
				ve.setIdCliente(rs.getInt("idCliente"));
				ve.setIdConcesionario(rs.getInt("idConcesionario"));
				ve.setIdCoche(rs.getInt("idCoche"));
				ve.setFecha(rs.getDate("fecha"));
				ve.setPrecioVenta(rs.getFloat("precioVenta"));
			}
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return ve;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo (Venta ve) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"INSERT INTO venta (id, idCliente, idConcesionario,idCoche,fecha,precioVenta) VALUES  (?, ?, ?, ?, ?, ?)");
			int registrosInsertados;
			
			ps.setInt(1, nextIdEnTabla(conn, "venta")); 
			ps.setInt(2, ve.getIdCliente());
			ps.setInt(3, ve.getIdConcesionario());
			ps.setInt(4, ve.getIdCoche());
			ps.setDate(5, ve.getFecha());
			ps.setFloat(6, ve.getPrecioVenta());

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
	private static void almacenarModificado (Venta ve) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"update venta set idCliente = ?, idConcesionario = ?, idCoche = ?, fecha = ?, precioVenta = ? where id = ?");
			int registrosInsertados;
			
			ps.setInt(2, ve.getIdCliente());
			ps.setInt(3, ve.getIdConcesionario());
			ps.setInt(4, ve.getIdCoche());
			ps.setDate(5, ve.getFecha());
			ps.setFloat(6, ve.getPrecioVenta());
			ps.setFloat(7, ve.getId());

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
	public static void eliminar (Venta ve) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"delete from venta where id = ?");
			int registrosInsertados;
			
			ps.setInt(1, ve.getId()); 

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
