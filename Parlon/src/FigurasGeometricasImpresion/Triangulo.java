package FigurasGeometricasImpresion;

public class Triangulo extends FiguraGeometrica {
	
	/**
	 * 
	 * @param base
	 * @param altura
	 */
	public Triangulo(int base, int altura) {
		super(base, altura);
	}

	/**
	 * 
	 */
	public void imprimir () {
		int contadorAsteriscosPorFila = 1;
		for (int i = 0; i < this.altura; i++) {
			for (int j = 0; j < contadorAsteriscosPorFila; j++) {
				System.out.print(caracterRelleno);
			}
			contadorAsteriscosPorFila++;
			System.out.println();
		}
	}
	
}