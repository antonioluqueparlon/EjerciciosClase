package Tema5;

import Parlon.UtilsArrays;

public class ArrayOrdenarPareseImpares {

	public static void main(String[] args) {
		//Declaro un array de numeros al azar
		int array[]=UtilsArrays.creaArrayNumerosAzar(10, 0, 9);
		
		//Mostrar array original
		UtilsArrays.mostrarArray(array);
		
		//Creo un array auxiliar que contendra a los numeros impares
		int impares[]=new int [array.length];
		
		//Recorro el array original buscando y almacenando numeros impares 
		//en el array "impares"
		int indicearrayimpares=0;
		for (int i = 0; i < impares.length; i++) {
			if(array[i] % 2 == 1) { // Impar, debe ir al array "impares"
				impares[indicearrayimpares]=array[i];
				indicearrayimpares++;
			}
		}
		
		//Mostrar array impares
		UtilsArrays.mostrarArray(array);
	}

}
