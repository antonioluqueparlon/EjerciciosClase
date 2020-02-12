package Tema6Recursos.Excepciones;

import javax.swing.JOptionPane;

public class Bombilla {

	private static String getException(String palabra) throws PalabrasException {
		StringBuffer str = new StringBuffer();

		if (!palabra.contains("bombilla")) { // tiene que contener bombilla
			throw new PalabrasException("no contiene bombilla");
		}
		else {
			str.append("La frase contiene a bombilla");
			String[] palabras = palabra.split(" "); // esto es para los espacios en blanco
			if (palabra.length() < 3) { // mas de 3 palabras
				throw new PalabrasException(" La frase tiene menos de 3 palabras");
			}
			else {
				str.append(" La frase tiene mas de 3 palabras");
			
				if (palabra.contains("tonto") || palabra.contains("tonta") || palabra.contains("idiota")) { // contenido
																										// ofensivo
					throw new PalabrasException(" La frase no debe contener palabras ofensivas");
				}
			}
		}

		return str.toString();
	}

	public static void main(String[] args) {
		try {
			String palabra = JOptionPane.showInputDialog("Introduce una frase: ");
			System.out.println(getException(palabra));
		} catch (PalabrasException e) {
			System.out.println("Hay excepciones en la frase ," +e.getMessage());
		}
	}

}
