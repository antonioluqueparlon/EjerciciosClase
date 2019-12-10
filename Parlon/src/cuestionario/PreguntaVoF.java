package cuestionario;

import javax.swing.JOptionPane;

public class PreguntaVoF extends Preguntas {
	/**
	 * @param enunciado
	 * @param respuestaCorrecta
	 * @param opcionCorrecta
	 */
	public PreguntaVoF(String enunciado, int respuestaCorrecta) {
		super(enunciado, respuestaCorrecta);
	}


	public void mostrarPantalla () {
		String enunciadoAMostrar = enunciado + "\n1.-Verdadero\n2.-Falso";
		String respuesta = JOptionPane.showInputDialog(enunciadoAMostrar);
		int respuestaInt = Integer.parseInt(respuesta);
		
		if (esCorrecta(respuestaInt)) {
			System.out.println("Acertastee uee");
		}
		else {
			System.out.println("Has fallao :( ");
		}
	}

}
