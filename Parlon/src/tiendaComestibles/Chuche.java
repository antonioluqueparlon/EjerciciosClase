/**
 * 
 */
package tiendaComestibles;

/**
 * @author Antonio
 *
 */
public class Chuche {
	private String nombre;
	private float precio;
	private String codigo;
	
	public Chuche() {
		super();
		this.nombre="Chuche0";
		this.precio=(float) 0.01;
		this.codigo="0000";
	}
	/**
	 * @param nombre
	 * @param precio
	 * @param codigo
	 */
	public Chuche(String nombre, float precio, String codigo) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.codigo = codigo;
	}
	public Chuche(Chuche chupaChups) {
		// TODO Auto-generated constructor stub
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
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return "Chuche [nombre=" + nombre + ", precio=" + precio + ", codigo=" + codigo + "]";
	}
	
			
		
}
	
