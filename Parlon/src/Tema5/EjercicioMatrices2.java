package Tema5;

import Parlon.Utils;

public class EjercicioMatrices2 {

	public static void main(String[] args) {
		//Declaracion de una matriz
		int matriz[][]=new int [5][5];

		//Rellena la matriz
		inicializarMatrizConValoresAlAzar(matriz, -100, 100);
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
		if(esMatrizSuperior(matriz)) {
			System.out.println("La matriz es superior");
		}
		else {
			System.out.println("La matriz no es superior");
		}
		
		//Comprueba la diagonal de la matriz 
		diagonalMatriz(matriz);
		
		//Matriz Opuesta
		MatrizOpuesta(matriz);
		
		//Comprubo si la matriz es dispersa
		if(esMatrizDispersa(matriz)) {
			System.out.println("La matriz es dispersa");
		}
		else {
			System.out.println("La matriz no es dispersa");
		}
		
	}
	
	private static boolean esMatrizSuperior(int[][] matriz) {
		// TODO Auto-generated method stub
		return false;
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
	 */
	
	public static void diagonalMatriz(int matriz[][]) {
		int diagonalMatriz []= new int [matriz.length];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i==j) {
					diagonalMatriz[i] =matriz[i][j];
				}
				
			}
			System.out.println("La diagonal es " +diagonalMatriz[i]);

		}
		
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
	public static void MatrizSimetrica (int matriz[][]) {
		int nFilas = 0,nColumnas=0;
		boolean esSimetrica = true;
		for (int i = 0; i < matriz.length; i++) { // i es el numero de filas
			for (int j = 0; j < matriz.length; j++) { // j es el numero de columnas
				
				//Compruebo si es simetrica
				if (nFilas==nColumnas) {
					
					i=0;
					esSimetrica=true;// si el numero de filas es igual al numero de columnas
					while (i<nFilas && esSimetrica==true)
						j=0;
				}
				else {
					System.out.println("La matriz no es simetrica");
				}
			}
		}
	}
	
	public static void MatrizOpuesta (int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
			}
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
