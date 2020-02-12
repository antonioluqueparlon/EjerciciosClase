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
			contrasena = JOptionPane.showInputDialog("Introduzca contraseña, que tenga:\n"
					+ "- Al menos una mayúscula.\n" + "- Al menos una minúscula.\n" + "- Al menos un dígito\n"
					+ "- Al menos un carácter no alfanumérico.");
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
			JOptionPane.showMessageDialog(null, "La contraseña no tiene mayusculas");

		}
		if (minus = false) {
			JOptionPane.showMessageDialog(null, "La contraseña no tiene minusculas");

		}
		if (digit = false) {
			JOptionPane.showMessageDialog(null, "La contraseña no tiene un dígito");

		}
		if (listo = false) {
			JOptionPane.showMessageDialog(null, "La contraseña no tiene un caracter alfanumérico");

		}
		if (listo = true) {
			JOptionPane.showMessageDialog(null, "La contraseña ha sido cambiada con éxito");
		}
	}

	public static void main(String[] args) {
		setContrasena();
		
	}

}
