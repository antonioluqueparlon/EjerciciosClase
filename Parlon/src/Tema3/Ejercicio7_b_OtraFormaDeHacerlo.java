package Tema3;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio7_b_OtraFormaDeHacerlo {

	public static void main(String[] args) {
		// Pedimos al usuario un numero para calcular sus multiplos 
		Scanner scanner= new Scanner(System.in);
		System.out.println("Introduce el numero que vamos a calcular sus multiplos: ");
	
		int numeroaPedir= scanner.nextInt();
		//Pedimos al usuario el limite
		System.out.println("Introduce el limite: ");
		int limite=scanner.nextInt();
		
		for(int i=0; i<=limite; i+=numeroaPedir) {
			//Muestro el resultado al usuario
			System.out.println("Multiplo de " +numeroaPedir +": " +i );
			
		}

	}

}