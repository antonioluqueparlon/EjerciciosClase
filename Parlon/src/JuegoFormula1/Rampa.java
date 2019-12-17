package JuegoFormula1;

import Parlon.Utils;

public class Rampa extends Obstaculo {
	
	private int impulso;
	

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
			
		}
	
	

	}
}
