package videojuegos.JuegoFormula1;

import java.awt.Graphics;

import Parlon.Utils;

public abstract class Obstaculo {
	
	private int posicion;
	private int impulso;
	private int espacioQueOcupa;

	/**
	 * @param posicion
	 */
	public Obstaculo(int posicion) {
		super();
		this.posicion = Utils.obtenerNumeroAzar(3, 8);
	}

	/**
	 * @param posicion
	 * @param impulso
	 * @param espacio
	 */
	public Obstaculo(int posicion, int impulso, int espacio) {
		super();
		this.posicion = Utils.obtenerNumeroAzar(1, 6);
		this.impulso = Utils.obtenerNumeroAzar(-3,3);
		this.espacioQueOcupa = Utils.obtenerNumeroAzar(1, 3);
	}
	
	

	@Override
	public String toString() {
		return "Obstaculo [posicion=" + posicion + ", impulso=" + impulso + ", espacio=" + espacioQueOcupa + "]";
	}

	/**
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicion;
	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	/**
	 * @return the impulso
	 */
	public int getImpulso() {
		return impulso;
	}

	/**
	 * @param impulso the impulso to set
	 */
	public void setImpulso(int impulso) {
		this.impulso = impulso;
	}

	/**
	 * @return the espacio
	 */
	public int getEspacio() {
		return espacioQueOcupa;
	}

	/**
	 * @param espacio the espacio to set
	 */
	public void setEspacio(int espacio) {
		this.espacioQueOcupa = espacio;
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
		
	}
	
	

}
