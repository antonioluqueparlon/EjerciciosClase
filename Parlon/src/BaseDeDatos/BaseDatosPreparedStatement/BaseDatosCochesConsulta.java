package BaseDeDatos.BaseDatosPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Scanner;
import java.sql.ResultSetMetaData;

import Parlon.Utils;

public class BaseDatosCochesConsulta {
	
	private static String tablas[] = new String[] {"venta", "concesionario", "cliente", "coche", "fabricante"};
	private static String tabla= new String("fabricante");
	private static String fabricantes[]= new String[] {"Opel", "Citroen", "Renault","Mercedes","Audi","Seat"};
	private static String colores[] = new String[] {"Blanco", "Negro", "Azul", "Rojo", "Verde", "Amarillo", "Gris"};
	private static String nombres[] = new String[] {"Eva", "Juan", "Carmen", "Pablo", "Rafa", "Pilar", "Pedro", 
			"Lola", "Casimiro", "Gertrudis", "Eustaquio", "Gerarda", "Nepomunosio", "Argimira", "Ascensio", "Baltasara", "Baudilio", "Bernabea"};
	private static String apellidos[] = new String[] {"Gonzalez", "Lopez", "Gutierrez", "Ruiz", "Jurado", "Carrasco", "Flores", 
			"Sanchez", "Bose", "Martin", "Martinez", "Santos", "Pozo", "Quijano", "Romero", "Pisano", "Cuevas", "Sanz"};
	private static String localidades[] = new String[] {"Lucena", "Cabra", "Priego de Cordoba", "Puente Genil", "Benameji", "Moriles","Córdoba","Aguilar de la Frontera"};
	private static SimpleDateFormat sdfFechaNacimiento = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static String tiposEmpresas[] = new String[] {"Hermanos", "Sociedad", "Concesionario", "Coches de"};
	private static String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	private static int CONT_NOTIFICACION_INSERCION = 10;
	private static int REGISTROS_A_INSERTAR_EN_CONCESIONARIO = 20;
	private static int REGISTROS_A_INSERTAR_EN_CLIENTE = 200;
	private static int REGISTROS_A_INSERTAR_EN_COCHE = 200;
	private static boolean LOG= true;
	
	private static Hashtable<String, PreparedStatement> psMaxIdsEnTabla;
	
	private static void vaciarTablas (Connection conn) throws SQLException {
		Statement s = (Statement) conn.createStatement();
		
		if (LOG)
			System.out.println("Eliminando los registros de todas las tablas");
		
		for (String tabla : tablas) {
			int registrosAfectados = s.executeUpdate("delete from tutorialjavacoches." + tabla);
			if (LOG)
				System.out.println("\t" + registrosAfectados + " registros eliminados en la tabla " + tabla);
		}
		s.close();
	}
	
