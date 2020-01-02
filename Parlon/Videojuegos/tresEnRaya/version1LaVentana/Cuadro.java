package tresEnRaya.version1LaVentana;

import java.awt.Color;
import java.awt.Graphics;

public class Cuadro {

	private int coordenadaX,coordenadaY;
	private int esquinaSuperiorIzquierdaX,esquinaSuperiorIzquierdaY;
	private int ancho, alto;

	/**
	 * @param coordenadaX
	 * @param coordenadaY
	 */
	public Cuadro(int coordenadaX, int coordenadaY) {
		super();
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	public void paint (Graphics g) {
		
		esquinaSuperiorIzquierdaX=this.coordenadaX * ancho;
		esquinaSuperiorIzquierdaY=this.coordenadaY * alto;
		//ancho y alto dependeran de la ventana principal del canvas y lo divido entre 3
		//porque son 3x3
		ancho=TresEnRaya.getInstance().getWidth() / 3;
		alto=TresEnRaya.getInstance().getHeight() / 3;
		
		//pinto los bordes de los cuadros
		g.setColor(Color.RED);
		g.drawRect(esquinaSuperiorIzquierdaX, esquinaSuperiorIzquierdaY, ancho, alto);
	}
	
	
	//Ahora voy a crear el metodo para comprobar si se ha hecho click o no sobre un cuadro
	public boolean seHaHechoClickSobreCuadro(int xClick, int yClick) {
		//Compruebo si donde se ha hecho click con el raton esta dentro del espacio de mi cuadro
		if (xClick > this.esquinaSuperiorIzquierdaX && xClick < (esquinaSuperiorIzquierdaX + ancho) // coordenada x dentro del cuadro
			&&
			yClick > this.esquinaSuperiorIzquierdaY && yClick < (esquinaSuperiorIzquierdaY + alto)) { // coordenada y dentro del cuadro
			return true;
		}
		return false;
	}
	
	public void click () {
		System.out.println("click sobre mi" + this.toString());
	}
	

	@Override
	public String toString() {
		return "Cuadro [Coordenada X=" + coordenadaX + ", Coordenada Y=" + coordenadaY + "]";
	}



	/**
	 * @return the coordenadaX
	 */
	public int getCoordenadaX() {
		return coordenadaX;
	}

	/**
	 * @param coordenadaX the coordenadaX to set
	 */
	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	/**
	 * @return the coordenadaY
	 */
	public int getCoordenadaY() {
		return coordenadaY;
	}

	/**
	 * @param coordenadaY the coordenadaY to set
	 */
	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	
}
