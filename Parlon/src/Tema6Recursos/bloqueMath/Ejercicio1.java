package Tema6Recursos.bloqueMath;

import javax.swing.JOptionPane;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		int a=Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor a de la ecuación: "));
		int b=Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor a de la ecuación: "));
		int c=Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor a de la ecuación: "));
		float[] resultado=ecuacionSegundoGrado(a, b ,c); // es un array porque la ecuacion de segundo grado me tiene que 
														// dar dos resultados
System.out.println("Las soluciones de la ecuacion son: "+resultado[1]+" y "+resultado[2]);
		
	}
	
	public static float[] ecuacionSegundoGrado(float a,float b,float c) {
		
		float resultado[]=new float[2];
		resultado[1]=(float) ((-b +  Math.sqrt(b*b)- 4*a*c)/(float)(2*a));
		resultado[2]=(float) ((-b -  Math.sqrt(b*b)- 4*a*c)/(float)(2*a));
		
		return resultado;
		
	}

}
