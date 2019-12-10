package Tema3;

import javax.swing.JOptionPane;


public class Ejercicio4MediaDeNumerosDadosPorElUsuario {

	public static void main(String[] args) {
		
		//Peticion al usuario de los numeros que quiere calcular la nota media
		int numsaPedir= Integer.parseInt(JOptionPane.showInputDialog("Introduce los numeros que quieres calcular la nota media: "));
		int contadorSuma=0; 
		
		for(int i=0; i<numsaPedir; i++) {
		int numero=Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero: "));
		contadorSuma=contadorSuma+=numero;
		}
		
		//Declaramos la variable de la nota media
		int media= contadorSuma/numsaPedir;
				
		//Muestro los datos al usuario
		System.out.println("La nota media de los numeros introducidos es: " + media);

	}

}
