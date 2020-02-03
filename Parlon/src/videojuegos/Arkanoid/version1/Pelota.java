package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;



public class Pelota extends Actor {

	public static final int DiametroBola=15;
	private int velocidadX=5;
	int vidas=3;
	public static int SegundosDeEsperaPelota=5;
	float VelocidadPelota = 2.5f;
	private PuntoAltaPrecision coordenadas=null;
	public TrayectoriaRecta trayectoria=null;
	
	public boolean espacio=false;// estas banderas son para indicar que el juego
	public boolean click=false;//empieza cuando le demos click o al espacio

	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillOval(Math.round(this.coordenadas.x),Math.round(this.coordenadas.y), DiametroBola, DiametroBola);
	}
	
	public Pelota() {
		super();
		spriteActual = null; // La bola se pinta de forma vectorial
		this.x = Arkanoid.getInstance().getWidth() / 2;
		this.y = Arkanoid.getInstance().getHeight() / 2;
		this.alto=DiametroBola;
		this.ancho=DiametroBola;
		this.coordenadas= new PuntoAltaPrecision(x, y);
	}

	@Override
	public void act() {
	
		//Movimiento eje horizontal
		if (this.x <0 || this.x > (Arkanoid.getInstance().getWidth() - DiametroBola)) {
			 this.velocidadX = 0 -this.velocidadX;
		}
		
		// Agregamos las velocidades respectivas a cada eje para la bola
		this.x += this.velocidadX;
		
		
			
	}
	
	public void NaveControlaInicioPelota(Nave nave) {
		//Si no tiene la trayectoria la bola le asigno las coordenadas oficiales que seran
		//las mismas que las de la nave al inicio
		if(trayectoria ==null) {
			this.coordenadas.x = nave.getX() + nave.getAncho() / 2;
			this.coordenadas.y = nave.getY() - this.getAlto() - 1;
			this.x = Math.round(this.coordenadas.x);
			this.y = Math.round(this.coordenadas.y);
		}
	}
	
	public void ColisionConActores(Actor actorcolisionado) {
		super.colisionConOtroActor(actorcolisionado);
		if (actorcolisionado instanceof Ladrillos) { // Colision con ladrillo
			colisionConLadrillo(actorcolisionado);
		}
		else if (actorcolisionado instanceof Nave) { // Colision con nave
			colisionConNave((Nave)  actorcolisionado);
		}
	}
	
	private void colisionConLadrillo(Actor actorcolisionado) {
		
	}
	
	private void colisionConNave(Nave nave) {
		
	}
	
	//Hacer que darle al espacio funcione
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			espacio = true;
			this.iniciarMovimiento(-1, -1);
	  	}
	}
	
	//Primer movimiento de la bola
	private void iniciarMovimiento(int xDestino, int yDestino) {
		if(trayectoria==null) {
			if(xDestino==-1 && yDestino==-1) {// Si la trayectoria es -1 hara una trayectoria por defecto
				this.trayectoria= new TrayectoriaRecta(-3f, this.coordenadas, true);
			}
			
			//si no usa la trayectoria por defecto
			else {
				// Establecemos una minima distancia en el eje X entre la situacion de la bola y el punto que nos
				// indican. De esa manera evitamos que la pelota se pueda poner completamente vertical
				int minimaDistanciamientoEntreX = 20;
				if (Math.abs(xDestino - this.getX()) < minimaDistanciamientoEntreX) {
					// Trayectoria a derecha
					if (xDestino < this.getX()) {
						xDestino = this.getX() - minimaDistanciamientoEntreX;
					}
					else {
						// Trayectoria a izquierda
						xDestino = this.getX() + minimaDistanciamientoEntreX;
					}
				}
			// Determinamos la direccion a seguir en la trayectoria en funcion del signo de la pendiente que 
			// esperamos
				boolean direccionCreciente = (xDestino > this.getX())? true : false;
				// Creamos la trayectoria.
				this.trayectoria = new TrayectoriaRecta(new PuntoAltaPrecision(this.x, this.y), new PuntoAltaPrecision(xDestino, yDestino), direccionCreciente);
		
			}
		}
	}
	
}
