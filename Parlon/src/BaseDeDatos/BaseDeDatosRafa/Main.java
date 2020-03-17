package BaseDeDatos.BaseDeDatosRafa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		menuPrincipal();
	}

	
	/**
	 * @throws ParseException 
	 * 
	 */
	private static void menuPrincipal() throws ParseException {

		int opcionElegida;
		do {
			System.out.println("\n\t\t\tGESTI�N DE VENTAS DE COCHES");
			
			System.out.println("\n\t1.- Gesti�n de fabricantes.");
			System.out.println("\t2.- Gesti�n de concesionarios.");
			System.out.println("\t3.- Gesti�n de clientes.");
			System.out.println("\t4.- Gesti�n de ventas.");
			System.out.println("\t5.- Gesti�n de coches.");
			System.out.println("\t0.- Salir");
			System.out.println("\n\tElija una opci�n: ");
			
			opcionElegida = Utils.getIntConsola(0, 5);
			
			switch (opcionElegida) {
			case 0:
				System.out.println("\n!Hasta Luego compa!");
				break;
			case 1:
				GestionFabricante.menuGestion();
			case 2:
				GestionConcesionario.menuGestion();
			case 3:
				GestionClientes.menuGestion();
			case 4:
				GestionVentas.menuGestion();
			case 5:
				GestionCoches.menuGestion();
			}
		} while (opcionElegida != 0);
	}
	
}
