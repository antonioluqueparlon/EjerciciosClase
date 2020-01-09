package definitivof1;

/**
 * 
 * @author Antonio Luque
 *
 */
public class Coche extends Vehiculo {
	// Propiedades específicas del Monstruo
	protected int velocidadx; // Cantidad de píxeles que aumentará la posición del coche en cada iteración del bucle principal del juego
	
	/**
	 * Constructor por defecto, que inicializa la imagen del coche y la velocidad de cambio de sprites
	 */
	public Coche() {
		super(new String[] {"coche2.png"}, 20);
	}
	
	/**
	 * Método necesario para extender de Actor, incorpora el movimiento que el actor realizará en cada iteración del programa
	 */
	public void act() {
		super.act(); // Necesario para habilitar cambios de sprites en el actor
		this.x += this.velocidadx; // En cada iteración del bucle principal, el coche cambiará su posición en el eje X, sumándole a esta el valor de vx
		
		// ¿Qué ocurre si la imagen del personaje sale de la pantalla en el eje horizontal?
				if (this.x < 0 || this.x > (GranPremio.getInstance().getWidth() - this.getWidth())) {
					  velocidadx = velocidadx; // En caso de salir fuera de la ventana, el actor cambiar el signo de su velocidad, tanto cuando choque
					  // con el límite derecho como cuando lo haga con el izquierdo
		}
	}
	
	// Métodos Getters y Setters
	public int getVx() { return velocidadx; }
	public void setVx(int velocidadx) { this.velocidadx = velocidadx; }

}
