package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_GestionEntidadCoche.modelo.entidades;

import java.util.Date;

public class Cliente {

	private int id;
	private String nombre;
	private String apellidos;
	private String localidad;
	private String dniNie;
	private Date fechaNac;
	
	
	public Cliente() {
		super();
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public String getLocalidad() {
		return localidad;
	}


	public String getDniNie() {
		return dniNie;
	}


	public Date getFechaNac() {
		return fechaNac;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public void setDniNie(String dniNie) {
		this.dniNie = dniNie;
	}


	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
	
	
}
