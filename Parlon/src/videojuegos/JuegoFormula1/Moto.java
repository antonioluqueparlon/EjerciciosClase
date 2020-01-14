package videojuegos.JuegoFormula1;

import java.awt.Graphics;

public class Moto extends Vehiculo {

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
		g.setColor(FormulaUno.COLORES[(int) Math.round(Math.random() * (FormulaUno.COLORES.length-1))]); 
		g.fillRect(this.getPosicion(), this.pista.getY() + 5, 20, 20);
	}

}

}
