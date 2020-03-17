package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_GestionEntidadCoche.gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	public VentanaPrincipal () {
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane jtabbedPane = new JTabbedPane();
		
		jtabbedPane.add("Gestión de coches", new PanelGestionCoche());
		jtabbedPane.add("Gestión de fabricantes", new PanelGestionFabricante());
		jtabbedPane.add("Gestión de concesionarios", new PanelGestionConcesionarios());
		jtabbedPane.add("Gestión de clientes", new PanelGestionCliente());
		
		
		
		
		
		this.setContentPane(jtabbedPane);
	}
	
}
