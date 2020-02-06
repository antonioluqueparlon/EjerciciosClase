package videojuegos.Arkanoid.version1;

import java.awt.Color;




public class Nivel1 extends Fase {
	// Propiedades estáticas de la fase
	public static final int EspacioSuperiorEntreLadrillos = 100;
	
	/**
	 * Inicialización de la fase, es la implementación de un método abstracto en el supertipo
	 */
	@Override
	public void inicializaFase() {

	    // Inicializamos los ladrillos
	    int numLadrillosPosibles = Arkanoid.JFRAME_WIDTH / (Ladrillos.ANCHO + Ladrillos.EspacioEntreLadrillos);
	    int margenIzquierdo = (Arkanoid.JFRAME_WIDTH % (Ladrillos.ANCHO + Ladrillos.EspacioEntreLadrillos) / 2)+235;
	    
	  //Array de colores de los ladrillos
		Color ArrayColores[]= new Color[] {Color.YELLOW, Color.BLUE,Color.LIGHT_GRAY, Color.ORANGE, Color.GREEN,
			Color.RED, Color.PINK} ;
	    
	    // Creamos las filas
	    for (int i = 0; i < 1; i++) {
	    	for (int j = 0; j < 1; j++) {
		    	this.actores.add(new Ladrillos(margenIzquierdo + j * (Ladrillos.ANCHO + Ladrillos.EspacioEntreLadrillos), 
		    			EspacioSuperiorEntreLadrillos + i * (Ladrillos.ALTO + Ladrillos.EspacioEntreLadrillos), ArrayColores[i]));
		    }
	    }
	}

}
