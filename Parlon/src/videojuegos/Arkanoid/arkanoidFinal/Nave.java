package videojuegos.Arkanoid.arkanoidFinal;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Clase que representa a la nave de nuestro juego
 * @author R
 *
 */
public class Nave extends Actor {
	// propiedades de la nave
	private boolean moviendoAIzquierda = false;
	private boolean moviendoADerecha = false;
	private int velocidadEjeX = 4;
	
	
	/**
	 * Constructor
	 */
	public Nave() {
		super();
		// Carga del sprite de la nave
		this.spriteActual = CacheRecursos.getInstancia().getImagen("nave-50x15.png");
		// Ajusto el ancho virtual de este objeto al mismo ancho que tiene la imagen del sprite
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
		// Colocaci�n de la nave en el centro horizontalmente y en la parte baja de la pantalla
		this.x = Arkanoid.ANCHO / 2;
		this.y = Arkanoid.ALTO - 50;
	}
	

	/**
	 * Metodo que llama a cada actor, en cada refresco de pantalla del juego
	 */
	@Override
	public void act() {
		// Controlo que el movimiento a derecha no haga que la nave se pierda por la derecha
		if (this.moviendoADerecha && (this.x + this.velocidadEjeX + this.ancho <= Arkanoid.ANCHO)) {
			this.x += this.velocidadEjeX;
		}
		// Control que el movimiento a izquierda no haga que la nave se pierda por la izquierda
		if (this.moviendoAIzquierda && (this.x - this.velocidadEjeX >= 0)) {
			this.x -= this.velocidadEjeX;
		}
		// Notifico el cambio de posici�n de la nave a la pelota. Cuando estamos al principio del juego
		// la bola debe permanecer pegada a la nave
		Arkanoid.getInstancia().getBola().naveCambiaPosicion(this);
	}
	
	
	public Rectangle getRectanguloParaColisiones () {
		return new Rectangle( this.x, this.y, this.ancho, this.alto);
	}
	
	/**
	 * M�todo llamado desde el controlador del rat�n, para delegar el evento hasta este objeto
	 * @param event
	 */
	public void mouseMoved(MouseEvent event) {
		// Cuando el rat�n se mueva sobre el canvas, la nave debe situarse a su mismo valor del eje X
		// Si el rat�n hace que la nave se pierda por la derecha o la izquierda debo contemplar el hecho de que la nave
		// no se pierda por ese margen
		if (!(event.isShiftDown() && event.isControlDown())) { // S�lo moveremos la nave con el rat�n en unas determinadas circunstancias ;-)
			if (event.getX() >= (this.ancho / 2) // La nave no se perder� por la izquierda
					&&
				event.getX() <= (Arkanoid.ANCHO - this.ancho / 2)) {
				this.x = event.getX() - this.ancho / 2;
				// Notifico el cambio de posici�n de la nave a la pelota. Cuando estamos al principio del juego
				// la bola debe permanecer pegada a la nave
				Arkanoid.getInstancia().getBola().naveCambiaPosicion(this);
			}
		}
	}

	/**
	 * M�todos llamados desde el controlador del teclado, para delegar el evento del teclado
	 * @param event
	 */
	public void keyPressed(KeyEvent e) {
		
			if (Arkanoid.getInstancia().fastidio == false) {  
				switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT : moviendoAIzquierda = true; break;
			  case KeyEvent.VK_RIGHT : moviendoADerecha = true; break;
			}
		
	  	}
			else {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT : moviendoAIzquierda = true; break;
				  case KeyEvent.VK_LEFT : moviendoADerecha = true; break;
			}
	}
	}
	
	public void keyReleased(KeyEvent e) {
		if (Arkanoid.getInstancia().fastidio == false) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT : moviendoAIzquierda = false; break; 
			case KeyEvent.VK_RIGHT : moviendoADerecha = false; break;
		}
		}
		else {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT: moviendoAIzquierda = false; break; 
			case KeyEvent.VK_LEFT : moviendoADerecha = false; break;
		}
		}
	}
	    
}
