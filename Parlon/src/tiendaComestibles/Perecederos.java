package tiendaComestibles;

public class Perecederos extends Chuche {
	
	private String fechaCaducidad;
	/**
	 * 
	 */
	public Perecederos() {
		
	}

	/**
	 * 
	 * @param nombre
	 * @param precio
	 * @param codigo
	 * @param fechaCaducidad
	 */
	public Perecederos( String nombre, float precio, String codigo , String fechaCaducidad) {
		super(nombre,precio,codigo);
		this.fechaCaducidad = fechaCaducidad;
	}

	@Override
	public String toString() {
		return "Perecederos [fechaCaducidad=" + fechaCaducidad + ", getNombre()=" + getNombre() + ", getPrecio()="
				+ getPrecio() + ", getCodigo()=" + getCodigo() + "]";
	}

	/**
	 * @return the fechaCaducidad
	 */
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	/**
	 * @param fechaCaducidad the fechaCaducidad to set
	 */
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
}
