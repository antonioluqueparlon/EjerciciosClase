package videojuegos.Arkanoid.version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Pelota extends Actor {

	protected int DiametroBola=15;
	protected int velocidadX=5;
	protected int velocidadY=5;

	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillOval(this.x,this.y, DiametroBola, DiametroBola);
	}
	
	public Pelota() {
		super();
		spriteActual = null; // La bola se pinta de forma vectorial
		this.x = Arkanoid.getInstance().getWidth() / 2;
		this.y = Arkanoid.getInstance().getHeight() / 2;
	}

	@Override
	public void act() {
	
		//Movimiento eje horizontal
		if (this.x <0 || this.x > (Arkanoid.getInstance().getWidth() - DiametroBola)) {
			 this.velocidadX = 0 -this.velocidadX;
		}
		
		// Movimiento en el eje vertical 
		if (this.y < 0 || this.y > (Arkanoid.getInstance().getHeight() - DiametroBola)) {
			  this.velocidadY = 0 -this.velocidadY; 
		}
		// Agregamos las velocidades respectivas a cada eje para la bola
		this.x += this.velocidadX;
		this.y += this.velocidadY;
		
		
			
	}
}
