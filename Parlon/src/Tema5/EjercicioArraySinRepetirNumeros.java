package Tema5;

import Parlon.Utils;
import Parlon.UtilsArrays;

public class EjercicioArraySinRepetirNumeros {

	public static void main(String[] args) {
		//Inicializo el primer array y la variable booleana
		int array[]=new int[10];
		
		//Bucle para que no repita numeros
		for (int i = 0; i < array.length; i++) {
			//Declaro aux porque lo necesito en la clausula while
			int candidato;//Numero generado al azar que se propone para oucpar la posicion
						  // de array[i]
			boolean yaExiste;
			//Comienzo un bucle que tiene como objetivo determinar un numero al azar no repetido
			//en el array
		do {
			candidato=Utils.obtenerNumeroAzar(0, 9);
			//Compruebo ahora si el "candidato" existe en las posiciones del array previas a i
			yaExiste=false;
			for (int j = 0; j < array.length; j++) {
				if(candidato==array[j]) {
					yaExiste=true;
				}
			}
		} while(yaExiste);
		//Cuando llego aqui se que el candidato no se repite en el array, es utilizable
		array[i]= candidato;
		}	
	
	//Mostrar en pantalla
	UtilsArrays.mostrarArray(array);
	}
		
}
			 
					



	


