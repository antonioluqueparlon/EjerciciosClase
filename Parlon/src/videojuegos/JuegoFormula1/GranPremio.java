package videojuegos.JuegoFormula1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version14_Fotogramas.Monster;

public class GranPremio extends Canvas {

	// Ventana principal del juego
	JFrame ventana = new JFrame("Formula 1 creado por Parlón ");

	// Indicamos alto y ancho del objeto tipo Canvas
	private static final int JFRAME_WIDTH = 700;
	private static final int JFRAME_HEIGHT = 700;
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormirá 10 millis
	// tras haber repintado la escena
	public static final int SPEED_FPS=60;

	// Variable para establecer la instancia del patrón singleton
	private static GranPremio instance = null;
	// Control sobre el turno de cada jugador
	public static int JUGADOR_1 = 1;
	public static int JUGADOR_2 = 2;
	private int turnoActual = JUGADOR_1;
	private int ganador = 0;
	
	// Matriz que refleja la posición de las jugadas hechas por lo jugadores
		private int matrizJugadas[][] = new int[][] {{0, 0, 0},
													 {0, 0, 0},
													 {0, 0, 0}};

	// Lista con los objetos tipo "Cuadro" que se van a representar en el canvas
	// Cada uno con sus propias coordeanadas de un tablero de 3x3 cuadros. De esta
	// manera el primer cuadro de la primera fila tendrá como coordenadas 0, 0 y el
	// último cuadro de la tercera tendrá como coordenadas 3, 3
	List<Pista> pistas = new ArrayList<Pista>();

