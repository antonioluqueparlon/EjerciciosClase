package operar_arrays;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int suma= 0;
		int media=0;
		int contador=0;
		int sumaImpares=0;
		int sumaPares=0;
		// Declaración de array
				int array[] = rellena_arrays(10, 1, 20);

		// Mostramos el array
				mostrarArray(array);

		//	Metodo sumar elementos del array
				sumar_array(array, suma);
				
		// suma pares
				sumaimpares_array(array, sumaImpares,sumaPares);
	
	}
			

			/**
			 *
			 * @param longitud
			 * @param limInf
			 * @param limSup
			 * @return
			 */
			public static int[] rellena_arrays(int longitud, int limInf, int limSup) {
				int array[] = new int[longitud];
				for (int i = 0; i < array.length; i++) {
					array[i] = Utils.obtenerNumeroAzar(limInf, limSup);
				}
				return array;
			}

			/**
			 *
			 * @param array
			 */
			public static void mostrarArray(int[] array) {
				System.out.println("Contenido del array");
				for (int i = 0; i < array.length; i++) {
					System.out.print(array[i] + " ");
				}
			}
			
			public static void sumar_array(int[] array, int suma) {
				for (int numero : array) {

					suma += numero;
				}
				// Imprimo el resultado
				System.out.println("\nSuma elementos del array: " + suma );

			}
			public static void sumaimpares_array(int[]array, int sumaImpares, int sumaPares ) {
				for (int i = 0; i < array.length; i++) {
					if (i % 2 == 0 ) {
						sumaPares+=array[i];
					}
				else {
					sumaImpares+=array[i];
				}
				}
				System.out.println("La suma de impares es : "+sumaImpares);
			}

			/**
			 *
			 * @return
			 */
			private static int obtenerNumeroAleatorio() {
				return (int) Math.round(Math.random() * 100);
			}

			/**
			 *
			 * @return
			 */
			private static int obtenerNumeroAleatorio(int limiteInferior, int limiteSuperior) {
				return (int) Math.round(Math.random() * (limiteSuperior - limiteInferior) + limiteInferior);
			}

	}


