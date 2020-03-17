package BaseDeDatos.BaseDeDatosRafa;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import BaseDeDatos.BaseDeDatosRafa.modelo.Venta;
import BaseDeDatos.BaseDeDatosRafa.modelo.controladores.ControladorVenta;
import BaseDeDatos.BaseDeDatosRafa.modelo.controladores.ErrorBBDDException;




public class GestionVentas {

	/**
	 * 
	 */
	public static void menuGestion() {

		int opcionElegida = -1;
		do {
			try {
				System.out.println("\n\t\t\tGESTIÓN DE VENTAS");
				
				System.out.println("\n\t1.- Listado de ventas.");
				System.out.println("\t2.- Alta de ventas.");
				System.out.println("\t3.- Modificación de ventas.");
				System.out.println("\t4.- Baja de ventas.");
				System.out.println("\t0.- Salir");
				System.out.println("\n\tElija una opción: ");
				
				opcionElegida = Utils.getIntConsola(0, 4);
				
				switch (opcionElegida) {
				case 0:
					break;
				case 1:
					listado(true);
					break;
				case 2: 
					alta();
					break;
				case 3: 
					modificacion();
					break;
				case 4: 
					baja();
					break;
				}
			} catch (ErrorBBDDException e) {
				System.out.println("\n\t\t\tError de acceso a datos: " + e.getMessage() + "\n");
				e.printStackTrace();
			}
		} while (opcionElegida != 0);
	}

	
	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void listado(boolean pausafinal) throws ErrorBBDDException {
		List<Venta> ventas = ControladorVenta.getAll();
		System.out.println("\n\tListado de ventas: \n");
		for (Venta ve : ventas) {
			System.out.println("\t" + ve.toString());
		}
		if (pausafinal) {
			System.out.println("\n\tPulse 'Intro' tecla para continuar");
			Utils.pausa();
		}
	}
	
	
	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void alta () throws ErrorBBDDException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("\n\tAlta de venta\n");
		
		Venta ve = new Venta();
		System.out.print("\nIntroduzca 'idCliente' de la venta: ");
		ve.setIdCliente(Utils.getIntConsola(1));
		System.out.print("\nIntroduzca 'idConcesionario' de la venta: ");
		ve.setIdConcesionario(Utils.getIntConsola(1));
		System.out.print("\nIntroduzca 'idCoche' de la venta: ");
		ve.setIdCoche(Utils.getIntConsola(1));
		System.out.print("\nIntroduzca 'fecha' de la venta: ");
		try {
			ve.setFecha((Date) sdf.parse(Utils.getStringConsola()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("\nIntroduzca 'precioVenta' de la venta: ");
		ve.setPrecioVenta(Utils.getIntConsola(0));
		
		ControladorVenta.almacenar(ve);  

		System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
		Utils.pausa();
	}



	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void modificacion () throws ErrorBBDDException {
		System.out.println("\n\tModificación de venta\n");
		
		Venta ve = seleccionPorUsuario();
		
		if (ve != null) {		
			System.out.print("\nIntroduzca 'idCliente' de la venta ('Intro' para no modificar): ");
			int str = Utils.getIntConsola(1); 
				ve.setIdCliente(str);
			System.out.print("\nIntroduzca 'idConcesionario' de la venta  ('Intro' para no modificar): ");
			str = Utils.getIntConsola(1); 
			 ve.setIdConcesionario(str);
				
			System.out.print("\nIntroduzca 'idCoche' de la venta  ('Intro' para no modificar): ");
			str = Utils.getIntConsola(1); 
				ve.setIdCoche(str);
				
			//System.out.print("\nIntroduzca 'fecha' de la venta  ('Intro' para no modificar): ");
			//str = Utils.getIntConsola(1); 
				//ve.setFecha(str);
				
			System.out.print("\nIntroduzca 'precio' de la venta  ('Intro' para no modificar): ");
			str = Utils.getIntConsola(1); 
				ve.setPrecioVenta(str);
		
			ControladorVenta.almacenar(ve);  

			System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
			Utils.pausa();
		}
	}

	
	
	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void baja () throws ErrorBBDDException {
		System.out.println("\n\tModificación de venta\n");
		
		Venta ve = seleccionPorUsuario();
		
		if (ve != null) {		
			System.out.print("\n¿Realmente desea eliminar el registro? (S/N): ");
			String str = Utils.getStringConsola();
			if (str.equalsIgnoreCase("S")) { 		 
				ControladorVenta.eliminar(ve);  
				System.out.println("\n\tEliminado correctamente!. Pulse 'Intro' para continuar");
				Utils.pausa();
			}
		}
	}

	
	
	/**
	 * 
	 * @return
	 * @throws ErrorBBDDException
	 */
	private static Venta seleccionPorUsuario () throws ErrorBBDDException {
		Venta ve = null;
		int id = -2;
		do {
			System.out.println("\n\tIntroduzca ID del venta ('-1' - ver listado, '0' - salir): ");
			id = Utils.getIntConsola(-1);
			if (id == -1) {
				listado(false);
			}
			else {
				if (id != 0) {
					ve = ControladorVenta.get(id);
					if (ve == null) {
						System.out.println("\tError. Ha especificado un ID inválido.");
					}
				}
			}
		} while (ve == null && id != 0);
		return ve;
	}
}
