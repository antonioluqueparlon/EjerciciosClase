package Tema6Recursos.Date;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Ejercicio1 {

	public static void main(String[] args) {
		pedirfecha();
		
		ejemploSumaRestaFechas();
	}

	private static void pedirfecha() {
		String fecha1 = JOptionPane.showInputDialog("Introduce una fecha: ");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		formateoFecha(fecha1, sdf2);
	}

	private static void formateoFecha(String fecha1, SimpleDateFormat sdf2) {
		Date fecha = null;
		try {
			fecha = (Date) (sdf2.parse(fecha1));
			System.out.println(fecha);
		} catch (ParseException e) {
			System.out.println("Error en el parseo de la fecha");
			e.printStackTrace();
		}
		setCalendar(fecha);
	}

	private static void setCalendar(Date fecha) {
		Calendar calendario = Calendar.getInstance();

		calendario.setTime(fecha);

		System.out.println("AÃ±o: " + calendario.get(Calendar.YEAR) + "\n Mes: " + calendario.get(Calendar.MONTH)
				+ "\n DÃ­a: " + calendario.get(Calendar.DAY_OF_MONTH) + "\n Hora: "
				+ calendario.get(Calendar.HOUR_OF_DAY) + "\n Minutos: " + calendario.get(Calendar.MINUTE)
				+ "\n Segundos: " + calendario.get(Calendar.SECOND));

		calendario.add(Calendar.DAY_OF_MONTH, 3);
		System.out.println(calendario.getTime());
		calendario.setTime(fecha);
		calendario.add(Calendar.WEEK_OF_YEAR, -2);
		System.out.println(calendario.getTime());
		calendario.setTime(fecha);
		calendario.add(Calendar.DAY_OF_YEAR, 300);
		System.out.println(calendario.getTime());
		calendario.setTime(fecha);
		calendario.add(Calendar.YEAR, 4);
		System.out.println(calendario.getTime());

	}

	private static void ejemploSumaRestaFechas() {
		Calendar ahora = Calendar.getInstance();
		ahora.add(Calendar.DAY_OF_MONTH, 3);
		System.out.println("Ahora más 3 días : " + ahora.getTime());

		ahora = Calendar.getInstance();
		ahora.add(Calendar.DAY_OF_MONTH, 300);
		System.out.println("Ahora más 300 días : " + ahora.getTime());

		ahora = Calendar.getInstance();
		ahora.add(Calendar.DAY_OF_MONTH, -14);
		System.out.println("Ahora menos 2 semanas : " + ahora.getTime());
		
		ahora=Calendar.getInstance();
		ahora.add(Calendar.YEAR,4);
		System.out.println("Ahora más 4 años : " + ahora.getTime());
	}
}
