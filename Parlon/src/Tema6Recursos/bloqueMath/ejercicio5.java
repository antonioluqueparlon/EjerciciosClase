package Tema6Recursos.bloqueMath;
;

public class ejercicio5 {

	public static void main(String[] args) {
		
		double anterior2=0,anterior=0,actual=0;
		
		double x=(float) 0;
		for (int i = 0; i < 5; i++) {
			do {
				anterior2=anterior;
				anterior=actual;
				actual= x*Math.sin(x);
				
				x+=0.001;	
			} while (!(anterior>actual && anterior >anterior2));
			System.out.println("x: " + x + " -y: " + actual + " - y ant: "+ anterior +" y anterior 2: "+anterior2);
			
		}	
		System.out.println();
	}

}
