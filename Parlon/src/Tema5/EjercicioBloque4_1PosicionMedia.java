package Tema5;

import Parlon.UtilsArrays;

public class EjercicioBloque4_1PosicionMedia {

	public static void main(String[] args) {
		//Creo mi array 
		int array[]=UtilsArrays.creaArrayNumerosAzar(11, 0, 100);
		//Muestro el array al usuario
		UtilsArrays.mostrarArray(array);
		//Examinar longitud del array
		for (int i = 0; i < array.length; i++) {//Recorro mi array
			//busco el valor que esta en la posicion media	
			}
		System.out.println("Valor medio del array es: "+array[array.length/2]);
			if (array.length % 2 != 0) {// Si la longitud del array entre 2 es distinto de 0 
			System.out.println("La longitud del array es impar");
			}
			else {// Si pusiese una longitud par me saldria este mensaje
			System.out.println("La longitud del array es par");
			}
	}

}
