package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ladrillos extends Actor {
	
	public static final int ANCHO = 30;
	public static final int ALTO = 20;
	
	private Color color = null;
	
	
	
	/**
	 * @param color
	 */
	public Ladrillos() {
		super();
		spriteActual=null; // Los ladrillos los pinto yo, por eso no voy a usar sprites que son imagenes
		this.x = 20;
		this.y = 20;
		this.color = Color.BLUE;
	}


	public void paint (Graphics2D g) {
		g.setColor(this.color);
		g.fillRoundRect(this.x, this.y, ANCHO, ALTO, 15, 23);
		
	}
	



	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}


	//GETTERS Y SETTERS


	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}




	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}




	/**
	 * @return the ancho
	 */
	public static int getAncho() {
		return ANCHO;
	}




	/**
	 * @return the alto
	 */
	public static int getAlto() {
		return ALTO;
	}
	

}
