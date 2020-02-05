package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Pocion extends Actor {
	// Damos un ancho y un alto espec�fico al ladrillo. Suponemos que todos los
		// ladrillos ser�n iguales
		public static final int ANCHO = 30;
		public static final int ALTO = 20;
		int newImg=0;
		public boolean colisionado = false;
		
		/**
		 * Constructor
		 */
		public Pocion() {
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
		public Pocion(int x, int y, int imagen) {
			this.x = x;
			this.y = y;
			this.ancho = ANCHO;
			this.alto = ALTO;
			// Carga de los sprites de la explosi�n
			List<BufferedImage> nuevosSprites = new ArrayList<BufferedImage>();
			nuevosSprites.add(CacheRecursos.getInstance().getImagen("Catch.gif"));
			nuevosSprites.add(CacheRecursos.getInstance().getImagen("Duplicate.gif"));
			nuevosSprites.add(CacheRecursos.getInstance().getImagen("Enlarge.gif"));
			
			
			// Sprite actual
			this.spriteActual = nuevosSprites.get(imagen);
			newImg = imagen;
		}
		public void act () {
			this.setY(this.getY()+1);
			if (this.getY()>=600||colisionado) {
				eliminar();
			}
		}
		
		/**
		 * Colision detectada
		 */
		@Override
		public void colisionProducidaConOtroActor(Actor actorColisionado) {
			super.colisionProducidaConOtroActor(actorColisionado);
			colisionado = true;
			if (newImg == 0) {
				Arkanoid.getInstance().puntos = Arkanoid.getInstance().puntos + 50;
				Arkanoid.getInstance().vidas++;
				
			}
			if (newImg == 1) {
				Arkanoid.getInstance().puntos = Arkanoid.getInstance().puntos+ 400;
				Arkanoid.getInstance().inmortal = true;
			}
			if (newImg==2) {
				Arkanoid.getInstance().puntos =Arkanoid.getInstance().puntos+  -500;
				Arkanoid.getInstance().inmortal = false;
				Arkanoid.getInstance().vidas = 0;
				Arkanoid.getInstance().GameOver();
				
			}

			
		}
}
