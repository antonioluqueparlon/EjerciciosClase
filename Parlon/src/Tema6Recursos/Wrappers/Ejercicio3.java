package Tema6Recursos.Wrappers;

import java.util.Scanner;

public class Ejercicio3 {
 
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número decimal: ");
        int decimal = teclado.nextInt();
        teclado.close();
         
        // 1º método con toHexString 
        String hexadecimal = Integer.toHexString(decimal);
        System.out.printf("%nMétodo 1 -> Decimal: %d, Hexadecimal: %s", decimal, hexadecimal);
         
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
        System.out.printf("%n%nMétodo 2 -> Decimal: %d, Hexadecimal: %s", decimal, hexadecimal2);
    }
}