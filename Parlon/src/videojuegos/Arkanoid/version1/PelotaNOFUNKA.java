package videojuegos.Arkanoid.version1; // se supone que tiene que estar bien ya

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;


public class PelotaNOFUNKA extends Actor {

	public static final int DiametroBola=15;
	int vidas=3;
	public static int SegundosDeEsperaPelota=5;
	float VelocidadPelota = 2.5f;
	private PuntoAltaPrecision coordenadas=null;
	public TrayectoriaRecta trayectoria=null;
	
	public boolean espacio=false;// estas banderas son para indicar que el juego
	public boolean click=false;//empieza cuando le demos click o al espacio
	public boolean UnaVidaMenos=false;//cuando muramos se nos quitara una vida; iniciamos en false la bandera
	float velocidadPorFrame = 2f;
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
		this.coordenadas= new PuntoAltaPrecision(x, y);
		this.alto=DiametroBola;
		this.ancho=DiametroBola;
		
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
	

	public void naveControlaInicioPelota(Nave nave) {
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
	
	private void colisionConLadrillo(Actor actorcolisionado) { // ESTO ES DIFICIL
		int margenLateral = 4; // Este mare
		// Creo peque�os rect�ngulos que coincidir�n con los bordes del ladrillo
		Rectangle rectArribaActor = new Rectangle(actorcolisionado.getX(), actorcolisionado.getY(), actorcolisionado.getAncho(), 1);
		Rectangle rectAbajoActor = new Rectangle(actorcolisionado.getX(), actorcolisionado.getY() + actorcolisionado.getAlto()-1, actorcolisionado.getAncho(), 1);
		Rectangle rectIzquierdaActor = new Rectangle(actorcolisionado.getX(), actorcolisionado.getY() + margenLateral, 1, actorcolisionado.getAlto() - 2 * margenLateral);
		Rectangle rectDerechaActor = new Rectangle(actorcolisionado.getX() + actorcolisionado.getAncho()-1, actorcolisionado.getY() + margenLateral, 1, actorcolisionado.getAlto() - 2 * margenLateral);

		// variables booleanas que me indicar�n una colsi�n por cada lado del ladrillo
		boolean arriba = false, abajo = false, derecha = false, izquierda = false;
		
		if (this.getRectanguloParaColisiones().intersects(rectArribaActor))  arriba = true;
		if (this.getRectanguloParaColisiones().intersects(rectAbajoActor))  abajo = true;
		if (this.getRectanguloParaColisiones().intersects(rectIzquierdaActor))  izquierda = true;
		if (this.getRectanguloParaColisiones().intersects(rectDerechaActor))  derecha = true;
		
		if (arriba && izquierda) { // Colisi�n con esquina superior izquierda
			// Coloco la bola en la esquina
			this.x = actorcolisionado.x;
			this.y = actorcolisionado.y;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			// Recalculo la pendiente
			this.trayectoria.setPendiente(Math.abs(this.trayectoria.getPendiente()), this.coordenadas, false);
			return;
		}
		if (arriba && derecha) {
			this.x = actorcolisionado.x + actorcolisionado.ancho;
			this.y = actorcolisionado.y;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			this.trayectoria.setPendiente(0-Math.abs(this.trayectoria.getPendiente()), this.coordenadas, true);
			return;
		}
		if (abajo && izquierda) {
			this.x = actorcolisionado.x;
			this.y = actorcolisionado.y + actorcolisionado.alto;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			this.trayectoria.setPendiente(0-Math.abs(this.trayectoria.getPendiente()), this.coordenadas, false);
			return;
		}
		if (abajo && derecha) {
			this.x = actorcolisionado.x + actorcolisionado.ancho;
			this.y = actorcolisionado.y + actorcolisionado.alto;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			this.trayectoria.setPendiente(Math.abs(this.trayectoria.getPendiente()), this.coordenadas, true);
			return;
		}
		if (abajo) {
			this.y = actorcolisionado.y + actorcolisionado.alto;
			this.coordenadas.y = this.y;
			this.trayectoria.reflejarHaciaAbajo(this.coordenadas);
			return;
		}
		if (arriba) {
			this.y = actorcolisionado.y;
			this.coordenadas.y = this.y;
			this.trayectoria.reflejarHaciaArriba(this.coordenadas);
			return;
		}
		if (izquierda) {
			this.x = actorcolisionado.x;
			this.coordenadas.x = this.x;
			this.trayectoria.reflejarHaciaIzquierda(this.coordenadas);
			return;
		}
		if (derecha) {
			this.x = actorcolisionado.x + actorcolisionado.ancho;
			this.coordenadas.x = this.x;
			this.trayectoria.reflejarHaciaDerecha(this.coordenadas);
			return;
		}
	}
	
	private void colisionConNave (Nave nave) {
		// Creo rect�ngulos para determinar la zona de la nave con la que choca la bola
		int anchoZonaEspecial = 7; // p�xeles que delimitan la zona de rebote especial de la nave
		Rectangle rectIzqNave = new Rectangle(nave.getX(), nave.getY(), anchoZonaEspecial, nave.alto);
		Rectangle rectDerNave = new Rectangle(nave.getX() + nave.ancho - anchoZonaEspecial, nave.getY(), anchoZonaEspecial, nave.alto);
		Rectangle rectBola = this.getRectanguloParaColisiones();
		
		// Colisi�n con el lado derecho de la nave
		if (rectBola.intersects(rectDerNave)) {
			this.y = nave.getY() - nave.getAlto();
			this.coordenadas.y = this.y;
			if (Math.abs(this.trayectoria.getPendiente()) > 1 ) { // La bola viene on una pendiente mayor a 1
				this.trayectoria.setPendiente(-(float) (Math.random() * (0.8 - 0.3) + 0.3), this.coordenadas, true);
			}
			else { // La bola viene con una pendiente suave ( > 0 y < 1 )
				this.trayectoria.setPendiente(-(float) (Math.random() * (10 - 2) + 2), this.coordenadas, true);
			}
			return;
		}
		// Colisi�n con el lado izquierdo de la nave
		if (rectBola.intersects(rectIzqNave)) {
			this.y = nave.getY() - nave.getAlto();
			this.coordenadas.y = this.y;
			if (Math.abs(this.trayectoria.getPendiente()) > 1 ) { // La bola viene con una pendiente mayor a 1
				this.trayectoria.setPendiente((float) (Math.random() * (0.8 - 0.3) + 0.3), this.coordenadas, false);
			}
			else { // La bola viene con una pendiente suave ( > 0 y < 1 )
				this.trayectoria.setPendiente((float) (Math.random() * (10 - 2) + 2), this.coordenadas, false);
			}
			return;
		}
		else { // La bola intersecta la parte central de la nave
			this.trayectoria.reflejarHaciaArriba(this.coordenadas);
			return;
		}			
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

	public Rectangle getRectanguloParaColisiones () {
		return new Rectangle(this.x + this.ancho / 2 - 4, this.y + this.alto / 2 - 4, 8, 8);
	}
}
