package Tema6Recursos.Wrappers;

import javax.swing.JOptionPane;

public class Ejercicio2 {
	static String contrasena;
	static char locura[];
	static boolean mayus = false;
	static boolean minus = false;
	static boolean digit = false;
	static boolean listo = false;

	public static void setContrasena() {
		do {
			contrasena = JOptionPane.showInputDialog("Introduzca contrase�a, que tenga:\n"
					+ "- Al menos una may�scula.\n" + "- Al menos una min�scula.\n" + "- Al menos un d�gito\n"
					+ "- Al menos un car�cter no alfanum�rico.");
			locura = new char[contrasena.length()];
			for (int i = 0; i < contrasena.length(); i++) {
				locura[i] = contrasena.charAt(i);
			}
			comparaContrasena();
		} while (!(mayus && minus && digit && listo));
	}

	public static void comparaContrasena() {
		for (int i = 0; i < contrasena.length(); i++) {
			if (Character.isUpperCase(locura[i])) {
				mayus = true;
				if (Character.isLowerCase(locura[i])) {
					minus = true;
					if (Character.isDigit(locura[i])) {
						digit = true;
						if (!Character.isLetterOrDigit(locura[i])) {
							listo = true;
						}
					}
				}
			}
		}

		llamadorBooleans();
	}

	private static void llamadorBooleans() {
		if (mayus = false) {
			JOptionPane.showMessageDialog(null, "La contrase�a no tiene mayusculas");

		}
		if (minus = false) {
			JOptionPane.showMessageDialog(null, "La contrase�a no tiene minusculas");

		}
		if (digit = false) {
			JOptionPane.showMessageDialog(null, "La contrase�a no tiene un d�gito");

		}
		if (listo = false) {
			JOptionPane.showMessageDialog(null, "La contrase�a no tiene un caracter alfanum�rico");

		}
		if (listo = true) {
			JOptionPane.showMessageDialog(null, "La contrase�a ha sido cambiada con �xito");
		}
	}

	public static void main(String[] args) {
		setContrasena();
		
	}

}
