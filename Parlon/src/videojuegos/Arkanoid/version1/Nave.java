package videojuegos.Arkanoid.version1;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class Nave extends Actor {
	// propiedades de la nave
	private boolean moviendoAIzquierda = false;
	private boolean moviendoADerecha = false;
	private int velocidadEjeX = 5;
	
	
	/**
	 * Constructor
	 */
	public Nave() {
		super();
		// Carga del sprite de la nave
		this.spriteActual = CacheRecursos.getInstance().getImagen("nave-50x15.png");
		// Ajusto el ancho virtual de este objeto al mismo ancho que tiene la imagen del sprite
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
		// Poniendo la nave en el centro horizontalmente y en la parte baja de la pantalla
		this.x = Arkanoid.JFRAME_WIDTH / 2;
		this.y = Arkanoid.JFRAME_HEIGHT - 100;
	}
	

	
	@Override
	public void act() {
		// Controlo que el movimiento a derecha no haga que la nave se pierda por la derecha
		if (this.moviendoADerecha && (this.x + this.velocidadEjeX + this.ancho <= Arkanoid.JFRAME_WIDTH-10)) {
			this.x += this.velocidadEjeX;
		}
		// Control que el movimiento a izquierda no haga que la nave se pierda por la izquierda
		if (this.moviendoAIzquierda && (this.x - this.velocidadEjeX >= 0)) {
			this.x -= this.velocidadEjeX;
		}
		// Cuando estamos al principio del juego
		// la bola debe permanecer pegada a la nave
		Arkanoid.getInstance().getPelota().naveControlaInicioPelota(this);
	}
	
	
	public Rectangle getRectanguloParaColisiones () {
		return new Rectangle( this.x, this.y, this.ancho, this.alto);
	}
	
	/**
	 * Metodo llamado desde el driver raton, para llevar el evento hasta este objeto
	 * @param event
	 */
	public void mouseMoved(MouseEvent event) {
		// Cuando el raton se mueva sobre el canvas, la nave debe situarse a su mismo valor del eje X
		// Si el raton hace que la nave se pierda por la derecha o la izquierda debo contemplar el hecho de que la nave
		// no se pierda por ese margen
		if (!(event.isShiftDown() && event.isControlDown())) { // la nave la movemos con el raton en unas determinadas circunstancias
			if (event.getX() >= (this.ancho / 2) // La nave no se pierde por la izquierda
					&&
				event.getX() <= (Arkanoid.JFRAME_WIDTH - this.ancho / 2)-10) {
				this.x = event.getX() - this.ancho / 2;
				// Notifico el cambio de la nave a la pelota. Cuando estamos al principio del juego
				// la bola debe permanecer pegada a la nave
				Arkanoid.getInstance().getPelota().naveControlaInicioPelota(this);
			}
		}
	}

	/**
	 * Metodos llamados desde el controlador del teclado, para delegar el evento del teclado
	 * @param event
	 */
	public void keyPressed(KeyEvent e) {
		
			if (Arkanoid.getInstance().fastidio == false) {  
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
		if (Arkanoid.getInstance().fastidio == false) {
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
