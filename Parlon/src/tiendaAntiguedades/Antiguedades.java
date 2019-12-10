/**
 * 
 */
package tiendaAntiguedades;

/**
 * @author Antonio
 *
 */
public class Antiguedades {
	protected String anioFabricacion;
	protected String origen;
	protected float precio;
	/**
	 * @param anioFabricacion
	 * @param origen
	 * @param precio
	 */
	public Antiguedades(String anioFabricacion, String origen, float precio) {
		super();
		this.anioFabricacion = anioFabricacion;
		this.origen = origen;
		this.precio = precio;
	}
	
	
	@Override
	public String toString() {
		return "Antiguedades [anioFabricacion=" + anioFabricacion + ", origen=" + origen + ", precio=" + precio + "]";
	}

	/**
	 * @return the anioFabricacion
	 */
	public String getAnioFabricacion() {
		return anioFabricacion;
	}
	/**
	 * @param anioFabricacion the anioFabricacion to set
	 */
	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
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
	
	
	

}
