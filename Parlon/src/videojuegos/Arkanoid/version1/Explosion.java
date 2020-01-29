package videojuegos.Arkanoid.version1;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Explosion extends Actor {

	/**
	 * 
	 */
	public Explosion(int x, int y) {
		super();
		this.x=x;
		this.y=y;
		//Carga de los sprites de la explosion
		List<BufferedImage> nuevosSpritesExplosion= new ArrayList<BufferedImage>();
	
		nuevosSpritesExplosion.add(CacheImagenes.getInstancia().getImagen("sprite-explosion1.png"));
		nuevosSpritesExplosion.add(CacheImagenes.getInstancia().getImagen("sprite-explosion2.png"));
		nuevosSpritesExplosion.add(CacheImagenes.getInstancia().getImagen("sprite-explosion3.png"));
		nuevosSpritesExplosion.add(CacheImagenes.getInstancia().getImagen("sprite-explosion4.png"));
		nuevosSpritesExplosion.add(CacheImagenes.getInstancia().getImagen("sprite-explosion5.png"));
		nuevosSpritesExplosion.add(CacheImagenes.getInstancia().getImagen("sprite-explosion6.png"));
		nuevosSpritesExplosion.add(CacheImagenes.getInstancia().getImagen("sprite-explosion7.png"));
		nuevosSpritesExplosion.add(CacheImagenes.getInstancia().getImagen("sprite-explosion8.png"));
		nuevosSpritesExplosion.add(CacheImagenes.getInstancia().getImagen("sprite-explosion9.png"));
		this.setSpritesDeAnimacionExplosion(nuevosSpritesExplosion);
		// Sprite actual
		this.spriteActual = this.getSpritesDeAnimacionExplosion().get(0);
		// Velocidad de cambio de sprite
		this.velocidadDeCambioDeSprite = 5;
	
	}
	
	@Override
	public void act() {
		super.act();
		if (this.spriteActual.equals(this.spritesDeAnimacionExplosion.get(this.spritesDeAnimacionExplosion.size()-1))) {
			this.eliminar();
		}
	}
}
	
