package ejercicio6.bloque3.menuRestaurante;

public class Menu {
	private Plato primerPlato;
	private Plato segundoPlato;
	private Plato tercerPlato;
	/**
	 * @param primerPlato
	 * @param segundoPlato
	 * @param tercerPlato
	 */
	public Menu(Plato primerPlato, Plato segundoPlato, Plato tercerPlato) {
		super();
		this.primerPlato = primerPlato;
		this.segundoPlato = segundoPlato;
		this.tercerPlato = tercerPlato;
	}
	
	
	
	public float getPrecio() {
		return this.primerPlato.getPrecio() + this.segundoPlato.getPrecio()+ this.tercerPlato.getPrecio();
	}
	
	
	
	
	
	/**
	 * @return the primerPlato
	 */
	public Plato getPrimerPlato() {
		return primerPlato;
	}
	/**
	 * @param primerPlato the primerPlato to set
	 */
	public void setPrimerPlato(Plato primerPlato) {
		this.primerPlato = primerPlato;
	}
	/**
	 * @return the segundoPlato
	 */
	public Plato getSegundoPlato() {
		return segundoPlato;
	}
	/**
	 * @param segundoPlato the segundoPlato to set
	 */
	public void setSegundoPlato(Plato segundoPlato) {
		this.segundoPlato = segundoPlato;
	}
	/**
	 * @return the tercerPlato
	 */
	public Plato getTercerPlato() {
		return tercerPlato;
	}
	/**
	 * @param tercerPlato the tercerPlato to set
	 */
	public void setTercerPlato(Plato tercerPlato) {
		this.tercerPlato = tercerPlato;
	}
	@Override
	public String toString() {
		return "Menu [primerPlato=" + primerPlato + ", segundoPlato=" + segundoPlato
				+ ", tercerPlato=" + tercerPlato+ "]";
	}
	
	
}
