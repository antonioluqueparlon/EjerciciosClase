package Tema5;

import Parlon.Utils;
import Parlon.UtilsArrays;

public class EjercicioBloque3_3ArraysSeleccion {

	public static void main(String[] args) {
//Creo el array y su variable auxiliar
		int array[]=UtilsArrays.creaArrayNumerosAzar(5, 0, 20);
		int masPequeno,aux;
		
		
		//Muestro al usuario en pantalla el array
		UtilsArrays.mostrarArray(array);
		
		//Bucle Metodo Seleccion
		for (int i = 0; i< array.length; i++) {
			//Guardo el numero mas pequeño
			masPequeno=i;
			//Hago un segunda pasada o recorrido
			for (int j = i+1; j < array.length; j++) {
				if(array[j]<array[masPequeno]) {
					masPequeno=j;	
				}
				
			}
			//Ordeno el array
			aux=array[i];
			array[i]=array[masPequeno];
			array[masPequeno]=aux;
		}
		//Imprimo un salto en pantalla
		System.out.println();
		//Muestro al usuario el array Ordenado final
		System.out.println("Contenido del array");
		for (int j = 0; j < array.length; j++) {
			System.out.print(array[j] + " ");
		
	
		}
	}
}
