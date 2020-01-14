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
	
	private static Formula1 instance = null;
	
	public Formula1 () {
		JFrame ventana =new JFrame("F1 creado por Parlón");
		JPanel panel = (JPanel) ventana.getContentPane();
		panel.setLayout(new BorderLayout());
		panel.add(this, BorderLayout.CENTER);
		ventana.setBounds(0, 0, 800, 800);
		
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
		
	}
	
	public static Formula1 getInstance () {
		if (instance == null) {
			instance = new Formula1();
		}
		return instance;
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		
	}
	
	public void initWord() {
		//Creo las 4 pista de mi mundo
		int contadorPistas=4;
		for (int i = 0; i < contadorPistas; i++) {
			
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