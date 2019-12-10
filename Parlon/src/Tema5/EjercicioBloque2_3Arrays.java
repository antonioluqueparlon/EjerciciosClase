package Tema5;

import javax.swing.JOptionPane;

import Parlon.Utils;

public class EjercicioBloque2_3Arrays {

	public static void main(String[] args) {
//Iniacializamos el primer array
		int array[]=new int[100];
		int numeroPedido=obtenerNumUsuario("mensaje");	
				
		//Bucle array y muestro en pantalla
		for (int i = 0; i < array.length; i++) {
			array[i]=Utils.obtenerNumeroAzar(0,100);
			array[i]*=numeroPedido;
			
		}
		System.out.println(array);
	}
	
	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	public static int obtenerNumUsuario (String mensaje) {
		int num= Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return num;
	}

}
