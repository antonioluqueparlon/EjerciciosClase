package BaseDeDatos.BaseDeDatosRafa;

import java.util.List;

import BaseDeDatos.BaseDeDatosRafa.modelo.Concesionario;
import BaseDeDatos.BaseDeDatosRafa.modelo.Fabricante;
import BaseDeDatos.BaseDeDatosRafa.modelo.controladores.ControladorConcesionario;
import BaseDeDatos.BaseDeDatosRafa.modelo.controladores.ControladorFabricante;
import BaseDeDatos.BaseDeDatosRafa.modelo.controladores.ErrorBBDDException;




public class GestionConcesionario {

	/**
	 * 
	 */
	public static void menuGestion() {

		int opcionElegida = -1;
		do {
			try {
				System.out.println("\n\t\t\tGESTIÓN DE CONCESIONARIOS");
				
				System.out.println("\n\t1.- Listado de concesionarios.");
				System.out.println("\t2.- Alta de concesionario.");
				System.out.println("\t3.- Modificación de concesionario.");
				System.out.println("\t4.- Baja de concesionario.");
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
		List<Concesionario> concesionarios = ControladorConcesionario.getAll();
		System.out.println("\n\tListado de concesionario: \n");
		for (Concesionario con : concesionarios) {
			System.out.println("\t" + con.toString());
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
		System.out.println("\n\tAlta de concesionario\n");
		
		Concesionario con = new Concesionario();
		System.out.print("\nIntroduzca 'CIF' concesionario: ");
		con.setCif(Utils.getStringConsola());
		System.out.print("\nIntroduzca 'Nombre' del concesionario: ");
		con.setNombre(Utils.getStringConsola());
		System.out.println("\nIntroduzca la localidad del concesionario: ");
		con.setLocalidad(Utils.getStringConsola());
		
		ControladorConcesionario.almacenar(con);  

		System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
		Utils.pausa();
	}



	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void modificacion () throws ErrorBBDDException {
		System.out.println("\n\tModificación de concesionario\n");
		
		Concesionario con = seleccionPorUsuario();
		
		if (con != null) {		
			System.out.print("\nIntroduzca 'CIF' del concesionario ('Intro' para no modificar): ");
			String str = Utils.getStringConsola();
			if (!str.equals("")) 
				con.setCif(str);
			System.out.print("\nIntroduzca 'Nombre' del concesionario  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				con.setNombre(str);
			System.out.print("\nIntroduzca la localidad del concesionario  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				con.setLocalidad(str);
		
			ControladorConcesionario.almacenar(con);  

			System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
			Utils.pausa();
		}
	}

	
	
	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void baja () throws ErrorBBDDException {
		System.out.println("\n\tModificación de concesionario\n");
		
		Concesionario con = seleccionPorUsuario();
		
		if (con != null) {		
			System.out.print("\n¿Realmente desea eliminar el registro? (S/N): ");
			String str = Utils.getStringConsola();
			if (str.equalsIgnoreCase("S")) { 		 
				ControladorConcesionario.eliminar(con); 
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
	private static Concesionario seleccionPorUsuario () throws ErrorBBDDException {
		Concesionario con = null;
		int id = -2;
		do {
			System.out.println("\n\tIntroduzca ID del concesionario ('-1' - ver listado, '0' - salir): ");
			id = Utils.getIntConsola(-1);
			if (id == -1) {
				listado(false);
			}
			else {
				if (id != 0) {
					con = ControladorConcesionario.get(id);
					if (con == null) {
						System.out.println("\tError. Ha especificado un ID inválido.");
					}
				}
			}
		} while (con == null && id != 0);
		return con;
	}
}
