function comprobarPalindromo(){

    var cadena=prompt("introduce tu palindromo");
 
    // paso a minusculas la cadena para hacerlo todo mas facil y pasarlo a un array luego
    var cadenaOriginal = cadena.toLowerCase();
  
    // convierto la cadena en un array
    var CadenaEnArray = cadenaOriginal.split(""); //me lo convierte sin espacios
  
    // Eliminar los espacios en blanco (este paso es demasiado largo ya que no se utiliza la funcion "replace")
    var cadenaSinEspacios = "";
    for(i in CadenaEnArray) {
      if(CadenaEnArray[i] != " ") {
        cadenaSinEspacios += CadenaEnArray[i]; // esto lo que hace es que cuando recorre la cadena del array, si ya no tiene espacios
                                              // lo pasa directamente a la cadena ya sin espacios "sumando"
      }
    }
  
    var letras = cadenaSinEspacios.split(""); // lo convierto en array
    var letrasReves = cadenaSinEspacios.split("").reverse(); //lo convierto en array y le doy la vuelta
  
    // compruebo si las letras se leen igual de al reves o no para dar una solucion

    for(i in letras) { //hemos convertido letras en array
      if(letras[i] == letrasReves[i]) {
        // Todo bien
        alert(" es un palíndromo");
      }
      else {
        // Alguna letra es distinta, ya no es un palindromo
        alert(" no es un palíndromo");
      }
    }

  }