package definitivof1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.Content;

import javafx.scene.layout.Background;
import videojuegos.tresEnRaya.SoundsRepository;
import videojuegos.tresEnRaya.SpritesRepository;

/**
 * @author Antonio Luque
 * 
 * Clase principal del juego, contiene la ventana y, al mismo tiempo, es el objeto Canvas sobre el que
 * se redibuja continuamente el juego. Tiene la lista de actores. Para el repintado de escena utiliza
 * la t�cnica de doble b�ffer, a trav�s del objeto BufferStrategy
 *
 */

public class GranPremio extends Canvas {
	
	// Ventana principal del juego
	JFrame ventana = new JFrame("F1 hecho por Parl�n");
	
	// Indicamos alto y ancho del objeto tipo Canvas
	private static final int JFRAME_WIDTH=900;
	private static final int JFRAME_HEIGHT=900;
	private int ganador = 0;
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormir� 10 millis
	// tras haber repintado la escena
	public static final int SPEED_FPS=60;
	
	// Lista con todos los actores que intervienen en el videojuego
	private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>(); 
	
	// BufferStrategy usado para conseguir la t�cnica de doble b�ffer
	private BufferStrategy strategy;
	private long usedTime; // Tiempo usado en cada iteraci�n del bucle principal del juego.
	
	// Instancia para patr�n Singleton
	private static GranPremio instance = null;
	
	/**
	 * Constructor: crea la ventana, obtiene una referencia al panel principal, introduce el Canvas en su interior
	 * y habilita y deshabilita varios comportamientos de la ventana
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
		ventana.setBounds(0,0, JFRAME_WIDTH, JFRAME_HEIGHT);
		// Muestro la ventana en pantalla
		ventana.setVisible(true);
		// Desactivo el comportamiento por defecto al pulsar el bot�n de cierre de la ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// Agrego un escuchador a la ventana, para detectar el evento de cierre de la misma
		ventana.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
		// Con ignoreRepaint le decimos al JFrame que no debe repintarse cuando el Sistema Operativo se lo indique,
		// nosotros nos ocupamos totalmente del refresco de la pantalla
		ventana.setIgnoreRepaint(true);
		// El Canvas se dibujar� en pantalla con una estrategia de doble b�ffer
		this.createBufferStrategy(2);
		// Obtengo una referencia a la estrategia de doble b�ffer.
		strategy = getBufferStrategy();
		// El foco de Windows ir� al Canvas, para que directamente podamos controlar este juego a trav�s del teclado
		this.requestFocus();
		
		// Lanzo un sonido en bucle que sonar� todo el tiempo
		SoundsRepository.getInstance().loopSound("musicaF1.wav");
	}
	
	/**
	 * M�todo de obtenci�n de patr�n Singleton
	 * @return
	 */
	public static GranPremio getInstance () {
		if (instance == null) {
			instance = new GranPremio();
		}
		return instance;
	}
	
	private void finalizarPartida() {
		
		if(ganador==1) {
			JOptionPane.showMessageDialog(ventana, "� Ha ganado El logo de la F1 !");
				System.exit(0);
		}
		if(ganador==2) {
			JOptionPane.showMessageDialog(ventana, "� Ha ganado el coche !");
			System.exit(0);
		}
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
	
	private void representarObstaculos() {
		ArrayList<Obstaculo> obstaculos;
		Pista p;
		Obstaculo o;
	}
	
	/**
	 * M�todo con el que iniciamos la cantidad de actores que aparecen en el videojuego
	 */
	public void iniciarcarrera() {
		// Creo una carrera de 2 Coches
		for (int i = 1; i < 3; i++){
			Coche m = new Coche();
			m.setX((int)(100)); // Inicializo al azar la posici�n del eje horizontal del monstruo
			m.setY((i*250)); // Inicializo la posici�n en el eje vertical, escalonando los monstruos hacia abajo
			m.setVx((int)(Math.random() * (20 - 16) + 2)); // Inicio al azar la velocidad de cada coche en el eje horizontal
			vehiculos.add(m); // agrego el nuevo coche a la lista de vehiculos del juego
		}
	}
	
	/**
	 * Este m�todo actualiza la posici�n y valores de los diferentes vehiculos del juego, se ejecuta en cada iteraci�n.
	 */
	public void updateWorld() {
		// B�sicamente, se llama al m�todo "act" de cada vehiuclo, para que cada uno recalcule por si mismo sus valores.
		for (Vehiculo vehiculo : this.vehiculos) {
			vehiculo.act();
		}
	}
	
	/**
	 * M�todo responsable del pintado de toda la escena, se ejecuta una vez por cada ciclo del programa
	 */
	public void paintWorld() {
		// Resuelve un problema de sincronizaci�n de memoria de v�deo en Linux
		Toolkit.getDefaultToolkit().sync();
		// Obtengo el objeto gr�fico que me permita pintar en el doble b�ffer
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		// Pinto un rect�ngulo negro que sera el fondo
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Para cada vehiculo del juego, le pido que se pinte a s� mismo
		for (Vehiculo vehiculo : this.vehiculos) {
			vehiculo.paint(g);
		}
		
	
		
		strategy.show();
	}
	
	/**
	 * M�todo principal del juego, con el bucle cont�nuo que refresca el mismo en cada FPS
	 */
	public void game() {
		// Inicializaci�n del juego
		iniciarcarrera();
		
		// El bucle se ejecutar� mientras el objeto Canvas sea visible
		while (isVisible()) {
			long startTime = System.currentTimeMillis(); // Tomo el tiempo, en millis, antes de crear el siguiente Frame del juego
			// actualizo y pinto la escena
			updateWorld(); 
			paintWorld();
			// Calculo el tiempo que se ha tardado en la ejecuci�n
			usedTime = System.currentTimeMillis()-startTime;
			// Hago que el bucle pare una serie de millis, antes de generar el siguiente FPS
			// El c�lculo hecho "duerme" el proceso para no generar m�s de los SPEED_FPS que se haya espec�ficado
			try { 
				int millisToSleep = (int) (1000/SPEED_FPS - usedTime);
				if (millisToSleep < 0) {
					millisToSleep = 0;
				}
				Thread.sleep(millisToSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	/**
	 * M�todo principal del juego
	 * @param args
	 */
	public static void main(String[] args) {
		GranPremio.getInstance().game();
	}
}
