package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Ladrillos extends Actor {
	
	public static final int ANCHO = 30;
	public static final int ALTO = 20;
	public static final int EspacioEntreLadrillos = 3;
	boolean tocado= false; // esto va a ser para indicar que el ladrillo esta preparado
	// para romperse y me va a dar puntos
	
	private Color color = null;
	
	
	
	/**
	 * @param color
	 */
	public Ladrillos() {
		super();
		spriteActual=null; // Los ladrillos los pinto yo, por eso no voy a usar sprites que son imagenes
		this.x = 20;
		this.y = 20;
		this.ancho=ANCHO;
		this.alto=ALTO;
		this.color = Color.BLUE; // por defecto los ladrillos serian azules
	}
	
	/**
	 * Constructor parametrizado
	 * @param x
	 * @param y
	 * @param color
	 */
	public Ladrillos(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.ancho=ANCHO;
		this.alto=ALTO;
		this.color = color;
	}


	public void paint (Graphics2D g) {
		g.setColor(this.color);
		g.fillRoundRect(this.x, this.y, ANCHO, ALTO, 3, 3);
		
	}
	
	//el ladrillo detecta una colision con la pelota
	@Override
	public void colisionConOtroActor(Actor actorColisionado) {
		// TODO Auto-generated method stub
		super.colisionConOtroActor(actorColisionado);
		if(actorColisionado instanceof Pelota) {
			eliminar();
			//creo el nuevo actor para la explosion y pongo que la explosion sea en el centro del ladrillo
			Arkanoid.getInstance().puntos=Arkanoid.getInstance().puntos + 100 ; // son los puntos que suma al romper ladrillo
			Explosion explosion = new Explosion(this.getX(),this.getY());
			explosion.setX(this.x+Ladrillos.ANCHO / 2 -explosion.getAncho()/2); // centrar la explosion
			Arkanoid.getInstance().agregarActor(explosion);//agrego la explosion al juego
			CacheRecursos.getInstance().playSonido("Arkanoid-SFX-01.wav");
			
			//Le pongo sonido a la explosion 
			//CacheRecursos.getInstancia().playSonido("Arkanoid-SFX-01.wav");	
		}
		else {
			tocado=true;
			Arkanoid.getInstance().puntos=Arkanoid.getInstance().puntos + 100 ;// serian los puntos para otro actor
		}
		
		}
	

	//GETTERS Y SETTERS


	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}




	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}



}
