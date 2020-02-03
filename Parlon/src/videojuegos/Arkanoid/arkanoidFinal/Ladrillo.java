package videojuegos.Arkanoid.arkanoidFinal;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a cada ladrillo de los que pondremos sobre la pantalla
 * 
 * @author R
 *
 */
public class Ladrillo extends Actor {
	// Damos un ancho y un alto espec�fico al ladrillo. Suponemos que todos los
	// ladrillos ser�n iguales
	public static final int ANCHO = 30;
	public static final int ALTO = 20;
	public static final int ESPACIO_ENTRE_LADRILLOS = 2;
	int newImg=0;
	boolean listo = false; 
	boolean loco = false;



	/**
	 * Constructor
	 */
	public Ladrillo() {
		super();
		spriteActual = null; // El ladrillo se pinta vectorialmente, as� que no utilizo ning�n sprite
		this.x = 10;
		this.y = 10;
		this.ancho = ANCHO;
		this.alto = ALTO;
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param x
	 * @param y
	 * @param color
	 */
	public Ladrillo(int x, int y, int imagen) {
		this.x = x;
		this.y = y;
		this.ancho = ANCHO;
		this.alto = ALTO;
		// Carga de los sprites de la explosi�n
		List<BufferedImage> nuevosSprites = new ArrayList<BufferedImage>();
		nuevosSprites.add(CacheRecursos.getInstancia().getImagen("ladrillorosa.png"));
		nuevosSprites.add(CacheRecursos.getInstancia().getImagen("ladrilloazul.png"));
		nuevosSprites.add(CacheRecursos.getInstancia().getImagen("ladrilloverde.png"));
		nuevosSprites.add(CacheRecursos.getInstancia().getImagen("ladrilloazul.png"));
		nuevosSprites.add(CacheRecursos.getInstancia().getImagen("ladrillorosa.png"));
		nuevosSprites.add(CacheRecursos.getInstancia().getImagen("ladrilloverde.png"));
		nuevosSprites.add(CacheRecursos.getInstancia().getImagen("ladrillorosa.png"));
		nuevosSprites.add(CacheRecursos.getInstancia().getImagen("ladrilloazul.png"));
		
		
		// Sprite actual
		this.spriteActual = nuevosSprites.get(imagen);

			newImg = imagen;
	

	}

	/**
	 * Colisi�n detectada
	 */
	@Override
	public void colisionProducidaConOtroActor(Actor actorColisionado) {
		super.colisionProducidaConOtroActor(actorColisionado);
		// Si un ladrillo detecta una colisi�n con un objeto de tipo "Bola", debe
		// desaparecer

		if (newImg != 6) {
			if (actorColisionado instanceof Bola ) {
				if (newImg != 7 || listo == true) {
				eliminar();
				// Creo un nuevo actor de tipo Explosion y lo centr� respecto a la posici�n del
				// ladrillo
				Arkanoid.getInstancia().puntuacion = Arkanoid.getInstancia().puntuacion+ 100;
				Explosion explosion = new Explosion(this.getX(), this.getY());
				explosion.setX(this.x + Ladrillo.ANCHO / 2 - explosion.getAncho() / 2);
				Arkanoid.getInstancia().agregarActor(explosion);
				
				
				int probabilidadPildora= (int) Math.round(Math.random()*10);
				if (probabilidadPildora >0) {
					int tipopildora = (int) Math.round(Math.random()*2);
					System.out.println(tipopildora);
					Pocion pocion = new Pocion (this.getX(), this.getY(), tipopildora);
					Arkanoid.getInstancia().agregarActor(pocion);
				}
				
				// Reproduzco el sonido de la explisi�n
				CacheRecursos.getInstancia().playSonido("Arkanoid-SFX-01.wav");
				}
				else {
					listo = true;
					Arkanoid.getInstancia().puntuacion = Arkanoid.getInstancia().puntuacion + 50;
				}
			}	
		}
		
	}

	
}
