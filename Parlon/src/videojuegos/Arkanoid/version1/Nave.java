package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Nave extends Actor{
	
	private int velocidadEjeX = 7; // velocidad de la nave del jugador
	private boolean izquierda=false;
	private boolean derecha=false; //variables que me van a decir si se esta moviendo actualmente

	/**
	 * 
	 */
	public Nave() {
		super();
		this.spriteActual=CacheRecursos.getInstance().getImagen("nave-50x15.png");
		//ajusto el ancho de la nave al del sprite y el alto
		this.ancho=this.spriteActual.getWidth();
		this.alto=this.spriteActual.getHeight();
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
		// Cuando estamos al principio del juego la bola debe
		// estar pegada a la nave
		Arkanoid.getInstance().getPelota().NaveControlaInicioPelota(this);
	}
	
	public Rectangle getNaveParaColisiones () {
		return new Rectangle( this.x, this.y, this.ancho, this.alto);
	}
	
	
	//Evento para que el raton mueva la nave
	public void mouseMoved(MouseEvent event) {
		// Cuando el ratón se mueva sobre el canvas, la nave debe situarse a su mismo valor del eje X
		// Si el ratón hace que la nave se pierda por la derecha o la izquierda debo contemplar el hecho de que la nave
		// no se pierda por ese margen
		if (!(event.isShiftDown() && event.isControlDown())) { // Sï¿½lo moveremos la nave con el ratï¿½n en unas determinadas circunstancias ;-)
			if (event.getX() >= (this.ancho / 2) // La nave no se perdera por la izquierda
					&&
				event.getX() <= (Arkanoid.JFRAME_WIDTH - this.ancho / 2)) {
				this.x = event.getX() - this.ancho / 2;
				// Notifico el cambio de posicion de la nave a la pelota. Cuando estamos al principio del juego
				// la bola debe permanecer pegada a la nave
				Arkanoid.getInstance().getPelota().NaveControlaInicioPelota(this);
			}
		}
	}
		
		/**
		 * Cuando pulsen una tecla activamos la bandera booleana concreta que indica que existe un movimiento
		 */
		
	public void keyPressed(KeyEvent e) {
		if (Arkanoid.getInstance().fastidio == false) {  
			switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT : izquierda = true; break;
		  case KeyEvent.VK_RIGHT : derecha = true; break;
		}
	
  	}
		else {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT : izquierda = true; break;
			  case KeyEvent.VK_LEFT : derecha = true; break;
			}
		}
	}

		/**
		 * Cuando una tecla se libera se desactiva la bandera booleana que se había activado al pulsarla
		 */
		
	public void keyReleased(KeyEvent e) {
			if (Arkanoid.getInstance().fastidio == false) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT : izquierda = false; break; 
					case KeyEvent.VK_RIGHT : derecha = false; break;
				}
				}
				else {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_RIGHT: izquierda = false; break; 
					case KeyEvent.VK_LEFT : derecha = false; break;
				}
				}
			}
		
	//colision de la nave con la bola
	//@Override
	//public void colisionConOtroActor(Actor actorcolisionado) {
		//super.colisionConOtroActor(actorcolisionado);
		//if(actorcolisionado instanceof Pelota) {
			//	System.out.println("Nave choca bola");
		//}
			
	//}
		  
		
	
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
