package cuestionario;

public class Preguntas {
	
	protected String enunciado;
	private int respuestaCorrecta;

	@Override
	public String toString() {
		return "Preguntas [enunciado=" + enunciado + ", respuestaCorrecta=" + respuestaCorrecta + "]";
	}

	/**
	 * @param enunciado
	 * @param respuestaCorrecta
	 */
	public Preguntas(String enunciado, int respuestaCorrecta) {
		super();
		this.enunciado = enunciado;
		this.respuestaCorrecta= respuestaCorrecta;
	}
	
	public boolean esCorrecta (int respuestaUsuario) {
		return this.respuestaCorrecta == respuestaUsuario;
	}
	
	public void mostrarPantalla () {
		return;
		
	}

}
