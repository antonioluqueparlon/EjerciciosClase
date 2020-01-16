package videojuegos.JuegoFormula1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import f1juegobuilder.granpremio;

public class Pista extends Actor {
	
	public static int  MARGEN=2;
	

	public Pista () {
		
	}

	
	/**
	 * @param x
	 * @param y
	 */
	public Pista(int x, int y,int width,int height) {
		super(x, y);
		this.width=width;
		this.height=height;
		
		}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(this.x, this.y, this.width, this.height);
		
		Graphics2D g2d =(Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(this.x + MARGEN, this.y + MARGEN, this.width - 2*MARGEN, this.height - 2*MARGEN);
		// El * margen es para que la pista no ocupe toda la ventana haciendola mas pequeña o mas grande
		// segun queramos
		
		
	}


	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}
}
	
