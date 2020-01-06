package videojuegos.tresEnRaya;

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

public class TresEnRaya extends Canvas {
	
	int ganador;
	
	//Creo la ventana del juego 
	JFrame ventanaDelJuego = new JFrame ("3 en Raya creado por Parlon");

	
	//Ancho y alto de la ventana
	private static final int JFRAME_WIDTH=700;
	private static final int JFRAME_HEIGHT=700;
	
	//Creo la lista de los cuadros
	List<Cuadro> cuadros = new ArrayList<Cuadro>();
	
	// Variable para establecer la instancia del patrón singleton
		private static TresEnRaya instance = null;
		
	//Creo el turno de mis juagdores
	public static int JUGADOR_1=1;
	public static int JUGADOR_2=2;
	private int turnoActual=JUGADOR_1;
	
	//Creo la matriz dde jugadas
	private int matrizJugadas[][]= {{0,0,0},{0,0,0},{0,0,0}};
	
	//Creo el constructor que me va a montar el juego
	
	/**
	 * @return the matrizJugadas
	 */
	public int[][] getMatrizJugadas() {
		return matrizJugadas;
	}
	
 private int comprobarGanador() {
	 ganador=0;
	for (int i = 0; i < matrizJugadas.length; i++) {
		if(matrizJugadas[i][0] == 1 && matrizJugadas[i][1] == 1 && matrizJugadas[i][2]==1) {
			ganador=1;
		}
		if(matrizJugadas[i][0] == 2 && matrizJugadas[i][1] == 2 && matrizJugadas[i][2]==2) {
			ganador=2;
		}
	}
	for (int i = 0; i < matrizJugadas.length; i++) {
		if(matrizJugadas[0][i] == 1 && matrizJugadas[1][i] == 1 && matrizJugadas[2][i]==1) {
			ganador=1;
		}
		if(matrizJugadas[0][i] == 2 && matrizJugadas[1][i] == 2 && matrizJugadas[2][i]==2) {
			ganador=2;
		}
	}
	
	if(matrizJugadas[0][0] == 1 && matrizJugadas[1][1] == 1 && matrizJugadas[2][2]==1) {
		ganador=1;
	}
	if(matrizJugadas[0][0] == 2 && matrizJugadas[1][1] == 2 && matrizJugadas[2][2]==2) {
		ganador=2;
	}
	
	if(matrizJugadas[2][0] == 1 && matrizJugadas[1][1] == 1 && matrizJugadas[0][2]==1) {
		ganador=1;
	}
	if(matrizJugadas[2][0] == 2 && matrizJugadas[1][1] == 2 && matrizJugadas[0][2]==2) {
		ganador=2;
	}
	return ganador;
	
	
 }
 
	/**
	 * @param matrizJugadas the matrizJugadas to set
	 */
	public void setMatrizJugadas(int[][] matrizJugadas) {
		this.matrizJugadas = matrizJugadas;
	}
	
	
              
	public TresEnRaya( ) {
		
		//Cargo los recursos primero
				SoundsRepository.getInstance();
				SpritesRepository.getInstance();
		
		//Creo el panel que se va a crear respecto a mi ventana del juego
		JPanel panel = (JPanel) ventanaDelJuego.getContentPane();
		
		//Le añado el layout al panel (esto siempre con los paneles) layout=plantilla
		panel.setLayout(new BorderLayout());
		
		//Le agrego al panel el Canvas
		panel.add(this,BorderLayout.CENTER);
		
		//Le pongo el tamaño a la ventana
		ventanaDelJuego.setBounds(300,150,JFRAME_WIDTH,JFRAME_HEIGHT);
		
		//Inicializos los cuadrados para mostrarlos en la pantalla
		
		comprobarGanador();
		GanadorJuego();
		inicializaCuadrosPantalla();
		
		
		
		
		
		
		//Hago que el juego escuche al raton y muestre que estoy haciendo click
		//en un cuadro
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// Sólo nos interesa el clic con el botón principal del ratón
				if (e.getButton() == MouseEvent.BUTTON1) {
					for (Cuadro cuadro : cuadros) {
						if (cuadro.seHaHechoClickSobreCuadro(e.getX(), e.getY())) {
							cuadro.click(turnoActual);
							//Hago cambio de turno
							if(turnoActual==JUGADOR_1) {
								//pongo sonido
								SoundsRepository.getInstance().playSound("item.wav");
								//cambio turno
								turnoActual=JUGADOR_2;
							}
								else {
									//pongo sonido
									SoundsRepository.getInstance().playSound("motorf1.wav");
									//cambio el turno
									turnoActual=JUGADOR_1;
								}
							}
					}
				}
			}
		});
		
		//pongo la musica de fondo
		SoundsRepository.getInstance().loopSound("musicaF1.wav");
		
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
	
	/**
	 * Método para devolver la instancia del patrón Singleton
	 * @return
	 */
	public static TresEnRaya getInstance () {
		if (instance == null) {
			instance = new TresEnRaya();
		}
		return instance;
	}
	
	//Creo un metodo que me pregunte que hacer cuando le de al boton de cerrar aplicacion
	private void cerrarAplicacion() {
		String [] opciones = {"Aceptar" , "Cancelar"};
		int eleccion = (JOptionPane.showOptionDialog(ventanaDelJuego, "¿Desea salir del juego?", "Salir del juego", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar"));
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}
	
	private void inicializaCuadrosPantalla() {
		for (int i = 0; i < 3 ; i++) {
			for (int j = 0; j < 3 ; j++) {
				this.cuadros.add(new Cuadro(j,i));	
			}
		}
	}
	
	//Creo un metodo que me diga el ganador
	protected void GanadorJuego() {
				
					JOptionPane.showMessageDialog(ventanaDelJuego, "Ha ganado el " + ganador + "");

					System.exit(0);
				}
			
				

	
	//Sobreescribo el metodo canvas para que yo decida lo que se pinta en la ventana
	@Override
	public void paint (Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//Pinto los bordes de los cuadros
		for (Cuadro cuadro:cuadros) {
			cuadro.paint(g);
		}
	}

//Metodo principal que lo que hace es inicializar el juego
	public static void main(String[] args) {
		
		TresEnRaya.getInstance();
	}

}
