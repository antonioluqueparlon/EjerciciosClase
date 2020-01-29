package videojuegos.Arkanoid.version1;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * Esta clase se utiliza como un almac�n de ficheros de imagen. Para almacenar las im�genes utilizamos
 * un HashMap<String, BufferedImage>. Adem�s esta clase incorpora un patr�n Singleton
 *
 */
public class CacheImagenes {
	// HashMap que act�a como almac�n de im�genes
	private HashMap<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();
	
	// Instancia Singleton
	private static CacheImagenes instancia= null;
	
	
	/**
	 * Getter Singleton
	 * @return
	 */
	public static CacheImagenes getInstancia () {
		if (instancia == null) {
			instancia = new CacheImagenes();
		}
		return instancia;
	}

	
	/**
	 * Este m�todo carga un fichero de imagen del sistema de ficheros y lo devuelve
	 * como un objeto de tipo BufferedImage
	 * @param nombre
	 * @return
	 */
	private BufferedImage cargarImagen (String nombre) {
		URL url=null;
		try {
			url = getClass().getResource(nombre);
			return ImageIO.read(url);
		} catch (Exception e) { // algo ha fallado, se acaba el programa si no podemos cargar alguna imagen
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
	
	/**
	 * M�todo utilizado desde fuera de esta clase para permitir acceder a las im�genes. En primer lugar se 
	 * busca la imagen en el almac�n, si no se encuentra se busca en el sistema de ficheros.
	 * @param nombre
	 * @return
	 */
	public BufferedImage getImagen(String nombre) {
		BufferedImage img = sprites.get(nombre);
		if (img == null) {
			img = cargarImagen("../res/"+nombre);
			sprites.put(nombre,img);
		}
		return img;
	}
}
