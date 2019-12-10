package tiendaAntiguedades;

public class Joyas extends Antiguedades {
	
	private String materialFabricacion;

	/**
	 * @param anioFabricacion
	 * @param origen
	 * @param precio
	 * @param materialFabricacion
	 */
	public Joyas(String anioFabricacion, String origen, float precio, String materialFabricacion) {
		super(anioFabricacion, origen, precio);
		this.materialFabricacion = materialFabricacion;
	}

	
	@Override
	public String toString() {
		return "Joyas [materialFabricacion=" + materialFabricacion + ", toString()=" + super.toString()
				+ ", getAnioFabricacion()=" + getAnioFabricacion() + ", getOrigen()=" + getOrigen() + ", getPrecio()="
				+ getPrecio() + " €, getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


	/**
	 * @return the materialFabricacion
	 */
	public String getMaterialFabricacion() {
		return materialFabricacion;
	}

	/**
	 * @param materialFabricacion the materialFabricacion to set
	 */
	public void setMaterialFabricacion(String materialFabricacion) {
		this.materialFabricacion = materialFabricacion;
	} 
	
	

}
