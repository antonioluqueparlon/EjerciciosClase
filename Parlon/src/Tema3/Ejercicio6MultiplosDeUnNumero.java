package Tema3;

import javax.swing.JOptionPane;

public class Ejercicio6MultiplosDeUnNumero {

	public static void main(String[] args) {
		// Pedimos al usuario un numero para calcular sus multiplos 
		
		int numeroaPedir= Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero del que vamos a calcular sus multiplos: "));
		int limite=100;
		
		for(int i=0; i<=limite; i+=numeroaPedir) {
			//Muestro el resultado al usuario
			System.out.println("Multiplo de " +numeroaPedir +": " +i );
			
		}

	}

}
