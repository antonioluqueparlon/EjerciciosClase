package Tema5;

import javax.swing.JOptionPane;

import Parlon.Utils;
import Parlon.UtilsArrays;

public class EjercicioBloque2_5Arrays {

	public static void main(String[] args) {
		//Declaro mi array
	int array[]=UtilsArrays.creaArrayNumerosAzar(5, 0, 100);

	//Muestro el array al usuario
	UtilsArrays.mostrarArray(array);
	
	//Pido al usuario cuantos movimientos quiere desplazar el array y hago su bucle
	int numeroPedido=Utils.obtenerNumUsuario("Introduce cuantos movimientos quieres hacer");	
	for (int i = 0; i < numeroPedido; i++) {
	
	//Introduzco otro array que me recorra a mi array primero menos 1
	int array2=array[array.length -1] ;
	for (int j = array.length-1; j > 0; j--) {
		array[j]=array[j-1];
		array[0]=array2;
	}	
		
	}
	
		//Muestro al usuario el array final con el recorrido hacia la derecha
	UtilsArrays.mostrarArray(array);

	}

}
