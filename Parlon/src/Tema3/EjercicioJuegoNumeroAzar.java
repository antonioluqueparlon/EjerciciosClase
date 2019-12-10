package Tema3;

import javax.swing.JOptionPane;


public class EjercicioJuegoNumeroAzar {
	
	public static int obtenerNumeroAzar () {
		 return (int) Math.round(Math.random() * 10);
	}
	
	public static void main(String[] args) {
		
		int numAleatorio= obtenerNumeroAzar(); //Declaro la variable del numero aleatorio
		
		
		System.out.println("JUEGO DE AZAR\n");
		
		int numero; // Introduccion de la variable numero
		
		do {
			
		numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero a ver si aciertas: ")); //Le pido al usuario que me digite un numero
				
		if(numero>numAleatorio) {
			System.out.println("Tu numero es Mayor, introduce uno mas pequeño");
		}
		else {
			System.out.println("Tu numero es Menor,introduce uno mas grande");
		}
		}while(numero!=numAleatorio);
		
		JOptionPane.showInputDialog("HAS ACERTADO UEEEEE " );
		System.out.println("numero aleatorio: "+numAleatorio);
				
					
				}
		
		

}
	




