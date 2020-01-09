package definitivof1;

/**
 * 
 * @author Antonio Luque
 *
 */
public class Coche extends Vehiculo {
	// Propiedades espec�ficas del Monstruo
	protected int velocidadx; // Cantidad de p�xeles que aumentar� la posici�n del coche en cada iteraci�n del bucle principal del juego
	
	/**
	 * Constructor por defecto, que inicializa la imagen del coche y la velocidad de cambio de sprites
	 */
	public Coche() {
		super(new String[] {"coche2.png"}, 20);
	}
	
	/**
	 * M�todo necesario para extender de Actor, incorpora el movimiento que el actor realizar� en cada iteraci�n del programa
	 */
	public void act() {
		super.act(); // Necesario para habilitar cambios de sprites en el actor
		this.x += this.velocidadx; // En cada iteraci�n del bucle principal, el coche cambiar� su posici�n en el eje X, sum�ndole a esta el valor de vx
		
		// �Qu� ocurre si la imagen del personaje sale de la pantalla en el eje horizontal?
				if (this.x < 0 || this.x > (GranPremio.getInstance().getWidth() - this.getWidth())) {
					  velocidadx = velocidadx; // En caso de salir fuera de la ventana, el actor cambiar el signo de su velocidad, tanto cuando choque
					  // con el l�mite derecho como cuando lo haga con el izquierdo
		}
	}
	
	// M�todos Getters y Setters
	public int getVx() { return velocidadx; }
	public void setVx(int velocidadx) { this.velocidadx = velocidadx; }

}
