package videojuegos.Arkanoid.version1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class DriverTeclado extends KeyAdapter {
	
	/**
	 * Se activa este método cuando dejamos pulsada una tecla
	 */
	@Override
	public void keyPressed(KeyEvent event) {
		super.keyPressed(event);
		Arkanoid.getInstance().getNave().keyPressed(event);
		Arkanoid.getInstance().getPelota().keyPressed(event);
	}

	/**
	 * Se activa este método cuando levantamos una tecla pulsada
	 */
	@Override
	public void keyReleased(KeyEvent event) {
		super.keyReleased(event);
		Arkanoid.getInstance().getNave().keyReleased(event);
		Arkanoid.getInstance().getNave().keyReleased(event);
	}

	
}

