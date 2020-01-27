package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Nave extends Actor implements KeyListener{
	
	protected int velocidadEjeX;
	protected int velocidadEjeY;
	private boolean arriba,abajo,izquierda,derecha; //variables que me van a decir si se esta moviendo actualmente
	protected static final int VelocidadJugador=4; // velocidad de la nave del jugador
	
	public BufferedImage loadImage(String nombre) {
		URL url=null;
		try {
			url = getClass().getResource(nombre);
			return ImageIO.read(url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}

	/**
	 * 
	 */
	public Nave() {
		super();
	}

	public void act() {
		super.act();
		//Movimiento en el eje horizontal 
		this.x += this.velocidadEjeX; // la posicion de la nave va a ser una suma de la velocidadEjeX que le hemos asignado nosotros
		
		//evitar que se salga por la izquierda no se lo permitimos
		if(this.x < 0 ) {
			this.x=0;
		}
		//evitar que se salga por la derecha no se lo permitimos
		if(this.x > (Arkanoid.getInstance().getWidth()) ) {
			this.x=(Arkanoid.getInstance().getWidth()-1);
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
		  	updateSpeed();
		}

		/**
		 * Cuando una tecla se libera se desactiva la bandera booleana que se había activado al pulsarla
		 */
		
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
	  			case KeyEvent.VK_LEFT : izquierda = false; break; 
	  			case KeyEvent.VK_RIGHT : derecha = false;break;
			}
			updateSpeed();
		}
		  
		/**
		 * Este método no se utiliza pero es necesario implementarlo por el KeyListener
		 */
		
		public void keyTyped(KeyEvent e) {}
		
		/**
		 * En función de las banderas booleanas de movimiento, actualizamos las velocidades en los dos ejes
		 */
		protected void updateSpeed() {
			velocidadEjeX=0;velocidadEjeY=0;
			if (izquierda) velocidadEjeX = -VelocidadJugador;
			if (derecha) velocidadEjeX = VelocidadJugador;
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
	 * @return the velocidadEjeY
	 */
	public int getVelocidadEjeY() {
		return velocidadEjeY;
	}

	/**
	 * @param velocidadEjeY the velocidadEjeY to set
	 */
	public void setVelocidadEjeY(int velocidadEjeY) {
		this.velocidadEjeY = velocidadEjeY;
	}

	/**
	 * @return the arriba
	 */
	public boolean isArriba() {
		return arriba;
	}

	/**
	 * @param arriba the arriba to set
	 */
	public void setArriba(boolean arriba) {
		this.arriba = arriba;
	}

	/**
	 * @return the abajo
	 */
	public boolean isAbajo() {
		return abajo;
	}

	/**
	 * @param abajo the abajo to set
	 */
	public void setAbajo(boolean abajo) {
		this.abajo = abajo;
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

	/**
	 * @return the velocidadjugador
	 */
	public static int getVelocidadjugador() {
		return VelocidadJugador;
	}
	
		
}
