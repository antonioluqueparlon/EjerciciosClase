package ejercicio6.bloque3.menuRestaurante;

public class Principal {

	public static void main(String[] args) {

		//Primeros platos
		Plato macarrones = new Plato ("Macarrones con tomate",5f);
		Plato tortilla = new Plato("Tortilla de patatas",3f);
		Plato solomillo = new Plato("Solomillo",10f);
		Plato pizza =new Plato ("Pizza",7.5f);
		Plato flamenquin = new Plato("Flamenquín",9f);
		Plato sanJacobo = new Plato("San Jacobo",11f);
		Plato habicholones = new Plato("Habicholones",4f);
		
		//Segundos Platos
		Plato solomilloRoquefort = new Plato("Solomillo Roquefort",7f);
		Plato bacalao = new Plato("Bacalao gratinado",10f);
		Plato lenguado= new Plato("Lenguado",12f);
		Plato pulpo = new Plato("Pulpo gallega",15f);
		Plato ensalada  = new Plato("Ensalada",5f);
		Plato calamares = new Plato("Calamares plancha rellenos de jamón",8f);
		
		//Postres
		Plato tartaAbuela = new Plato("Tarta de la abuela",4f);
		Plato natillas = new Plato("Natillas",4f);
		Plato tartaQueso = new Plato("Tarta de queso",4.5f);
		Plato tarta3Chocolates = new Plato("Flamenquín",9f);
		Plato fruta = new Plato("Fruta del tiempo",3f);
		
		//Construimos los menús
		Menu menus[]= new Menu[3];
		menus[0]=new Menu(flamenquin, ensalada, natillas);
		menus[1]=new Menu(sanJacobo, calamares, tartaAbuela);
		menus[2]=new Menu(flamenquin, bacalao, tarta3Chocolates);

		//Imprimo los menús con su precio
		for (int i = 0; i < menus.length; i++) {
			System.out.println(menus[i].toString());
			System.out.println("Precio: " +menus[i].getPrecio());
		}
		
		
	}

}
