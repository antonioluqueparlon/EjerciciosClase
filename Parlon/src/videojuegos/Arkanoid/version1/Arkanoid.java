package videojuegos.Arkanoid.version1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class Arkanoid extends Canvas {
	
	// Ventana principal del juego
	JFrame ventana = new JFrame("Arkanoid de Parlón");
	
	// Indicamos alto y ancho del objeto tipo Canvas
	public static final int JFRAME_WIDTH=564;
	public static final int JFRAME_HEIGHT=931;
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormirá 10 millis
	// tras haber repintado la escena
	public static final int FPS=120;
	
	// Lista con todos los actores que intervienen en el videojuego
	List<Actor> actores = new ArrayList<Actor>(); 
	List<Actor> nuevosactores = new ArrayList<Actor>();// las explosiones
	// BufferStrategy usado para conseguir la técnica de doble búffer
	private BufferStrategy strategy;
	 
	// Instancia para patrón Singleton
	private static Arkanoid instance = null;
	
	
	// Referencia que guardaremos apuntando al objeto de tipo Player
	Nave nave = new Nave();
	Pelota pelota= new Pelota();
	
		
	//Niveles del juego
	Fase faseActiva=null;
	boolean activo=false;
		
	int vidas=3;
	boolean inmortal=false;
	boolean fastidio=false;
	int puntos;
	boolean nivelFinal = false;
	boolean nivel1Acabado = false;

	private int YforStatusBar=0;

	
	

	public Arkanoid() {
		// Creación de la ventana
			ventana = new JFrame("Arkanoid-DragonBall de Parlón");
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
			// Con el siguiente código preguntamos al usuario si realmente desea cerrar la aplicación, cuando
			// pulse sobre el aspa de la ventana
			ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			ventana.addWindowListener( new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					cerrarAplicacion();
				}
			});
			// Creación de la estrategia de doble búffer
			this.createBufferStrategy(2);
			strategy = this.getBufferStrategy();
			// Con ignoreRepaint le decimos al JFrame que no debe repintarse cuando el Sistema Operativo se lo indique,
			// nosotros nos ocupamos totalmente del refresco de la pantalla
			ventana.setIgnoreRepaint(true);
			// La ventana no podrá redimensionarse
			ventana.setResizable(false);
			// Hacemos que el Canvas obtenga automáticamente el foco del programa para que, si se pulsa una tecla, la pulsación
			// se transmita directamente al Canvas.
			this.requestFocus();
			// Para resolver un problema de sincronización con la memoria de vídeo de Linux, utilizamos esta línea
			Toolkit.getDefaultToolkit().sync();
			
			// Agrego los controladores de ratón y de teclado
			DriverRaton driverRaton = new DriverRaton();
			this.addMouseMotionListener(driverRaton);
			this.addMouseListener(driverRaton);
			this.addKeyListener(new DriverTeclado());
	}
	
	public static Arkanoid getInstance() {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}

	/**
	* Al cerrar la aplicación preguntaremos al usuario si está seguro de que desea salir.
	*/
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
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
		
		//Agregamos los actores del primer nivel, limpiamos y añadimos todos
		this.actores.clear();
		this.actores.addAll(this.faseActiva.getActores());
		
		// Creación de los actores Nave y Bola
		this.actores.add(this.nave);//guardo la nave
	    this.actores.add(this.pelota);// guardo la pelota
		
	}
	
	public void updateWorld() {
		// Comprobación de las colisiones posibles producidas
		// Para detectar colisiones me basta con coger a los ladrillos del array de actores y comprobar si tienen colisión con la
		// bola, ya que es el único caso que de momento nos interesa para romper ladrillos.
		// También intentaré encontrar una colisión entre la bola y la nave
		for (Actor actor : this.actores) {
			if (actor instanceof Ladrillos || actor instanceof Nave) {
				if (detectarYNotificarColisionConPelota (actor)) {
					break;
				}
			}
		}
		
		// A continuación se revisa si alguno de los actores de la lista ha sido marcado para su eliminación. En caso de ser así
		// se procede a borrarlo de la lista.
		for (int i = this.actores.size()-1; i >= 0; i--) {
			if (this.actores.get(i).EstaMarcadoParaEliminar) {
				this.actores.remove(i);
			}
		}
		
		//Agrego los nuevos actores que seran la explosiones
		for(Actor nuevoActor : this.nuevosactores) {
			this.actores.add(0,nuevoActor);
		}
		this.nuevosactores.clear(); // Limpio el array de actores a insertar
		// Actualización de todos los actores
		for (Actor actor : this.actores) {
			actor.act();
		}
		
	}
	
	//metodo que detecta colisiones con rectangulos imaginarios en este caso la pelota
	private boolean detectarYNotificarColisionConPelota (Actor actor) {
		Rectangle rectActor = new Rectangle(actor.getX(), actor.getY(), actor.getAncho(), actor.getAlto());
		if (rectActor.intersects(this.pelota.getRectanguloParaColisiones())) {
			// En el caso de que exista una colisión, informo a los dos actores de que han colisionado y les indico el
			// actor con el que se ha producido el choque
			actor.colisionConOtroActor(this.pelota);
			this.pelota.colisionConOtroActor(actor);
			return true;
		}
		return false;
	}
	
	public void agregarActor (Actor nuevoActor) {
		this.nuevosactores.add(nuevoActor);
	}		
	
	public void game () {
			// Inicialización del juego
			initWorld();
			//Musica de fondo de Dragon Ball del juego
			CacheRecursos.getInstance().loopSonido(this.faseActiva.getNombreSonidoInicio());
			// Este bucle se ejecutará mientras el objeto Canvas sea visible.
			while (this.isVisible()) {
				// Tomamos el tiempo en milisegundos antes de repintar el frame
				long millisAntesDeConstruirEscenario = System.currentTimeMillis();
				// Actualizamos y pintamos el nuevo frame
				updateWorld();
				paint();
				if (this.actores.size() <= 2 && nivelFinal == false) {
					nivel1Acabado = true;
					ReiniciarNivel();
				}
				
				GameOver();
				// Calculamos la cantidad de milisegundos que se ha tardado en realizar un nuevo frame del juego
				int millisUsados = (int) (System.currentTimeMillis() - millisAntesDeConstruirEscenario);
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
		if(pelota.vidaMenos == false) {
			pelota= new Pelota();
		}
		puntos= puntos -150;
		actores.add(pelota);
		pelota.trayectoria = null;
		pelota.velocidadPorFrame = 2f; // velocidad con la que sale la pelota al principio
		game();
	}

	public void paint() {
		// Obtenemos el objeto Graphics (la brocha) desde la estrategia de doble buffer
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		// Lo primero que hace cada frame es pintar un rectangulo tan grande como la escena,
		// para superponer la escena anterior.
		g.drawImage(CacheRecursos.getInstance().getImagen("fondodb2.jpg"),0,0,this);
		if (inmortal != true) {
		g.setFont(new Font("Arial", Font.BOLD,20));
		g.setColor(Color.WHITE);
		g.drawString("VIDAS: " , 445, 890);
		g.setColor(Color.RED);
		//paintVidas(g);
		g.drawString("" +vidas, 520, 890);
		}
		
		g.setFont(new Font("Arial", Font.BOLD,20));
		g.setColor(Color.WHITE);
		g.drawString("PUNTOS: " , 10, 890);
		g.setColor(Color.RED);
		g.drawString("" +puntos, 110, 890);
		
		// Ejecutamos el metodo paint de cada uno de los actores
		for (Actor actor : this.actores) {
			actor.paint(g);
		}
		// Una vez construida la escena nueva, la mostramos.
		strategy.show();
		
		//paintVidas(g);
	}
	
	public void paintVidas(Graphics g) {
		int x = 280 ;
		int y= 700;
		for (int i = 0; i < pelota.getVida(); i++) {
			BufferedImage boladragon = CacheRecursos.getInstance().getImagen("boladragon.jpg");
			g.drawImage(boladragon, x,y + boladragon.getWidth() ,this);
		x+= pelota.getAncho();
			//}
	}
	}
	public void GameOver() {
		if (inmortal != true) {
			if (vidas<= 0) {
				//CacheRecursos.getInstance().getImagen("game-over.png");
				
				//BufferedImage gameover = CacheRecursos.getInstance().getImagen("game-over.png");
				//g.drawImage(gameover, 0,0, this);
				JOptionPane.showMessageDialog(null, "HAS PERDIDO, MALDITO SAIYAJIN");
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

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	

	
	
	
}
