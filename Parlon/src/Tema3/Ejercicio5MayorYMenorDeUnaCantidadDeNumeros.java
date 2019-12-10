package Tema3;

import javax.swing.JOptionPane;

public class Ejercicio5MayorYMenorDeUnaCantidadDeNumeros {

	public static void main(String[] args) {
		
		int menor=0;
		int mayor=0;
//Vamos a pedir al usuario una serie de numeros
		int numsaPedir=Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de numeros que vas a introducir"));
		
		for(int i=0;i<numsaPedir;i++) {
			//Pido un numero al usuario
			int numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero: "));
			//Compruebo la primera iteracion
			if(i==0) {
				
				mayor=numero;
				menor=numero;
			}
			//Si no es el primer numero pedido, debe comparar cada numero pedidio con el
			// actual mayor y el actual menor
			else {
				//Comparo con el mayor
				if(numero>mayor) mayor=numero;
				//Comparo con el menor
				if(numero<menor) menor = numero;
			}
		}
		
		//Mostramos al usuario el resultado en pantalla
		System.out.println("El mayor de los numeros introducidos es: "+ mayor +
				"\nEl menor de los numeros introducidos es : " +menor);
	}

}
