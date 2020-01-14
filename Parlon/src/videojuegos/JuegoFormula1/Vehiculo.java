package videojuegos.JuegoFormula1;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Parlon.Utils;

public class Vehiculo extends Actor {
	
	protected Pista pista = null;
	private int posicion = 0;
	/**
	 * @param pista
	 * @param posicion
	 */
	public Vehiculo(Pista pista) {
		this.pista = pista;
		
	}
	public Vehiculo(int x, int y) {
		super(x,y);
	}
	
		
	@Override
	public void paint(Graphics g) {
		this.pista.paint(g);
	}
	@Override
	public void act() {
		this.posicion += Utils.obtenerNumeroAzar(1, 6);
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
	
	
}
	
