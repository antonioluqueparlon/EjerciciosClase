package BaseDeDatos.BaseDeDatosRafa.modelo;

import java.sql.Date;

public class Cliente {

	int id;
	String nombre;
	String apellidos;
	String localidad;
	String dniNie;
	Date fechaNac;
	int activo;

	public Cliente() {
	}
	
	/**
	 * @param id
	 * @param cif
	 * @param nombre
	 * @param apellidos
	 * @param localidad
	 * @param dniNie
	 * @param fechaNac
	 * @param activo
	 */
	public Cliente(int id, String nombre, String apellidos, String localidad, String dniNie,
			Date fechaNac, int activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.localidad = localidad;
		this.dniNie = dniNie;
		this.fechaNac = fechaNac;
		this.activo = activo;
	}	
  

	/**
	 * @param id
	 * @param cif
	 * @param nombre
	 * @param localidad
	 */

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the dniNie
	 */
	public String getDniNie() {
		return dniNie;
	}

	/**
	 * @param dniNie the dniNie to set
	 */
	public void setDniNie(String dniNie) {
		this.dniNie = dniNie;
	}

	/**
	 * @return the fechaNac
	 */
	public Date getFechaNac() {
		return fechaNac;
	}

	/**
	 * @param date the fechaNac to set
	 */
	public void setFechaNac(java.util.Date date) {
		this.fechaNac = (Date) date;
	}

	/**
	 * @return the activo
	 */
	public int getActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(int activo) {
		this.activo = activo;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", localidad="
				+ localidad + ", dniNie=" + dniNie + ", fechaNac=" + fechaNac + ", activo=" + activo + "]";
	}


	
	
}
