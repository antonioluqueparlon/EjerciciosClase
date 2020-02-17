package Tema6Recursos.ListenerEventos;

public class BuscaDigitosEvent {

	String string;

	/**
	 * @param string
	 */
	public BuscaDigitosEvent(String string) {
		super();
		this.string = string;
	}

	//getter y setter
	/**
	 * @return the string
	 */
	public String getString() {
		return string;
	}
	/**
	 * @param string the string to set
	 */
	public void setString(String string) {
		this.string = string;
	}

}
