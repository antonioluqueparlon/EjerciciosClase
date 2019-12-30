package tresEnRaya.version1LaVentana;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TresEnRaya extends Canvas {
	
	
	//Creo la ventana del juego 
	JFrame ventanaDelJuego = new JFrame ("3 en raya creado por Parlon");

	
	//Ancho y alto de la ventana
	private static final int JFRAME_WIDTH=700;
	private static final int JFRAME_HEIGHT=700;
	
	
	
	//Creo el constructor que me va a montar el juego
	
	public TresEnRaya( ) {
		
		//Creo el panel que se va a crear respecto a mi ventana del juego
		JPanel panel = (JPanel) ventanaDelJuego.getContentPane();
		
		//Le añado el layout al panel (esto siempre con los paneles) layout=plantilla
		panel.setLayout(new BorderLayout());
		
		//Le agrego al panel el Canvas
		panel.add(this,BorderLayout.CENTER);
		
		//Le pongo el tamaño a la ventana
		ventanaDelJuego.setBounds(300,150,JFRAME_WIDTH,JFRAME_HEIGHT);
		
		//Quito el comportamiento normal de cerrar ventana al pulsar X
		ventanaDelJuego.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//Para que me detecte este hecho, le añado un escuchador
		ventanaDelJuego.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
	
		//Muestro la ventana
		ventanaDelJuego.setVisible(true);
		
	}
	
	//Creo un metodo que me pregunte que hacer cuando le de al boton de cerrar aplicacion
	protected void cerrarAplicacion() {
		String [] opciones = {"Aceptar" , "Cancelar"};
		int eleccion = (JOptionPane.showOptionDialog(ventanaDelJuego, "¿Desea salir del juego?", "Salir del juego", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar"));
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}

	
	//Sobreescribo el metodo canvas para que yo decida lo que se pinta en la ventana
	@Override
	public void paint (Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

//Metodo principal que lo que hace es inicializar el juego
	public static void main(String[] args) {
		
	TresEnRaya tresEnRaya = new  TresEnRaya();
	}

}
