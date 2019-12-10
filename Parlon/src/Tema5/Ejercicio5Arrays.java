package Tema5;

import Parlon.Utils;

public class Ejercicio5Arrays {

	public static void main(String[] args) {
		// Declaracion del array y del contador de suma de pares
		int array[]=new int [5];
		int sumaPares=0;
		
		//Bucle del array y lo mostramos en pantalla
		
		for (int i = 0; i < array.length; i++) {
			array[i]=Utils.obtenerNumeroAzar(0, 100);
		System.out.println(array[i]);
		}
		
		//Declaro las variables de la suma de pares y impares
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0 ) {
				sumaPares+=array[i];
				}
			
		}
		//Salto de linea
		System.out.println();
		//Muestro en pantalla al usuario la suma 
		System.out.println("El resultado de los numeros de indice par es: "+sumaPares);
	}
}	
