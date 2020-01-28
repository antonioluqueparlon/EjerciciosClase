package videojuegos.Arkanoid.version1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DriverRaton extends MouseAdapter {
	
	/**
	 * Override que permite manejar el evento de mover el ratón sobre el Canvas
	 */
	@Override
	public void mouseMoved(MouseEvent event) {
		super.mouseMoved(event);
		// Al recibir un evento se le envía directamente a la nave, para que ella lo maneje
		Arkanoid.getInstance().getNave().mouseMoved(event);
	}

}
