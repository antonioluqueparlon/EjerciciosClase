package Tema5;

import Parlon.Utils;
import Parlon.UtilsArrays;

public class Ejercicio0Arrays {

	public static void main(String[] args) {
		//Declaracion del array y de la suma, media,menor y mayor
		int array [] = new int [10];
		float suma=0;
		float media=0;
		int menor=0;
		int mayor=0;
		int contador=0;
	
	
	//Inicializamos los valores del array y declaramos que sean numeros al azar
	for(int i=0; i<array.length; i++) {
		array[i]=Utils.obtenerNumeroAzar(1,100);

	}
	
	//Motramos en pantalla el resultado de los arrays
	UtilsArrays.mostrarArray(array);
	
	//Inicializamos la suma,menor y mayor con su bucle
	menor=array[0];
	mayor=array[0];
	for(int i=0; i<array.length;i++)
		suma=suma+array[i];
	
	//Inicializamos el mayor y el menor
	for (int i = 0; i < array.length; i++) {
		if(array[i]>mayor) {
			mayor=array[i];
		}
		if(array[i]<menor) {
			menor=array[i];
		}
	}
	
	//Mostramos el mayor y el menor del array
	System.out.println("El mayor del array es: " +mayor);
	System.out.println("El menor del array es: " +menor);
	
	//Mostrar suma del array
	System.out.println("La suma del array es: "+suma);
	
	//Acumulador de la media
	for(int i=0;i<array.length;i++)
	 contador++;
	
	//Mostrar media del array
	for(int i=0; i<array.length;i++);
	media=suma/contador;
	System.out.println("La media del array es: "+media);
	
	
	
	}
}
	


