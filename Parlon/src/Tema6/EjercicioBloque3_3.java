package Tema6;

import javax.swing.JOptionPane;

import Parlon.Persona;

public class EjercicioBloque3_3 {

	public static void main(String[] args) { //
		String str=JOptionPane.showInputDialog("Quiere crear una nueva persona?"
				+"\n 0---> No" + "\n 1---> Sí" );
		int comprobarPersona=Integer.parseInt(str);
		switch (comprobarPersona) {
			
		case 0:
			System.exit(0);
		case 1:
				
		Persona persona01 = new Persona();
		
		persona01.nombre = JOptionPane.showInputDialog(" Introduce tu nombre: ");
		persona01.dni = JOptionPane.showInputDialog(" Introduce tu DNI: ");
		persona01.direccion =JOptionPane.showInputDialog(" Introduce tu direccion: ");
		persona01.telefono=JOptionPane.showInputDialog(" Teléfono: ");
		
		persona01.imprimeEnConsola();
		
		Persona persona02=new Persona();
		
		persona02.nombre = JOptionPane.showInputDialog(" Introduce tu nombre: ");
		persona02.dni = JOptionPane.showInputDialog(" Introduce tu DNI: ");
		persona02.direccion =JOptionPane.showInputDialog(" Introde tu direccion: ");
		persona02.telefono=JOptionPane.showInputDialog(" Teléfono: ");
		
		persona02.imprimeEnConsola();
		
	
		}

	}
}
