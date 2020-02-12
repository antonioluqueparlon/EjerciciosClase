package Tema6Recursos.Date;

import java.util.Calendar;
import java.util.TimeZone;

public class Ejercicio2 {

	private static void ZonasHorarias() {
		Calendar ahoraEnRoma = Calendar.getInstance(TimeZone.getTimeZone("Europe/Roma"));
		Calendar ahoraEnSidney = Calendar.getInstance(TimeZone.getTimeZone("Europe/Sydney"));
		//Calendar ahoraEnMadrid= Calendar.getInstance(TimeZone.getTimeZone(ID))

		System.out.println("Hora en Roma: " + ahoraEnRoma.get(Calendar.HOUR) + ":" + ahoraEnRoma.get(Calendar.MINUTE));
		System.out.println(
				"Hora en Sidney: " + ahoraEnSidney.get(Calendar.HOUR) + ":" + ahoraEnSidney.get(Calendar.MINUTE));
		System.out.println();
		float dias = (float) ((ahoraEnRoma.get(Calendar.HOUR) - ahoraEnSidney.get(Calendar.HOUR)));
		System.out.println("Diferencia entre Roma y Sidney: " + dias);
	}

	public static void main(String[] args) {
		ZonasHorarias();

	}

}
