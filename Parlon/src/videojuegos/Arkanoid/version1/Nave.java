package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Nave extends Actor{
	
	public BufferedImage loadImage(String nombre) {
		URL url=null;
		try {
			url = getClass().getResource(nombre);
			return ImageIO.read(url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(SpritesRepository.getInstance().getSprite(SpritesRepository.getInstance().NAVE),100,100,null);
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}


		
}
