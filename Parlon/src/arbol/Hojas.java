package arbol;

public class  Hojas extends ElementoArbol {
	
	private String nombre;

	/**
	 * @param nombre
	 */
	public Hojas(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Hojas [nombre=" + nombre + "]";
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
	
	

}
