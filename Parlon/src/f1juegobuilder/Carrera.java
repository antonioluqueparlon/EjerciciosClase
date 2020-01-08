package f1juegobuilder;

import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Carrera extends Thread {
	private JLabel eti;
	private granpremio p;
	/**
	 * @param eti
	 * @param actionListener
	 */
	
	/**
	 * @param eti
	 * @param p
	 */
	public Carrera(JLabel eti, granpremio p) {
		super();
		this.eti = eti;
		this.p = p;
	}
	
	
	public Carrera(JLabel lblCoche2, ActionListener actionListener) {
		// TODO Auto-generated constructor stub
	}


	public void correr () {
		int c1=0, c2=0;
		while(true) {
			try {
				sleep((int)(Math.random()*1000));
				c1=p.getlblCoche().getLocation().x;
				c2=p.getlblCoche2().getLocation().x;
				if(c1<p.getlblMeta().getLocation().x-10 && c2<p.getlblMeta().getLocation().x-10) {
					eti.setLocation(eti.getLocation().x+10,eti.getLocation().y);
					p.repaint();
				}else {
					break;
				}
					
					
				}catch (InterruptedException e) {
				}
				if(eti.getLocation().x>=p.getlblMeta().getLocation().x-10) {
				if(c1>c2) {
					JOptionPane.showMessageDialog(null, "Ha ganado el coche 1");
				}
				else if(c2>c1) {
					JOptionPane.showMessageDialog(null, "Ha ganado el coche 2");
				}
				else {
					JOptionPane.showMessageDialog(null, "Empate");
				}
			}
		}
	
}
}