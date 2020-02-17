package Tema6Recursos.ListenerEventos;

public class Escuchador implements BuscaDigitosListener{
	
	int digitos;

	
	/**
	 * @param digitos
	 */
	public Escuchador(int digitos) {
		super();
		this.digitos = digitos;
	}


	@Override
	public void digitosIntroducidos(BuscaDigitosEvent event) {
		System.out.println("Ha escrito la frase con las 3 palabras correctamente.");
	}
	
	

}
