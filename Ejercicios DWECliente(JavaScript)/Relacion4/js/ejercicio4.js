function compruebaCapicua(){
    var numero= prompt("introduce un numero y comprueba si es capicua");
    var numeroarray= numero.split("");
    var numerosAlReves=numero.split("").reverse();

    for(i in numero) { //hemos convertido los numeros en array
        if(numeroarray[i] == numerosAlReves[i]) {
          // Todo bien
          alert(" es capicua");
        }
        else {
          // Algun numero es distinta, ya no es un capicua
          alert(" no es capicua");
        }
      }


}
compruebaCapicua();