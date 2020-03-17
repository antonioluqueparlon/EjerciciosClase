package ejerciciosTutorial.capitulo8.ConsultasBBDDSWIN;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelGestionCoche extends JPanel {
	double pesoCol1 = 0.25, pesoCol2 = 1;
	
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	JTextField jtfId = new JTextField();
	JComboBox<String> jcbFabricante = new JComboBox<String>();	
	JTextField jtfBastidor = new JTextField();
	JTextField jtfModelo = new JTextField();
	JTextField jtfColor = new JTextField();
	JButton jbtNavPrimero = new JButton();
	JButton jbtNavAnterior = new JButton();
	JButton jbtNavUltimo = new JButton();	
	JButton jbtNavSiguiente = new JButton();
	
	Coche coche = new Coche();


	
	
	
	
	/**
	 * 
	 */
	public PanelGestionCoche () {
		this.setLayout(new GridBagLayout());
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		//Incorporamos los components del Id 
		colocaComponente(0, 0, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel ("Id: "), gridBagConstraints);
		colocaComponente(0, 0, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfId, gridBagConstraints);
				
		//Incorporamos el fabricante
		colocaComponente(0, 1, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel ("Fabricante: "), gridBagConstraints);
		colocaComponente(0, 1, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jcbFabricante, gridBagConstraints);
		
		//Incorporamos el bastidor
		colocaComponente(0, 2, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel ("Bastidor: "), gridBagConstraints);
		colocaComponente(0, 2, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jcbFabricante, gridBagConstraints);
				
				//Incorporamos el modelo
		colocaComponente(0, 3, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel ("Modelo: "), gridBagConstraints);
		colocaComponente(0, 3, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfModelo, gridBagConstraints);		
					
			//Incorporamos el color
		colocaComponente(0, 4, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel ("Color: "), gridBagConstraints);
		colocaComponente(0, 4, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfColor, gridBagConstraints);	
		
		//Incorporamos fila botones
		colocaComponente(0, 5, GridBagConstraints.NORTH, 1, 1, GridBagConstraints.BOTH);
		gridBagConstraints.gridwidth = 2;
		this.add(getBotonera(), gridBagConstraints);
		
	
	}
	
	private JPanel getBotonera() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.setBackground(Color.YELLOW);
		
		configurarBoton(jbtNavPrimero, "gotostart.png", new ActionListener () {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAPrimero();
			}
		});
		
		configurarBoton(jbtNavAnterior, "gotostart.png", new ActionListener () {
					
		
					@Override
					public void actionPerformed(ActionEvent e) {
						navegaAAnterior();
					}
				});
		
		configurarBoton(jbtNavSiguiente, "gotostart.png", new ActionListener () {
			
		
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaASiguiente();
			}
		});
		
		configurarBoton(jbtNavUltimo, "gotostart.png", new ActionListener () {
			
		
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAUltimo();
			}
		});
		
		//Incluimos los botones
	
		
		panel.add(jbtNavPrimero);
		panel.add(jbtNavAnterior);
		panel.add(jbtNavSiguiente);
		panel.add(jbtNavUltimo);
		
		return panel;
		

	}
	
	private void navegaAPrimero() {
		coche = ControladorBBDDCoche.getPrimerCoche();
		cargaCocheEnComponentesVisuales();
	}
	
	private void navegaAAnterior() {
		System.out.println("Primero");
	}
	
	private void navegaASiguiente() {
		System.out.println("Primero");
	}
	private void navegaAUltimo() {
		System.out.println("Primero");
	}
	
	private void cargaCocheEnComponentesVisuales () {
		this.jtfId.setText("" + coche.getId());
		this.jtfModelo.setText(""+ coche.getModelo());
		this.jtfColor.setText(coche.getColor());
		this.jtfBastidor.setText(coche.getBastidor());
	}
	
	private JButton configurarBoton (JButton jbt, String img, ActionListener actionListener) {
		//jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono (img));
		jbt.addActionListener(actionListener);
		return jbt;
	}
	
	/**
	 * 
	 * @param gridX
	 * @param gridY
	 * @param pesoColumna
	 * @param pesoFila
	 * @param fill
	 */
	private void colocaComponente (int gridX, int gridY, int anchor, double pesoColumna, int pesoFila, int fill) { 
		gridBagConstraints.gridx = gridX;
		gridBagConstraints.gridy = gridY;
		gridBagConstraints.weightx = pesoColumna;
		gridBagConstraints.weighty = pesoFila;
		gridBagConstraints.fill = fill;
		gridBagConstraints.anchor = anchor;
		
	}
}
