function calcletra(){

var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];

var numero = prompt("Introduce tu número de DNI (sin la letra)");
var letra = prompt("Introduce la letra de tu DNI ");
var letraCalculada = letras[numero % 23];
letra = letra.toUpperCase(); // ponemos esto por si el usuario pone la letra en minuscula no nos de error el programa

if(numero < 0 || numero > 99999999) {
  alert("El número proporcionado no es válido");
}
else {
  
  if(letraCalculada != letra) {
    alert("La letra no es correcta");
  }
  else {
    alert("El número de DNI y su letra son correctos");
  }
}

}
