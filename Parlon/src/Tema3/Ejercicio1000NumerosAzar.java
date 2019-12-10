package Tema3;

import Parlon.Utils;

public class Ejercicio1000NumerosAzar { //Tenemos que imprimir 1000 numeros al azar y que nos haga la media 
										// y nos calcule el mayor y el menor

	public static void main(String[] args) {
		
		int numAzar=Utils.obtenerNumeroAzar(0,101);
		int mayor=0;
		int menor=0;
		int media=0;
		int suma=0;
				
		for (int i=0; i<101; i++) {
			System.out.println("Numero "+i+":"+numAzar);
			suma =suma+=numAzar;
					
					//Declaramos las primeras iteraciones);
		}
		
		//Mostramos al usuario los resultados finales
		
		System.out.println("La suma será: "+suma);

	}

}
