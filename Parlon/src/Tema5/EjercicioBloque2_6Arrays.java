package Tema5;

import Parlon.Utils;
import Parlon.UtilsArrays;

public class EjercicioBloque2_6Arrays {

	public static void main(String[] args) {
		//Creo un array
		int array[]=UtilsArrays.creaArrayNumerosAzar(5, 0, 100);
		//Muestro al usuario el array creado
		UtilsArrays.mostrarArray(array);
		
		//Tengo que establecer las dos opciones (switch) y los dos tipos de casos
		//que pueden ser, para la izquierda (Case0) o derecha (Case1) y pedirle al usuario
		//la direccion que quiere
		int direccion=Utils.obtenerNumUsuario("Introduce hacia donde:\n"
				+ "0 ----> Izquierda\n"
				+ "1 ----> Derecha");
		int numCiclos=Utils.obtenerNumUsuario("Introduce cuantos movimientos quieres hacer");
		
		//Creo el bucle para usar el switch y operar
		for (int i = 0; i < numCiclos; i++) {
		switch(direccion) {
		case 0: // izquierda
			// Comienzo el algoritmo de ciclo
			int aux = array[array.length - 1];
			for (int j = array.length - 1; j > 0; j--) {
				array[j] = array[j-1];
			}
			array[0] = aux;
			// Finalizo el algotitmo del ciclo
			break;
		case 1: // a izquierda
			// Salvaguardo la primera posicion del array
			aux = array[0];
			// Recorro las posiciones del array de primera a penultima
			for (int j = 0; j < array.length - 1; j++) {
				array[j] = array[j+1];
			}
			// La primera posicion, guardada en aux, pasa a ser la ultima
			array[array.length-1] = aux;
			break;
			}
			}
		UtilsArrays.mostrarArray(array);
	}
	
}	
	




