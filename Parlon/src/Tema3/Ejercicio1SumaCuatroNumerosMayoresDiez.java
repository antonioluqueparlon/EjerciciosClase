package Tema3;

import javax.swing.JOptionPane;

public class Ejercicio1SumaCuatroNumerosMayoresDiez {

	public static void main(String[] args) {
			
		int acumuladorMayorDiez=0;
		
		for( int i=0; i<4; i++) {
			 int numeros = Integer.parseInt(JOptionPane.showInputDialog("Introduce 4 números: "));
			 	
			if (numeros>=10) {
			 acumuladorMayorDiez += numeros;
			}
		}
		
		//Mostramos el resultado de la suma
		
		System.out.println("El resultado de la suma es: "+acumuladorMayorDiez);
	}
}

