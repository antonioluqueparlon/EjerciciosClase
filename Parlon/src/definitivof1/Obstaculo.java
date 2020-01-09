package definitivof1;

import java.awt.Graphics2D;

import Parlon.Utils;

public abstract class Obstaculo {
	
	private int posicionX,posicionY;
	private int impulso;
	private int espacioQueOcupa;

	/**
	 * @param posicion
	 */
	public Obstaculo(int posicion) {
		super();
		this.posicionX = Utils.obtenerNumeroAzar(3, 8);
		this.posicionY = Utils.obtenerNumeroAzar(3, 8);
	}

	/**
	 * @param posicion
	 * @param impulso
	 * @param espacio
	 */
	public Obstaculo(int posicion, int impulso, int espacio) {
		super();
		this.posicionX = Utils.obtenerNumeroAzar(1, 6);
		this.posicionY = Utils.obtenerNumeroAzar(3, 8);
		this.impulso = Utils.obtenerNumeroAzar(-3,3);
		this.espacioQueOcupa = Utils.obtenerNumeroAzar(1, 3);
	}
	
	

	@Override
	public String toString() {
		return "Obstaculo [posicion=" + posicionX + ", impulso=" + impulso + ", espacio=" + espacioQueOcupa + "]";
	}

	/**
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicionX;
	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(int posicion) {
		this.posicionX = posicion;
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

	public void paint(Graphics2D g) {
		g.drawOval(24, 23, 10, 10);	
	}
	
	
	
	

}
