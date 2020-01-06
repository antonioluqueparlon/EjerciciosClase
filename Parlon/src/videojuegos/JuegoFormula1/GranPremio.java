package videojuegos.JuegoFormula1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GranPremio extends Canvas {

	// Ventana principal del juego
	JFrame ventana = new JFrame("Formula 1 creado por Parlon");

	// Indicamos alto y ancho del objeto tipo Canvas
	private static final int JFRAME_WIDTH=700;
	private static final int JFRAME_HEIGHT=700;	
	
	// Variable para establecer la instancia del patr�n singleton
	private static GranPremio instance = null;
	
	/**
	 * Constructor, inicializa y monta la ventana
	 */
	public GranPremio() {
		
		// Obtengo referencia al panel principal de la ventana
		JPanel panel = (JPanel) ventana.getContentPane();
				// Establezco una plantilla en el panel, para poder incorporar el Canvas
		panel.setLayout(new BorderLayout());
				// Agrego el Canvas al panel
		panel.add(this, BorderLayout.CENTER);
		// Dimensiono la ventana
		ventana.setBounds(0,0, JFRAME_WIDTH, JFRAME_HEIGHT);
		
		// Desactivo el comportamiento por defecto al pulsar el bot�n de cierre de la ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// Agrego un escuchador a la ventana, para detectar el evento de cierre de la misma
		ventana.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
		
		// Muestro la ventana en pantalla
		ventana.setVisible(true);
		
		// El foco de Windows ir� al Canvas, para que directamente podamos controlar este juego, si 
		// utiliz�ramos el teclado
		this.requestFocus();
	}
	
	//Metodo para devolver la instancia del patron Singleton
	
	public static GranPremio getInstance () {
		if (instance == null) {
			instance = new GranPremio();
		}
		return instance;
	}
	
	//Al cerrar preguntaremos al usuario si est� seguro de salir del juego
	
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
	 * Sobrescribo el m�todo "paint" propio del Canvas, para que cada vez que el SO o la m�quina virtual Java
	 * decida repintarlo, nosotros decidamos qu� queremos que se pinte en pantalla
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// Pinto un rect�ngulo tan grande como las dimensiones del Canvas
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	/**
	 * M�todo principal del juego, lo �nico que hace es inicializar un objeto del tipo TresEnRaya
	 * @param args
	 */
	public static void main(String[] args) {
		
		GranPremio.getInstance();

	}

}
