package arbol;

public class Ramas extends ElementoArbol {
	
	private ElementoArbol el01;
	private ElementoArbol el02;
	private ElementoArbol el03;
	/**
	 * @param el01
	 * @param el02
	 * @param el03
	 */
	public Ramas(ElementoArbol el01, ElementoArbol el02, ElementoArbol el03) {
		super();
		this.el01 = el01;
		this.el02 = el02;
		this.el03 = el03;
	}
	
	
	@Override
	public String toString() {
		return "Ramas [el01=" + el01 + ", el02=" + el02 + ", el03=" + el03 + "]";
	}
	/**
	 * @return the el01
	 */
	public ElementoArbol getEl01() {
		return el01;
	}
	/**
	 * @param el01 the el01 to set
	 */
	public void setEl01(ElementoArbol el01) {
		this.el01 = el01;
	}
	/**
	 * @return the el02
	 */
	public ElementoArbol getEl02() {
		return el02;
	}
	/**
	 * @param el02 the el02 to set
	 */
	public void setEl02(ElementoArbol el02) {
		this.el02 = el02;
	}
	/**
	 * @return the el03
	 */
	public ElementoArbol getEl03() {
		return el03;
	}
	/**
	 * @param el03 the el03 to set
	 */
	public void setEl03(ElementoArbol el03) {
		this.el03 = el03;
	}

	
	
	
	
	

}
