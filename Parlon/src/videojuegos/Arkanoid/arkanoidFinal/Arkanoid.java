package videojuegos.Arkanoid.arkanoidFinal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Clase principal del programa, act�a como la ventana que ver� el usuario. Se utiliza un patr�n Singleton
 * @author R
 *
 */
public class Arkanoid extends Canvas {
	// Variables est�ticas
	public static final int ANCHO = 400;
	public static final int ALTO = 600;
	public static final int FPS = 101; // Frames por segundo
	// Ventana
	JFrame ventana = null;
	// Lista de actores que se representan en pantalla
	List<Actor> actores = new ArrayList<Actor>();
	// Nave y bola
	Nave nave = new Nave();
	Bola bola = new Bola();
	boolean faseFinal = false;
	boolean fase1Acabada = false;
	boolean inmortal = false;
	
	boolean fastidio = false;
	int puntuacion ;
	int vidas = 3;
	// Fase activa en el juego
	boolean activo = false;
	Fase faseActiva = null;
	// Estrategia de Doble Buffer
	private BufferStrategy strategy;
	// Variable para patr�n Singleton
	private static Arkanoid instancia = null;
	// Lista con actores nuevos que se deben incorporar en la siguiente iteraci�n del juego
	List<Actor> actoresAInsertar = new ArrayList<Actor>();
	
	/**
	 * Getter Singleton
	 * @return
	 */
	public synchronized static Arkanoid getInstancia () {
		if (instancia == null) {
			instancia = new Arkanoid();
		}
		return instancia;
	}
	
	
	
	/**
	 * Constructor
	 */
	public Arkanoid() {
		// Creaci�n de la ventana
		ventana = new JFrame("Arkanoid");
		// Obtenemos el panel principal del JFrame
		JPanel panel = (JPanel) ventana.getContentPane();
		// Establezco las dimensiones del Canvas
		this.setBounds(0,0,ANCHO,ALTO);
		// El panel tendr� un tama�o preferido
		panel.setPreferredSize(new Dimension(ANCHO,ALTO));
		panel.setLayout(null);
		// Agregamos el Canvas al panel
		panel.add(this);
		// Dimensionamos el JFrame
		ventana.setBounds( 0, 0, ANCHO+5, ALTO+28);
		
		// Hacemos el JFrame visible
		ventana.setVisible(true);
		// Con el siguiente c�digo preguntamos al usuario si realmente desea cerrar la aplicaci�n, cuando
		// pulse sobre el aspa de la ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
		// Creaci�n de la estrategia de doble b�ffer
		this.createBufferStrategy(2);
		strategy = this.getBufferStrategy();
		// Con ignoreRepaint le decimos al JFrame que no debe repintarse cuando el Sistema Operativo se lo indique,
		// nosotros nos ocupamos totalmente del refresco de la pantalla
		ventana.setIgnoreRepaint(true);
		// La ventana no podr� redimensionarse
		ventana.setResizable(false);
		// Hacemos que el Canvas obtenga autom�ticamente el foco del programa para que, si se pulsa una tecla, la pulsaci�n
		// se transmita directamente al Canvas.
		this.requestFocus();
		// Para resolver un problema de sincronizaci�n con la memoria de v�deo de Linux, utilizamos esta l�nea
		Toolkit.getDefaultToolkit().sync();
		
		// Agrego los controladores de rat�n y de teclado
		ControladorRaton controladorRaton = new ControladorRaton();
		this.addMouseMotionListener(controladorRaton);
		this.addMouseListener(controladorRaton);
		this.addKeyListener(new ControladorTeclado());
	}
	
	

	/**
	 * Al cerrar la aplicaci�n preguntaremos al usuario si est� seguro de que desea salir.
	 */
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"�Desea cerrar la aplicaci�n?","Salir de la aplicaci�n",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	
	
	/**
	 * Al principio del juego, lo primero que se debe hacer es inicializar todo lo necesario para que se pueda mostrar
	 * la primera fase.
	 */
	public void initWorld1() {
		// Preparaci�n de la primera fase
		if (fase1Acabada == false) {
			this.faseActiva = new Fase01();
		}
		else {
			this.faseActiva = new Fase02();
		}
		this.faseActiva.inicializaFase();
		// Agregamos los actores de la primera fase a nuestro juego
		this.actores.clear();
		this.actores.addAll(this.faseActiva.getActores());
		// Creaci�n de los actores Nave y Bola
	    this.actores.add(this.nave);
	    this.actores.add(this.bola);
	}
	
		

