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


public class Formula1 extends Canvas {

	private List<Vehiculo> vehiculos= new ArrayList<Vehiculo>(); 
	
	public static int MAX_POSICION_POR_PISTA=100;
	
	private static int WIDTH=800, HEIGHT=800;
	
	private static Formula1 instance = null;
	
	public static Color COLORES[] = new Color[] {Color.BLACK, Color.WHITE, Color.CYAN, Color.DARK_GRAY, Color.GREEN,
			Color.LIGHT_GRAY, Color.MAGENTA};
	
	public Formula1 () {
		//Cargo para que no de lag al cargar 
		SpritesRepository.getInstance();
		SoundsRepository.getInstance();
		
		JFrame ventana =new JFrame("F1 creado por Parlón");
		JPanel panel = (JPanel) ventana.getContentPane();
		panel.setLayout(new BorderLayout());
		panel.add(this, BorderLayout.CENTER);
		ventana.setBounds(0, 0, WIDTH, HEIGHT);
		
		Canvas punteroAThis = this;
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				super.mouseClicked(arg0);
				punteroAThis.repaint();
			}
		});
		
		ventana.setResizable(false);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SoundsRepository.getInstance().loopSound("musicaF1.wav");
		
		// Desactivo el comportamiento por defecto al pulsar el botón de cierre de la
		// ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
	}
	
	public static Formula1 getInstance () {
		if (instance == null) {
			instance = new Formula1();
		}
		return instance;
	}
	
	public void paint (Graphics g) { //  aqui termino de pintar todo, las pistas y los coches y eso
		super.paint(g);
		
		System.out.println("Ancho: " + this.getWidth() +"Alto: " +this.getHeight());
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (Vehiculo v : this.vehiculos) {
			v.paint(g);		}
		
	}
	
	public void initWord() {
		//Creo las 4 pista de mi mundo
		int contadorPistas=4;
		int pixelsAltoPista = this.getHeight() / contadorPistas;
		
		for (int i = 0; i < contadorPistas; i++) {
			Pista pista = new Pista(0, i * pixelsAltoPista, this.getWidth(), pixelsAltoPista);
			
			Vehiculo vehiculo = null;
			if (Math.round(Math.random()) == 0) { // Probabilidad del 50%
				vehiculo = new Coche(pista);
			}
			else {
				vehiculo = new Moto(pista);
			}
			this.vehiculos.add(vehiculo);
		}
	}
	
		
	public void game() {
		do {
			for (Vehiculo v: this.vehiculos) {
				v.act();
			}this.repaint();
			JOptionPane.showMessageDialog(null, "Avance");
		}while(true);
			
	}
	
	public static void main (String args[]) {
		Formula1.getInstance().initWord();
		Formula1.getInstance().game();
	}
}