package videojuegos.Arkanoid.version1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class Arkanoid extends Canvas {
	
	// Ventana principal del juego
	JFrame ventana = new JFrame("Arkanoid de Parl�n");
	
	// Indicamos alto y ancho del objeto tipo Canvas
	public static final int JFRAME_WIDTH=564;
	public static final int JFRAME_HEIGHT=800;
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormir� 10 millis
	// tras haber repintado la escena
	public static final int FPS=120;
	
	// Lista con todos los actores que intervienen en el videojuego
	List<Actor> actores = new ArrayList<Actor>(); 
	List<Actor> nuevosactores = new ArrayList<Actor>();// las explosiones
	// BufferStrategy usado para conseguir la t�cnica de doble b�ffer
	private BufferStrategy strategy;
	 
	// Instancia para patr�n Singleton
	private static Arkanoid instance = null;
	
	
	// Referencia que guardaremos apuntando al objeto de tipo Player
	Nave nave = null;
	Pelota pelota= null;
		
	//Niveles del juego
	Fase faseActiva=null;
	boolean activo=false;
		
	int vidas=3;
	boolean inmortal=false;
	boolean fastidio=false;
	int puntos=0;
	boolean nivelFinal = false;
	boolean nivel1Acabado = false;
	

	public Arkanoid() {
		// Creaci�n de la ventana
			ventana = new JFrame("Arkanoid de Parl�n");
			// Obtenemos el panel principal del JFrame
			JPanel panel = (JPanel) ventana.getContentPane();
			// Utilizo un BorderLayout para colocar el Canvas sobre el JPanel
			panel.setLayout(new BorderLayout());
			// Agregamos el Canvas al panel de manera que ocupe todo el espacio disponible
			panel.add(this, BorderLayout.CENTER);
			// Dimensionamos el JFrame
			ventana.setBounds( 0, 0, JFRAME_WIDTH, JFRAME_HEIGHT);
			// Hacemos el JFrame visible
			ventana.setVisible(true);
			// Con el siguiente c�digo preguntamos al usuario si realmente desea cerrar la aplicaci�n, cuando
			// pulse sobre el aspa de la ventana
			ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			ventana.addWindowListener( new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					cerrarAplicacion();
				}
			});
			// Creaci�n de la estrategia de doble b�ffer
			this.createBufferStrategy(2);
			strategy = this.getBufferStrategy();
			// Con ignoreRepaint le decimos al JFrame que no debe repintarse cuando el Sistema Operativo se lo indique,
			// nosotros nos ocupamos totalmente del refresco de la pantalla
			ventana.setIgnoreRepaint(true);
			// La ventana no podr� redimensionarse
			ventana.setResizable(false);
			// Hacemos que el Canvas obtenga autom�ticamente el foco del programa para que, si se pulsa una tecla, la pulsaci�n
			// se transmita directamente al Canvas.
			this.requestFocus();
			// Para resolver un problema de sincronizaci�n con la memoria de v�deo de Linux, utilizamos esta l�nea
			Toolkit.getDefaultToolkit().sync();
			
			// Agrego los controladores de rat�n y de teclado
			this.addMouseMotionListener(new DriverRaton());
			this.addKeyListener(new DriverTeclado());
	}
	
	public static Arkanoid getInstance() {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}

	/**
	 * Al cerrar la aplicaci�n preguntaremos al usuario si est� seguro de que desea salir.
	 */
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"�Desea cerrar la aplicaci�n?","Salir de la aplicaci�n",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void initWorld () {
		
		//Creamos la primera fase
		if(nivel1Acabado==false) {
			this.faseActiva= new Nivel1();
		}
		else {
			this.faseActiva= new Nivel2();
		}
		this.faseActiva.inicializaFase(); 
		
		//Agregamos los actores del primer nivel, limpiamos y a�adimos todos
		this.actores.clear();
		this.actores.addAll(this.faseActiva.getActores());
		
		// Creaci�n de los actores Nave y Bola
		this.nave = new Nave(); // creo el jugador
		this.actores.add(this.nave); // creo el jugador y lo guardo
		this.pelota = new Pelota(); // creo la pelota
		this.actores.add(this.pelota);// guardo la pelota
		
	}
	
	public void updateWorld() {
		// Comprobaci�n de las colisiones posibles producidas
		// Para detectar colisiones me basta con coger a los ladrillos del array de actores y comprobar si tienen colisi�n con la
		// bola, ya que es el �nico caso que de momento nos interesa para romper ladrillos.
		// Tambi�n intentar� encontrar una colisi�n entre la bola y la nave
		for (Actor actor : this.actores) {
			if (actor instanceof Ladrillos || actor instanceof Nave) {
				detectarYNotificarColision (actor, this.getPelota());
			}
		}
		
		// A continuaci�n se revisa si alguno de los actores de la lista ha sido marcado para su eliminaci�n. En caso de ser as�
		// se procede a borrarlo de la lista.
		for (int i = this.actores.size()-1; i >= 0; i--) {
			if (this.actores.get(i).EstaMarcadoParaEliminar) {
				this.actores.remove(i);
			}
		}
		
		//Agrego los nuevos actores que seran la explosiones
		for(Actor nuevoActor :this.nuevosactores) {
			this.actores.add(0,nuevoActor);
		}
		this.nuevosactores.clear(); // Limpio el array de actores a insertar
		// Actualizaci�n de todos los actores
		for (Actor actor : this.actores) {
			actor.act();
		}
		
		
	}
	
	//metodo que detecta colisiones con rectangulos imaginarios
	private void detectarYNotificarColision (Actor actor1, Actor actor2) {
		Rectangle rectActor1 = new Rectangle(actor1.getX(), actor1.getY(), actor1.getAncho(), actor1.getAlto());
		Rectangle rectActor2 = new Rectangle (actor2.getX(), actor2.getY(), actor2.getAncho(), actor2.getAlto());
		if (rectActor1.intersects(rectActor2)) {
			// En el caso de que exista una colisi�n, informo a los dos actores de que han colisionado y les indico el
			// actor con el que se ha producido el choque
			actor1.colisionConOtroActor(actor2);
			actor2.colisionConOtroActor(actor1);
		}
	}
	
	public void agregarActor (Actor nuevoActor) {
		this.nuevosactores.add(nuevoActor);
	}		
	
	public void game () {
			// Inicializaci�n del juego
			initWorld();
			// Este bucle se ejecutar� mientras el objeto Canvas sea visible.
			while (this.isVisible()) {
				// Tomamos el tiempo en milisegundos antes de repintar el frame
				long millisAntesDeConstruirEscena = System.currentTimeMillis();
				// Actualizamos y pintamos el nuevo frame
				updateWorld();
				paint();
				if(this.actores.size()<2 && nivelFinal==false) {
					nivel1Acabado=true;
					ReiniciarNivel();
				}
				GameOver();
				// Calculamos la cantidad de milisegundos que se ha tardado en realizar un nuevo frame del juego
				int millisUsados = (int) (System.currentTimeMillis() - millisAntesDeConstruirEscena);
				// Hago que el programa duerma lo suficiente para que realmente se ejecuten la cantidad de FPS
				// que tenemos programados
				try { 
					int millisADetenerElJuego = 1000 / FPS - millisUsados;
					if (millisADetenerElJuego >= 0) {
						 Thread.sleep(millisADetenerElJuego);
					}
				} catch (InterruptedException e) {}
			}
		}
	
	public void ReiniciarNivel() {
		actores.remove(this.pelota);
		if(pelota.UnaVidaMenos == false) {
			pelota= new Pelota();
		}
		puntos=0;
		actores.add(pelota);
		pelota.trayectoria = null;
		pelota.velocidadPorFrame = 2f; // velocidad con la que sale la pelota al principio
		game();
	}

	public void paint() {
		// Obtenemos el objeto Graphics (la brocha) desde la estrategia de doble b�ffer
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		// Lo primero que hace cada frame es pintar un rect�ngulo tan grande como la escena,
		// para superponer la escena anterior.
		g.drawImage(CacheRecursos.getInstance().getImagen("fondodb.jpg"),0,0,this);
		if (inmortal != true) {
		g.setColor(Color.BLACK);
		g.drawString("VIDAS: " + vidas, 480, 750);
		}
		g.setColor(Color.BLACK);
		g.drawString("PUNTOS: " + puntos, 10, 750);
		// Ejecutamos el m�todo paint de cada uno de los actores
		for (Actor actor : this.actores) {
			actor.paint(g);
		}
		// Una vez construida la escena nueva, la mostramos.
		strategy.show();;
		}
	
	public void GameOver() {
		if (inmortal != true) {
			if (vidas<= 0) {
				JOptionPane.showMessageDialog(null, "HAS PERDIDO, DEBES MEJORAR");
				System.exit(0);
			}
		}
	}
	
	

	
	
	public static void main(String[] args) {
		CacheRecursos.getInstance().cargarRecursosEnMemoria();
		Arkanoid.getInstance().game();
		
	}

	
	//GETTER Y SETTERS
	/**
	 * @return the nave
	 */
	public Nave getNave() {
		return nave;
	}

	/**
	 * @param nave the nave to set
	 */
	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public Pelota getPelota() {
		return pelota;
	}

	public void setPelota(Pelota pelota) {
		this.pelota = pelota;
	}
	
	
}
