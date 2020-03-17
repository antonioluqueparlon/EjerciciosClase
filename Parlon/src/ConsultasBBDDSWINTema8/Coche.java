package ejerciciosTutorial.capitulo8.ConsultasBBDDSWIN;

public class Coche {
	private int id;
	private int idFabricante;
	private String bastidor;
	private String modelo;
	private String color;
	
	
	/**
	 * 
	 * @param id
	 * @param idFabricante
	 * @param bastidor
	 * @param modelo
	 * @param color
	 */
	public Coche(int id, int idFabricante, String bastidor, String modelo, String color) {
		super();
		this.id = id;
		this.idFabricante = idFabricante;
		this.bastidor = bastidor;
		this.modelo = modelo;
		this.color = color;
	}

/**
 * 
 */
	public Coche() {
		super();
	}


	public int getId() {
		return id;
	}



	public int getIdFabricante() {
		return idFabricante;
	}



	public String getBastidor() {
		return bastidor;
	}



	public String getModelo() {
		return modelo;
	}



	public String getColor() {
		return color;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
	}



	public void setBastidor(String bastidor) {
		this.bastidor = bastidor;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
}
