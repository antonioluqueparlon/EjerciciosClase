package Tema5;

import javax.swing.JOptionPane;

import Parlon.Utils;

public class Ejercicio3Arrays {

	public static void main(String[] args) {
		//Declaracion del array
		int array[]= new int [5];
		int numeroBuscado;
		

		
		//Mostramos el array en pantalla
		for (int i = 0; i < array.length; i++) {
			array[i]=Utils.obtenerNumeroAzar(0,100);
			System.out.println(array [ i ]);
					
		}
		//Pedimos al usuario el numero que quiere buscar en el array
		
		numeroBuscado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero que quieres buscar en el array: "));
		
		boolean EstaElNumeroEnElArray=false;

		//Buscar el numero
	
		for (int i = 0; i < array.length; i++) {
			if(numeroBuscado==array[i]) {
				System.out.println("He encontrado el numero "+numeroBuscado + " en la posicion "+i);
				EstaElNumeroEnElArray=true;
			}
		}
		
		//SI el contador esta a cero o la variable booleana la hemos establecido, sabemos
		// que el numero no esta en el array
		if(!EstaElNumeroEnElArray) {
			System.out.println("EL numero "+ numeroBuscado +" no se encuentra en el array");
		}
		
	}
	
	

}
