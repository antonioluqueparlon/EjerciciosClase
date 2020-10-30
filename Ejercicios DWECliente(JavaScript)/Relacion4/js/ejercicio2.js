var numRepeticiones = (cadena, texto) => {
  //pos sera la posicion a partir de la cual va a contar
  let pos = 0;
  let contador = 0;

  //mientras se encuentre la subcadena

  while (pos != -1) {
    pos = cadena.indexOf(texto, pos);
    if (pos !== -1) {
      contador++;
      pos++;
    }
  }

  console.log(`en el texto ${cadena} se repite la palabra ${texto} ${contador} veces`)

  //return contador;
}
//console.log(numRepeticiones("hola gilipollas lolipop", "l"));
