package videojuegos.Arkanoid.arkanoidFinal;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

/**
 * Clase que representa la bola del juego, que rebotar� y destruir� ladrillos
 * @author R
 *
 */
public class Bola extends Actor {
	// Pienso que, aunque m�s adelante en el juego pueda haber varias bolas, en principio su di�metro no cambia
	public static final int DIAMETRO = 15;
	// Segundos que se puede esperar con la bola quieta
	public static final int SEGUNDOS_MAXIMA_ESPERA_A_INICIO_DE_MOVIMIENTO = 5;
	// La siguiente variable nos ayuda a contar el tiempo que ha pasado desde que se inicializa la bola
	private long millisDesdeInicializacion;
	int vida = 3;
	
	// La bola se mover� en una determinada recta (trayectoria) con una determinada velocidad
	public TrayectoriaRecta trayectoria = null;
	boolean espacio =false;
	boolean click = false;
	
	long segundos;
	// Para el control preciso del aumento de la velocidad de la bola constante utilizo unas coordenadas flotantes
	// aunque eso no quita que sigan existiendo las coordenades x e y del supertipo Actor. De hecho, cada vez que
	// actualizamos las coordenadas flotantes tambi�n actualizar� las coordenadas enteras.
	private PuntoAltaPrecision coordenadas = null;
	float velocidadPorFrame = 2.5f; // Velocidad inicial de la bola, expresada en pixels por frame
	// La velocidad de la Bola aumentar� conforme vaya aumentando el n�mero de frames generados con el siguiente factor
	private float factorIncrementoVelocidadBola = 1.00035f;
	long millis = System.currentTimeMillis();
	public boolean vidaMenos=false; 
	// M�xima velocidad posible a alcanzar
	private static final float MAXIMA_VELOCIDAD = 12;
	
	
	/**
	 * 
	 */
	public Bola() {
		super();
		spriteActual = null; // La bola se pinta de forma vectorial
		this.x = Arkanoid.ANCHO / 2;
		this.y = Arkanoid.ALTO / 2;
		// Inicializamos las coordenadas de alta precisi�n
		this.coordenadas = new PuntoAltaPrecision(x, y);
		this.ancho = DIAMETRO;
		this.alto = DIAMETRO;
	}

