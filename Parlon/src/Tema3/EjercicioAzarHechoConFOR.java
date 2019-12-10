package Tema3;

import javax.swing.JOptionPane;


public class EjercicioAzarHechoConFOR {
	
	
	public static void main(String[] args) {
		
		int numAleatorio= (int) Math.round(Math.random() * 100);; //Declaro la variable del numero aleatorio
		
		
		System.out.println("JUEGO DE AZAR\n");
		
		int numero; // Introduccion de la variable numero
		
		do {
			
		numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero a ver si aciertas: ")); //Le pido al usuario que me digite un numero
				
		if(numero>numAleatorio) {
			System.out.println("Tu numero es Mayor, introduce uno mas pequeño");
		}
		else {// El numero coincide y ha acertado
			System.out.println("Tu numero es Menor,introduce uno mas grande");
		}
		}while(numero!=numAleatorio);
		
		JOptionPane.showInputDialog("HAS ACERTADO UEEEEE " );
		System.out.println("numero aleatorio: "+numAleatorio);
				
					
		}
		
		

}