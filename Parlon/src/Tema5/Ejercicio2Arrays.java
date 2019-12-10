package Tema5;

public class Ejercicio2Arrays {

	public static void main(String[] args) {
		int array []=new int [100];
		
		
		for(int i=0; i<array.length;i++) { //Declaracion del bucle
			array[i]=(int)Math.round(Math.random()*(100-0)+0);
		}
//Mostrar en pantalla el array
		for (int i=0; i<array.length;i++) {
		System.out.println("Array realizado con exito: " +array[i]);
	
		}
		//Tenemos que invertir el array
		
		for(int i=array.length-1; i>=0 ; i--) {
			System.out.println("El array invertido es: " +array[i]);
		}
	}
}
