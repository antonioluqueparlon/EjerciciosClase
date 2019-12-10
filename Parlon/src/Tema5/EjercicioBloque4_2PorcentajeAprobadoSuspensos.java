package Tema5;

import Parlon.UtilsArrays;

public class EjercicioBloque4_2PorcentajeAprobadoSuspensos {

	public static void main(String[] args) {
		//Creamos el array del ejercicio
		int array[]=UtilsArrays.creaArrayNumerosAzar(21, 0, 10);
		//Mostrar array al usuario
		UtilsArrays.mostrarArray(array);
		//Creo mi contador de suspensos y aprobados
		float aprobados=0;
		float suspensos=0;
		float porcentajeAprobados,porcentajeSuspensos; //Creo la variable del porcentaje
		
		//Recorro el array
		for (int i = 0; i < array.length; i++) {
			if(array[i]>=5) {
				aprobados++;
			}
			else {
				suspensos++;
			}
		}
		porcentajeAprobados= aprobados/array.length*100;
		porcentajeSuspensos= suspensos/array.length*100;
		
		
		//Muestro en pantalla los resultados de los porcentajes
		
		System.out.println("Porcentaje de notas aprobadas: "+porcentajeAprobados + "%"); 			
		System.out.println("Porcentaje de suspensos: "+(100-porcentajeAprobados) + "%"); 			
	}
	
	
}