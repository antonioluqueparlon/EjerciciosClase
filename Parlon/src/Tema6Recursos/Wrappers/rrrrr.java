package Tema6Recursos.Wrappers;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class rrrrr {

	public static void main(String[] args) {
		
		int decimal =Integer.parseInt(JOptionPane.showInputDialog("numero"));
		
      
		 // 2º método con array
        char digitosHexadecimales[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        System.out.println("Los primeros 100 numeros en hexadecimal son estos: "+digitosHexadecimales.toString());
        String hexadecimal2 = "";
        int resto, aux = decimal;
        for (int i = 0; i < digitosHexadecimales.length; i++) {
			
		}
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal2 = digitosHexadecimales[resto] + hexadecimal2;
            aux /= 16; 
        }
        for (int i = 0; i < 100; i++) {
        	System.out.printf(" Decimal: %d, Hexadecimal: %s", decimal, hexadecimal2);
		}
        
    }
}
