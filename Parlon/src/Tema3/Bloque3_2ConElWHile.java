package Tema3;

import javax.swing.JOptionPane;

public class Bloque3_2ConElWHile {

	public static void main(String[] args) {
			int suma = 0, num = -1; 
			int media=0;
			int acumulador=0;

			while ( num != 0) {
				num = Integer.parseInt(JOptionPane.showInputDialog(
						"Introduzca número (0 -> Salir): "));
				acumulador++;
				suma = suma + num;
				media= suma/acumulador;
					 
		
			}
			// Sacamos el mensaje final con el valor acumulado
			System.out.println("Media= "+ media);
		
		}
		
		

	}
