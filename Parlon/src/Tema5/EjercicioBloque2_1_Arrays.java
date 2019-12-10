package Tema5;



import Parlon.Utils;

public class EjercicioBloque2_1_Arrays {

	public static void main(String[] args) {
		//Inicializo el array
		int array[]=new int [5];
		
		//Recorro el array y lo muestro en pantalla
		for (int i = 0; i < array.length; i++) {
			array[i]=Utils.obtenerNumeroAzar(-100, 100);
			System.out.println(array[i]);
			
		}
//Hacer que los numeros pares cambien de signo y viceversa
		for (int i = 0; i < array.length; i++) {
			
			if( array[i] % 2 == 0) {
				array[i]=array[i]*(-1);
			}
				
			}
		//Imprimo un salto de linea
		System.out.println();
		//Muestro en pantalla el array invertido
		System.out.println("Array invertido de signo es: "+array);
		
			
		}
}
