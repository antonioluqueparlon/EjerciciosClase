package Tema5;

import Parlon.UtilsArrays;

public class EjercicioBloque3_1ArraysBurbuja {

	public static void main(String[] args) {
		//Creo mi array de numeros al azar y un auxiliar
		
		int array[]=UtilsArrays.creaArrayNumerosAzar(5, 0, 50);
		int aux;
		//Muestro al usuario en pantalla el array
		UtilsArrays.mostrarArray(array);
		
		//Metodo Burbuja
		for (int i = 0; i < array.length-1; i++) {
		for (int j = 0; j < array.length-1; j++) {
			if(array[j]>array[j+1]){//Si el numeroActual>numeroSiguiente
				//Hago un intercambio
				aux=array[j];
				array[j]=array[j+1];
				array[j+1]=aux;
			
			}	
		}
		}
		//Imprimo un salto en pantalla
		System.out.println();
		//Muestro en pantalla el array ordenado
		UtilsArrays.mostrarArray(array);
		
	}
}
