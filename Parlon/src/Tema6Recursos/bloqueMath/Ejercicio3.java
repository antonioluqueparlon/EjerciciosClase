package Tema6Recursos.bloqueMath;

import javax.swing.JOptionPane;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		int numero= (int) 0.00001; // esto sera mi termino de precision
		
		System.out.println("pi sera igual : "+pi(numero));
	}

	
	public static double pi(int numero) {
		int denominador=1 ; int signo=1;
		double t,s=0;
		
		for (int i = 1; i <= numero; i++) {
			t=(double)1/denominador*signo;
			s+=t;
			denominador+=2;
			signo*=-1;
			
		}
		return s*4;
	}
	

}