	/**
	 * Cada vez que actualicemos el juego se llamar� a este m�todo	
	 */
	public void updateWorld() {
		// Comprobaci�n de las colisiones posibles producidas
		// Para detectar colisiones me basta con coger a los ladrillos del array de actores y comprobar si tienen colisi�n con la
		// bola, ya que es el �nico caso que de momento nos interesa para romper ladrillos.
		// Tambi�n intentar� encontrar una colisi�n entre la bola y la nave
		for (Actor actor : this.actores) {
			if (actor instanceof Ladrillo || actor instanceof Nave) {
				if (detectarYNotificarColisionConBola (actor)) {
					break; // Una vez que detecto la primera colisi�n dejo de buscar m�s colisiones.
				}
				
			}
			
			if (actor instanceof Pocion) {
				if (detectarYNotificarColisionConPocima(actor)) {
					break;
				}
			}
			
		}
		
			
		
		// A continuaci�n se revisa si alguno de los actores de la lista ha sido marcado para su eliminaci�n. En caso de ser as�
		// se procede a borrarlo de la lista.
		for (int i = this.actores.size()-1; i >= 0; i--) {
			if (this.actores.get(i).marcadoParaEliminacion) {
				this.actores.remove(i);
			}
		}
		
		// Agregamos aquellos nuevos actores que se desea incorporar a la siguiente escena
		for (Actor nuevoActor : this.actoresAInsertar) {
			this.actores.add(0, nuevoActor);
		}
		this.actoresAInsertar.clear(); // Limpio el array de actores a insertar
		
		// Actualizaci�n de todos los actores
		for (Actor actor : this.actores) {
			actor.act();
		}
	}

	
	/**
	 * 
	 * @param a1
	 * @param a2
	 */
	private boolean detectarYNotificarColisionConBola (Actor actor) {
		Rectangle rectActor = new Rectangle(actor.getX(), actor.getY(), actor.getAncho(), actor.getAlto());
		if (rectActor.intersects(this.bola.getRectanguloParaColisiones())) {
			// En el caso de que exista una colisi�n, informo a los dos actores de que han colisionado y les indico el
			// actor con el que se ha producido el choque
			actor.colisionProducidaConOtroActor(this.bola);
			this.bola.colisionProducidaConOtroActor(actor);
			return true;
		}
		return false;
	}
	
	private boolean detectarYNotificarColisionConPocima (Actor actor) {
		Rectangle rectActor = new Rectangle (actor.getX(), actor.getY(), actor.getAncho(), actor.getAlto());
		if (rectActor.intersects(this.nave.getRectanguloParaColisiones())) {
			actor.colisionProducidaConOtroActor(this.nave);
			this.nave.colisionProducidaConOtroActor(actor);
			return true;
		}
		return false;
	}
	
	

	/**
	 * M�todo responsable de repintar cada frame del juego
	 */
	public void paintWorld() {
		// Obtenemos el objeto Graphics (la brocha) desde la estrategia de doble b�ffer
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		// Lo primero que hace cada frame es pintar un rect�ngulo tan grande como la escena,
		// para superponer la escena anterior.
		g.drawImage(CacheRecursos.getInstancia().getImagen("fondo.jpg"),0,0,this);
		if (inmortal != true) {
		g.setColor(Color.BLACK);
		g.drawString("Vidas: " + vidas, 340, 580);
		}
		g.setColor(Color.BLACK);
		g.drawString("Puntuación: " + puntuacion, 10, 580);
		// Ejecutamos el m�todo paint de cada uno de los actores
		for (Actor actor : this.actores) {
			actor.paint(g);
		}
		// Una vez construida la escena nueva, la mostramos.
		strategy.show();
	}
	
	public void reiniciar () {
		actores.remove(this.bola);
		if(bola.vidaMenos == false) {
			bola = new Bola();	
		}
		puntuacion = puntuacion -150;
		actores.add(bola);
		bola.trayectoria = null;
		bola.velocidadPorFrame = 2.5f;
		game();
	}
	
	/**
	 * M�todo principal del juego. Contiene el bucle principal
	 */
	public void game() {
		
			initWorld1();
			
		// Este bucle se ejecutar� mientras el objeto Canvas sea visible.
		while (this.isVisible()) {
			
			// Inicializaci�n del juego
			Toolkit.getDefaultToolkit().sync();
			// Tomamos el tiempo en milisegundos antes de repintar el frame
			long millisAntesDeConstruirEscena = System.currentTimeMillis();
			// Actualizamos y pintamos el nuevo frame
			updateWorld();
			paintWorld();
			if (this.actores.size() <= 2 && faseFinal == false) {
				fase1Acabada = true;
				reiniciar();
				
			}
			gameOver();
			
			// Calculamos la cantidad de milisegundos que se ha tardado en realizar un nuevo frame del juego
			int millisUsados = (int) (System.currentTimeMillis() - millisAntesDeConstruirEscena);
			// Hago que el programa duerma lo suficiente para que realmente se ejecuten la cantidad de FPS
			// que tenemos programados
			try { 
				int millisADetenerElJuego = 1000 / FPS - millisUsados;
				if (millisADetenerElJuego >= 0) {
					 Thread.sleep(millisADetenerElJuego);
				}
			} catch (InterruptedException e) {}
		}
	}
	
	
	public void gameOver() {
		if (inmortal != true) {
			if (vidas<= 0) {
				JOptionPane.showMessageDialog(null, "GAME OVER");
				System.exit(0);
			}
		}
	}



	/**
	 * M�todo que permite agregar un nuevo actor
	 * @param nuevoActor
	 */
	public void agregarActor (Actor nuevoActor) {
		this.actoresAInsertar.add(nuevoActor);
	}
	
	
	
	// Getters
	public Nave getNave() { return nave; }
	public Bola getBola() { return bola; }



	/**
	 * M�todo main()
	 * @param args
	 */
	public static void main(String[] args) {
		CacheRecursos.getInstancia().cargarRecursosEnMemoria();
		Arkanoid.getInstancia().game();
	}


}
