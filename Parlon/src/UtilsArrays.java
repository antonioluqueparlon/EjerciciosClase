

public class UtilsArrays {

	/**
	 * 
	 * @param array
	 */
	public static void mostrarArray (int[] array) {
		System.out.println("Contenido del array");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			
		}
		//Salto de linea
		System.out.println();
	}
	
	/**
	 * 
	 * @param longitud
	 * @param limInf
	 * @param limSup
	 * @return
	 */
	public static int[] creaArrayNumerosAzar (int longitud, int limInf, int limSup) {
		int array[] = new int[longitud];
		for (int i = 0; i < array.length; i++) {
			array[i] = Utils.obtenerNumeroAzar(limInf, limSup);
		}
		return array;
	}
	
	public static int[] creaArrayNumerosUsuario (int longitud, int limInf, int limSup) {
		int array[] = new int[longitud];
		for (int i = 0; i < array.length; i++) {
			array[i] = Utils.obtenerNumUsuario();
		}
		return array;
	}
	
	public static int getValorCentralDeArray (int array[]) {
		System.out.println("Longitud de array: " + array.length);
		if (array.length % 2 == 1) {// longitud impar
			return array[array.length/2];
		}
		return -1;
	}
	
	public static void inicializarMatrizConValoresAlAzar (int matriz[][], int min,int max) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j]=Utils.obtenerNumeroAzar(min, max);
			}
		}
	}

	
	public static void MostrarMatriz (int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " \t");
			}
			System.out.println();
		}
	}
	
}
