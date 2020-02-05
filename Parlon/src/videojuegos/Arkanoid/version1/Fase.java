package videojuegos.Arkanoid.version1;

import java.util.ArrayList;
import java.util.List;


public abstract class Fase {
	
	// Lista de actores a colocar en cualquier fase
	protected List<Actor> actores = new ArrayList<Actor>();
	
	// Método que debe implementar cada Fase
	public abstract void inicializaFase ();

	// Getter de la lista de actores
	public List<Actor> getActores() { return actores; }
	
	//Musica de fondo de Dragon Ball para el inicio de la primera fase
	public String getNombreSonidoInicio () {
		return "musicadbfondo.wav";
	}
}
