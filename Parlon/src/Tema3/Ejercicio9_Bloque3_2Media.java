package Tema3;

import javax.swing.JOptionPane;

public class Ejercicio9_Bloque3_2Media {

	public static void main(String[] args) {
		int suma=0;
		int num= -1;
		int i;
	
	
		for( i=0; num!=0; i++) {
			num=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero: "+"\n 0 para salir"));
			suma=suma+num;
		}
		
		System.out.println("El resultado de la media es: "+(float)suma/(i-1));
		
	}

}