	/**
	 * Pintado de la bola en pantalla
	 */
	public void paint(Graphics2D g){
		g.setColor(Color.LIGHT_GRAY);
		// Se pinta la bola como un c�rculo
		g.fillOval(Math.round(this.coordenadas.x), Math.round(this.coordenadas.y), DIAMETRO, DIAMETRO);
	}

	
	/**
	 * La bola act�a en cada iteraci�n del programa
	 */
	public void act() {
		super.act();
		millisDesdeInicializacion = System.currentTimeMillis();
		segundos = millisDesdeInicializacion - millis; 
		if (espacio == true || click == true || segundos> 5) {
		// Si la bola lleva una cantidad de segundos quieta, se pondr� autom�ticamente en movimiento
		long millisActuales = new Date().getTime();
		if (this.trayectoria == null &&
			(millisActuales - this.millisDesdeInicializacion) >= (1000 * SEGUNDOS_MAXIMA_ESPERA_A_INICIO_DE_MOVIMIENTO)) {
			this.iniciarMovimiento(-1, -1);
		}
		
		if (this.trayectoria != null) {
			// Si la bola toca el borde por arriba o por abajo, su trayectoria se reflejar� verticalmente
			if (this.y < 0) {
				this.trayectoria.reflejarHaciaAbajo(this.coordenadas);
			}
			else if (this.y > Arkanoid.ALTO - DIAMETRO) {
				vidaMenos = true; 
				if (Arkanoid.getInstancia().inmortal != true) {
					Arkanoid.getInstancia().vidas--;
				}
								
				Arkanoid.getInstancia().reiniciar();
			
			}
			// Si la bola se toca el borde por la izquierda o por la derecha, su velocidad cambia de signo
			else if (this.x < 0) {
				this.trayectoria.reflejarHaciaDerecha(this.coordenadas);
			}
			else if (this.x > Arkanoid.ANCHO - DIAMETRO) {
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
			if (this.velocidadPorFrame < MAXIMA_VELOCIDAD) {
				this.velocidadPorFrame *= this.factorIncrementoVelocidadBola;
			}
		}

		}
	}

	/**
	 * M�todos llamados desde el controlador del teclado, para delegar el evento del teclado
	 * @param event
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			espacio = true;
			this.iniciarMovimiento(-1, -1);
	  	}
	}
	
	/**
	 * Con el siguiente m�todo recogeremos el clic del rat�n, para iniciar el movimiento si este no se ha iniciado
	 * @param event
	 */
	public void mouseClicked(MouseEvent event) {
		// En caso de que hagan clic manteniendo pulsado las may�sculas y el control iniciaremos un movimiento con
		// una trayectoria que pase desde el punto actual de la bola y por el punto se�alado con el rat�n
		if (event.isShiftDown() && event.isControlDown()) {
			this.iniciarMovimiento(event.getX(), event.getY());
			click = true; 
		}
		else {
			// Indicamos que se inicie el movimiento con una trayectoria por defecto
			this.iniciarMovimiento(-1, -1);
		}
	}
	
	/**
	 * Principio del movimiento de la bola
	 * @param xDestino
	 * @param yDestino
	 */
	private void iniciarMovimiento (int xDestino, int yDestino) {
		if (trayectoria == null) {
			// Si los valores del punto de destino son "-1" indica ue debemos hacer una trayectoria por defecto
			if (xDestino == -1 && yDestino == -1) {
				this.trayectoria = new TrayectoriaRecta(-3f, this.coordenadas, true);
			}
			// En caso contrario debemos trazar la trayectoria desde el punto actual de la bola hasta el punto
			// que nos indican
			else {
				// Establecemos una m�nima distancia en el eje X entre la situaci�n de la bola y el punto que nos
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
				// Determinamos la direcci�n a seguir en la trayectoria en funci�n del signo de la pendiente que 
			// esperamos
				boolean direccionCreciente = (xDestino > this.getX())? true : false;
				// Creamos la trayectoria.
				this.trayectoria = new TrayectoriaRecta(new PuntoAltaPrecision(this.x, this.y), new PuntoAltaPrecision(xDestino, yDestino), direccionCreciente);
			}	 
			
		}
	}
	
	/**
	 * Este m�todo sirve para la nave nos notifique el momento en que cambia su posici�n. Hay que recordar
	 * que al principio de la fase, la pelota debe quedar pegada a la nave
	 * @param x
	 * @param y
	 */
	public void naveCambiaPosicion (Nave nave) {
		// Si la velocidad de la bola todav�a est� a cero indica que no ha comenzado a moverse
		// Si la nave se mueve y la bola est� quieta, la bola debe permanecer pegada a la nave.
		if (this.trayectoria == null) {
			// Cada vez que la nave se mueva y, por tanto, la pelota pegada a la nave, actualizo las coordenadas de
			// alta precisi�n para, a continuaci�n, redondearlas en las coordenadas enteras
			this.coordenadas.x = nave.getX() + nave.getAncho() / 2;
			this.coordenadas.y = nave.getY() - this.getAlto() - 1;
			this.x = Math.round(this.coordenadas.x);
			this.y = Math.round(this.coordenadas.y);
		}
	}

	/**
	 * En el caso de que detectemos una colisi�n se debe decidir el rebote. Para empezar, debemos decidir si se ha producido una colisi�n
	 * con un tipo de objeto u otro, ya que una cosa es rebotar con un ladrillo y otra con la nave
	 */
	@Override
	public void colisionProducidaConOtroActor(Actor actorColisionado) {
		super.colisionProducidaConOtroActor(actorColisionado);
		if (actorColisionado instanceof Ladrillo) { // Colisi�n con ladrillo
			colisionConLadrillo(actorColisionado);
		}
		else if (actorColisionado instanceof Nave) { // Colisi�n con nave
			colisionConNave((Nave)  actorColisionado);
		}
	}
	
	
	/**
	 * Utilizaremos, para calcular las colisiones, un rect�ngulo menor que el di�metro de la propia bola, de esta manera haremos las colisiones
	 * m�s precisas
	 * @return
	 */
	public Rectangle getRectanguloParaColisiones () {
		return new Rectangle(this.x + this.ancho / 2 - 4, this.y + this.alto / 2 - 4, 8, 8);
	}
	
	/**
	 * Colisi�n de la bola con un ladrillo, para determinar el lugar del ladrillo a trav�s del que la bola ha colisionado utilizaremos cuatro
	 * rect�ngulos imaginarios alrededor del mismo.
	 * @param actorColisionado
	 */
	private void colisionConLadrillo (Actor actorColisionado) {
		int margenLateral = 4; // Este mare
		// Creo peque�os rect�ngulos que coincidir�n con los bordes del ladrillo
		Rectangle rectArribaActor = new Rectangle(actorColisionado.getX(), actorColisionado.getY(), actorColisionado.getAncho(), 1);
		Rectangle rectAbajoActor = new Rectangle(actorColisionado.getX(), actorColisionado.getY() + actorColisionado.getAlto()-1, actorColisionado.getAncho(), 1);
		Rectangle rectIzquierdaActor = new Rectangle(actorColisionado.getX(), actorColisionado.getY() + margenLateral, 1, actorColisionado.getAlto() - 2 * margenLateral);
		Rectangle rectDerechaActor = new Rectangle(actorColisionado.getX() + actorColisionado.getAncho()-1, actorColisionado.getY() + margenLateral, 1, actorColisionado.getAlto() - 2 * margenLateral);

		// variables booleanas que me indicar�n una colsi�n por cada lado del ladrillo
		boolean arriba = false, abajo = false, derecha = false, izquierda = false;
		
		if (this.getRectanguloParaColisiones().intersects(rectArribaActor))  arriba = true;
		if (this.getRectanguloParaColisiones().intersects(rectAbajoActor))  abajo = true;
		if (this.getRectanguloParaColisiones().intersects(rectIzquierdaActor))  izquierda = true;
		if (this.getRectanguloParaColisiones().intersects(rectDerechaActor))  derecha = true;
		
		if (arriba && izquierda) { // Colisi�n con esquina superior izquierda
			// Coloco la bola en la esquina
			this.x = actorColisionado.x;
			this.y = actorColisionado.y;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			// Recalculo la pendiente
			this.trayectoria.setPendiente(Math.abs(this.trayectoria.getPendiente()), this.coordenadas, false);
			return;
		}
		if (arriba && derecha) {
			this.x = actorColisionado.x + actorColisionado.ancho;
			this.y = actorColisionado.y;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			this.trayectoria.setPendiente(0-Math.abs(this.trayectoria.getPendiente()), this.coordenadas, true);
			return;
		}
		if (abajo && izquierda) {
			this.x = actorColisionado.x;
			this.y = actorColisionado.y + actorColisionado.alto;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			this.trayectoria.setPendiente(0-Math.abs(this.trayectoria.getPendiente()), this.coordenadas, false);
			return;
		}
		if (abajo && derecha) {
			this.x = actorColisionado.x + actorColisionado.ancho;
			this.y = actorColisionado.y + actorColisionado.alto;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			this.trayectoria.setPendiente(Math.abs(this.trayectoria.getPendiente()), this.coordenadas, true);
			return;
		}
		if (abajo) {
			this.y = actorColisionado.y + actorColisionado.alto;
			this.coordenadas.y = this.y;
			this.trayectoria.reflejarHaciaAbajo(this.coordenadas);
			return;
		}
		if (arriba) {
			this.y = actorColisionado.y;
			this.coordenadas.y = this.y;
			this.trayectoria.reflejarHaciaArriba(this.coordenadas);
			return;
		}
		if (izquierda) {
			this.x = actorColisionado.x;
			this.coordenadas.x = this.x;
			this.trayectoria.reflejarHaciaIzquierda(this.coordenadas);
			return;
		}
		if (derecha) {
			this.x = actorColisionado.x + actorColisionado.ancho;
			this.coordenadas.x = this.x;
			this.trayectoria.reflejarHaciaDerecha(this.coordenadas);
			return;
		}
	}
	
	
	/**
	 * M�todo que determina lo que hacer cuando la bola choca con la nave
	 * @param nave
	 */
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
}