	/**
	 * Constructor, inicializa y monta la ventana
	 */
	public GranPremio() {
		
		//Carga de recursos para que no de lag al cargar
		
		SoundsRepository.getInstance();
		SpritesRepository.getInstance();
		
		// Obtengo referencia al panel principal de la ventana
		JPanel panel = (JPanel) ventana.getContentPane();
		// Establezco una plantilla en el panel, para poder incorporar el Canvas
		panel.setLayout(new BorderLayout());
		// Agrego el Canvas al panel
		panel.add(this, BorderLayout.CENTER);

		// Dimensiono la ventana
		ventana.setBounds(0, 0, JFRAME_WIDTH, JFRAME_HEIGHT);

		// Inicializo la lista con los nueve cuadros que formarán el tablero
		inicializaCuadrosDelTablero();

		// Agrego al Canvas un MouserAdapter, del cual sobrecargo el método
		// mouseClicked, que me va a permitir interceptar los eventos de clic de ratón que se produzcan sobre
		// el Canvas
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// Sólo nos interesa el clic con el botón principal del ratón
				if (e.getButton() == MouseEvent.BUTTON1 && ganador == 0) {
					for (Pista cuadro : pistas) {
						if (cuadro.seHaHechoClickSobreCuadro(e.getX(), e.getY())) {
							cuadro.click(turnoActual);
							ganador = comprobarGanador();
							if(ganador!=0) {
								finalizarPartida();
							}
							// Hago cambio de turno
							if (turnoActual == JUGADOR_1) {
								// Lanzo un sonido del jugador 1
								SoundsRepository.getInstance().playSound("item.wav");
								// cambio el turno
								turnoActual = JUGADOR_2;
							} else {
								// Lanzo un sonido del jugador 2
								SoundsRepository.getInstance().playSound("motorf1.wav");
								// Cambio el turno
								turnoActual = JUGADOR_1;
							}
						}

					}
				}
			}

		});
				
		// Lanzo un sonido en bucle que sonará todo el tiempo
		SoundsRepository.getInstance().loopSound("musicaF1.wav");

		// Desactivo el comportamiento por defecto al pulsar el botón de cierre de la
		// ventana
				ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		// Agrego un escuchador a la ventana, para detectar el evento de cierre de la
		// misma
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});

		// Muestro la ventana en pantalla
		ventana.setVisible(true);

		// El foco de Windows irá al Canvas, para que directamente podamos controlar
		// este juego, si
		// utilizáramos el teclado
		this.requestFocus();

	}

	/**
	 * Crea la lista de objetos de tipo "cuadro" a mostrar sobre la ventana, con sus
	 * coordenadas La primera fila de 3 cuadros tendrá como coordenadas 0,0 0,1 y
	 * 0,2 La segunda fila de 3 cuadros tendrá como coordenadas 1,0 1,1 y 1,2 La
	 * tercera fila de 3 cuadros tendrá como coordenadas 2,0 2,1 y 2,2
	 */
	private void inicializaCuadrosDelTablero() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.pistas.add(new Pista(j, i));
			}
		}
	}

	private void finalizarPartida() {
		
		if(ganador==1) {
			JOptionPane.showMessageDialog(ventana, "¡¡ Ha ganado el coche 1 !!");
				System.exit(0);
		}
		if(ganador==2) {
			JOptionPane.showMessageDialog(ventana, "¡¡ Ha ganado el coche 2 !!");
			System.exit(0);
		}
	}
	
	private void cerrarAplicacion() {
		String[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(ventana, "¿Desea cerrar la aplicación?", "Salir de la aplicación",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}
	
	/**
	 * Método con el que iniciamos la cantidad de actores que aparecen en el videojuego
	 */
	public void initWorld() {
		// Creo una oleada de 2 Coches
		for (int i = 0; i < 2; i++){
			Coche c = new Coche();
			c.setX((int)(Math.random() * (this.getWidth() - c.getWidth())) ); // Inicializo al azar la posición del eje horizontal del monstruo
			c.setY(i * 20); // Inicializo la posición en el eje vertical, escalonando los monstruos hacia abajo
			c.setVx((int)(Math.random() * (20 - 2) + 2)); // Inicio al azar la velocidad de cada monstruo en el eje horizontal, entre 2 y 20
			actors.add(m); // agrego el nuevo actor a la lista de actores del juego
		}
	}

	/**
	 * Método para devolver la instancia del patrón Singleton
	 * 
	 * @return
	 */
	public static GranPremio getInstance() {
		if (instance == null) {
			instance = new GranPremio();
		}
		return instance;
	}

	private int comprobarGanador() {
		int ganador = 0;
		for (int i = 0; i < matrizJugadas.length; i++) {
			if(matrizJugadas[i][0] == 1 && matrizJugadas[i][1] == 1 && matrizJugadas[i][2] == 1) {
				ganador=1;
			}
			if(matrizJugadas[i][0] == 2 && matrizJugadas[i][1] == 2 && matrizJugadas[i][2] == 2) {
				ganador=2;
			}
		}
		for (int i = 0; i < matrizJugadas.length; i++) {
			if(matrizJugadas[0][i] == 1 && matrizJugadas[1][i] == 1 && matrizJugadas[2][i] == 1) {
				ganador=1;
			}
			if(matrizJugadas[0][i] == 2 && matrizJugadas[1][i] == 2 && matrizJugadas[2][i] == 2) {
				ganador=2;
			}
		}
		
		if(matrizJugadas[0][0] == 1 && matrizJugadas[1][1] == 1 && matrizJugadas[2][2] == 1) {
			ganador=1;
		}
		if(matrizJugadas[0][0] == 2 && matrizJugadas[1][1] == 2 && matrizJugadas[2][2] == 2) {
			ganador=2;
		}
		
		if(matrizJugadas[2][0] == 1 && matrizJugadas[1][1] == 1 && matrizJugadas[0][2] == 1) {
			ganador=1;
		}
		if(matrizJugadas[2][0] == 2 && matrizJugadas[1][1] == 2 && matrizJugadas[0][2] == 2) {
			ganador=2;
		}
		return ganador;
	}
	
	/**
	 * Sobrescribo el método "paint" propio del Canvas, para que cada vez que el SO
	 * o la máquina virtual Java decida repintarlo, nosotros decidamos qué queremos
	 * que se pinte en pantalla
	 */	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// Pinto un rectángulo tan grande como las dimensiones del Canvas
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Pinto cada uno de los cuadros que hay en la lista, delegando en cada uno la
		// responsibilidad de
		// utilizar el objeto Graphics para pintarse a sí mismo en pantalla.
		g.setColor(Color.yellow);
		g.fillOval(30, 200, 30, 30);
		g.drawOval(30, 200, 30, 30);
		g.fillRect(30,400,30,30);
		g.drawRect(30,400,30,30);
	}
	
	// Getters y Setters
	
		public int[][] getMatrizJugadas() {
			return matrizJugadas;
		}

	/**
	 * Método principal del juego, lo único que hace es inicializar un objeto del
	 * tipo TresEnRaya
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GranPremio.getInstance();

	}

}
