package Tema5;

import javax.swing.JOptionPane;

import Parlon.Utils;


public class Ejercicio1Arrays {

	public static void main(String[] args) {
		//Declaracion del array y los limites
		int limiteinferior, limitesuperior;
		int array[]=new int[150];
		
		//Peticion de limites al usuario
		
		limiteinferior=Integer.parseInt(JOptionPane.showInputDialog("Introduce el limite inferior: "));
		limitesuperior=Integer.parseInt(JOptionPane.showInputDialog("Introduce el limite inferior: "));

		
		
		//Bucle del array
		for(int i=0;i<array.length;i++) {
			array[i]=Utils.obtenerNumeroAzar(limiteinferior,limitesuperior);
		}
		
		
		//Mostramos al usuario en pantalla el array en la consola
		for(int i=0;i<array.length;i++) {
		System.out.println(array[i]);
	}
		
		//Imprimo un salto de linea
		System.out.println();
		
		//Otra forma de iterar sobre un array;
		for (int i : array) {
			
		}
		
		
		}
	
}

