package Tema5;

import Parlon.Utils;


public class EjercicioBloque2_2_Arrays {

	public static void main(String[] args) {
		//Inicializo el primer array
		int array1[]= new int[10];
		int numerosPar;
		int numerosImpar;
		
		
		//Declaro el bucle del primer array
		for (int i = 0; i < array1.length; i++) {
			array1[i]=Utils.obtenerNumeroAzar(0, 100);
			System.out.println(array1[i]);
			
		}
		
		//Inicializo el segundo array
		
		System.out.println(); // Salto de linea
		System.out.println("Segundo array\n");
		int array2[]=new int[10];
		
		//Declaro el bucle del segundo array
		for (int i = 0; i < array2.length; i++) {
			array2[i]=Utils.obtenerNumeroAzar(0,100);
			System.out.println(array2[i]);
		}
		
		//Creacion del tercer array pedido
		int arrayfinal[]=new int[10];
		for (int i = 0; i < arrayfinal.length; i++) {
			if(i % 2 ==0) {
				arrayfinal[i]=array1[i];
			}
			else {
				arrayfinal[i]=array2[i];
			}
		}
		System.out.println(arrayfinal);
		
			
	}

}
