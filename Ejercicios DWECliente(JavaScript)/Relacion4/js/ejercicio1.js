/* function invertir2(cadena="ee"){
    if(!cadena){
        console.log("no va");
    }else
    var cadenainvertida2= cadena.split("").reverse().join();
    return cadena;

    alt shift a
}
invertir2(); */

function invertirPalabras(cadena) {
  var arrayCadena = cadena.split("");
  console.log(arrayCadena);
  var cadenaInvertida = arrayCadena.reverse();
  console.log(cadenaInvertida);
  var cadenaUnida = cadenaInvertida.join();
  console.log(cadenaUnida);

  return cadenaInvertida;
  return cadenaUnida;
}
invertirPalabras("orejones");
