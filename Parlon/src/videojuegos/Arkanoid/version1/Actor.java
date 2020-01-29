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
	
	
	/**
	 * 
	 */
	public Actor() {
		// En principio coloco una imagen genérica al actor
		spriteActual = CacheImagenes.getInstancia().getImagen("sin-imagen.png");
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
}
