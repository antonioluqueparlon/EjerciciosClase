package Tema5;

import Parlon.UtilsArrays;

public class EjercicioBloque2_4Arrays {

	public static void main(String[] args) {
		//Declaro mi array
	int array[]=UtilsArrays.creaArrayNumerosAzar(5, 0, 100);

	//Muestro el array al usuario
	UtilsArrays.mostrarArray(array);
	
	//Introduzco otro array que me recorra a mi array primero menos 1
	int array2=array[array.length -1] ;
	for (int i = array.length-1; i > 0; i--) {
		array[i]=array[i-1];
		
	}
	array[0]=array2;
		
		//Muestro al usuario el array final con el recorrido hacia la derecha
	UtilsArrays.mostrarArray(array);

	}

}
