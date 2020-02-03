package videojuegos.Arkanoid.arkanoidFinal;

import java.util.ArrayList;
import java.util.List;

public class Fase02 extends Fase {
	// Propiedades est�ticas de la fase
	public static final int ESPACIO_SUPERIOR_SOBRE_LADRILLOS = 60;
	static int numLadrillosPosibles = Arkanoid.ANCHO / (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS);
	static int margenIzquierdo = (Arkanoid.ANCHO % (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS)) + 100 / 2;

	@Override
	public void inicializaFase() {
		// Inicializamos los ladrillos

		int[][] matriz = { { 0, 0, 7, 6, 7, 6, 7, 0 }, { 0, 0, 6, 5, 5, 5, 6, 0 }, { 0, 0, 7, 6, 7, 6, 7, 0 } };
		for (int x = 0; x < matriz.length; x++) {
			for (int y = 0; y < matriz[x].length; y++) {
				this.actores.add(new Ladrillo(margenIzquierdo + y * (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS),
						ESPACIO_SUPERIOR_SOBRE_LADRILLOS + x * (Ladrillo.ALTO + Ladrillo.ESPACIO_ENTRE_LADRILLOS),
						matriz[x][y]));

			}
		}

		int[][] matriz1 = { { 0, 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 3, 0, 1, 1, 2, 0 } };
		for (int x = 0; x < matriz1.length; x++) {
			for (int y = 0; y < matriz1[x].length; y++) {
				this.actores.add(new Ladrillo(margenIzquierdo + y * (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS),
						ESPACIO_SUPERIOR_SOBRE_LADRILLOS + x * (Ladrillo.ALTO + Ladrillo.ESPACIO_ENTRE_LADRILLOS),
						matriz1[x][y]));

			}
		}
	}

}
