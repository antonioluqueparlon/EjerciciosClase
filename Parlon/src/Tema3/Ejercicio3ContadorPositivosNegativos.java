package Tema3;

import javax.swing.JOptionPane;

public class Ejercicio3ContadorPositivosNegativos {

	public static void main(String[] args) {
			
		int contadorPositivos=0;
		int contadorNegativos=0;
		
		for( int i=0; i<4; i++) {
			 int numerosaPedir = Integer.parseInt(JOptionPane.showInputDialog("Introduce los números que quieras: "));
			 	
			if (numerosaPedir<0) {
			 contadorNegativos ++;
			}
			else {
				contadorPositivos ++;
			}
		}
		
		//Mostramos el resultado de la suma
		
		System.out.println("Numeros positivos: "+contadorPositivos);
		System.out.println("Numeros negativos : "+contadorNegativos);
	}

}
