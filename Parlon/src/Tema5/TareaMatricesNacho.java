package Tema5;

import Parlon.Utils;
import Parlon.UtilsArrays;
import Parlon.UtilsMatrices;

/**
*Disponemos de una matriz de enteros generados de manera aleatoria, de tamaño 10x10. (Matriz 1)
*Queremos realizar una modificación de los valores de cada una de sus celdas, según otra pequeña matriz de tamaño 3x3. (Matriz 2)
*La modificación consiste en incrementar el valor de la celda de la matriz 1 el número de unidades que indica la matriz 2.
*Y este número de unidades será la media de los números de la matriz 2 al posicionar la celda central de Matriz 2 sobre la celda en cuestión de Matriz 1.
*Si la celda es la 0,0 no se tendrán en cuenta las posiciones de la Matriz 2 que se “salgan” de la Matriz 1.
*/

public class TareaMatricesNacho {

	public static void main(String[] args) {
		
		int matriz[][]=new int[3][3];
		
		//Relleno la matriz
		UtilsMatrices.inicializarMatrizConValoresUsuario(matriz);
		
		//imprimir en pantalla 
		UtilsMatrices.imprimeMatriz(matriz);
		

	}
}


