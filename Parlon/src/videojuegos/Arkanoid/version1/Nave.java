package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;



public class Nave extends Actor{
	
	private int velocidadEjeX = 15; // velocidad de la nave del jugador
	private boolean izquierda=false;
	private boolean derecha=false; //variables que me van a decir si se esta moviendo actualmente
	private int ancho=0;

	/**
	 * 
	 */
	public Nave() {
		super();
		this.spriteActual=CacheImagenes.getInstancia().getImagen("nave-50x15.png");
		//ajusto el ancho de la nave al del sprite
		this.ancho=this.spriteActual.getWidth();
		//pongo la nave en el centro del juego y en la mitad
		this.x = Arkanoid.getInstance().getWidth() / 2;
		this.y = Arkanoid.getInstance().getHeight() - 50;
	}
	
	
	@Override
	public void act() {
		super.act();
		// Controlo que el movimiento a derecha no haga que la nave se pierda por la derecha
				if (this.derecha && (this.x + this.velocidadEjeX + this.ancho <= Arkanoid.getInstance().getWidth())) {
					this.x += this.velocidadEjeX;
				}
				// Control que el movimiento a izquierda no haga que la nave se pierda por la izquierda
				if (this.izquierda && (this.x - this.velocidadEjeX >= 0)) {
					this.x -= this.velocidadEjeX;
				}
			}
	
	
	//Evento para que el raton mueva la nave
	public void mouseMoved(MouseEvent event) {
		// Cuando el ratón se mueva sobre el canvas, la nave debe situarse a su mismo valor del eje X
		// Si el ratón hace que la nave se pierda por la derecha o la izquierda debo contemplar el hecho de que la nave
		// no se pierda por ese margen
		if (event.getX() >= (this.ancho / 2) // La nave no se perderá por la izquierda
						&&
			event.getX() <= (Arkanoid.getInstance().getWidth() - this.ancho / 2)) {
			this.x = event.getX() - this.ancho / 2;
		}
	}
		
		/**
		 * Cuando pulsen una tecla activamos la bandera booleana concreta que indica que existe un movimiento
		 */
		
		public void keyPressed(KeyEvent e) {
		  	switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT : izquierda = true; break;
				case KeyEvent.VK_RIGHT : derecha = true; break;
		  	}
		}

		/**
		 * Cuando una tecla se libera se desactiva la bandera booleana que se había activado al pulsarla
		 */
		
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
	  			case KeyEvent.VK_LEFT : izquierda = false; break; 
	  			case KeyEvent.VK_RIGHT : derecha = false;break;
			}
	
		}
		  
		
	
	//GETTERS Y SETTERS

	/**
	 * @return the velocidadEjeX
	 */
	public int getVelocidadEjeX() {
		return velocidadEjeX;
	}

	/**
	 * @param velocidadEjeX the velocidadEjeX to set
	 */
	public void setVelocidadEjeX(int velocidadEjeX) {
		this.velocidadEjeX = velocidadEjeX;
	}

	

	/**
	 * @return the izquierda
	 */
	public boolean isIzquierda() {
		return izquierda;
	}

	/**
	 * @param izquierda the izquierda to set
	 */
	public void setIzquierda(boolean izquierda) {
		this.izquierda = izquierda;
	}

	/**
	 * @return the derecha
	 */
	public boolean isDerecha() {
		return derecha;
	}

	/**
	 * @param derecha the derecha to set
	 */
	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}
		
}
