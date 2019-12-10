package Tema3;

import javax.swing.JOptionPane;

public class Ejercicio7MultiplosyLimitePedidosPorUsuario {

	public static void main(String[] args) {
		// Pedimos al usuario un numero para calcular sus multiplos 
		
		int numeroaPedir= Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero del que vamos a calcular sus multiplos: "));
		int limite=Integer.parseInt(JOptionPane.showInputDialog("Introduce el limite: "));
		
		for(int i=0; i<=limite; i+=numeroaPedir) {
			//Muestro el resultado al usuario
			System.out.println("Multiplo de " +numeroaPedir +": " +i );
			
		}

	}

}

