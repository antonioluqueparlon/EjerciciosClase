package videojuegos.Arkanoid.version1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Actor {
	// Propiedades que contienen las coordenadas del actor y la imagen que corresponda con el mismo
	
	protected int x, y;// Coordenadas en las que se encuentra el actor
	protected int ancho, alto; // Ancho y alto que ocupa, imprescindible para detectar colisiones
	protected BufferedImage spriteActual;
	
	protected boolean EstaMarcadoParaEliminar = false; // se pondra a true cuando tenga que eliminar algun
														// actor, en este caso los ladrillos
	protected int velocidadDeCambioDeSprite=0;
	private int unidadDeTiempo = 0; // La unidad de tiempo aumenta cada vez que se llama al método "act()" del Actor
	protected List<BufferedImage> spritesDeAnimacionExplosion = new ArrayList<BufferedImage>();
	
	/**
	 * 
	 */
	public Actor() {
		// En principio coloco una imagen genérica al actor
		spriteActual = CacheRecursos.getInstance().getImagen("sin-imagen.png");
		//spriteActual= CacheImagenes.getInstancia().getImagen("nave-50x15.png");
	}
	
	
	/**
	 * Método para pintar el actor en la pantalla
	 * @param g
	 */
	public void paint(Graphics2D g){
		// Cuidado, el sprite del actor puede ser nulo, de manera que el actor se pinte por gráficos vectoriales
		if (this.spriteActual != null) {
			g.drawImage(this.spriteActual, this.x, this.y, null);
		}
	}
	
	
	/**
	 * Método que se llamará para cada actor, en cada refresco de pantalla del juego
	 */
	public void act() {
	// En el caso de que exista un array de sprites el actor actual se tratará de una animación, para eso llevaremos a cabo los siguientes pasos
		if(this.spritesDeAnimacionExplosion != null && this.spritesDeAnimacionExplosion.size()>0) {
		unidadDeTiempo++;
			if (unidadDeTiempo % velocidadDeCambioDeSprite == 0){
			unidadDeTiempo = 0;
			int indiceSpriteActual = spritesDeAnimacionExplosion.indexOf(this.spriteActual);
			int indiceSiguienteSprite = (indiceSpriteActual + 1) % spritesDeAnimacionExplosion.size();
			this.spriteActual = spritesDeAnimacionExplosion.get(indiceSiguienteSprite);
			}
		
		}
	}
	
	public void eliminar() {
		this.EstaMarcadoParaEliminar=true;
	}
	
	public void colisionConOtroActor(Actor actorcolisionado) {
		
	}


	


	//GETTERS Y SETTERS
	
	
	public int getX() {	return x; }
	public int getAncho() {
		return ancho;
	}


	public void setAncho(int ancho) {
		this.ancho = ancho;
	}


	public int getAlto() {
		return alto;
	}


	public void setAlto(int alto) {
		this.alto = alto;
	}


	public void setX(int x) { this.x = x; }
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
	public BufferedImage getSpriteActual() { return spriteActual; }
	public void setSpriteActual(BufferedImage spriteActual) { this.spriteActual = spriteActual; }


	/**
	 * @return the spritesDeAnimacionExplosion
	 */
	public List<BufferedImage> getSpritesDeAnimacionExplosion() {
		return spritesDeAnimacionExplosion;
	}


	/**
	 * @param spritesDeAnimacionExplosion the spritesDeAnimacionExplosion to set
	 */
	public void setSpritesDeAnimacionExplosion(List<BufferedImage> spritesDeAnimacionExplosion) {
		this.spritesDeAnimacionExplosion = spritesDeAnimacionExplosion;
		// Al darnos unos nuevos sprites de animación debo calcular el nuevo ancho y alto del actor, ajustándolo
		// al máximo de los nuevos sprites
		if (this.spritesDeAnimacionExplosion != null) {
			for (BufferedImage imagen : this.spritesDeAnimacionExplosion) {
				if (imagen.getWidth() > this.ancho) this.ancho = imagen.getWidth();
				if (imagen.getHeight() > this.alto) this.alto = imagen.getHeight();
			}
		}
	}
	
}
	

