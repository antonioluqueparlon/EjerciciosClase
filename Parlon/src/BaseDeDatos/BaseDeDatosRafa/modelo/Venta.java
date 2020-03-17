package BaseDeDatos.BaseDeDatosRafa.modelo;

import java.sql.Date;

public class Venta {

	int id;
	int idCliente;
	int idConcesionario;
	int idCoche;
	Date fecha;
	float precioVenta;
	
	

	public Venta() {
	}



	/**
	 * @param id
	 * @param idCliente
	 * @param idConcesionario
	 * @param idCoche
	 * @param fecha
	 * @param precioVenta
	 */
	public Venta(int id, int idCliente, int idConcesionario, int idCoche, Date fecha, int precioVenta) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idConcesionario = idConcesionario;
		this.idCoche = idCoche;
		this.fecha = fecha;
		this.precioVenta = precioVenta;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}



	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}



	/**
	 * @return the idConcesionario
	 */
	public int getIdConcesionario() {
		return idConcesionario;
	}



	/**
	 * @param idConcesionario the idConcesionario to set
	 */
	public void setIdConcesionario(int idConcesionario) {
		this.idConcesionario = idConcesionario;
	}



	/**
	 * @return the idCoche
	 */
	public int getIdCoche() {
		return idCoche;
	}



	/**
	 * @param idCoche the idCoche to set
	 */
	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}



	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}



	/**
	 * @param str the fecha to set
	 */
	public void setFecha(Date str) {
		this.fecha = str;
	}



	/**
	 * @return the precioVenta
	 */
	public float getPrecioVenta() {
		return precioVenta;
	}



	/**
	 * @param f the precioVenta to set
	 */
	public void setPrecioVenta(float f) {
		this.precioVenta = f;
	}



	@Override
	public String toString() {
		return "Venta [id=" + id + ", idCliente=" + idCliente + ", idConcesionario=" + idConcesionario + ", idCoche="
				+ idCoche + ", fecha=" + fecha + ", precioVenta=" + precioVenta + "]";
	}
	
	
	



	
	
}
