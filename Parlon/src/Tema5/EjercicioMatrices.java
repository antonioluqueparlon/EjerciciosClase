package Tema5;

import Parlon.Utils;
import Parlon.UtilsArrays;
import Parlon.UtilsMatrices;

public class EjercicioMatrices {

	public static void main(String[] args) {
		//Declaracion de una matriz
		int matriz[][]= new int [5][5];
		
		//Rellena la matriz
		inicializarMatrizValoresDadosUsuario(matriz, 0, 100);
		
		//Mostrar en pantalla
		MostrarMatriz(matriz);
		
		
		//Comprobar si es positiva
		System.out.println();
		esMatrizPositiva(matriz);
		
		//Compruebo si es positiva 2
		boolean esPositiva=esMatrizPositiva2(matriz);
		if(esPositiva) {
			System.out.println("La matriz es positiva");
		}
		else {
			System.out.println("La matriz no es positiva");
		}
		
		//Compruebo si la matriz es superior
		if(matrizTriangularSuperior(matriz)) {
			System.out.println("La matriz es superior");
		}
		else {
			System.out.println("La matriz no es superior");
		}
		
		//Comprueba la diagonal de la matriz 
		boolean esDiagonal=diagonalMatriz(matriz);
			if(esDiagonal) {
			System.out.println("La matriz es diagonal");
		}
		else {
			System.out.println("La matriz no es diagonal");
		}
		
			System.out.println();
		//Matriz Opuesta
		matrizOpuesta(matriz);
		
		System.out.println();
		
		//Comprubo si la matriz es dispersa
		if(esMatrizDispersa(matriz)) {
			System.out.println("La matriz es dispersa");
		}
		else {
			System.out.println("La matriz no es dispersa");
		}
		
		//comversion de matriz a array
		//UtilsArrays.mostrarArray(array);
		
	}
	

	/**
	 * 
	 * @param matriz
	 * @param min
	 * @param max
	 */
	public static void inicializarMatrizConValoresAlAzar (int matriz[][], int min,int max) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j]=Utils.obtenerNumeroAzar(min, max);
			}
		}
	}
	
	/**
	 * 
	 * @param matriz
	 * @param min
	 * @param max
	 */
	public static void inicializarMatrizValoresDadosUsuario (int matriz[][], int min,int max) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j]=Utils.obtenerNumUsuario("Introduce un numero", min, max);
			}
		}
	}

	/**
	 * 
	 * @param matriz
	 */
	public static void MostrarMatriz (int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " \t");
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param matriz
	 */
	
	public static void esMatrizPositiva( int matriz [][]) {
		boolean positiva=true;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]<0 ) { //Hay un elemento negativo, no es positiva
					positiva=false;
				}
			}
		}
		if(positiva==true) {
			System.out.println("La matriz es positiva");
		}
		else {
			System.out.println("La matriz no es positiva");
		}
	}
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	
	public static boolean diagonalMatriz(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				//Compruebo si hay algun elemento fuera de la diagonal principal,
				//que no sea valor cero
				if (i!=j && matriz[i][j] != 0) {
					return false;
				}
				
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	
	public static boolean matrizTriangularSuperior (int matriz [][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				//Compruebo si hay un elemento debajo de la diagonal
				//principal distinto de cero.
				//Todos los elementos debajo de esa diagonal
				//cumple la condicion de que i>j
				if(i>j && matriz[i][j] !=0) {
					return false;
				
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	
	public static boolean esMatrizDispersa(int matriz[][]) {
		//voy a comprobar si todas las filas tienen al menos un elemento
		//igual a cero
	for (int i = 0; i < matriz.length; i++) {
		//la i me recorre todas las filas
		//con un bucle de j recorro todos los elementos de la fila
		boolean noHayCeros=true;
		for (int j = 0; j < matriz[i].length; j++) {
			if(matriz[i][j] == 0) { //En la fila "i" hay al menos un cero 
				noHayCeros=false;
			}
		}
		
		if (noHayCeros) {
			return false;
		}
		
	}
			
	return true;	
	}
	
	
	
	
	/**
	 * 
	 * @param matriz
	 */
	
	public static void matrizOpuesta (int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j]*=-1;
				System.out.print(matriz[i][j] + " \t");
			}
			System.out.println();
			
		}
		
	}
	
	
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	
	public static boolean esMatrizPositiva2 (int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]<0) { //Hay un elemento negativo, no es positiva
					return false;
				}
				
			}
		}
		return true;

	}
}
