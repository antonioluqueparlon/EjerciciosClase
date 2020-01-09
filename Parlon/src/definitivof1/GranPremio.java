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
 * la técnica de doble búffer, a través del objeto BufferStrategy
 *
 */

public class GranPremio extends Canvas {
	
	// Ventana principal del juego
	JFrame ventana = new JFrame("F1 hecho por Parlón");
	
	// Indicamos alto y ancho del objeto tipo Canvas
	private static final int JFRAME_WIDTH=900;
	private static final int JFRAME_HEIGHT=900;
	private int ganador = 0;
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormirá 10 millis
	// tras haber repintado la escena
	public static final int SPEED_FPS=60;
	
	// Lista con todos los actores que intervienen en el videojuego
	private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>(); 
	
	// BufferStrategy usado para conseguir la técnica de doble búffer
	private BufferStrategy strategy;
	private long usedTime; // Tiempo usado en cada iteración del bucle principal del juego.
	
	// Instancia para patrón Singleton
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
		// Desactivo el comportamiento por defecto al pulsar el botón de cierre de la ventana
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
		// El Canvas se dibujará en pantalla con una estrategia de doble búffer
		this.createBufferStrategy(2);
		// Obtengo una referencia a la estrategia de doble búffer.
		strategy = getBufferStrategy();
		// El foco de Windows irá al Canvas, para que directamente podamos controlar este juego a través del teclado
		this.requestFocus();
		
		// Lanzo un sonido en bucle que sonará todo el tiempo
		SoundsRepository.getInstance().loopSound("musicaF1.wav");
	}
	
	/**
	 * Método de obtención de patrón Singleton
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
			JOptionPane.showMessageDialog(ventana, "¡ Ha ganado El logo de la F1 !");
				System.exit(0);
		}
		if(ganador==2) {
			JOptionPane.showMessageDialog(ventana, "¡ Ha ganado el coche !");
			System.exit(0);
		}
	}
	
	/**
	 * Al cerrar la aplicación preguntaremos al usuario si está seguro de que desea salir.
	 */
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
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
	 * Método con el que iniciamos la cantidad de actores que aparecen en el videojuego
	 */
	public void iniciarcarrera() {
		// Creo una carrera de 2 Coches
		for (int i = 1; i < 3; i++){
			Coche m = new Coche();
			m.setX((int)(100)); // Inicializo al azar la posición del eje horizontal del monstruo
			m.setY((i*250)); // Inicializo la posición en el eje vertical, escalonando los monstruos hacia abajo
			m.setVx((int)(Math.random() * (20 - 16) + 2)); // Inicio al azar la velocidad de cada coche en el eje horizontal
			vehiculos.add(m); // agrego el nuevo coche a la lista de vehiculos del juego
		}
	}
	
	/**
	 * Este método actualiza la posición y valores de los diferentes vehiculos del juego, se ejecuta en cada iteración.
	 */
	public void updateWorld() {
		// Básicamente, se llama al método "act" de cada vehiuclo, para que cada uno recalcule por si mismo sus valores.
		for (Vehiculo vehiculo : this.vehiculos) {
			vehiculo.act();
		}
	}
	
	/**
	 * Método responsable del pintado de toda la escena, se ejecuta una vez por cada ciclo del programa
	 */
	public void paintWorld() {
		// Resuelve un problema de sincronización de memoria de vídeo en Linux
		Toolkit.getDefaultToolkit().sync();
		// Obtengo el objeto gráfico que me permita pintar en el doble búffer
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		// Pinto un rectángulo negro que sera el fondo
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Para cada vehiculo del juego, le pido que se pinte a sí mismo
		for (Vehiculo vehiculo : this.vehiculos) {
			vehiculo.paint(g);
		}
		
	
		
		strategy.show();
	}
	
	/**
	 * Método principal del juego, con el bucle contínuo que refresca el mismo en cada FPS
	 */
	public void game() {
		// Inicialización del juego
		iniciarcarrera();
		
		// El bucle se ejecutará mientras el objeto Canvas sea visible
		while (isVisible()) {
			long startTime = System.currentTimeMillis(); // Tomo el tiempo, en millis, antes de crear el siguiente Frame del juego
			// actualizo y pinto la escena
			updateWorld(); 
			paintWorld();
			// Calculo el tiempo que se ha tardado en la ejecución
			usedTime = System.currentTimeMillis()-startTime;
			// Hago que el bucle pare una serie de millis, antes de generar el siguiente FPS
			// El cálculo hecho "duerme" el proceso para no generar más de los SPEED_FPS que se haya específicado
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
	 * Método principal del juego
	 * @param args
	 */
	public static void main(String[] args) {
		GranPremio.getInstance().game();
	}
}
