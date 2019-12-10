package tiendaComestibles;

public class NoPerecederos extends Chuche {
	/**
	 * 
	 */
	public NoPerecederos() {

	}

	/**
	 * @param nombre
	 * @param precio
	 * @param codigo
	 */
	public NoPerecederos(String nombre, float precio, String codigo) {
		super(nombre, precio, codigo);
	}

	@Override
	public String toString() {
		return "NoPerecederos [getNombre()=" + getNombre() + ", getPrecio()=" + getPrecio() + ", getCodigo()="
				+ getCodigo() + "]";
	}
	
	

}
