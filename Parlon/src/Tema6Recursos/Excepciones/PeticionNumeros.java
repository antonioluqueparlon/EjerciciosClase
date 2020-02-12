package Tema6Recursos.Excepciones;

import java.util.Scanner;

public class PeticionNumeros {

	
	public static int pideNumeroPar() throws NumeroImparException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int numero= sc.nextInt();
		
		if(numero % 2 == 1) {
			throw new NumeroImparException();
		}
		return numero;
	}
	
	public static void main(String[] args) {
		System.out.println("Introduce un numero par: ");
		int num;
		try {
			num=pideNumeroPar();
		} catch (NumeroImparException e) {
			System.out.println("El numero introducido es impar");
		}
	

	}

	
}