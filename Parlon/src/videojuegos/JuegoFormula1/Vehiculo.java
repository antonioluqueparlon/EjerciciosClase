package videojuegos.JuegoFormula1;

import java.awt.Graphics;

import tutorialJava.Utils;

public abstract class Vehiculo {
	
	private String nombre;
	private int posicion=0;
	private String color;
	private Pista p= new Pista();
	/**
	 * @param nombre
	 * @param posicion
	 * @param color
	 * @param pista
	 */
	public Vehiculo(String nombre, int posicion, String color, int pista) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.color = color;
		this.p = p;
	}

		
	
	public abstract void paint(Graphics g); 
		
	



	public void avanza() {
		//Bucle que hace que avanzen los vehiculos
		for (int i =posicion;i<100;i++) {
			this.posicion=Parlon.Utils.obtenerNumeroAzar(2, 8);
			
		}
	}
	

}
