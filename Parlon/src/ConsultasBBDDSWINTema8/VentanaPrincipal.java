package ejerciciosTutorial.capitulo8.ConsultasBBDDSWIN;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	
	public VentanaPrincipal () {

		this.setBounds(0, 0, 500, 500);;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		this.setContentPane(new PanelGestionCoche());
	}

}
