package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics;

public class Ladrillos extends Actor {
	
	public void paint (Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(5, 67,50, 25);
		
	}
	

	/**
	 * 
	 */
	public Ladrillos() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param x
	 * @param y
	 */
	public Ladrillos(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

}
