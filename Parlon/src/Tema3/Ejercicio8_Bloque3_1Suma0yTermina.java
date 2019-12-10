package Tema3;

import javax.swing.JOptionPane;

public class Ejercicio8_Bloque3_1Suma0yTermina {

	public static void main(String[] args) {
		int suma=0;
		int num= -1;
	
		
		for(; num!=0; ) {
			num=Integer.parseInt(JOptionPane.showInputDialog("Introduce un número: "));
			suma= suma+num;
		}
		
		System.out.println("El resultado de la suma es: "+suma);
		
	}

}
