package videojuegos.Arkanoid.version1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Arkanoid extends Canvas {
	
	private List<Actor> actores = new ArrayList<Actor>();
	
	JFrame ventana= new JFrame("Arkanoid de Parlón");

	private long usedTime;
	//Dimensiones de la ventana del juego
	public static final int JFRAME_WIDTH = 800;
	public static final int JFRAME_HEIGHT = 600;
	
	public static final int SPEED_FPS=60;
	
	//Patron singleton
	private static Arkanoid instance = null;
	
	public Arkanoid() {
		// Obtengo referencia al panel principal de la ventana
				JPanel panel = (JPanel) ventana.getContentPane();
				// Establezco una plantilla en el panel, para poder incorporar el Canvas
				panel.setLayout(new BorderLayout());
				// Agrego el Canvas al panel
				panel.add(this,BorderLayout.CENTER);
				// Dimensiono la ventana
				ventana.setBounds(0,0, JFRAME_WIDTH, JFRAME_HEIGHT);
				
				// Desactivo el comportamiento por defecto al pulsar el botón de cierre de la ventana
				ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				// Agrego un escuchador a la ventana, para detectar el evento de cierre de la misma
				ventana.addWindowListener( new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						cerrarAplicacion();
					}
				});
				// Muestro la ventana en pantalla
				ventana.setVisible(true);
				// El foco de Windows irá al Canvas, para que directamente podamos controlar este juego, si 
				// utilizáramos el teclado
				this.requestFocus();

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
	
	
	
	
	public void paint (Graphics g) {
		super.paint(g);
		//Pinto un rectangulo tan grande como el Canvas
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//pinto a los actores 
		for (Actor a : this.actores) {
			a.paint(g);
		}
						
	}
	
	public void initworld () {
		this.actores.add(new Ladrillos());
		this.actores.add(new Pelota());
		this.actores.add(new Nave());
	}
	
	public void game () {
		// Inicialización del juego
			initworld();
				
			// El bucle se ejecutará mientras el objeto Canvas sea visible
			while (isVisible()) {
					long startTime = System.currentTimeMillis(); // Tomo el tiempo, en millis, antes de crear el siguiente Frame del juego
					// actualizo y pinto la escena
					updateWorld(); 
					repaint();
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
	private void updateWorld() {
		for (Actor a : this.actores) {
			a.act();}
	}
	
	
	
	
	public static void main(String[] args) {
		Arkanoid.getInstance().game();
		
	}
}
