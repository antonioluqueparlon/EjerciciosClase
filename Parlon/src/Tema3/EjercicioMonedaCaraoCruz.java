package Tema3;

import javax.swing.JOptionPane;

import Parlon.Utils;


public class EjercicioMonedaCaraoCruz {

	public static void main(String[] args) {
		
		int contadorPersona=0;
		int contadorMaquina=0;
		
		int numeroAzar=Utils.obtenerNumeroAzar(1,2) ;
		
	for(;contadorPersona!=2 && contadorMaquina!=2;) {
		
		int num=Integer.parseInt(JOptionPane.showInputDialog("¿Que eliges cara o cruz? \n1.Cara \n2.Cruz"));
		if(num==numeroAzar) {
			JOptionPane.showInputDialog("HAS ACERTADO");
		contadorPersona++;
		}
		else {
			JOptionPane.showInputDialog("HAS PERDIDO");
			contadorMaquina++;
		}
		
		
	
	}
	System.out.println("Has obtenido: "+contadorPersona +" victorias");
	System.out.println("HAs obtenido: "+contadorMaquina +" derrotas");

	}

}


