package Tema6Recursos.ListenerEventos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio1 {

	private static List<BuscaDigitosListener> buscaDigitosListeners = new ArrayList<BuscaDigitosListener>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numUsuario;
		Escuchador escuchador1 = new Escuchador(1);
		addBuscaDigitosListener(escuchador1);

		do {
			numUsuario = JOptionPane.showInputDialog("Introduce una frase que tenga 3 dígitos: ");

			int contadorDigitos = 0;

			for (int i = 0; i < numUsuario.length(); i++) {

				if (Character.isDigit(numUsuario.charAt(i))) {
					contadorDigitos++;
				}
			}

			if (contadorDigitos == 3) {
				BuscaDigitosEvent event = new BuscaDigitosEvent("3");
				fireBuscaDigitosListeners(event);
			}
		} while (!numUsuario.equals(""));
		
		System.exit(0);

	}


	// getter y setters
	public static void fireBuscaDigitosListeners(BuscaDigitosEvent event) {
		for (BuscaDigitosListener listener : buscaDigitosListeners) {
			listener.digitosIntroducidos(event);
		}
		
	}

	public static void removeBuscaDigitosListener(BuscaDigitosListener listener) {
		buscaDigitosListeners.remove(listener);
			
	}

	public static void addBuscaDigitosListener(BuscaDigitosListener listener) {
		buscaDigitosListeners.add(listener);
			
	}

}
