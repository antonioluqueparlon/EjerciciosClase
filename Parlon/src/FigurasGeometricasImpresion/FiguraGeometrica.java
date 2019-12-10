package FigurasGeometricasImpresion;

public abstract class FiguraGeometrica {
	
	protected int base;
	protected int altura;
	protected static String caracterRelleno = "*";

	/**
	 * @param base
	 * @param altura
	 */
	public FiguraGeometrica(int base, int altura) {
		super();
		this.base = base;
		this.altura = altura;
	}	
	
	
	public abstract void imprimir ();
}
