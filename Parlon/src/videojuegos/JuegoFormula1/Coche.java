package videojuegos.JuegoFormula1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Coche extends Vehiculo {




	/**
	 * @param nombre
	 * @param posicion
	 * @param color
	 */
	public Coche(String nombre, int posicion, String color) {
		super(nombre, posicion, color);
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.RED);
		g.fillOval(0, 0, ancho, alto);
		g.drawOval(0, 0, ancho, alto);
		g.fillRect(50,0,30,30);
		g.drawRect(50, 50, 30, 30);
		
	}

}
