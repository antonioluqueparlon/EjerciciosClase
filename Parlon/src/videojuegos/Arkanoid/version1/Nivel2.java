package videojuegos.Arkanoid.version1;

import java.awt.Color;


public class Nivel2 extends Fase {
	// Propiedades est�ticas de la fase
	public static final int EspacioSuperiorEntreLadrillos = 20;

	
	/**
	 * Inicializaci�n de la fase, es la implementaci�n de un m�todo abstracto en el supertipo
	 */
	@Override
	public void inicializaFase() {

	    // Inicializamos los ladrillos
	    int numLadrillosPosibles = Arkanoid.JFRAME_WIDTH / (Ladrillos.ANCHO + Ladrillos.EspacioEntreLadrillos);
	    int margenIzquierdo = (Arkanoid.JFRAME_WIDTH % (Ladrillos.ANCHO + Ladrillos.EspacioEntreLadrillos)) / 2;
	    
	  //Array de colores de los ladrillos
		Color ArrayColores[]= new Color[] {Color.BLACK, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GREEN,
			Color.RED, Color.PINK} ;
	    
	    // Creamos las filas
	    for (int i = 0; i < ArrayColores.length; i++) {
	    	for (int j = 0; j < 3; j++) {
		    	this.actores.add(new Ladrillos(margenIzquierdo + j * (Ladrillos.ANCHO + Ladrillos.EspacioEntreLadrillos), 
		    			EspacioSuperiorEntreLadrillos + i * (Ladrillos.ALTO + Ladrillos.EspacioEntreLadrillos), i));
		    }
	    }
	}

}
