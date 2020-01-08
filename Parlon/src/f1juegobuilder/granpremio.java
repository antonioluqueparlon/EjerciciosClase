package f1juegobuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class granpremio extends JFrame {

	private JFrame frame;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					granpremio window = new granpremio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	
	public granpremio() {
		initialize();
	}
	public JLabel getlblCoche () {
		return getlblCoche();
	}
	public JLabel getlblCoche2 () {
		return getlblCoche2();
	}
	
	public JLabel getlblMeta () {
		return getlblMeta();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Formula 1 creado por Parlón");
		frame.setBounds(100, 100, 700, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 51, 664, 278);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCoche = new JLabel("coche1");
		lblCoche.setIcon(new ImageIcon(granpremio.class.getResource("/videojuegos/tresEnRaya/resources/images/coche2.png")));
		lblCoche.setBounds(10, 44, 169, 59);
		panel.add(lblCoche);
		
		JLabel lblCoche2 = new JLabel("coche2");
		lblCoche2.setIcon(new ImageIcon(granpremio.class.getResource("/videojuegos/tresEnRaya/resources/images/coche2.png")));
		lblCoche2.setBounds(10, 171, 169, 59);
		panel.add(lblCoche2);
		
		JLabel lblMeta = new JLabel("meta");
		lblMeta.setForeground(Color.RED);
		lblMeta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeta.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		lblMeta.setBounds(608, 11, 46, 256);
		panel.add(lblMeta);
		
		JLabel lblCarreraDeCoches = new JLabel("CARRERA DE COCHES DE FORMULA 1");
		lblCarreraDeCoches.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarreraDeCoches.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCarreraDeCoches.setBounds(219, 11, 249, 29);
		frame.getContentPane().add(lblCarreraDeCoches);
		
		JButton btnIniciarCarrera = new JButton("INICIAR CARRERA");
		btnIniciarCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCoche.setLocation(0,lblCoche.getLocation().y);
				lblCoche2.setLocation(0,lblCoche2.getLocation().y);
				Carrera hilo1= new Carrera(lblCoche,this);
				Carrera hilo2= new Carrera(lblCoche2,this);
				hilo1.start();
				hilo2.start();
			}
		});
		btnIniciarCarrera.setBounds(279, 361, 141, 23);
		frame.getContentPane().add(btnIniciarCarrera);
	}
	

}
