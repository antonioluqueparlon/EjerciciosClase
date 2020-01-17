package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics;


public class Pelota extends Actor {

	protected int vx;
	protected int vy;

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(10, 10, 15, 15);
	}
	
	/**
	 * 
	 */
	public Pelota() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param x
	 * @param y
	 */
	public Pelota(int x, int y) {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public void act() {
		super.act();
		this.x += this.vx; // En cada iteraci�n del bucle principal, el monstruo cambiar� su posici�n en el eje X, sum�ndole a esta el valor de vx
		// �Qu� ocurre si la imagen del personaje sale de la pantalla en el eje horizontal?
		if (this.x < 0 || this.x > (Arkanoid.getInstance().getWidth() - this.getWidth())) {
			  vx = -vx; // En caso de salir fuera de la ventana, el actor cambiar el signo de su velocidad, tanto cuando choque
			  // con el l�mite derecho como cuando lo haga con el izquierdo
		}
		
		// Movimiento en el eje vertical
		this.y += this.vy; // En cada iteraci�n del bucle principal, el monstruo cambiar� su posici�n en el eje y, sum�ndole a esta el valor de vy
		// �Qu� ocurre si la imagen del personaje sale de la pantalla en el eje vertical?
		if (this.y < 0 || this.y > (Arkanoid.getInstance().getHeight() - this.getHeight())) {
			  vy = -vy; // En caso de salir fuera de la ventana, el actor cambiar el signo de su velocidad, tanto cuando choque
			  // con el l�mite superior como cuando lo haga con el inferior
		}
	}



	/**
	 * @return the vx
	 */
	public int getVx() {
		return vx;
	}



	/**
	 * @param vx the vx to set
	 */
	public void setVx(int vx) {
		this.vx = vx;
	}



	/**
	 * @return the vy
	 */
	public int getVy() {
		return vy;
	}



	/**
	 * @param vy the vy to set
	 */
	public void setVy(int vy) {
		this.vy = vy;
	}
	
	
		
}
