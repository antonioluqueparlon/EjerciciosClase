package videojuegos.JuegoFormula1;

import java.awt.Graphics;

import Parlon.Utils;

public abstract class Obstaculo {
	
	private int posicion;
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

	private int impulso;

	/**
	 * @param posicion
	 */
	public Obstaculo(int posicion) {
		super();
		this.posicion = Utils.obtenerNumeroAzar(3, 8);
		this.impulso = Utils.obtenerNumeroAzar(1.5);
	}

	public Object getPosicionObstaculo() {
		// TODO Auto-generated method stub
		return null;
	}
	


	
	

}
