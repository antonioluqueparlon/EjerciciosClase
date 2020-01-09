package videojuegos.JuegoFormula1;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Vehiculo {
	
	private String nombre;
	private int posicion=0;
	private String color;
	protected int ancho;
	protected int alto;
	/**
	 * @param nombre
	 * @param posicion
	 * @param color
	 */
	public Vehiculo(String nombre, int posicion, String color) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.color = color;
	}

	public void avanza() {
		
		int longitudCarrera=0;
		int numAleatorio;
		do {
				numAleatorio=Parlon.Utils.obtenerNumeroAzar(1, 15);
				System.out.println("El coche "+ nombre+ " ha aumentado en" + numAleatorio);
				longitudCarrera+=numAleatorio;
			
		}while (longitudCarrera<100); {
            System.out.println("Carrera interrumpida");
		}
	}
	
	public void paint(Graphics g){
		
	}
	
}
	
