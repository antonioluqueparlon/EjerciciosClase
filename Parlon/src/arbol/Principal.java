package arbol;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creo mi hoja
		
		Hojas hoja01= new Hojas ("Hoja 01");
		Hojas hoja02= new Hojas ("Hoja 02");
		Frutos fruta01= new Frutos ("Fruta 01");
		
		
		//Creo mis frutas
		Frutos fruta02 = new Frutos("Fruta02");
		Hojas hoja03 = new Hojas ("Hoja 03");
		
		//Creo mis Ramas
		
		Ramas rama1  =new Ramas(hoja01,hoja02,fruta01);
		Ramas rama2 = new Ramas (hoja03,fruta02,fruta01);
		
		
		//Muestro en pantalla
		System.out.println(rama1.toString());
		System.out.println(rama2.toString());

	}

}
