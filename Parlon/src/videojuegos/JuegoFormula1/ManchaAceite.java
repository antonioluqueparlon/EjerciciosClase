package videojuegos.JuegoFormula1;

import java.awt.Color;
import java.awt.Graphics;

public class ManchaAceite extends Obstaculo {

	/**
	 * @param posicion
	 */
	public ManchaAceite(int posicion) {
		super(posicion);
		
	}
	
	public void paint (Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 50,50);
		g.drawRect(0, 0, 50, 50);
	}

	
	
	

}
