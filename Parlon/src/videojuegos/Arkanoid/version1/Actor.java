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
	
	protected boolean markedForRemoval = false;
	protected List<BufferedImage> sprites = new ArrayList<BufferedImage>();
	protected int width, height;
	
	/**
	 * 
	 */
	public Actor() {
		// En principio coloco una imagen genérica al actor
		spriteActual = CacheRecursos.getInstance().getImagen("sin-imagen.png");
		//spriteActual= CacheImagenes.getInstancia().getImagen("nave-50x15.png");
	}
	
	public Actor (String spriteName) {
		this.velocidadDeCambioDeSprite = 1;
		cargarImagenesDesdeSpriteNames(new String[] {spriteName});
	}
	
	/**
	 * Constructor amplíamente utilizado, indicando los nombres de los sprites a utilizar para mostrar este actor
	 * @param spriteName
	 */
	public Actor (String spriteNames[]) {
		this.velocidadDeCambioDeSprite = 1;
		cargarImagenesDesdeSpriteNames(spriteNames);
	}
	
	/**
	 * 
	 * @param spriteNames
	 * @param velocidadDeCambioDeSprite
	 */
	public Actor (String spriteNames[], int velocidadDeCambioDeSprite) {
		this.velocidadDeCambioDeSprite = velocidadDeCambioDeSprite;
		cargarImagenesDesdeSpriteNames(spriteNames);
	}
	
	private void cargarImagenesDesdeSpriteNames (String spriteNames[]) {
		// Obtengo las imágenes de este actor, a partir del patrón de diseño Singleton con el que se encuentra
		// el spritesRepository
		for (String sprite : spriteNames) {
			this.sprites.add(SpritesRepository.getInstance().getSprite(sprite));
		}
		// ajusto el primer sprite del actor
		if (this.sprites.size() > 0) {
			this.spriteActual = this.sprites.get(0);
		}
		adjustHeightAndWidth ();
	}
	
	
	/**
	 * Actualiza los valores de width y height del Actor, a partir una BufferedImage que lo representará
	 * en pantalla
	 */
	private void adjustHeightAndWidth () {
		// Una vez que tengo las imágenes que representa a este actor, obtengo el ancho y el alto máximos de las mismas y se
		// los traspaso a objeto actual.
		if (this.sprites.size() > 0) {
			this.height = this.sprites.get(0).getHeight();
			this.width = this.sprites.get(0).getWidth();
		}
		for (BufferedImage sprite : this.sprites) {
			// Ajusto el máximo width como el width del actor
			if (sprite.getWidth() > this.width) {
				this.width = sprite.getWidth();
			}
			// Lo mismo que el anterior, pero con el máximo height
			if (sprite.getHeight() > this.height) {
				this.height = sprite.getHeight();
			}
		}
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
		
		//parte2
		if (this.sprites != null && this.sprites.size() > 1) {
			// cada vez que llaman a "act()" se incrementará esta unidad, siempre que existan sprites
			unidadDeTiempo++;
			// Si la unidad de tiemplo coincide o es múltiplo de la velocidad de cambio de sprite, entramos al if
			if (unidadDeTiempo % velocidadDeCambioDeSprite == 0){
				// Reiniciamos la unidad de tiempo
				unidadDeTiempo = 0;
				// Obtengo el índice del spriteActual, dentro de la lista de índices
				int indiceSpriteActual = sprites.indexOf(this.spriteActual);
				// Obtengo el siguiente índice de sprite, teniendo en cuenta que los sprites cambian de uno a otro en ciclo
				int indiceSiguienteSprite = (indiceSpriteActual + 1) % sprites.size();
				// Se selecciona el nuevo spriteActual
				this.spriteActual = sprites.get(indiceSiguienteSprite);
			}
		}
	}
	
	public void eliminar() {
		this.EstaMarcadoParaEliminar=true;
	}
	
	public void colisionConOtroActor(Actor actorColisionado) {
		
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
	
	public boolean isMarkedForRemoval() { return markedForRemoval; }
	public void setMarkedForRemoval(boolean markedForRemoval) { this.markedForRemoval = markedForRemoval; }
}
	

