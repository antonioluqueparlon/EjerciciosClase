package Tema6Recursos.bloqueMath;

public class Ejercicio2 {

	public static void main(String[] args) {

		float x= (float) 0;
		
		puntoCorte(x);
	}	
	
	public static void puntoCorte (float x) {
		float y1;
		float y2;
			
		
		do {
			x += 0.0001;
			y1 = (float) Math.sqrt(x);
			System.out.println("La gráfica se corta en las siguientes coordenadas: " +x+", y " +y1);
			y2 = (float) (0 - Math.log(x));
			System.out.println("La gráfica se corta en las siguientes coordenadas: " +x+", y " +y2);
		} while (Math.abs(y1-y2)<0.001);
	}			
			
}
		
	
