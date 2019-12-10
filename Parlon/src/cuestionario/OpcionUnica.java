package cuestionario;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class OpcionUnica extends Preguntas {
	String opciones [];
		
	/**
	 * @param enunciado
	 * @param respuestaCorrecta
	 * @param opciones
	 */
	public OpcionUnica(String enunciado, int respuestaCorrecta, String[] opciones) {
		super(enunciado, respuestaCorrecta);
		this.opciones = opciones;
	}

	public int mostrarPantalla () {
		String enunciadoAMostrar = this.enunciado;
		for (int i = 0; i < opciones.length; i++) {
			enunciadoAMostrar=enunciadoAMostrar+ "\n" + (i+1) + ".-" + this.opciones[i];
		}
		return Integer.parseInt(JOptionPane.showInputDialog(enunciadoAMostrar));
	}

	@Override
	public String toString() {
		return "OpcionUnica [opciones=" + Arrays.toString(opciones) + "]";
	}

	/**
	 * @return the opciones
	 */
	public String[] getOpciones() {
		return opciones;
	}

	/**
	 * @param opciones the opciones to set
	 */
	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}

	

	
	
	

}