	private static void insertarDatosFabricantes(Connection conn) throws SQLException,ImposibleConectarException {
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("inser into tutorialjavacoches.fabricante (id,cif,nombre) values (?, ?, ?)");
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla fabricante");
		
		for (int i = 0; i < fabricantes.length; i++) {
		
		ps.setInt(1, nextIdEnTabla(conn, "fabricante"));
		ps.setString(2, getDNICIFAzar());
		ps.setString(3, fabricantes[i]);
		
		registrosInsertados = ps.executeUpdate();
		if (registrosInsertados != 1) {
			throw new SQLException ("No ha sido posible la insercion en fabricante");
		}
		contRegistrosInsertados++;
		if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
			System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla fabricante");
		}
	}
	ps.close();
}
	
	private static void insertarDatosConcesionario (Connection conn) throws SQLException, ImposibleConectarException {
		PreparedStatement ps = (PreparedStatement) conn.
				prepareStatement("INSERT INTO tutorialjavacoches.concesionario (id, cif, nombre, localidad) VALUES  (?, ?, ?, ?)");
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla concesionario");

		for (int i = 0; i < REGISTROS_A_INSERTAR_EN_CONCESIONARIO; i++) {
			
			ps.setInt(1, nextIdEnTabla(conn, "concesionario"));
			ps.setString(2, getDNICIFAzar());
			ps.setString(3, getStringAlAzar(tiposEmpresas) + " " + getStringAlAzar(apellidos));
			ps.setString(4, getStringAlAzar(localidades));
			
			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserciï¿½n en concesionario");
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla concesionario");
			}
		}
		ps.close();
	}
	
	private static void insertarCoches (Connection conn) throws SQLException, ImposibleConectarException {
		PreparedStatement ps = (PreparedStatement) conn.
				prepareStatement("INSERT INTO tutorialjavacoches.coche (id, idFabricante, bastidor, modelo, color) VALUES  (?, ?, ?, ?, ?)");
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla coche");

		for (int i = 0; i < REGISTROS_A_INSERTAR_EN_COCHE; i++) {
			
			ps.setInt(1, nextIdEnTabla(conn, "coche"));
			ps.setInt(2, getIdAzarEnTabla(conn, "fabricante"));
			ps.setString(3, getBastidorAzar());
			ps.setString(4, getModeloCoche());
			ps.setString(5, getStringAlAzar(colores));

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserciï¿½n en coche");
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla coche");
			}
		}
		ps.close();
	}
	
	private static void ListaFabricantes(Connection conn) throws SQLException,ImposibleConectarException{
		
		Statement s = (Statement) conn.createStatement(); 		
		ResultSet rs = s.executeQuery ("select * from "+tabla);
		
		// A través del objeto ResultSetMetaData obtenemos información sobre las características de los campos que 
		// posee el conjunto de registros que hemos obtenido con la consulta. Gracias a eso podemos hacer una visualización
		// enriquecida del contenido del objeto ResultSet
		ResultSetMetaData rsmd= rs.getMetaData();			

		// Impresión en pantalla de los tipos de las columnas que forman el resultado del ResultSet
		System.out.println("\n-------------------------------------------------------------");
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnTypeName(i) + "\t");
		}
		System.out.println("\n-------------------------------------------------------------");

		// Impresión e pantalla de las etiquetas de nombre de las columnas del objeto ResultSet
		System.out.println("\n-------------------------------------------------------------");
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnLabel(i) + "\t");
		} 
		System.out.println("\n-------------------------------------------------------------");
		
		// Recorrido del ResultSet, diferenciando entre los tipos de datos que pueden tener las columnas
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				if (rsmd.getColumnTypeName(i).equalsIgnoreCase("INT")) {
					System.out.print(rs.getInt(rsmd.getColumnLabel(i)) + "\t");
				}
				if (rsmd.getColumnTypeName(i).equalsIgnoreCase("VARCHAR")) {
					System.out.print(rs.getString(rsmd.getColumnLabel(i)) + "\t");
				}
				if (rsmd.getColumnTypeName(i).equalsIgnoreCase("DATETIME")) {
					System.out.print(rs.getDate(rsmd.getColumnLabel(i)) + "\t");
				}
				if (rsmd.getColumnTypeName(i).equalsIgnoreCase("TINYINT")) {
					System.out.print(rs.getBoolean(rsmd.getColumnLabel(i)) + "\t");
				}
				if (rsmd.getColumnTypeName(i).equalsIgnoreCase("FLOAT")) {
					System.out.print(rs.getFloat(rsmd.getColumnLabel(i)) + "\t");
				}
				
			}
			System.out.println("\n");			
		}

		rs.close();
		s.close();
	}	
	
	private static void creacionDatosCliente (Connection conn) throws SQLException, ImposibleConectarException {
		PreparedStatement ps = (PreparedStatement) conn.
				prepareStatement("INSERT INTO tutorialjavacoches.cliente (id, nombre, apellidos, localidad, dniNie, fechaNac, activo) VALUES  (?, ?, ?, ?, ?, ?, ?)");
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla cliente");

		for (int i = 0; i < REGISTROS_A_INSERTAR_EN_CLIENTE; i++) {
			
			ps.setInt(1, nextIdEnTabla(conn, "cliente"));
			ps.setString(2, getStringAlAzar(nombres));
			ps.setString(3, getStringAlAzar(apellidos) + " " + getStringAlAzar(apellidos));
			ps.setString(4, getStringAlAzar(localidades));
			ps.setString(5, getDNICIFAzar());
			ps.setDate(6, (java.sql.Date) getFechaAzar(1960, 2000));
			ps.setBoolean(7, true);

			
			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la insercion en cliente");
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla cliente");
			}
		}
		ps.close();
	}
	
	private static String getStringAlAzar (String strings[]) {
		return strings[Utils.obtenerNumeroAzar(0, strings.length - 1)];
	}
	
	private static String getDNICIFAzar () {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < 8; i++) {
			sb.append(Utils.obtenerNumeroAzar(0, 9));
		}
		sb.append(abecedario.charAt(Utils.obtenerNumeroAzar(0, abecedario.length()-1)));
		
		return sb.toString();
	}
	
	private static int nextIdEnTabla (Connection conn, String tabla) throws SQLException {
		return maxIdEnTabla(conn, tabla) + 1;
	}
	
	private static int maxIdEnTabla (Connection conn, String tabla) throws SQLException {
		Statement s = (Statement) conn.createStatement();

		String sql = "select max(id) from tutorialjavacoches." + tabla;
		ResultSet rs = s.executeQuery(sql);
		int max = 1; 
		if (rs.next() ) {
			max = rs.getInt(1);
		}
		rs.close();
		s.close();
		return max;
	}
	
	private static String getBastidorAzar () {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < 17; i++) {
			sb.append(Utils.obtenerNumeroAzar(0, 9));
		}
		
		return sb.toString();
	}
	
	private static Date getFechaAzar (int anioMin, int anioMax) {
		Calendar calendar = new GregorianCalendar(Utils.obtenerNumeroAzar(anioMin, anioMax) /*aï¿½o*/, Utils.obtenerNumeroAzar(0, 11) /*mes*/, Utils.obtenerNumeroAzar(1, 31) /*dï¿½a*/, 
				Utils.obtenerNumeroAzar(0, 23) /*hora*/, Utils.obtenerNumeroAzar(0, 59) /*minuto*/, Utils.obtenerNumeroAzar(0, 59) /*segundo*/);
	
		return new Date(calendar.getTimeInMillis());
	}
	
	private static String getModeloCoche () {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < 2; i++) {
			sb.append(abecedario.charAt(Utils.obtenerNumeroAzar(0, abecedario.length()-1)));
		}
		for (int i = 0; i < 2; i++) {
			sb.append(Utils.obtenerNumeroAzar(0, 9));
		}
		
		return sb.toString();
	}

	private static int getIdAzarEnTabla (Connection conn, String tabla) throws SQLException {
		int maxIdFabricante = maxIdEnTabla(conn, tabla);
		int idFabricanteAzar;
		
		Statement s = (Statement) conn.createStatement();
		ResultSet rs;
		do {
			idFabricanteAzar = Utils.obtenerNumeroAzar(1, maxIdFabricante);
			rs = s.executeQuery("select * from tutorialjavacoches." + tabla + " where id = " + idFabricanteAzar);
		} while (!rs.next());
		
		rs.close();
		s.close();
		return idFabricanteAzar;
	}
	
	private static void inicializaPreparedStatementConsultas (Connection conn) throws SQLException {
		psMaxIdsEnTabla = new Hashtable<String, PreparedStatement>();
		psMaxIdsEnTabla.put("concesionario", conn.prepareStatement("select max(id) from tutorialjavacoches.concesionario"));
		psMaxIdsEnTabla.put("cliente", conn.prepareStatement("select max(id) from tutorialjavacoches.cliente"));
		psMaxIdsEnTabla.put("fabricante", conn.prepareStatement("select max(id) from tutorialjavacoches.fabricante"));
		psMaxIdsEnTabla.put("coche", conn.prepareStatement("select max(id) from tutorialjavacoches.coche"));
		psMaxIdsEnTabla.put("venta", conn.prepareStatement("select max(id) from tutorialjavacoches.venta"));
	}
	
	public static void main(String[] args) {
		String passwd, user,passwd2,user2;
        boolean continuarEnMenu=false;
        int opcion;
        Scanner teclado=new Scanner(System.in);
      

        user="java";
        passwd="1234";
		
		
		try {
			long startTime = new Date().getTime();

			Connection conn;
			conn = ConnectionManagerV2.getConexion();
			inicializaPreparedStatementConsultas(conn);
			
			do {
	            System.out.println("Introduce tu usuario y contraseña");
	            System.out.print("Usuario: ");
	            user2=teclado.nextLine();
	            System.out.print("Contraseña: ");
	            passwd2=teclado.nextLine();
	           
	            if (user.equals(user2) && passwd.equals(passwd2)){

	                System.out.println("\nBienvenido al programa");
	                continuarEnMenu=true;

	                do {

	                    System.out.println("-----------------------");
	                    System.out.println("Gestion de Venta de Coches:");
	                    System.out.println("-----------------------");
	                    System.out.println("1. Gestion de Fabricantes.");
	                    System.out.println("2. Gestion de Concesionario");
	                    System.out.println("-----------------------");
	                    System.out.println("0. Salir");

	                    opcion=teclado.nextInt();

	                    switch (opcion){

	                        case 1:
	                        	String tecladoOpcion1;
	                        	
	                        	System.out.println("-----------------------");
	                        	System.out.println();
	                            System.out.println("1.Lista de fabricantes");
	                            System.out.println("2.Insertar fabricante");
	                            System.out.println("3.Modificación de fabricante");
	                            System.out.println("4.Eliminar fabricante");
	                            System.out.println("0.Salir");
	                            teclado.nextLine();
	                            
	                            Scanner scnopcion1 = new Scanner(System.in);
	                            
	                            tecladoOpcion1=scnopcion1.nextLine();
	                            ListaFabricantes(conn);
	                            
	                            return;	

	                        case 2:
	                        	
	                        	System.out.println("-----------------------");
	                        	System.out.println();
	                        	creacionDatosCliente(conn);
	                        
	                            
	                            return;	

	                        default:

	                            opcion=0;
	                            break;

	                    }
	                }while (opcion!=0);

	            }else {

	                System.out.println("Usuario o contraseña incorrectos\n");

	            }
	        }while (continuarEnMenu==false);

	        // Cerrar Scanner
	        teclado.close();

			// Limpieza en las tablas
			//vaciarTablas(conn);
			// Datos de concesionarios
			//creacionDatosConcesionario(conn);
			// Datos de clientes
			//creacionDatosCliente(conn);
			// Datos de fabricantes
			//creacionDatosFabricantes(conn);
			// Datos de coches
			//creacionDatosCoches(conn);
			// Datos de venta
			//creacionDatosVentas(conn);

			long usedMillis = new Date().getTime() - startTime;
			int secs = (int) (usedMillis / 1000);
			System.out.println(
					"\nProceso terminado en " + secs + " segundos y " + (usedMillis - secs * 1000) + " milisegundos");

		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
