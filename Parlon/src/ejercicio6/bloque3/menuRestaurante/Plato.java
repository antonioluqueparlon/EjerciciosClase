package ejercicio6.bloque3.menuRestaurante;

public class Plato {
	private String nombre;
	private float precio;
	
	
	
	/**
	 * 
	 */
	public Plato() {
		super();
		this.nombre="Plato sin nombre";
		this.precio=10F;
	}

	/**
	 * @param nombre
	 * @param precio
	 */
	public Plato(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Plato: " + nombre + "," + precio;
	}

	
	
	
	
	
	
}
