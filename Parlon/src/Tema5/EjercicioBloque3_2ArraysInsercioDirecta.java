package Tema5;

import Parlon.Utils;
import Parlon.UtilsArrays;

public class EjercicioBloque3_2ArraysInsercioDirecta {

	public static void main(String[] args) {
		//Creo el array y su variable auxiliar
		int array[]=UtilsArrays.creaArrayNumerosAzar(5, 0, 20);
		int aux;
		int j;
		
		//Muestro al usuario en pantalla el array
		UtilsArrays.mostrarArray(array);
		
		//Bucle Metodo Insercion
		for (int i = 0; i< array.length; i++) {
			aux=array[i];
			//Hago los desplazamientos a derecha,uno a uno de los valores del array
			//hasta encontrar un valor menor que el que contiene la var "aux"
			for (j = i; j > 0 && array[j-1] >aux; j--) {
				array[j]=array[j-1];
		}
		//Cuando acabo los desplazamientos el valor de "j" indica la posicion del array
		//en la que debo insertar el valor de la var "aux"
			array[j]=aux;

		}
		//for	
		//Muestro el array resuelto en pantalla y un salto de linea
		System.out.println();
		System.out.println("Contenido del array");
		for (j = 0; j < array.length; j++) {
			System.out.print(array[j] + " ");
		}
		
	}
}

