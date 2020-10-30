function comprobarCadena(){

  var cadena= prompt("Introduce una cadena de texto");

  //COMPROBAR MAYUSCULA Y MINISCULA

  if(cadena == cadena.toUpperCase()) {
    alert("la "+cadena+"esta formada por mayusculas");
  }
  else if(cadena == cadena.toLowerCase()) {
    alert("la "+cadena+"esta formada por minusculas");
  }
  else {
    alert("la "+cadena+"esta formada por mayusculas y minusculas");
  }

}



 
   