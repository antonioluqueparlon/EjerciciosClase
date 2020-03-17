package BaseDeDatos.BaseDeDatosRafa.modelo;

public class Concesionario {

	int id;
	String cif;
	String nombre;
	String localidad;

	public Concesionario() {
	}
  

	/**
	 * @param id
	 * @param cif
	 * @param nombre
	 * @param localidad
	 */
	public Concesionario(int id, String cif, String nombre, String localidad) {
		super();
		this.id = id;
		this.cif = cif;
		this.nombre = nombre;
		this.localidad = localidad;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
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

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Concesionario [id=" + id + ", cif=" + cif + ", nombre=" + nombre + ", localidad=" + localidad + "]";
	}	
	
}
