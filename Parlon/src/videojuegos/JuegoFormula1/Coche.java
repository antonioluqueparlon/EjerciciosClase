package videojuegos.JuegoFormula1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import tutorialJava.capitulo6b_Videojuegos.FormulaUno.FormulaUno;
import tutorialJava.capitulo6b_Videojuegos.FormulaUno.Pista;
import tutorialJava.capitulo6b_Videojuegos.FormulaUno.Vehiculo;

public class Coche extends Vehiculo {

	public Coche(Pista pista) {
		super(pista);
		// TODO Auto-generated constructor stub
	}

	public Coche(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Formula1.COLORES[(int) Math.round(Math.random() * (Formula1.COLORES.length-1))]); 
		g.fillRect(this.getPosicion(), this.pista.getY() + 5, 20, 20);
	}

}
