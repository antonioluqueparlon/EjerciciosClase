package videojuegos.Arkanoid.version1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ObjetosACrear {
	
	public void paint (Graphics n) {
		BufferedImage nave = loadImage("../res/nave-original.png");
		n.drawImage(nave, 450, 450,null);
	}
}

