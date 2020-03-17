package BaseDeDatos.BaseDeDatosRafa;

import java.util.List;

import BaseDeDatos.BaseDeDatosRafa.modelo.Coche;
import BaseDeDatos.BaseDeDatosRafa.modelo.controladores.ControladorCoche;
import BaseDeDatos.BaseDeDatosRafa.modelo.controladores.ErrorBBDDException;




public class GestionCoches {

	/**
	 * 
	 */
	public static void menuGestion() {

		int opcionElegida = -1;
		do {
			try {
				System.out.println("\n\t\t\tGESTIÓN DE COCHES");
				
				System.out.println("\n\t1.- Listado de coches.");
				System.out.println("\t2.- Alta de coche.");
				System.out.println("\t3.- Modificación de coche.");
				System.out.println("\t4.- Baja de coche.");
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
		List<Coche> coches = ControladorCoche.getAll();
		System.out.println("\n\tListado de coches: \n");
		for (Coche co : coches) {
			System.out.println("\t" + co.toString());
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
		System.out.println("\n\tAlta de coche\n");
		
		Coche co = new Coche();
		System.out.print("\nIntroduzca el ID del coche: ");
		co.setId(Utils.getIntConsola(1));
		System.out.print("\nIntroduzca el ID del fabricante del coche: ");
		co.setIdFabricante(Utils.getIntConsola(1));
		System.out.print("\nIntroduzca el bastidor del coche: ");
		co.setBastidor(Utils.getStringConsola());
		System.out.print("\nIntroduzca el modelo del coche: ");
		co.setModelo(Utils.getStringConsola());
		System.out.print("\nIntroduzca el color del coche: ");
		co.setColor(Utils.getStringConsola());
		
		ControladorCoche.almacenar(co);  

		System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
		Utils.pausa();
	}



	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void modificacion () throws ErrorBBDDException {
		System.out.println("\n\tModificación de coche\n");
		
		Coche co = seleccionPorUsuario();
		
		if (co != null) {	
			
			System.out.print("\nIntroduzca el bastidor del coche ('Intro' para no modificar): ");
			String str = Utils.getStringConsola();
			if (!str.equals("")) 
				co.setBastidor(str);
			System.out.print("\nIntroduzca el modelo del coche  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				co.setModelo(str);
			System.out.println("\nIntroduzca el color del coche  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals(""))
				co.setColor(str);
		
			ControladorCoche.almacenar(co);  

			System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
			Utils.pausa();
		}
	}

	
	
	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void baja () throws ErrorBBDDException {
		System.out.println("\n\tModificación de coche\n");
		
		Coche co = seleccionPorUsuario();
		
		if (co != null) {		
			System.out.print("\n¿Realmente desea eliminar el registro? (S/N): ");
			String str = Utils.getStringConsola();
			if (str.equalsIgnoreCase("S")) { 		 
				ControladorCoche.eliminar(co);  
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
	private static Coche seleccionPorUsuario () throws ErrorBBDDException {
		Coche co = null;
		int id = -2;
		do {
			System.out.println("\n\tIntroduzca ID del coche ('-1' - ver listado, '0' - salir): ");
			id = Utils.getIntConsola(-1);
			if (id == -1) {
				listado(false);
			}
			else {
				if (id != 0) {
					co = ControladorCoche.get(id);
					if (co == null) {
						System.out.println("\tError. Ha especificado un ID inválido.");
					}
				}
			}
		} while (co == null && id != 0);
		return co;
	}
}
