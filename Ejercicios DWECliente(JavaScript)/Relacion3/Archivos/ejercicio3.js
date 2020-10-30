/* var circulo= {
  //variables del objeto
  radio:prompt("introduce el radio"),

  calculoArea () {
    document.write("El área del circulo de radio "+this.radio+" es "+Math.PI*this.radio*this.radio+"<br>");
    },

calculoLongitud () {
  document.write("La longitud del circulo de radio "+this.radio+" es "+2*Math.PI*this.radio+"<br>");
},



}
  

circulo.calculoArea();
circulo.calculoLongitud(); */

class circulo{
  constructor(radio){
    this.radio=radio;
  }

  calculoArea() {
    document.write("El área del circulo de radio "+this.radio+" es "+Math.PI*this.radio*this.radio+"<br>");
    }
    //método para calcular longitud de la circunferencia
    calculoLongitud(){
    document.write("La longitud del circulo de radio "+this.radio+" es "+ 2*Math.PI*this.radio+"<br>");
    }
    
}

const circuloCreado= new circulo(prompt("introduce el radio del circulo par calcular su area y su longitud"));
circuloCreado.calculoArea();
circuloCreado.calculoLongitud();
