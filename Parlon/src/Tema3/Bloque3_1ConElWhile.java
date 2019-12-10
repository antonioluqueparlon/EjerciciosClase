package Tema3;

import javax.swing.JOptionPane;

public class Bloque3_1ConElWhile {

	public static void main(String[] args) {
			int suma = 0, num=-1;
			

			while (num != 0) {
				num = Integer.parseInt(JOptionPane.showInputDialog(
						"Introduzca número (0 -> Salir): "));
				suma = suma + num;
			}
			
			// Sacamos el mensaje final con el valor acumulado
			JOptionPane.showMessageDialog(null, "Total acumulado " + suma);

		}

	}