package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import videojuegos.JuegoFormula1.GranPremio;


public class Arkanoid {
	//Dimensiones de la ventana del juego
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	//Patron singleton
	private static Arkanoid instance = null;
	
	public static Arkanoid getInstance() {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}
	
	public Arkanoid() {
		
	}
	
	
	
	
	public void paint (Graphics g) {
		super.paint(g);
		//Pinto un rectangulo tan grande como el Canvas
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.get, this.HEIGHT);
	}
	
	public static void main(String[] args) {
		Arkanoid.getInstance();
	}
}
