package Tema6Recursos.ListenerEventos;

public class Perro implements BuscaDigitosListener{
	
	String digito;

	
	public Perro(String digito) {
		this.digito = digito;
		Ejercicio1.addBuscaDigitosListener(this);
	}
	
	public void digitosIntroducidos(BuscaDigitosEvent event) {
		System.out.println("has creado palabras");
	}
	
	

}
