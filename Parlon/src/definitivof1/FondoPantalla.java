package definitivof1;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPantalla extends JPanel {
	ImageIcon imagen; 
	
	public FondoPantalla() {
		super();
		initialize();
		imagen = new ImageIcon(getClass().getResource("pista.jpg"));
		setSize(imagen.getIconWidth(),imagen.getIconHeight());
	}
	
	protected void paintComponent (Graphics g) {
		Dimension d= getSize();
		g.drawImage(pista.jpg, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
	}
	private void initialize() {
		// TODO Auto-generated method stub
		
	}
}