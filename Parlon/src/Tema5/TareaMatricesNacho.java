package Tema5;

import Parlon.Utils;
import Parlon.UtilsArrays;
import Parlon.UtilsMatrices;

/**
*Disponemos de una matriz de enteros generados de manera aleatoria, de tama�o 10x10. (Matriz 1)
*Queremos realizar una modificaci�n de los valores de cada una de sus celdas, seg�n otra peque�a matriz de tama�o 3x3. (Matriz 2)
*La modificaci�n consiste en incrementar el valor de la celda de la matriz 1 el n�mero de unidades que indica la matriz 2.
*Y este n�mero de unidades ser� la media de los n�meros de la matriz 2 al posicionar la celda central de Matriz 2 sobre la celda en cuesti�n de Matriz 1.
*Si la celda es la 0,0 no se tendr�n en cuenta las posiciones de la Matriz 2 que se �salgan� de la Matriz 1.
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


