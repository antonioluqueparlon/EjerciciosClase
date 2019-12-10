package Tema5;

import Parlon.Utils;
import Parlon.UtilsArrays;

public class EjercicioBloque3_4ArraysShell {

	public static void main(String[] args) {	
		//Creo mi array
		int array[]=UtilsArrays.creaArrayNumerosAzar(5, 0, 100);
		
		//Ordenacion metodo shell
		int salto,aux,i;
		boolean cambios;
		for (salto = array.length/2; salto !=0; salto/=2) {
			cambios=true;
			while(cambios) {// Mientras se intercambia algun elemento
				cambios=false;
				for (i = salto; i < array.length; i++) { // se da una pasada
					if(array[i-salto]>array[i]) { // y si estan desordenados
						aux=array[i]; // se reordenan
						array[i]=array[i-salto];
						array[i-salto]=aux;
						cambios=true; // y se marca como cambio
					}
				}
			}
			
			
		}
		
		//Salto en pantalla
		System.out.println();
		//Muestro el array
		UtilsArrays.mostrarArray(array);
		
	}
}