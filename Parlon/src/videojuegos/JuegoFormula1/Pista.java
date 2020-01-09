package videojuegos.JuegoFormula1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import f1juegobuilder.granpremio;

public class Pista {
	// Coordenadas de este cuadro sobre el tablero, por ejemplo: 0,0 - 0,1 - 0,2 forman la primera fila de cuadros
	private int coordenadaX,coordenadaY;
	// Coordenadas del pixel superior izquierdo del cuadro representado por cada cuadro, a partir de ese píxel se pintará el cuadro
	private int esquinaSuperiorIzquierdaX,esquinaSuperiorIzquierdaY;
	// Ancho y alto de este cuadro
	private int ancho, alto;
	
	//private boolean clickHecho=false;
	
	//jugador que ha hecho click sobre este cuadro
	//el 0 dice que no pertenece a ningun jugador ese cuadro
	private int jugadorPropietario=0;
	/**
	 * @param coordenadaX
	 * @param coordenadaY
	 */
	public Pista(int coordenadaX, int coordenadaY) {
		super();
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	public void paint (Graphics g) {
		
		//ancho y alto dependeran de la ventana principal del canvas y lo divido entre 3
		//porque son 3x3
		ancho=GranPremio.getInstance().getWidth() ;
		alto=GranPremio.getInstance().getHeight() ;
		esquinaSuperiorIzquierdaX=this.coordenadaX * ancho;
		esquinaSuperiorIzquierdaY=this.coordenadaY * alto;
		
		//pinto los bordes de los cuadros
		g.setColor(Color.RED);
		g.drawOval(esquinaSuperiorIzquierdaX, esquinaSuperiorIzquierdaY, ancho, alto);
	
	//Pinto imagenes vectoriales si se ha hecho click sobre el
		
		//pintaImagenesVectoriales(g);
		pintaFotos(g);
		
	}
	
	private void pintaFotos(Graphics g) {
		BufferedImage imagenAPintar = null;
		if (this.jugadorPropietario == GranPremio.JUGADOR_1) { // Comprueba jugador 1 - Pinto el escudo del Real Madrid CF
			imagenAPintar = SpritesRepository.getInstance().getSprite("logof1.png");
		} 
		if (this.jugadorPropietario == GranPremio.JUGADOR_2) { // En este caso el jugador 2 - Pinto el escudo del FCB 
			imagenAPintar = SpritesRepository.getInstance().getSprite("coche2.png");
		}
		
		//una vez se la imagen, la pinto en el cuadro
		if(imagenAPintar != null) {
			int x= this.esquinaSuperiorIzquierdaX +this.ancho / 2 - imagenAPintar.getWidth() / 2;
			int y= this.esquinaSuperiorIzquierdaY +this.alto / 2 -imagenAPintar.getHeight() / 2;
			g.drawImage(imagenAPintar, x, y, null);
		}
	}

	/**
	 * Creo imagenesVectoriales
	 * @param g
	 */
	
	private void pintaImagenesVectoriales (Graphics g) {
		// Ahora, dependiendo del jugador propietario de este cuadro, pinto algo diferente
				if (this.jugadorPropietario == GranPremio.JUGADOR_1) { // Comprueba jugador 1 - pinta una cruz
					// Para pintar una cruz pinto dos líneas que se cruzan
					g.drawLine(this.esquinaSuperiorIzquierdaX, this.esquinaSuperiorIzquierdaY, 
							this.esquinaSuperiorIzquierdaX + this.ancho, this.esquinaSuperiorIzquierdaY + alto);
					g.drawLine(this.esquinaSuperiorIzquierdaX, this.esquinaSuperiorIzquierdaY + alto, 
							this.esquinaSuperiorIzquierdaX + this.ancho, this.esquinaSuperiorIzquierdaY);
				} 
				if (this.jugadorPropietario == GranPremio.JUGADOR_2) { // En este caso el jugador 2
					g.drawOval(this.esquinaSuperiorIzquierdaX, this.esquinaSuperiorIzquierdaY, this.ancho, this.alto);
				}
			}
	
	
	/**
	 * //Ahora voy a crear el metodo para comprobar si se ha hecho click o no sobre un cuadro
	 * @param xClick
	 * @param yClick
	 * @return
	 */
	public boolean seHaHechoClickSobreCuadro(int xClick, int yClick) {
		//Compruebo si donde se ha hecho click con el raton esta dentro del espacio de mi cuadro
		if (xClick > this.esquinaSuperiorIzquierdaX && xClick < (esquinaSuperiorIzquierdaX + ancho) // coordenada x dentro del cuadro
			&&
			yClick > this.esquinaSuperiorIzquierdaY && yClick < (esquinaSuperiorIzquierdaY + alto)) { // coordenada y dentro del cuadro
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public void click (int jugador) {
		if(this.jugadorPropietario == 0) {
			this.jugadorPropietario=jugador;
		}
		
		//Actualizo la matriz de jugadas del 3 en Raya
		GranPremio.getInstance().getMatrizJugadas()[this.coordenadaX][this.coordenadaY]= jugadorPropietario;
		
		//this.clickHecho=true; //Aqui digo que cuando se de click, actualizo a true
	
		
		//Obligo a repitar el canvas
		GranPremio.getInstance().repaint(); // vuelvo a pintar
		GranPremio.getInstance().revalidate();//vuelvo a validar por si acaso
		
		System.out.println("Estado del juego");
		for (int i = 0; i < GranPremio.getInstance().getMatrizJugadas().length; i++) {
			for (int j = 0; j < GranPremio.getInstance().getMatrizJugadas()[i].length; j++) {
				System.out.print(GranPremio.getInstance().getMatrizJugadas()[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
/**
 * 
 */
	@Override
	public String toString() {
		return "Pista [Coordenada X=" + coordenadaX + ", Coordenada Y=" + coordenadaY + "]";
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
