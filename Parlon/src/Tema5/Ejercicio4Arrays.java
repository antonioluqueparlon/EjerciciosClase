package Tema5;

import Parlon.Utils;

public class Ejercicio4Arrays {

	public static void main(String[] args) {
		// Declaracion del array y del contador de suma de pares e impares
		int array[]=new int [5];
		int suma=0;
		
		
		//Bucle del array y lo mostramos en pantalla
		for (int i = 0; i < array.length; i++) {
		array[i]=Utils.obtenerNumeroAzar(0,100);
		System.out.println(array[i]);
		}
		
		//Declaro las variables de la suma de pares y impares
		for (int numeros : array) {
			suma= numeros+=suma;
	
		}
		
		//Imprimo un salto en pantalla
		System.out.println();
		
		//Muestro al usuario los resultados en pantalla
		System.out.println("El resultado de la suma de los pares es: "+sumaPares);
		System.out.println("El resultado de la suma de los Impares es: "+sumaImpares);
	}

}
