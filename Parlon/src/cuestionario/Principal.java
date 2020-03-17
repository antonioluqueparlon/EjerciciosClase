package cuestionario;

public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		//Creo mis preguntas
		
		Preguntas Pregunta[] = new Preguntas[4];
		int contadorRespuestasAcertadas = 0; 
		
		Pregunta[0] =new PreguntaVoF ("La capital de España es Madrid", 1); ////1 es Verdadero 2 es Falso 
		Pregunta[1] =new Preguntas ("El alcohol activa los neurotransmisores",2); //1 es Verdadero 2 es Falso
		Pregunta[2] =new Preguntas ("Mañana es jueves",1);//1 es Verdadero 2 es Falso
		Pregunta[3] =new OpcionUnica ("Capital de España",1, new String[]{"Madrid","Barcelona","Valencia","Sevilla"});
	
	
		//Muestro en pantalla
		System.out.println("Rspuestas acertadas: " + contadorRespuestasAcertadas);
		
		
	}

}
