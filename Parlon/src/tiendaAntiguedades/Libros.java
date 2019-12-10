/**
 * 
 */
package tiendaAntiguedades;

/**
 * @author Antonio
 *
 */
public class Libros extends Antiguedades {
	
	private String autor;
	private String titulo;
	/**
	 * @param anioFabricacion
	 * @param origen
	 * @param precio
	 * @param autor
	 * @param titulo
	 */
	public Libros(String anioFabricacion, String origen, float precio, String autor, String titulo) {
		super(anioFabricacion, origen, precio);
		this.autor = autor;
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		return "Libros [autor=" + autor + ", titulo=" + titulo + ", año de fabricación()=" + getAnioFabricacion() + ", Origen()=" + getOrigen() + ", Precio()="
				+ getPrecio() + ", CodigoHash=" + hashCode() + "]";
	}
	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void imprimir() {
		System.out.println(autor + titulo + anioFabricacion + origen + precio);
	}
	
	

}
