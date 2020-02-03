package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;




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
	public boolean UnaVidaMenos=false;//cuando muramos se nos quitara una vida; iniciamos en false la bandera
	float velocidadPorFrame = 2;
	long milis = System.currentTimeMillis();// segundos en los que empieza el juego
	long segundos;// segundos que le vamos a asignar a la pelota para que empiece
	long milisDesdeQueEmpiezaElJuego; // tiempo que transcurre desde que ha empezado
	private static final float VelocidadMaxima = 10;
	private float incrementoVelocidad = 1.00035f;
	

	public void paint(Graphics2D g) {
		g.setColor(Color.BLACK);
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

	
	public void act() {
		super.act();
		milisDesdeQueEmpiezaElJuego = System.currentTimeMillis();
		segundos = milisDesdeQueEmpiezaElJuego - milis; 
		if (espacio == true || click == true || segundos> 5) {
		// Si la bola lleva una cantidad de segundos quieta, se pondr� autom�ticamente en movimiento
		long millisActuales = new Date().getTime();
		if (this.trayectoria == null &&
			(millisActuales - this.milisDesdeQueEmpiezaElJuego) >= (1000 * SegundosDeEsperaPelota)) {
			this.iniciarMovimiento(-1, -1);
		}
		
		if (this.trayectoria != null) {
			// Si la bola toca el borde por arriba o por abajo, su trayectoria se reflejar� verticalmente
			if (this.y < 0) {
				this.trayectoria.reflejarHaciaAbajo(this.coordenadas);
			}
			else if (this.y > Arkanoid.JFRAME_HEIGHT - DiametroBola) {
				UnaVidaMenos = true; 
				if (Arkanoid.getInstance().inmortal != true) {
					Arkanoid.getInstance().vidas--;
				}
								
				Arkanoid.getInstance().ReiniciarNivel();
			
			}
			// Si la bola se toca el borde por la izquierda o por la derecha, su velocidad cambia de signo
			else if (this.x < 0) {
				this.trayectoria.reflejarHaciaDerecha(this.coordenadas);
			}
			else if (this.x > Arkanoid.JFRAME_WIDTH - DiametroBola) {
				this.trayectoria.reflejarHaciaIzquierda(this.coordenadas);
			}

			// Calculo del nuevo punto de la trayectoria de la bola
			PuntoAltaPrecision nuevoPuntoEnLaTrayectoria = this.trayectoria.getPuntoADistanciaDePunto(this.coordenadas, this.velocidadPorFrame);
			this.coordenadas = nuevoPuntoEnLaTrayectoria;
			// Actualizo las coordenadas enteras del supertipo Actor, ya que es conforme a estas con las que se pinta en pantalla
			// y se detectan las colisiones.
			this.x = Math.round(this.coordenadas.x);
			this.y = Math.round(this.coordenadas.y);
			
			// Detecto si es necesario aumentar la velocidad de la bola y, si es as�, lo hago, hasta que llegue al l�mite
			if (this.velocidadPorFrame < VelocidadMaxima) {
				this.velocidadPorFrame *= this.incrementoVelocidad;
			}
		}

		}
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
	
	@Override
	public void colisionConOtroActor(Actor actorcolisionado) {
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
	
	// si damos click tambien se iniciara el juego
	public void mouseClicked(MouseEvent event) {
		if (event.isShiftDown() && event.isControlDown()) {
			this.iniciarMovimiento(event.getX(), event.getY());
			click = true; 
		}
		else {
			// Indicamos que se inicie el movimiento con una trayectoria por defecto
			this.iniciarMovimiento(-1, -1);
		}
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
