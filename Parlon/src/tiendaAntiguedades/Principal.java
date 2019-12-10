package tiendaAntiguedades;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creo mis antiguedades
		
		Joyas joya1=new Joyas("2010","españa",1000,"oro");
		Libros libro1 = new Libros (" 2007"," Inglaterra", 10," J.K Rowling"," Harry Potter");
		
		//Muestro en pantalla mis antiguedades
		
		System.out.println(joya1);
		System.out.println(libro1);
		//libro1.imprimir();

	}

}
