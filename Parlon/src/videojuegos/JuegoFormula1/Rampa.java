package videojuegos.JuegoFormula1;

import Parlon.Utils;

public class Rampa extends Obstaculo {
	
	private int impulso;
	private int longitudPista;
	

	/**
	 * @param posicion
	 * @param impulso
	 * @param espacio
	 */
	public Rampa(int posicion, int impulso, int espacio) {
		super(posicion, impulso, espacio);
		// TODO Auto-generated constructor stub
	}
	


	/**
	 * @param posicion
	 * @param impulso
	 */
	public Rampa(int posicion, int impulso) {
		super(posicion);
		this.impulso = impulso;
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


	@Override
	public String toString() {
		return "Rampa [impulso=" + impulso + "]";
	}


	public void ImpulsaDistancia() {
		do {
			impulso+= Utils.obtenerNumeroAzar(3,10);
		}while (this.longitudPista<=100);
	 }
	
	

}
