package Tema6Recursos.Wrappers;

public class Ejercicio1 {

	public static void main(String[] args) {
		maximosRepresentables();
		minimosRepresentables();
		
	}
		private static void maximosRepresentables() {
			

			System.out.println("Limites máximos representables "+Byte.MAX_VALUE +" en bytes son: " +Byte.MAX_VALUE*Byte.BYTES);
			System.out.println("Limites máximos representables "+Integer.MAX_VALUE +" en bytes son: " +Integer.MAX_VALUE*Integer.BYTES);
			System.out.println("Limites máximos representables "+Short.MAX_VALUE +" en bytes son: " +Short.MAX_VALUE*Short.BYTES);
			System.out.println("Limites máximos representables "+Long.MAX_VALUE +" en bytes son: " +Long.MAX_VALUE*Long.BYTES);
			System.out.println("Limites máximos representables "+Float.MAX_VALUE +" en bytes son: " +Float.MAX_VALUE*Float.BYTES);
			System.out.println("Limites máximos representables "+Double.MAX_VALUE +" en bytes son: " +Double.MAX_VALUE*Double.BYTES );
		
			System.out.println("\n");
		}
		
		
		
		
		private static void minimosRepresentables() {
			
			System.out.println("Limites minimos representables "+Byte.MIN_VALUE +" en bytes son: " +Byte.MIN_VALUE*Byte.BYTES);
			System.out.println("Limites minimos representables "+Integer.MIN_VALUE +" en bytes son: " +Integer.MIN_VALUE*Integer.BYTES);
			System.out.println("Limites minimos representables "+Short.MIN_VALUE +" en bytes son: " +Short.MIN_VALUE*Short.BYTES);
			System.out.println("Limites minimos representables "+Long.MIN_VALUE +" en bytes son: " +Long.MIN_VALUE*Long.BYTES);
			System.out.println("Limites minimos representables "+Float.MIN_VALUE +" en bytes son: " +Float.MIN_VALUE*Float.BYTES);
			System.out.println("Limites minimos representables "+Double.MIN_VALUE +" en bytes son: " +Double.MIN_VALUE*Double.BYTES);
		
		}
}

