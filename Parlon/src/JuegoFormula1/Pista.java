package JuegoFormula1;

import java.util.Arrays;

public class Pista {
	
	private Obstaculo obstaculos []=new Obstaculo [4];
	private int longitudPista=100;

	
	/**
	 * @param jugadores
	 * @param pistas
	 * @param obstaculos
	 * @param longitudPista
	 */
	public Pista(Vehiculo[] jugadores, Pista[] pistas, Obstaculo[] obstaculos, int longitudPista) {
		super();
		this.obstaculos = obstaculos;
		this.longitudPista = longitudPista;
	}


	

	/**
	 * @return the obstaculos
	 */
	public Obstaculo[] getObstaculos() {
		return obstaculos;
	}




	/**
	 * @param obstaculos the obstaculos to set
	 */
	public void setObstaculos(Obstaculo[] obstaculos) {
		this.obstaculos = obstaculos;
	}




	/**
	 * @return the longitudPista
	 */
	public int getLongitudPista() {
		return longitudPista;
	}




	/**
	 * @param longitudPista the longitudPista to set
	 */
	public void setLongitudPista(int longitudPista) {
		this.longitudPista = longitudPista;
	}



	
	
	public void imprimirEnPantalla () {
		
	}
}
