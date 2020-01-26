package videojuegos.Arkanoid.version1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Arkanoid extends Canvas {
	
	// Ventana principal del juego
	JFrame ventana = new JFrame("Arkanoid de Parlón");
	
	// Indicamos alto y ancho del objeto tipo Canvas
	private static final int JFRAME_WIDTH=800;
	private static final int JFRAME_HEIGHT=600;
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormirá 10 millis
	// tras haber repintado la escena
	public static final int FPS=60;
	
	// Lista con todos los actores que intervienen en el videojuego
	private List<Actor> actores = new ArrayList<Actor>(); 
	
	// BufferStrategy usado para conseguir la técnica de doble búffer
	private BufferStrategy strategy;
	 
	// Instancia para patrón Singleton
	private static Arkanoid instance = null;
	
	//Array de colores de los ladrillos
	public static Color ArrayColores[]= new Color[] {Color.BLACK, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GREEN,
		Color.RED, Color.PINK} ;
	
	
	/**
	 * @return the arrayColores
	 */
	public static Color[] getArrayColores() {
		return ArrayColores;
	}

	/**
	 * @param arrayColores the arrayColores to set
	 */
	public static void setArrayColores(Color[] arrayColores) {
		ArrayColores = arrayColores;
	}

	public Arkanoid() {
		// Creación de la ventana
			ventana = new JFrame("Arkanoid de Parlón");
			// Obtenemos el panel principal del JFrame
			JPanel panel = (JPanel) ventana.getContentPane();
			// Utilizo un BorderLayout para colocar el Canvas sobre el JPanel
			panel.setLayout(new BorderLayout());
			// Agregamos el Canvas al panel de manera que ocupe todo el espacio disponible
			panel.add(this, BorderLayout.CENTER);
			// Dimensionamos el JFrame
			ventana.setBounds( 0, 0, JFRAME_WIDTH, JFRAME_HEIGHT);
			// Hacemos el JFrame visible
			ventana.setVisible(true);
			// Con el siguiente código preguntamos al usuario si realmente desea cerrar la aplicación, cuando
			// pulse sobre el aspa de la ventana
			ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			ventana.addWindowListener( new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					cerrarAplicacion();
				}
			});
			// Creación de la estrategia de doble búffer
			this.createBufferStrategy(2);
			strategy = this.getBufferStrategy();
			// Con ignoreRepaint le decimos al JFrame que no debe repintarse cuando el Sistema Operativo se lo indique,
			// nosotros nos ocupamos totalmente del refresco de la pantalla
			ventana.setIgnoreRepaint(true);
			// La ventana no podrá redimensionarse
			ventana.setResizable(false);
			// Hacemos que el Canvas obtenga automáticamente el foco del programa para que, si se pulsa una tecla, la pulsación
			// se transmita directamente al Canvas.
			this.requestFocus();
			// Para resolver un problema de sincronización con la memoria de vídeo de Linux, utilizamos esta línea
			}
	
	public static Arkanoid getInstance() {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
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
	
	public void initWorld () {
		
		//this.actores.add(new Ladrillos());
		this.actores.add(new Pelota());
		this.actores.add(new Nave());
		crearLadrillos();
		
	}
	
	private void updateWorld() {
		for (Actor actor : this.actores) {
			actor.act();}
	}
	
private void crearLadrillos() {
		
		int coordenadaXdondeEmpiezanLosLadrillos=50;
		int coordenadaYdondeEmpiezanLosLadrillos=10;
		for (int i = 0; i < 5 ;i++) {
			for (int j = 0; j < 20; j++) {
				
				Ladrillos ladrillo1 = new Ladrillos(); // creo ladrillo
				ladrillo1.setX(coordenadaXdondeEmpiezanLosLadrillos);
				ladrillo1.setY(coordenadaYdondeEmpiezanLosLadrillos);
				this.actores.add(ladrillo1); // guardo el ladrillo para que no se pierda
				coordenadaXdondeEmpiezanLosLadrillos +=35;
			}
			coordenadaYdondeEmpiezanLosLadrillos += 40;
			coordenadaXdondeEmpiezanLosLadrillos = 50;
		}
	}
			
	
	public void game () {
			// Inicialización del juego
			initWorld();
			// Este bucle se ejecutará mientras el objeto Canvas sea visible.
			while (this.isVisible()) {
				// Tomamos el tiempo en milisegundos antes de repintar el frame
				long millisAntesDeConstruirEscena = System.currentTimeMillis();
				// Actualizamos y pintamos el nuevo frame
				updateWorld();
				paint();
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
	
	public void paint() {
			Toolkit.getDefaultToolkit().sync();
			// Obtenemos el objeto Graphics (la brocha) desde la estrategia de doble búffer
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			// Lo primero que hace cada frame es pintar un rectángulo tan grande como la escena,
			// para superponer la escena anterior.
			g.setColor(Color.black);
			g.fillRect( 0, 0, getWidth(), getHeight());

			// Ejecutamos el método paint de cada uno de los actores
			for (Actor actor : this.actores) {
				actor.paint(g);
			}
			// Una vez construida la escena nueva, la mostramos.
			strategy.show();
		}
	
	
	public static void main(String[] args) {
		Arkanoid.getInstance().game();
		
	}
}
