package FigurasGeometricasImpresion;

public class Rectangulo extends FiguraGeometrica {
	
	/**
	 * 
	 * @param base
	 * @param altura
	 */
	public Rectangulo(int base, int altura) {
		super(base, altura);
	}

	/**
	 * 
	 */
	public void imprimir () {
		for (int i = 0; i < this.altura; i++) {
			for (int j = 0; j < this.base; j++) {
				System.out.print(caracterRelleno);
			}
			System.out.println();
		}
	}
	
}
