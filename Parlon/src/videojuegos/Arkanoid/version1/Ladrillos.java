package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a cada ladrillo de los que pondremos sobre la pantalla
 * 
 */
public class Ladrillos extends Actor {
	// Damos un ancho y un alto espec�fico al ladrillo. Suponemos que todos los
	// ladrillos ser�n iguales
	public static final int ANCHO = 30;
	public static final int ALTO = 20;
	public static final int EspacioEntreLadrillos = 2;
	int newImg=0;
	boolean listo = false; 
	boolean loco = false;



	/**
	 * Constructor
	 */
	public Ladrillos() {
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
	public Ladrillos(int x, int y, int imagen) {
		this.x = x;
		this.y = y;
		this.ancho = ANCHO;
		this.alto = ALTO;
		// Carga de los sprites de la explosi�n
		List<BufferedImage> nuevosSprites = new ArrayList<BufferedImage>();
		nuevosSprites.add(CacheRecursos.getInstance().getImagen("ladrillorosa.png"));
		nuevosSprites.add(CacheRecursos.getInstance().getImagen("ladrilloazul.png"));
		nuevosSprites.add(CacheRecursos.getInstance().getImagen("ladrilloverde.png"));
		nuevosSprites.add(CacheRecursos.getInstance().getImagen("ladrilloazul.png"));
		nuevosSprites.add(CacheRecursos.getInstance().getImagen("ladrillorosa.png"));
		nuevosSprites.add(CacheRecursos.getInstance().getImagen("ladrilloverde.png"));
		nuevosSprites.add(CacheRecursos.getInstance().getImagen("ladrillorosa.png"));
		nuevosSprites.add(CacheRecursos.getInstance().getImagen("ladrilloazul.png"));
		
		
		// Sprite actual
		this.spriteActual = nuevosSprites.get(imagen);

			newImg = imagen;
	

	}

	/**
	 * Colisi�n detectada
	 */
	@Override
	public void colisionConOtroActor(Actor actorColisionado) {
		super.colisionConOtroActor(actorColisionado);
		// Si un ladrillo detecta una colisi�n con un objeto de tipo "Bola", debe
		// desaparecer

		if (newImg != 6) {
			if (actorColisionado instanceof Pelota ) {
				if (newImg != 7 || listo == true) {
				eliminar();
				// Creo un nuevo actor de tipo Explosion y lo centr� respecto a la posici�n del
				// ladrillo
				Arkanoid.getInstance().puntos = Arkanoid.getInstance().puntos+ 100;
				Explosion explosion = new Explosion(this.getX(), this.getY());
				explosion.setX(this.x + Ladrillos.ANCHO / 2 - explosion.getAncho() / 2);
				Arkanoid.getInstance().agregarActor(explosion);
				
				
				int probabilidadPildora= (int) Math.round(Math.random()*10);
				if (probabilidadPildora >0) {
					int tipopildora = (int) Math.round(Math.random()*2);
					System.out.println(tipopildora);
					Pocion pocion = new Pocion (this.getX(), this.getY(), tipopildora);
					Arkanoid.getInstance().agregarActor(pocion);
				}
				
				// Reproduzco el sonido de la explisi�n
				CacheRecursos.getInstance().playSonido("Arkanoid-SFX-01.wav");
				}
				else {
					listo = true;
					Arkanoid.getInstance().puntos = Arkanoid.getInstance().puntos + 50;
				}
			}	
		}
		
	}

	
}
